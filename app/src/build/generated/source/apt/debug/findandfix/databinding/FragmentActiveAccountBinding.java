package findandfix.databinding;
import com.findandfix.carowner.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class FragmentActiveAccountBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.iv_active_mail_logo, 1);
        sViewsWithIds.put(R.id.tv_active_mail_text, 2);
        sViewsWithIds.put(R.id.lav_animation_holder, 3);
        sViewsWithIds.put(R.id.tv_active_mail_more, 4);
        sViewsWithIds.put(R.id.tv_active_mail_site, 5);
    }
    // views
    @NonNull
    public final android.widget.ImageView ivActiveMailLogo;
    @NonNull
    public final com.airbnb.lottie.LottieAnimationView lavAnimationHolder;
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    public final android.widget.TextView tvActiveMailMore;
    @NonNull
    public final android.widget.TextView tvActiveMailSite;
    @NonNull
    public final android.widget.TextView tvActiveMailText;
    // variables
    @Nullable
    private com.findandfix.carowner.viewmodel.ActivateAccountViewModel mViewmodel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentActiveAccountBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds);
        this.ivActiveMailLogo = (android.widget.ImageView) bindings[1];
        this.lavAnimationHolder = (com.airbnb.lottie.LottieAnimationView) bindings[3];
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvActiveMailMore = (android.widget.TextView) bindings[4];
        this.tvActiveMailSite = (android.widget.TextView) bindings[5];
        this.tvActiveMailText = (android.widget.TextView) bindings[2];
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
            setViewmodel((com.findandfix.carowner.viewmodel.ActivateAccountViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewmodel(@Nullable com.findandfix.carowner.viewmodel.ActivateAccountViewModel Viewmodel) {
        this.mViewmodel = Viewmodel;
    }
    @Nullable
    public com.findandfix.carowner.viewmodel.ActivateAccountViewModel getViewmodel() {
        return mViewmodel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewmodel((com.findandfix.carowner.viewmodel.ActivateAccountViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewmodel(com.findandfix.carowner.viewmodel.ActivateAccountViewModel Viewmodel, int fieldId) {
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
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FragmentActiveAccountBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentActiveAccountBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentActiveAccountBinding>inflate(inflater, findandfix.R.layout.fragment_active_account, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentActiveAccountBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentActiveAccountBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.fragment_active_account, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentActiveAccountBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentActiveAccountBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_active_account_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentActiveAccountBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): viewmodel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}