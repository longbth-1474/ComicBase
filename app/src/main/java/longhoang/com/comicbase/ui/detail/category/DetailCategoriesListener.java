package longhoang.com.comicbase.ui.detail.category;

import longhoang.com.comicbase.core.adapter.recycleview.BaseViewAdapter;
import longhoang.com.comicbase.data.model.api.detail.category.ComicItem;

public interface DetailCategoriesListener extends BaseViewAdapter.Listener {
    void onClickDetailCategories(ComicItem comicItem);
}
