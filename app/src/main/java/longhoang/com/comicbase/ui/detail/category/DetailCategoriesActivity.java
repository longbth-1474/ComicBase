package longhoang.com.comicbase.ui.detail.category;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import longhoang.com.comicbase.R;
import longhoang.com.comicbase.core.BaseFragmentActivity;
import longhoang.com.comicbase.core.adapter.recycleview.SingleTypeAdapter;
import longhoang.com.comicbase.data.model.api.Comic;
import longhoang.com.comicbase.data.model.api.category.Category;
import longhoang.com.comicbase.data.model.api.detail.category.ComicItem;
import longhoang.com.comicbase.databinding.ActivityDetailCategoriesBinding;
import longhoang.com.comicbase.ui.comic.ComicFragment;

import static longhoang.com.comicbase.ui.detail.category.CategoriesMode.ALL;
import static longhoang.com.comicbase.ui.detail.category.CategoriesMode.CATEGORY;
import static longhoang.com.comicbase.ui.detail.category.CategoriesMode.COMMENT;
import static longhoang.com.comicbase.ui.detail.category.CategoriesMode.COMPLETE;
import static longhoang.com.comicbase.ui.detail.category.CategoriesMode.DATE_UPDATE;
import static longhoang.com.comicbase.ui.detail.category.CategoriesMode.FOLLOW;
import static longhoang.com.comicbase.ui.detail.category.CategoriesMode.NAME_COMIC;
import static longhoang.com.comicbase.ui.detail.category.CategoriesMode.NEW_COMIC;
import static longhoang.com.comicbase.ui.detail.category.CategoriesMode.TOP_ALL;
import static longhoang.com.comicbase.ui.detail.category.CategoriesMode.TOP_DAY;
import static longhoang.com.comicbase.ui.detail.category.CategoriesMode.TOP_MONTH;
import static longhoang.com.comicbase.ui.detail.category.CategoriesMode.TOP_WEEK;

public class DetailCategoriesActivity
    extends BaseFragmentActivity<ActivityDetailCategoriesBinding, DetailCategoriesViewModel>
    implements DetailCategoriesListener {
    public static final String BUNDLE_CATEGORY = "BUNDLE_CATEGORY";
    private Category mCategory;
    private int mStatus;
    private int mSort;
    private int mPage = 1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail_categories;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_filter, menu);
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpToolbar();
        mCategory = getIntent().getParcelableExtra(BUNDLE_CATEGORY);
        if (mCategory == null) return;
        getViewDataBinding().textTitle.setText(mCategory.getTitle());
        initRecyclerDetailCategory();
        initTablayout();
        initListener();
    }

    private void initListener() {
        getViewDataBinding().icBack.setOnClickListener(v -> onBackPressed());
    }

    private void setUpToolbar() {
        setSupportActionBar(getViewDataBinding().toolbar);
        Drawable drawable =
            ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_filter);
        getViewDataBinding().toolbar.setOverflowIcon(drawable);
    }

    private void initTablayout() {
        getViewDataBinding().tablayoutComic.addOnTabSelectedListener(
            new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    switch (tab.getPosition()) {
                        case 0:
                            mStatus = ALL;
                            break;
                        case 1:
                            mStatus = CATEGORY;
                            break;
                        case 2:
                            mStatus = COMPLETE;
                            break;
                    }
                    getViewModel().fetchDetailCategories(createURL(), mPage);
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });
    }

    private void initRecyclerDetailCategory() {
        SingleTypeAdapter<ComicItem> adapter =
            new SingleTypeAdapter<>(this, R.layout.item_detail_category);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        getViewDataBinding().recyclerContentCategory
            .setLayoutManager(gridLayoutManager);
        getViewDataBinding().recyclerContentCategory.setAdapter(adapter);
        adapter.setPresenter(this);
        getViewModel().mComicItemLiveData.observe(this, comicItems
            -> adapter.set(getViewModel().mComicItemLiveData.getValue()));
        getViewModel().fetchDetailCategories(mCategory.getUrl(), mPage);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        String urlComic;
        switch (id) {
            case R.id.action_date_update:
                mSort = DATE_UPDATE;
                break;
            case R.id.action_new_comic:
                mSort = NEW_COMIC;
                break;
            case R.id.action_top_all:
                mSort = TOP_ALL;
                break;
            case R.id.action_top_month:
                mSort = TOP_MONTH;
                break;
            case R.id.action_top_week:
                mSort = TOP_WEEK;
                break;
            case R.id.action_top_day:
                mSort = TOP_DAY;
                break;
            case R.id.action_follows:
                mSort = FOLLOW;
                break;
            case R.id.action_comment:
                mSort = COMMENT;
                break;
            case R.id.action_name_comic:
                mSort = NAME_COMIC;
                break;
        }
        urlComic = createURL();
        getViewModel().fetchDetailCategories(urlComic, mPage);
        return super.onOptionsItemSelected(item);
    }

    private String createURL() {
        return mCategory.getUrl() + getString(R.string.query_status) + mStatus +
            getString(R.string.query_sort) + mSort;
    }

    @Override
    public void onClickDetailCategories(ComicItem comicItem) {
        Comic comic = new Comic(comicItem.getUrlImage(),
            comicItem.getTitle(),
            comicItem.getTime(),
            comicItem.getChapter(),
            comicItem.getUrl(),
            comicItem.getId());
        addFragment(ComicFragment.newInstance(comic), R.id.constraint_layout);
    }
}
