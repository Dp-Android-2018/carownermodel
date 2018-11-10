package findandfix.databinding;
import com.findandfix.carowner.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityRequestDetailsBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(25);
        sIncludes.setIncludes(1, 
            new String[] {"toolbar_layout"},
            new int[] {2},
            new int[] {R.layout.toolbar_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.head_image, 3);
        sViewsWithIds.put(R.id.rating_content, 4);
        sViewsWithIds.put(R.id.tv_rate_value_content, 5);
        sViewsWithIds.put(R.id.tv_distance_content, 6);
        sViewsWithIds.put(R.id.tv_urgent_request_num_content, 7);
        sViewsWithIds.put(R.id.tv_normal_request_num_content, 8);
        sViewsWithIds.put(R.id.tv_request_details_type, 9);
        sViewsWithIds.put(R.id.tv_request_details_model, 10);
        sViewsWithIds.put(R.id.tv_request_details_location, 11);
        sViewsWithIds.put(R.id.tv_request_details_calender, 12);
        sViewsWithIds.put(R.id.progress1, 13);
        sViewsWithIds.put(R.id.tv_percentage, 14);
        sViewsWithIds.put(R.id.tv_desc_content, 15);
        sViewsWithIds.put(R.id.tv_price_label_content, 16);
        sViewsWithIds.put(R.id.tv_price_value_content, 17);
        sViewsWithIds.put(R.id.tv_average_time_text, 18);
        sViewsWithIds.put(R.id.tv_avg_time_value_content, 19);
        sViewsWithIds.put(R.id.tv_offer_time_text, 20);
        sViewsWithIds.put(R.id.tv_offer_time_value_content, 21);
        sViewsWithIds.put(R.id.tv_workshop_info, 22);
        sViewsWithIds.put(R.id.btn_call, 23);
        sViewsWithIds.put(R.id.btn_chat, 24);
    }
    // views
    @NonNull
    public final android.widget.Button btnCall;
    @NonNull
    public final android.widget.Button btnChat;
    @NonNull
    public final android.widget.ImageView headImage;
    @NonNull
    public final android.widget.LinearLayout llParent;
    @NonNull
    private final android.widget.ScrollView mboundView0;
    @NonNull
    public final com.cuieney.progress.library.RainbowProgressBar progress1;
    @NonNull
    public final android.widget.RatingBar ratingContent;
    @Nullable
    public final findandfix.databinding.ToolbarLayoutBinding toolbar;
    @NonNull
    public final android.widget.TextView tvAverageTimeText;
    @NonNull
    public final android.widget.TextView tvAvgTimeValueContent;
    @NonNull
    public final android.widget.TextView tvDescContent;
    @NonNull
    public final android.widget.TextView tvDistanceContent;
    @NonNull
    public final android.widget.TextView tvNormalRequestNumContent;
    @NonNull
    public final android.widget.TextView tvOfferTimeText;
    @NonNull
    public final android.widget.TextView tvOfferTimeValueContent;
    @NonNull
    public final android.widget.TextView tvPercentage;
    @NonNull
    public final android.widget.TextView tvPriceLabelContent;
    @NonNull
    public final android.widget.TextView tvPriceValueContent;
    @NonNull
    public final android.widget.TextView tvRateValueContent;
    @NonNull
    public final android.widget.TextView tvRequestDetailsCalender;
    @NonNull
    public final android.widget.TextView tvRequestDetailsLocation;
    @NonNull
    public final android.widget.TextView tvRequestDetailsModel;
    @NonNull
    public final android.widget.TextView tvRequestDetailsType;
    @NonNull
    public final android.widget.TextView tvUrgentRequestNumContent;
    @NonNull
    public final android.widget.TextView tvWorkshopInfo;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityRequestDetailsBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds);
        this.btnCall = (android.widget.Button) bindings[23];
        this.btnChat = (android.widget.Button) bindings[24];
        this.headImage = (android.widget.ImageView) bindings[3];
        this.llParent = (android.widget.LinearLayout) bindings[1];
        this.llParent.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.progress1 = (com.cuieney.progress.library.RainbowProgressBar) bindings[13];
        this.ratingContent = (android.widget.RatingBar) bindings[4];
        this.toolbar = (findandfix.databinding.ToolbarLayoutBinding) bindings[2];
        setContainedBinding(this.toolbar);
        this.tvAverageTimeText = (android.widget.TextView) bindings[18];
        this.tvAvgTimeValueContent = (android.widget.TextView) bindings[19];
        this.tvDescContent = (android.widget.TextView) bindings[15];
        this.tvDistanceContent = (android.widget.TextView) bindings[6];
        this.tvNormalRequestNumContent = (android.widget.TextView) bindings[8];
        this.tvOfferTimeText = (android.widget.TextView) bindings[20];
        this.tvOfferTimeValueContent = (android.widget.TextView) bindings[21];
        this.tvPercentage = (android.widget.TextView) bindings[14];
        this.tvPriceLabelContent = (android.widget.TextView) bindings[16];
        this.tvPriceValueContent = (android.widget.TextView) bindings[17];
        this.tvRateValueContent = (android.widget.TextView) bindings[5];
        this.tvRequestDetailsCalender = (android.widget.TextView) bindings[12];
        this.tvRequestDetailsLocation = (android.widget.TextView) bindings[11];
        this.tvRequestDetailsModel = (android.widget.TextView) bindings[10];
        this.tvRequestDetailsType = (android.widget.TextView) bindings[9];
        this.tvUrgentRequestNumContent = (android.widget.TextView) bindings[7];
        this.tvWorkshopInfo = (android.widget.TextView) bindings[22];
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
    public static ActivityRequestDetailsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityRequestDetailsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityRequestDetailsBinding>inflate(inflater, findandfix.R.layout.activity_request_details, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityRequestDetailsBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityRequestDetailsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.activity_request_details, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityRequestDetailsBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityRequestDetailsBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_request_details_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityRequestDetailsBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): toolbar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}