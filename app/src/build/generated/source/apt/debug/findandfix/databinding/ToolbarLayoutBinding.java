package findandfix.databinding;
import findandfix.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ToolbarLayoutBinding extends android.databinding.ViewDataBinding  {

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
    public final android.widget.ImageView ivToolbarMessages;
    @NonNull
    private final android.widget.ImageView mboundView1;
    @NonNull
    private final android.widget.ImageView mboundView2;
    @NonNull
    public final android.support.v7.widget.Toolbar toolbar;
    @NonNull
    public final android.widget.TextView tvToolbarTitle;
    // variables
    @Nullable
    private findandfix.viewmodel.ToolbarViewModel mViewmodel;
    @Nullable
    private int mFoo;
    // values
    // listeners
    private OnClickListenerImpl mViewmodelFinishActAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mViewmodelBackToMainActAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mViewmodelOpenChatActAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener tvToolbarTitleandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.toolbarTitle.get()
            //         is viewmodel.toolbarTitle.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(tvToolbarTitle);
            // localize variables for thread safety
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.toolbarTitle
            android.databinding.ObservableField<java.lang.String> viewmodelToolbarTitle = null;
            // viewmodel.toolbarTitle.get()
            java.lang.String viewmodelToolbarTitleGet = null;
            // viewmodel.toolbarTitle != null
            boolean viewmodelToolbarTitleJavaLangObjectNull = false;
            // viewmodel
            findandfix.viewmodel.ToolbarViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelToolbarTitle = viewmodel.toolbarTitle;

                viewmodelToolbarTitleJavaLangObjectNull = (viewmodelToolbarTitle) != (null);
                if (viewmodelToolbarTitleJavaLangObjectNull) {




                    viewmodelToolbarTitle.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ToolbarLayoutBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 5);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.ivToolbarMessages = (android.widget.ImageView) bindings[4];
        this.ivToolbarMessages.setTag(null);
        this.mboundView1 = (android.widget.ImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.ImageView) bindings[2];
        this.mboundView2.setTag(null);
        this.toolbar = (android.support.v7.widget.Toolbar) bindings[0];
        this.toolbar.setTag(null);
        this.tvToolbarTitle = (android.widget.TextView) bindings[3];
        this.tvToolbarTitle.setTag(null);
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
        if (BR.viewmodel == variableId) {
            setViewmodel((findandfix.viewmodel.ToolbarViewModel) variable);
        }
        else if (BR.foo == variableId) {
            setFoo((int) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewmodel(@Nullable findandfix.viewmodel.ToolbarViewModel Viewmodel) {
        updateRegistration(1, Viewmodel);
        this.mViewmodel = Viewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewmodel);
        super.requestRebind();
    }
    @Nullable
    public findandfix.viewmodel.ToolbarViewModel getViewmodel() {
        return mViewmodel;
    }
    public void setFoo(int Foo) {
        this.mFoo = Foo;
    }
    public int getFoo() {
        return mFoo;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewmodelToolbarTitle((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewmodel((findandfix.viewmodel.ToolbarViewModel) object, fieldId);
            case 2 :
                return onChangeViewmodelToolbarColor((android.databinding.ObservableInt) object, fieldId);
            case 3 :
                return onChangeViewmodelBackimageVisibility((android.databinding.ObservableInt) object, fieldId);
            case 4 :
                return onChangeViewmodelImageVisibility((android.databinding.ObservableInt) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewmodelToolbarTitle(android.databinding.ObservableField<java.lang.String> ViewmodelToolbarTitle, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodel(findandfix.viewmodel.ToolbarViewModel Viewmodel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelToolbarColor(android.databinding.ObservableInt ViewmodelToolbarColor, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelBackimageVisibility(android.databinding.ObservableInt ViewmodelBackimageVisibility, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelImageVisibility(android.databinding.ObservableInt ViewmodelImageVisibility, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
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
        android.view.View.OnClickListener viewmodelFinishActAndroidViewViewOnClickListener = null;
        android.view.View.OnClickListener viewmodelBackToMainActAndroidViewViewOnClickListener = null;
        android.databinding.ObservableField<java.lang.String> viewmodelToolbarTitle = null;
        findandfix.viewmodel.ToolbarViewModel viewmodel = mViewmodel;
        int viewmodelToolbarColorGet = 0;
        android.databinding.ObservableInt viewmodelToolbarColor = null;
        android.databinding.ObservableInt viewmodelBackimageVisibility = null;
        android.databinding.ObservableInt viewmodelImageVisibility = null;
        java.lang.String viewmodelToolbarTitleGet = null;
        int viewmodelImageVisibilityGet = 0;
        android.view.View.OnClickListener viewmodelOpenChatActAndroidViewViewOnClickListener = null;
        int viewmodelBackimageVisibilityGet = 0;

        if ((dirtyFlags & 0x5fL) != 0) {


            if ((dirtyFlags & 0x42L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel::FinishAct
                        viewmodelFinishActAndroidViewViewOnClickListener = (((mViewmodelFinishActAndroidViewViewOnClickListener == null) ? (mViewmodelFinishActAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mViewmodelFinishActAndroidViewViewOnClickListener).setValue(viewmodel));
                        // read viewmodel::backToMainAct
                        viewmodelBackToMainActAndroidViewViewOnClickListener = (((mViewmodelBackToMainActAndroidViewViewOnClickListener == null) ? (mViewmodelBackToMainActAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mViewmodelBackToMainActAndroidViewViewOnClickListener).setValue(viewmodel));
                        // read viewmodel::openChatAct
                        viewmodelOpenChatActAndroidViewViewOnClickListener = (((mViewmodelOpenChatActAndroidViewViewOnClickListener == null) ? (mViewmodelOpenChatActAndroidViewViewOnClickListener = new OnClickListenerImpl2()) : mViewmodelOpenChatActAndroidViewViewOnClickListener).setValue(viewmodel));
                    }
            }
            if ((dirtyFlags & 0x43L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.toolbarTitle
                        viewmodelToolbarTitle = viewmodel.toolbarTitle;
                    }
                    updateRegistration(0, viewmodelToolbarTitle);


                    if (viewmodelToolbarTitle != null) {
                        // read viewmodel.toolbarTitle.get()
                        viewmodelToolbarTitleGet = viewmodelToolbarTitle.get();
                    }
            }
            if ((dirtyFlags & 0x46L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.toolbarColor
                        viewmodelToolbarColor = viewmodel.toolbarColor;
                    }
                    updateRegistration(2, viewmodelToolbarColor);


                    if (viewmodelToolbarColor != null) {
                        // read viewmodel.toolbarColor.get()
                        viewmodelToolbarColorGet = viewmodelToolbarColor.get();
                    }
            }
            if ((dirtyFlags & 0x4aL) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.backimageVisibility
                        viewmodelBackimageVisibility = viewmodel.backimageVisibility;
                    }
                    updateRegistration(3, viewmodelBackimageVisibility);


                    if (viewmodelBackimageVisibility != null) {
                        // read viewmodel.backimageVisibility.get()
                        viewmodelBackimageVisibilityGet = viewmodelBackimageVisibility.get();
                    }
            }
            if ((dirtyFlags & 0x52L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.imageVisibility
                        viewmodelImageVisibility = viewmodel.imageVisibility;
                    }
                    updateRegistration(4, viewmodelImageVisibility);


                    if (viewmodelImageVisibility != null) {
                        // read viewmodel.imageVisibility.get()
                        viewmodelImageVisibilityGet = viewmodelImageVisibility.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x42L) != 0) {
            // api target 1

            this.ivToolbarMessages.setOnClickListener(viewmodelOpenChatActAndroidViewViewOnClickListener);
            this.mboundView1.setOnClickListener(viewmodelBackToMainActAndroidViewViewOnClickListener);
            this.mboundView2.setOnClickListener(viewmodelFinishActAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x52L) != 0) {
            // api target 1

            this.mboundView1.setVisibility(viewmodelImageVisibilityGet);
        }
        if ((dirtyFlags & 0x4aL) != 0) {
            // api target 1

            this.mboundView2.setVisibility(viewmodelBackimageVisibilityGet);
        }
        if ((dirtyFlags & 0x46L) != 0) {
            // api target 1

            findandfix.utils.CustomBinder.setToolBarBackground(this.toolbar, viewmodelToolbarColorGet);
        }
        if ((dirtyFlags & 0x43L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvToolbarTitle, viewmodelToolbarTitleGet);
        }
        if ((dirtyFlags & 0x40L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.tvToolbarTitle, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, tvToolbarTitleandroidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private findandfix.viewmodel.ToolbarViewModel value;
        public OnClickListenerImpl setValue(findandfix.viewmodel.ToolbarViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.FinishAct(arg0);
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private findandfix.viewmodel.ToolbarViewModel value;
        public OnClickListenerImpl1 setValue(findandfix.viewmodel.ToolbarViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.backToMainAct(arg0);
        }
    }
    public static class OnClickListenerImpl2 implements android.view.View.OnClickListener{
        private findandfix.viewmodel.ToolbarViewModel value;
        public OnClickListenerImpl2 setValue(findandfix.viewmodel.ToolbarViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.openChatAct(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ToolbarLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ToolbarLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ToolbarLayoutBinding>inflate(inflater, findandfix.R.layout.toolbar_layout, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ToolbarLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ToolbarLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.toolbar_layout, null, false), bindingComponent);
    }
    @NonNull
    public static ToolbarLayoutBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ToolbarLayoutBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/toolbar_layout_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ToolbarLayoutBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): viewmodel.toolbarTitle
        flag 1 (0x2L): viewmodel
        flag 2 (0x3L): viewmodel.toolbarColor
        flag 3 (0x4L): viewmodel.backimageVisibility
        flag 4 (0x5L): viewmodel.imageVisibility
        flag 5 (0x6L): foo
        flag 6 (0x7L): null
    flag mapping end*/
    //end
}