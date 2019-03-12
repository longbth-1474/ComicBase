package longhoang.com.comicbase.ui.home;

import longhoang.com.comicbase.core.adapter.recycleview.BaseViewAdapter;
import longhoang.com.comicbase.data.model.api.home.NewUpdate;
import longhoang.com.comicbase.data.model.api.home.Proposal;

public interface HomeListener extends BaseViewAdapter.Listener {
    void onClickTopReadListener(Proposal proposal);
    void onClickNewUpdateListener(NewUpdate newUpdate);
}
