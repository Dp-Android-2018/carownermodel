package findandfix.databinding;
import com.findandfix.carowner.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityMyConversationLayoutBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(5);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar_layout"},
            new int[] {3},
            new int[] {R.layout.toolbar_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv1, 4);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.RelativeLayout mboundView2;
    @NonNull
    public final android.support.v7.widget.RecyclerView rvMyConversation;
    @Nullable
    public final findandfix.databinding.ToolbarLayoutBinding toolbar;
    @NonNull
    public final android.widget.TextView tv1;
    // variables
    @Nullable
    private com.findandfix.carowner.viewmodel.ConversationViewModel mConversationviewmodel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMyConversationLayoutBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 5);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.RelativeLayout) bindings[2];
        this.mboundView2.setTag(null);
        this.rvMyConversation = (android.support.v7.widget.RecyclerView) bindings[1];
        this.rvMyConversation.setTag(null);
        this.toolbar = (findandfix.databinding.ToolbarLayoutBinding) bindings[3];
        setContainedBinding(this.toolbar);
        this.tv1 = (android.widget.TextView) bindings[4];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
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
        if (BR.conversationviewmodel == variableId) {
            setConversationviewmodel((com.findandfix.carowner.viewmodel.ConversationViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setConversationviewmodel(@Nullable com.findandfix.carowner.viewmodel.ConversationViewModel Conversationviewmodel) {
        updateRegistration(4, Conversationviewmodel);
        this.mConversationviewmodel = Conversationviewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.conversationviewmodel);
        super.requestRebind();
    }
    @Nullable
    public com.findandfix.carowner.viewmodel.ConversationViewModel getConversationviewmodel() {
        return mConversationviewmodel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeConversationviewmodelHistories((android.databinding.ObservableList<com.findandfix.carowner.model.global.Conv.ConversationHistory>) object, fieldId);
            case 1 :
                return onChangeConversationviewmodelNoData((android.databinding.ObservableField<java.lang.Integer>) object, fieldId);
            case 2 :
                return onChangeToolbar((findandfix.databinding.ToolbarLayoutBinding) object, fieldId);
            case 3 :
                return onChangeConversationviewmodelHasData((android.databinding.ObservableField<java.lang.Integer>) object, fieldId);
            case 4 :
                return onChangeConversationviewmodel((com.findandfix.carowner.viewmodel.ConversationViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeConversationviewmodelHistories(android.databinding.ObservableList<com.findandfix.carowner.model.global.Conv.ConversationHistory> ConversationviewmodelHistories, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeConversationviewmodelNoData(android.databinding.ObservableField<java.lang.Integer> ConversationviewmodelNoData, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeToolbar(findandfix.databinding.ToolbarLayoutBinding Toolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeConversationviewmodelHasData(android.databinding.ObservableField<java.lang.Integer> ConversationviewmodelHasData, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeConversationviewmodel(com.findandfix.carowner.viewmodel.ConversationViewModel Conversationviewmodel, int fieldId) {
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
        java.lang.Integer conversationviewmodelNoDataGet = null;
        android.databinding.ObservableList<com.findandfix.carowner.model.global.Conv.ConversationHistory> conversationviewmodelHistories = null;
        android.databinding.ObservableField<java.lang.Integer> conversationviewmodelNoData = null;
        int androidDatabindingDynamicUtilSafeUnboxConversationviewmodelHasDataGet = 0;
        java.lang.Integer conversationviewmodelHasDataGet = null;
        android.databinding.ObservableField<java.lang.Integer> conversationviewmodelHasData = null;
        int androidDatabindingDynamicUtilSafeUnboxConversationviewmodelNoDataGet = 0;
        com.findandfix.carowner.viewmodel.ConversationViewModel conversationviewmodel = mConversationviewmodel;

        if ((dirtyFlags & 0x3bL) != 0) {


            if ((dirtyFlags & 0x31L) != 0) {

                    if (conversationviewmodel != null) {
                        // read conversationviewmodel.histories
                        conversationviewmodelHistories = conversationviewmodel.histories;
                    }
                    updateRegistration(0, conversationviewmodelHistories);
            }
            if ((dirtyFlags & 0x32L) != 0) {

                    if (conversationviewmodel != null) {
                        // read conversationviewmodel.noData
                        conversationviewmodelNoData = conversationviewmodel.noData;
                    }
                    updateRegistration(1, conversationviewmodelNoData);


                    if (conversationviewmodelNoData != null) {
                        // read conversationviewmodel.noData.get()
                        conversationviewmodelNoDataGet = conversationviewmodelNoData.get();
                    }


                    // read android.databinding.DynamicUtil.safeUnbox(conversationviewmodel.noData.get())
                    androidDatabindingDynamicUtilSafeUnboxConversationviewmodelNoDataGet = android.databinding.DynamicUtil.safeUnbox(conversationviewmodelNoDataGet);
            }
            if ((dirtyFlags & 0x38L) != 0) {

                    if (conversationviewmodel != null) {
                        // read conversationviewmodel.hasData
                        conversationviewmodelHasData = conversationviewmodel.hasData;
                    }
                    updateRegistration(3, conversationviewmodelHasData);


                    if (conversationviewmodelHasData != null) {
                        // read conversationviewmodel.hasData.get()
                        conversationviewmodelHasDataGet = conversationviewmodelHasData.get();
                    }


                    // read android.databinding.DynamicUtil.safeUnbox(conversationviewmodel.hasData.get())
                    androidDatabindingDynamicUtilSafeUnboxConversationviewmodelHasDataGet = android.databinding.DynamicUtil.safeUnbox(conversationviewmodelHasDataGet);
            }
        }
        // batch finished
        if ((dirtyFlags & 0x32L) != 0) {
            // api target 1

            this.mboundView2.setVisibility(androidDatabindingDynamicUtilSafeUnboxConversationviewmodelNoDataGet);
        }
        if ((dirtyFlags & 0x38L) != 0) {
            // api target 1

            this.rvMyConversation.setVisibility(androidDatabindingDynamicUtilSafeUnboxConversationviewmodelHasDataGet);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            com.findandfix.carowner.utils.CustomBinder.setRecyclerConversation(this.rvMyConversation, conversationviewmodelHistories);
        }
        executeBindingsOn(toolbar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityMyConversationLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMyConversationLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityMyConversationLayoutBinding>inflate(inflater, findandfix.R.layout.activity_my_conversation_layout, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityMyConversationLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMyConversationLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.activity_my_conversation_layout, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityMyConversationLayoutBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMyConversationLayoutBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_my_conversation_layout_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityMyConversationLayoutBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): conversationviewmodel.histories
        flag 1 (0x2L): conversationviewmodel.noData
        flag 2 (0x3L): toolbar
        flag 3 (0x4L): conversationviewmodel.hasData
        flag 4 (0x5L): conversationviewmodel
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}