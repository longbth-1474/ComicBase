package longhoang.com.comicbase.data.local.db;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import longhoang.com.comicbase.data.model.db.HistorySearch;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
public class BAnkDBHelperImpl implements BAnkDBHelper {
    private final BAnkDatabase mAppDatabase;

    @Inject
    public BAnkDBHelperImpl(BAnkDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }

    @Override
    public Observable<Boolean> clearAllHistorySearch() {
        return Observable.fromCallable(()->{
            mAppDatabase.mHistorySearchDao().clearHistory();
            return true;
        });
    }

    @Override
    public Observable<List<HistorySearch>> getAllHistorySearch() {
        return Observable.fromCallable(
            () -> mAppDatabase.mHistorySearchDao().loadAll());
    }

    @Override
    public Observable<Boolean> insertHistorySearch(HistorySearch historySearch) {
        return Observable.fromCallable(() -> {
            mAppDatabase.mHistorySearchDao().insert(historySearch);
            return true;
        });
    }
}
