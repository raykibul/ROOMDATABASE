package cgpakoto.com.roomdatabase;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SemisterAdapter.OnRecyclerItemClickInterface {
    List<Semister> listofsemister=new ArrayList<>();
    RecyclerView recyclerView;
    SemisterAdapter semisterAdapter;
    SemisterViewModel semisterViewModel;
    Button addButton;
    SemisterAdapter.OnRecyclerItemClickInterface InterFace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        addButton=findViewById(R.id.addsemisterButton);
        InterFace=this;



       // listofsemister.add(new Semister(2.25,3.25,"my semister"));


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });



        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT
                |ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                DeleteSemister(viewHolder.getAdapterPosition());


            }
        }).attachToRecyclerView(recyclerView);



        semisterViewModel= ViewModelProviders.of(this).get(SemisterViewModel.class);

        semisterViewModel.GetALlSemister().observe(this, new Observer<List<Semister>>() {
            @Override
            public void onChanged(@Nullable List<Semister> semisters) {

                listofsemister=semisters;

                Toast.makeText(MainActivity.this, semisters.size()+"size:", Toast.LENGTH_SHORT).show();
                semisterAdapter =new SemisterAdapter(listofsemister,InterFace);
                recyclerView.setAdapter(semisterAdapter);
            }
        });


    }

    private void DeleteSemister(final int position) {

        new AlertDialog.Builder(this)
                .setMessage("Do you want to delete the semister?")
                .setTitle("WARNING!!!")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //delete function called

                        Semister temp=listofsemister.get(position);

                        semisterViewModel.DeleteSemister(temp);
                        semisterAdapter.notifyDataSetChanged();

                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }

    @Override
    public void OnItemClick(int position) {
        Semister temp=listofsemister.get(position);
        temp.setSemister_name("RAKIB");
        temp.setSemister_gpa(4.0);
        temp.setSemister_credit(4.0);

        semisterViewModel.UpdateSemister(temp);

    }
}
