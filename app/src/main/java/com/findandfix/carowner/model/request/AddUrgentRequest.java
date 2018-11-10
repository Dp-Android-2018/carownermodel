package com.findandfix.carowner.model.request;

import java.util.HashMap;

/**
 * Created by DELL on 29/07/2018.
 */

public class AddUrgentRequest {
    HashMap<String,Object>fields;

    public HashMap<String, Object> getFields() {
        return fields;
    }

    public void setFields(HashMap<String, Object> fields) {
        this.fields = fields;
    }
}
