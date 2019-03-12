package longhoang.com.comicbase.ui.category;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import longhoang.com.comicbase.R;
import longhoang.com.comicbase.core.BaseFragment;
import longhoang.com.comicbase.core.adapter.recycleview.SingleTypeAdapter;
import longhoang.com.comicbase.data.model.api.category.Category;
import longhoang.com.comicbase.databinding.FragmentCategoryBinding;
import longhoang.com.comicbase.ui.detail.category.DetailCategoriesActivity;

public class CategoryFragment extends BaseFragment<FragmentCategoryBinding, CategoriesViewModel>
    implements CategoriesListener {
    public static CategoryFragment newInstance() {
        Bundle args = new Bundle();
        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_category;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerCategories();
    }

    private void initRecyclerCategories() {
        SingleTypeAdapter<Category> adapter =
            new SingleTypeAdapter<>(getBaseActivity(), R.layout.item_category);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getBaseActivity(), 3);
        getViewDataBinding().recyclerCategory
            .setLayoutManager(gridLayoutManager);
        getViewDataBinding().recyclerCategory.setAdapter(adapter);
        adapter.setPresenter(this);
        getViewModel().mListMutableLiveData.observe(this, categories
            -> adapter.set(getViewModel().mListMutableLiveData.getValue()));
        getViewModel().fetchCategories();
    }

    @Override
    public void onClickCategories(Category category) {
        Intent intent = new Intent(getActivity(), DetailCategoriesActivity.class);
        intent.putExtra(DetailCategoriesActivity.BUNDLE_CATEGORY,category);
        startActivity(intent);
    }
}
