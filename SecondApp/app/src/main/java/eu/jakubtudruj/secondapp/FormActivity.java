package eu.jakubtudruj.secondapp;

import android.app.DatePickerDialog;
import android.app.LauncherActivity;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.R.id.list;

public class FormActivity extends AppCompatActivity {

    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;

    ListView listView;
    ArrayList<ListItemEntity> items;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        this.setupListView();
//        this.listView = (ListView) findViewById(R.id.listView);
//
//        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_2, items);
//        this.listView.setAdapter(adapter);
    }

    public void dateButtonClicked(View view) {
        this.setupCalendar();
        new DatePickerDialog(this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void saveButtonClicked(View view) {
        EditText placeEditText = (EditText) findViewById(R.id.placeEditText);
        EditText dateEditText = (EditText) findViewById(R.id.dateEditText);
        EditText temperatureEditText= (EditText) findViewById(R.id.temperatureEditText);

        ListItemEntity item = new ListItemEntity(placeEditText.getText().toString(), dateEditText.getText().toString(), temperatureEditText.getText().toString());
        this.items.add(item);
        this.adapter.notifyDataSetChanged();
    }

    public void updateLabel() {
        String myFormat = "yy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);

        EditText dateEditText = (EditText) findViewById(R.id.dateEditText);
        dateEditText.setText(sdf.format(myCalendar.getTime()));
    }

    private void setupCalendar() {
        this.myCalendar = Calendar.getInstance();
        this.date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, Calendar.MONTH, Calendar.DATE);
                updateLabel();
            }
        };
    }

    private void setupListView() {
        this.listView = (ListView) findViewById(R.id.listView);
        this.items = new ArrayList<ListItemEntity>();

//        ListItemEntity item1 = new ListItemEntity("Lublin", "11-11-2011", "8");
//        ListItemEntity item2 = new ListItemEntity("Warszawa", "12-10-1999", "-10");
//        ListItemEntity item3 = new ListItemEntity("Sosnowiec", "30-07-2015", "34");
//
//        this.items.add(item1);
//        this.items.add(item2);
//        this.items.add(item3);

        this.adapter = new MyAdapter(this, this.items);
        this.listView.setAdapter(this.adapter);

    }
}
