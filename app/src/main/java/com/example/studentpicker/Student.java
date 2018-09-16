package com.example.studentpicker;

import java.io.Serializable;

public class Student implements Serializable {
    //protected because want things to have access to it but not change it outside the student class
    private final String studentName;

    public Student(String studentName){
        this.studentName=studentName;
    }

    public String getName(){
        return this.studentName;
    }
    public String toString(){
        return getName();
    }

    public boolean equals(Object compareStudent) {
        return compareStudent != null && compareStudent.getClass() == this.getClass() && this.equals((Student) compareStudent);
    }

    public boolean equals(Student compareStudent) {
        return compareStudent != null && getName().equals(compareStudent.getName());
    }

    public int hashcode(){
        return ("Student: "+getName()).hashCode();
    }
}
