package com.findandfix.carowner.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;



import com.findandfix.carowner.model.global.RequestData;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.ui.activities.NormalRequestDetailActivity;

/**
 * Created by DELL on 27/03/2018.
 */

public class ItemRequestViewModel extends BaseObservable {
    private RequestData requestData;
    private Context context;
    public ItemRequestViewModel(Context context, RequestData requestData) {
        this.requestData=requestData;
        this.context=context;
    }

    public void setRequestData(RequestData requestData) {
        this.requestData = requestData;
        notifyChange();
    }

    public String getRequestTitle(){
        String specialize="";
        for (int i=0;i<requestData.getSpecializations().size();i++){
            specialize=specialize+" "+requestData.getSpecializations().get(i).getName();
        }
        return specialize;
    }

    public int getPrecentage(){
        return (int)requestData.getPercentage();
    }

    public String precentageText(){
        return requestData.getPercentage()+"%";
    }

    public String getCarType(){
        return requestData.getBrand()+"-"+requestData.getModel();
    }

    public String getAddress(){
        return requestData.getAddress();
    }

    public String getDate(){
        return requestData.getDate();
    }

    public String getImage(){

            if (requestData.getImage().size() != 0)
                return requestData.getImage().get(0).getPath();
            else return "";

   }

    public void moveToInProgressDetailPage(View view){

        Intent i=new Intent(view.getContext(), NormalRequestDetailActivity.class);
        i.putExtra(ConfigurationFile.SharedPrefConstants.PREF_REQUEST_OBJECT,requestData);
        context.startActivity(i);



    }


    public void moveToPublishedDetailPage(View view){

      /*  Intent i=new Intent(view.getContext(), RequestDetailActivity.class);
        i.putExtra(ConfigurationFile.Constants.REQUEST_TYPE,ConfigurationFile.Constants.PUBLISH_REQUEST_DETAIL);
        i.putExtra(ConfigurationFile.SharedPrefConstants.PREF_REQUEST_OBJECT,requestData);
        context.startActivity(i);
        ((Activity)context).finish();*/

    }


    public void moveToOfferedDetailPage(View view){

        /*Intent i=new Intent(view.getContext(), RequestDetailActivity.class);
        i.putExtra(ConfigurationFile.Constants.REQUEST_TYPE,ConfigurationFile.Constants.OFFERED_REQUEST_DETAIL);
        i.putExtra(ConfigurationFile.SharedPrefConstants.PREF_REQUEST_OBJECT,requestData);
        context.startActivity(i);
        ((Activity)context).finish();*/
    }
}
