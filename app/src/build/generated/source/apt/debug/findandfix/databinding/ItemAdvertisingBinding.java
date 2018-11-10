package findandfix.databinding;
import com.findandfix.carowner.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ItemAdvertisingBinding extends android.databinding.ViewDataBinding  {

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
    public final android.widget.ImageView ivAdv;
    @NonNull
    public final android.widget.LinearLayout llParent;
    @NonNull
    public final android.widget.TextView textView;
    @NonNull
    public final android.widget.TextView textView2;
    // variables
    @Nullable
    private com.findandfix.carowner.viewmodel.ItemOfferViewModel mViewmodel;
    // values
    // listeners
    private OnClickListenerImpl mViewmodelOnItemClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ItemAdvertisingBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds);
        this.ivAdv = (android.widget.ImageView) bindings[1];
        this.ivAdv.setTag(null);
        this.llParent = (android.widget.LinearLayout) bindings[0];
        this.llParent.setTag(null);
        this.textView = (android.widget.TextView) bindings[2];
        this.textView.setTag(null);
        this.textView2 = (android.widget.TextView) bindings[3];
        this.textView2.setTag(null);
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
            setViewmodel((com.findandfix.carowner.viewmodel.ItemOfferViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewmodel(@Nullable com.findandfix.carowner.viewmodel.ItemOfferViewModel Viewmodel) {
        updateRegistration(0, Viewmodel);
        this.mViewmodel = Viewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.viewmodel);
        super.requestRebind();
    }
    @Nullable
    public com.findandfix.carowner.viewmodel.ItemOfferViewModel getViewmodel() {
        return mViewmodel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewmodel((com.findandfix.carowner.viewmodel.ItemOfferViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewmodel(com.findandfix.carowner.viewmodel.ItemOfferViewModel Viewmodel, int fieldId) {
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
        java.lang.String viewmodelAdvTitle = null;
        java.lang.String viewmodelAdvContent = null;
        com.findandfix.carowner.viewmodel.ItemOfferViewModel viewmodel = mViewmodel;
        android.view.View.OnClickListener viewmodelOnItemClickAndroidViewViewOnClickListener = null;
        java.lang.String viewmodelImage = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewmodel != null) {
                    // read viewmodel.advTitle
                    viewmodelAdvTitle = viewmodel.getAdvTitle();
                    // read viewmodel.advContent
                    viewmodelAdvContent = viewmodel.getAdvContent();
                    // read viewmodel::onItemClick
                    viewmodelOnItemClickAndroidViewViewOnClickListener = (((mViewmodelOnItemClickAndroidViewViewOnClickListener == null) ? (mViewmodelOnItemClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mViewmodelOnItemClickAndroidViewViewOnClickListener).setValue(viewmodel));
                    // read viewmodel.image
                    viewmodelImage = viewmodel.getImage();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.findandfix.carowner.utils.CustomBinder.setImageConv(this.ivAdv, viewmodelImage);
            this.llParent.setOnClickListener(viewmodelOnItemClickAndroidViewViewOnClickListener);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textView, viewmodelAdvTitle);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textView2, viewmodelAdvContent);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.ItemOfferViewModel value;
        public OnClickListenerImpl setValue(com.findandfix.carowner.viewmodel.ItemOfferViewModel value) {
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
    public static ItemAdvertisingBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemAdvertisingBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ItemAdvertisingBinding>inflate(inflater, findandfix.R.layout.item_advertising, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ItemAdvertisingBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemAdvertisingBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.item_advertising, null, false), bindingComponent);
    }
    @NonNull
    public static ItemAdvertisingBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemAdvertisingBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/item_advertising_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ItemAdvertisingBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): viewmodel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}