package com.findandfix.carowner.utils;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by DELL on 28/03/2018.
 */

public class FragmentUtils {
    public static int CONTAINER_ID = android.R.id.content;


    private static FragmentTransaction getFragmentTransaction(Context context) {
        FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        return fragmentManager.beginTransaction();
    }

    public static void addFragment(Context context, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentTransaction(context);
        fragmentTransaction.replace(CONTAINER_ID, fragment);
        fragmentTransaction.commit();
    }

}
