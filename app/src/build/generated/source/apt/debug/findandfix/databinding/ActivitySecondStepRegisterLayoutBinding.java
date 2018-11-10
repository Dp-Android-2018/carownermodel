package findandfix.databinding;
import com.findandfix.carowner.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivitySecondStepRegisterLayoutBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    public final android.widget.Button btnRegister2Next;
    @NonNull
    public final android.widget.EditText etRegister2CarBrand;
    @NonNull
    public final android.widget.EditText etRegister2City;
    @NonNull
    public final android.widget.EditText etRegister2Country;
    @NonNull
    public final android.widget.EditText etRegister2FirstName;
    @NonNull
    public final android.widget.EditText etRegister2LastName;
    @NonNull
    public final android.widget.EditText etRegister2Model;
    @NonNull
    public final android.widget.EditText etRegister2PhoneNumber;
    @NonNull
    public final android.widget.EditText etRegister2Year;
    @NonNull
    public final android.support.design.widget.TextInputLayout inputLayoutSignUpFname;
    @NonNull
    public final android.support.design.widget.TextInputLayout inputSignUpBrand;
    @NonNull
    public final android.support.design.widget.TextInputLayout inputSignUpCity;
    @NonNull
    public final android.support.design.widget.TextInputLayout inputSignUpCountry;
    @NonNull
    public final android.support.design.widget.TextInputLayout inputSignUpLname;
    @NonNull
    public final android.support.design.widget.TextInputLayout inputSignUpModel;
    @NonNull
    public final android.support.design.widget.TextInputLayout inputSignUpPhone;
    @NonNull
    public final android.support.design.widget.TextInputLayout inputSignUpYear;
    @NonNull
    public final android.widget.ProgressBar progressBar;
    @NonNull
    public final android.widget.RelativeLayout rlParent;
    // variables
    @Nullable
    private com.findandfix.carowner.viewmodel.SecondStepRegisterValidation mValidation;
    @Nullable
    private com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel mRegisterModelView2;
    // values
    // listeners
    private OnClickListenerImpl mRegisterModelView2ShowCarBrandsAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mRegisterModelView2ShowCountriesAndroidViewViewOnClickListener;
    private OnClickListenerImpl2 mRegisterModelView2ShowModelsAndroidViewViewOnClickListener;
    private OnClickListenerImpl3 mRegisterModelView2ShowYearsAndroidViewViewOnClickListener;
    private OnClickListenerImpl4 mRegisterModelView2NextAndroidViewViewOnClickListener;
    private OnClickListenerImpl5 mRegisterModelView2ShowCitiesAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener etRegister2CarBrandandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of RegisterModelView2.brand.get()
            //         is RegisterModelView2.brand.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(etRegister2CarBrand);
            // localize variables for thread safety
            // RegisterModelView2
            com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel registerModelView2 = mRegisterModelView2;
            // RegisterModelView2.brand != null
            boolean registerModelView2BrandJavaLangObjectNull = false;
            // RegisterModelView2.brand
            android.databinding.ObservableField<java.lang.String> registerModelView2Brand = null;
            // RegisterModelView2.brand.get()
            java.lang.String registerModelView2BrandGet = null;
            // RegisterModelView2 != null
            boolean registerModelView2JavaLangObjectNull = false;



            registerModelView2JavaLangObjectNull = (registerModelView2) != (null);
            if (registerModelView2JavaLangObjectNull) {


                registerModelView2Brand = registerModelView2.brand;

                registerModelView2BrandJavaLangObjectNull = (registerModelView2Brand) != (null);
                if (registerModelView2BrandJavaLangObjectNull) {




                    registerModelView2Brand.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener etRegister2CityandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of RegisterModelView2.city.get()
            //         is RegisterModelView2.city.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(etRegister2City);
            // localize variables for thread safety
            // RegisterModelView2
            com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel registerModelView2 = mRegisterModelView2;
            // RegisterModelView2.city != null
            boolean registerModelView2CityJavaLangObjectNull = false;
            // RegisterModelView2.city
            android.databinding.ObservableField<java.lang.String> registerModelView2City = null;
            // RegisterModelView2 != null
            boolean registerModelView2JavaLangObjectNull = false;
            // RegisterModelView2.city.get()
            java.lang.String registerModelView2CityGet = null;



            registerModelView2JavaLangObjectNull = (registerModelView2) != (null);
            if (registerModelView2JavaLangObjectNull) {


                registerModelView2City = registerModelView2.city;

                registerModelView2CityJavaLangObjectNull = (registerModelView2City) != (null);
                if (registerModelView2CityJavaLangObjectNull) {




                    registerModelView2City.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener etRegister2CountryandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of RegisterModelView2.country.get()
            //         is RegisterModelView2.country.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(etRegister2Country);
            // localize variables for thread safety
            // RegisterModelView2
            com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel registerModelView2 = mRegisterModelView2;
            // RegisterModelView2.country != null
            boolean registerModelView2CountryJavaLangObjectNull = false;
            // RegisterModelView2.country
            android.databinding.ObservableField<java.lang.String> registerModelView2Country = null;
            // RegisterModelView2.country.get()
            java.lang.String registerModelView2CountryGet = null;
            // RegisterModelView2 != null
            boolean registerModelView2JavaLangObjectNull = false;



            registerModelView2JavaLangObjectNull = (registerModelView2) != (null);
            if (registerModelView2JavaLangObjectNull) {


                registerModelView2Country = registerModelView2.country;

                registerModelView2CountryJavaLangObjectNull = (registerModelView2Country) != (null);
                if (registerModelView2CountryJavaLangObjectNull) {




                    registerModelView2Country.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener etRegister2FirstNameandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of RegisterModelView2.firstName.get()
            //         is RegisterModelView2.firstName.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(etRegister2FirstName);
            // localize variables for thread safety
            // RegisterModelView2.firstName != null
            boolean registerModelView2FirstNameJavaLangObjectNull = false;
            // RegisterModelView2
            com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel registerModelView2 = mRegisterModelView2;
            // RegisterModelView2.firstName.get()
            java.lang.String registerModelView2FirstNameGet = null;
            // RegisterModelView2.firstName
            android.databinding.ObservableField<java.lang.String> registerModelView2FirstName = null;
            // RegisterModelView2 != null
            boolean registerModelView2JavaLangObjectNull = false;



            registerModelView2JavaLangObjectNull = (registerModelView2) != (null);
            if (registerModelView2JavaLangObjectNull) {


                registerModelView2FirstName = registerModelView2.firstName;

                registerModelView2FirstNameJavaLangObjectNull = (registerModelView2FirstName) != (null);
                if (registerModelView2FirstNameJavaLangObjectNull) {




                    registerModelView2FirstName.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener etRegister2LastNameandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of RegisterModelView2.lastName.get()
            //         is RegisterModelView2.lastName.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(etRegister2LastName);
            // localize variables for thread safety
            // RegisterModelView2
            com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel registerModelView2 = mRegisterModelView2;
            // RegisterModelView2 != null
            boolean registerModelView2JavaLangObjectNull = false;
            // RegisterModelView2.lastName
            android.databinding.ObservableField<java.lang.String> registerModelView2LastName = null;
            // RegisterModelView2.lastName != null
            boolean registerModelView2LastNameJavaLangObjectNull = false;
            // RegisterModelView2.lastName.get()
            java.lang.String registerModelView2LastNameGet = null;



            registerModelView2JavaLangObjectNull = (registerModelView2) != (null);
            if (registerModelView2JavaLangObjectNull) {


                registerModelView2LastName = registerModelView2.lastName;

                registerModelView2LastNameJavaLangObjectNull = (registerModelView2LastName) != (null);
                if (registerModelView2LastNameJavaLangObjectNull) {




                    registerModelView2LastName.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener etRegister2ModelandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of RegisterModelView2.model.get()
            //         is RegisterModelView2.model.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(etRegister2Model);
            // localize variables for thread safety
            // RegisterModelView2.model
            android.databinding.ObservableField<java.lang.String> registerModelView2Model = null;
            // RegisterModelView2
            com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel registerModelView2 = mRegisterModelView2;
            // RegisterModelView2.model.get()
            java.lang.String registerModelView2ModelGet = null;
            // RegisterModelView2 != null
            boolean registerModelView2JavaLangObjectNull = false;
            // RegisterModelView2.model != null
            boolean registerModelView2ModelJavaLangObjectNull = false;



            registerModelView2JavaLangObjectNull = (registerModelView2) != (null);
            if (registerModelView2JavaLangObjectNull) {


                registerModelView2Model = registerModelView2.model;

                registerModelView2ModelJavaLangObjectNull = (registerModelView2Model) != (null);
                if (registerModelView2ModelJavaLangObjectNull) {




                    registerModelView2Model.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener etRegister2PhoneNumberandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of RegisterModelView2.phoneNumber.get()
            //         is RegisterModelView2.phoneNumber.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(etRegister2PhoneNumber);
            // localize variables for thread safety
            // RegisterModelView2
            com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel registerModelView2 = mRegisterModelView2;
            // RegisterModelView2.phoneNumber != null
            boolean registerModelView2PhoneNumberJavaLangObjectNull = false;
            // RegisterModelView2.phoneNumber.get()
            java.lang.String registerModelView2PhoneNumberGet = null;
            // RegisterModelView2 != null
            boolean registerModelView2JavaLangObjectNull = false;
            // RegisterModelView2.phoneNumber
            android.databinding.ObservableField<java.lang.String> registerModelView2PhoneNumber = null;



            registerModelView2JavaLangObjectNull = (registerModelView2) != (null);
            if (registerModelView2JavaLangObjectNull) {


                registerModelView2PhoneNumber = registerModelView2.phoneNumber;

                registerModelView2PhoneNumberJavaLangObjectNull = (registerModelView2PhoneNumber) != (null);
                if (registerModelView2PhoneNumberJavaLangObjectNull) {




                    registerModelView2PhoneNumber.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private android.databinding.InverseBindingListener etRegister2YearandroidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of RegisterModelView2.year.get()
            //         is RegisterModelView2.year.set((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(etRegister2Year);
            // localize variables for thread safety
            // RegisterModelView2
            com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel registerModelView2 = mRegisterModelView2;
            // RegisterModelView2.year
            android.databinding.ObservableField<java.lang.String> registerModelView2Year = null;
            // RegisterModelView2.year.get()
            java.lang.String registerModelView2YearGet = null;
            // RegisterModelView2 != null
            boolean registerModelView2JavaLangObjectNull = false;
            // RegisterModelView2.year != null
            boolean registerModelView2YearJavaLangObjectNull = false;



            registerModelView2JavaLangObjectNull = (registerModelView2) != (null);
            if (registerModelView2JavaLangObjectNull) {


                registerModelView2Year = registerModelView2.year;

                registerModelView2YearJavaLangObjectNull = (registerModelView2Year) != (null);
                if (registerModelView2YearJavaLangObjectNull) {




                    registerModelView2Year.set(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivitySecondStepRegisterLayoutBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 18);
        final Object[] bindings = mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds);
        this.btnRegister2Next = (android.widget.Button) bindings[17];
        this.btnRegister2Next.setTag(null);
        this.etRegister2CarBrand = (android.widget.EditText) bindings[12];
        this.etRegister2CarBrand.setTag(null);
        this.etRegister2City = (android.widget.EditText) bindings[10];
        this.etRegister2City.setTag(null);
        this.etRegister2Country = (android.widget.EditText) bindings[8];
        this.etRegister2Country.setTag(null);
        this.etRegister2FirstName = (android.widget.EditText) bindings[2];
        this.etRegister2FirstName.setTag(null);
        this.etRegister2LastName = (android.widget.EditText) bindings[4];
        this.etRegister2LastName.setTag(null);
        this.etRegister2Model = (android.widget.EditText) bindings[14];
        this.etRegister2Model.setTag(null);
        this.etRegister2PhoneNumber = (android.widget.EditText) bindings[6];
        this.etRegister2PhoneNumber.setTag(null);
        this.etRegister2Year = (android.widget.EditText) bindings[16];
        this.etRegister2Year.setTag(null);
        this.inputLayoutSignUpFname = (android.support.design.widget.TextInputLayout) bindings[1];
        this.inputLayoutSignUpFname.setTag(null);
        this.inputSignUpBrand = (android.support.design.widget.TextInputLayout) bindings[11];
        this.inputSignUpBrand.setTag(null);
        this.inputSignUpCity = (android.support.design.widget.TextInputLayout) bindings[9];
        this.inputSignUpCity.setTag(null);
        this.inputSignUpCountry = (android.support.design.widget.TextInputLayout) bindings[7];
        this.inputSignUpCountry.setTag(null);
        this.inputSignUpLname = (android.support.design.widget.TextInputLayout) bindings[3];
        this.inputSignUpLname.setTag(null);
        this.inputSignUpModel = (android.support.design.widget.TextInputLayout) bindings[13];
        this.inputSignUpModel.setTag(null);
        this.inputSignUpPhone = (android.support.design.widget.TextInputLayout) bindings[5];
        this.inputSignUpPhone.setTag(null);
        this.inputSignUpYear = (android.support.design.widget.TextInputLayout) bindings[15];
        this.inputSignUpYear.setTag(null);
        this.progressBar = (android.widget.ProgressBar) bindings[18];
        this.progressBar.setTag(null);
        this.rlParent = (android.widget.RelativeLayout) bindings[0];
        this.rlParent.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x80000L;
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
        if (BR.validation == variableId) {
            setValidation((com.findandfix.carowner.viewmodel.SecondStepRegisterValidation) variable);
        }
        else if (BR.RegisterModelView2 == variableId) {
            setRegisterModelView2((com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setValidation(@Nullable com.findandfix.carowner.viewmodel.SecondStepRegisterValidation Validation) {
        updateRegistration(4, Validation);
        this.mValidation = Validation;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.validation);
        super.requestRebind();
    }
    @Nullable
    public com.findandfix.carowner.viewmodel.SecondStepRegisterValidation getValidation() {
        return mValidation;
    }
    public void setRegisterModelView2(@Nullable com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel RegisterModelView2) {
        this.mRegisterModelView2 = RegisterModelView2;
        synchronized(this) {
            mDirtyFlags |= 0x40000L;
        }
        notifyPropertyChanged(BR.RegisterModelView2);
        super.requestRebind();
    }
    @Nullable
    public com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel getRegisterModelView2() {
        return mRegisterModelView2;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeValidationPhoneError((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeRegisterModelView2City((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeRegisterModelView2LastName((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeRegisterModelView2FirstName((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeValidation((com.findandfix.carowner.viewmodel.SecondStepRegisterValidation) object, fieldId);
            case 5 :
                return onChangeValidationFnameError((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 6 :
                return onChangeRegisterModelView2ProgressDialog((android.databinding.ObservableInt) object, fieldId);
            case 7 :
                return onChangeRegisterModelView2PhoneNumber((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 8 :
                return onChangeValidationYearError((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 9 :
                return onChangeRegisterModelView2Model((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 10 :
                return onChangeValidationBrandError((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 11 :
                return onChangeRegisterModelView2Brand((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 12 :
                return onChangeValidationModelError((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 13 :
                return onChangeValidationCityError((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 14 :
                return onChangeValidationCountryError((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 15 :
                return onChangeValidationLnameError((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 16 :
                return onChangeRegisterModelView2Country((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 17 :
                return onChangeRegisterModelView2Year((android.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeValidationPhoneError(android.databinding.ObservableField<java.lang.String> ValidationPhoneError, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegisterModelView2City(android.databinding.ObservableField<java.lang.String> RegisterModelView2City, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegisterModelView2LastName(android.databinding.ObservableField<java.lang.String> RegisterModelView2LastName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegisterModelView2FirstName(android.databinding.ObservableField<java.lang.String> RegisterModelView2FirstName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeValidation(com.findandfix.carowner.viewmodel.SecondStepRegisterValidation Validation, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeValidationFnameError(android.databinding.ObservableField<java.lang.String> ValidationFnameError, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegisterModelView2ProgressDialog(android.databinding.ObservableInt RegisterModelView2ProgressDialog, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegisterModelView2PhoneNumber(android.databinding.ObservableField<java.lang.String> RegisterModelView2PhoneNumber, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeValidationYearError(android.databinding.ObservableField<java.lang.String> ValidationYearError, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegisterModelView2Model(android.databinding.ObservableField<java.lang.String> RegisterModelView2Model, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x200L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeValidationBrandError(android.databinding.ObservableField<java.lang.String> ValidationBrandError, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x400L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegisterModelView2Brand(android.databinding.ObservableField<java.lang.String> RegisterModelView2Brand, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x800L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeValidationModelError(android.databinding.ObservableField<java.lang.String> ValidationModelError, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeValidationCityError(android.databinding.ObservableField<java.lang.String> ValidationCityError, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeValidationCountryError(android.databinding.ObservableField<java.lang.String> ValidationCountryError, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeValidationLnameError(android.databinding.ObservableField<java.lang.String> ValidationLnameError, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegisterModelView2Country(android.databinding.ObservableField<java.lang.String> RegisterModelView2Country, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegisterModelView2Year(android.databinding.ObservableField<java.lang.String> RegisterModelView2Year, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20000L;
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
        java.lang.String registerModelView2FirstNameGet = null;
        java.lang.String registerModelView2LastNameGet = null;
        android.view.View.OnClickListener registerModelView2ShowCarBrandsAndroidViewViewOnClickListener = null;
        java.lang.String registerModelView2PhoneNumberGet = null;
        android.databinding.ObservableField<java.lang.String> validationPhoneError = null;
        int registerModelView2ProgressDialogGet = 0;
        java.lang.String validationFnameErrorGet = null;
        android.databinding.ObservableField<java.lang.String> registerModelView2City = null;
        android.databinding.ObservableField<java.lang.String> registerModelView2LastName = null;
        android.view.View.OnClickListener registerModelView2ShowCountriesAndroidViewViewOnClickListener = null;
        android.databinding.ObservableField<java.lang.String> registerModelView2FirstName = null;
        com.findandfix.carowner.viewmodel.SecondStepRegisterValidation validation = mValidation;
        android.view.View.OnClickListener registerModelView2ShowModelsAndroidViewViewOnClickListener = null;
        java.lang.String validationModelErrorGet = null;
        android.databinding.ObservableField<java.lang.String> validationFnameError = null;
        android.databinding.ObservableInt registerModelView2ProgressDialog = null;
        android.databinding.ObservableField<java.lang.String> registerModelView2PhoneNumber = null;
        java.lang.String validationYearErrorGet = null;
        android.databinding.ObservableField<java.lang.String> validationYearError = null;
        java.lang.String registerModelView2BrandGet = null;
        java.lang.String registerModelView2CountryGet = null;
        android.databinding.ObservableField<java.lang.String> registerModelView2Model = null;
        java.lang.String registerModelView2YearGet = null;
        java.lang.String validationCityErrorGet = null;
        android.view.View.OnClickListener registerModelView2ShowYearsAndroidViewViewOnClickListener = null;
        java.lang.String registerModelView2CityGet = null;
        android.databinding.ObservableField<java.lang.String> validationBrandError = null;
        android.view.View.OnClickListener registerModelView2NextAndroidViewViewOnClickListener = null;
        android.databinding.ObservableField<java.lang.String> registerModelView2Brand = null;
        com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel registerModelView2 = mRegisterModelView2;
        java.lang.String registerModelView2ModelGet = null;
        android.databinding.ObservableField<java.lang.String> validationModelError = null;
        java.lang.String validationLnameErrorGet = null;
        android.databinding.ObservableField<java.lang.String> validationCityError = null;
        java.lang.String validationPhoneErrorGet = null;
        java.lang.String validationCountryErrorGet = null;
        android.databinding.ObservableField<java.lang.String> validationCountryError = null;
        android.databinding.ObservableField<java.lang.String> validationLnameError = null;
        android.databinding.ObservableField<java.lang.String> registerModelView2Country = null;
        android.databinding.ObservableField<java.lang.String> registerModelView2Year = null;
        java.lang.String validationBrandErrorGet = null;
        android.view.View.OnClickListener registerModelView2ShowCitiesAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x8f531L) != 0) {


            if ((dirtyFlags & 0x80011L) != 0) {

                    if (validation != null) {
                        // read validation.phoneError
                        validationPhoneError = validation.phoneError;
                    }
                    updateRegistration(0, validationPhoneError);


                    if (validationPhoneError != null) {
                        // read validation.phoneError.get()
                        validationPhoneErrorGet = validationPhoneError.get();
                    }
            }
            if ((dirtyFlags & 0x80030L) != 0) {

                    if (validation != null) {
                        // read validation.fnameError
                        validationFnameError = validation.fnameError;
                    }
                    updateRegistration(5, validationFnameError);


                    if (validationFnameError != null) {
                        // read validation.fnameError.get()
                        validationFnameErrorGet = validationFnameError.get();
                    }
            }
            if ((dirtyFlags & 0x80110L) != 0) {

                    if (validation != null) {
                        // read validation.yearError
                        validationYearError = validation.yearError;
                    }
                    updateRegistration(8, validationYearError);


                    if (validationYearError != null) {
                        // read validation.yearError.get()
                        validationYearErrorGet = validationYearError.get();
                    }
            }
            if ((dirtyFlags & 0x80410L) != 0) {

                    if (validation != null) {
                        // read validation.brandError
                        validationBrandError = validation.brandError;
                    }
                    updateRegistration(10, validationBrandError);


                    if (validationBrandError != null) {
                        // read validation.brandError.get()
                        validationBrandErrorGet = validationBrandError.get();
                    }
            }
            if ((dirtyFlags & 0x81010L) != 0) {

                    if (validation != null) {
                        // read validation.modelError
                        validationModelError = validation.modelError;
                    }
                    updateRegistration(12, validationModelError);


                    if (validationModelError != null) {
                        // read validation.modelError.get()
                        validationModelErrorGet = validationModelError.get();
                    }
            }
            if ((dirtyFlags & 0x82010L) != 0) {

                    if (validation != null) {
                        // read validation.cityError
                        validationCityError = validation.cityError;
                    }
                    updateRegistration(13, validationCityError);


                    if (validationCityError != null) {
                        // read validation.cityError.get()
                        validationCityErrorGet = validationCityError.get();
                    }
            }
            if ((dirtyFlags & 0x84010L) != 0) {

                    if (validation != null) {
                        // read validation.countryError
                        validationCountryError = validation.countryError;
                    }
                    updateRegistration(14, validationCountryError);


                    if (validationCountryError != null) {
                        // read validation.countryError.get()
                        validationCountryErrorGet = validationCountryError.get();
                    }
            }
            if ((dirtyFlags & 0x88010L) != 0) {

                    if (validation != null) {
                        // read validation.lnameError
                        validationLnameError = validation.lnameError;
                    }
                    updateRegistration(15, validationLnameError);


                    if (validationLnameError != null) {
                        // read validation.lnameError.get()
                        validationLnameErrorGet = validationLnameError.get();
                    }
            }
        }
        if ((dirtyFlags & 0xf0aceL) != 0) {


            if ((dirtyFlags & 0xc0000L) != 0) {

                    if (registerModelView2 != null) {
                        // read RegisterModelView2::showCarBrands
                        registerModelView2ShowCarBrandsAndroidViewViewOnClickListener = (((mRegisterModelView2ShowCarBrandsAndroidViewViewOnClickListener == null) ? (mRegisterModelView2ShowCarBrandsAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mRegisterModelView2ShowCarBrandsAndroidViewViewOnClickListener).setValue(registerModelView2));
                        // read RegisterModelView2::showCountries
                        registerModelView2ShowCountriesAndroidViewViewOnClickListener = (((mRegisterModelView2ShowCountriesAndroidViewViewOnClickListener == null) ? (mRegisterModelView2ShowCountriesAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mRegisterModelView2ShowCountriesAndroidViewViewOnClickListener).setValue(registerModelView2));
                        // read RegisterModelView2::showModels
                        registerModelView2ShowModelsAndroidViewViewOnClickListener = (((mRegisterModelView2ShowModelsAndroidViewViewOnClickListener == null) ? (mRegisterModelView2ShowModelsAndroidViewViewOnClickListener = new OnClickListenerImpl2()) : mRegisterModelView2ShowModelsAndroidViewViewOnClickListener).setValue(registerModelView2));
                        // read RegisterModelView2::showYears
                        registerModelView2ShowYearsAndroidViewViewOnClickListener = (((mRegisterModelView2ShowYearsAndroidViewViewOnClickListener == null) ? (mRegisterModelView2ShowYearsAndroidViewViewOnClickListener = new OnClickListenerImpl3()) : mRegisterModelView2ShowYearsAndroidViewViewOnClickListener).setValue(registerModelView2));
                        // read RegisterModelView2::next
                        registerModelView2NextAndroidViewViewOnClickListener = (((mRegisterModelView2NextAndroidViewViewOnClickListener == null) ? (mRegisterModelView2NextAndroidViewViewOnClickListener = new OnClickListenerImpl4()) : mRegisterModelView2NextAndroidViewViewOnClickListener).setValue(registerModelView2));
                        // read RegisterModelView2::showCities
                        registerModelView2ShowCitiesAndroidViewViewOnClickListener = (((mRegisterModelView2ShowCitiesAndroidViewViewOnClickListener == null) ? (mRegisterModelView2ShowCitiesAndroidViewViewOnClickListener = new OnClickListenerImpl5()) : mRegisterModelView2ShowCitiesAndroidViewViewOnClickListener).setValue(registerModelView2));
                    }
            }
            if ((dirtyFlags & 0xc0002L) != 0) {

                    if (registerModelView2 != null) {
                        // read RegisterModelView2.city
                        registerModelView2City = registerModelView2.city;
                    }
                    updateRegistration(1, registerModelView2City);


                    if (registerModelView2City != null) {
                        // read RegisterModelView2.city.get()
                        registerModelView2CityGet = registerModelView2City.get();
                    }
            }
            if ((dirtyFlags & 0xc0004L) != 0) {

                    if (registerModelView2 != null) {
                        // read RegisterModelView2.lastName
                        registerModelView2LastName = registerModelView2.lastName;
                    }
                    updateRegistration(2, registerModelView2LastName);


                    if (registerModelView2LastName != null) {
                        // read RegisterModelView2.lastName.get()
                        registerModelView2LastNameGet = registerModelView2LastName.get();
                    }
            }
            if ((dirtyFlags & 0xc0008L) != 0) {

                    if (registerModelView2 != null) {
                        // read RegisterModelView2.firstName
                        registerModelView2FirstName = registerModelView2.firstName;
                    }
                    updateRegistration(3, registerModelView2FirstName);


                    if (registerModelView2FirstName != null) {
                        // read RegisterModelView2.firstName.get()
                        registerModelView2FirstNameGet = registerModelView2FirstName.get();
                    }
            }
            if ((dirtyFlags & 0xc0040L) != 0) {

                    if (registerModelView2 != null) {
                        // read RegisterModelView2.progressDialog
                        registerModelView2ProgressDialog = registerModelView2.progressDialog;
                    }
                    updateRegistration(6, registerModelView2ProgressDialog);


                    if (registerModelView2ProgressDialog != null) {
                        // read RegisterModelView2.progressDialog.get()
                        registerModelView2ProgressDialogGet = registerModelView2ProgressDialog.get();
                    }
            }
            if ((dirtyFlags & 0xc0080L) != 0) {

                    if (registerModelView2 != null) {
                        // read RegisterModelView2.phoneNumber
                        registerModelView2PhoneNumber = registerModelView2.phoneNumber;
                    }
                    updateRegistration(7, registerModelView2PhoneNumber);


                    if (registerModelView2PhoneNumber != null) {
                        // read RegisterModelView2.phoneNumber.get()
                        registerModelView2PhoneNumberGet = registerModelView2PhoneNumber.get();
                    }
            }
            if ((dirtyFlags & 0xc0200L) != 0) {

                    if (registerModelView2 != null) {
                        // read RegisterModelView2.model
                        registerModelView2Model = registerModelView2.model;
                    }
                    updateRegistration(9, registerModelView2Model);


                    if (registerModelView2Model != null) {
                        // read RegisterModelView2.model.get()
                        registerModelView2ModelGet = registerModelView2Model.get();
                    }
            }
            if ((dirtyFlags & 0xc0800L) != 0) {

                    if (registerModelView2 != null) {
                        // read RegisterModelView2.brand
                        registerModelView2Brand = registerModelView2.brand;
                    }
                    updateRegistration(11, registerModelView2Brand);


                    if (registerModelView2Brand != null) {
                        // read RegisterModelView2.brand.get()
                        registerModelView2BrandGet = registerModelView2Brand.get();
                    }
            }
            if ((dirtyFlags & 0xd0000L) != 0) {

                    if (registerModelView2 != null) {
                        // read RegisterModelView2.country
                        registerModelView2Country = registerModelView2.country;
                    }
                    updateRegistration(16, registerModelView2Country);


                    if (registerModelView2Country != null) {
                        // read RegisterModelView2.country.get()
                        registerModelView2CountryGet = registerModelView2Country.get();
                    }
            }
            if ((dirtyFlags & 0xe0000L) != 0) {

                    if (registerModelView2 != null) {
                        // read RegisterModelView2.year
                        registerModelView2Year = registerModelView2.year;
                    }
                    updateRegistration(17, registerModelView2Year);


                    if (registerModelView2Year != null) {
                        // read RegisterModelView2.year.get()
                        registerModelView2YearGet = registerModelView2Year.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xc0000L) != 0) {
            // api target 1

            this.btnRegister2Next.setOnClickListener(registerModelView2NextAndroidViewViewOnClickListener);
            this.etRegister2CarBrand.setOnClickListener(registerModelView2ShowCarBrandsAndroidViewViewOnClickListener);
            this.etRegister2City.setOnClickListener(registerModelView2ShowCitiesAndroidViewViewOnClickListener);
            this.etRegister2Country.setOnClickListener(registerModelView2ShowCountriesAndroidViewViewOnClickListener);
            this.etRegister2Model.setOnClickListener(registerModelView2ShowModelsAndroidViewViewOnClickListener);
            this.etRegister2Year.setOnClickListener(registerModelView2ShowYearsAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0xc0800L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.etRegister2CarBrand, registerModelView2BrandGet);
        }
        if ((dirtyFlags & 0x80000L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etRegister2CarBrand, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etRegister2CarBrandandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etRegister2City, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etRegister2CityandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etRegister2Country, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etRegister2CountryandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etRegister2FirstName, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etRegister2FirstNameandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etRegister2LastName, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etRegister2LastNameandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etRegister2Model, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etRegister2ModelandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etRegister2PhoneNumber, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etRegister2PhoneNumberandroidTextAttrChanged);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etRegister2Year, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etRegister2YearandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0xc0002L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.etRegister2City, registerModelView2CityGet);
        }
        if ((dirtyFlags & 0xd0000L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.etRegister2Country, registerModelView2CountryGet);
        }
        if ((dirtyFlags & 0xc0008L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.etRegister2FirstName, registerModelView2FirstNameGet);
        }
        if ((dirtyFlags & 0xc0004L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.etRegister2LastName, registerModelView2LastNameGet);
        }
        if ((dirtyFlags & 0xc0200L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.etRegister2Model, registerModelView2ModelGet);
        }
        if ((dirtyFlags & 0xc0080L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.etRegister2PhoneNumber, registerModelView2PhoneNumberGet);
        }
        if ((dirtyFlags & 0xe0000L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.etRegister2Year, registerModelView2YearGet);
        }
        if ((dirtyFlags & 0x80030L) != 0) {
            // api target 1

            com.findandfix.carowner.utils.CustomBinder.setErrorMessage(this.inputLayoutSignUpFname, validationFnameErrorGet);
        }
        if ((dirtyFlags & 0x80410L) != 0) {
            // api target 1

            com.findandfix.carowner.utils.CustomBinder.setErrorMessage(this.inputSignUpBrand, validationBrandErrorGet);
        }
        if ((dirtyFlags & 0x82010L) != 0) {
            // api target 1

            com.findandfix.carowner.utils.CustomBinder.setErrorMessage(this.inputSignUpCity, validationCityErrorGet);
        }
        if ((dirtyFlags & 0x84010L) != 0) {
            // api target 1

            com.findandfix.carowner.utils.CustomBinder.setErrorMessage(this.inputSignUpCountry, validationCountryErrorGet);
        }
        if ((dirtyFlags & 0x88010L) != 0) {
            // api target 1

            com.findandfix.carowner.utils.CustomBinder.setErrorMessage(this.inputSignUpLname, validationLnameErrorGet);
        }
        if ((dirtyFlags & 0x81010L) != 0) {
            // api target 1

            com.findandfix.carowner.utils.CustomBinder.setErrorMessage(this.inputSignUpModel, validationModelErrorGet);
        }
        if ((dirtyFlags & 0x80011L) != 0) {
            // api target 1

            com.findandfix.carowner.utils.CustomBinder.setErrorMessage(this.inputSignUpPhone, validationPhoneErrorGet);
        }
        if ((dirtyFlags & 0x80110L) != 0) {
            // api target 1

            com.findandfix.carowner.utils.CustomBinder.setErrorMessage(this.inputSignUpYear, validationYearErrorGet);
        }
        if ((dirtyFlags & 0xc0040L) != 0) {
            // api target 1

            this.progressBar.setVisibility(registerModelView2ProgressDialogGet);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel value;
        public OnClickListenerImpl setValue(com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.showCarBrands(arg0);
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel value;
        public OnClickListenerImpl1 setValue(com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.showCountries(arg0);
        }
    }
    public static class OnClickListenerImpl2 implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel value;
        public OnClickListenerImpl2 setValue(com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.showModels(arg0);
        }
    }
    public static class OnClickListenerImpl3 implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel value;
        public OnClickListenerImpl3 setValue(com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.showYears(arg0);
        }
    }
    public static class OnClickListenerImpl4 implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel value;
        public OnClickListenerImpl4 setValue(com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.next(arg0);
        }
    }
    public static class OnClickListenerImpl5 implements android.view.View.OnClickListener{
        private com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel value;
        public OnClickListenerImpl5 setValue(com.findandfix.carowner.viewmodel.SecondStepRegisterViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.showCities(arg0);
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivitySecondStepRegisterLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivitySecondStepRegisterLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivitySecondStepRegisterLayoutBinding>inflate(inflater, findandfix.R.layout.activity_second_step_register_layout, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivitySecondStepRegisterLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivitySecondStepRegisterLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.activity_second_step_register_layout, null, false), bindingComponent);
    }
    @NonNull
    public static ActivitySecondStepRegisterLayoutBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivitySecondStepRegisterLayoutBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_second_step_register_layout_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivitySecondStepRegisterLayoutBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): validation.phoneError
        flag 1 (0x2L): RegisterModelView2.city
        flag 2 (0x3L): RegisterModelView2.lastName
        flag 3 (0x4L): RegisterModelView2.firstName
        flag 4 (0x5L): validation
        flag 5 (0x6L): validation.fnameError
        flag 6 (0x7L): RegisterModelView2.progressDialog
        flag 7 (0x8L): RegisterModelView2.phoneNumber
        flag 8 (0x9L): validation.yearError
        flag 9 (0xaL): RegisterModelView2.model
        flag 10 (0xbL): validation.brandError
        flag 11 (0xcL): RegisterModelView2.brand
        flag 12 (0xdL): validation.modelError
        flag 13 (0xeL): validation.cityError
        flag 14 (0xfL): validation.countryError
        flag 15 (0x10L): validation.lnameError
        flag 16 (0x11L): RegisterModelView2.country
        flag 17 (0x12L): RegisterModelView2.year
        flag 18 (0x13L): RegisterModelView2
        flag 19 (0x14L): null
    flag mapping end*/
    //end
}