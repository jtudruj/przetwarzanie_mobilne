package eu.jakubtudruj.secondapp;

import android.app.DatePickerDialog;
import android.app.LauncherActivity;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.R.id.list;

public class FormActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ListItemEntity> items;
    MyAdapter adapter;

    int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        this.setupListView();
    }

    public void dateButtonClicked(View view) {
        final Calendar c = Calendar.getInstance();
        this.year = c.get(Calendar.YEAR);
        this.month = c.get(Calendar.MONTH);
        this.day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        EditText dateEditText = (EditText) findViewById(R.id.dateEditText);

                        dateEditText.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);

                    }
                }, this.year, this.month, this.day);
        datePickerDialog.show();
    }

    public void saveButtonClicked(View view) {
        EditText placeEditText = (EditText) findViewById(R.id.placeEditText);
        EditText dateEditText = (EditText) findViewById(R.id.dateEditText);
        EditText temperatureEditText= (EditText) findViewById(R.id.temperatureEditText);

        ListItemEntity item = new ListItemEntity(placeEditText.getText().toString(), dateEditText.getText().toString(), temperatureEditText.getText().toString());
        this.items.add(item);
        this.adapter.notifyDataSetChanged();
    }

    private void setupListView() {
        this.listView = (ListView) findViewById(R.id.listView);
        this.items = new ArrayList<ListItemEntity>();

        this.adapter = new MyAdapter(this, this.items);
        this.listView.setAdapter(this.adapter);

    }
}
