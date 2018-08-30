package findandfix.databinding;
import findandfix.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityUrgentRequstInfoBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(19);
        sIncludes.setIncludes(1, 
            new String[] {"toolbar_layout"},
            new int[] {2},
            new int[] {R.layout.toolbar_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rb_urgent_request_rating, 3);
        sViewsWithIds.put(R.id.tv_add_urgent_request_total, 4);
        sViewsWithIds.put(R.id.tv_date, 5);
        sViewsWithIds.put(R.id.tv_normal_request_num, 6);
        sViewsWithIds.put(R.id.tv_urgent_request_num, 7);
        sViewsWithIds.put(R.id.tv_address, 8);
        sViewsWithIds.put(R.id.iv_urgent_type, 9);
        sViewsWithIds.put(R.id.tv_urgent_type, 10);
        sViewsWithIds.put(R.id.tv_desc, 11);
        sViewsWithIds.put(R.id.view2, 12);
        sViewsWithIds.put(R.id.tv_record, 13);
        sViewsWithIds.put(R.id.visualizer, 14);
        sViewsWithIds.put(R.id.iv_play_record, 15);
        sViewsWithIds.put(R.id.view1, 16);
        sViewsWithIds.put(R.id.ll_call, 17);
        sViewsWithIds.put(R.id.iv_chat, 18);
    }
    // views
    @NonNull
    public final android.widget.ImageView ivChat;
    @NonNull
    public final android.widget.ImageView ivPlayRecord;
    @NonNull
    public final android.widget.ImageView ivUrgentType;
    @NonNull
    public final android.widget.LinearLayout llCall;
    @NonNull
    public final android.widget.LinearLayout llParent;
    @NonNull
    private final android.widget.ScrollView mboundView0;
    @NonNull
    public final me.zhanghai.android.materialratingbar.MaterialRatingBar rbUrgentRequestRating;
    @Nullable
    public final findandfix.databinding.ToolbarLayoutBinding toolbar;
    @NonNull
    public final android.widget.TextView tvAddUrgentRequestTotal;
    @NonNull
    public final android.widget.TextView tvAddress;
    @NonNull
    public final android.widget.TextView tvDate;
    @NonNull
    public final android.widget.TextView tvDesc;
    @NonNull
    public final android.widget.TextView tvNormalRequestNum;
    @NonNull
    public final android.widget.TextView tvRecord;
    @NonNull
    public final android.widget.TextView tvUrgentRequestNum;
    @NonNull
    public final android.widget.TextView tvUrgentType;
    @NonNull
    public final android.view.View view1;
    @NonNull
    public final android.view.View view2;
    @NonNull
    public final com.chibde.visualizer.BarVisualizer visualizer;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityUrgentRequstInfoBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds);
        this.ivChat = (android.widget.ImageView) bindings[18];
        this.ivPlayRecord = (android.widget.ImageView) bindings[15];
        this.ivUrgentType = (android.widget.ImageView) bindings[9];
        this.llCall = (android.widget.LinearLayout) bindings[17];
        this.llParent = (android.widget.LinearLayout) bindings[1];
        this.llParent.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.rbUrgentRequestRating = (me.zhanghai.android.materialratingbar.MaterialRatingBar) bindings[3];
        this.toolbar = (findandfix.databinding.ToolbarLayoutBinding) bindings[2];
        setContainedBinding(this.toolbar);
        this.tvAddUrgentRequestTotal = (android.widget.TextView) bindings[4];
        this.tvAddress = (android.widget.TextView) bindings[8];
        this.tvDate = (android.widget.TextView) bindings[5];
        this.tvDesc = (android.widget.TextView) bindings[11];
        this.tvNormalRequestNum = (android.widget.TextView) bindings[6];
        this.tvRecord = (android.widget.TextView) bindings[13];
        this.tvUrgentRequestNum = (android.widget.TextView) bindings[7];
        this.tvUrgentType = (android.widget.TextView) bindings[10];
        this.view1 = (android.view.View) bindings[16];
        this.view2 = (android.view.View) bindings[12];
        this.visualizer = (com.chibde.visualizer.BarVisualizer) bindings[14];
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
    public static ActivityUrgentRequstInfoBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityUrgentRequstInfoBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityUrgentRequstInfoBinding>inflate(inflater, findandfix.R.layout.activity_urgent_requst_info, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityUrgentRequstInfoBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityUrgentRequstInfoBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.activity_urgent_requst_info, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityUrgentRequstInfoBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityUrgentRequstInfoBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_urgent_requst_info_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityUrgentRequstInfoBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): toolbar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}