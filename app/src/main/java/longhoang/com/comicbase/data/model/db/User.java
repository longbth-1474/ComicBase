package longhoang.com.comicbase.data.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Cong Nguyen on 2/19/19.
 */
@Entity(tableName = "users")
public class User {
    @ColumnInfo(name = "created_at")
    public String createdAt;
    @PrimaryKey
    public Long id;
    public String name;
    @ColumnInfo(name = "updated_at")
    public String updatedAt;
}

