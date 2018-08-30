package findandfix.view.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import findandfix.R;
import findandfix.databinding.ActivityFixationPaperLayoutBinding;
import findandfix.model.request.AddNormalRequest;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.viewmodel.FixationPaperViewModel;
import findandfix.viewmodel.ToolbarViewModel;

/**
 * Created by DELL on 15/08/2018.
 */

public class FixationPaperActivity extends BaseActivity implements BaseInterface {
    private ActivityFixationPaperLayoutBinding binding;
    private FixationPaperViewModel viewModel;
    private AddNormalRequest addNormalRequest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_fixation_paper_layout);
        addNormalRequest=new AddNormalRequest();
        viewModel=new FixationPaperViewModel(FixationPaperActivity.this,this,addNormalRequest);
        binding.setUploadImageModelView(viewModel);

        setUpActionBar();

    }

    public void setUpActionBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(FixationPaperActivity.this, ConfigurationFile.Constants.HANDLE_NORMAL_REQUEST_TOOLBAR));}

    @Override
    public void updateUi(int code) {
        if(code== ConfigurationFile.Constants.SHOW_DIALOG_CODE)
            CustomUtils.getInstance().showDialog(FixationPaperActivity.this,viewModel);

        else if(code==ConfigurationFile.Constants.PERMISSION_DENIED)
            showSnackBar(getString(R.string.permission_denied));
        else if(code==ConfigurationFile.Constants.PERMISSION_GRANTED_CAMERA)
            CustomUtils.getInstance().openCamera(FixationPaperActivity.this);
        else if(code==ConfigurationFile.Constants.PERMISSION_GRANTED_GALLERY)
            CustomUtils.getInstance().openGallery(FixationPaperActivity.this,false);

        else if (code==ConfigurationFile.Constants.CHOOSE_IMAGE_FROM_GALLERY)
            showSnackBar(getString(R.string.choose_image));

        else if (code==ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE)
            showSnackBar(getString(R.string.msg_internet_connection));

        else if(code== ConfigurationFile.Constants.INVALID_DATA)
            showSnackBar(getString(R.string.invalid_data));
        else if(code== ConfigurationFile.Constants.MOVE_TO_MAIN_ACT) {
            Intent i = new Intent(this, AddRequestCarInfoActivity.class);
            i.putExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_REQUEST_OBJ,addNormalRequest);
            startActivity(i);
        }
    }



    public void showSnackBar(String message){
        Snackbar.make(binding.rlParent,message,Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        viewModel.onActivityResult(requestCode,resultCode,data);
    }
}
