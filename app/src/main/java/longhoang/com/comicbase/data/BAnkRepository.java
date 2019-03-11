package longhoang.com.comicbase.data;


import longhoang.com.comicbase.data.local.db.BAnkDBHelper;
import longhoang.com.comicbase.data.remote.BAnkApiHelper;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
public interface BAnkRepository extends BAnkApiHelper, BAnkDBHelper {
}
