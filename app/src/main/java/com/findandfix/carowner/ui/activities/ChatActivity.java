package com.findandfix.carowner.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivityChatLayoutBinding;
import com.findandfix.carowner.model.global.Conv.ConversationHistory;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.ui.callback.BaseInterface;
import com.findandfix.carowner.ui.callback.CallAnotherActivityNavigator;
import com.findandfix.carowner.viewmodel.ChatViewModel;
import com.findandfix.carowner.viewmodel.ToolbarViewModel;

/**
 * Created by DELL on 14/03/2018.
 */

public class ChatActivity extends BaseActivity implements BaseInterface,CallAnotherActivityNavigator{

    private ActivityChatLayoutBinding binding;
    private ChatViewModel viewModel;
    private ConversationHistory history;
    private String deviceToken=null;
    public static boolean active=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
        setUpToolBar();
    }

    @Override
    protected void onStart() {
        super.onStart();
        active=true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        active=false;
    }

    public void initBinding(){
            history=(ConversationHistory) getIntent().getSerializableExtra("Conversation_Id");

            binding= DataBindingUtil.setContentView(ChatActivity.this, R.layout.activity_chat_layout);
            viewModel=new ChatViewModel(this,this,this,history);
            binding.setViewmodel(viewModel);
            binding.rvChat.setHasFixedSize(true);
            binding.rvChat.setItemViewCacheSize(20);
            binding.rvChat.setDrawingCacheEnabled(true);
            binding.rvChat.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
            binding.rvChat.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false));
    }

    public void setUpToolBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        ToolbarViewModel toolbarViewModel=new ToolbarViewModel(ChatActivity.this, ConfigurationFile.Constants.HANDLE_CONVERSATION_HISTORY_TOOLBAR);
        binding.toolbar.setViewmodel(toolbarViewModel);
        toolbarViewModel.handleConversationDetailToolbar(history.getConversations().sender_name);

    }

    @Override
    public void updateUi(int code) {
        if(code== ConfigurationFile.Constants.SHOW_DIALOG_CODE)
            CustomUtils.getInstance().showDialog(ChatActivity.this,viewModel);
        else if(code==ConfigurationFile.Constants.PERMISSION_GRANTED_CAMERA)
           CustomUtils.getInstance().openCamera(ChatActivity.this);
        else if(code==ConfigurationFile.Constants.PERMISSION_GRANTED_GALLERY)
            CustomUtils.getInstance().openGallery(ChatActivity.this,false);

        else if(code==ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE)
            Snackbar.make(binding.rlParent,getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        viewModel.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public void callActivity() {
            CustomUtils.getInstance().startPlacePicker(ChatActivity.this);
    }
}
