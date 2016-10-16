package eu.jakubtudruj.firstapp.Entities;

import android.util.Log;
import eu.jakubtudruj.firstapp.Entities.SubjectMark;
import java.util.ArrayList;
/**
 * Created by kuba on 16/10/2016.
 */

public class Student extends Human {
    private static final int MAX_COUNTER = 20;
    public String indexNumber;
    public ArrayList<SubjectMark> subjectMarks = new ArrayList<SubjectMark>();
    private int counter;

    public Student(String name, String surname, int age, String indexNumber) {
        super(name, surname, age);
        this.indexNumber = indexNumber;

        this.counter = 0;
    }

    public void addMark(String subject, double mark) {
        this.subjectMarks.add(new SubjectMark(subject, mark));
    }

    public String printMarks() {
        String marks = "";


        for (int i=0; i < this.subjectMarks.size(); i++) {
            String tab = "\t\t";
            if (i%2 != 0) {
                tab = "";
            }
            marks += this.subjectMarks.get(i).getSubject() + ": " + tab + String.valueOf(this.subjectMarks.get(i).getMark()) + "\n";
        }
        return marks;
    }

}
