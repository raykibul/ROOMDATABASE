package cgpakoto.com.roomdatabase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface SemisterDao {

    @Insert
    void  insertSemister(Semister semister);
    @Update
    void updateSemister(Semister semister);
    @Delete
    void deleteSemister(Semister semister);

    @Query("select * From Semister order by semister_name")
    LiveData<List<Semister>> getAllSemister();

    @Query("Delete From semister")
    void deleteAll();

}
