package eu.jakubtudruj.firstapp.Entities;

/**
 * Created by kuba on 16/10/2016.
 */

public class SubjectMark {
    private String subject;
    private double mark;

    public String getSubject() {
        return subject;
    }

    public double getMark() {
        return mark;
    }

    public SubjectMark(String subject, double mark) {
        this.subject = subject;
        this.mark = mark;
    }
}
