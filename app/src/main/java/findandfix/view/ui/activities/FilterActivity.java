package findandfix.view.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import findandfix.R;
import findandfix.databinding.ActivityFilterationLayoutBinding;
import findandfix.utils.ConfigurationFile;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.viewmodel.FilterViewModel;
import findandfix.viewmodel.ToolbarViewModel;

/**
 * Created by DELL on 16/08/2018.
 */

public class FilterActivity extends AppCompatActivity implements BaseInterface{

    private ActivityFilterationLayoutBinding binding;
    private FilterViewModel viewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_filteration_layout);
        setUpActionBar();
        viewModel=new FilterViewModel(this,this);
        binding.setViewmodel(viewModel);}

    public void setUpActionBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(FilterActivity.this, ConfigurationFile.Constants.HANDLE_FILTER_TOOLBAR));}

    @Override
    public void updateUi(int code) {
        if (code==ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE)
            Snackbar.make(binding.getRoot(),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
        else if (code==ConfigurationFile.Constants.EMPTY_VALUE)
            Snackbar.make(binding.getRoot(), R.string.choose_specialization_filter,Snackbar.LENGTH_LONG).show();
        else if (code==ConfigurationFile.Constants.EMPTY_SPECIALIZATION)
            Snackbar.make(binding.getRoot(), R.string.choose_specialization,Snackbar.LENGTH_LONG).show();
    }
}
