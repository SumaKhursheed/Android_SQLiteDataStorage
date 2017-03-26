package com.example.sqlitedatastorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by suma khursheed on 3/26/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PRODUCT_INFO.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
            "CREATE TABLE "+ ProductInfo.NewProductInfo.TABLE_NAME+"("+ ProductInfo.NewProductInfo.PROD_NAME+" TEXT,"+
                    ProductInfo.NewProductInfo.PROD_DESC+" TEXT,"+ ProductInfo.NewProductInfo.PROD_PRICE+ " TEXT,"+
                    ProductInfo.NewProductInfo.PROD_REVIEW+ " TEXT);";
    public DbHelper (Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("Db Operations", "Database Created");
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_QUERY);
        Log.e("Db Operations", "Table Created");
    }

    public void addProdInfo(String name,String desc,String price,String review,SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ProductInfo.NewProductInfo.PROD_NAME, name);
        contentValues.put(ProductInfo.NewProductInfo.PROD_DESC, desc);
        contentValues.put(ProductInfo.NewProductInfo.PROD_PRICE, price);
        contentValues.put(ProductInfo.NewProductInfo.PROD_REVIEW, review);
        sqLiteDatabase.insert(ProductInfo.NewProductInfo.TABLE_NAME,null,contentValues);
        Log.e("Db Operations", "Row Created");
    }

    public Cursor getProdInfo(DbHelper dbo)
    {
        SQLiteDatabase sqLiteDatabase = dbo.getReadableDatabase();
        String[] columns= {ProductInfo.NewProductInfo.PROD_NAME, ProductInfo.NewProductInfo.PROD_DESC,
                ProductInfo.NewProductInfo.PROD_PRICE, ProductInfo.NewProductInfo.PROD_REVIEW};
        Cursor CR = sqLiteDatabase.query(ProductInfo.NewProductInfo.TABLE_NAME,columns,null,null,null,null,null);
        return CR;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
