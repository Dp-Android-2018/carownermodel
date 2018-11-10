package findandfix.databinding;
import com.findandfix.carowner.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class HeaderMenuLayoutBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.iv_background, 1);
        sViewsWithIds.put(R.id.tv_workshop_title, 2);
        sViewsWithIds.put(R.id.tv_workshop_name, 3);
        sViewsWithIds.put(R.id.tv_workshop_mail, 4);
    }
    // views
    @NonNull
    public final android.widget.ImageView ivBackground;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    public final android.widget.TextView tvWorkshopMail;
    @NonNull
    public final android.widget.TextView tvWorkshopName;
    @NonNull
    public final android.widget.TextView tvWorkshopTitle;
    // variables
    @Nullable
    private com.findandfix.carowner.viewmodel.MainActViewModel mHeaderviewmodel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public HeaderMenuLayoutBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.ivBackground = (android.widget.ImageView) bindings[1];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvWorkshopMail = (android.widget.TextView) bindings[4];
        this.tvWorkshopName = (android.widget.TextView) bindings[3];
        this.tvWorkshopTitle = (android.widget.TextView) bindings[2];
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
        if (BR.headerviewmodel == variableId) {
            setHeaderviewmodel((com.findandfix.carowner.viewmodel.MainActViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHeaderviewmodel(@Nullable com.findandfix.carowner.viewmodel.MainActViewModel Headerviewmodel) {
        this.mHeaderviewmodel = Headerviewmodel;
    }
    @Nullable
    public com.findandfix.carowner.viewmodel.MainActViewModel getHeaderviewmodel() {
        return mHeaderviewmodel;
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
    public static HeaderMenuLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static HeaderMenuLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<HeaderMenuLayoutBinding>inflate(inflater, findandfix.R.layout.header_menu_layout, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static HeaderMenuLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static HeaderMenuLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.header_menu_layout, null, false), bindingComponent);
    }
    @NonNull
    public static HeaderMenuLayoutBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static HeaderMenuLayoutBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/header_menu_layout_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new HeaderMenuLayoutBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): headerviewmodel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}