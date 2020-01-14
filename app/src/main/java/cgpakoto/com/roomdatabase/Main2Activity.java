package cgpakoto.com.roomdatabase;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText smisternameet,semistergpaet,semistercreditet;
    Button addbutton;
    SemisterViewModel myviewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addbutton=findViewById(R.id.addbutton);
        semistercreditet=findViewById(R.id.semistercredit);
        semistergpaet=findViewById(R.id.semistergpa);
        smisternameet=findViewById(R.id.semistername);

        myviewmodel= ViewModelProviders.of(this).get(SemisterViewModel.class);



        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double gpa=Double.parseDouble(semistergpaet.getText().toString());
                double credit=Double.parseDouble(semistercreditet.getText().toString());
                String name=smisternameet.getText().toString();
                Semister temp=new Semister(gpa,credit,name);
                myviewmodel.InsertSemister(temp);

                Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);


            }
        });


    }
}
