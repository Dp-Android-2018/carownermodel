package com.findandfix.carowner.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.View;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import agency.tango.materialintroscreen.animations.IViewTranslation;
import com.findandfix.carowner.R;

public class IntroActivity extends MaterialIntroActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableLastSlideAlphaExitTransition(true);

        getBackButtonTranslationWrapper()
                .setEnterTranslation((view, percentage) -> view.setAlpha(percentage));
        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.colorPrimary)
                        .buttonsColor(R.color.colorAccent)
                        .image(R.drawable.h1)
                        .title("")
                        .description(getString(R.string.choose_car_problem))
                        .build());


        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.colorAccent)
                .image(R.drawable.h2)
                .title("")
                .description(getString(R.string.search_for_professional_workshop))
                .build());


        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.colorAccent)
                .image(R.drawable.h3)
                .title("")
                .description(getString(R.string.choose_best_offer))
                .build());


        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.colorAccent)
                .image(R.drawable.h4)
                .title("")
                .description(getString(R.string.pick_location))
                .build());


        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.colorAccent)
                .image(R.drawable.h5)
                .title("")
                .description(getString(R.string.choose_problem))
                .build());


        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.colorAccent)
                .image(R.drawable.h6)
                .title("")
                .description(getString(R.string.choose_offer))
                .build());


    }

    @Override
    public void onFinish() {
        super.onFinish();
        Intent i=new Intent(IntroActivity.this,LoginActivity.class);
        startActivity(i);
        finish();
    }
}
