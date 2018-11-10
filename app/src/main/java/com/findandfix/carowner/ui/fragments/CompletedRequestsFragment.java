package com.findandfix.carowner.ui.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.findandfix.carowner.R;
import com.findandfix.carowner.databinding.FragmentCompletedRequestsLayoutBinding;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.ui.callback.BaseInterface;
import com.findandfix.carowner.viewmodel.CompletedRequestsViewModel;

/**
 * Created by DELL on 12/03/2018.
 */

public class CompletedRequestsFragment extends Fragment implements BaseInterface {
   private FragmentCompletedRequestsLayoutBinding binding;
   private CompletedRequestsViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_completed_requests_layout,container,false);
        View v=binding.getRoot();
        viewModel=new CompletedRequestsViewModel(getActivity(),this);
        binding.setCompletedViewModel(viewModel);
        binding.rvCompletedRequests.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL,false));
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        viewModel.onPause();
    }

    @Override
    public void updateUi(int code) {
        if(code== ConfigurationFile.Constants.NO_INTERNET_CONNECTION_CODE)
            Snackbar.make(getActivity().findViewById(R.id.ll_parent), R.string.msg_internet_connection, Snackbar.LENGTH_LONG).show();

        else if(code== ConfigurationFile.Constants.UNUTHENTICATED_CODE)
            CustomUtils.getInstance().endSession(getActivity());

        else if (code==ConfigurationFile.Constants.NO_DATA){
            binding.rvCompletedRequests.setVisibility(View.GONE);
            binding.tvCompleteRequestTxt.setVisibility(View.GONE);
            binding.ivNoRequests.setVisibility(View.VISIBLE);
            binding.tvNoRequests.setVisibility(View.VISIBLE);
        }
    }
}
