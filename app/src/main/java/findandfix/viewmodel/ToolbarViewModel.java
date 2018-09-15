package findandfix.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


import findandfix.R;

import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.view.ui.activities.MainActivity;
import findandfix.view.ui.activities.MyConversationsActivity;

/**
 * Created by DELL on 14/05/2018.
 */

public class ToolbarViewModel extends BaseObservable {

    public ObservableInt imageVisibility;
    public ObservableInt convVisibility;
    public ObservableInt backimageVisibility;
    public ObservableField<String> toolbarTitle;
    public ObservableInt toolbarColor;
    public ObservableInt rotation;
    private Context context;
    public ToolbarViewModel(Context context, int checker) {
        this.context=context;
        imageVisibility=new ObservableInt();
        convVisibility=new ObservableInt();
        backimageVisibility=new ObservableInt(View.GONE);
        toolbarTitle=new ObservableField<>();
        toolbarColor=new ObservableInt();
        rotation=new ObservableInt();

        if (CustomUtils.getInstance().getAppLanguage(context).equals("ar"))
            rotation.set(180);
        if (checker== ConfigurationFile.Constants.HANDLE_MAIN_TOOLBAR)
            handleMainToolBar();

        else if (checker== ConfigurationFile.Constants.HANDLE_FILTER_TOOLBAR)
            handleFilterToolBar();

        else if (checker== ConfigurationFile.Constants.HANDLE_WORKSHOP_OFFERS_TOOLBAR)
            handleWorkShopOffersToolbar();

       else if (checker== ConfigurationFile.Constants.HANDLE_WORKSHOP_URGENT_REQUEST_OFFERS)
            handleUrgentOffers(context.getString(R.string.urgent_offers));

        else if (checker== ConfigurationFile.Constants.HANDLE_WORKSHOP_URGENT_REQUEST_DETAIL_TOOLBAR)
            handleUrgentOffers(context.getString(R.string.request_detail_label));

       else if (checker== ConfigurationFile.Constants.HANDLE_WORKSHOP_URGENT_REQUEST_TOOLBAR)
            handleUrgentRequestToolbar();

        else if (checker== ConfigurationFile.Constants.HANDLE_FIND_REQUESTS_TOOLBAR)
            handleFindRequestsToolBarToolbar(context.getString(R.string.find_request));

        else if (checker== ConfigurationFile.Constants.HANDLE_REQUEST_DETAIL_TOOLBAR)
            handleFindRequestsToolBarToolbar(context.getString(R.string.request_detail_label));

        else if (checker== ConfigurationFile.Constants.HANDLE_WORKSHOP_ACHIEVMENTS_TOOLBAR)
            handleWorkShopAchievmentToolbar();

        else if (checker== ConfigurationFile.Constants.HANDLE_NORMAL_REQUEST_TOOLBAR)
            handleNormalRequestToolbar();

        else if (checker== ConfigurationFile.Constants.HANDLE_URGENT_REQUEST_TOOLBAR)
            handleUrgentRequestToolbar();

        else if (checker== ConfigurationFile.Constants.HANDLE_WORKSHOP_URGENT_REQUEST_SECONDARY_TOOLBAR)
            handleUrgentRequestSecondaryToolbar();

        else if (checker== ConfigurationFile.Constants.HANDLE_EDIT_PROFILE_TOOLBAR)
            handleEditProfileToolbar();

        else if (checker== ConfigurationFile.Constants.HANDLE_CONVERSATION_HISTORY_TOOLBAR)
            handleConversationHistory();

        else if (checker== ConfigurationFile.Constants.HANDLE_NORMAL_REQUEST_SECONDARY_TOOLBAR)
            handleSecondaryNormalRequestToolbar(context.getString(R.string.add_request));



        else if (checker== ConfigurationFile.Constants.HANDLE_ADD_ADVERTISING_TOOLBAR)
            handleAddAdvertise();

        else if (checker== ConfigurationFile.Constants.HANDLE_ADVERTISING_DETAIL_TOOLBAR)
            handleAddAdvertiseDetail();

        else if (checker== ConfigurationFile.Constants.HANDLE_CHANGE_PASSWORD_TOOLBAR)
            handleChangePasswordToolbar();

        else if (checker== ConfigurationFile.Constants.HANDLE_CUSTOM_ADD_ADVERTISING_TOOLBAR)
            handleAddAdvertisingToolbar();
        else if (checker== ConfigurationFile.Constants.HANDLE_NORMAL_REQUEST_DETAIL_TOOLBAR)
            handleNormalRequestDetailToolbar();
        else if (checker== ConfigurationFile.Constants.HANDLE_NORMAL_REQUEST_DETAIL_TOOLBAR)
            handleNormalRequestDetailToolbar();

        else if (checker== ConfigurationFile.Constants.HANDLE_ACTIVATION_CODE_TOOLBAR)
            handleSecondaryNormalRequestToolbar(context.getString(R.string.active_account));
    }
    
    public void handleRequestDetailToolBarToolbar(){
        
    }

    public void handleMainToolBar(){
        imageVisibility.set(View.GONE);

        handleToolbarBackground(context.getString(R.string.find_fix),R.color.colorPrimary);
        handleStatusBar(R.color.colorPrimary);
    }

