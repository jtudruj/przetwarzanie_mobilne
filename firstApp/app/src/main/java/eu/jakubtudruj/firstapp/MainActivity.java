package eu.jakubtudruj.firstapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import eu.jakubtudruj.firstapp.Entities.Student;

public class MainActivity extends AppCompatActivity {

    private Student student;
    private TextView studentDetailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.setupStudent();
        this.setupStudentMarks();
        this.printAllStudentsInformations();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupStudent() {
        this.student = new Student("Jan", "Kowalski", 25, "ABC123456");
        this.studentDetailTextView= (TextView)findViewById(R.id.studentDesc);
        this.studentDetailTextView.setText(this.student.whatIsYourName() + "\n\n");
    }

    private void setupStudentMarks() {
        this.student.addMark("Projektowanie systemów komputerowych", 5);
        this.student.addMark("Programowanie JAVA", 4);
        this.student.addMark("Projektowanie C++", 3);
        this.student.addMark("Projektowanie Perl", 2);
    }

    private void printAllStudentsInformations() {
        this.studentDetailTextView.append(this.student.printMarks());
    }
}
