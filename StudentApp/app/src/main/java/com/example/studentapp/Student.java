package com.example.studentapp;

import java.io.Serializable;

public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private int yearOfBirth;
    private String specialty;

    public Student(String firstName, String lastName, int yearOfBirth, String specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.specialty = specialty;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getSpecialty() {
        return specialty;
    }

    public int getAge() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return currentYear - yearOfBirth;
    }
}
