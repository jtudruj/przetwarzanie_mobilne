package eu.jakubtudruj.secondapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Array;
import java.sql.SQLData;

/**
 * Created by kuba on 30/10/2016.
 */

public class TempDbHelper extends SQLiteOpenHelper {

    public TempDbHelper(Context context) {
        super(context, ListItemContract.DATABASE_NAME, null, ListItemContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ListItemContract.TempHistory.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ListItemContract.TempHistory.DELETE_TABLE);
        onCreate(db);
    }

    public Cursor getTemperatures() {
        //pierwszy sposob
        Cursor firstCursor = this.getReadableDatabase().rawQuery("SELECT _ID, "+ListItemContract.TempHistory.COLUMN_NAME_PLACE+", "+ListItemContract.TempHistory.COLUMN_NAME_DATE+", " +ListItemContract.TempHistory.COLUMN_NAME_TEMPERATURE+" FROM " +ListItemContract.TempHistory.TABLE_NAME, null);

        //drugi sposob
        String[] columns = new String[] {
            ListItemContract.TempHistory.COLUMN_NAME_PLACE,
            ListItemContract.TempHistory.COLUMN_NAME_DATE,
            ListItemContract.TempHistory.COLUMN_NAME_TEMPERATURE,
        };

        Cursor secondCursor = this.getReadableDatabase().query(ListItemContract.TempHistory.TABLE_NAME, columns, null, null, null, null, null);
        return firstCursor;
    }


    public void insertTemp(ListItemEntity entity) {
        ContentValues values = new ContentValues();
        values.put(ListItemContract.TempHistory.COLUMN_NAME_PLACE, entity.getPlace());
        values.put(ListItemContract.TempHistory.COLUMN_NAME_DATE, entity.getDate());
        values.put(ListItemContract.TempHistory.COLUMN_NAME_TEMPERATURE, entity.getTemperature());

        long newRowId;
        newRowId = this.getReadableDatabase().insert(ListItemContract.TempHistory.TABLE_NAME, null, values);
    }
}
