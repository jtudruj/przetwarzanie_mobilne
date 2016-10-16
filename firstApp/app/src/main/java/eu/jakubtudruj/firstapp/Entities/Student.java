package eu.jakubtudruj.firstapp.Entities;

import android.util.Log;

/**
 * Created by kuba on 16/10/2016.
 */

public class Student extends Human {
    private static final int MAX_COUNTER = 20;
    public String indexNumber;
    public String[][] subjectMarks = new String[MAX_COUNTER][2];
    private int counter;

    public Student(String name, String surname, int age, String indexNumber) {
        super(name, surname, age);
        this.indexNumber = indexNumber;

        this.counter = 0;
    }

    public addMark(String subject, double mark) {
//        if (this.counter <= MAX_COUNTER) {
//            this.subjectMarks[this.counter][0] = subject;
//            this.subjectMarks[this.counter][1] = String.valueOf(mark);
//            this.counter ++;
//            Log.i("Added subject: " + subject + " and mark: " + mark " at index: " this.counter);
//        } else {
//            Log.e("Maximum counter " + String.valueOf(MAX_COUNTER) + "reached!")
//        }
        try {
            this.subjectMarks[this.counter][0] = subject;
            this.subjectMarks[this.counter][1] = String.valueOf(mark);
            this.counter ++;
            Log.i("Added subject: " + subject + " and mark: " + mark " at index: " this.counter);
        } catch (Exception e) {
            Log.e("Maximum counter " + String.valueOf(MAX_COUNTER) + "reached!")
            e.printStackTrace();
        }

    }

    public printMarks() {
        String marks = "";
        for (int i=0; i < this.subjectMarks.length; i++) {
            for (int j=0; j < this.subjectMarks[0].length; j++) {
                marks += String
            }
        }
    }

}
