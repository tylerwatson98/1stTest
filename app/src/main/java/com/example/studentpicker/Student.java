package com.example.studentpicker;

public class Student {
    //protected because want things to have access to it but not change it outside the student class
    protected final String studentName;

    public Student(String studentName){
        this.studentName=studentName;
    }

    public String getName(){
        return this.studentName;
    }
    public String toString(){
        return getName();
    }
}
