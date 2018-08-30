package findandfix.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import findandfix.R;

import findandfix.utils.ConfigurationFile;
import findandfix.utils.ValidationUtils;

/**
 * Created by DELL on 10/06/2018.
 */

public class FirstStepRegisterValidation extends BaseObservable{
    public ObservableField<String>emailError;
    public ObservableField<String>passwordError;
    public ObservableField<String>confirmPasswordError;
    private Context context;
    public FirstStepRegisterValidation(Context context) {
        emailError=new ObservableField<>();
        passwordError=new ObservableField<>();
        confirmPasswordError=new ObservableField<>();
        this.context=context;
    }

    public void setEmailError(String error){
        emailError.set(error);
    }

    public void setPasswordError(String error){
        passwordError.set(error);
    }

    public void setConfirmPasswordError(String error){
        confirmPasswordError.set(error);
    }

    public boolean validator(ObservableField<String> email,ObservableField<String> password,ObservableField<String> confirmpassword){
        if (email.get()!=null){
                emailError.set("");
            if (password.get()!=null){
                passwordError.set("");
               if (confirmpassword.get()!=null){
                   confirmPasswordError.set("");
                   if (ValidationUtils.isMail(email.get())){
                       emailError.set("");

                       if (password.get().length()>= ConfigurationFile.Constants.MINIMUM_PASSWORD_LENGTH){
                           passwordError.set("");
                           if (confirmpassword.get().length()>=ConfigurationFile.Constants.MINIMUM_PASSWORD_LENGTH){
                               confirmPasswordError.set("");
                               if (passwordError.get().equals(confirmPasswordError.get())){
                                   confirmPasswordError.set("");
                                   return true;

                               }else {
                                   confirmPasswordError.set(context.getString(R.string.password_confirm_not_match));
                               }

                           }else {
                               confirmPasswordError.set(context.getString(R.string.password_length));
                           }

                       }else {
                           passwordError.set(context.getString(R.string.password_length));
                       }

                   }else {
                       emailError.set(context.getString(R.string.invalid_email_format));
                   }

               }else {
                   confirmPasswordError.set(context.getResources().getString(R.string.required_field));
               }
            }else {
                passwordError.set(context.getResources().getString(R.string.required_field));
            }
        }else {
            emailError.set(context.getResources().getString(R.string.required_field));
        }
        return false;
    }
}
