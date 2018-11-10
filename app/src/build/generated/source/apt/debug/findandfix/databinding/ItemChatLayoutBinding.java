package findandfix.databinding;
import com.findandfix.carowner.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ItemChatLayoutBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rl_sender_layout, 15);
        sViewsWithIds.put(R.id.rl_reciever_layout, 16);
    }
    // views
    @NonNull
    public final android.support.v7.widget.CardView cvImage;
    @NonNull
    public final android.support.v7.widget.CardView cvReciverImage;
    @NonNull
    private final android.widget.TextView mboundView10;
    @NonNull
    private final android.widget.ImageView mboundView12;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.ImageView mboundView4;
    @NonNull
    private final android.widget.ImageView mboundView5;
    @NonNull
    private final android.widget.ImageView mboundView8;
    @NonNull
    public final android.widget.RelativeLayout rlRecieverLayout;
    @NonNull
    public final android.widget.RelativeLayout rlRecieverMessage;
    @NonNull
    public final android.widget.RelativeLayout rlSenderLayout;
    @NonNull
    public final android.widget.RelativeLayout rlSenderMessage;
    @NonNull
    public final android.widget.RelativeLayout rvParent;
    @NonNull
    public final android.widget.TextView tvRecieverTime;
    @NonNull
    public final android.widget.TextView tvSender;
    @NonNull
    public final android.widget.TextView tvSenderTime;
    @NonNull
    public final android.widget.TextView tvWorkshopTitle;
    // variables
    @Nullable
    private com.findandfix.carowner.viewmodel.ItemChatDetailViewModel mViewmodel;
    // values
    // listeners
    private OnClickListenerImpl mViewmodelShowZoomAbleImageAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mViewmodelNavigateAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public ItemChatLayoutBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds);
        this.cvImage = (android.support.v7.widget.CardView) bindings[3];
        this.cvImage.setTag(null);
        this.cvReciverImage = (android.support.v7.widget.CardView) bindings[11];
        this.cvReciverImage.setTag(null);
        this.mboundView10 = (android.widget.TextView) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView12 = (android.widget.ImageView) bindings[12];
        this.mboundView12.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView4 = (android.widget.ImageView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.ImageView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView8 = (android.widget.ImageView) bindings[8];
        this.mboundView8.setTag(null);
        this.rlRecieverLayout = (android.widget.RelativeLayout) bindings[16];
        this.rlRecieverMessage = (android.widget.RelativeLayout) bindings[9];
        this.rlRecieverMessage.setTag(null);
        this.rlSenderLayout = (android.widget.RelativeLayout) bindings[15];
        this.rlSenderMessage = (android.widget.RelativeLayout) bindings[1];
        this.rlSenderMessage.setTag(null);
        this.rvParent = (android.widget.RelativeLayout) bindings[0];
        this.rvParent.setTag(null);
        this.tvRecieverTime = (android.widget.TextView) bindings[14];
        this.tvRecieverTime.setTag(null);
        this.tvSender = (android.widget.TextView) bindings[6];
        this.tvSender.setTag(null);
        this.tvSenderTime = (android.widget.TextView) bindings[7];
        this.tvSenderTime.setTag(null);
        this.tvWorkshopTitle = (android.widget.TextView) bindings[13];
        this.tvWorkshopTitle.setTag(null);
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
            setViewmodel((com.findandfix.carowner.viewmodel.ItemChatDetailViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewmodel(@Nullable com.findandfix.carowner.viewmodel.ItemChatDetailViewModel Viewmodel) {
        updateRegistration(0, Viewmodel);
        this.mViewmodel = Viewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.viewmodel);
        super.requestRebind();
    }
    @Nullable
    public com.findandfix.carowner.viewmodel.ItemChatDetailViewModel getViewmodel() {
        return mViewmodel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewmodel((com.findandfix.carowner.viewmodel.ItemChatDetailViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewmodel(com.findandfix.carowner.viewmodel.ItemChatDetailViewModel Viewmodel, int fieldId) {
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
        int viewmodelLocViewVISIBLEViewGONE = 0;
        java.lang.String viewmodelSecondUserName = null;
        int viewmodelImageViewVISIBLEViewGONE = 0;
        android.view.View.OnClickListener viewmodelShowZoomAbleImageAndroidViewViewOnClickListener = null;
        int viewmodelSenderViewVISIBLEViewGONE = 0;
        boolean viewmodelLoc = false;
        int viewmodelTextViewVISIBLEViewGONE = 0;
        java.lang.String viewmodelTime = null;
        com.findandfix.carowner.viewmodel.ItemChatDetailViewModel viewmodel = mViewmodel;
        java.lang.String viewmodelContent = null;
        boolean viewmodelText = false;
        int viewmodelSenderViewGONEViewVISIBLE = 0;
        android.view.View.OnClickListener viewmodelNavigateAndroidViewViewOnClickListener = null;
        java.lang.String viewmodelFirstUserName = null;
        boolean viewmodelSender = false;
        boolean viewmodelImage = false;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewmodel != null) {
                    // read viewmodel.secondUserName()
                    viewmodelSecondUserName = viewmodel.secondUserName();
                    // read viewmodel::showZoomAbleImage
                    viewmodelShowZoomAbleImageAndroidViewViewOnClickListener = (((mViewmodelShowZoomAbleImageAndroidViewViewOnClickListener == null) ? (mViewmodelShowZoomAbleImageAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mViewmodelShowZoomAbleImageAndroidViewViewOnClickListener).setValue(viewmodel));
                    // read viewmodel.loc
                    viewmodelLoc = viewmodel.isLoc();
                    // read viewmodel.time
                    viewmodelTime = viewmodel.getTime();
                    // read viewmodel.content
                    viewmodelContent = viewmodel.getContent();
                    // read viewmodel.text
                    viewmodelText = viewmodel.isText();
                    // read viewmodel::navigate
                    viewmodelNavigateAndroidViewViewOnClickListener = (((mViewmodelNavigateAndroidViewViewOnClickListener == null) ? (mViewmodelNavigateAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mViewmodelNavigateAndroidViewViewOnClickListener).setValue(viewmodel));
                    // read viewmodel.firstUserName()
                    viewmodelFirstUserName = viewmodel.firstUserName();
                    // read viewmodel.sender
                    viewmodelSender = viewmodel.getSender();
                    // read viewmodel.image
                    viewmodelImage = viewmodel.isImage();
                }
            if((dirtyFlags & 0x3L) != 0) {
                if(viewmodelLoc) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }
            if((dirtyFlags & 0x3L) != 0) {
                if(viewmodelText) {
                        dirtyFlags |= 0x200L;
                }
                else {
                        dirtyFlags |= 0x100L;
                }
            }
            if((dirtyFlags & 0x3L) != 0) {
                if(viewmodelSender) {
                        dirtyFlags |= 0x80L;
                        dirtyFlags |= 0x800L;
                }
                else {
                        dirtyFlags |= 0x40L;
                        dirtyFlags |= 0x400L;
                }
            }
            if((dirtyFlags & 0x3L) != 0) {
                if(viewmodelImage) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }


                // read viewmodel.loc ? View.VISIBLE : View.GONE
                viewmodelLocViewVISIBLEViewGONE = ((viewmodelLoc) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read viewmodel.text ? View.VISIBLE : View.GONE
                viewmodelTextViewVISIBLEViewGONE = ((viewmodelText) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read viewmodel.sender ? View.VISIBLE : View.GONE
                viewmodelSenderViewVISIBLEViewGONE = ((viewmodelSender) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read viewmodel.sender ? View.GONE : View.VISIBLE
                viewmodelSenderViewGONEViewVISIBLE = ((viewmodelSender) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
                // read viewmodel.image ? View.VISIBLE : View.GONE
                viewmodelImageViewVISIBLEViewGONE = ((viewmodelImage) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.cvImage.setVisibility(viewmodelImageViewVISIBLEViewGONE);
            this.cvReciverImage.setVisibility(viewmodelImageViewVISIBLEViewGONE);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView10, viewmodelContent);
            this.mboundView10.setVisibility(viewmodelTextViewVISIBLEViewGONE);
            this.mboundView12.setOnClickListener(viewmodelNavigateAndroidViewViewOnClickListener);
            this.mboundView12.setVisibility(viewmodelLocViewVISIBLEViewGONE);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, viewmodelContent);
            this.mboundView2.setVisibility(viewmodelTextViewVISIBLEViewGONE);
            com.findandfix.carowner.utils.CustomBinder.setImageConv(this.mboundView4, viewmodelContent);
            this.mboundView4.setOnClickListener(viewmodelShowZoomAbleImageAndroidViewViewOnClickListener);
            this.mboundView5.setVisibility(viewmodelLocViewVISIBLEViewGONE);
            this.mboundView5.setOnClickListener(viewmodelNavigateAndroidViewViewOnClickListener);
            this.mboundView8.setOnClickListener(viewmodelShowZoomAbleImageAndroidViewViewOnClickListener);
            com.findandfix.carowner.utils.CustomBinder.setImageConv(this.mboundView8, viewmodelContent);
            this.rlRecieverMessage.setVisibility(viewmodelSenderViewVISIBLEViewGONE);
            this.rlSenderMessage.setVisibility(viewmodelSenderViewGONEViewVISIBLE);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvRecieverTime, viewmodelTime);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvSender, viewmodelSecondUserName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvSenderTime, viewmodelTime);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvWorkshopTitle, viewmodelFirstUserName);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.ItemChatDetailViewModel value;
        public OnClickListenerImpl setValue(com.findandfix.carowner.viewmodel.ItemChatDetailViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.showZoomAbleImage(arg0);
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.ItemChatDetailViewModel value;
        public OnClickListenerImpl1 setValue(com.findandfix.carowner.viewmodel.ItemChatDetailViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.navigate(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ItemChatLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemChatLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ItemChatLayoutBinding>inflate(inflater, findandfix.R.layout.item_chat_layout, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ItemChatLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemChatLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.item_chat_layout, null, false), bindingComponent);
    }
    @NonNull
    public static ItemChatLayoutBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemChatLayoutBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/item_chat_layout_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ItemChatLayoutBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): viewmodel
        flag 1 (0x2L): null
        flag 2 (0x3L): viewmodel.loc ? View.VISIBLE : View.GONE
        flag 3 (0x4L): viewmodel.loc ? View.VISIBLE : View.GONE
        flag 4 (0x5L): viewmodel.image ? View.VISIBLE : View.GONE
        flag 5 (0x6L): viewmodel.image ? View.VISIBLE : View.GONE
        flag 6 (0x7L): viewmodel.sender ? View.VISIBLE : View.GONE
        flag 7 (0x8L): viewmodel.sender ? View.VISIBLE : View.GONE
        flag 8 (0x9L): viewmodel.text ? View.VISIBLE : View.GONE
        flag 9 (0xaL): viewmodel.text ? View.VISIBLE : View.GONE
        flag 10 (0xbL): viewmodel.sender ? View.GONE : View.VISIBLE
        flag 11 (0xcL): viewmodel.sender ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}