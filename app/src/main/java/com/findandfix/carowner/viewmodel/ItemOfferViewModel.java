package com.findandfix.carowner.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;

import com.findandfix.carowner.model.global.AdvData;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.ui.activities.OffersDetailActivity;

public class ItemOfferViewModel extends BaseObservable {
    private Context context;
    private AdvData advData;
    public ItemOfferViewModel(Context context, AdvData advData) {
        this.context=context;
        this.advData=advData;
    }

    public void setAdv(AdvData adv){
        this.advData=adv;
        notifyChange();
    }

    public String getAdvTitle(){return advData.getTitle();};
    public String getAdvContent(){return  advData.getDescription();};

    public String getImage(){return  advData.getImage();};

    public void onItemClick(View view){
        Intent intent=new Intent(view.getContext(),OffersDetailActivity.class);
        intent.putExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADV_OBJ,advData);
        context.startActivity(intent);
    }
}
