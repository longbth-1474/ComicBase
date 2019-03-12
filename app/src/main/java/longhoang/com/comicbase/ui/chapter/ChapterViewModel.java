package longhoang.com.comicbase.ui.chapter;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import longhoang.com.comicbase.core.BaseViewModel;
import longhoang.com.comicbase.data.model.api.chapter.ChapterBody;
import longhoang.com.comicbase.data.model.api.chapter.ChapterItem;

public class ChapterViewModel extends BaseViewModel {
    MutableLiveData<List<ChapterItem>> mChapterItemMutableLiveData = new MutableLiveData<>();

    @Inject
    ChapterViewModel() {
    }

    public void fetchDataChapter(String url) {
        ChapterBody chapterBody = new ChapterBody(url);
        getCompositeDisposable().add(repository
            .getChapterApiCall(chapterBody)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnSubscribe(disposable -> showProgressDialog(true))
            .doAfterTerminate(() -> showProgressDialog(false))
            .subscribe(chapterResponse -> {
                if (chapterResponse != null && chapterResponse.getChapter() != null) {
                    mChapterItemMutableLiveData
                        .postValue(chapterResponse.getChapter().getChapters());
                }
            }, throwable -> {
            })
        );
    }
}
