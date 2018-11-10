package findandfix.databinding;
import com.findandfix.carowner.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ItemAchievmentLayoutBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_achievment_title, 1);
        sViewsWithIds.put(R.id.tv_achievment_date, 2);
        sViewsWithIds.put(R.id.ll_images, 3);
        sViewsWithIds.put(R.id.iv_before, 4);
        sViewsWithIds.put(R.id.iv_after, 5);
        sViewsWithIds.put(R.id.tv_achievment_desc, 6);
    }
    // views
    @NonNull
    public final android.support.v7.widget.CardView cvParent;
    @NonNull
    public final android.widget.ImageView ivAfter;
    @NonNull
    public final android.widget.ImageView ivBefore;
    @NonNull
    public final android.widget.LinearLayout llImages;
    @NonNull
    public final android.widget.TextView tvAchievmentDate;
    @NonNull
    public final android.widget.TextView tvAchievmentDesc;
    @NonNull
    public final android.widget.TextView tvAchievmentTitle;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemAchievmentLayoutBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
        this.cvParent = (android.support.v7.widget.CardView) bindings[0];
        this.cvParent.setTag(null);
        this.ivAfter = (android.widget.ImageView) bindings[5];
        this.ivBefore = (android.widget.ImageView) bindings[4];
        this.llImages = (android.widget.LinearLayout) bindings[3];
        this.tvAchievmentDate = (android.widget.TextView) bindings[2];
        this.tvAchievmentDesc = (android.widget.TextView) bindings[6];
        this.tvAchievmentTitle = (android.widget.TextView) bindings[1];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ItemAchievmentLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemAchievmentLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ItemAchievmentLayoutBinding>inflate(inflater, findandfix.R.layout.item_achievment_layout, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ItemAchievmentLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemAchievmentLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.item_achievment_layout, null, false), bindingComponent);
    }
    @NonNull
    public static ItemAchievmentLayoutBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemAchievmentLayoutBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/item_achievment_layout_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ItemAchievmentLayoutBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}