package findandfix.databinding;
import findandfix.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityAddUrgentRequestLocationBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(8);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar_layout"},
            new int[] {1},
            new int[] {R.layout.toolbar_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_pin_location, 2);
        sViewsWithIds.put(R.id.ll_add_urgent_request_location_holder, 3);
        sViewsWithIds.put(R.id.iv_pin_location, 4);
        sViewsWithIds.put(R.id.tv_add_urgent_request_address, 5);
        sViewsWithIds.put(R.id.tv_add_urgent_request_splitter, 6);
        sViewsWithIds.put(R.id.btn_next, 7);
    }
    // views
    @NonNull
    public final android.widget.Button btnNext;
    @NonNull
    public final android.widget.ImageView ivPinLocation;
    @NonNull
    public final android.widget.LinearLayout llAddUrgentRequestLocationHolder;
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @Nullable
    public final findandfix.databinding.ToolbarLayoutBinding toolbar;
    @NonNull
    public final android.widget.TextView tvAddUrgentRequestAddress;
    @NonNull
    public final android.view.View tvAddUrgentRequestSplitter;
    @NonNull
    public final android.widget.TextView tvPinLocation;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityAddUrgentRequestLocationBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds);
        this.btnNext = (android.widget.Button) bindings[7];
        this.ivPinLocation = (android.widget.ImageView) bindings[4];
        this.llAddUrgentRequestLocationHolder = (android.widget.LinearLayout) bindings[3];
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.toolbar = (findandfix.databinding.ToolbarLayoutBinding) bindings[1];
        setContainedBinding(this.toolbar);
        this.tvAddUrgentRequestAddress = (android.widget.TextView) bindings[5];
        this.tvAddUrgentRequestSplitter = (android.view.View) bindings[6];
        this.tvPinLocation = (android.widget.TextView) bindings[2];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeToolbar((findandfix.databinding.ToolbarLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeToolbar(findandfix.databinding.ToolbarLayoutBinding Toolbar, int fieldId) {
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
        // batch finished
        executeBindingsOn(toolbar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityAddUrgentRequestLocationBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityAddUrgentRequestLocationBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityAddUrgentRequestLocationBinding>inflate(inflater, findandfix.R.layout.activity_add_urgent_request_location, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityAddUrgentRequestLocationBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityAddUrgentRequestLocationBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.activity_add_urgent_request_location, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityAddUrgentRequestLocationBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityAddUrgentRequestLocationBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_add_urgent_request_location_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityAddUrgentRequestLocationBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): toolbar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}