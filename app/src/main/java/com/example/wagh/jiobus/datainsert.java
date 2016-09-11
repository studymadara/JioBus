package com.example.wagh.jiobus;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by wagh on 11/9/16.
 */
public class datainsert extends AppCompatActivity {


    Button save;

    EditText datainsertfrom,datainsertfromtime,datainsertto,datainserttotime;

    String datainsertfrom1,datainsertfromtime1,datainsertto1,datainserttotime1;

     public SQLiteDatabase mydb;

    String tablename="Bus";


    public void datasave()
    {
        try
        {
            mydb=this.openOrCreateDatabase(tablename,MODE_PRIVATE,null);

            mydb.execSQL("INSERT INTO "+tablename+" VALUES ('"+datainsertfrom1+"','"+datainsertfromtime1+"','"+datainsertto1+"','"+datainserttotime1+"');");


        }
        catch (Exception e)
        {
            Log.e("DATA INSERT","ERROR",e);
        }
        finally {
            mydb.close();
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.datainsert);

        datainsertfrom=(EditText)findViewById(R.id.datainsertfrom);
        datainsertfromtime=(EditText)findViewById(R.id.datainsertfromtime);
        datainsertto=(EditText)findViewById(R.id.datainsertto);
        datainserttotime=(EditText)findViewById(R.id.datainserttotime);

        save=(Button)findViewById(R.id.datainsertsave);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datainsertfrom1=datainsertfrom.getText().toString();

                datainsertfromtime1=datainsertfromtime.getText().toString();

                datainsertto1=datainsertto.getText().toString();

                datainserttotime1=datainserttotime.getText().toString();

                datasave();


            }
        });


    }
}
