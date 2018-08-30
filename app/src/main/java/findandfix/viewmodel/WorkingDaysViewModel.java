package findandfix.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import findandfix.R;
import findandfix.model.global.WorkDayItems;
import findandfix.utils.ConfigurationFile;
import findandfix.view.ui.callback.BaseInterface;
import findandfix.view.ui.callback.UpdateTimeListener;

/**
 * Created by DELL on 13/08/2018.
 */

public class WorkingDaysViewModel{
    public String current;
    public String previous;
    public ObservableField<String> dayName;
    public ObservableField<String>mFrom;
    public ObservableField<String>mTo;
    public ObservableField<String>eFrom;
    public ObservableField<String>eTo;
    private HashMap<String,WorkDayItems> days;
    private int code;
    private Context context;
    private BaseInterface baseInterface;
    private ArrayList<WorkDayItems>workingDays;
    public WorkingDaysViewModel(Context context, BaseInterface baseInterface,ArrayList<WorkDayItems>workingDays) {
        this.context=context;
        this.baseInterface=baseInterface;
        this.workingDays=workingDays;
        current="saturday";
        dayName=new ObservableField<>(context.getString(R.string.sa));
        days=new HashMap<String, WorkDayItems>();;
        mFrom=new ObservableField<>("00:00");
        eFrom=new ObservableField<>("00:00");
        mTo=new ObservableField<>("00:00");
        eTo=new ObservableField<>("00:00");
        convertListToMap();
        setData();
    }
    public void convertListToMap(){
        for (WorkDayItems i : workingDays) {
            days.put(i.getDay() + "_" + i.getShift(), i);
            System.out.println("Day Of Data :" + i.getDay() + "_" + i.getShift()+" "+i.getFrom()+" "+i.getTo());
        }
    }

    public void validate(View view){

        if (view.getId()== R.id.tv_sa){
            current="saturday";
            dayName.set(context.getString(R.string.sa));
        }else if (view.getId()== R.id.tv_su){
            current="sunday";
            dayName.set(context.getString(R.string.sع));
        }else if (view.getId()== R.id.tv_mo){
            current="monday";
            dayName.set(context.getString(R.string.Mo));
        }else if (view.getId()== R.id.tv_tue){
            current="tuesday";
            dayName.set(context.getString(R.string.Tue));
        }else if (view.getId()== R.id.tv_wed){
            current="wednesday";
            dayName.set(context.getString(R.string.Wed));
        }else if (view.getId()== R.id.tv_thu){
            current="thursday";
            dayName.set(context.getString(R.string.Thu));
        }else if (view.getId()== R.id.tv_fri){
            current="friday";
            dayName.set(context.getString(R.string.fri));
        }

        setData();
    }

    public void setData(){
        if (days.containsKey(current+"_morning")){
            mFrom.set(days.get(current+"_morning").getFrom());
            mTo.set(days.get(current+"_morning").getTo());
        }else {
            mFrom.set("00:00");
            mTo.set("00:00");
        }

        if (days.containsKey(current+"_night")){
                eFrom.set(days.get(current+"_night").getFrom());
                eTo.set(days.get(current+"_night").getTo());
            }else {
            eFrom.set("00:00");
            eTo.set("00:00");
        }

    }


}

