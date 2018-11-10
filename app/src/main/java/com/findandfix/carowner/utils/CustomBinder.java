package com.findandfix.carowner.utils;


import android.animation.Animator;
import android.databinding.BindingAdapter;
import android.databinding.ObservableList;
import android.graphics.Bitmap;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import com.findandfix.carowner.Application.MyApplication;
import com.findandfix.carowner.model.global.Conv.ConversationHistory;
import com.findandfix.carowner.model.global.Conv.Message;
import com.findandfix.carowner.model.global.RequestData;
import com.findandfix.carowner.ui.adapters.ConversationDetailAdapter;
import com.findandfix.carowner.ui.adapters.MyConversationAdapter;
import com.findandfix.carowner.ui.adapters.RequestsAdapter;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.views.BannerSlider;

/**
 * Created by DELL on 20/03/2018.
 */

public class CustomBinder {

    /*@BindingAdapter("bind:items")
    public static void bindList(Spinner view, List<BaseModel> list) {
        CityAdapter adapter = new CityAdapter(list);
        view.setAdapter(adapter);
    }*/


    @BindingAdapter("bind:navigationItem")
    public static void navigationEvent(NavigationView navigationView, NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        navigationView.setNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }


    @BindingAdapter("bind:toolbarBackground")
    public static void setToolBarBackground(android.support.v7.widget.Toolbar toolBarBackground,int color) {
        toolBarBackground.setBackgroundColor(MyApplication.getAppContext().getResources().getColor(color));
    }


    @BindingAdapter("bind:completedrequests")
    public static void setRecyclerCompletedRequests(RecyclerView view,ObservableList<RequestData> list) {
        System.out.println("Requests  Binding:");
        RequestsAdapter adapter = new RequestsAdapter(list,4);
        view.setAdapter(adapter);

    }


    @BindingAdapter("bind:scroll")
    public static void setRecyclerScroll(RecyclerView recyclerView, RecyclerView.OnScrollListener listener) {
        recyclerView.setOnScrollListener(listener);
    }

    @BindingAdapter("bind:imageConv")
    public static void setImageConv(ImageView imageView, String url) {
        try {

            if (url!=null && !url.equals(""))
            Picasso.with(MyApplication.getAppContext()).load(url).fit().into(imageView);
        }catch (IllegalArgumentException ex){ex.printStackTrace();}
    }
    @BindingAdapter("bind:setBanners")
    public static void setBanners(BannerSlider bannerSlider, ArrayList<Banner> list) {
        bannerSlider.setBanners(list);
    }
    @BindingAdapter("bind:imageBitmap")
    public static void setImageBitmap(ImageView imageView, Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
    }


    @BindingAdapter("bind:circleImageBitmap")
    public static void setcircleImageBitmap(CircleImageView imageView, Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
    }


    @BindingAdapter("bind:conversationDetails")
    public static void setRecyclerConversationDetails(RecyclerView view, ObservableList<Message> list) {
        System.out.println("Adapter Data Fire:"+list.size());
        ConversationDetailAdapter adapter=new ConversationDetailAdapter(list);
        view.setAdapter(adapter);
        view.scrollToPosition(list.size()-1);
    }

    @BindingAdapter("bind:conversationhistory")
    public static void setRecyclerConversation(RecyclerView view,ObservableList<ConversationHistory> list) {
        System.out.println("Adapter Data Fire:"+list.size());
        MyConversationAdapter myConversationAdapter=new MyConversationAdapter(list);
        view.setAdapter(myConversationAdapter);
    }

    @BindingAdapter("bind:errorText")
    public static void setErrorMessage(TextInputLayout view, String errorMessage) {
        view.setError(errorMessage);
    }


    @BindingAdapter("bind:animation")
    public static void onAnimationEnd(LottieAnimationView animationView, Animator.AnimatorListener animatorListener) {
        animationView.addAnimatorListener(animatorListener);
    }


    @BindingAdapter("bind:ontouch")
    public static void onTouch(LottieAnimationView animationView, View.OnTouchListener touchListener) {
        animationView.setOnTouchListener(touchListener);
    }



    @BindingAdapter("bind:setprogress")
    public static void progress(LottieAnimationView animationView,float progress) {
        if (progress==0.3f) {
            System.out.println("Played Lottie 1");
            animationView.setMaxProgress(progress);
            animationView.playAnimation();

        }else if (progress == 1.0f) {
            System.out.println("Played Lottie 2");
            animationView.setMaxProgress(1.0f);
            animationView.resumeAnimation();

        }
   //    animationView.playAnimation();
     //  animationView.setMaxProgress(progress);



    }


    @BindingAdapter("bind:picUrl")
    public static void setImageConv(CircleImageView imageView, String url) {
        Picasso.with(MyApplication.getAppContext()).load(url).fit().into(imageView);
    }

}
