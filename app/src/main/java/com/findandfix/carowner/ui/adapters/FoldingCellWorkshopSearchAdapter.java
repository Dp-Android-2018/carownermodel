package com.findandfix.carowner.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.List;

import com.findandfix.carowner.R;
import com.findandfix.carowner.model.global.Conv.ConversationHistory;
import com.findandfix.carowner.model.global.Conv.ConversationsLocation;
import com.findandfix.carowner.model.global.RequestOfferObj;
import com.findandfix.carowner.model.global.UserData;
import com.findandfix.carowner.model.global.WorkshopSearchObj;
import com.findandfix.carowner.utils.ConfigurationFile;
import com.findandfix.carowner.utils.CustomUtils;
import com.findandfix.carowner.ui.activities.ChatActivity;
import com.findandfix.carowner.ui.activities.WorkingDaysActivity;
import com.findandfix.carowner.ui.callback.AchievmentItemClickListener;
import com.findandfix.carowner.ui.callback.PhoneCallListener;
import com.findandfix.carowner.ui.callback.RecycleItemClickListener;

/**
 * Created by DELL on 15/08/2018.
 */

public class FoldingCellWorkshopSearchAdapter extends ArrayAdapter<WorkshopSearchObj> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;
    private PhoneCallListener phoneCallListener;
    private AchievmentItemClickListener achievmentItemClickListener;
    private Context context;
    private UserData userData;
    public FoldingCellWorkshopSearchAdapter(Context context, List<WorkshopSearchObj> objects) {
        super(context, 0, objects);
        userData= CustomUtils.getInstance().getSaveUserObject(context);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // get item for selected view
        WorkshopSearchObj item = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        FoldingCellWorkshopSearchAdapter.ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new FoldingCellWorkshopSearchAdapter.ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.workshop_cell_search_layout, parent, false);
         //   viewHolder.date = cell.findViewById(R.id.title_date_label);
          viewHolder.fromAddress = cell.findViewById(R.id.title_from_address);
           viewHolder.requestsCount = cell.findViewById(R.id.title_requests_count);
            viewHolder.ratingBar=cell.findViewById(R.id.rating);
            viewHolder.normalRequestNormal=cell.findViewById(R.id.title_normal_request_num);
            viewHolder.urgentRequestNum=cell.findViewById(R.id.title_urgent_request_num);
            viewHolder.distanceContent=cell.findViewById(R.id.tv_distance_content);
            viewHolder.normalRequestnumContent=cell.findViewById(R.id.tv_normal_request_num_content);
            viewHolder.urgentRequestnumContent=cell.findViewById(R.id.tv_urgent_request_num_content);
            viewHolder.workshopNameContent=cell.findViewById(R.id.tv_workshop_name_content);
            viewHolder.rateContent=cell.findViewById(R.id.rating_content);
            viewHolder.rateTextContent=cell.findViewById(R.id.tv_rate_value_content);
            viewHolder.achievments=cell.findViewById(R.id.tv_achievments_text);
            viewHolder.workingDays=cell.findViewById(R.id.tv_working_time_text);
            viewHolder.ivChat=cell.findViewById(R.id.iv_message);
            viewHolder.ivCall=cell.findViewById(R.id.iv_phone);
            viewHolder.ivLocation=cell.findViewById(R.id.iv_location);
          //  viewHolder.acceptOffer=cell.findViewById(R.id.tv_accept_offer_text);

            cell.setTag(viewHolder);
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (FoldingCellWorkshopSearchAdapter.ViewHolder) cell.getTag();
        }

        if (null == item)
            return cell;
//        viewHolder.date.setText(R.string.today);
       viewHolder.fromAddress.setText(item.getName());
       viewHolder.ratingBar.setRating(item.getRate()==null? 0: Float.parseFloat(item.getRate()));
       viewHolder.requestsCount.setText(item.getDistance()==null? " 0 " +context.getString(R.string.km):String.valueOf(new DecimalFormat("##.##").format(Double.parseDouble(item.getDistance())))+context.getString(R.string.km));
        viewHolder.normalRequestNormal.setText(String.valueOf(item.getNormalRequestCount()));
        viewHolder.urgentRequestNum.setText(String.valueOf(item.getUrgentRequestCount()));

        viewHolder.distanceContent.setText(item.getDistance()==null? " 0 " +context.getString(R.string.km):String.valueOf(new DecimalFormat("##.##").format(Double.parseDouble(item.getDistance())))+context.getString(R.string.km));
        viewHolder.normalRequestnumContent.setText(String.valueOf(item.getNormalRequestCount()));
        viewHolder.urgentRequestnumContent.setText(String.valueOf(item.getUrgentRequestCount()));
        viewHolder.workshopNameContent.setText(item.getName());
        viewHolder.rateContent.setRating(item.getRate()==null? 0: Float.parseFloat(item.getRate()));
        if (item.getRate()!=null)
            viewHolder.rateTextContent.setText("("+item.getRate()+") "+context.getString(R.string.rate_label));

        /*viewHolder.acceptOffer.setOnClickListener(v -> {

        });*/

        viewHolder.achievments.setOnClickListener(v -> {
            if (achievmentItemClickListener!=null)
                achievmentItemClickListener.onItemClick(item.getId());
        });

        viewHolder.workingDays.setOnClickListener(v -> {
            System.out.println("Working Days Size :"+item.getWorkdays().size());
            Intent i=new Intent(context, WorkingDaysActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.putExtra(ConfigurationFile.IntentsConstants.WORKING_DAYS_TAG,item.getWorkdays());
            context.startActivity(i);
        });

        viewHolder.ivChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConversationsLocation conversationsLocation=new ConversationsLocation();
                conversationsLocation.setSecondUserUrl("workshop-"+item.getId());
                conversationsLocation.sender_name=item.getName();
                conversationsLocation.location="FAF"+item.getId()+"-"+userData.getId();

                ConversationHistory conversationHistory=new ConversationHistory(null,conversationsLocation);
                Intent i=new Intent(context,ChatActivity.class);
                i.putExtra("Conversation_Id",conversationHistory);
                i.putExtra(ConfigurationFile.IntentsConstants.DEVICE_TOKEN,item.getDeviceToken());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

        viewHolder.ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?daddr=" + item.getLatitude() + "," + item.getLongitude()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        viewHolder.ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    phoneCallListener.onPhoneCall(item.getMobile());
            }
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
        TextView fromAddress;
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
        TextView achievments;
        TextView workingDays;
        ImageView ivChat;
        ImageView ivCall;
        ImageView ivLocation;
        //TextView acceptOffer;
    }

   public void setPhoneCallListener(PhoneCallListener listener){
        this.phoneCallListener=listener;
   }

    public void setAchievmentItemClickListener(AchievmentItemClickListener achievmentItemClickListener){
        this.achievmentItemClickListener=achievmentItemClickListener;
    }
}
