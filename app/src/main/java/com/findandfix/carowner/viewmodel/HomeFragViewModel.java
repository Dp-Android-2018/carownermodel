package com.findandfix.carowner.viewmodel;

import android.animation.Animator;
import android.app.Activity;
import android.databinding.ObservableBoolean;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.ui.callback.BaseInterface;

/**
 * Created by DELL on 13/06/2018.
 */

public class HomeFragViewModel {

    public ObservableBoolean isTextVisible;
    public ObservableBoolean isImageVisible;

    private BaseInterface callback;
    private Activity activity;
    private int width,height;

    public HomeFragViewModel(Activity activity, BaseInterface callback) {
        isTextVisible=new ObservableBoolean(false);
        isImageVisible=new ObservableBoolean(false);
        this.callback=callback;
        this.activity=activity;
        calculateMetrics();
    }

    public void calculateMetrics(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = (displayMetrics.widthPixels);
    }

    public Animator.AnimatorListener onAnimationEnd(){
        return new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (!isTextVisible.get())
                    isTextVisible.set(true);
                else {
                    isTextVisible.set(false);
                    isImageVisible.set(true);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        };
    }
    public View.OnTouchListener onTouchEvent(){

        return (v, event) -> {

            if (isImageVisible.get()) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if ((int) event.getX() < ((width - 24) / 2) && (int) event.getY() < ((height - 24) / 4)) {
                            callback.updateUi(ConfigurationFile.Constants.URGENT_REQUEST_ACTIVITY);
                    } else if ((int) event.getX() < ((width - 24) / 2) && (int) event.getY() > ((height - 24) / 4)) {
                        callback.updateUi(ConfigurationFile.Constants.ADVERTISEMENT_ACTIVITY);
                    } else if ((int) event.getX() > ((width - 24) / 2) && (int) event.getY() < ((height - 24) / 4)) {
                        callback.updateUi(ConfigurationFile.Constants.NORMAL_REQUEST_ACTIVITY);
                    } else if ((int) event.getX() > ((width - 24) / 2) && (int) event.getY() > ((height - 24) / 4)) {
                        callback.updateUi(ConfigurationFile.Constants.EDIT_PROFILE_ACTIVITY);
                    }
                }
            }
            return true;

        };

    }

    public void startEngine(View view){
        callback.updateUi(ConfigurationFile.Constants.COMPLETE_ANIMATION_CODE);
    }

}
