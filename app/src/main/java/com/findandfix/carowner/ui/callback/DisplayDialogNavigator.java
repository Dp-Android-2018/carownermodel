package com.findandfix.carowner.ui.callback;

import com.google.android.gms.fido.u2f.api.common.RegisterRequest;

/**
 * Created by DELL on 24/03/2018.
 */

public interface DisplayDialogNavigator extends BaseInterface{

    public void NavigateBetweenActivities(RegisterRequest registerRequest, int code);
}
