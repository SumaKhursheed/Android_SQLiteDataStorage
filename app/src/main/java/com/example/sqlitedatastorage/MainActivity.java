package com.example.sqlitedatastorage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insertItem (View view)
    {
        Intent intent = new Intent(MainActivity.this, InsertionActivity.class);
        startActivity(intent);
    }

    public void searchItem (View view)
    {
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);
    }
}
