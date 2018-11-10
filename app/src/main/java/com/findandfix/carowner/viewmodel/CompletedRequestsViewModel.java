package com.findandfix.carowner.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.function.Consumer;

import com.findandfix.carowner.model.global.RequestData;
import com.findandfix.carowner.model.global.UserData;
import com.findandfix.carowner.model.response.WorkShopRequestResponse;
import com.findandfix.carowner.network.ApiClient;
import com.findandfix.carowner.network.EndPoints;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.utils.NetWorkConnection;
import com.findandfix.carowner.ui.callback.BaseInterface;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by DELL on 27/03/2018.
 */

public class CompletedRequestsViewModel extends BaseObservable {

    private Context context;
    private BaseInterface callback;
    private UserData userData;
    public ObservableField<String> total;
    public ObservableList<RequestData>completedRequests;

    /////////////////////////////////////////////////////////////////////////
    private boolean loading=false;
    private String next=null;
    private int pageId=0;
    private int pos=0;

    ////////////////////////////////////////////////////////////////////////
    public CompletedRequestsViewModel(Context context, BaseInterface callback) {
        this.callback=callback;
        this.context=context;
        loading=true;
        userData= CustomUtils.getInstance().getSaveUserObject(context);
        completedRequests=new ObservableArrayList<>();
        total=new ObservableField<>();

    }

    public void onResume(){
        getCompletedRequests();
    }

    public RecyclerView.OnScrollListener onScroll(){
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if ( ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition()==completedRequests.size()) {
                    if (next!=null && loading ==false) {
                        loading=true;
                        System.out.println("Load More Data Success ");
                        getCompletedRequests();
                    }
                }
            }
        };
    }
    public void getCompletedRequests(){
       if(NetWorkConnection.isConnectingToInternet(context)) {
            System.out.println("Code cONNECTING");
           System.out.println("Token of User :"+userData.getToken());
           CustomUtils.getInstance().showProgressDialog((Activity) context);
            ApiClient.getClient().create(EndPoints.class).getCompletedRequests(ConfigurationFile.Constants.API_KEY, CustomUtils.getInstance().getAppLanguage(context), ConfigurationFile.Constants.Content_Type, ConfigurationFile.Constants.Content_Type, "Bearer "+userData.getToken(),pageId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(workShopRequestResponseResponse -> {
                        //     CustomUtils.getInstance().cancelDialog();
                        CustomUtils.getInstance().cancelDialog();
                        int code = workShopRequestResponseResponse.code();
                        System.out.println("Code :" + code);
                        loading=false;
                        if (code == ConfigurationFile.Constants.SUCCESS_CODE) {
                            pos=completedRequests.size();
                            System.out.println("Code :" + workShopRequestResponseResponse.body().getData().size());
                            completedRequests.addAll(workShopRequestResponseResponse.body().getData());
                            total.set(String.valueOf(workShopRequestResponseResponse.body().getMeta().getTotal()));
                            if (completedRequests.size() == 0)
                                callback.updateUi(ConfigurationFile.Constants.NO_DATA);
                            next=workShopRequestResponseResponse.body().getLinks().getNext();
                            if (next!=null)
                                pageId=Integer.parseInt(next.substring(next.length()-1));
                        } else if (code == ConfigurationFile.Constants.UNUTHENTICATED_CODE) {
                            callback.updateUi(ConfigurationFile.Constants.UNUTHENTICATED_CODE);
                        }
                    }, throwable -> {
                        CustomUtils.getInstance().cancelDialog();
                        System.out.println("Exception :" + throwable.getMessage());
                    });
        }else {
            callback.updateUi(ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE);
        }
    }

    public void onPause(){
        completedRequests.clear();
    }
}
