package findandfix.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;
import java.sql.Timestamp;
import java.util.Date;

import findandfix.R;
import findandfix.model.global.Conv.ConversationHistory;
import findandfix.utils.ConfigurationFile;
import findandfix.view.ui.activities.ChatActivity;

/**
 * Created by DELL on 09/05/2018.
 */

public class ItemConversationViewModel extends BaseObservable {

    private ConversationHistory history;
    private Context context;
    public ItemConversationViewModel(Context context, ConversationHistory history) {
        this.history=history;
        this.context=context;
    }

    public void setConversation(ConversationHistory history){
        this.history=history;
        notifyChange();
    }

    public String getUserName(){
        return history.getConversations().sender_name;
    }

    public String getLastMessage(){
        if(!history.getLastMessage().content.contains("app_photos"))
             return history.getLastMessage().content;
        else return context.getString(R.string.photo);
    }

    public String getTime(){
        Timestamp stamp = new Timestamp(history.getLastMessage().getTimestamp());
        Date date = new Date(stamp.getTime());
        return String.valueOf(date);
    }

    public void onItemClick(View view){
        Intent intent=new Intent(view.getContext(),ChatActivity.class);
        intent.putExtra("Conversation_Id",history);
        intent.putExtra(ConfigurationFile.IntentsConstants.DEVICE_TOKEN,history.getConversations().getDevice_token());
        context.startActivity(intent);
    }
}
