package findandfix.view.ui.callback;

import findandfix.model.global.RequestOfferObj;

/**
 * Created by mohamedatef on 5/5/18.
 */

public interface RecycleItemClickListener {

    void onItemClick(int position);
    void getWorkshopOffer(RequestOfferObj offerObj);
}
