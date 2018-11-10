package com.findandfix.carowner.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import com.findandfix.carowner.R;
import com.findandfix.carowner.ui.callback.RecycleItemClickListener;

/**
 * Created by mohamedatef on 5/5/18.
 */

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.ViewHolder> {

    private List<com.findandfix.carowner.model.global.CountryItem> countryItems;
    private LayoutInflater mInflater;
    private RecycleItemClickListener recycleItemClickListener;
    Context context;

    // data is passed into the constructor
    public CountriesAdapter(Context context, List<com.findandfix.carowner.model.global.CountryItem> countryItems) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.countryItems = countryItems;
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
        com.findandfix.carowner.model.global.CountryItem countryItem = countryItems.get(position);
        holder.title.setText(countryItem.getName());
        System.out.println("Path Image :"+"http://new.findandfix.com/"+countryItem.getImage());
        Picasso.with(context).load("http://new.findandfix.com/"+countryItem.getImage()).into(holder.image);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return countryItems.size();
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