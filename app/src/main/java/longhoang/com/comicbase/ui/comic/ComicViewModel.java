package longhoang.com.comicbase.ui.comic;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import longhoang.com.comicbase.core.BaseViewModel;
import longhoang.com.comicbase.data.model.api.comic.Chapter;
import longhoang.com.comicbase.data.model.api.comic.ComicBody;
import longhoang.com.comicbase.data.model.api.comic.ComicDetail;

public class ComicViewModel extends BaseViewModel {
    public MutableLiveData<ComicDetail> mComicDetailMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<List<Chapter>> mComicChapter = new MutableLiveData<>();

    @Inject
    public ComicViewModel() {
    }

    public void fetchDataComic(String urlComic) {
        ComicBody comicBody = new ComicBody(urlComic);
        getCompositeDisposable().add(repository
            .getComicApiCall(comicBody)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnSubscribe(disposable -> showProgressDialog(true))
            .doAfterTerminate(() -> showProgressDialog(false))
            .subscribe(comicResponse -> {
                if (comicResponse != null && comicResponse.getComic() != null) {
                    mComicDetailMutableLiveData.postValue(comicResponse.getComic());
                    mComicChapter.postValue(comicResponse.getComic().getChapters());
                }
            }, throwable -> {
            })
        );
    }
}
