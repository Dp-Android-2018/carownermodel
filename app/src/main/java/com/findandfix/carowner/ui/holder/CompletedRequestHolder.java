package com.findandfix.carowner.ui.holder;

import android.support.v7.widget.RecyclerView;



import com.findandfix.carowner.databinding.ItemCompletedRequestLayoutBinding;
import com.findandfix.carowner.model.global.RequestData;
import com.findandfix.carowner.viewmodel.ItemRequestViewModel;

/**
 * Created by DELL on 27/03/2018.
 */

public class CompletedRequestHolder extends RecyclerView.ViewHolder {

    ItemCompletedRequestLayoutBinding binding;
    public CompletedRequestHolder(ItemCompletedRequestLayoutBinding binding) {
        super(binding.cvParent);
        this.binding=binding;
    }

    public void BindRequest(RequestData requestData){
        if(binding.getCompletedViewMOdel()==null){
            binding.setCompletedViewMOdel(new ItemRequestViewModel(itemView.getContext(),requestData));
        }else {
            binding.getCompletedViewMOdel().setRequestData(requestData);
        }
    }
}
