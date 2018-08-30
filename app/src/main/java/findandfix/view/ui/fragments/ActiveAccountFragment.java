package findandfix.view.ui.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import findandfix.R;
import findandfix.databinding.FragmentActiveAccountBinding;

import findandfix.viewmodel.ActivateAccountViewModel;

/**
 * Created by DELL on 12/06/2018.
 */

public class ActiveAccountFragment extends Fragment {

    private FragmentActiveAccountBinding binding;
    private ActivateAccountViewModel viewModel;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         viewModel=new ActivateAccountViewModel(getActivity());
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_active_account,container,false);
        View view=binding.getRoot();
        binding.setViewmodel(viewModel);
        return view;
    }
}
