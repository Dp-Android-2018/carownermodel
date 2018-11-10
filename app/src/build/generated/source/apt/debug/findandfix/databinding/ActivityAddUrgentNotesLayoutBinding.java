package findandfix.databinding;
import com.findandfix.carowner.R;
import findandfix.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityAddUrgentNotesLayoutBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(6);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar_layout", "fragment_add_urgent_request_3", "fragment_add_urgent_request_4"},
            new int[] {1, 2, 3},
            new int[] {R.layout.toolbar_layout, R.layout.fragment_add_urgent_request_3, R.layout.fragment_add_urgent_request_4});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_type, 4);
        sViewsWithIds.put(R.id.tv_voice_notes, 5);
    }
    // views
    @Nullable
    public final findandfix.databinding.FragmentAddUrgentRequest3Binding layoutNotes;
    @Nullable
    public final findandfix.databinding.FragmentAddUrgentRequest4Binding layoutVoiceNotes;
    @NonNull
    public final android.widget.LinearLayout llContainer;
    @Nullable
    public final findandfix.databinding.ToolbarLayoutBinding toolbar;
    @NonNull
    public final android.widget.TextView tvType;
    @NonNull
    public final android.widget.TextView tvVoiceNotes;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityAddUrgentNotesLayoutBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 3);
        final Object[] bindings = mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds);
        this.layoutNotes = (findandfix.databinding.FragmentAddUrgentRequest3Binding) bindings[2];
        setContainedBinding(this.layoutNotes);
        this.layoutVoiceNotes = (findandfix.databinding.FragmentAddUrgentRequest4Binding) bindings[3];
        setContainedBinding(this.layoutVoiceNotes);
        this.llContainer = (android.widget.LinearLayout) bindings[0];
        this.llContainer.setTag(null);
        this.toolbar = (findandfix.databinding.ToolbarLayoutBinding) bindings[1];
        setContainedBinding(this.toolbar);
        this.tvType = (android.widget.TextView) bindings[4];
        this.tvVoiceNotes = (android.widget.TextView) bindings[5];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        toolbar.invalidateAll();
        layoutNotes.invalidateAll();
        layoutVoiceNotes.invalidateAll();
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
        if (layoutNotes.hasPendingBindings()) {
            return true;
        }
        if (layoutVoiceNotes.hasPendingBindings()) {
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
                return onChangeLayoutVoiceNotes((findandfix.databinding.FragmentAddUrgentRequest4Binding) object, fieldId);
            case 1 :
                return onChangeToolbar((findandfix.databinding.ToolbarLayoutBinding) object, fieldId);
            case 2 :
                return onChangeLayoutNotes((findandfix.databinding.FragmentAddUrgentRequest3Binding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLayoutVoiceNotes(findandfix.databinding.FragmentAddUrgentRequest4Binding LayoutVoiceNotes, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeToolbar(findandfix.databinding.ToolbarLayoutBinding Toolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLayoutNotes(findandfix.databinding.FragmentAddUrgentRequest3Binding LayoutNotes, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        executeBindingsOn(layoutNotes);
        executeBindingsOn(layoutVoiceNotes);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityAddUrgentNotesLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityAddUrgentNotesLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityAddUrgentNotesLayoutBinding>inflate(inflater, findandfix.R.layout.activity_add_urgent_notes_layout, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityAddUrgentNotesLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityAddUrgentNotesLayoutBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(findandfix.R.layout.activity_add_urgent_notes_layout, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityAddUrgentNotesLayoutBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityAddUrgentNotesLayoutBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_add_urgent_notes_layout_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityAddUrgentNotesLayoutBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): layoutVoiceNotes
        flag 1 (0x2L): toolbar
        flag 2 (0x3L): layoutNotes
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}