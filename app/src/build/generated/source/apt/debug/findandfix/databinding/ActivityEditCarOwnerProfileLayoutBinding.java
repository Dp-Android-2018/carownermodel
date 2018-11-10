package findandfix.databinding;
import com.findandfix.carowner.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityEditCarOwnerProfileLayoutBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(29);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar_layout"},
            new int[] {20},
            new int[] {R.layout.toolbar_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ll_container, 21);
        sViewsWithIds.put(R.id.rl_car_owner_pic, 22);
        sViewsWithIds.put(R.id.tv_workshop_info, 23);
        sViewsWithIds.put(R.id.ll_workshop_info, 24);
        sViewsWithIds.put(R.id.tv_workshop_specialization, 25);
        sViewsWithIds.put(R.id.ll_workshop_specialization, 26);
        sViewsWithIds.put(R.id.tv_change_password, 27);
        sViewsWithIds.put(R.id.iv_change_password_page, 28);
    }
    // views
    @NonNull
    public final android.widget.Button btnSubmit;
    @NonNull
    public final android.widget.EditText etEditProfileWorkshopName;
    @NonNull
    public final android.widget.ImageView ivBrands;
    @NonNull
    public final de.hdodenhof.circleimageview.CircleImageView ivCarOwnerImage;
    @NonNull
    public final android.widget.ImageView ivChangePasswordPage;
    @NonNull
    public final android.widget.ImageView ivCitiesDialog;
    @NonNull
    public final android.widget.ImageView ivCountriesDialog;
    @NonNull
    public final de.hdodenhof.circleimageview.CircleImageView ivLogo;
    @NonNull
    public final android.widget.ImageView ivSpecialization;
    @NonNull
    public final android.widget.ImageView ivUrgents;
    @NonNull
    public final android.widget.LinearLayout llChangePassword;
    @NonNull
    public final android.widget.RelativeLayout llContainer;
    @NonNull
    public final android.widget.LinearLayout llWorkshopInfo;
    @NonNull
    public final android.widget.LinearLayout llWorkshopSpecialization;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.EditText mboundView11;
    @NonNull
    private final android.widget.EditText mboundView13;
    @NonNull
    private final android.widget.EditText mboundView15;
    @NonNull
    private final android.widget.EditText mboundView17;
    @NonNull
    private final android.widget.ImageView mboundView3;
    @NonNull
    private final android.widget.EditText mboundView5;
    @NonNull
    private final android.widget.EditText mboundView6;
    @NonNull
    private final android.widget.EditText mboundView7;
    @NonNull
    private final android.widget.EditText mboundView9;
    @NonNull
    public final android.widget.RelativeLayout rlCarOwnerPic;
    @Nullable
    public final findandfix.databinding.ToolbarLayoutBinding toolbar;
    @NonNull
    public final android.widget.TextView tvChangePassword;
    @NonNull
    public final android.widget.TextView tvWorkshopInfo;
    @NonNull
    public final android.widget.TextView tvWorkshopSpecialization;
    // variables
    @Nullable
    private com.findandfix.carowner.viewmodel.EditProfileInfoViewModel mViewmodel;
    // values
    // listeners
    private OnClickListenerImpl mViewmodelShowCountriesAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mViewmodelShowCitiesAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mViewmodelValidateAndroidViewViewOnClickListener;
    private OnClickListenerImpl3 mViewmodelShowModelsAndroidViewViewOnClickListener;
    private OnClickListenerImpl4 mViewmodelDisplayDialogAndroidViewViewOnClickListener;
    private OnClickListenerImpl5 mViewmodelChangePasswordActAndroidViewViewOnClickListener;
    private OnClickListenerImpl6 mViewmodelShowYearsAndroidViewViewOnClickListener;
    private OnClickListenerImpl7 mViewmodelShowCarBrandsAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener etEditProfileWorkshopNameandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.fname.get()
            //         is viewmodel.fname.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(etEditProfileWorkshopName);
            // localize variables for thread safety
            // viewmodel.fname.get()
            java.lang.String viewmodelFnameGet = null;
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.fname
            android.databinding.ObservableField<java.lang.String> viewmodelFname = null;
            // viewmodel.fname != null
            boolean viewmodelFnameJavaLangObjectNull = false;
            // viewmodel
            com.findandfix.carowner.viewmodel.EditProfileInfoViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelFname = viewmodel.fname;

                viewmodelFnameJavaLangObjectNull = (viewmodelFname) != (null);
                if (viewmodelFnameJavaLangObjectNull) {




                    viewmodelFname.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView11androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.city.get()
            //         is viewmodel.city.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView11);
            // localize variables for thread safety
            // viewmodel.city.get()
            java.lang.String viewmodelCityGet = null;
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.city != null
            boolean viewmodelCityJavaLangObjectNull = false;
            // viewmodel.city
            android.databinding.ObservableField<java.lang.String> viewmodelCity = null;
            // viewmodel
            com.findandfix.carowner.viewmodel.EditProfileInfoViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelCity = viewmodel.city;

                viewmodelCityJavaLangObjectNull = (viewmodelCity) != (null);
                if (viewmodelCityJavaLangObjectNull) {




                    viewmodelCity.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView13androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.brand.get()
            //         is viewmodel.brand.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView13);
            // localize variables for thread safety
            // viewmodel.brand != null
            boolean viewmodelBrandJavaLangObjectNull = false;
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.brand
            android.databinding.ObservableField<java.lang.String> viewmodelBrand = null;
            // viewmodel.brand.get()
            java.lang.String viewmodelBrandGet = null;
            // viewmodel
            com.findandfix.carowner.viewmodel.EditProfileInfoViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelBrand = viewmodel.brand;

                viewmodelBrandJavaLangObjectNull = (viewmodelBrand) != (null);
                if (viewmodelBrandJavaLangObjectNull) {




                    viewmodelBrand.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView15androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.model.get()
            //         is viewmodel.model.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView15);
            // localize variables for thread safety
            // viewmodel.model
            android.databinding.ObservableField<java.lang.String> viewmodelModel = null;
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.model != null
            boolean viewmodelModelJavaLangObjectNull = false;
            // viewmodel.model.get()
            java.lang.String viewmodelModelGet = null;
            // viewmodel
            com.findandfix.carowner.viewmodel.EditProfileInfoViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelModel = viewmodel.model;

                viewmodelModelJavaLangObjectNull = (viewmodelModel) != (null);
                if (viewmodelModelJavaLangObjectNull) {




                    viewmodelModel.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView17androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.year.get()
            //         is viewmodel.year.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView17);
            // localize variables for thread safety
            // viewmodel.year.get()
            java.lang.String viewmodelYearGet = null;
            // viewmodel.year
            android.databinding.ObservableField<java.lang.String> viewmodelYear = null;
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.year != null
            boolean viewmodelYearJavaLangObjectNull = false;
            // viewmodel
            com.findandfix.carowner.viewmodel.EditProfileInfoViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelYear = viewmodel.year;

                viewmodelYearJavaLangObjectNull = (viewmodelYear) != (null);
                if (viewmodelYearJavaLangObjectNull) {




                    viewmodelYear.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView5androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.lname.get()
            //         is viewmodel.lname.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView5);
            // localize variables for thread safety
            // viewmodel.lname != null
            boolean viewmodelLnameJavaLangObjectNull = false;
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.lname.get()
            java.lang.String viewmodelLnameGet = null;
            // viewmodel.lname
            android.databinding.ObservableField<java.lang.String> viewmodelLname = null;
            // viewmodel
            com.findandfix.carowner.viewmodel.EditProfileInfoViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelLname = viewmodel.lname;

                viewmodelLnameJavaLangObjectNull = (viewmodelLname) != (null);
                if (viewmodelLnameJavaLangObjectNull) {




                    viewmodelLname.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView6androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.phone.get()
            //         is viewmodel.phone.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView6);
            // localize variables for thread safety
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.phone.get()
            java.lang.String viewmodelPhoneGet = null;
            // viewmodel.phone
            android.databinding.ObservableField<java.lang.String> viewmodelPhone = null;
            // viewmodel.phone != null
            boolean viewmodelPhoneJavaLangObjectNull = false;
            // viewmodel
            com.findandfix.carowner.viewmodel.EditProfileInfoViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelPhone = viewmodel.phone;

                viewmodelPhoneJavaLangObjectNull = (viewmodelPhone) != (null);
                if (viewmodelPhoneJavaLangObjectNull) {




                    viewmodelPhone.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView7androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.email.get()
            //         is viewmodel.email.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView7);
            // localize variables for thread safety
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.email != null
            boolean viewmodelEmailJavaLangObjectNull = false;
            // viewmodel.email
            android.databinding.ObservableField<java.lang.String> viewmodelEmail = null;
            // viewmodel.email.get()
            java.lang.String viewmodelEmailGet = null;
            // viewmodel
            com.findandfix.carowner.viewmodel.EditProfileInfoViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelEmail = viewmodel.email;

                viewmodelEmailJavaLangObjectNull = (viewmodelEmail) != (null);
                if (viewmodelEmailJavaLangObjectNull) {




                    viewmodelEmail.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener mboundView9androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewmodel.country.get()
            //         is viewmodel.country.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView9);
            // localize variables for thread safety
            // viewmodel.country
            android.databinding.ObservableField<java.lang.String> viewmodelCountry = null;
            // viewmodel != null
            boolean viewmodelJavaLangObjectNull = false;
            // viewmodel.country.get()
            java.lang.String viewmodelCountryGet = null;
            // viewmodel.country != null
            boolean viewmodelCountryJavaLangObjectNull = false;
            // viewmodel
            com.findandfix.carowner.viewmodel.EditProfileInfoViewModel viewmodel = mViewmodel;



            viewmodelJavaLangObjectNull = (viewmodel) != (null);
            if (viewmodelJavaLangObjectNull) {


                viewmodelCountry = viewmodel.country;

                viewmodelCountryJavaLangObjectNull = (viewmodelCountry) != (null);
                if (viewmodelCountryJavaLangObjectNull) {




                    viewmodelCountry.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityEditCarOwnerProfileLayoutBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 12);
        final Object[] bindings = mapBindings(bindingComponent, root, 29, sIncludes, sViewsWithIds);
        this.btnSubmit = (android.widget.Button) bindings[19];
        this.btnSubmit.setTag(null);
        this.etEditProfileWorkshopName = (android.widget.EditText) bindings[4];
        this.etEditProfileWorkshopName.setTag(null);
        this.ivBrands = (android.widget.ImageView) bindings[12];
        this.ivBrands.setTag(null);
        this.ivCarOwnerImage = (de.hdodenhof.circleimageview.CircleImageView) bindings[2];
        this.ivCarOwnerImage.setTag(null);
        this.ivChangePasswordPage = (android.widget.ImageView) bindings[28];
        this.ivCitiesDialog = (android.widget.ImageView) bindings[10];
        this.ivCitiesDialog.setTag(null);
        this.ivCountriesDialog = (android.widget.ImageView) bindings[8];
        this.ivCountriesDialog.setTag(null);
        this.ivLogo = (de.hdodenhof.circleimageview.CircleImageView) bindings[1];
        this.ivLogo.setTag(null);
        this.ivSpecialization = (android.widget.ImageView) bindings[14];
        this.ivSpecialization.setTag(null);
        this.ivUrgents = (android.widget.ImageView) bindings[16];
        this.ivUrgents.setTag(null);
        this.llChangePassword = (android.widget.LinearLayout) bindings[18];
        this.llChangePassword.setTag(null);
        this.llContainer = (android.widget.RelativeLayout) bindings[21];
        this.llWorkshopInfo = (android.widget.LinearLayout) bindings[24];
        this.llWorkshopSpecialization = (android.widget.LinearLayout) bindings[26];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView11 = (android.widget.EditText) bindings[11];
        this.mboundView11.setTag(null);
        this.mboundView13 = (android.widget.EditText) bindings[13];
        this.mboundView13.setTag(null);
        this.mboundView15 = (android.widget.EditText) bindings[15];
        this.mboundView15.setTag(null);
        this.mboundView17 = (android.widget.EditText) bindings[17];
        this.mboundView17.setTag(null);
        this.mboundView3 = (android.widget.ImageView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView5 = (android.widget.EditText) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.EditText) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.EditText) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView9 = (android.widget.EditText) bindings[9];
        this.mboundView9.setTag(null);
        this.rlCarOwnerPic = (android.widget.RelativeLayout) bindings[22];
        this.toolbar = (findandfix.databinding.ToolbarLayoutBinding) bindings[20];
        setContainedBinding(this.toolbar);
        this.tvChangePassword = (android.widget.TextView) bindings[27];
        this.tvWorkshopInfo = (android.widget.TextView) bindings[23];
        this.tvWorkshopSpecialization = (android.widget.TextView) bindings[25];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2000L;
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
        if (BR.viewmodel == variableId) {
            setViewmodel((com.findandfix.carowner.viewmodel.EditProfileInfoViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewmodel(@Nullable com.findandfix.carowner.viewmodel.EditProfileInfoViewModel Viewmodel) {
        updateRegistration(5, Viewmodel);
        this.mViewmodel = Viewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.viewmodel);
        super.requestRebind();
    }
    @Nullable
    public com.findandfix.carowner.viewmodel.EditProfileInfoViewModel getViewmodel() {
        return mViewmodel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewmodelFname((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewmodelCity((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeViewmodelYear((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeViewmodelBrand((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeViewmodelModel((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeViewmodel((com.findandfix.carowner.viewmodel.EditProfileInfoViewModel) object, fieldId);
            case 6 :
                return onChangeViewmodelCountry((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 7 :
                return onChangeViewmodelEmail((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 8 :
                return onChangeViewmodelPicUrl((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 9 :
                return onChangeToolbar((findandfix.databinding.ToolbarLayoutBinding) object, fieldId);
            case 10 :
                return onChangeViewmodelPhone((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 11 :
                return onChangeViewmodelLname((android.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewmodelFname(android.databinding.ObservableField<java.lang.String> ViewmodelFname, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelCity(android.databinding.ObservableField<java.lang.String> ViewmodelCity, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelYear(android.databinding.ObservableField<java.lang.String> ViewmodelYear, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelBrand(android.databinding.ObservableField<java.lang.String> ViewmodelBrand, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelModel(android.databinding.ObservableField<java.lang.String> ViewmodelModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodel(com.findandfix.carowner.viewmodel.EditProfileInfoViewModel Viewmodel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        else if (fieldId == BR.picBitmap) {
            synchronized(this) {
                    mDirtyFlags |= 0x1000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelCountry(android.databinding.ObservableField<java.lang.String> ViewmodelCountry, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelEmail(android.databinding.ObservableField<java.lang.String> ViewmodelEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelPicUrl(android.databinding.ObservableField<java.lang.String> ViewmodelPicUrl, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeToolbar(findandfix.databinding.ToolbarLayoutBinding Toolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x200L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelPhone(android.databinding.ObservableField<java.lang.String> ViewmodelPhone, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x400L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewmodelLname(android.databinding.ObservableField<java.lang.String> ViewmodelLname, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x800L;
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
        android.view.View.OnClickListener viewmodelShowCountriesAndroidViewViewOnClickListener = null;
        android.databinding.ObservableField<java.lang.String> viewmodelFname = null;
        boolean viewmodelPicBitmapJavaLangObjectNull = false;
        android.view.View.OnClickListener viewmodelShowCitiesAndroidViewViewOnClickListener = null;
        android.view.View.OnClickListener viewmodelValidateAndroidViewViewOnClickListener = null;
        android.databinding.ObservableField<java.lang.String> viewmodelCity = null;
        android.databinding.ObservableField<java.lang.String> viewmodelYear = null;
        java.lang.String viewmodelEmailGet = null;
        java.lang.String viewmodelYearGet = null;
        java.lang.String viewmodelPicUrlGet = null;
        android.view.View.OnClickListener viewmodelShowModelsAndroidViewViewOnClickListener = null;
        android.view.View.OnClickListener viewmodelDisplayDialogAndroidViewViewOnClickListener = null;
        android.databinding.ObservableField<java.lang.String> viewmodelBrand = null;
        int viewmodelPicBitmapJavaLangObjectNullViewINVISIBLEViewVISIBLE = 0;
        android.view.View.OnClickListener viewmodelChangePasswordActAndroidViewViewOnClickListener = null;
        android.databinding.ObservableField<java.lang.String> viewmodelModel = null;
        java.lang.String viewmodelLnameGet = null;
        java.lang.String viewmodelPhoneGet = null;
        java.lang.String viewmodelBrandGet = null;
        com.findandfix.carowner.viewmodel.EditProfileInfoViewModel viewmodel = mViewmodel;
        android.databinding.ObservableField<java.lang.String> viewmodelCountry = null;
        java.lang.String viewmodelCountryGet = null;
        android.databinding.ObservableField<java.lang.String> viewmodelEmail = null;
        android.graphics.Bitmap viewmodelPicBitmap = null;
        int viewmodelPicBitmapJavaLangObjectNullViewVISIBLEViewINVISIBLE = 0;
        java.lang.String viewmodelModelGet = null;
        android.databinding.ObservableField<java.lang.String> viewmodelPicUrl = null;
        android.databinding.ObservableField<java.lang.String> viewmodelPhone = null;
        java.lang.String viewmodelCityGet = null;
        android.view.View.OnClickListener viewmodelShowYearsAndroidViewViewOnClickListener = null;
        java.lang.String viewmodelFnameGet = null;
        android.databinding.ObservableField<java.lang.String> viewmodelLname = null;
        android.view.View.OnClickListener viewmodelShowCarBrandsAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x3dffL) != 0) {


            if ((dirtyFlags & 0x2020L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel::showCountries
                        viewmodelShowCountriesAndroidViewViewOnClickListener = (((mViewmodelShowCountriesAndroidViewViewOnClickListener == null) ? (mViewmodelShowCountriesAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mViewmodelShowCountriesAndroidViewViewOnClickListener).setValue(viewmodel));
                        // read viewmodel::showCities
                        viewmodelShowCitiesAndroidViewViewOnClickListener = (((mViewmodelShowCitiesAndroidViewViewOnClickListener == null) ? (mViewmodelShowCitiesAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mViewmodelShowCitiesAndroidViewViewOnClickListener).setValue(viewmodel));
                        // read viewmodel::validate
                        viewmodelValidateAndroidViewViewOnClickListener = (((mViewmodelValidateAndroidViewViewOnClickListener == null) ? (mViewmodelValidateAndroidViewViewOnClickListener = new OnClickListenerImpl2()) : mViewmodelValidateAndroidViewViewOnClickListener).setValue(viewmodel));
                        // read viewmodel::showModels
                        viewmodelShowModelsAndroidViewViewOnClickListener = (((mViewmodelShowModelsAndroidViewViewOnClickListener == null) ? (mViewmodelShowModelsAndroidViewViewOnClickListener = new OnClickListenerImpl3()) : mViewmodelShowModelsAndroidViewViewOnClickListener).setValue(viewmodel));
                        // read viewmodel::displayDialog
                        viewmodelDisplayDialogAndroidViewViewOnClickListener = (((mViewmodelDisplayDialogAndroidViewViewOnClickListener == null) ? (mViewmodelDisplayDialogAndroidViewViewOnClickListener = new OnClickListenerImpl4()) : mViewmodelDisplayDialogAndroidViewViewOnClickListener).setValue(viewmodel));
                        // read viewmodel::changePasswordAct
                        viewmodelChangePasswordActAndroidViewViewOnClickListener = (((mViewmodelChangePasswordActAndroidViewViewOnClickListener == null) ? (mViewmodelChangePasswordActAndroidViewViewOnClickListener = new OnClickListenerImpl5()) : mViewmodelChangePasswordActAndroidViewViewOnClickListener).setValue(viewmodel));
                        // read viewmodel::showYears
                        viewmodelShowYearsAndroidViewViewOnClickListener = (((mViewmodelShowYearsAndroidViewViewOnClickListener == null) ? (mViewmodelShowYearsAndroidViewViewOnClickListener = new OnClickListenerImpl6()) : mViewmodelShowYearsAndroidViewViewOnClickListener).setValue(viewmodel));
                        // read viewmodel::showCarBrands
                        viewmodelShowCarBrandsAndroidViewViewOnClickListener = (((mViewmodelShowCarBrandsAndroidViewViewOnClickListener == null) ? (mViewmodelShowCarBrandsAndroidViewViewOnClickListener = new OnClickListenerImpl7()) : mViewmodelShowCarBrandsAndroidViewViewOnClickListener).setValue(viewmodel));
                    }
            }
            if ((dirtyFlags & 0x2021L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.fname
                        viewmodelFname = viewmodel.fname;
                    }
                    updateRegistration(0, viewmodelFname);


                    if (viewmodelFname != null) {
                        // read viewmodel.fname.get()
                        viewmodelFnameGet = viewmodelFname.get();
                    }
            }
            if ((dirtyFlags & 0x2022L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.city
                        viewmodelCity = viewmodel.city;
                    }
                    updateRegistration(1, viewmodelCity);


                    if (viewmodelCity != null) {
                        // read viewmodel.city.get()
                        viewmodelCityGet = viewmodelCity.get();
                    }
            }
            if ((dirtyFlags & 0x2024L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.year
                        viewmodelYear = viewmodel.year;
                    }
                    updateRegistration(2, viewmodelYear);


                    if (viewmodelYear != null) {
                        // read viewmodel.year.get()
                        viewmodelYearGet = viewmodelYear.get();
                    }
            }
            if ((dirtyFlags & 0x2028L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.brand
                        viewmodelBrand = viewmodel.brand;
                    }
                    updateRegistration(3, viewmodelBrand);


                    if (viewmodelBrand != null) {
                        // read viewmodel.brand.get()
                        viewmodelBrandGet = viewmodelBrand.get();
                    }
            }
            if ((dirtyFlags & 0x2030L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.model
                        viewmodelModel = viewmodel.model;
                    }
                    updateRegistration(4, viewmodelModel);


                    if (viewmodelModel != null) {
                        // read viewmodel.model.get()
                        viewmodelModelGet = viewmodelModel.get();
                    }
            }
            if ((dirtyFlags & 0x2060L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.country
                        viewmodelCountry = viewmodel.country;
                    }
                    updateRegistration(6, viewmodelCountry);


                    if (viewmodelCountry != null) {
                        // read viewmodel.country.get()
                        viewmodelCountryGet = viewmodelCountry.get();
                    }
            }
            if ((dirtyFlags & 0x20a0L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.email
                        viewmodelEmail = viewmodel.email;
                    }
                    updateRegistration(7, viewmodelEmail);


                    if (viewmodelEmail != null) {
                        // read viewmodel.email.get()
                        viewmodelEmailGet = viewmodelEmail.get();
                    }
            }
            if ((dirtyFlags & 0x3020L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.picBitmap
                        viewmodelPicBitmap = viewmodel.getPicBitmap();
                    }


                    // read viewmodel.picBitmap != null
                    viewmodelPicBitmapJavaLangObjectNull = (viewmodelPicBitmap) != (null);
                if((dirtyFlags & 0x3020L) != 0) {
                    if(viewmodelPicBitmapJavaLangObjectNull) {
                            dirtyFlags |= 0x8000L;
                            dirtyFlags |= 0x20000L;
                    }
                    else {
                            dirtyFlags |= 0x4000L;
                            dirtyFlags |= 0x10000L;
                    }
                }


                    // read viewmodel.picBitmap != null ? View.INVISIBLE : View.VISIBLE
                    viewmodelPicBitmapJavaLangObjectNullViewINVISIBLEViewVISIBLE = ((viewmodelPicBitmapJavaLangObjectNull) ? (android.view.View.INVISIBLE) : (android.view.View.VISIBLE));
                    // read viewmodel.picBitmap != null ? View.VISIBLE : View.INVISIBLE
                    viewmodelPicBitmapJavaLangObjectNullViewVISIBLEViewINVISIBLE = ((viewmodelPicBitmapJavaLangObjectNull) ? (android.view.View.VISIBLE) : (android.view.View.INVISIBLE));
            }
            if ((dirtyFlags & 0x2120L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.picUrl
                        viewmodelPicUrl = viewmodel.picUrl;
                    }
                    updateRegistration(8, viewmodelPicUrl);


                    if (viewmodelPicUrl != null) {
                        // read viewmodel.picUrl.get()
                        viewmodelPicUrlGet = viewmodelPicUrl.get();
                    }
            }
            if ((dirtyFlags & 0x2420L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.phone
                        viewmodelPhone = viewmodel.phone;
                    }
                    updateRegistration(10, viewmodelPhone);


                    if (viewmodelPhone != null) {
                        // read viewmodel.phone.get()
                        viewmodelPhoneGet = viewmodelPhone.get();
                    }
            }
            if ((dirtyFlags & 0x2820L) != 0) {

                    if (viewmodel != null) {
                        // read viewmodel.lname
                        viewmodelLname = viewmodel.lname;
                    }
                    updateRegistration(11, viewmodelLname);


                    if (viewmodelLname != null) {
                        // read viewmodel.lname.get()
                        viewmodelLnameGet = viewmodelLname.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x2020L) != 0) {
            // api target 1

            this.btnSubmit.setOnClickListener(viewmodelValidateAndroidViewViewOnClickListener);
            this.ivBrands.setOnClickListener(viewmodelShowCarBrandsAndroidViewViewOnClickListener);
            this.ivCitiesDialog.setOnClickListener(viewmodelShowCitiesAndroidViewViewOnClickListener);
            this.ivCountriesDialog.setOnClickListener(viewmodelShowCountriesAndroidViewViewOnClickListener);
            this.ivSpecialization.setOnClickListener(viewmodelShowModelsAndroidViewViewOnClickListener);
            this.ivUrgents.setOnClickListener(viewmodelShowYearsAndroidViewViewOnClickListener);
            this.llChangePassword.setOnClickListener(viewmodelChangePasswordActAndroidViewViewOnClickListener);
            this.mboundView11.setOnClickListener(viewmodelShowCitiesAndroidViewViewOnClickListener);
            this.mboundView13.setOnClickListener(viewmodelShowCarBrandsAndroidViewViewOnClickListener);
            this.mboundView15.setOnClickListener(viewmodelShowModelsAndroidViewViewOnClickListener);
            this.mboundView17.setOnClickListener(viewmodelShowYearsAndroidViewViewOnClickListener);
            this.mboundView3.setOnClickListener(viewmodelDisplayDialogAndroidViewViewOnClickListener);
            this.mboundView9.setOnClickListener(viewmodelShowCountriesAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x2021L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.etEditProfileWorkshopName, viewmodelFnameGet);
        }
        if ((dirtyFlags & 0x2000L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etEditProfileWorkshopName, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etEditProfileWorkshopNameandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView11, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView11androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView13, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView13androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView15, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView15androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView17, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView17androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView5, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView5androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView6, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView6androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView7, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView7androidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView9, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView9androidTextAttrChanged);
        }
        if ((dirtyFlags & 0x3020L) != 0) {
            // api target 1

            com.findandfix.carowner.utils.CustomBinder.setImageBitmap(this.ivCarOwnerImage, viewmodelPicBitmap);
            this.ivCarOwnerImage.setVisibility(viewmodelPicBitmapJavaLangObjectNullViewVISIBLEViewINVISIBLE);
            this.ivLogo.setVisibility(viewmodelPicBitmapJavaLangObjectNullViewINVISIBLEViewVISIBLE);
        }
        if ((dirtyFlags & 0x2120L) != 0) {
            // api target 1

            com.findandfix.carowner.utils.CustomBinder.setImageConv(this.ivLogo, viewmodelPicUrlGet);
        }
        if ((dirtyFlags & 0x2022L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView11, viewmodelCityGet);
        }
        if ((dirtyFlags & 0x2028L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView13, viewmodelBrandGet);
        }
        if ((dirtyFlags & 0x2030L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView15, viewmodelModelGet);
        }
        if ((dirtyFlags & 0x2024L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView17, viewmodelYearGet);
        }
        if ((dirtyFlags & 0x2820L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, viewmodelLnameGet);
        }
        if ((dirtyFlags & 0x2420L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, viewmodelPhoneGet);
        }
        if ((dirtyFlags & 0x20a0L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, viewmodelEmailGet);
        }
        if ((dirtyFlags & 0x2060L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView9, viewmodelCountryGet);
        }
        executeBindingsOn(toolbar);
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.EditProfileInfoViewModel value;
        public OnClickListenerImpl setValue(com.findandfix.carowner.viewmodel.EditProfileInfoViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.showCountries(arg0);
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.EditProfileInfoViewModel value;
        public OnClickListenerImpl1 setValue(com.findandfix.carowner.viewmodel.EditProfileInfoViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.showCities(arg0);
        }
    }
    public static class OnClickListenerImpl2 implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.EditProfileInfoViewModel value;
        public OnClickListenerImpl2 setValue(com.findandfix.carowner.viewmodel.EditProfileInfoViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.validate(arg0);
        }
    }
    public static class OnClickListenerImpl3 implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.EditProfileInfoViewModel value;
        public OnClickListenerImpl3 setValue(com.findandfix.carowner.viewmodel.EditProfileInfoViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.showModels(arg0);
        }
    }
    public static class OnClickListenerImpl4 implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.EditProfileInfoViewModel value;
        public OnClickListenerImpl4 setValue(com.findandfix.carowner.viewmodel.EditProfileInfoViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.displayDialog(arg0);
        }
    }
    public static class OnClickListenerImpl5 implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.EditProfileInfoViewModel value;
        public OnClickListenerImpl5 setValue(com.findandfix.carowner.viewmodel.EditProfileInfoViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.changePasswordAct(arg0);
        }
    }
    public static class OnClickListenerImpl6 implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.EditProfileInfoViewModel value;
        public OnClickListenerImpl6 setValue(com.findandfix.carowner.viewmodel.EditProfileInfoViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.showYears(arg0);
        }
    }
    public static class OnClickListenerImpl7 implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.EditProfileInfoViewModel value;
        public OnClickListenerImpl7 setValue(com.findandfix.carowner.viewmodel.EditProfileInfoViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.showCarBrands(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityEditCarOwnerProfileLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityEditCarOwnerProfileLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityEditCarOwnerProfileLayoutBinding>inflate(inflater, findandfix.R.layout.activity_edit_car_owner_profile_layout, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityEditCarOwnerProfileLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityEditCarOwnerProfileLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.activity_edit_car_owner_profile_layout, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityEditCarOwnerProfileLayoutBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityEditCarOwnerProfileLayoutBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_edit_car_owner_profile_layout_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityEditCarOwnerProfileLayoutBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): viewmodel.fname
        flag 1 (0x2L): viewmodel.city
        flag 2 (0x3L): viewmodel.year
        flag 3 (0x4L): viewmodel.brand
        flag 4 (0x5L): viewmodel.model
        flag 5 (0x6L): viewmodel
        flag 6 (0x7L): viewmodel.country
        flag 7 (0x8L): viewmodel.email
        flag 8 (0x9L): viewmodel.picUrl
        flag 9 (0xaL): toolbar
        flag 10 (0xbL): viewmodel.phone
        flag 11 (0xcL): viewmodel.lname
        flag 12 (0xdL): viewmodel.picBitmap
        flag 13 (0xeL): null
        flag 14 (0xfL): viewmodel.picBitmap != null ? View.INVISIBLE : View.VISIBLE
        flag 15 (0x10L): viewmodel.picBitmap != null ? View.INVISIBLE : View.VISIBLE
        flag 16 (0x11L): viewmodel.picBitmap != null ? View.VISIBLE : View.INVISIBLE
        flag 17 (0x12L): viewmodel.picBitmap != null ? View.VISIBLE : View.INVISIBLE
    flag mapping end*/
    //end
}