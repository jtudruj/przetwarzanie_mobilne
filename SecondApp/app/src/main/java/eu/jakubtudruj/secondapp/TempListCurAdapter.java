package eu.jakubtudruj.secondapp;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kuba on 30/10/2016.
 */

public class TempListCurAdapter extends CursorAdapter {
    public TempListCurAdapter(Context context, Cursor c) {
        super(context, c);
    }

    public TempListCurAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    public TempListCurAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_row, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView placeTextView = (TextView) view.findViewById(R.id.list_place);
        TextView temperatureTextView = (TextView) view.findViewById(R.id.list_temperature);
        TextView dateTextView = (TextView) view.findViewById(R.id.list_date);

        String place = cursor.getString(cursor.getColumnIndexOrThrow(ListItemContract.TempHistory.COLUMN_NAME_PLACE));
        String temperature = cursor.getString(cursor.getColumnIndexOrThrow(ListItemContract.TempHistory.COLUMN_NAME_TEMPERATURE));
        String date = cursor.getString(cursor.getColumnIndexOrThrow(ListItemContract.TempHistory.COLUMN_NAME_DATE));

        placeTextView.setText(place);
        temperatureTextView.setText(temperature);
        dateTextView.setText(date);
    }
}
