package findandfix.view.ui.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import findandfix.R;
import findandfix.databinding.ItemChatLayoutBinding;

import findandfix.model.global.Conv.Message;
import findandfix.view.ui.holder.ConversationDetailHolder;

/**
 * Created by DELL on 13/05/2018.
 */

public class ConversationDetailAdapter extends RecyclerView.Adapter<ConversationDetailHolder> {
    private ObservableList<Message> history;
    public ConversationDetailAdapter(ObservableList<Message> history) {
        this.history=history;
    }

    @NonNull
    @Override
    public ConversationDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChatLayoutBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_chat_layout,parent,false);
        return new ConversationDetailHolder(binding);
    }



    @Override
    public void onBindViewHolder(@NonNull ConversationDetailHolder holder, int position) {
        holder.bindConversationDetail(history.get(position));
    }

    @Override
    public int getItemCount() {
        return history.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
