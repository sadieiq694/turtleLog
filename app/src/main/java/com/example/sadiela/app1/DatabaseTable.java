package com.example.sadiela.app1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    public static final String CAPT_NUM = "CAPTURE_NUMBER";
    public static final String STR_CL_MIN = "STRAIGHT_CARAPACE_LENGTH_MINIMUM";
    public static final String STR_CL_NT = "STRAIGHT_CARAPACE_LENGTH_NOTCH_TO_TIP";
    public static final String STR_CW = "STRAIGHT_CARAPACE_WIDTH";
    public static final String CUR_CL_MIN = "CURVED_CARAPACE_LENGTH_MINIMUM";
    public static final String CUR_CL_NT = "CURVED_CARAPACE_LENGTH_NOTCH_TO_TIP";
    public static final String CUR_CW = "CURVED_CARAPACE_WIDTH";
    public static final String H_D = "HEAD_DEPTH";
    public static final String H_L = "HEAD_LENGTH";
    public static final String H_W = "HEAD_WIDTH";
    public static final String B_D = "BODY_DEPTH";
    public static final String P_KEY = "PRIMARY_KEY";

    private static final String DATABASE_NAME = "CAPTURES";
    private static final int DATABASE_VERSION = 2;

    public final DatabaseOpenHelper database_open_helper;

    public DatabaseTable(Context context) {
        database_open_helper = new DatabaseOpenHelper(context);
    }

    public static class DatabaseOpenHelper extends SQLiteOpenHelper {

        public final Context helper_context;
        public SQLiteDatabase database;

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + DATABASE_NAME +
                        " (" + CAPT_DATE + " TEXT," + P_KEY + " INTEGER, "
                        + CAPT_LOC + " TEXT, " +
                        CAPT_NUM + " INTEGER, " + STR_CL_MIN + " REAL, "
                        + STR_CL_NT + " REAL, " + STR_CW + " REAL, " + CUR_CL_MIN
                        + " REAL, " + CUR_CL_NT + " REAL, " + CUR_CW + " REAL, " +
                        H_D + " REAL, " + H_L + " REAL, " + H_W + " REAL, " + B_D + " REAL)";

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

    public void insert(Capture capture) {
        SQLiteDatabase db = database_open_helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CAPT_DATE, capture.date);
        values.put(CAPT_LOC, capture.location);
        values.put(CAPT_NUM, capture.catchNum);
        values.put(STR_CL_MIN, capture.strCLMin);
        values.put(STR_CL_NT, capture.strCLnt);
        values.put(STR_CW, capture.strCW);
        values.put(CUR_CL_MIN, capture.curCLMin);
        values.put(CUR_CL_NT, capture.curCLnt);
        values.put(CUR_CW, capture.curCW);
        values.put(H_D, capture.headD);
        values.put(H_W, capture.headL);
        values.put(H_L, capture.headW);
        values.put(B_D, capture.bodyD);


        long newRowid = db.insert(DATABASE_NAME, null, values);
    }

    void dump()
    {
        SQLiteDatabase db = database_open_helper.getReadableDatabase();

        String[] columns = {
                CAPT_DATE,
                CAPT_NUM,
                CAPT_LOC,
                STR_CL_MIN,
                STR_CL_NT,
                STR_CW,
                CUR_CL_MIN,
                CUR_CL_NT,
                CUR_CW,
                H_D,
                H_W,
                H_L,
                B_D
        };

    /*
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.

        // Filter results WHERE "title" = 'My Title'
                String selection = FeedEntry.COLUMN_NAME_TITLE + " = ?";
                String[] selectionArgs = { "My Title" };

        // How you want the results sorted in the resulting Cursor
                String sortOrder =
                        FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";
                        */

        Cursor cursor = db.query(
                DATABASE_NAME,                     // The table to query
                columns,                               // The columns to return
                null, // selection,                                // The columns for the WHERE clause
                null, // selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null // sortOrder

                // The sort order
        );

        cursor.moveToFirst();
        while(cursor.isAfterLast() == false) {
            for(int i = 0; i < 13; i++) {
                Log.d("data column", String.valueOf(cursor.getInt(i)));
            }
            cursor.moveToNext();
        }


        //somehow loop over cursor and log the results
    }
}