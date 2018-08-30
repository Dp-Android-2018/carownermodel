package findandfix.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import findandfix.R;
import findandfix.utils.ConfigurationFile;
import findandfix.view.ui.activities.ChatActivity;
import findandfix.view.ui.activities.FindRequestsActivity;
import findandfix.view.ui.activities.MainActivity;
import findandfix.view.ui.activities.MyConversationsActivity;
import findandfix.view.ui.activities.UrgentOffersActivity;
import findandfix.view.ui.activities.WaitingOffersUrgentActivity;
import findandfix.view.ui.activities.WorkShopOffersActivity;


public class FirebaseMessageService extends FirebaseMessagingService {

    Context context;

    // Handler handler =null;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        try {
          context = this;
            System.out.println("Notification Log Title:"+remoteMessage.getNotification().getTitle());
            System.out.println("Notification Log Body:"+remoteMessage.getNotification().getBody());
            System.out.println("Notification Log Data :"+remoteMessage.getData());
            Map<String , String> map=remoteMessage.getData();
            for (Map.Entry<String, String> entry : map.entrySet())
            {
                System.out.println("Notification Log Data :"+entry.getKey() + "/" + entry.getValue());
            }

            if (map.size()>0) {
                Intent i=null;
                if (map.containsKey("title")){
                    if (map.get("title").equals("urgent-request-offer")) {
                    if (WaitingOffersUrgentActivity.active) {
                        Intent intent = new Intent("CLOSE_ALL");
                        this.sendBroadcast(intent);
                    } else {
                        i = new Intent(context, UrgentOffersActivity.class);
                        i.putExtra(ConfigurationFile.IntentsConstants.REQUEST_ID, 100);
                        Notify(i, remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
                    }
                }else if (map.get("title").equals("urgent-request-completed")){
                        i = new Intent(context, MainActivity.class);
                        Notify(i, remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
                    }else if (map.get("title").equals("account-activated")){
                        Intent intent = new Intent("account_activated");
                        this.sendBroadcast(intent);
                    }
                }else if (map.containsKey("noti_title")){

                    if (map.get("noti_title").equals("new_message")){
                        if (ChatActivity.active){

                        }else {
                             i = new Intent(context, MyConversationsActivity.class);
                            Notify(i, remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
                        }
                    } else if (map.get("noti_title").equals("new_offer")) {
                        if (FindRequestsActivity.active){
                            Intent intent = new Intent("CLOSE_ALL");
                            intent.putExtra(ConfigurationFile.IntentsConstants.REQUEST_ID, Integer.parseInt(map.get("request_id")));
                            this.sendBroadcast(intent);
                        }else {
                            i = new Intent(context, WorkShopOffersActivity.class);
                            i.putExtra(ConfigurationFile.IntentsConstants.REQUEST_ID, Integer.parseInt(map.get("request_id")));
                            Notify(i,remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
                        }
                    }else if (map.get("noti_title").equals("complete_fixing")) {
                        i = new Intent(context, MainActivity.class);
                        i.putExtra(ConfigurationFile.IntentsConstants.WORKSHOP_ID,Integer.parseInt(map.get("workshop_id")));
                        i.putExtra(ConfigurationFile.IntentsConstants.WORKSHOP_NAME,map.get("workshop_name"));
                        Notify(i,remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
                    }

                }

            }
       /*   Notify(null,"123","456");*/

        } catch (Exception e) {
            System.out.println("Notification Log in firebaseMesage : " + e.getMessage());
        }
    }


    public void Notify(Intent intent, String messageTitle, String nb) {
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* request code */, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        long[] pattern = {500, 500, 500, 500, 500};

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_find_fix_logo)
                .setContentTitle(messageTitle)
                .setContentText(nb)
                .setAutoCancel(true)
                .setVibrate(pattern)
                .setLights(Color.BLUE, 1, 1)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationManager.IMPORTANCE_HIGH);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
}


