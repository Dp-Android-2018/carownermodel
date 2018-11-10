package com.findandfix.carowner.ui.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

import com.findandfix.carowner.R;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.ui.adapters.WorkshopProfileImagesAdapter;

/**
 * Created by Bahaa Gabal on 20,October,2018
 */
public class WorkshopProfileImagesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewWorkshopProfileImages;
    private Toolbar mToolbar;
    private WorkshopProfileImagesAdapter mWorkshopProfileImagesAdapter;
    private final int NUMBER_OF_RECYCLER_VIEW_COLOUMNS = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop_profile_images);
        initUi();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void initUi() {
        handleStatusBarColor();
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.profile_pics);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        mRecyclerViewWorkshopProfileImages = findViewById(R.id.recycler_view_workshop_images);
        mRecyclerViewWorkshopProfileImages.setLayoutManager(new GridLayoutManager(this, NUMBER_OF_RECYCLER_VIEW_COLOUMNS));
        mRecyclerViewWorkshopProfileImages.setHasFixedSize(true);
        mWorkshopProfileImagesAdapter = new WorkshopProfileImagesAdapter(this, getWorkshopProfileImages());
        mRecyclerViewWorkshopProfileImages.setAdapter(mWorkshopProfileImagesAdapter);
    }

    public ArrayList<String> getWorkshopProfileImages() {
        ArrayList<String> workshopProfileImages = (ArrayList<String>) getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.WORKSHOP_PROFILE_IMAGES_TAG);
        return workshopProfileImages;
    }

    public void handleStatusBarColor() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.colorOrange));
        }
    }
}
