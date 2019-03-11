package longhoang.com.comicbase.data.local.db;

import javax.inject.Inject;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
public class BAnkDBHelperImpl implements BAnkDBHelper {
    private final BAnkDatabase mAppDatabase;

    @Inject
    public BAnkDBHelperImpl(BAnkDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }
}
