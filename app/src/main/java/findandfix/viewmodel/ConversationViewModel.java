package findandfix.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.view.View;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import findandfix.model.global.Conv.ConversationHistory;
import findandfix.model.global.Conv.ConversationsLocation;
import findandfix.model.global.Conv.LastMessage;
import findandfix.model.global.UserData;
import findandfix.utils.CustomUtils;

/**
 * Created by DELL on 09/05/2018.
 */

public class ConversationViewModel extends BaseObservable {
    private DatabaseReference reference;
    private List<ConversationsLocation> conversationsList;
    public ObservableList<ConversationHistory>histories;
    private String secondUserUrl;
    LastMessage lastMessage;
    private int stepNum=0;
    private UserData userData;
    public ObservableField<Integer> noData;
    public ObservableField<Integer> hasData;
    private ConversationHistory conversationHistory=null;
    public ConversationViewModel(Context context) {
        conversationsList=new ArrayList<>();
        userData= CustomUtils.getInstance().getSaveUserObject(context);
        histories=new ObservableArrayList<>();
        hasData=new ObservableField<>(View.GONE);
        noData=new ObservableField<>(View.VISIBLE);
        getUserConversation();

    }

    public void getUserConversation(){
        reference= FirebaseDatabase.getInstance().getReference("users/carowner-"+userData.getId());
        ChildEventListener childEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                String key=dataSnapshot.getRef().getKey();
                hasData.set(View.VISIBLE);
                noData.set(View.GONE);
                if(key.equals("conversations")){

                    for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                   //     System.out.println("Conv Key :"+);
                        ConversationsLocation conversationsLocation=(ConversationsLocation) dataSnapshot1.getValue(ConversationsLocation.class);
                        conversationsLocation.setSecondUserUrl(dataSnapshot1.getKey());
                        System.out.println("Chat Conv :+1"+conversationsLocation.location);
                        System.out.println("Chat Conv :+2"+conversationsLocation.sender_name);
                        System.out.println("Chat Conv :+4"+conversationsLocation.getDevice_token());
                        System.out.println("Chat Conv :+3"+conversationsLocation.getSecondUserUrl());
                        conversationsList.add(conversationsLocation);
                    }

                    getLastMessage();
                }


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        reference.addChildEventListener(childEventListener);
    }


    public void getLastMessage() {



        for (ConversationsLocation conversationsLocation : conversationsList) {
            lastMessage = new LastMessage();
            reference = FirebaseDatabase.getInstance().getReference("conversations/" + conversationsLocation.location);
            reference.child("last_message").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    if (dataSnapshot.getKey().equals("content")) {
                        lastMessage.content = dataSnapshot.getValue(String.class);
                        if (lastMessage.timestamp != null) {
                            conversationHistory = new ConversationHistory(lastMessage, conversationsLocation);
                            histories.add(conversationHistory);
                            lastMessage = new LastMessage();
                            conversationHistory = null;
                        }
                    } else if (dataSnapshot.getKey().equals("timestamp")) {
                        System.out.println("Conversation List Size Step Num :" + stepNum);
                        lastMessage.timestamp = dataSnapshot.getValue(Long.class);
                        if (lastMessage.content != null) {
                            conversationHistory = new ConversationHistory(lastMessage, conversationsLocation);
                            histories.add(conversationHistory);
                            lastMessage = new LastMessage();
                            conversationHistory = null;
                        }

                        System.out.println("History Size :" + histories.size());
                    }

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }
    }


}
