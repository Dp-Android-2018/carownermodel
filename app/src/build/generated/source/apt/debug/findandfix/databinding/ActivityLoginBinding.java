package findandfix.databinding;
import com.findandfix.carowner.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityLoginBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    public final android.widget.Button btnLoginEnter;
    @NonNull
    public final android.widget.EditText etRegisterEmail;
    @NonNull
    public final android.widget.EditText etRegisterPassword;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    public final android.widget.ProgressBar progressBar;
    @NonNull
    public final android.widget.RelativeLayout rlParent;
    // variables
    @Nullable
    private com.findandfix.carowner.viewmodel.LoginViewModel mLoginViewModel;
    // values
    // listeners
    private OnClickListenerImpl mLoginViewModelCheckLoginAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mLoginViewModelMoveToRegisterActAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener etRegisterEmailandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of LoginViewModel.email.get()
            //         is LoginViewModel.email.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(etRegisterEmail);
            // localize variables for thread safety
            // LoginViewModel
            com.findandfix.carowner.viewmodel.LoginViewModel loginViewModel = mLoginViewModel;
            // LoginViewModel.email != null
            boolean loginViewModelEmailJavaLangObjectNull = false;
            // LoginViewModel != null
            boolean loginViewModelJavaLangObjectNull = false;
            // LoginViewModel.email.get()
            java.lang.String loginViewModelEmailGet = null;
            // LoginViewModel.email
            android.databinding.ObservableField<java.lang.String> loginViewModelEmail = null;



            loginViewModelJavaLangObjectNull = (loginViewModel) != (null);
            if (loginViewModelJavaLangObjectNull) {


                loginViewModelEmail = loginViewModel.email;

                loginViewModelEmailJavaLangObjectNull = (loginViewModelEmail) != (null);
                if (loginViewModelEmailJavaLangObjectNull) {




                    loginViewModelEmail.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener etRegisterPasswordandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of LoginViewModel.password.get()
            //         is LoginViewModel.password.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(etRegisterPassword);
            // localize variables for thread safety
            // LoginViewModel
            com.findandfix.carowner.viewmodel.LoginViewModel loginViewModel = mLoginViewModel;
            // LoginViewModel.password.get()
            java.lang.String loginViewModelPasswordGet = null;
            // LoginViewModel != null
            boolean loginViewModelJavaLangObjectNull = false;
            // LoginViewModel.password
            android.databinding.ObservableField<java.lang.String> loginViewModelPassword = null;
            // LoginViewModel.password != null
            boolean loginViewModelPasswordJavaLangObjectNull = false;



            loginViewModelJavaLangObjectNull = (loginViewModel) != (null);
            if (loginViewModelJavaLangObjectNull) {


                loginViewModelPassword = loginViewModel.password;

                loginViewModelPasswordJavaLangObjectNull = (loginViewModelPassword) != (null);
                if (loginViewModelPasswordJavaLangObjectNull) {




                    loginViewModelPassword.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityLoginBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 3);
        final Object[] bindings = mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds);
        this.btnLoginEnter = (android.widget.Button) bindings[3];
        this.btnLoginEnter.setTag(null);
        this.etRegisterEmail = (android.widget.EditText) bindings[1];
        this.etRegisterEmail.setTag(null);
        this.etRegisterPassword = (android.widget.EditText) bindings[2];
        this.etRegisterPassword.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.progressBar = (android.widget.ProgressBar) bindings[5];
        this.progressBar.setTag(null);
        this.rlParent = (android.widget.RelativeLayout) bindings[0];
        this.rlParent.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.LoginViewModel == variableId) {
            setLoginViewModel((com.findandfix.carowner.viewmodel.LoginViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setLoginViewModel(@Nullable com.findandfix.carowner.viewmodel.LoginViewModel LoginViewModel) {
        this.mLoginViewModel = LoginViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.LoginViewModel);
        super.requestRebind();
    }
    @Nullable
    public com.findandfix.carowner.viewmodel.LoginViewModel getLoginViewModel() {
        return mLoginViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeLoginViewModelEmail((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeLoginViewModelPassword((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeLoginViewModelProgressDialog((android.databinding.ObservableInt) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLoginViewModelEmail(android.databinding.ObservableField<java.lang.String> LoginViewModelEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLoginViewModelPassword(android.databinding.ObservableField<java.lang.String> LoginViewModelPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLoginViewModelProgressDialog(android.databinding.ObservableInt LoginViewModelProgressDialog, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String loginViewModelEmailGet = null;
        java.lang.String loginViewModelPasswordGet = null;
        int loginViewModelProgressDialogGet = 0;
        android.databinding.ObservableField<java.lang.String> loginViewModelEmail = null;
        android.view.View.OnClickListener loginViewModelCheckLoginAndroidViewViewOnClickListener = null;
        android.databinding.ObservableField<java.lang.String> loginViewModelPassword = null;
        android.databinding.ObservableInt loginViewModelProgressDialog = null;
        com.findandfix.carowner.viewmodel.LoginViewModel loginViewModel = mLoginViewModel;
        android.view.View.OnClickListener loginViewModelMoveToRegisterActAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (loginViewModel != null) {
                        // read LoginViewModel.email
                        loginViewModelEmail = loginViewModel.email;
                    }
                    updateRegistration(0, loginViewModelEmail);


                    if (loginViewModelEmail != null) {
                        // read LoginViewModel.email.get()
                        loginViewModelEmailGet = loginViewModelEmail.get();
                    }
            }
            if ((dirtyFlags & 0x18L) != 0) {

                    if (loginViewModel != null) {
                        // read LoginViewModel::checkLogin
                        loginViewModelCheckLoginAndroidViewViewOnClickListener = (((mLoginViewModelCheckLoginAndroidViewViewOnClickListener == null) ? (mLoginViewModelCheckLoginAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mLoginViewModelCheckLoginAndroidViewViewOnClickListener).setValue(loginViewModel));
                        // read LoginViewModel::moveToRegisterAct
                        loginViewModelMoveToRegisterActAndroidViewViewOnClickListener = (((mLoginViewModelMoveToRegisterActAndroidViewViewOnClickListener == null) ? (mLoginViewModelMoveToRegisterActAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mLoginViewModelMoveToRegisterActAndroidViewViewOnClickListener).setValue(loginViewModel));
                    }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (loginViewModel != null) {
                        // read LoginViewModel.password
                        loginViewModelPassword = loginViewModel.password;
                    }
                    updateRegistration(1, loginViewModelPassword);


                    if (loginViewModelPassword != null) {
                        // read LoginViewModel.password.get()
                        loginViewModelPasswordGet = loginViewModelPassword.get();
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (loginViewModel != null) {
                        // read LoginViewModel.progressDialog
                        loginViewModelProgressDialog = loginViewModel.progressDialog;
                    }
                    updateRegistration(2, loginViewModelProgressDialog);


                    if (loginViewModelProgressDialog != null) {
                        // read LoginViewModel.progressDialog.get()
                        loginViewModelProgressDialogGet = loginViewModelProgressDialog.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            this.btnLoginEnter.setOnClickListener(loginViewModelCheckLoginAndroidViewViewOnClickListener);
            this.mboundView4.setOnClickListener(loginViewModelMoveToRegisterActAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.etRegisterEmail, loginViewModelEmailGet);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etRegisterEmail, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etRegisterEmailandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etRegisterPassword, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etRegisterPasswordandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.etRegisterPassword, loginViewModelPasswordGet);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            this.progressBar.setVisibility(loginViewModelProgressDialogGet);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.LoginViewModel value;
        public OnClickListenerImpl setValue(com.findandfix.carowner.viewmodel.LoginViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.checkLogin(arg0);
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.LoginViewModel value;
        public OnClickListenerImpl1 setValue(com.findandfix.carowner.viewmodel.LoginViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.moveToRegisterAct(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityLoginBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityLoginBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityLoginBinding>inflate(inflater, findandfix.R.layout.activity_login, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityLoginBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityLoginBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.activity_login, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityLoginBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityLoginBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_login_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityLoginBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): LoginViewModel.email
        flag 1 (0x2L): LoginViewModel.password
        flag 2 (0x3L): LoginViewModel.progressDialog
        flag 3 (0x4L): LoginViewModel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}