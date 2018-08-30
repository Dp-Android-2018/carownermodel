package findandfix.model.global.Conv;

import java.io.Serializable;

/**
 * Created by DELL on 10/04/2018.
 */

public class ConversationsLocation implements Serializable{
    public String location;
    public String sender_name;
    private String secondUserUrl;
    private String device_token;
    public ConversationsLocation(){}
    public ConversationsLocation(String location,String sender_name,String device_token) {
        this.location = location;
        this.sender_name=sender_name;
    this.device_token=device_token;}

    public void setSecondUserUrl(String secondUserUrl){
        this.secondUserUrl=secondUserUrl;
    }

    public void setDeviceToken(String deviceToken){
        this.device_token=deviceToken;
    }

    public String getSecondUserUrl() {
        return secondUserUrl;
    }

    public String getLocation() {
        return location;
    }

    public String getSender_name() {
        return sender_name;
    }

    public String getDevice_token() {
        return device_token;
    }
}
