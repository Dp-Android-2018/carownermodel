package findandfix.view.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import findandfix.R;
import findandfix.databinding.ActivityOffersLayoutBinding;
import findandfix.model.global.AdvData;
import findandfix.model.global.UserData;
import findandfix.model.response.OffersResponse;
import findandfix.network.ApiClient;
import findandfix.network.EndPoints;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.utils.NetWorkConnection;
import findandfix.view.ui.adapters.OffersAdapter;
import findandfix.viewmodel.ToolbarViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class OffersActivity extends BaseActivity {

    ActivityOffersLayoutBinding binding;
    private List<AdvData>offers=new ArrayList<>();
    private OffersAdapter offersAdapter;
    private UserData userData;
    /////////////////////////////////////////////////////
    private boolean loading=false;
    private String next=null;
    private int pageId=0;
    private int pos=0;

    ////////////////////////////////////////////////////
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(OffersActivity.this,R.layout.activity_offers_layout);
        setUpToolBar();
        initializeRecycler();
        loading=true;
        getUserData();
        getOffers();
    }

    public void getUserData(){
        userData= CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
    }
    public void setUpToolBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(OffersActivity.this, ConfigurationFile.Constants.HANDLE_ADD_ADVERTISING_TOOLBAR));
    }

    public void initializeRecycler(){

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.rvOffers.setLayoutManager(mLayoutManager);
        binding.rvOffers.setItemAnimator(new DefaultItemAnimator());
        binding.rvOffers.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if ( ((LinearLayoutManager) binding.rvOffers.getLayoutManager()).findLastVisibleItemPosition()==offers.size()-1) {
                    if (next!=null && loading ==false) {
                        loading=true;
                        System.out.println("Load More Data Success ");
                        getOffers();
                    }

                }
            }
        });
    }

    public void getOffers(){
        if (NetWorkConnection.isConnectingToInternet(OffersActivity.this)) {
           // binding.progressBar.setVisibility(View.VISIBLE);
            CustomUtils.getInstance().showProgressDialog(OffersActivity.this);
            System.out.println("Offers Token :"+userData.getToken());
            ApiClient.getClient().create(EndPoints.class).getOffers(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getApplicationContext()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken(),pageId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(offersResponseResponse -> {
                        System.out.println("Offers CODE :"+offersResponseResponse.code());
                        CustomUtils.getInstance().cancelDialog();
                      //  binding.progressBar.setVisibility(View.GONE);
                        loading=false;
                        if (offersResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE) {
                            OffersResponse response=offersResponseResponse.body();
                            pos=offers.size();
                            offers.addAll(response.getData());
                            next=response.getLinks().getNext();
                            if (next!=null)
                                pageId=Integer.parseInt(next.substring(next.length()-1));
                            System.out.println("Offers CODE Size :"+offers.size());
                            setAdapter();
                        }else if (offersResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE) {
                          CustomUtils.getInstance().endSession(OffersActivity.this);
                        }
                    }, throwable -> {
                      //  binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        System.out.println("Ex :"+throwable.getMessage());
                    });

        }else {
            Snackbar.make(binding.getRoot(),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
        }
    }

    public void setAdapter(){

        if (offers.size()>0) {
            offersAdapter = new OffersAdapter(offers);
            binding.rvOffers.setAdapter(offersAdapter);
        }else {
            binding.rlNoAdv.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(OffersActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
