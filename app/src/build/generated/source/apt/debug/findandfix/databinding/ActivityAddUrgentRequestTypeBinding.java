package findandfix.databinding;
import findandfix.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityAddUrgentRequestTypeBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(9);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar_layout"},
            new int[] {1},
            new int[] {R.layout.toolbar_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_choose, 2);
        sViewsWithIds.put(R.id.ll_add_urgent_request_types_holder, 3);
        sViewsWithIds.put(R.id.iv_gas, 4);
        sViewsWithIds.put(R.id.iv_tire, 5);
        sViewsWithIds.put(R.id.iv_towed, 6);
        sViewsWithIds.put(R.id.iv_battery, 7);
        sViewsWithIds.put(R.id.btn_next, 8);
    }
    // views
    @NonNull
    public final android.widget.Button btnNext;
    @NonNull
    public final android.widget.ImageView ivBattery;
    @NonNull
    public final android.widget.ImageView ivGas;
    @NonNull
    public final android.widget.ImageView ivTire;
    @NonNull
    public final android.widget.ImageView ivTowed;
    @NonNull
    public final android.widget.LinearLayout llAddUrgentRequestTypesHolder;
    @NonNull
    public final android.widget.RelativeLayout rlParent;
    @Nullable
    public final findandfix.databinding.ToolbarLayoutBinding toolbar;
    @NonNull
    public final android.widget.TextView tvChoose;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityAddUrgentRequestTypeBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds);
        this.btnNext = (android.widget.Button) bindings[8];
        this.ivBattery = (android.widget.ImageView) bindings[7];
        this.ivGas = (android.widget.ImageView) bindings[4];
        this.ivTire = (android.widget.ImageView) bindings[5];
        this.ivTowed = (android.widget.ImageView) bindings[6];
        this.llAddUrgentRequestTypesHolder = (android.widget.LinearLayout) bindings[3];
        this.rlParent = (android.widget.RelativeLayout) bindings[0];
        this.rlParent.setTag(null);
        this.toolbar = (findandfix.databinding.ToolbarLayoutBinding) bindings[1];
        setContainedBinding(this.toolbar);
        this.tvChoose = (android.widget.TextView) bindings[2];
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
    public static ActivityAddUrgentRequestTypeBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityAddUrgentRequestTypeBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityAddUrgentRequestTypeBinding>inflate(inflater, findandfix.R.layout.activity_add_urgent_request_type, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityAddUrgentRequestTypeBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityAddUrgentRequestTypeBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.activity_add_urgent_request_type, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityAddUrgentRequestTypeBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityAddUrgentRequestTypeBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_add_urgent_request_type_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityAddUrgentRequestTypeBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): toolbar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}