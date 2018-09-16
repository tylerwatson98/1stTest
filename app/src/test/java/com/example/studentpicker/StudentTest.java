package com.example.studentpicker;

import junit.framework.TestCase;

public class StudentTest extends TestCase{
    public void testStudent(){
        String studentName= "A Student";
        Student student = new Student(studentName);
        assertTrue("Student string is not equal", studentName.equals(student.getName()));
    }

    public void testStudentToString(){
        String studentName= "A Student";
        Student student = new Student(studentName);
        assertTrue("Student name.Tostring is not equal", studentName.equals(student.getName()));
    }

    public void testStudentEquals(){
        String studentName= "A Student";
        String studentNameC= "C Student";
        Student studentA = new Student(studentName);
        Student studentB = new Student(studentName);
        Student studentC = new Student(studentNameC);
        assertTrue("A!=B",studentA.equals(studentB));
        assertTrue("B!=A",studentB.equals(studentA));

    }
}
