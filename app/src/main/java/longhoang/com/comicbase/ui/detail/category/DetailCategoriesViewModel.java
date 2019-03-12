package longhoang.com.comicbase.ui.detail.category;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import longhoang.com.comicbase.core.BaseViewModel;
import longhoang.com.comicbase.data.model.api.detail.category.ComicItem;
import longhoang.com.comicbase.data.model.api.detail.category.DetailCategoryBody;

public class DetailCategoriesViewModel extends BaseViewModel {
    MutableLiveData<List<ComicItem>> mComicItemLiveData = new MutableLiveData<>();

    @Inject
    DetailCategoriesViewModel() {
    }

    public void fetchDetailCategories(String url, int page) {
        DetailCategoryBody detailCategoryBody = new DetailCategoryBody(url, page);
        getCompositeDisposable().add(repository
            .getDetailCategoriesApiCall(detailCategoryBody)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnSubscribe(disposable -> showProgressDialog(true))
            .doAfterTerminate(() -> showProgressDialog(false))
            .subscribe(detailCategoryResponse -> {
                if (detailCategoryResponse != null && detailCategoryResponse.getComics() != null) {
                    mComicItemLiveData.postValue(detailCategoryResponse.getComics().getComics());
                }
            }, throwable -> {
            })
        );
    }
}
