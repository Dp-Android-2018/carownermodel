package findandfix.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import java.util.Observable;

import findandfix.model.request.RegisterRequest;
import findandfix.utils.IntentConstants;
import findandfix.view.ui.activities.RegisterActivity2;
import findandfix.view.ui.callback.BaseInterface;


public class RegisterModelView extends Observable {

    public ObservableField<String> email;
    public ObservableField<String> password;
    public ObservableField<String> confirmPassword;

    private Context context;
    private BaseInterface callback;


    public RegisterModelView(Context context, BaseInterface callback) {
        this.context = context;
        this.callback = callback;
        initializeVariables();
    }

    public void initializeVariables() {
        email = new ObservableField<>();
        password = new ObservableField<>();
        confirmPassword = new ObservableField<>();
    }


    public void next(final View view) {
        Intent intent = new Intent(context, RegisterActivity2.class);
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail(email.get());
        registerRequest.setPassword(password.get());
        intent.putExtra(IntentConstants.REGISTER_MODEL,registerRequest);
        context.startActivity(intent);
    }

    public void reset() {
        context = null;
    }


}
