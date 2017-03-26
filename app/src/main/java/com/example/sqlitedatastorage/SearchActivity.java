package com.example.sqlitedatastorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends Activity {
    EditText Searchitem, Output;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Searchitem = (EditText) findViewById(R.id.search);
        Output = (EditText) findViewById(R.id.output);
    }

    public void searchItem (View view)
    {
        String item = Searchitem.getText().toString();
        DbHelper dbo= new DbHelper(context);
        Cursor CR = dbo.getProdInfo(dbo);
        CR.moveToFirst();
        boolean status = false;
        do
        {
           if(item.equals(CR.getString(0)) || (item.equals(CR.getString(1))) || (item.equals(CR.getString(2)))
                   || (item.equals(CR.getString(3))))
            {
                status = true;
                Output.setText("Name: "+ CR.getString(0)+"\nDescription: "+CR.getString(1)
                        +"\nPrice: "+CR.getString(2)+"\nReview: "+CR.getString(3));
            }
        }
        while (CR.moveToNext());
        if(status)
        {
            Toast.makeText(getBaseContext(), "Item Found", Toast.LENGTH_LONG).show();
        }
         else
        {
            Toast.makeText(getBaseContext(), "Item Not Found", Toast.LENGTH_LONG).show();
        }

    }

    public void back (View view)
    {
        Intent intent = new Intent(SearchActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
