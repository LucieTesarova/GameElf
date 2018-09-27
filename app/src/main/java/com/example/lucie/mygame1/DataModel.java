package com.example.lucie.mygame1;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.TypedValue;

public class DataModel extends SQLiteOpenHelper {

    private static final String DB_DATABAZE = "databaze";
    private static final int DB_VERZE = 1;
    private static final String DB_TABULKA = "tabulka";
    private final Context dbcontext;

    private static final String ATR_ID = "_id";
    private static final String ATR_HLAVNITEXT = "hlavniText";
    private static final String ATR_ODPOVEDA = "odpovedA";
    private static final String ATR_ODPOVEDB = "odpovedB";
    private static final String ATR_ODKAZA = "odkazA";
    private static final String ATR_ODKAZB = "odkazB";

    public DataModel(Context context) {
        super(context, DB_DATABAZE, null, DB_VERZE);
        dbcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + DB_TABULKA
                + " (" + ATR_ID + " INTEGER PRIMARY KEY,"
                + ATR_HLAVNITEXT + " TEXT,"
                + ATR_ODPOVEDA + " TEXT,"
                + ATR_ODPOVEDB + " TEXT,"
                + ATR_ODKAZA + " TEXT,"
                + ATR_ODKAZB + " TEXT"
                + ");");

        Resources res = dbcontext.getResources();
        String[] array = res.getStringArray(R.array.my_array1);
        String[] array2 = res.getStringArray(R.array.my_array2);
        String[] array3 = res.getStringArray(R.array.my_array3);
        String[] array4 = res.getStringArray(R.array.my_array4);
        String[] array5 = res.getStringArray(R.array.my_array5);
        zapisData(array, db);
        zapisData(array2, db);
        zapisData(array3, db);
        zapisData(array4, db);
        zapisData(array5, db);

// 2.moznost
//        String sInsert = "INSERT INTO " + DB_TABULKA + " ("
//                + ATR_HLAVNITEXT + ", " + ATR_ODPOVEDA + ", "
//                + ATR_ODPOVEDB + ", " + ATR_ODKAZA + ", "
//                + ATR_ODKAZB + ") Values ('hlavniTexxxt', 'odpovedA', 'odpovedBB', 'odkazA', 'odkazB')";
//        db.execSQL(sInsert);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + DB_TABULKA;
        db.execSQL(query);
        onCreate(db);
    }

    private void zapisData(String[] array, SQLiteDatabase db){
        ContentValues val = new ContentValues();

        for (int i = 0; i < array.length; i++) {
            String item = array[i];
            switch (i) {
                case 0:
                    val.put(ATR_HLAVNITEXT, item);
                    break;
                case 1:
                    val.put(ATR_ODPOVEDA, item);
                    break;
                case 2:
                    val.put(ATR_ODPOVEDB, item);
                    break;
                case 3:
                    val.put(ATR_ODKAZA, item);
                    break;
                case 4:
                    val.put(ATR_ODKAZB, item);
                    break;
            }
        }
        db.insert(DB_TABULKA, null, val);
    }

//    public void deleteTable(){
//        String query = "DROP TABLE IF EXISTS " + DB_TABULKA;
//        SQLiteDatabase db = this.getReadableDatabase();
//        db.execSQL(query);
//    }

//    public long insertItem() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues val = new ContentValues();
//        val.put(ATR_HLAVNITEXT, "hlavnitext");
//        val.put(ATR_ODPOVEDA, "odpovedAAA");
//        val.put(ATR_ODKAZB, "odpovedB");
//        val.put(ATR_ODKAZA, "odkazA");
//        val.put(ATR_ODKAZB, "odkazB");
//        long id = db.insert(DB_TABULKA, null, val);
//        db.close();
//        return id;
//    }

    public Integer getItem(int id) {
        String sSql = "SELECT * FROM " + DB_TABULKA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sSql, null);
        int result;

        if (cursor.moveToFirst()) {
            do {
                result = cursor.getInt(0);
                if (result == id){
                    return result;
                }
            } while (cursor.moveToNext());
        }
        return -1;
    }
}
