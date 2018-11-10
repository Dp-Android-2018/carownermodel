package com.findandfix.carowner.ui.activities;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.ActivityAddRequestMediaBinding;
import com.findandfix.carowner.model.global.RequestOfferObj;
import com.findandfix.carowner.model.request.AddNormalRequest;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.ui.adapters.ImagesAdapter;
import com.findandfix.carowner.ui.callback.BaseInterface;
import com.findandfix.carowner.ui.callback.RecycleItemClickListener;
import com.findandfix.carowner.viewmodel.ToolbarViewModel;

public class AddRequestMediaActivity extends BaseActivity implements BaseInterface {
    private ActivityAddRequestMediaBinding binding;
    private RxPermissions rxPermissions;
    private Uri selectedImageUri = null;
    private String selectedVideoUri = null;
    private Bitmap selectedImageBitmap;
    private String filemanagerstring = null;
    private Uri selectedVideoPathUri = null;
    private ArrayList<Bitmap> bitmaps;
    private ArrayList<Uri> uris;
    private ArrayList<String> photoUrls;
    private ImagesAdapter imagesAdapter;
    private StorageReference storageReference;
    private ProgressDialog progressdialog;
    private double progressImages = 0;
    private int index = 0;
    private String uploadedVideoUrl = null;
    private AddNormalRequest addNormalRequest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(AddRequestMediaActivity.this, R.layout.activity_add_request_media);
        setUpActionBar();
        getExtraFromIntents();
        bitmaps = new ArrayList<>();
        uris = new ArrayList<>();
        photoUrls = new ArrayList<>();
        rxPermissions = new RxPermissions(this);
        storageReference = FirebaseStorage.getInstance().getReference().child("app_photos");
        initializeRecycler();
        binding.btnChooseImages.setOnClickListener(v -> {
            if (bitmaps.size() < 5)
                CustomUtils.getInstance().showDialog(AddRequestMediaActivity.this, null);
            else
                showSnackBar(getString(R.string.maximum_image_number));
        });

        binding.btnChooseVideo.setOnClickListener(v -> askForPermission(2));

