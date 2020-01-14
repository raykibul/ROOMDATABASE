package cgpakoto.com.roomdatabase;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class Repository {
    public  SemisterDao semisterDao;
    LiveData<List<Semister>> allSemister;

    Repository(Application application){
        SemisterDatabase db=SemisterDatabase.getDatabase(application);
        semisterDao=db.semisterDao();
        allSemister=semisterDao.getAllSemister();
    }

  public LiveData<List<Semister>> getAllSemister(){
        return  allSemister;
  }


  public void  InsertSemister(Semister semister){
        new InsertTask(semisterDao).execute(semister);

  }


  public class  InsertTask extends AsyncTask<Semister,Void,Void>{
          private  SemisterDao semisterDao;

      public InsertTask(SemisterDao semisterDao) {

          this.semisterDao = semisterDao;
      }

      @Override
      protected Void doInBackground(Semister... perams) {

          semisterDao.insertSemister(perams[0]);

          return null;
      }
  }

}
