package findandfix.view.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

import findandfix.R;
import findandfix.databinding.ActivityWorkshopOffersLayoutBinding;
import findandfix.model.global.Notification;
import findandfix.model.global.Payload;
import findandfix.model.global.RequestOfferObj;
import findandfix.model.global.UserData;
import findandfix.model.request.AcceptedOfferNotification;
import findandfix.model.request.NormalRequestDetailObject;
import findandfix.model.response.DefaultResponse;
import findandfix.model.response.RequestOfferResponse;
import findandfix.network.ApiClient;
import findandfix.network.EndPoints;
import findandfix.utils.ConfigurationFile;
import findandfix.utils.CustomUtils;
import findandfix.utils.NetWorkConnection;
import findandfix.utils.SharedPrefrenceUtils;
import findandfix.view.ui.adapters.FoldingCellListAdapter;
import findandfix.view.ui.callback.AchievmentItemClickListener;
import findandfix.view.ui.callback.RecycleItemClickListener;
import findandfix.viewmodel.ToolbarViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
/**
 * Example of using Folding Cell with ListView and ListAdapter
 */

public class WorkShopOffersActivity extends BaseActivity {

    private ProgressBar progressBar;
    private UserData userData;
    ArrayList<RequestOfferObj> items=null;
    private RequestOfferObj requestOfferObj=null;
    private  FoldingCellListAdapter adapter=null;
    private int requestid=0;
    private ActivityWorkshopOffersLayoutBinding binding;
    private NormalRequestDetailObject normalRequestDetailObjec=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_workshop_offers_layout);
        // get our list view
        setUpActionBar();
        userData= CustomUtils.getInstance().getSaveUserObject(getApplicationContext());
        // prepare elements to display
        items = new ArrayList<>();

        getOffersData();
      //  getRequestOffers();

        // get our list view


    }

    public void getOffersData(){
        if (getIntent()!=null) {
            if (getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.WORKSHOP_OFFERS)!=null) {
                items = (ArrayList<RequestOfferObj>) getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.WORKSHOP_OFFERS);
                normalRequestDetailObjec=(NormalRequestDetailObject) getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.REQUESt_DETAIL_OBJ);
                setAdapter();
            }else if (getIntent().getIntExtra(ConfigurationFile.IntentsConstants.REQUEST_ID,0)!=0){
                requestid=getIntent().getIntExtra(ConfigurationFile.IntentsConstants.REQUEST_ID,0);
                System.out.println("Request Id Data  2:"+requestid);
                getRequestOffers();
            }
        }
    }


    public void setUpActionBar(){
        setSupportActionBar( binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(WorkShopOffersActivity.this, ConfigurationFile.Constants.HANDLE_WORKSHOP_OFFERS_TOOLBAR)); }
    public void getRequestOffers(){


        if (NetWorkConnection.isConnectingToInternet(WorkShopOffersActivity.this)) {
              //  binding.progressBar.setVisibility(View.VISIBLE);
            CustomUtils.getInstance().showProgressDialog(WorkShopOffersActivity.this);
                ApiClient.getClient().create(EndPoints.class).getRequestOffers(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getApplicationContext()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken(),requestid)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(requestOfferResponseResponse -> {
                            System.out.println("Message Of Request CODE :"+requestOfferResponseResponse.code());
                         //   binding.progressBar.setVisibility(View.GONE);
                                CustomUtils.getInstance().cancelDialog();
                            if (requestOfferResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE){

                                RequestOfferResponse requestOfferResponse=requestOfferResponseResponse.body();
                                items= requestOfferResponse.getData();

                                setAdapter();
                            }
                            // moveToNextAct();
                            else if (requestOfferResponseResponse.code()==ConfigurationFile.Constants.UNCONFIRMED_CODE ||
                                    requestOfferResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                                Snackbar.make(findViewById(R.id.rl_parent), R.string.unuthenticated,Snackbar.LENGTH_LONG).show();}
                            else if (requestOfferResponseResponse.code()==ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                                Snackbar.make(findViewById(R.id.rl_parent), R.string.cant_complete_your_request,Snackbar.LENGTH_LONG).show();
                        }, throwable -> {
                            CustomUtils.getInstance().cancelDialog();
                          //  binding.progressBar.setVisibility(View.GONE);
                            System.out.println("Ex :"+throwable.getMessage());
                        });


        }else {
            Snackbar.make(findViewById(R.id.rl_parent),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
        }

    }


    public void acceptWorkOffer(RequestOfferObj requestOfferObj){


        if (NetWorkConnection.isConnectingToInternet(WorkShopOffersActivity.this)) {
           // binding.progressBar.setVisibility(View.VISIBLE);
            CustomUtils.getInstance().showProgressDialog(WorkShopOffersActivity.this);
            Notification notification=new Notification();
            notification.setKey(3);
            notification.setDeviceToken(requestOfferObj.getWorkshop().getDeviceToken());
            Payload payload=new Payload();
            payload.setNotificationTitle("offer_accepted");
            payload.setOfferId(String.valueOf(requestOfferObj.getId()));
            payload.setKey(3);
            notification.setData(payload);
            AcceptedOfferNotification acceptedOfferNotification=new AcceptedOfferNotification();
            acceptedOfferNotification.setNotification(notification);
            ApiClient.getClient().create(EndPoints.class).acceptWorkShopOffer(ConfigurationFile.Constants.API_KEY,CustomUtils.getInstance().getAppLanguage(getApplicationContext()),ConfigurationFile.Constants.Content_Type,ConfigurationFile.Constants.Content_Type,"Bearer "+userData.getToken(),acceptedOfferNotification,requestOfferObj.getId())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(defaultResponseResponse -> {
                        System.out.println("Message Of Request CODE OFFERS WORKSHOP :"+defaultResponseResponse.code());
                       // binding.progressBar.setVisibility(View.GONE);
                        CustomUtils.getInstance().cancelDialog();
                        if (defaultResponseResponse.code()==ConfigurationFile.Constants.SUCCESS_CODE){
                                Intent i=new Intent(getApplicationContext(),RequestDetailActivity.class);
                                i.putExtra(ConfigurationFile.IntentsConstants.WORKSHOP_OFFER_OBJ,requestOfferObj);
                                 i.putExtra(ConfigurationFile.IntentsConstants.REQUESt_DETAIL_OBJ,normalRequestDetailObjec);
                                startActivity(i);
                                finish();
                                finishAffinity();

                        }
                        // moveToNextAct();
                        else if (defaultResponseResponse.code()==ConfigurationFile.Constants.UNCONFIRMED_CODE ||
                                defaultResponseResponse.code()==ConfigurationFile.Constants.UNUTHENTICATED_CODE){
                           CustomUtils.getInstance().endSession(WorkShopOffersActivity.this);
                        }
                        else if (defaultResponseResponse.code()==ConfigurationFile.Constants.CANT_COMPLETE_REQUEST_CODE)
                            Snackbar.make(findViewById(R.id.rl_parent), R.string.cant_complete_your_request,Snackbar.LENGTH_LONG).show();
                    }, throwable -> {
                        CustomUtils.getInstance().cancelDialog();
                      //  binding.progressBar.setVisibility(View.GONE);
                        System.out.println("Ex :"+throwable.getMessage());
                    });


        }else {
            Snackbar.make(findViewById(R.id.rl_parent),getResources().getString(R.string.msg_internet_connection),Snackbar.LENGTH_LONG).show();
        }

    }

    public void setAdapter(){
        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
          adapter = new FoldingCellListAdapter(this, items);

        // add default btn handler for each request btn on each item if custom handler not found
        adapter.setDefaultRequestBtnClickListener(v -> Toast.makeText(getApplicationContext(), "DEFAULT HANDLER FOR ALL BUTTONS", Toast.LENGTH_SHORT).show());

        // set elements to adapter
        binding.mainListView.setAdapter(adapter);

        // set on click event listener to list view
        binding.mainListView.setOnItemClickListener((adapterView, view, pos, l) -> {
            // toggle clicked cell state
            ((FoldingCell) view).toggle(false);
            // \\register in adapter that state for selected cell is toggled
            adapter.registerToggle(pos);
        });

        adapter.setListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {
                    acceptWorkOffer(offerObj);
            }
        });

        adapter.setAchievmentItemClickListener(workshopId -> {
             Intent i=new Intent(getApplicationContext(),WorkShopAchievmentActivity.class);
             i.putExtra(ConfigurationFile.IntentsConstants.WORKSHOP_ID,workshopId);
             startActivity(i);
        }

        );

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(WorkShopOffersActivity.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