    public void handleFilterToolBar(){
        imageVisibility.set(View.GONE);
        backimageVisibility.set(View.VISIBLE);
        handleToolbarBackground(context.getString(R.string.filter),R.color.colorPrimary);
        handleStatusBar(R.color.colorPrimary);
    }

    public void handleNormalRequestToolbar(){
        handleToolbarBackground(context.getString(R.string.add_request),R.color.colorPrimary);
        handleStatusBar(R.color.colorPrimary);
    }

    public void handleSecondaryNormalRequestToolbar(String param){
        backimageVisibility.set(View.VISIBLE);
        imageVisibility.set(View.GONE);
        handleToolbarBackground(param,R.color.colorPrimary);
        handleStatusBar(R.color.colorPrimary);
    }

    public void handleWorkShopOffersToolbar(){
        imageVisibility.set(View.GONE);
        backimageVisibility.set(View.VISIBLE);
        handleToolbarBackground(context.getString(R.string.add_request),R.color.colorPrimary);
        handleStatusBar(R.color.colorPrimary);
    }

    public void handleWorkShopAchievmentToolbar(){
        imageVisibility.set(View.GONE);
        backimageVisibility.set(View.VISIBLE);
        handleToolbarBackground(context.getString(R.string.workshop_achievment),R.color.colorPrimary);
        handleStatusBar(R.color.colorPrimary);
    }

    public void handleFindRequestsToolBarToolbar(String toolBarTitle){
        handleToolbarBackground(toolBarTitle,R.color.colorPrimary);
        handleStatusBar(R.color.colorPrimary);
    }



    public void handleEditProfileToolbar(){
        handleToolbarBackground(context.getString(R.string.edit_profile),R.color.colorOrange);
        handleStatusBar(R.color.colorOrange);
    }

    public void handleConversationHistory(){
        imageVisibility.set(View.GONE);
        backimageVisibility.set(View.VISIBLE);
        convVisibility.set(View.GONE);
        handleToolbarBackground(context.getString(R.string.chat),R.color.colorBlue);
        handleStatusBar(R.color.colorBlue);}

        public void handleConversationDetailToolbar(String name){
            imageVisibility.set(View.GONE);
            backimageVisibility.set(View.VISIBLE);
            handleToolbarBackground(name,R.color.colorPrimary);
            handleStatusBar(R.color.colorPrimary);
        }

    public void handleAddAdvertise(){
        handleToolbarBackground(context.getString(R.string.label_offers),R.color.advertisment_toolbar_color);
        handleStatusBar(R.color.advertisment_toolbar_color);
    }

    public void handleAddAdvertiseDetail(){
        imageVisibility.set(View.GONE);
        backimageVisibility.set(View.VISIBLE);
        handleToolbarBackground(context.getString(R.string.offer_detail),R.color.advertisment_toolbar_color);
        handleStatusBar(R.color.advertisment_toolbar_color);
    }

    public void handleChangePasswordToolbar(){
        imageVisibility.set(View.GONE);
        backimageVisibility.set(View.VISIBLE);
        handleToolbarBackground(context.getString(R.string.change_password),R.color.colorOrange);
        handleStatusBar(R.color.colorOrange);
    }

    public void handleAddAdvertisingToolbar(){
      imageVisibility.set(View.GONE);
        backimageVisibility.set(View.VISIBLE);
        handleToolbarBackground(context.getString(R.string.label_offers),R.color.advertisment_toolbar_color);
        handleStatusBar(R.color.advertisment_toolbar_color);
    }

    public void handleUrgentRequestToolbar(){
        imageVisibility.set(View.VISIBLE);
        backimageVisibility.set(View.GONE);
        handleToolbarBackground(context.getString(R.string.urgent_request_label),R.color.colorRed);
        handleStatusBar(R.color.colorRed);
    }

    public void handleUrgentOffers(String title){
        imageVisibility.set(View.VISIBLE);
        backimageVisibility.set(View.GONE);
        handleToolbarBackground(title,R.color.colorRed);
        handleStatusBar(R.color.colorRed);
    }

    public void handleUrgentRequestSecondaryToolbar(){
        imageVisibility.set(View.GONE);
        backimageVisibility.set(View.VISIBLE);
        handleToolbarBackground(context.getString(R.string.urgent_request_label),R.color.colorRed);
        handleStatusBar(R.color.colorRed);
    }

    public void  handleNormalRequestDetailToolbar(){
       imageVisibility.set(View.GONE);
        backimageVisibility.set(View.VISIBLE);
        handleToolbarBackground(context.getString(R.string.request_detail),R.color.colorLightBlue);
        handleStatusBar(R.color.colorLightBlue);
    }

    public void handleStatusBar(int color){
        if(Build.VERSION.SDK_INT>=21){
            Window window=((Activity)context).getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(context.getResources().getColor(color));
        }}
    public void openChatAct(View view){
       Intent i=new Intent(context,MyConversationsActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);}

    public void FinishAct(View view){
        ((Activity)context).finish();
    }
    public void backToMainAct(View view){
        Intent intent=new Intent(context,MainActivity.class);
        ((Activity)context).startActivity(intent);
        ((Activity)context).finishAffinity();
    }
    public void handleToolbarBackground(String toolbarTitleText , int color){
        toolbarTitle.set(toolbarTitleText);
        toolbarColor.set(color);}



}
