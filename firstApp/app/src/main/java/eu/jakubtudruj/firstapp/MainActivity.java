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

        this.setupLayoutElements();

        Student student1 = new Student("Jan", "Kowalski", 25, "ABC123456");
        Student student2 = new Student("Halina", "Nowak", 20, "ABC98765");

        this.setupStudentMarks(student1);
        this.printAllStudentsInformations(student1);

        this.setupStudentMarks(student2);
        this.printAllStudentsInformations(student2);
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

    private void setupStudentMarks(Student student) {
        student.addMark("Projektowanie systemów komputerowych", 5);
        student.addMark("Programowanie JAVA", 4);
        student.addMark("Projektowanie C++", 3);
        student.addMark("Projektowanie Perl", 2);
    }

    private void printAllStudentsInformations(Student student) {
        this.studentDetailTextView.append(student.whatIsYourName() + "\n\n");
        this.studentDetailTextView.append(student.printMarks() + "\n");
        this.studentDetailTextView.append("Averrage: " + student.calculateverrage() + "\n\n");
    }

    private void setupLayoutElements() {
        this.studentDetailTextView= (TextView)findViewById(R.id.studentDesc);
        this.studentDetailTextView.setText("");
    }
}
