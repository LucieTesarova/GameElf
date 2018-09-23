package com.example.lucie.mygame1;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataModel extends SQLiteOpenHelper {

    protected static final String DB_DATABAZE = "databaze";
    protected static final int DB_VERZE = 1;
    protected static final String DB_TABULKA = "tabulka";
    private final Context dbcontext;

    public static final String ATR_ID = "_id";
    public static final String ATR_HLAVNITEXT = "hlavniText";
    public static final String ATR_ODPOVEDA = "odpovedA";
    public static final String ATR_ODPOVEDB = "odpovedB";
    public static final String ATR_ODKAZA = "odkazA";
    public static final String ATR_ODKAZB = "odkazB";

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
// 1.moznost
//        Resources res = dbcontext.getResources();
//        String[] array = res.getStringArray(R.array.my_array);
//        ContentValues val = new ContentValues();
//
//        for (int i = 0; i < array.length; i++) {
//            String item = array[i];
//            switch (i) {
//                case 0:
//                    val.put(ATR_HLAVNITEXT, item);
//                    break;
//                case 1:
//                    val.put(ATR_ODPOVEDA, item);
//                    break;
//                case 2:
//                    val.put(ATR_ODPOVEDB, item);
//                    break;
//                case 3:
//                    val.put(ATR_ODKAZA, item);
//                    break;
//                case 4:
//                    val.put(ATR_ODKAZB, item);
//                    break;
//            }
//        }
//        db.insert(DB_TABULKA, null, val);

// 2.moznost
//        String sInsert = "INSERT INTO " + DB_TABULKA + " ("
//                + ATR_HLAVNITEXT + ", " + ATR_ODPOVEDA + ", "
//                + ATR_ODPOVEDB + ", " + ATR_ODKAZA + ", "
//                + ATR_ODKAZB + ") Values ('hlavniText', 'odpovedA', 'odpovedBB', 'odkazA', 'odkazB')";
//        db.execSQL(sInsert);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + DB_TABULKA;
        db.execSQL(query);
        onCreate(db);
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

    public String getItems() {
        String sSql = "SELECT * FROM " + DB_TABULKA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sSql, null);
        String result = null;

        if (cursor.moveToFirst()) {
            do {
                result = cursor.getString(1);
            } while (cursor.moveToNext());
        }
        return result;
    }
}
