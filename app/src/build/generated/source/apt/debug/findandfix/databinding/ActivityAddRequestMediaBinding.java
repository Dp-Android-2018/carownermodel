package findandfix.databinding;
import com.findandfix.carowner.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityAddRequestMediaBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(13);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar_layout"},
            new int[] {1},
            new int[] {R.layout.toolbar_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.progress_bar, 2);
        sViewsWithIds.put(R.id.tv_add_request_car_info, 3);
        sViewsWithIds.put(R.id.iv_add_request_3_photo, 4);
        sViewsWithIds.put(R.id.rl_add_request_5_images, 5);
        sViewsWithIds.put(R.id.rv_images, 6);
        sViewsWithIds.put(R.id.btn_choose_images, 7);
        sViewsWithIds.put(R.id.rl_add_request_5_videos, 8);
        sViewsWithIds.put(R.id.iv_video_placeholder, 9);
        sViewsWithIds.put(R.id.btn_choose_video, 10);
        sViewsWithIds.put(R.id.btn_next, 11);
        sViewsWithIds.put(R.id.ll_add_request_2_steps_holder, 12);
    }
    // views
    @NonNull
    public final android.widget.Button btnChooseImages;
    @NonNull
    public final android.widget.Button btnChooseVideo;
    @NonNull
    public final android.widget.Button btnNext;
    @NonNull
    public final android.widget.ImageView ivAddRequest3Photo;
    @NonNull
    public final android.widget.ImageView ivVideoPlaceholder;
    @NonNull
    public final android.widget.LinearLayout llAddRequest2StepsHolder;
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    public final android.widget.ProgressBar progressBar;
    @NonNull
    public final android.widget.RelativeLayout rlAddRequest5Images;
    @NonNull
    public final android.widget.RelativeLayout rlAddRequest5Videos;
    @NonNull
    public final android.support.v7.widget.RecyclerView rvImages;
    @Nullable
    public final findandfix.databinding.ToolbarLayoutBinding toolbar;
    @NonNull
    public final android.widget.TextView tvAddRequestCarInfo;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityAddRequestMediaBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds);
        this.btnChooseImages = (android.widget.Button) bindings[7];
        this.btnChooseVideo = (android.widget.Button) bindings[10];
        this.btnNext = (android.widget.Button) bindings[11];
        this.ivAddRequest3Photo = (android.widget.ImageView) bindings[4];
        this.ivVideoPlaceholder = (android.widget.ImageView) bindings[9];
        this.llAddRequest2StepsHolder = (android.widget.LinearLayout) bindings[12];
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.progressBar = (android.widget.ProgressBar) bindings[2];
        this.rlAddRequest5Images = (android.widget.RelativeLayout) bindings[5];
        this.rlAddRequest5Videos = (android.widget.RelativeLayout) bindings[8];
        this.rvImages = (android.support.v7.widget.RecyclerView) bindings[6];
        this.toolbar = (findandfix.databinding.ToolbarLayoutBinding) bindings[1];
        setContainedBinding(this.toolbar);
        this.tvAddRequestCarInfo = (android.widget.TextView) bindings[3];
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
    public static ActivityAddRequestMediaBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityAddRequestMediaBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityAddRequestMediaBinding>inflate(inflater, findandfix.R.layout.activity_add_request_media, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityAddRequestMediaBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityAddRequestMediaBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.activity_add_request_media, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityAddRequestMediaBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityAddRequestMediaBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_add_request_media_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityAddRequestMediaBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): toolbar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}