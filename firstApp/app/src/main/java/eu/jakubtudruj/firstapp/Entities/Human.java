package eu.jakubtudruj.firstapp.Entities;

/**
 * Created by kuba on 16/10/2016.
 */

public class Human {
    public String name;
    public String surname;
    public int age;

    Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String whatIsYourName() {
        return this.name + " " + this.surname;
    }

//setters & getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
