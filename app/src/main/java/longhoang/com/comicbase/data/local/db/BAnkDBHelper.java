package longhoang.com.comicbase.data.local.db;

import java.util.List;

import io.reactivex.Observable;
import longhoang.com.comicbase.data.model.db.HistorySearch;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
public interface BAnkDBHelper {
    Observable<Boolean> clearAllHistorySearch();
    Observable<List<HistorySearch>> getAllHistorySearch();
    Observable<Boolean> insertHistorySearch(final HistorySearch historySearch);
}
