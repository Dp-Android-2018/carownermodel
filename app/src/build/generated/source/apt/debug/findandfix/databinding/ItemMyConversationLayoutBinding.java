package findandfix.databinding;
import findandfix.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ItemMyConversationLayoutBinding extends android.databinding.ViewDataBinding  {

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
    public final android.support.v7.widget.CardView cvParent;
    @NonNull
    public final android.widget.TextView tvAdvDesc;
    @NonNull
    public final android.widget.TextView tvClientName;
    @NonNull
    public final android.widget.TextView tvDate;
    // variables
    @Nullable
    private findandfix.viewmodel.ItemConversationViewModel mViewmodel;
    // values
    // listeners
    private OnClickListenerImpl mViewmodelOnItemClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ItemMyConversationLayoutBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds);
        this.cvParent = (android.support.v7.widget.CardView) bindings[0];
        this.cvParent.setTag(null);
        this.tvAdvDesc = (android.widget.TextView) bindings[3];
        this.tvAdvDesc.setTag(null);
        this.tvClientName = (android.widget.TextView) bindings[1];
        this.tvClientName.setTag(null);
        this.tvDate = (android.widget.TextView) bindings[2];
        this.tvDate.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
            setViewmodel((findandfix.viewmodel.ItemConversationViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewmodel(@Nullable findandfix.viewmodel.ItemConversationViewModel Viewmodel) {
        updateRegistration(0, Viewmodel);
        this.mViewmodel = Viewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.viewmodel);
        super.requestRebind();
    }
    @Nullable
    public findandfix.viewmodel.ItemConversationViewModel getViewmodel() {
        return mViewmodel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewmodel((findandfix.viewmodel.ItemConversationViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewmodel(findandfix.viewmodel.ItemConversationViewModel Viewmodel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
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
        java.lang.String viewmodelUserName = null;
        java.lang.String viewmodelTime = null;
        findandfix.viewmodel.ItemConversationViewModel viewmodel = mViewmodel;
        android.view.View.OnClickListener viewmodelOnItemClickAndroidViewViewOnClickListener = null;
        java.lang.String viewmodelLastMessage = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewmodel != null) {
                    // read viewmodel.userName
                    viewmodelUserName = viewmodel.getUserName();
                    // read viewmodel.time
                    viewmodelTime = viewmodel.getTime();
                    // read viewmodel::onItemClick
                    viewmodelOnItemClickAndroidViewViewOnClickListener = (((mViewmodelOnItemClickAndroidViewViewOnClickListener == null) ? (mViewmodelOnItemClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mViewmodelOnItemClickAndroidViewViewOnClickListener).setValue(viewmodel));
                    // read viewmodel.lastMessage
                    viewmodelLastMessage = viewmodel.getLastMessage();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.cvParent.setOnClickListener(viewmodelOnItemClickAndroidViewViewOnClickListener);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvAdvDesc, viewmodelLastMessage);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvClientName, viewmodelUserName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvDate, viewmodelTime);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private findandfix.viewmodel.ItemConversationViewModel value;
        public OnClickListenerImpl setValue(findandfix.viewmodel.ItemConversationViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onItemClick(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ItemMyConversationLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemMyConversationLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ItemMyConversationLayoutBinding>inflate(inflater, findandfix.R.layout.item_my_conversation_layout, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ItemMyConversationLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemMyConversationLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.item_my_conversation_layout, null, false), bindingComponent);
    }
    @NonNull
    public static ItemMyConversationLayoutBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemMyConversationLayoutBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/item_my_conversation_layout_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ItemMyConversationLayoutBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): viewmodel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}