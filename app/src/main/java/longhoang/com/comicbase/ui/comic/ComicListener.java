package longhoang.com.comicbase.ui.comic;

import longhoang.com.comicbase.core.adapter.recycleview.BaseViewAdapter;
import longhoang.com.comicbase.data.model.api.comic.Chapter;

public interface ComicListener extends BaseViewAdapter.Listener {
    void onClickChapterListener(Chapter chapter);
}
