package longhoang.com.comicbase.ui.chapter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import longhoang.com.comicbase.R;
import longhoang.com.comicbase.core.BaseFragment;
import longhoang.com.comicbase.data.model.api.chapter.ChapterItem;
import longhoang.com.comicbase.data.model.api.comic.Chapter;
import longhoang.com.comicbase.databinding.FragmentChapterBinding;

public class ChapterFragment extends BaseFragment<FragmentChapterBinding, ChapterViewModel>
    implements
    ObservableScrollViewCallbacks {
    private static final String BUNDLE_CHAPTER = "BUNDLE_CHAPTER";

    @Override
    public int getLayoutId() {
        return R.layout.fragment_chapter;
    }

    public static ChapterFragment newInstance(Chapter chapter) {
        Bundle args = new Bundle();
        args.putParcelable(BUNDLE_CHAPTER, chapter);
        ChapterFragment fragment = new ChapterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null) return;
        Chapter chapter = getArguments().getParcelable(BUNDLE_CHAPTER);
        if (chapter == null) return;
        getViewModel().fetchDataChapter(chapter.getUrlChapter());
        updateWebView();
    }

    private void updateWebView() {
        List<String> images = new ArrayList<>();
        getViewModel().mChapterItemMutableLiveData.observe(this, chapterItems -> {
            for (ChapterItem chapter : chapterItems
            ) {
                String image = chapter.getImage();
                String imageFormat = String.format(getString(R.string.image_html), image, image);
                images.add(imageFormat);
            }
            String temp = TextUtils.join("", images);
            String html = String.format(getString(R.string.web_view), temp);
            getViewDataBinding().webViewComic
                .loadDataWithBaseURL("", html,
                    "text/html", "UTF-8", "");
            getViewDataBinding().webViewComic.setScrollViewCallbacks(this);
        });
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        RelativeLayout relativeTop = getViewDataBinding().relativeTop;
        LinearLayout linearComment = getViewDataBinding().linearComment;
        if (scrollState == ScrollState.UP) {
            if (relativeTop.isShown()) {
                relativeTop.setVisibility(View.GONE);
                linearComment.setVisibility(View.GONE);
            }
        } else if (scrollState == ScrollState.DOWN) {
            if (!relativeTop.isShown()) {
                relativeTop.setVisibility(View.VISIBLE);
                linearComment.setVisibility(View.VISIBLE);
            }
        }
    }
}
