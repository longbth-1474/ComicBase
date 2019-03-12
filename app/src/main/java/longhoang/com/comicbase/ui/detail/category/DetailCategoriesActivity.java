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

public class DetailCategoriesActivity
    extends BaseFragmentActivity<ActivityDetailCategoriesBinding, DetailCategoriesViewModel>
    implements DetailCategoriesListener {
    public static final String BUNDLE_CATEGORY = "BUNDLE_CATEGORY";
    private Category mCategory;

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
        setSupportActionBar(getViewDataBinding().toolbar);
        Drawable drawable =
            ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_filter);
        getViewDataBinding().toolbar.setOverflowIcon(drawable);
        mCategory = getIntent().getParcelableExtra(BUNDLE_CATEGORY);
        if (mCategory == null) return;
        getViewDataBinding().textTitle.setText(mCategory.getTitle());
        initRecyclerDetailCategory();
        initTablayout();
    }

    private void initTablayout() {
        getViewDataBinding().tablayoutComic.addOnTabSelectedListener(
            new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
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
        getViewModel().fetchDetailCategories(mCategory.getUrl(), 1);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        String urlComic = null;
        switch (id) {
            case R.id.action_date_update:
                urlComic = mCategory.getUrl();
                break;
            case R.id.action_new_comic:
                urlComic = mCategory.getUrl() + "?status=-1&sort=15";
                break;
            case R.id.action_top_all:
                urlComic = mCategory.getUrl() + "?status=-1&sort=10";
                break;
            case R.id.action_top_month:
                urlComic = mCategory.getUrl() + "?status=-1&sort=11";
                break;
            case R.id.action_top_week:
                urlComic = mCategory.getUrl() + "?status=-1&sort=12";
                break;
            case R.id.action_top_day:
                urlComic = mCategory.getUrl() + "?status=-1&sort=13";
                break;
            case R.id.action_follows:
                urlComic = mCategory.getUrl() + "?status=-1&sort=20";
                break;
            case R.id.action_comment:
                urlComic = mCategory.getUrl() + "?status=-1&sort=25";
                break;
            case R.id.action_name_comic:
                urlComic = mCategory.getUrl() + "?status=-1&sort=5";
                break;
        }
        getViewModel().fetchDetailCategories(urlComic, 1);
        return super.onOptionsItemSelected(item);
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
