package findandfix.view.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import findandfix.R;
import findandfix.model.global.BaseModel;
import findandfix.view.ui.callback.RecycleItemClickListener;
import findandfix.view.ui.callback.RecyclerItemUnSelectedListener;

public class SubSpecilaizeAdapter extends RecyclerView.Adapter<SubSpecilaizeAdapter.ViewHolder> {

    private List<BaseModel> specializeItems;
    private LayoutInflater mInflater;
    private RecycleItemClickListener recycleItemClickListener;
    private RecyclerItemUnSelectedListener recyclerItemUnSelectedListener;
    Context context;

    // data is passed into the constructor
    public SubSpecilaizeAdapter(Context context, List<BaseModel> specializeItems) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.specializeItems = specializeItems;
    }

    // inflates the row layout from xml when needed
    @Override
    public SubSpecilaizeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_sub_specialize_layout, parent, false);
        return new SubSpecilaizeAdapter.ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(SubSpecilaizeAdapter.ViewHolder holder, int position) {
        BaseModel baseModel = specializeItems.get(position);
        holder.title.setText(baseModel.getName());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return specializeItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView title;
        CheckBox checkBox;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_spinner_title);
            checkBox = itemView.findViewById(R.id.checkbox);
            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (recycleItemClickListener != null) {
                    if (isChecked)
                        recycleItemClickListener.onItemClick(getAdapterPosition());
                    else if (! isChecked)
                        recyclerItemUnSelectedListener.onItemUnSelected(getAdapterPosition());
                }
            });
        }


    }


    public void setClickListener(RecycleItemClickListener recycleItemClickListener) {
        this.recycleItemClickListener = recycleItemClickListener;
    }

    public void setUnSelectedListener(RecyclerItemUnSelectedListener recyclerItemUnSelectedListener){
        this.recyclerItemUnSelectedListener=recyclerItemUnSelectedListener;

    }


}
