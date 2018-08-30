package findandfix.view.ui.holder;

import android.support.v7.widget.RecyclerView;

import findandfix.databinding.ItemAdvertisingBinding;

import findandfix.model.global.AdvData;
import findandfix.viewmodel.ItemOfferViewModel;

public class OffersHolder extends RecyclerView.ViewHolder {
    private ItemAdvertisingBinding binding;
    public OffersHolder(ItemAdvertisingBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }

    public void bindOffer(AdvData advData){
       if(binding.getViewmodel()==null)
            binding.setViewmodel(new ItemOfferViewModel(itemView.getContext(),advData));
        else
            binding.getViewmodel().setAdv(advData);

    }
}
