package findandfix.view.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import findandfix.R;
import findandfix.model.response.YearItem;
import findandfix.view.ui.callback.RecycleItemClickListener;

/**
 * Created by mohamedatef on 5/5/18.
 */

public class YearsAdapter extends RecyclerView.Adapter<YearsAdapter.ViewHolder> {

    private List<YearItem> yearItems;
    private LayoutInflater mInflater;
    private RecycleItemClickListener recycleItemClickListener;
    Context context;

    // data is passed into the constructor
    public YearsAdapter(Context context, List<YearItem> yearItems) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.yearItems = yearItems;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_spinner, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        YearItem yearItem = yearItems.get(position);
        holder.title.setText(yearItem.getName());
        holder.image.setVisibility(View.GONE);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return yearItems.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView image;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_spinner_title);
            image = itemView.findViewById(R.id.iv_spinner_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (recycleItemClickListener != null) recycleItemClickListener.onItemClick(getAdapterPosition());
        }
    }



    public  void setClickListener(RecycleItemClickListener recycleItemClickListener) {
        this.recycleItemClickListener = recycleItemClickListener;
    }


}