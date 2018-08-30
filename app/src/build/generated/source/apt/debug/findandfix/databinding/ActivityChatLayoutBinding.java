package findandfix.databinding;
import findandfix.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityChatLayoutBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(8);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar_layout"},
            new int[] {6},
            new int[] {R.layout.toolbar_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relativeLayout, 7);
    }
    // views
    @NonNull
    public final android.widget.ImageView ivAddText;
    @NonNull
    public final android.widget.ImageView ivShareImage;
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.ImageView mboundView4;
    @NonNull
    private final android.widget.EditText mboundView5;
    @NonNull
    public final android.widget.RelativeLayout relativeLayout;
    @NonNull
    public final android.support.v7.widget.RecyclerView rvChat;
    @Nullable
    public final findandfix.databinding.ToolbarLayoutBinding toolbar;
    // variables
    @Nullable
    private findandfix.viewmodel.ChatViewModel mViewmodel;
    // values
    // listeners
    private OnClickListenerImpl mViewmodelAddMessageActionAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mViewmodelDisplayDialogAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mViewmodelShareLocationAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener mboundView5androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.message.get()
            //         is viewmodel.message.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView5);
            // localize variables for thread safety
            // viewmodel.message
            android.databinding.ObservableField<java.lang.String> viewmodelMessage = null;
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.message != null
            boolean viewmodelMessageJavaLangObjectNull = false;
            // viewmodel.message.get()
            java.lang.String viewmodelMessageGet = null;
            // viewmodel
            findandfix.viewmodel.ChatViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelMessage = viewmodel.message;

                viewmodelMessageJavaLangObjectNull = (viewmodelMessage) != (null);
                if (viewmodelMessageJavaLangObjectNull) {




                    viewmodelMessage.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityChatLayoutBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 4);
        final Object[] bindings = mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds);
        this.ivAddText = (android.widget.ImageView) bindings[2];
        this.ivAddText.setTag(null);
        this.ivShareImage = (android.widget.ImageView) bindings[3];
        this.ivShareImage.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView4 = (android.widget.ImageView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.EditText) bindings[5];
        this.mboundView5.setTag(null);
        this.relativeLayout = (android.widget.RelativeLayout) bindings[7];
        this.rvChat = (android.support.v7.widget.RecyclerView) bindings[1];
        this.rvChat.setTag(null);
        this.toolbar = (findandfix.databinding.ToolbarLayoutBinding) bindings[6];
        setContainedBinding(this.toolbar);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
        if (BR.viewmodel == variableId) {
            setViewmodel((findandfix.viewmodel.ChatViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewmodel(@Nullable findandfix.viewmodel.ChatViewModel Viewmodel) {
        updateRegistration(1, Viewmodel);
        this.mViewmodel = Viewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewmodel);
        super.requestRebind();
    }
    @Nullable
    public findandfix.viewmodel.ChatViewModel getViewmodel() {
        return mViewmodel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewmodelMessage((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewmodel((findandfix.viewmodel.ChatViewModel) object, fieldId);
            case 2 :
                return onChangeViewmodelMessages((android.databinding.ObservableList<findandfix.model.global.Conv.Message>) object, fieldId);
            case 3 :
                return onChangeToolbar((findandfix.databinding.ToolbarLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewmodelMessage(android.databinding.ObservableField<java.lang.String> ViewmodelMessage, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodel(findandfix.viewmodel.ChatViewModel Viewmodel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelMessages(android.databinding.ObservableList<findandfix.model.global.Conv.Message> ViewmodelMessages, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeToolbar(findandfix.databinding.ToolbarLayoutBinding Toolbar, int fieldId) {
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
        android.view.View.OnClickListener viewmodelAddMessageActionAndroidViewViewOnClickListener = null;
        android.databinding.ObservableField<java.lang.String> viewmodelMessage = null;
        android.view.View.OnClickListener viewmodelDisplayDialogAndroidViewViewOnClickListener = null;
        java.lang.String viewmodelMessageGet = null;
        findandfix.viewmodel.ChatViewModel viewmodel = mViewmodel;
        android.databinding.ObservableList<findandfix.model.global.Conv.Message> viewmodelMessages = null;
        android.view.View.OnClickListener viewmodelShareLocationAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x17L) != 0) {


            if ((dirtyFlags & 0x12L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel::addMessageAction
                        viewmodelAddMessageActionAndroidViewViewOnClickListener = (((mViewmodelAddMessageActionAndroidViewViewOnClickListener == null) ? (mViewmodelAddMessageActionAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mViewmodelAddMessageActionAndroidViewViewOnClickListener).setValue(viewmodel));
                        // read viewmodel::displayDialog
                        viewmodelDisplayDialogAndroidViewViewOnClickListener = (((mViewmodelDisplayDialogAndroidViewViewOnClickListener == null) ? (mViewmodelDisplayDialogAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mViewmodelDisplayDialogAndroidViewViewOnClickListener).setValue(viewmodel));
                        // read viewmodel::shareLocation
                        viewmodelShareLocationAndroidViewViewOnClickListener = (((mViewmodelShareLocationAndroidViewViewOnClickListener == null) ? (mViewmodelShareLocationAndroidViewViewOnClickListener = new OnClickListenerImpl2()) : mViewmodelShareLocationAndroidViewViewOnClickListener).setValue(viewmodel));
                    }
            }
            if ((dirtyFlags & 0x13L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.message
                        viewmodelMessage = viewmodel.message;
                    }
                    updateRegistration(0, viewmodelMessage);


                    if (viewmodelMessage != null) {
                        // read viewmodel.message.get()
                        viewmodelMessageGet = viewmodelMessage.get();
                    }
            }
            if ((dirtyFlags & 0x16L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.messages
                        viewmodelMessages = viewmodel.messages;
                    }
                    updateRegistration(2, viewmodelMessages);
            }
        }
        // batch finished
        if ((dirtyFlags & 0x12L) != 0) {
            // api target 1

            this.ivAddText.setOnClickListener(viewmodelAddMessageActionAndroidViewViewOnClickListener);
            this.ivShareImage.setOnClickListener(viewmodelDisplayDialogAndroidViewViewOnClickListener);
            this.mboundView4.setOnClickListener(viewmodelShareLocationAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x13L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, viewmodelMessageGet);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView5, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView5androidTextAttrChanged);
        }
        if ((dirtyFlags & 0x16L) != 0) {
            // api target 1

            findandfix.utils.CustomBinder.setRecyclerConversationDetails(this.rvChat, viewmodelMessages);
        }
        executeBindingsOn(toolbar);
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private findandfix.viewmodel.ChatViewModel value;
        public OnClickListenerImpl setValue(findandfix.viewmodel.ChatViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.addMessageAction(arg0);
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private findandfix.viewmodel.ChatViewModel value;
        public OnClickListenerImpl1 setValue(findandfix.viewmodel.ChatViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.displayDialog(arg0);
        }
    }
    public static class OnClickListenerImpl2 implements android.view.View.OnClickListener{
        private findandfix.viewmodel.ChatViewModel value;
        public OnClickListenerImpl2 setValue(findandfix.viewmodel.ChatViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.shareLocation(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityChatLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityChatLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityChatLayoutBinding>inflate(inflater, findandfix.R.layout.activity_chat_layout, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityChatLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityChatLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.activity_chat_layout, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityChatLayoutBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityChatLayoutBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_chat_layout_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityChatLayoutBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): viewmodel.message
        flag 1 (0x2L): viewmodel
        flag 2 (0x3L): viewmodel.messages
        flag 3 (0x4L): toolbar
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}