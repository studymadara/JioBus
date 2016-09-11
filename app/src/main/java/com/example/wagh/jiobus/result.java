package com.example.wagh.jiobus;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wagh on 10/9/16.
 */
public class result extends AppCompatActivity {

    String fromResult,toResult;

    SQLiteDatabase mydb;

    String tablename="Bus";

    String fresult,tresult;

    int cfresult,ctresult,count,i;

    Button admin;

    RecyclerView rv1;

    List<adapterdata> adapterdatas=new ArrayList<adapterdata>();

    public void datasetup()
    {
        try
        {
            mydb=this.openOrCreateDatabase(tablename,MODE_PRIVATE,null);  //database chalu hai ..................*****************

            mydb.execSQL("CREATE TABLE IF NOT EXISTS "+tablename+" (Stop_1 VARCHAR2, Stop_1_Time VARCHAR2,Stop_2 VARCHAR2, Stop_2_Time VARCHAR2);");


        }
        catch (Exception e)
        {
            Log.e("ERROR SETUP","DB",e);
        }
    }


    public void datasearch()
    {
        try
        {

            adapterdata adapterdata11;

            Cursor cursor=mydb.rawQuery("SELECT Stop_1,Stop_1_Time,Stop_2,Stop_2_Time FROM "+tablename+" WHERE Stop_1=='"+fromResult+"' AND Stop_2=='"+toResult+"'",null);

            cfresult=cursor.getColumnIndex("Stop_1_Time");

            ctresult=cursor.getColumnIndex("Stop_2_Time");

            count=cursor.getCount();

            cursor.moveToFirst();

            for (i=0;i<=count;i++)
            {
                fresult=cursor.getString(cfresult);

                tresult=cursor.getString(ctresult);

                adapterdata11=new adapterdata();

                adapterdata11.setFromadapter(fresult);

                adapterdata11.setToadapter(tresult);

                adapterdatas.add(adapterdata11);

                cursor.moveToNext();

                Toast.makeText(result.this,"1",Toast.LENGTH_LONG).show();

            }

            cursor.close();

        }
        catch (Exception e)
        {
            Log.e("ERROR SEARCH","DB",e);
        }
        finally {


            mydb.close();
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        Intent i2=getIntent();

        fromResult=i2.getStringExtra("From");
        toResult=i2.getStringExtra("To");

        admin=(Button)findViewById(R.id.admin);



        datasetup();


        datasearch();





        rv1=(RecyclerView)findViewById(R.id.rv1);

        rv1.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);

        rv1.setLayoutManager(linearLayoutManager);

        RecyclerView.Adapter adaptercycle=new adapterrecycle(adapterdatas);

        rv1.setAdapter(adaptercycle);


    //****************************************************************************visit here *******************
        //**

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ii=new Intent(result.this,datainsert.class);

                startActivity(ii);

            }
        });




    }
}
