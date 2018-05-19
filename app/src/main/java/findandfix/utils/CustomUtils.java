package findandfix.utils;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.util.Base64;
import android.widget.TimePicker;

import com.example.dp.findandfix.R;
import findandfix.model.global.BaseModel;
import findandfix.model.global.BrandItem;
import findandfix.model.global.UserData;
import findandfix.Application.MyApplication;
import findandfix.view.ui.callback.UpdateTimeListener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DELL on 28/03/2018.
 */

public class CustomUtils {

    private static  CustomUtils customUtils=null;
    private static String selectedTime;
    private CustomUtils(){}
    public static CustomUtils getInstance(){
        if(customUtils==null)
            customUtils=new CustomUtils();

        return customUtils;
    }


    public  void showTimePickerDialog(Context context, final UpdateTimeListener listener, final int code){

        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                selectedTime=(selectedHour < 10 ? "0" + selectedHour : selectedHour) + ":" + (selectedMinute < 10 ? "0" + selectedMinute : selectedMinute);
                listener.updateTime(selectedTime,code);
            }

        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle(context.getString(R.string.label_car));
        mTimePicker.show();

    }

    public  String encodeImage(Bitmap bm)
    {
        int nh = (int) (bm.getHeight() * (512.0 / bm.getWidth()));
        bm = Bitmap.createScaledBitmap(bm, 512, nh, true);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG,100,baos);
        byte[] b = baos.toByteArray();
        String encImage = Base64.encodeToString(b, Base64.DEFAULT);
        return encImage;
    }

    public  Bitmap modifyOrientation(Bitmap bitmap, String image_absolute_path) throws IOException {
        ExifInterface ei = new ExifInterface(image_absolute_path);
        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                return rotate(bitmap, 90);

            case ExifInterface.ORIENTATION_ROTATE_180:
                return rotate(bitmap, 180);

            case ExifInterface.ORIENTATION_ROTATE_270:
                return rotate(bitmap, 270);

            case ExifInterface.ORIENTATION_FLIP_HORIZONTAL:
                return flip(bitmap, true, false);

            case ExifInterface.ORIENTATION_FLIP_VERTICAL:
                return flip(bitmap, false, true);

            default:
                return bitmap;
        }
    }

    public  Bitmap rotate(Bitmap bitmap, float degrees) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degrees);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public  Bitmap flip(Bitmap bitmap, boolean horizontal, boolean vertical) {
        Matrix matrix = new Matrix();
        matrix.preScale(horizontal ? -1 : 1, vertical ? -1 : 1);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public  String uriToFilename(Uri uri, Context context) {

        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        String picturePath="";
        if (uri != null) {
            Cursor cursor = context.getContentResolver().query(uri, filePathColumn, null, null, null);
            assert cursor != null;
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
        }
        return picturePath;
    }



    public  boolean checkIfAlreadyhavePermission(Context context,String permission) {
        if (ActivityCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    public  void requestForSpecificPermission(Context context,String[]permissions,int requestCode) {
        ActivityCompat.requestPermissions((Activity)context, permissions, requestCode);
    }

    public UserData getSaveUserObject(Context context){
        SharedPreferenceUtils prefrenceUtils=new SharedPreferenceUtils(context);
        UserData userData=(UserData) prefrenceUtils.getSavedObject(ConfigurationFile.SharedPrefConstants.PREF_WORKSHOP_DATA, UserData.class);
        return userData;
    }

    public Boolean isValidMobileNumber(String s){
        Pattern p = Pattern.compile("(0/1)?[0-9]{9}");

        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression
        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }

    public void logout(Activity activity){
        /*Intent i=new Intent(activity, LoginActivity.class);
        activity.finishAffinity();
        clearSharedPref((Context)activity);
        activity.startActivity(i);
        */
    }

    public void clearSharedPref(Context context){
        SharedPreferenceUtils prefrenceUtils=new SharedPreferenceUtils(context);
        prefrenceUtils.clearToken();
    }

    public String setSpecializationText(){
        String specializationText="";

        List<BaseModel> baseModels=((MyApplication)MyApplication.getAppContext()).getBasicspecializations();
        for(BaseModel model:baseModels)
            specializationText=specializationText+model.getName()+" - ";
        return specializationText;
    }


    public String setBrandsText(){
        String brandsText="";

        List<BrandItem> baseModels=((MyApplication)MyApplication.getAppContext()).getBasicBrands();
        for(BrandItem brandItem:baseModels)
            brandsText=brandsText+brandItem.getName()+" - ";
        return brandsText;
    }

    public String setUrgentText(){
        String urgentText="";
        List<BaseModel> baseModels=((MyApplication)MyApplication.getAppContext()).getBasicUrgentTypes();
        for(BaseModel model:baseModels)
            urgentText=urgentText+model.getName()+" - ";
        return urgentText;
    }


    public List<Integer> getSpecializationIds(){

        List<Integer>ids=new ArrayList();
        List<BaseModel> baseModels=((MyApplication) MyApplication.getAppContext()).getBasicspecializations();
        for(BaseModel model:baseModels)
            ids.add(model.getId());

        return ids;
    }


    public List<Integer> getBrandsIds(){

        List<Integer>ids=new ArrayList();
        List<BrandItem> baseModels=((MyApplication)MyApplication.getAppContext()).getBasicBrands();
        for(BrandItem brandItem:baseModels)
            ids.add(brandItem.getId());
        return ids;
    }

    public List<Integer> getUrgentIds(){

        List<Integer>ids=new ArrayList();
        List<BaseModel> baseModels=((MyApplication)MyApplication.getAppContext()).getBasicUrgentTypes();
        for(BaseModel model:baseModels)
            ids.add(model.getId());
        return ids;
    }

    public void endSession(Activity activity){
            /*SharedPreferenceUtils utils=new SharedPreferenceUtils(activity);
            utils.clearToken();
            Intent i=new Intent(activity,LoginActivity.class);
            activity.startActivity(i);
            activity.finish();
            */
    }


    public boolean checktimings(String time, String endtime) {

        String pattern = "HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        try {
            Date date1 = sdf.parse(time);
            Date date2 = sdf.parse(endtime);

            if(date1.before(date2)) {
                return true;
            } else {

                return false;
            }
        } catch (ParseException e){
            e.printStackTrace();
        }
        return false;
    }
}
