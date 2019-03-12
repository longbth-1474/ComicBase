package longhoang.com.comicbase.ui.comic;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import longhoang.com.comicbase.R;
import longhoang.com.comicbase.core.BaseFragment;
import longhoang.com.comicbase.core.adapter.recycleview.SingleTypeAdapter;
import longhoang.com.comicbase.data.model.api.Comic;
import longhoang.com.comicbase.data.model.api.comic.Chapter;
import longhoang.com.comicbase.data.model.api.comic.ComicDetail;
import longhoang.com.comicbase.databinding.FragmentComicBinding;
import longhoang.com.comicbase.ui.chapter.ChapterFragment;

public class ComicFragment extends BaseFragment<FragmentComicBinding, ComicViewModel>
    implements ComicListener, SwipeRefreshLayout.OnRefreshListener {
    private static final String BUNDLE_COMIC = "BUNDLE_COMIC";
    private static final long DELAY_PULL_REFRESH = 1000;
    private Comic mComic;

    public static ComicFragment newInstance(Comic comic) {
        Bundle args = new Bundle();
        args.putParcelable(BUNDLE_COMIC, comic);
        ComicFragment fragment = new ComicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_comic;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null) return;
        mComic = getArguments().getParcelable(BUNDLE_COMIC);
        if (mComic == null) return;
        getViewDataBinding().textTitleComic.setText(mComic.getTitle());
        getViewModel().mComicDetailMutableLiveData.observe(this, comicDetail -> {
            if (comicDetail == null) return;
            updateUI(comicDetail);
            getViewDataBinding().constraintComic.setVisibility(View.VISIBLE);
        });
        initRecyclerViewChapter();
        getViewModel().fetchDataComic(mComic.getUrl());
        getViewDataBinding().swipeComic.setOnRefreshListener(this);
    }

    private void updateUI(ComicDetail comicDetail) {
        getViewDataBinding().textTitleComic.setText(comicDetail.getTitle());
        getViewDataBinding().textOtherName
            .setText(String.format(getString(R.string.title_other_name),
                comicDetail.getTitleOther()));
        getViewDataBinding().textAuthor.setText(String.format(getString(R.string.title_author),
            comicDetail.getAuthor()));
        getViewDataBinding().textStatus.setText(String.format(getString(R.string.title_status),
            comicDetail.getStatus()));
        getViewDataBinding().textViewer.setText(String.format(getString(R.string.title_viewer),
            comicDetail.getViewer()));
        getViewDataBinding().textContent.setText(comicDetail.getContent());
        getViewDataBinding().textTypeComic.setText(String.format(getString(R.string.title_type),
            comicDetail.getType()));
        getViewDataBinding().textTimeUpdate.setText(comicDetail.getTimeUpdate());
        Glide.with(getContext()).load(comicDetail.getImage()).into(getViewDataBinding().imageComic);
    }

    private void initRecyclerViewChapter() {
        SingleTypeAdapter<Chapter> adapter =
            new SingleTypeAdapter<>(getBaseActivity(), R.layout.item_chapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getBaseActivity(), 1);
        getViewDataBinding().recyclerNewChapter
            .setLayoutManager(gridLayoutManager);
        getViewDataBinding().recyclerNewChapter.setAdapter(adapter);
        adapter.setPresenter(this);
        getViewModel().mComicChapter.observe(this, newUpdates
            -> adapter.set(getViewModel().mComicChapter.getValue()));
    }

    @Override
    public void onClickChapterListener(Chapter chapter) {
        addFragment(ChapterFragment.newInstance(chapter), R.id.constraint_layout);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(() -> {
            getViewDataBinding().swipeComic.setRefreshing(false);
            getViewModel().fetchDataComic(mComic.getUrl());
        }, DELAY_PULL_REFRESH);
    }
}
