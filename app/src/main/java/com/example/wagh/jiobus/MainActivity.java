package com.example.wagh.jiobus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    AutoCompleteTextView actvfrom,actvto;
    Button find;

    String fromMain,toMain;

    String[] stops={"Rabale","TC-23","Stop A","Stop B","Stop C","Stop D","Stop E"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        actvfrom=(AutoCompleteTextView)findViewById(R.id.actvfrom);
        actvto=(AutoCompleteTextView)findViewById(R.id.actvto);

        find=(Button)findViewById(R.id.find);

        ArrayAdapter arrayAdapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,stops);

        actvfrom.setAdapter(arrayAdapter);
        actvfrom.setThreshold(1);

        actvto.setAdapter(arrayAdapter);
        actvto.setThreshold(1);



        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                fromMain=actvfrom.getText().toString();
                toMain=actvto.getText().toString();

                Intent i=new Intent(MainActivity.this,result.class);

                i.putExtra("From",fromMain);
                i.putExtra("To",toMain);

                startActivity(i);



            }
        });



    }
}
