package longhoang.com.comicbase.ui.search;

import longhoang.com.comicbase.core.adapter.recycleview.BaseViewAdapter;
import longhoang.com.comicbase.data.model.api.Comic;
import longhoang.com.comicbase.data.model.db.HistorySearch;

public interface SearchListener extends BaseViewAdapter.Listener {
    void onClickItemSearch(Comic comic);
    void onClickItemHistory(HistorySearch historySearch);
}
