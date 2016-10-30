package eu.jakubtudruj.secondapp;

import android.provider.BaseColumns;

/**
 * Created by kuba on 30/10/2016.
 */

public final class ListItemContract {
    public ListItemContract() {
    }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "weather.db";
    public static final String TEXT_TYPE = " TEXT";
    public static final String DOUBLE_TYPE = " REAL";
    public static final String COMMA_SEP = ",";

    public static abstract class Temp_history implements BaseColumns {
        public static final String TABLE_NAME = "temperatures";
        public static final String COLUMN_NAME_PLACE = "place";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_TEMPERATURE = "temperature";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY," + COLUMN_NAME_PLACE + TEXT_TYPE + COMMA_SEP + COLUMN_NAME_DATE + TEXT_TYPE + COMMA_SEP + COLUMN_NAME_TEMPERATURE + DOUBLE_TYPE + ")";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS" + TABLE_NAME;
    }

}
