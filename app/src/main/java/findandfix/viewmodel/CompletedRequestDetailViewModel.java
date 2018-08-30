package findandfix.viewmodel;

/**
 * Created by DELL on 04/08/2018.
 */

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;


import findandfix.R;
import findandfix.model.global.BaseModel;
import findandfix.model.global.Media;
import findandfix.model.global.RequestData;
import findandfix.model.global.UserData;
import findandfix.network.ApiClient;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.view.ui.callback.BaseInterface;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.RemoteBanner;

/**
 * Created by DELL on 28/03/2018.
 */

public class CompletedRequestDetailViewModel extends BaseObservable{
    public ObservableList<Banner> remoteBanners;
    private RequestData requestData;
    private Context context;
    private BaseInterface callback;
    public ObservableInt requestDetailType;
    private UserData userData;
    private Dialog dialog=null;
    private int offerId;
    public ObservableInt progressVisibility;

    public CompletedRequestDetailViewModel(Context context, RequestData requestData,int requestType, BaseInterface callback) {
        remoteBanners=new ObservableArrayList<>();
        this.context=context;
        this.requestData=requestData;
        this.callback=callback;
        requestDetailType=new ObservableInt();
        progressVisibility=new ObservableInt(View.GONE);
        requestDetailType.set(requestType);
        userData= CustomUtils.getInstance().getSaveUserObject(context);
        setUpBanners();
    }

    public void setUpBanners(){
        for (Media media:requestData.getImage()) {
            remoteBanners.add(new RemoteBanner(media.getPath()));

        }

        if (requestData.getVideos()!=null && requestData.getVideos().size()!=0){
            if (!requestData.getVideos().get(0).equals(""))
                remoteBanners.add(new RemoteBanner(null).setPlaceHolder(context.getResources().getDrawable(R.drawable.ic_video_symbol)));
        }



    }


    public String getSpecialization(){
        String specializationtext="";
        for (BaseModel model:requestData.getSpecializations())
            specializationtext=specializationtext+model.getName()+" ";
        return specializationtext;
    }

    public String CarInfo(){
        return requestData.getBrand()+"-"+requestData.getModel()+"-"+requestData.getYear();
    }

    public String getDesc(){
        return  requestData.getNotes();
    }

    public String getAddress(){
        return requestData.getAddress();
    }

    public String getDate(){return  requestData.getDate();
    }

    public void navigate(View view){

        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr=" + requestData.getLatitude() + "," + requestData.getLongitude()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public String needWinch(){
        String winch;
        if(requestData.getWinch()==1)
            winch=context.getString(R.string.need_winch);
        else
            winch=context.getString(R.string.dont_need_winch);
        return winch;
    }

    public void displayDialog(View view){
        callback.updateUi(ConfigurationFile.Constants.SHOW_DIALOG_CODE);
    }
}

