package com.example.sqlitedatastorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertionActivity extends Activity {
    EditText ProdName, ProdDescription, ProdPrice, ProdReview;
    Context context = this;
    DbHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion);
        ProdName = (EditText) findViewById(R.id.name);
        ProdDescription = (EditText) findViewById(R.id.desc);
        ProdPrice = (EditText) findViewById(R.id.price);
        ProdReview = (EditText) findViewById(R.id.review);
    }

    public void addProd(View view)
    {
        String name = ProdName.getText().toString();
        String description = ProdDescription.getText().toString();
        String price = ProdPrice.getText().toString();
        String review = ProdReview.getText().toString();
        dbHelper = new DbHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
        dbHelper.addProdInfo(name,description,price,review,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();
        dbHelper.close();

    }

    public void back (View view)
    {
        Intent intent = new Intent(InsertionActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
