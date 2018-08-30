package findandfix.databinding;
import findandfix.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class FragmentHomeBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rl_lottie, 5);
        sViewsWithIds.put(R.id.progress_bar, 6);
        sViewsWithIds.put(R.id.tv_urgent_request, 7);
        sViewsWithIds.put(R.id.tv_normal_request, 8);
        sViewsWithIds.put(R.id.tv_add_adv, 9);
        sViewsWithIds.put(R.id.tv_edit_profile, 10);
    }
    // views
    @NonNull
    public final com.airbnb.lottie.LottieAnimationView animationView;
    @NonNull
    public final de.hdodenhof.circleimageview.CircleImageView ivLogo;
    @NonNull
    public final android.widget.LinearLayout llContainer;
    @NonNull
    public final android.widget.ProgressBar progressBar;
    @NonNull
    public final android.widget.RelativeLayout rlLottie;
    @NonNull
    public final android.widget.TextView tvAddAdv;
    @NonNull
    public final android.widget.TextView tvEditProfile;
    @NonNull
    public final android.widget.TextView tvNormalRequest;
    @NonNull
    public final android.widget.TextView tvStartEngine;
    @NonNull
    public final android.widget.TextView tvStartJourney;
    @NonNull
    public final android.widget.TextView tvUrgentRequest;
    // variables
    @Nullable
    private findandfix.viewmodel.HomeFragViewModel mViewModel;
    // values
    // listeners
    private OnClickListenerImpl mViewModelStartEngineAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public FragmentHomeBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 2);
        final Object[] bindings = mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds);
        this.animationView = (com.airbnb.lottie.LottieAnimationView) bindings[2];
        this.animationView.setTag(null);
        this.ivLogo = (de.hdodenhof.circleimageview.CircleImageView) bindings[3];
        this.ivLogo.setTag(null);
        this.llContainer = (android.widget.LinearLayout) bindings[0];
        this.llContainer.setTag(null);
        this.progressBar = (android.widget.ProgressBar) bindings[6];
        this.rlLottie = (android.widget.RelativeLayout) bindings[5];
        this.tvAddAdv = (android.widget.TextView) bindings[9];
        this.tvEditProfile = (android.widget.TextView) bindings[10];
        this.tvNormalRequest = (android.widget.TextView) bindings[8];
        this.tvStartEngine = (android.widget.TextView) bindings[4];
        this.tvStartEngine.setTag(null);
        this.tvStartJourney = (android.widget.TextView) bindings[1];
        this.tvStartJourney.setTag(null);
        this.tvUrgentRequest = (android.widget.TextView) bindings[7];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.viewModel == variableId) {
            setViewModel((findandfix.viewmodel.HomeFragViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable findandfix.viewmodel.HomeFragViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }
    @Nullable
    public findandfix.viewmodel.HomeFragViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelIsTextVisible((android.databinding.ObservableBoolean) object, fieldId);
            case 1 :
                return onChangeViewModelIsImageVisible((android.databinding.ObservableBoolean) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelIsTextVisible(android.databinding.ObservableBoolean ViewModelIsTextVisible, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelIsImageVisible(android.databinding.ObservableBoolean ViewModelIsImageVisible, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        int viewModelIsTextVisibleViewVISIBLEViewGONE = 0;
        int viewModelIsImageVisibleViewVISIBLEViewGONE = 0;
        boolean viewModelIsImageVisibleGet = false;
        android.view.View.OnTouchListener viewModelOnTouchEvent = null;
        java.lang.String viewModelIsImageVisibleTvStartJourneyAndroidStringJourneyTvStartJourneyAndroidStringStartJourney = null;
        boolean viewModelIsTextVisibleGet = false;
        android.databinding.ObservableBoolean viewModelIsTextVisible = null;
        android.view.View.OnClickListener viewModelStartEngineAndroidViewViewOnClickListener = null;
        android.databinding.ObservableBoolean viewModelIsImageVisible = null;
        android.animation.Animator.AnimatorListener viewModelOnAnimationEnd = null;
        findandfix.viewmodel.HomeFragViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xcL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.onTouchEvent
                        viewModelOnTouchEvent = viewModel.onTouchEvent();
                        // read viewModel::startEngine
                        viewModelStartEngineAndroidViewViewOnClickListener = (((mViewModelStartEngineAndroidViewViewOnClickListener == null) ? (mViewModelStartEngineAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mViewModelStartEngineAndroidViewViewOnClickListener).setValue(viewModel));
                        // read viewModel.onAnimationEnd
                        viewModelOnAnimationEnd = viewModel.onAnimationEnd();
                    }
            }
            if ((dirtyFlags & 0xdL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.isTextVisible
                        viewModelIsTextVisible = viewModel.isTextVisible;
                    }
                    updateRegistration(0, viewModelIsTextVisible);


                    if (viewModelIsTextVisible != null) {
                        // read viewModel.isTextVisible.get()
                        viewModelIsTextVisibleGet = viewModelIsTextVisible.get();
                    }
                if((dirtyFlags & 0xdL) != 0) {
                    if(viewModelIsTextVisibleGet) {
                            dirtyFlags |= 0x20L;
                    }
                    else {
                            dirtyFlags |= 0x10L;
                    }
                }


                    // read viewModel.isTextVisible.get() ? View.VISIBLE : View.GONE
                    viewModelIsTextVisibleViewVISIBLEViewGONE = ((viewModelIsTextVisibleGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.isImageVisible
                        viewModelIsImageVisible = viewModel.isImageVisible;
                    }
                    updateRegistration(1, viewModelIsImageVisible);


                    if (viewModelIsImageVisible != null) {
                        // read viewModel.isImageVisible.get()
                        viewModelIsImageVisibleGet = viewModelIsImageVisible.get();
                    }
                if((dirtyFlags & 0xeL) != 0) {
                    if(viewModelIsImageVisibleGet) {
                            dirtyFlags |= 0x80L;
                            dirtyFlags |= 0x200L;
                    }
                    else {
                            dirtyFlags |= 0x40L;
                            dirtyFlags |= 0x100L;
                    }
                }


                    // read viewModel.isImageVisible.get() ? View.VISIBLE : View.GONE
                    viewModelIsImageVisibleViewVISIBLEViewGONE = ((viewModelIsImageVisibleGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                    // read viewModel.isImageVisible.get() ? @android:string/journey : @android:string/start_journey
                    viewModelIsImageVisibleTvStartJourneyAndroidStringJourneyTvStartJourneyAndroidStringStartJourney = ((viewModelIsImageVisibleGet) ? (tvStartJourney.getResources().getString(R.string.journey)) : (tvStartJourney.getResources().getString(R.string.start_journey)));
            }
        }
        // batch finished
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            findandfix.utils.CustomBinder.onAnimationEnd(this.animationView, viewModelOnAnimationEnd);
            findandfix.utils.CustomBinder.onTouch(this.animationView, viewModelOnTouchEvent);
            this.ivLogo.setOnClickListener(viewModelStartEngineAndroidViewViewOnClickListener);
            this.tvStartEngine.setOnClickListener(viewModelStartEngineAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            this.ivLogo.setVisibility(viewModelIsImageVisibleViewVISIBLEViewGONE);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.tvStartJourney, viewModelIsImageVisibleTvStartJourneyAndroidStringJourneyTvStartJourneyAndroidStringStartJourney);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.tvStartEngine.setVisibility(viewModelIsTextVisibleViewVISIBLEViewGONE);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private findandfix.viewmodel.HomeFragViewModel value;
        public OnClickListenerImpl setValue(findandfix.viewmodel.HomeFragViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.startEngine(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FragmentHomeBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentHomeBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentHomeBinding>inflate(inflater, findandfix.R.layout.fragment_home, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentHomeBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentHomeBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.fragment_home, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentHomeBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentHomeBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_home_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentHomeBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): viewModel.isTextVisible
        flag 1 (0x2L): viewModel.isImageVisible
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
        flag 4 (0x5L): viewModel.isTextVisible.get() ? View.VISIBLE : View.GONE
        flag 5 (0x6L): viewModel.isTextVisible.get() ? View.VISIBLE : View.GONE
        flag 6 (0x7L): viewModel.isImageVisible.get() ? View.VISIBLE : View.GONE
        flag 7 (0x8L): viewModel.isImageVisible.get() ? View.VISIBLE : View.GONE
        flag 8 (0x9L): viewModel.isImageVisible.get() ? @android:string/journey : @android:string/start_journey
        flag 9 (0xaL): viewModel.isImageVisible.get() ? @android:string/journey : @android:string/start_journey
    flag mapping end*/
    //end
}