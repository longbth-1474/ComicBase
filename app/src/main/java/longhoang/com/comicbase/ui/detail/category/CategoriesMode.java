package longhoang.com.comicbase.ui.detail.category;

import androidx.annotation.IntDef;

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

@IntDef(
    {DATE_UPDATE, NEW_COMIC, TOP_ALL, TOP_MONTH, TOP_WEEK, TOP_DAY, FOLLOW, COMMENT, NAME_COMIC,
        ALL, CATEGORY, COMPLETE})
public @interface CategoriesMode {
    //sort
    int DATE_UPDATE = 0;
    int NEW_COMIC = 15;
    int TOP_ALL = 10;
    int TOP_MONTH = 11;
    int TOP_WEEK = 12;
    int TOP_DAY = 13;
    int FOLLOW = 20;
    int COMMENT = 25;
    int NAME_COMIC = 5;
    //status
    int ALL = -1;
    int CATEGORY = 1;
    int COMPLETE = 2;
}
