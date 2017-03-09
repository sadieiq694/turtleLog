package com.example.sadiela.app1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by sadie.la on 2/27/2017.
 */
public class DatabaseTable {
    private static final String TAG = "CaptureDatabase";
    //Columns to include (add more later)
    public static final String CAPT_DATE = "DATE";
    public static final String CAPT_LOC = "LOCATION";
    public static final String CAPT_NUM = "CAPTURE NUMBER";
    // public static final String
    // public static final String
    // public static final String
    // public static final String
    // public static final String
    // public static final String


    private static final String DATABASE_NAME = "CAPTURES";
    private static final int DATABASE_VERSION = 1;

    public final DatabaseOpenHelper database_open_helper;

    public DatabaseTable(Context context) {
        database_open_helper = new DatabaseOpenHelper(context);
    }

    public static class DatabaseOpenHelper extends SQLiteOpenHelper {

        public final Context helper_context;
        public SQLiteDatabase database;

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + DATABASE_NAME +
                        " (" + CAPT_DATE + " INTEGER,"
                        + CAPT_LOC + " TEXT, " +
                        CAPT_NUM + " INTEGER)";

        DatabaseOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            helper_context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            database = db;
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }

    }
}