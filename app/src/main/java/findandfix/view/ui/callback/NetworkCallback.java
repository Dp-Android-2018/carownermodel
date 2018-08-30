package findandfix.view.ui.callback;

/**
 * Created by DELL on 05/04/2018.
 */

public interface NetworkCallback {

    public <E>void  onSuccess(Object data, int code);

    public void  onFailure(Throwable throwable);

    public <E>void  onUnUthenticated(int code);

}
