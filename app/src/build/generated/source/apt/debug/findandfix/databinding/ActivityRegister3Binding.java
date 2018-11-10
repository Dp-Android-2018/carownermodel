package findandfix.databinding;
import com.findandfix.carowner.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityRegister3Binding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rl_container, 6);
    }
    // views
    @NonNull
    public final com.airbnb.lottie.LottieAnimationView animationView;
    @NonNull
    public final android.widget.Button btnRegister2Next;
    @NonNull
    public final de.hdodenhof.circleimageview.CircleImageView ivCarOwnerImage;
    @NonNull
    private final android.widget.ImageView mboundView1;
    @NonNull
    private final android.widget.ProgressBar mboundView3;
    @NonNull
    public final android.widget.RelativeLayout rlContainer;
    @NonNull
    public final android.widget.RelativeLayout rlParent;
    // variables
    @Nullable
    private com.findandfix.carowner.viewmodel.UploadImageModelView mUploadImageModelView;
    @Nullable
    private com.findandfix.carowner.viewmodel.HandleRegisterViewModel mRegisterviewmodel;
    // values
    // listeners
    private OnClickListenerImpl mUploadImageModelViewValidateAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mUploadImageModelViewDisplayDialogAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ActivityRegister3Binding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 4);
        final Object[] bindings = mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
        this.animationView = (com.airbnb.lottie.LottieAnimationView) bindings[4];
        this.animationView.setTag(null);
        this.btnRegister2Next = (android.widget.Button) bindings[5];
        this.btnRegister2Next.setTag(null);
        this.ivCarOwnerImage = (de.hdodenhof.circleimageview.CircleImageView) bindings[2];
        this.ivCarOwnerImage.setTag(null);
        this.mboundView1 = (android.widget.ImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView3 = (android.widget.ProgressBar) bindings[3];
        this.mboundView3.setTag(null);
        this.rlContainer = (android.widget.RelativeLayout) bindings[6];
        this.rlParent = (android.widget.RelativeLayout) bindings[0];
        this.rlParent.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
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
        if (BR.UploadImageModelView == variableId) {
            setUploadImageModelView((com.findandfix.carowner.viewmodel.UploadImageModelView) variable);
        }
        else if (BR.registerviewmodel == variableId) {
            setRegisterviewmodel((com.findandfix.carowner.viewmodel.HandleRegisterViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setUploadImageModelView(@Nullable com.findandfix.carowner.viewmodel.UploadImageModelView UploadImageModelView) {
        updateRegistration(2, UploadImageModelView);
        this.mUploadImageModelView = UploadImageModelView;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.UploadImageModelView);
        super.requestRebind();
    }
    @Nullable
    public com.findandfix.carowner.viewmodel.UploadImageModelView getUploadImageModelView() {
        return mUploadImageModelView;
    }
    public void setRegisterviewmodel(@Nullable com.findandfix.carowner.viewmodel.HandleRegisterViewModel Registerviewmodel) {
        this.mRegisterviewmodel = Registerviewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.registerviewmodel);
        super.requestRebind();
    }
    @Nullable
    public com.findandfix.carowner.viewmodel.HandleRegisterViewModel getRegisterviewmodel() {
        return mRegisterviewmodel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeUploadImageModelViewProgress((android.databinding.ObservableFloat) object, fieldId);
            case 1 :
                return onChangeRegisterviewmodelProgressDialog((android.databinding.ObservableField<java.lang.Integer>) object, fieldId);
            case 2 :
                return onChangeUploadImageModelView((com.findandfix.carowner.viewmodel.UploadImageModelView) object, fieldId);
            case 3 :
                return onChangeUploadImageModelViewLoading((android.databinding.ObservableField<java.lang.Integer>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeUploadImageModelViewProgress(android.databinding.ObservableFloat UploadImageModelViewProgress, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegisterviewmodelProgressDialog(android.databinding.ObservableField<java.lang.Integer> RegisterviewmodelProgressDialog, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeUploadImageModelView(com.findandfix.carowner.viewmodel.UploadImageModelView UploadImageModelView, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.picBitmap) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeUploadImageModelViewLoading(android.databinding.ObservableField<java.lang.Integer> UploadImageModelViewLoading, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
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
        android.databinding.ObservableFloat uploadImageModelViewProgress = null;
        int androidDatabindingDynamicUtilSafeUnboxUploadImageModelViewLoadingGet = 0;
        float uploadImageModelViewProgressGet = 0f;
        android.databinding.ObservableField<java.lang.Integer> registerviewmodelProgressDialog = null;
        int uploadImageModelViewPicBitmapJavaLangObjectNullViewVISIBLEViewINVISIBLE = 0;
        int UploadImageModelViewPicBitmapJavaLangObjectNullViewVISIBLEViewINVISIBLE1 = 0;
        com.findandfix.carowner.viewmodel.UploadImageModelView uploadImageModelView = mUploadImageModelView;
        int androidDatabindingDynamicUtilSafeUnboxRegisterviewmodelProgressDialogGet = 0;
        boolean uploadImageModelViewPicBitmapJavaLangObjectNull = false;
        boolean UploadImageModelViewPicBitmapJavaLangObjectNull1 = false;
        java.lang.Integer uploadImageModelViewLoadingGet = null;
        com.findandfix.carowner.viewmodel.HandleRegisterViewModel registerviewmodel = mRegisterviewmodel;
        android.databinding.ObservableField<java.lang.Integer> uploadImageModelViewLoading = null;
        android.view.View.OnClickListener uploadImageModelViewValidateAndroidViewViewOnClickListener = null;
        android.graphics.Bitmap uploadImageModelViewPicBitmap = null;
        android.view.View.OnClickListener uploadImageModelViewDisplayDialogAndroidViewViewOnClickListener = null;
        java.lang.Integer registerviewmodelProgressDialogGet = null;
        android.animation.Animator.AnimatorListener uploadImageModelViewOnAnimationEnd = null;

        if ((dirtyFlags & 0x6dL) != 0) {


            if ((dirtyFlags & 0x45L) != 0) {

                    if (uploadImageModelView != null) {
                        // read UploadImageModelView.progress
                        uploadImageModelViewProgress = uploadImageModelView.progress;
                    }
                    updateRegistration(0, uploadImageModelViewProgress);


                    if (uploadImageModelViewProgress != null) {
                        // read UploadImageModelView.progress.get()
                        uploadImageModelViewProgressGet = uploadImageModelViewProgress.get();
                    }
            }
            if ((dirtyFlags & 0x4cL) != 0) {

                    if (uploadImageModelView != null) {
                        // read UploadImageModelView.loading
                        uploadImageModelViewLoading = uploadImageModelView.loading;
                    }
                    updateRegistration(3, uploadImageModelViewLoading);


                    if (uploadImageModelViewLoading != null) {
                        // read UploadImageModelView.loading.get()
                        uploadImageModelViewLoadingGet = uploadImageModelViewLoading.get();
                    }


                    // read android.databinding.DynamicUtil.safeUnbox(UploadImageModelView.loading.get())
                    androidDatabindingDynamicUtilSafeUnboxUploadImageModelViewLoadingGet = android.databinding.DynamicUtil.safeUnbox(uploadImageModelViewLoadingGet);
            }
            if ((dirtyFlags & 0x44L) != 0) {

                    if (uploadImageModelView != null) {
                        // read UploadImageModelView::validate
                        uploadImageModelViewValidateAndroidViewViewOnClickListener = (((mUploadImageModelViewValidateAndroidViewViewOnClickListener == null) ? (mUploadImageModelViewValidateAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mUploadImageModelViewValidateAndroidViewViewOnClickListener).setValue(uploadImageModelView));
                        // read UploadImageModelView::displayDialog
                        uploadImageModelViewDisplayDialogAndroidViewViewOnClickListener = (((mUploadImageModelViewDisplayDialogAndroidViewViewOnClickListener == null) ? (mUploadImageModelViewDisplayDialogAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mUploadImageModelViewDisplayDialogAndroidViewViewOnClickListener).setValue(uploadImageModelView));
                        // read UploadImageModelView.onAnimationEnd
                        uploadImageModelViewOnAnimationEnd = uploadImageModelView.onAnimationEnd();
                    }
            }
            if ((dirtyFlags & 0x64L) != 0) {

                    if (uploadImageModelView != null) {
                        // read UploadImageModelView.picBitmap
                        uploadImageModelViewPicBitmap = uploadImageModelView.getPicBitmap();
                    }


                    // read UploadImageModelView.picBitmap != null
                    uploadImageModelViewPicBitmapJavaLangObjectNull = (uploadImageModelViewPicBitmap) != (null);
                    // read UploadImageModelView.picBitmap == null
                    UploadImageModelViewPicBitmapJavaLangObjectNull1 = (uploadImageModelViewPicBitmap) == (null);
                if((dirtyFlags & 0x64L) != 0) {
                    if(uploadImageModelViewPicBitmapJavaLangObjectNull) {
                            dirtyFlags |= 0x100L;
                    }
                    else {
                            dirtyFlags |= 0x80L;
                    }
                }
                if((dirtyFlags & 0x64L) != 0) {
                    if(UploadImageModelViewPicBitmapJavaLangObjectNull1) {
                            dirtyFlags |= 0x400L;
                    }
                    else {
                            dirtyFlags |= 0x200L;
                    }
                }


                    // read UploadImageModelView.picBitmap != null ? View.VISIBLE : View.INVISIBLE
                    uploadImageModelViewPicBitmapJavaLangObjectNullViewVISIBLEViewINVISIBLE = ((uploadImageModelViewPicBitmapJavaLangObjectNull) ? (android.view.View.VISIBLE) : (android.view.View.INVISIBLE));
                    // read UploadImageModelView.picBitmap == null ? View.VISIBLE : View.INVISIBLE
                    UploadImageModelViewPicBitmapJavaLangObjectNullViewVISIBLEViewINVISIBLE1 = ((UploadImageModelViewPicBitmapJavaLangObjectNull1) ? (android.view.View.VISIBLE) : (android.view.View.INVISIBLE));
            }
        }
        if ((dirtyFlags & 0x52L) != 0) {



                if (registerviewmodel != null) {
                    // read registerviewmodel.progressDialog
                    registerviewmodelProgressDialog = registerviewmodel.progressDialog;
                }
                updateRegistration(1, registerviewmodelProgressDialog);


                if (registerviewmodelProgressDialog != null) {
                    // read registerviewmodel.progressDialog.get()
                    registerviewmodelProgressDialogGet = registerviewmodelProgressDialog.get();
                }


                // read android.databinding.DynamicUtil.safeUnbox(registerviewmodel.progressDialog.get())
                androidDatabindingDynamicUtilSafeUnboxRegisterviewmodelProgressDialogGet = android.databinding.DynamicUtil.safeUnbox(registerviewmodelProgressDialogGet);
        }
        // batch finished
        if ((dirtyFlags & 0x45L) != 0) {
            // api target 1

            com.findandfix.carowner.utils.CustomBinder.progress(this.animationView, uploadImageModelViewProgressGet);
        }
        if ((dirtyFlags & 0x44L) != 0) {
            // api target 1

            com.findandfix.carowner.utils.CustomBinder.onAnimationEnd(this.animationView, uploadImageModelViewOnAnimationEnd);
            this.btnRegister2Next.setOnClickListener(uploadImageModelViewValidateAndroidViewViewOnClickListener);
            this.ivCarOwnerImage.setOnClickListener(uploadImageModelViewDisplayDialogAndroidViewViewOnClickListener);
            this.mboundView1.setOnClickListener(uploadImageModelViewDisplayDialogAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x4cL) != 0) {
            // api target 1

            this.animationView.setVisibility(androidDatabindingDynamicUtilSafeUnboxUploadImageModelViewLoadingGet);
        }
        if ((dirtyFlags & 0x64L) != 0) {
            // api target 1

            com.findandfix.carowner.utils.CustomBinder.setImageBitmap(this.ivCarOwnerImage, uploadImageModelViewPicBitmap);
            this.ivCarOwnerImage.setVisibility(uploadImageModelViewPicBitmapJavaLangObjectNullViewVISIBLEViewINVISIBLE);
            this.mboundView1.setVisibility(UploadImageModelViewPicBitmapJavaLangObjectNullViewVISIBLEViewINVISIBLE1);
        }
        if ((dirtyFlags & 0x52L) != 0) {
            // api target 1

            this.mboundView3.setVisibility(androidDatabindingDynamicUtilSafeUnboxRegisterviewmodelProgressDialogGet);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.UploadImageModelView value;
        public OnClickListenerImpl setValue(com.findandfix.carowner.viewmodel.UploadImageModelView value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.validate(arg0);
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.UploadImageModelView value;
        public OnClickListenerImpl1 setValue(com.findandfix.carowner.viewmodel.UploadImageModelView value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.displayDialog(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityRegister3Binding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityRegister3Binding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityRegister3Binding>inflate(inflater, findandfix.R.layout.activity_register_3, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityRegister3Binding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityRegister3Binding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.activity_register_3, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityRegister3Binding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityRegister3Binding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_register_3_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityRegister3Binding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): UploadImageModelView.progress
        flag 1 (0x2L): registerviewmodel.progressDialog
        flag 2 (0x3L): UploadImageModelView
        flag 3 (0x4L): UploadImageModelView.loading
        flag 4 (0x5L): registerviewmodel
        flag 5 (0x6L): UploadImageModelView.picBitmap
        flag 6 (0x7L): null
        flag 7 (0x8L): UploadImageModelView.picBitmap != null ? View.VISIBLE : View.INVISIBLE
        flag 8 (0x9L): UploadImageModelView.picBitmap != null ? View.VISIBLE : View.INVISIBLE
        flag 9 (0xaL): UploadImageModelView.picBitmap == null ? View.VISIBLE : View.INVISIBLE
        flag 10 (0xbL): UploadImageModelView.picBitmap == null ? View.VISIBLE : View.INVISIBLE
    flag mapping end*/
    //end
}