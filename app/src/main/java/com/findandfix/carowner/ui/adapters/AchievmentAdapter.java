package com.findandfix.carowner.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import com.findandfix.carowner.R;
import com.findandfix.carowner.model.global.AchievmentObj;
import com.findandfix.carowner.ui.holder.AchievmentHolder;

public class AchievmentAdapter extends RecyclerView.Adapter<AchievmentHolder> {
   private List<AchievmentObj>achievmentObjs;

    public AchievmentAdapter(List<AchievmentObj> achievmentObjs) {
        this.achievmentObjs=achievmentObjs;
    }

    @NonNull
    @Override
    public AchievmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_achievment_layout,parent,false);
        return new AchievmentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AchievmentHolder holder, int position) {
            holder.bindAchievment(achievmentObjs.get(position));
    }

    @Override
    public int getItemCount() {
        return achievmentObjs.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
