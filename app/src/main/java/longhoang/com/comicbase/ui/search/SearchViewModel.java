package longhoang.com.comicbase.ui.search;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import longhoang.com.comicbase.R;
import longhoang.com.comicbase.core.BaseViewModel;
import longhoang.com.comicbase.data.model.api.Comic;
import longhoang.com.comicbase.data.model.api.search.SearchBody;
import longhoang.com.comicbase.data.model.db.HistorySearch;

public class SearchViewModel extends BaseViewModel {
    MutableLiveData<List<Comic>> mComicLiveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> isNoData = new MutableLiveData<>();
    public MutableLiveData<List<HistorySearch>> mHistoryLiveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> showHistory = new MutableLiveData<>();
    public MutableLiveData<Boolean> updateHistory = new MutableLiveData<>();
    @Inject
    Context mContext;

    @Inject
    public SearchViewModel() {
        showHistory.postValue(true);
    }

    public void fetchDataSearch(String keySearch) {
        isNoData.postValue(false);
        SearchBody searchBody = new SearchBody(keySearch);
        getCompositeDisposable().add(repository
            .getSearchApiCall(searchBody)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnSubscribe(disposable -> showProgressDialog(true))
            .doAfterTerminate(() -> showProgressDialog(false))
            .subscribe(searchResponse -> {
                if (searchResponse != null && searchResponse.getComics() != null) {
                    isNoData.postValue(searchResponse.getComics().getComics().size() == 0);
                    mComicLiveData.postValue(searchResponse.getComics().getComics());
                }
            }, throwable -> showToast(throwable.getMessage()))
        );
    }

    public void deleteHistory() {
        getCompositeDisposable()
            .add(repository.clearAllHistorySearch().subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe(disposable -> showProgressDialog(true))
                .doAfterTerminate(() -> showProgressDialog(false))
                .subscribe(historySearches -> {
                        updateHistory.postValue(true);
                        showToast(
                            mContext.getString(R.string.message_delete_history_search));
                    },
                    throwable -> showToast(throwable.getMessage())));
    }

    public void fetchHistory() {
        getCompositeDisposable()
            .add(repository.getAllHistorySearch().subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe(disposable -> showProgressDialog(true))
                .doAfterTerminate(() -> showProgressDialog(false))
                .subscribe(historySearches -> {
                    if (historySearches != null) {
                        mHistoryLiveData.postValue(historySearches);
                    }
                }, throwable -> showToast(throwable.getMessage())));
    }

    public void addSearch(String keySeach) {
        HistorySearch historySearch = new HistorySearch();
        historySearch.setKeySearch(keySeach);
        getCompositeDisposable()
            .add(repository.insertHistorySearch(historySearch).subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(historySearches -> {
                    if (historySearches != null) {
                        updateHistory.postValue(true);
                    }
                }, throwable -> showToast(throwable.getMessage())));
    }
}
