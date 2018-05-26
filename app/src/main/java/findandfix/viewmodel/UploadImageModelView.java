package findandfix.viewmodel;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;
import com.example.dp.findandfix.BR;
import com.example.dp.findandfix.R;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import findandfix.model.request.RegisterRequest;
import findandfix.model.response.RegisterResponse;
import findandfix.network.ApiClient;
import findandfix.network.EndPoints;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.utils.NetWorkConnection;
import findandfix.utils.ValidationUtils;
import findandfix.view.ui.callback.BaseInterface;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import static android.app.Activity.RESULT_OK;


public class UploadImageModelView extends BaseObservable {

    public ObservableField<String> email;
    public ObservableField<String> password;
    public ObservableField<String> phone;
    public ObservableInt progressDialog;
    private CompositeDisposable compositeDisposable;
    private Context context;
    private BaseInterface callback;
    private Bitmap picBitmap;
    private Bitmap selectedImageBitmap;
    StorageReference storageReference;
    Uri selectedImageUri = null;
    String encodedImage = "";


    public UploadImageModelView(Context context, BaseInterface callback) {
        this.context = context;
        this.callback = callback;
        initializeVariables();
        setPicBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.img_upload));
        storageReference = FirebaseStorage.getInstance().getReference().child("app_photos");
    }

    public void selectImage(View view) {
        if (checkIfAlreadyHavePermission()) {
            showPictureDialog();
        } else {
            Toast.makeText(context, "not", Toast.LENGTH_SHORT).show();
            CustomUtils.getInstance().requestForSpecificPermission(context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, ConfigurationFile.PermissionsClass.REQUEST_CODE_WRITE_EXTERNAL_STORAGE);
        }
    }

    private void showPictureDialog() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(context);
        pictureDialog.setTitle(context.getResources().getString(R.string.label_select_action));
        String[] pictureDialogItems = {
                context.getResources().getString(R.string.label_select_gallery),
                context.getResources().getString(R.string.label_select_camera)};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallery();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            convertImageToBase64(data.getData());
            selectedImageUri = data.getData();
        }

    }

    public void convertImageToBase64(Uri ImageUri) {
        try {
            final InputStream imageStream = context.getContentResolver().openInputStream(ImageUri);
            selectedImageBitmap = BitmapFactory.decodeStream(imageStream);
            String RealPicturePath = CustomUtils.getInstance().uriToFilename(ImageUri, context);
            selectedImageBitmap = CustomUtils.getInstance().modifyOrientation(selectedImageBitmap, RealPicturePath);
            setPicBitmap(selectedImageBitmap);
            encodedImage = CustomUtils.getInstance().encodeImage(selectedImageBitmap);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static int GALLERY = 1303, CAMERA = 1304;

    public void choosePhotoFromGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        ((Activity) context).startActivityForResult(galleryIntent, GALLERY);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        ((Activity) context).startActivityForResult(intent, CAMERA);
    }


    public void initializeVariables() {
        email = new ObservableField<>();
        password = new ObservableField<>();
        phone = new ObservableField<>();
        progressDialog = new ObservableInt(View.GONE);
        compositeDisposable = new CompositeDisposable();
    }

    public void reset() {
        unSubScribe();
        compositeDisposable = null;
        context = null;
    }

    public void unSubScribe() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed())
            compositeDisposable.dispose();
    }

    public void setPicBitmap(Bitmap picBitmap) {
        this.picBitmap = picBitmap;
        notifyPropertyChanged(BR.picBitmap);
    }


    @Bindable
    public Bitmap getPicBitmap() {
        return picBitmap;
    }


    private boolean checkIfAlreadyHavePermission() {
        int granted = PackageManager.PERMISSION_GRANTED;
        return (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == granted) && (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) == granted);
    }


    public void register(final View view){

        if(ValidationUtils.isEmpty(email.get()) || ValidationUtils.isEmpty(password.get())){
            callback.updateUi(ConfigurationFile.Constants.FILL_ALL_DATTA);
        }else {
            if(NetWorkConnection.isConnectingToInternet(context)) {
                if (!ValidationUtils.isMail(email.get()) && ValidationUtils.isPhone(email.get())) {
                    phone.set(email.get());
                    email.set(null);
                }

                progressDialog.set(View.VISIBLE);
                final RegisterRequest registerRequest = new RegisterRequest();

                Disposable disposable = ApiClient.getClient().create(EndPoints.class).register(ConfigurationFile.Constants.API_KEY, "EN", ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type, registerRequest)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Response<RegisterResponse>>() {
                            @Override
                            public void accept(Response<RegisterResponse> registerResponseResponse) throws Exception {
                                progressDialog.set(View.GONE);
                                if (registerResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_CODE) {

                                }
                            }

                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                progressDialog.set(View.GONE);
                            }
                        });

                compositeDisposable.add(disposable);
            }else {
                callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
            }
        }
    }


}
