package cgpakoto.com.roomdatabase;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Semister> listofsemister=new ArrayList<>();
    RecyclerView recyclerView;
    SemisterAdapter semisterAdapter;
    SemisterViewModel semisterViewModel;
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        addButton=findViewById(R.id.addsemisterButton);


       // listofsemister.add(new Semister(2.25,3.25,"my semister"));


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        semisterAdapter =new SemisterAdapter(listofsemister);
        recyclerView.setAdapter(semisterAdapter);

        semisterViewModel= ViewModelProviders.of(this).get(SemisterViewModel.class);

        semisterViewModel.GetALlSemister().observe(this, new Observer<List<Semister>>() {
            @Override
            public void onChanged(@Nullable List<Semister> semisters) {
                listofsemister=semisters;


                Toast.makeText(MainActivity.this, semisters.size()+"size:", Toast.LENGTH_SHORT).show();
                semisterAdapter.notifyDataSetChanged();
            }
        });



    }
}
