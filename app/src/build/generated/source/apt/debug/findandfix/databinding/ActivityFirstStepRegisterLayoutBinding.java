package findandfix.databinding;
import findandfix.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityFirstStepRegisterLayoutBinding extends android.databinding.ViewDataBinding  {

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
    public final android.widget.EditText etSignUpCarOwnerConfirmPassword;
    @NonNull
    public final android.widget.EditText etSignUpCarOwnerEmail;
    @NonNull
    public final android.widget.EditText etSignUpCarOwnerPassword;
    @NonNull
    public final android.support.design.widget.TextInputLayout inputLayoutSignUpConfirmPassword;
    @NonNull
    public final android.support.design.widget.TextInputLayout inputLayoutSignUpEmail;
    @NonNull
    public final android.support.design.widget.TextInputLayout inputLayoutSignUpPassword;
    @NonNull
    private final android.widget.ProgressBar mboundView1;
    @NonNull
    public final android.widget.RelativeLayout rlParent;
    // variables
    @Nullable
    private findandfix.viewmodel.RegisterViewModel mRegisterModelView;
    @Nullable
    private findandfix.viewmodel.FirstStepRegisterValidation mValidator;
    // values
    // listeners
    private AfterTextChangedImpl mRegisterModelViewOnPasswordChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private OnClickListenerImpl mRegisterModelViewValidatorAndroidViewViewOnClickListener;
    private AfterTextChangedImpl1 mRegisterModelViewOnEmailChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    private AfterTextChangedImpl2 mRegisterModelViewOnConfirmPasswordChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged;
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener etSignUpCarOwnerConfirmPasswordandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of RegisterModelView.confirmPassword.get()
            //         is RegisterModelView.confirmPassword.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(etSignUpCarOwnerConfirmPassword);
            // localize variables for thread safety
            // RegisterModelView
            findandfix.viewmodel.RegisterViewModel registerModelView = mRegisterModelView;
            // RegisterModelView.confirmPassword
            android.databinding.ObservableField<java.lang.String> registerModelViewConfirmPassword = null;
            // RegisterModelView.confirmPassword.get()
            java.lang.String registerModelViewConfirmPasswordGet = null;
            // RegisterModelView != null
            boolean registerModelViewJavaLangObjectNull = false;
            // RegisterModelView.confirmPassword != null
            boolean registerModelViewConfirmPasswordJavaLangObjectNull = false;



            registerModelViewJavaLangObjectNull = (registerModelView) != (null);
            if (registerModelViewJavaLangObjectNull) {


                registerModelViewConfirmPassword = registerModelView.confirmPassword;

                registerModelViewConfirmPasswordJavaLangObjectNull = (registerModelViewConfirmPassword) != (null);
                if (registerModelViewConfirmPasswordJavaLangObjectNull) {




                    registerModelViewConfirmPassword.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener etSignUpCarOwnerEmailandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of RegisterModelView.email.get()
            //         is RegisterModelView.email.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(etSignUpCarOwnerEmail);
            // localize variables for thread safety
            // RegisterModelView
            findandfix.viewmodel.RegisterViewModel registerModelView = mRegisterModelView;
            // RegisterModelView.email.get()
            java.lang.String registerModelViewEmailGet = null;
            // RegisterModelView != null
            boolean registerModelViewJavaLangObjectNull = false;
            // RegisterModelView.email != null
            boolean registerModelViewEmailJavaLangObjectNull = false;
            // RegisterModelView.email
            android.databinding.ObservableField<java.lang.String> registerModelViewEmail = null;



            registerModelViewJavaLangObjectNull = (registerModelView) != (null);
            if (registerModelViewJavaLangObjectNull) {


                registerModelViewEmail = registerModelView.email;

                registerModelViewEmailJavaLangObjectNull = (registerModelViewEmail) != (null);
                if (registerModelViewEmailJavaLangObjectNull) {




                    registerModelViewEmail.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener etSignUpCarOwnerPasswordandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of RegisterModelView.password.get()
            //         is RegisterModelView.password.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(etSignUpCarOwnerPassword);
            // localize variables for thread safety
            // RegisterModelView
            findandfix.viewmodel.RegisterViewModel registerModelView = mRegisterModelView;
            // RegisterModelView.password
            android.databinding.ObservableField<java.lang.String> registerModelViewPassword = null;
            // RegisterModelView != null
            boolean registerModelViewJavaLangObjectNull = false;
            // RegisterModelView.password.get()
            java.lang.String registerModelViewPasswordGet = null;
            // RegisterModelView.password != null
            boolean registerModelViewPasswordJavaLangObjectNull = false;



            registerModelViewJavaLangObjectNull = (registerModelView) != (null);
            if (registerModelViewJavaLangObjectNull) {


                registerModelViewPassword = registerModelView.password;

                registerModelViewPasswordJavaLangObjectNull = (registerModelViewPassword) != (null);
                if (registerModelViewPasswordJavaLangObjectNull) {




                    registerModelViewPassword.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityFirstStepRegisterLayoutBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 8);
        final Object[] bindings = mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds);
        this.btnLoginEnter = (android.widget.Button) bindings[8];
        this.btnLoginEnter.setTag(null);
        this.etSignUpCarOwnerConfirmPassword = (android.widget.EditText) bindings[7];
        this.etSignUpCarOwnerConfirmPassword.setTag(null);
        this.etSignUpCarOwnerEmail = (android.widget.EditText) bindings[3];
        this.etSignUpCarOwnerEmail.setTag(null);
        this.etSignUpCarOwnerPassword = (android.widget.EditText) bindings[5];
        this.etSignUpCarOwnerPassword.setTag(null);
        this.inputLayoutSignUpConfirmPassword = (android.support.design.widget.TextInputLayout) bindings[6];
        this.inputLayoutSignUpConfirmPassword.setTag(null);
        this.inputLayoutSignUpEmail = (android.support.design.widget.TextInputLayout) bindings[2];
        this.inputLayoutSignUpEmail.setTag(null);
        this.inputLayoutSignUpPassword = (android.support.design.widget.TextInputLayout) bindings[4];
        this.inputLayoutSignUpPassword.setTag(null);
        this.mboundView1 = (android.widget.ProgressBar) bindings[1];
        this.mboundView1.setTag(null);
        this.rlParent = (android.widget.RelativeLayout) bindings[0];
        this.rlParent.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x200L;
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
        if (BR.RegisterModelView == variableId) {
            setRegisterModelView((findandfix.viewmodel.RegisterViewModel) variable);
        }
        else if (BR.validator == variableId) {
            setValidator((findandfix.viewmodel.FirstStepRegisterValidation) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRegisterModelView(@Nullable findandfix.viewmodel.RegisterViewModel RegisterModelView) {
        this.mRegisterModelView = RegisterModelView;
        synchronized(this) {
            mDirtyFlags |= 0x100L;
        }
        notifyPropertyChanged(BR.RegisterModelView);
        super.requestRebind();
    }
    @Nullable
    public findandfix.viewmodel.RegisterViewModel getRegisterModelView() {
        return mRegisterModelView;
    }
    public void setValidator(@Nullable findandfix.viewmodel.FirstStepRegisterValidation Validator) {
        updateRegistration(6, Validator);
        this.mValidator = Validator;
        synchronized(this) {
            mDirtyFlags |= 0x40L;
        }
        notifyPropertyChanged(BR.validator);
        super.requestRebind();
    }
    @Nullable
    public findandfix.viewmodel.FirstStepRegisterValidation getValidator() {
        return mValidator;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeRegisterModelViewPassword((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeRegisterModelViewEmail((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeRegisterModelViewConfirmPassword((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeValidatorEmailError((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeValidatorConfirmPasswordError((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeValidatorPasswordError((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 6 :
                return onChangeValidator((findandfix.viewmodel.FirstStepRegisterValidation) object, fieldId);
            case 7 :
                return onChangeRegisterModelViewVisibleprogress((android.databinding.ObservableField<java.lang.Integer>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeRegisterModelViewPassword(android.databinding.ObservableField<java.lang.String> RegisterModelViewPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegisterModelViewEmail(android.databinding.ObservableField<java.lang.String> RegisterModelViewEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegisterModelViewConfirmPassword(android.databinding.ObservableField<java.lang.String> RegisterModelViewConfirmPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeValidatorEmailError(android.databinding.ObservableField<java.lang.String> ValidatorEmailError, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeValidatorConfirmPasswordError(android.databinding.ObservableField<java.lang.String> ValidatorConfirmPasswordError, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeValidatorPasswordError(android.databinding.ObservableField<java.lang.String> ValidatorPasswordError, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeValidator(findandfix.viewmodel.FirstStepRegisterValidation Validator, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegisterModelViewVisibleprogress(android.databinding.ObservableField<java.lang.Integer> RegisterModelViewVisibleprogress, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
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
        java.lang.String validatorEmailErrorGet = null;
        android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged registerModelViewOnPasswordChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = null;
        java.lang.String registerModelViewPasswordGet = null;
        android.view.View.OnClickListener registerModelViewValidatorAndroidViewViewOnClickListener = null;
        android.databinding.ObservableField<java.lang.String> registerModelViewPassword = null;
        findandfix.viewmodel.RegisterViewModel registerModelView = mRegisterModelView;
        java.lang.String validatorPasswordErrorGet = null;
        java.lang.String validatorConfirmPasswordErrorGet = null;
        android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged registerModelViewOnEmailChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = null;
        android.databinding.ObservableField<java.lang.String> registerModelViewEmail = null;
        android.databinding.ObservableField<java.lang.String> registerModelViewConfirmPassword = null;
        android.databinding.ObservableField<java.lang.String> validatorEmailError = null;
        android.databinding.ObservableField<java.lang.String> validatorConfirmPasswordError = null;
        android.databinding.ObservableField<java.lang.String> validatorPasswordError = null;
        java.lang.Integer registerModelViewVisibleprogressGet = null;
        findandfix.viewmodel.FirstStepRegisterValidation validator = mValidator;
        java.lang.String registerModelViewEmailGet = null;
        android.databinding.ObservableField<java.lang.Integer> registerModelViewVisibleprogress = null;
        java.lang.String registerModelViewConfirmPasswordGet = null;
        android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged registerModelViewOnConfirmPasswordChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = null;
        int androidDatabindingDynamicUtilSafeUnboxRegisterModelViewVisibleprogressGet = 0;

        if ((dirtyFlags & 0x387L) != 0) {


            if ((dirtyFlags & 0x300L) != 0) {

                    if (registerModelView != null) {
                        // read RegisterModelView::onPasswordChanged
                        registerModelViewOnPasswordChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = (((mRegisterModelViewOnPasswordChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged == null) ? (mRegisterModelViewOnPasswordChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = new AfterTextChangedImpl()) : mRegisterModelViewOnPasswordChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged).setValue(registerModelView));
                        // read RegisterModelView::validator
                        registerModelViewValidatorAndroidViewViewOnClickListener = (((mRegisterModelViewValidatorAndroidViewViewOnClickListener == null) ? (mRegisterModelViewValidatorAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mRegisterModelViewValidatorAndroidViewViewOnClickListener).setValue(registerModelView));
                        // read RegisterModelView::onEmailChanged
                        registerModelViewOnEmailChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = (((mRegisterModelViewOnEmailChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged == null) ? (mRegisterModelViewOnEmailChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = new AfterTextChangedImpl1()) : mRegisterModelViewOnEmailChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged).setValue(registerModelView));
                        // read RegisterModelView::onConfirmPasswordChanged
                        registerModelViewOnConfirmPasswordChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = (((mRegisterModelViewOnConfirmPasswordChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged == null) ? (mRegisterModelViewOnConfirmPasswordChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged = new AfterTextChangedImpl2()) : mRegisterModelViewOnConfirmPasswordChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged).setValue(registerModelView));
                    }
            }
            if ((dirtyFlags & 0x301L) != 0) {

                    if (registerModelView != null) {
                        // read RegisterModelView.password
                        registerModelViewPassword = registerModelView.password;
                    }
                    updateRegistration(0, registerModelViewPassword);


                    if (registerModelViewPassword != null) {
                        // read RegisterModelView.password.get()
                        registerModelViewPasswordGet = registerModelViewPassword.get();
                    }
            }
            if ((dirtyFlags & 0x302L) != 0) {

                    if (registerModelView != null) {
                        // read RegisterModelView.email
                        registerModelViewEmail = registerModelView.email;
                    }
                    updateRegistration(1, registerModelViewEmail);


                    if (registerModelViewEmail != null) {
                        // read RegisterModelView.email.get()
                        registerModelViewEmailGet = registerModelViewEmail.get();
                    }
            }
            if ((dirtyFlags & 0x304L) != 0) {

                    if (registerModelView != null) {
                        // read RegisterModelView.confirmPassword
                        registerModelViewConfirmPassword = registerModelView.confirmPassword;
                    }
                    updateRegistration(2, registerModelViewConfirmPassword);


                    if (registerModelViewConfirmPassword != null) {
                        // read RegisterModelView.confirmPassword.get()
                        registerModelViewConfirmPasswordGet = registerModelViewConfirmPassword.get();
                    }
            }
            if ((dirtyFlags & 0x380L) != 0) {

                    if (registerModelView != null) {
                        // read RegisterModelView.visibleprogress
                        registerModelViewVisibleprogress = registerModelView.visibleprogress;
                    }
                    updateRegistration(7, registerModelViewVisibleprogress);


                    if (registerModelViewVisibleprogress != null) {
                        // read RegisterModelView.visibleprogress.get()
                        registerModelViewVisibleprogressGet = registerModelViewVisibleprogress.get();
                    }


                    // read android.databinding.DynamicUtil.safeUnbox(RegisterModelView.visibleprogress.get())
                    androidDatabindingDynamicUtilSafeUnboxRegisterModelViewVisibleprogressGet = android.databinding.DynamicUtil.safeUnbox(registerModelViewVisibleprogressGet);
            }
        }
        if ((dirtyFlags & 0x278L) != 0) {


            if ((dirtyFlags & 0x248L) != 0) {

                    if (validator != null) {
                        // read validator.emailError
                        validatorEmailError = validator.emailError;
                    }
                    updateRegistration(3, validatorEmailError);


                    if (validatorEmailError != null) {
                        // read validator.emailError.get()
                        validatorEmailErrorGet = validatorEmailError.get();
                    }
            }
            if ((dirtyFlags & 0x250L) != 0) {

                    if (validator != null) {
                        // read validator.confirmPasswordError
                        validatorConfirmPasswordError = validator.confirmPasswordError;
                    }
                    updateRegistration(4, validatorConfirmPasswordError);


                    if (validatorConfirmPasswordError != null) {
                        // read validator.confirmPasswordError.get()
                        validatorConfirmPasswordErrorGet = validatorConfirmPasswordError.get();
                    }
            }
            if ((dirtyFlags & 0x260L) != 0) {

                    if (validator != null) {
                        // read validator.passwordError
                        validatorPasswordError = validator.passwordError;
                    }
                    updateRegistration(5, validatorPasswordError);


                    if (validatorPasswordError != null) {
                        // read validator.passwordError.get()
                        validatorPasswordErrorGet = validatorPasswordError.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x300L) != 0) {
            // api target 1

            this.btnLoginEnter.setOnClickListener(registerModelViewValidatorAndroidViewViewOnClickListener);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etSignUpCarOwnerConfirmPassword, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)registerModelViewOnConfirmPasswordChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged, etSignUpCarOwnerConfirmPasswordandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etSignUpCarOwnerEmail, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)registerModelViewOnEmailChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged, etSignUpCarOwnerEmailandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etSignUpCarOwnerPassword, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)registerModelViewOnPasswordChangedAndroidDatabindingAdaptersTextViewBindingAdapterAfterTextChanged, etSignUpCarOwnerPasswordandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x304L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.etSignUpCarOwnerConfirmPassword, registerModelViewConfirmPasswordGet);
        }
        if ((dirtyFlags & 0x302L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.etSignUpCarOwnerEmail, registerModelViewEmailGet);
        }
        if ((dirtyFlags & 0x301L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.etSignUpCarOwnerPassword, registerModelViewPasswordGet);
        }
        if ((dirtyFlags & 0x250L) != 0) {
            // api target 1

            findandfix.utils.CustomBinder.setErrorMessage(this.inputLayoutSignUpConfirmPassword, validatorConfirmPasswordErrorGet);
        }
        if ((dirtyFlags & 0x248L) != 0) {
            // api target 1

            findandfix.utils.CustomBinder.setErrorMessage(this.inputLayoutSignUpEmail, validatorEmailErrorGet);
        }
        if ((dirtyFlags & 0x260L) != 0) {
            // api target 1

            findandfix.utils.CustomBinder.setErrorMessage(this.inputLayoutSignUpPassword, validatorPasswordErrorGet);
        }
        if ((dirtyFlags & 0x380L) != 0) {
            // api target 1

            this.mboundView1.setVisibility(androidDatabindingDynamicUtilSafeUnboxRegisterModelViewVisibleprogressGet);
        }
    }
    // Listener Stub Implementations
    public static class AfterTextChangedImpl implements android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged{
        private findandfix.viewmodel.RegisterViewModel value;
        public AfterTextChangedImpl setValue(findandfix.viewmodel.RegisterViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void afterTextChanged(android.text.Editable arg0) {
            this.value.onPasswordChanged(arg0);
        }
    }
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private findandfix.viewmodel.RegisterViewModel value;
        public OnClickListenerImpl setValue(findandfix.viewmodel.RegisterViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.validator(arg0);
        }
    }
    public static class AfterTextChangedImpl1 implements android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged{
        private findandfix.viewmodel.RegisterViewModel value;
        public AfterTextChangedImpl1 setValue(findandfix.viewmodel.RegisterViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void afterTextChanged(android.text.Editable arg0) {
            this.value.onEmailChanged(arg0);
        }
    }
    public static class AfterTextChangedImpl2 implements android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged{
        private findandfix.viewmodel.RegisterViewModel value;
        public AfterTextChangedImpl2 setValue(findandfix.viewmodel.RegisterViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void afterTextChanged(android.text.Editable arg0) {
            this.value.onConfirmPasswordChanged(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityFirstStepRegisterLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityFirstStepRegisterLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityFirstStepRegisterLayoutBinding>inflate(inflater, findandfix.R.layout.activity_first_step_register_layout, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityFirstStepRegisterLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityFirstStepRegisterLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.activity_first_step_register_layout, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityFirstStepRegisterLayoutBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityFirstStepRegisterLayoutBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_first_step_register_layout_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityFirstStepRegisterLayoutBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): RegisterModelView.password
        flag 1 (0x2L): RegisterModelView.email
        flag 2 (0x3L): RegisterModelView.confirmPassword
        flag 3 (0x4L): validator.emailError
        flag 4 (0x5L): validator.confirmPasswordError
        flag 5 (0x6L): validator.passwordError
        flag 6 (0x7L): validator
        flag 7 (0x8L): RegisterModelView.visibleprogress
        flag 8 (0x9L): RegisterModelView
        flag 9 (0xaL): null
    flag mapping end*/
    //end
}