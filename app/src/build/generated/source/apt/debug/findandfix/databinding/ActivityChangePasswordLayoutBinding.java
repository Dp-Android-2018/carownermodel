package findandfix.databinding;
import com.findandfix.carowner.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityChangePasswordLayoutBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(10);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar_layout"},
            new int[] {6},
            new int[] {R.layout.toolbar_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ll_container, 7);
        sViewsWithIds.put(R.id.tv_workshop_info, 8);
        sViewsWithIds.put(R.id.ll_workshop_info, 9);
    }
    // views
    @NonNull
    public final android.widget.Button btnSubmit;
    @NonNull
    public final android.widget.EditText etEditProfileWorkshopName;
    @NonNull
    public final android.widget.LinearLayout llBase;
    @NonNull
    public final android.widget.RelativeLayout llContainer;
    @NonNull
    public final android.widget.LinearLayout llWorkshopInfo;
    @NonNull
    private final android.widget.EditText mboundView2;
    @NonNull
    private final android.widget.EditText mboundView3;
    @NonNull
    private final android.widget.ProgressBar mboundView5;
    @Nullable
    public final findandfix.databinding.ToolbarLayoutBinding toolbar;
    @NonNull
    public final android.widget.TextView tvWorkshopInfo;
    // variables
    @Nullable
    private com.findandfix.carowner.viewmodel.ChangePasswordViewModel mChangepasswordviewmodel;
    // values
    // listeners
    private OnClickListenerImpl mChangepasswordviewmodelChangePasswordActionAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener etEditProfileWorkshopNameandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of changepasswordviewmodel.currentpassword.get()
            //         is changepasswordviewmodel.currentpassword.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(etEditProfileWorkshopName);
            // localize variables for thread safety
            // changepasswordviewmodel.currentpassword != null
            boolean changepasswordviewmodelCurrentpasswordJavaLangObjectNull = false;
            // changepasswordviewmodel.currentpassword.get()
            java.lang.String changepasswordviewmodelCurrentpasswordGet = null;
            // changepasswordviewmodel
            com.findandfix.carowner.viewmodel.ChangePasswordViewModel changepasswordviewmodel = mChangepasswordviewmodel;
            // changepasswordviewmodel != null
            boolean changepasswordviewmodelJavaLangObjectNull = false;
            // changepasswordviewmodel.currentpassword
            android.databinding.ObservableField<java.lang.String> changepasswordviewmodelCurrentpassword = null;



            changepasswordviewmodelJavaLangObjectNull = (changepasswordviewmodel) != (null);
            if (changepasswordviewmodelJavaLangObjectNull) {


                changepasswordviewmodelCurrentpassword = changepasswordviewmodel.currentpassword;

                changepasswordviewmodelCurrentpasswordJavaLangObjectNull = (changepasswordviewmodelCurrentpassword) != (null);
                if (changepasswordviewmodelCurrentpasswordJavaLangObjectNull) {




                    changepasswordviewmodelCurrentpassword.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView2androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of changepasswordviewmodel.newPassword.get()
            //         is changepasswordviewmodel.newPassword.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView2);
            // localize variables for thread safety
            // changepasswordviewmodel.newPassword != null
            boolean changepasswordviewmodelNewPasswordJavaLangObjectNull = false;
            // changepasswordviewmodel.newPassword
            android.databinding.ObservableField<java.lang.String> changepasswordviewmodelNewPassword = null;
            // changepasswordviewmodel.newPassword.get()
            java.lang.String changepasswordviewmodelNewPasswordGet = null;
            // changepasswordviewmodel
            com.findandfix.carowner.viewmodel.ChangePasswordViewModel changepasswordviewmodel = mChangepasswordviewmodel;
            // changepasswordviewmodel != null
            boolean changepasswordviewmodelJavaLangObjectNull = false;



            changepasswordviewmodelJavaLangObjectNull = (changepasswordviewmodel) != (null);
            if (changepasswordviewmodelJavaLangObjectNull) {


                changepasswordviewmodelNewPassword = changepasswordviewmodel.newPassword;

                changepasswordviewmodelNewPasswordJavaLangObjectNull = (changepasswordviewmodelNewPassword) != (null);
                if (changepasswordviewmodelNewPasswordJavaLangObjectNull) {




                    changepasswordviewmodelNewPassword.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView3androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of changepasswordviewmodel.cofirmNewPassword.get()
            //         is changepasswordviewmodel.cofirmNewPassword.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView3);
            // localize variables for thread safety
            // changepasswordviewmodel.cofirmNewPassword
            android.databinding.ObservableField<java.lang.String> changepasswordviewmodelCofirmNewPassword = null;
            // changepasswordviewmodel.cofirmNewPassword.get()
            java.lang.String changepasswordviewmodelCofirmNewPasswordGet = null;
            // changepasswordviewmodel.cofirmNewPassword != null
            boolean changepasswordviewmodelCofirmNewPasswordJavaLangObjectNull = false;
            // changepasswordviewmodel
            com.findandfix.carowner.viewmodel.ChangePasswordViewModel changepasswordviewmodel = mChangepasswordviewmodel;
            // changepasswordviewmodel != null
            boolean changepasswordviewmodelJavaLangObjectNull = false;



            changepasswordviewmodelJavaLangObjectNull = (changepasswordviewmodel) != (null);
            if (changepasswordviewmodelJavaLangObjectNull) {


                changepasswordviewmodelCofirmNewPassword = changepasswordviewmodel.cofirmNewPassword;

                changepasswordviewmodelCofirmNewPasswordJavaLangObjectNull = (changepasswordviewmodelCofirmNewPassword) != (null);
                if (changepasswordviewmodelCofirmNewPasswordJavaLangObjectNull) {




                    changepasswordviewmodelCofirmNewPassword.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityChangePasswordLayoutBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 6);
        final Object[] bindings = mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds);
        this.btnSubmit = (android.widget.Button) bindings[4];
        this.btnSubmit.setTag(null);
        this.etEditProfileWorkshopName = (android.widget.EditText) bindings[1];
        this.etEditProfileWorkshopName.setTag(null);
        this.llBase = (android.widget.LinearLayout) bindings[0];
        this.llBase.setTag(null);
        this.llContainer = (android.widget.RelativeLayout) bindings[7];
        this.llWorkshopInfo = (android.widget.LinearLayout) bindings[9];
        this.mboundView2 = (android.widget.EditText) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.EditText) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView5 = (android.widget.ProgressBar) bindings[5];
        this.mboundView5.setTag(null);
        this.toolbar = (findandfix.databinding.ToolbarLayoutBinding) bindings[6];
        setContainedBinding(this.toolbar);
        this.tvWorkshopInfo = (android.widget.TextView) bindings[8];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
        }
        toolbar.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (toolbar.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.changepasswordviewmodel == variableId) {
            setChangepasswordviewmodel((com.findandfix.carowner.viewmodel.ChangePasswordViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setChangepasswordviewmodel(@Nullable com.findandfix.carowner.viewmodel.ChangePasswordViewModel Changepasswordviewmodel) {
        updateRegistration(3, Changepasswordviewmodel);
        this.mChangepasswordviewmodel = Changepasswordviewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.changepasswordviewmodel);
        super.requestRebind();
    }
    @Nullable
    public com.findandfix.carowner.viewmodel.ChangePasswordViewModel getChangepasswordviewmodel() {
        return mChangepasswordviewmodel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeChangepasswordviewmodelCofirmNewPassword((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeChangepasswordviewmodelNewPassword((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeChangepasswordviewmodelProgress((android.databinding.ObservableInt) object, fieldId);
            case 3 :
                return onChangeChangepasswordviewmodel((com.findandfix.carowner.viewmodel.ChangePasswordViewModel) object, fieldId);
            case 4 :
                return onChangeChangepasswordviewmodelCurrentpassword((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeToolbar((findandfix.databinding.ToolbarLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeChangepasswordviewmodelCofirmNewPassword(android.databinding.ObservableField<java.lang.String> ChangepasswordviewmodelCofirmNewPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeChangepasswordviewmodelNewPassword(android.databinding.ObservableField<java.lang.String> ChangepasswordviewmodelNewPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeChangepasswordviewmodelProgress(android.databinding.ObservableInt ChangepasswordviewmodelProgress, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeChangepasswordviewmodel(com.findandfix.carowner.viewmodel.ChangePasswordViewModel Changepasswordviewmodel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeChangepasswordviewmodelCurrentpassword(android.databinding.ObservableField<java.lang.String> ChangepasswordviewmodelCurrentpassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeToolbar(findandfix.databinding.ToolbarLayoutBinding Toolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
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
        java.lang.String changepasswordviewmodelCurrentpasswordGet = null;
        java.lang.String changepasswordviewmodelCofirmNewPasswordGet = null;
        java.lang.String changepasswordviewmodelNewPasswordGet = null;
        android.databinding.ObservableField<java.lang.String> changepasswordviewmodelCofirmNewPassword = null;
        android.databinding.ObservableField<java.lang.String> changepasswordviewmodelNewPassword = null;
        android.databinding.ObservableInt changepasswordviewmodelProgress = null;
        com.findandfix.carowner.viewmodel.ChangePasswordViewModel changepasswordviewmodel = mChangepasswordviewmodel;
        android.databinding.ObservableField<java.lang.String> changepasswordviewmodelCurrentpassword = null;
        int changepasswordviewmodelProgressGet = 0;
        android.view.View.OnClickListener changepasswordviewmodelChangePasswordActionAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x5fL) != 0) {


            if ((dirtyFlags & 0x49L) != 0) {

                    if (changepasswordviewmodel != null) {
                        // read changepasswordviewmodel.cofirmNewPassword
                        changepasswordviewmodelCofirmNewPassword = changepasswordviewmodel.cofirmNewPassword;
                    }
                    updateRegistration(0, changepasswordviewmodelCofirmNewPassword);


                    if (changepasswordviewmodelCofirmNewPassword != null) {
                        // read changepasswordviewmodel.cofirmNewPassword.get()
                        changepasswordviewmodelCofirmNewPasswordGet = changepasswordviewmodelCofirmNewPassword.get();
                    }
            }
            if ((dirtyFlags & 0x4aL) != 0) {

                    if (changepasswordviewmodel != null) {
                        // read changepasswordviewmodel.newPassword
                        changepasswordviewmodelNewPassword = changepasswordviewmodel.newPassword;
                    }
                    updateRegistration(1, changepasswordviewmodelNewPassword);


                    if (changepasswordviewmodelNewPassword != null) {
                        // read changepasswordviewmodel.newPassword.get()
                        changepasswordviewmodelNewPasswordGet = changepasswordviewmodelNewPassword.get();
                    }
            }
            if ((dirtyFlags & 0x4cL) != 0) {

                    if (changepasswordviewmodel != null) {
                        // read changepasswordviewmodel.progress
                        changepasswordviewmodelProgress = changepasswordviewmodel.progress;
                    }
                    updateRegistration(2, changepasswordviewmodelProgress);


                    if (changepasswordviewmodelProgress != null) {
                        // read changepasswordviewmodel.progress.get()
                        changepasswordviewmodelProgressGet = changepasswordviewmodelProgress.get();
                    }
            }
            if ((dirtyFlags & 0x58L) != 0) {

                    if (changepasswordviewmodel != null) {
                        // read changepasswordviewmodel.currentpassword
                        changepasswordviewmodelCurrentpassword = changepasswordviewmodel.currentpassword;
                    }
                    updateRegistration(4, changepasswordviewmodelCurrentpassword);


                    if (changepasswordviewmodelCurrentpassword != null) {
                        // read changepasswordviewmodel.currentpassword.get()
                        changepasswordviewmodelCurrentpasswordGet = changepasswordviewmodelCurrentpassword.get();
                    }
            }
            if ((dirtyFlags & 0x48L) != 0) {

                    if (changepasswordviewmodel != null) {
                        // read changepasswordviewmodel::changePasswordAction
                        changepasswordviewmodelChangePasswordActionAndroidViewViewOnClickListener = (((mChangepasswordviewmodelChangePasswordActionAndroidViewViewOnClickListener == null) ? (mChangepasswordviewmodelChangePasswordActionAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mChangepasswordviewmodelChangePasswordActionAndroidViewViewOnClickListener).setValue(changepasswordviewmodel));
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x48L) != 0) {
            // api target 1

            this.btnSubmit.setOnClickListener(changepasswordviewmodelChangePasswordActionAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x58L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.etEditProfileWorkshopName, changepasswordviewmodelCurrentpasswordGet);
        }
        if ((dirtyFlags & 0x40L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etEditProfileWorkshopName, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etEditProfileWorkshopNameandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView3, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView3androidTextAttrChanged);
        }
        if ((dirtyFlags & 0x4aL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, changepasswordviewmodelNewPasswordGet);
        }
        if ((dirtyFlags & 0x49L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, changepasswordviewmodelCofirmNewPasswordGet);
        }
        if ((dirtyFlags & 0x4cL) != 0) {
            // api target 1

            this.mboundView5.setVisibility(changepasswordviewmodelProgressGet);
        }
        executeBindingsOn(toolbar);
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.ChangePasswordViewModel value;
        public OnClickListenerImpl setValue(com.findandfix.carowner.viewmodel.ChangePasswordViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.changePasswordAction(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityChangePasswordLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityChangePasswordLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityChangePasswordLayoutBinding>inflate(inflater, findandfix.R.layout.activity_change_password_layout, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityChangePasswordLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityChangePasswordLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.activity_change_password_layout, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityChangePasswordLayoutBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityChangePasswordLayoutBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_change_password_layout_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityChangePasswordLayoutBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): changepasswordviewmodel.cofirmNewPassword
        flag 1 (0x2L): changepasswordviewmodel.newPassword
        flag 2 (0x3L): changepasswordviewmodel.progress
        flag 3 (0x4L): changepasswordviewmodel
        flag 4 (0x5L): changepasswordviewmodel.currentpassword
        flag 5 (0x6L): toolbar
        flag 6 (0x7L): null
    flag mapping end*/
    //end
}