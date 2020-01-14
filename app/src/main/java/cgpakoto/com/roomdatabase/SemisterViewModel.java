package cgpakoto.com.roomdatabase;

import android.app.Application;
import android.app.ListActivity;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class SemisterViewModel extends AndroidViewModel {
         public  Repository myrepository;
         LiveData<List<Semister>>allSemister;



    public SemisterViewModel(@NonNull Application application) {
        super(application);
        myrepository=new Repository(application);
        this.allSemister=myrepository.getAllSemister();
    }

    public  LiveData<List<Semister>>GetALlSemister(){
        return allSemister;
    }

    public  void InsertSemister(Semister semister){
        myrepository.InsertSemister(semister);
    }

}
