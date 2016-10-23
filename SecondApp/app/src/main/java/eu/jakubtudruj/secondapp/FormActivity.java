package eu.jakubtudruj.secondapp;

import android.app.DatePickerDialog;
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

    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.YEAR, Calendar.MONTH, Calendar.DATE);
//            myCalendar.set(Calendar.MONTH, month);
//            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };


    ListView listView = (ListView) findViewById(R.id.listView);
    ArrayList<ListItemEntity> items = new ArrayList<ListItemEntity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_2, items);
        this.listView.setAdapter(adapter);
    }

    public void dateButtonClicked(View view) {
        new DatePickerDialog(this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void saveButtonClicked(View view) {
        
    }

    public void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        EditText dateEditText = (EditText) findViewById(R.id.dateEditText);
        dateEditText.setText(sdf.format(myCalendar.getTime()));
    }
}
