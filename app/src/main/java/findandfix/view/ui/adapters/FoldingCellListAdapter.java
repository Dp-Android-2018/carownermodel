package findandfix.view.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ramotion.foldingcell.FoldingCell;

import java.util.HashSet;
import java.util.List;

import findandfix.R;
import findandfix.model.global.RequestOfferObj;
import findandfix.utils.ConfigurationFile;
import findandfix.view.ui.activities.WorkingDaysActivity;
import findandfix.view.ui.activities.WorkshopProfileImagesActivity;
import findandfix.view.ui.callback.AchievmentItemClickListener;
import findandfix.view.ui.callback.RecycleItemClickListener;

/**
 * Simple example of ListAdapter for using with Folding Cell
 * Adapter holds indexes of unfolded elements for correct work with default reusable views behavior
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FoldingCellListAdapter extends ArrayAdapter<RequestOfferObj> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;
    private RecycleItemClickListener recycleItemClickListener;
    private AchievmentItemClickListener achievmentItemClickListener;
    private Context context;

    public FoldingCellListAdapter(Context context, List<RequestOfferObj> objects) {
        super(context, 0, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // get item for selected view
        RequestOfferObj item = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);
            // binding view parts to view holder
            viewHolder.price = cell.findViewById(R.id.title_price);
            viewHolder.time = cell.findViewById(R.id.title_time_label);
            viewHolder.date = cell.findViewById(R.id.title_date_label);
            viewHolder.fromAddress = cell.findViewById(R.id.title_from_address);
            viewHolder.requestsCount = cell.findViewById(R.id.title_requests_count);
            viewHolder.ratingBar = cell.findViewById(R.id.rating);
            viewHolder.normalRequestNormal = cell.findViewById(R.id.title_normal_request_num);
            viewHolder.urgentRequestNum = cell.findViewById(R.id.title_urgent_request_num);
            viewHolder.distanceContent = cell.findViewById(R.id.tv_distance_content);
            viewHolder.normalRequestnumContent = cell.findViewById(R.id.tv_normal_request_num_content);
            viewHolder.urgentRequestnumContent = cell.findViewById(R.id.tv_urgent_request_num_content);
            viewHolder.workshopNameContent = cell.findViewById(R.id.tv_workshop_name_content);
            viewHolder.rateContent = cell.findViewById(R.id.rating_content);
            viewHolder.rateTextContent = cell.findViewById(R.id.tv_rate_value_content);
            viewHolder.descContent = cell.findViewById(R.id.tv_desc_content);
            viewHolder.avgPriceContent = cell.findViewById(R.id.tv_price_value_content);
            viewHolder.avgTimeContent = cell.findViewById(R.id.tv_avg_time_value_content);
            viewHolder.offerTimeContent = cell.findViewById(R.id.tv_offer_time_value_content);
            viewHolder.achievments = cell.findViewById(R.id.tv_achievments_text);
            viewHolder.workingDays = cell.findViewById(R.id.tv_working_time_text);
            viewHolder.acceptOffer = cell.findViewById(R.id.tv_accept_offer_text);
            viewHolder.profilePictures = cell.findViewById(R.id.tv_workshop_profile_pics);

            cell.setTag(viewHolder);
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }

        if (null == item)
            return cell;

        // bind data from selected element to view through view holder
        viewHolder.price.setText(String.valueOf(item.getCostFrom()) + ":" + String.valueOf(item.getCostTo()));
        viewHolder.time.setText(String.valueOf(item.getDurationFrom()) + ":" + String.valueOf(item.getDurationTo()));
        viewHolder.date.setText(R.string.today);
        viewHolder.fromAddress.setText(item.getWorkshop().getName());
        viewHolder.ratingBar.setRating(item.getRate() == null ? 0 : Float.parseFloat(item.getRate()));
        viewHolder.requestsCount.setText(item.getDistance() == null ? " 0 " + context.getString(R.string.km) : String.valueOf(item.getDistance()) + context.getString(R.string.km));
        viewHolder.normalRequestNormal.setText(String.valueOf(item.getNormalRequestsCount()));
        viewHolder.urgentRequestNum.setText(String.valueOf(item.getUrgentRequestsCount()));

        viewHolder.distanceContent.setText(item.getDistance() == null ? " 0 " + context.getString(R.string.km) : String.valueOf(item.getDistance()) + context.getString(R.string.km));
        viewHolder.normalRequestnumContent.setText(String.valueOf(item.getNormalRequestsCount()));
        viewHolder.urgentRequestnumContent.setText(String.valueOf(item.getUrgentRequestsCount()));
        viewHolder.workshopNameContent.setText(item.getWorkshop().getName());
        viewHolder.rateContent.setRating(item.getRate() == null ? 0 : Float.parseFloat(item.getRate()));
        if (item.getRate() != null)
            viewHolder.rateTextContent.setText("(" + item.getRate() + ") " + context.getString(R.string.rate_label));

        viewHolder.descContent.setText(item.getDescription() == null ? context.getString(R.string.no_desc) : item.getDescription());
        viewHolder.avgPriceContent.setText(String.valueOf(item.getCostFrom()) + ":" + String.valueOf(item.getCostTo()));
        viewHolder.avgTimeContent.setText(String.valueOf(item.getDurationFrom()) + ":" + String.valueOf(item.getDurationTo()));
        viewHolder.offerTimeContent.setText(item.getDate());
        viewHolder.acceptOffer.setOnClickListener(v -> {
            if (recycleItemClickListener != null)
                recycleItemClickListener.getWorkshopOffer(item);
        });

        viewHolder.achievments.setOnClickListener(v -> {
            if (achievmentItemClickListener != null)
                achievmentItemClickListener.onItemClick(item.getWorkshop().getId());
        });

        viewHolder.profilePictures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Workshop Obj Data :"+new Gson().toJson(item.getWorkshop()));
                Intent i = new Intent(context, WorkshopProfileImagesActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra(ConfigurationFile.IntentsConstants.WORKSHOP_PROFILE_IMAGES_TAG, item.getWorkshop().getWorkshopProfileImages());
                context.startActivity(i);
            }
        });

        viewHolder.workingDays.setOnClickListener(v -> {
            Intent i = new Intent(context, WorkingDaysActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.putExtra(ConfigurationFile.IntentsConstants.WORKING_DAYS_TAG, item.getWorkshop().getWorkdays());
            context.startActivity(i);
        });
        return cell;
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView price;
        //TextView contentRequestBtn;

        TextView fromAddress;
        //  TextView toAddress;
        TextView requestsCount;
        RatingBar ratingBar;
        TextView date;
        TextView time;
        TextView normalRequestNormal;
        TextView urgentRequestNum;
        TextView distanceContent;
        TextView normalRequestnumContent;
        TextView urgentRequestnumContent;
        TextView workshopNameContent;
        RatingBar rateContent;
        TextView rateTextContent;
        TextView descContent;
        TextView avgPriceContent;
        TextView avgTimeContent;
        TextView offerTimeContent;
        TextView achievments;
        TextView workingDays;
        TextView profilePictures;
        TextView acceptOffer;
    }

    public void setListener(RecycleItemClickListener recycleItemClickListener) {
        this.recycleItemClickListener = recycleItemClickListener;
    }

    public void setAchievmentItemClickListener(AchievmentItemClickListener achievmentItemClickListener) {
        this.achievmentItemClickListener = achievmentItemClickListener;
    }
}