        binding.btnNext.setOnClickListener(v -> {
            if (bitmaps.size() != 0) {
                binding.btnNext.setEnabled(false);
                uploadImagesToFireBase();
            } else if (selectedVideoPathUri != null) {
                binding.btnNext.setEnabled(false);
                uploadVideoTOFireBase();
            } else {
                moveTonextAct();
            }
        });
    }

    public void getExtraFromIntents() {
        addNormalRequest = (AddNormalRequest) getIntent().getSerializableExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_REQUEST_OBJ);
    }

    public void startVideoFromGallery() {
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, getString(R.string.select_video)), ConfigurationFile.Constants.PERMISSION_GRANTED_VIDEO);
    }

    public void initializeRecycler() {
        imagesAdapter = new ImagesAdapter(getApplicationContext(), bitmaps);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.rvImages.setHasFixedSize(true);
        binding.rvImages.setItemViewCacheSize(20);
        binding.rvImages.setDrawingCacheEnabled(true);
        binding.rvImages.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        binding.rvImages.setLayoutManager(mLayoutManager);
        binding.rvImages.setItemAnimator(new DefaultItemAnimator());
        binding.rvImages.setAdapter(imagesAdapter);
        imagesAdapter.setClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClick(int position) {
                bitmaps.remove(bitmaps.get(position));
                uris.remove(uris.get(position));
                imagesAdapter.notifyDataSetChanged();
            }

            @Override
            public void getWorkshopOffer(RequestOfferObj offerObj) {

            }
        });
    }

    public void askForPermission(int checker) {
        CustomUtils.getInstance().requirePermission(rxPermissions, checker, AddRequestMediaActivity.this);
    }

    @Override
    public void updateUi(int code) {
        if (code == ConfigurationFile.Constants.PERMISSION_DENIED)
            showSnackBar(getString(R.string.permission_denied));
        else if (code == ConfigurationFile.Constants.PERMISSION_GRANTED_CAMERA)
            CustomUtils.getInstance().openCamera(AddRequestMediaActivity.this);
        else if (code == ConfigurationFile.Constants.PERMISSION_GRANTED_GALLERY)
            CustomUtils.getInstance().openGallery(AddRequestMediaActivity.this, true);

        else if (code == ConfigurationFile.Constants.PERMISSION_GRANTED_VIDEO)
            startVideoFromGallery();
    }

    public void showSnackBar(String message) {
        Snackbar.make(binding.getRoot(), message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // infoViewModel.onActivityResult(requestCode,resultCode,data);
        if (resultCode == RESULT_OK) {
            if (requestCode == ConfigurationFile.Constants.PERMISSION_GRANTED_VIDEO) {
                selectedVideoPathUri = data.getData();

                binding.ivVideoPlaceholder.setVisibility(View.VISIBLE);
                Glide.with(getApplicationContext())
                        .load(selectedVideoPathUri)
                        .into(binding.ivVideoPlaceholder);
                // OI FILE Manager
                filemanagerstring = selectedVideoPathUri.getPath();

                // MEDIA GALLERY
                selectedVideoUri = getPath(selectedVideoPathUri);
                if (selectedVideoUri != null) {

             /*   Intent intent = new Intent(HomeActivity.this,
                        VideoplayAvtivity.class);
                intent.putExtra("path", selectedImagePath);
                startActivity(intent);*/

                }
            } else {
                if (data.getData() != null) {
                    convertImageToBase64(data.getData());
                    selectedImageUri = data.getData();
                    uris.add(selectedImageUri);
                } else {
                    if (data.getClipData() != null) {
                        ClipData mClipData = data.getClipData();
                        if (mClipData.getItemCount() + uris.size() <= 5) {
                            for (int i = 0; i < mClipData.getItemCount(); i++) {
                                ClipData.Item item = mClipData.getItemAt(i);
                                Uri uri = item.getUri();
                                convertImageToBase64(uri);
                                uris.add(uri);
                            }
                        } else {
                            showSnackBar(getString(R.string.maxmimum_image_num));
                        }
                    }
                }
            }
        }
    }

    public String getPath(Uri uri) {
        String[] projection = {MediaStore.Video.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            // HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
            // THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }

    public void convertImageToBase64(Uri ImageUri) {
        try {
            final InputStream imageStream = getContentResolver().openInputStream(ImageUri);
            selectedImageBitmap = BitmapFactory.decodeStream(imageStream);
            String RealPicturePath = CustomUtils.getInstance().uriToFilename(ImageUri, getApplicationContext());
            selectedImageBitmap = CustomUtils.getInstance().modifyOrientation(selectedImageBitmap, RealPicturePath);
            bitmaps.add(selectedImageBitmap);
            imagesAdapter.notifyDataSetChanged();
            // setPicBitmap(selectedImageBitmap);
            //    encodedImage = CustomUtils.getInstance().encodeImage(selectedImageBitmap);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setUpActionBar() {
        setSupportActionBar(binding.toolbar.toolbar);
        binding.toolbar.setViewmodel(new ToolbarViewModel(AddRequestMediaActivity.this, ConfigurationFile.Constants.HANDLE_NORMAL_REQUEST_SECONDARY_TOOLBAR));
    }


    public void uploadImagesToFireBase() {
        System.out.println("Photo Url uploaded: Start");
        showProgressDialog(getString(R.string.uploading_pictures));
        for (int i = 0; i < uris.size(); i++) {
            index = i;
            UploadTask photoRef = storageReference.child(uris.get(i).getLastPathSegment()).putFile(uris.get(i));
            photoRef.addOnSuccessListener(taskSnapshot -> {

                Uri photoUrl = taskSnapshot.getDownloadUrl();
                photoUrls.add(photoUrl.toString());
                System.out.println("Uploaded Media Photo :" + photoUrl.toString() + " index:" + index);
                if (photoUrls.size() == uris.size()) {
                    progressdialog.setProgress(100);
                    progressdialog.dismiss();
                    progressdialog = null;
                    if (selectedVideoPathUri != null)
                        uploadVideoTOFireBase();
                    else moveTonextAct();

                }

            });


            photoRef.addOnProgressListener(taskSnapshot -> {
                progressImages = progressImages + (((100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount()) / uris.size());
                System.out.println("Upload is " + progressImages + "% done");
                if ((int) progressImages >= 100)
                    progressdialog.setProgress(98);
                else
                    progressdialog.setProgress((int) progressImages);
            });
        }
    }

    public void uploadVideoTOFireBase() {
        showProgressDialog(getString(R.string.uploading_videos));
        StorageMetadata metadata = new StorageMetadata.Builder()
                .setContentType("video/mp4")
                .build();
        UploadTask photoRef = storageReference.child(selectedVideoPathUri.getLastPathSegment()).putFile(selectedVideoPathUri, metadata);
        photoRef.addOnSuccessListener(taskSnapshot -> {
            Uri videourl = taskSnapshot.getDownloadUrl();
            uploadedVideoUrl = videourl.toString();
            if (uploadedVideoUrl != null) {
                progressdialog.setProgress(100);
                progressdialog.dismiss();
                moveTonextAct();
            }
            System.out.println("Uploaded Media Video :" + videourl.toString());
        });


        photoRef.addOnProgressListener(taskSnapshot -> {
            double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
            System.out.println("Upload is " + progress + "% done");
            if ((int) progress < 100)
                progressdialog.setProgress((int) progress);
            else
                progressdialog.setProgress(98);
           /*  if ((int)progress>=100){
                 progressdialog.dismiss();
                 moveTonextAct();
             }*/

        });
    }


    public void showProgressDialog(String title) {

        progressdialog = new ProgressDialog(AddRequestMediaActivity.this);


        progressdialog.setIndeterminate(false);
        progressdialog.setTitle(title);
        progressdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        progressdialog.setCancelable(false);


        progressdialog.setMax(100);

        progressdialog.show();


    }

    public void moveTonextAct() {
        if (photoUrls.size() > 0)
            addNormalRequest.setImages(photoUrls);
        else addNormalRequest.setImages(null);
        addNormalRequest.setVideo(uploadedVideoUrl);
        bitmaps.clear();
        uris.clear();
        binding.btnNext.setEnabled(true);
        Intent i = new Intent(AddRequestMediaActivity.this, AddRequestNotesActivity.class);
        i.putExtra(ConfigurationFile.IntentsConstants.CAR_OWNER_ADD_REQUEST_OBJ, addNormalRequest);
        startActivity(i);
    }

}
