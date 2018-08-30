package findandfix.view.ui.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import java.util.List;

import findandfix.R;
import findandfix.databinding.ItemCompletedRequestLayoutBinding;
import findandfix.model.global.RequestData;
import findandfix.view.ui.holder.CompletedRequestHolder;

/**
 * Created by DELL on 27/03/2018.
 */

public class RequestsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<RequestData> requests;
    private int checker;
    public RequestsAdapter(ObservableList<RequestData>requests, int checker) {
        this.requests=requests;
        this.checker=checker;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       if(checker==4){
            ItemCompletedRequestLayoutBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_completed_request_layout,parent,false);
            return new CompletedRequestHolder(binding);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(checker==4){
            CompletedRequestHolder completedRequestHolder=(CompletedRequestHolder)holder;
            completedRequestHolder.BindRequest(requests.get(position));
        }

    }

    @Override
    public int getItemCount() {
        System.out.println("Requests Binding:"+requests.size());
        return requests.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
