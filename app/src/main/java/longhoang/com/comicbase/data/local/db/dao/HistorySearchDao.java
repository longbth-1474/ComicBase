package longhoang.com.comicbase.data.local.db.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import longhoang.com.comicbase.data.model.db.HistorySearch;

@Dao
public interface HistorySearchDao {
    @Delete
    void delete(HistorySearch historySearch);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(HistorySearch historySearch);

    @Query("SELECT * FROM history")
    List<HistorySearch> loadAll();

    @Query("DELETE FROM history")
    void clearHistory();
}
