package longhoang.com.comicbase.ui.category;

import longhoang.com.comicbase.core.adapter.recycleview.BaseViewAdapter;
import longhoang.com.comicbase.data.model.api.category.Category;

public interface CategoriesListener extends BaseViewAdapter.Listener {
    void onClickCategories(Category category);
}
