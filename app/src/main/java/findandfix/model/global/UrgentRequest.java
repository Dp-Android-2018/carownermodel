package findandfix.model.global;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class UrgentRequest implements Serializable{

    @SerializedName("lat")
    private String lat;

    @SerializedName("lng")
    private String lng;

    @SerializedName("notes")
    private String notes;

    @SerializedName("voice_notes")
    private String voiceNotes;

    @SerializedName("winch_types")
    private List<Integer> winchType;


    @SerializedName("type_id")
    private int typeId;

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setVoiceNotes(String voiceNotes) {
        this.voiceNotes = voiceNotes;
    }

    public void setWinchType(List<Integer> winchType) {
        this.winchType = winchType;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getNotes() {
        return notes;
    }

    public String getVoiceNotes() {
        return voiceNotes;
    }

    public List<Integer> getWinchType() {
        return winchType;
    }

    public int getTypeId() {
        return typeId;
    }
}
