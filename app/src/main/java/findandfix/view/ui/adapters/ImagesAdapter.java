package findandfix.view.ui.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import findandfix.R;
import findandfix.view.ui.callback.RecycleItemClickListener;

public class ImagesAdapter  extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {

    private List<Bitmap> bitmaps;
    private LayoutInflater mInflater;
    private RecycleItemClickListener recycleItemClickListener;
    Context context;

    // data is passed into the constructor
    public ImagesAdapter(Context context, List<Bitmap> bitmaps) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.bitmaps = bitmaps;
    }

    // inflates the row layout from xml when needed
    @Override
    public ImagesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_image_layout, parent, false);
        return new ImagesAdapter.ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ImagesAdapter.ViewHolder holder, int position) {
        Bitmap bitmap = bitmaps.get(position);
        holder.image.setImageBitmap(bitmap);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return bitmaps.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        ImageView close;
        ViewHolder(View itemView) {
            super(itemView);
            close = itemView.findViewById(R.id.iv_close);
            image = itemView.findViewById(R.id.iv_image);
            close.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (recycleItemClickListener != null) recycleItemClickListener.onItemClick(getAdapterPosition());
        }
    }



    public  void setClickListener(RecycleItemClickListener recycleItemClickListener) {
        this.recycleItemClickListener = recycleItemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}