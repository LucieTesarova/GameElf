package com.example.lucie.mygame1;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
 Trida Datamodel
 Umoznuje vytvoreni databaze a praci s daty
 */
public class DataModel extends SQLiteOpenHelper {

    private static final String DB_DATABAZE = "databaze";
    private static final int DB_VERZE = 3;
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
        String[] array6 = res.getStringArray(R.array.my_array6);
        String[] array7 = res.getStringArray(R.array.my_array7);
        String[] array8 = res.getStringArray(R.array.my_array8);
        String[] array9 = res.getStringArray(R.array.my_array9);
        String[] array10 = res.getStringArray(R.array.my_array10);
        String[] array11 = res.getStringArray(R.array.my_array11);
        String[] array12 = res.getStringArray(R.array.my_array12);
        String[] array13 = res.getStringArray(R.array.my_array13);
        String[] array14 = res.getStringArray(R.array.my_array14);
        String[] array15 = res.getStringArray(R.array.my_array15);
        String[] array16 = res.getStringArray(R.array.my_array16);
        String[] array17 = res.getStringArray(R.array.my_array17);
        String[] array18 = res.getStringArray(R.array.my_array18);
        String[] array19 = res.getStringArray(R.array.my_array19);

        zapisData(array, db);
        zapisData(array2, db);
        zapisData(array3, db);
        zapisData(array4, db);
        zapisData(array5, db);
        zapisData(array6, db);
        zapisData(array7, db);
        zapisData(array8, db);
        zapisData(array9, db);
        zapisData(array10, db);
        zapisData(array11, db);
        zapisData(array12, db);
        zapisData(array13, db);
        zapisData(array14, db);
        zapisData(array15, db);
        zapisData(array16, db);
        zapisData(array17, db);
        zapisData(array18, db);
        zapisData(array19, db);

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

    public Item getItem(int id) {
        String sSql = "SELECT * FROM " + DB_TABULKA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sSql, null);
        Item item;
        int result;

        if (cursor.moveToFirst()) {
            do {
                result = cursor.getInt(0);
                if (result == id){
                    item = new Item(id, cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
                    db.close();
                    return item;
                }
            } while (cursor.moveToNext());
        }
        db.close();
        return null;
    }
}
