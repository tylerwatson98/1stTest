package com.example.studentpicker;

import junit.framework.TestCase;
import com.example.studentpicker.Student;

public class StudentTest extends TestCase{
    public void testStudent(){
        String studentName= "A Student";
        Student student = new Student(studentName);
        assertTrue("Student Name is equal", studentName.equals(student.getName()));
        assertTrue("Student string is not equal", studentName.equals(student.getName()));
    }
}
