package cgpakoto.com.roomdatabase;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

@Database(entities = {Semister.class},version = 2,exportSchema = false)

public abstract class SemisterDatabase extends RoomDatabase {
    public abstract SemisterDao semisterDao();

    private static volatile SemisterDatabase INSTANCE;



    static SemisterDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SemisterDatabase.class) {
                if (INSTANCE == null) {


                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SemisterDatabase.class, "word_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();


                }
            }
        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final SemisterDao mDao;

        PopulateDbAsync(SemisterDatabase db) {
            mDao = db.semisterDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
//            mDao.deleteAll();
//            Semister semister = new Semister(3.25,4.00,"mysem");
//            mDao.insertSemister(semister);
            return null;
        }
    }


}
