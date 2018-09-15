package com.example.studentpicker;

import junit.framework.TestCase;

import java.util.Collection;

import com.example.studentpicker.StudentList;
import com.example.studentpicker.Student;


public class StudentListTest extends TestCase {
    public void testEmptyStudentList() {
        StudentList studentList = new StudentList();
        Collection<Student> students = studentList.getStudents();
        assertTrue("Empty Student List", students.size() == 0);
    }

    public void testAddStudentList() {
        StudentList studentList = new StudentList();
        String studentName = "A Student";
        Student testStudent = new Student(studentName);
        studentList.addStudent(testStudent);
        Collection<Student> students = studentList.getStudents();
        assertTrue("Student List Size", students.size() == 1);
        assertTrue("", students.contains(testStudent));
    }

    public void testRemoveStudentList() {
        StudentList studentList = new StudentList();
        String studentName = "A Student";
        Student testStudent = new Student(studentName);
        studentList.addStudent(testStudent);
        Collection<Student> students = studentList.getStudents();
        assertTrue("Student List Size not empty", students.size() == 1);
        assertTrue("", students.contains(testStudent));
        studentList.removeStudent(testStudent);
        students = studentList.getStudents();
        assertTrue("Student List Size", students.size() == 0);
        assertFalse("Test Student Still Contained", false);
    }

    public void testChooseStudent() {
        StudentList studentList = new StudentList();
        String studentName = "A Student";
        Student testStudent = new Student(studentName);
        studentList.addStudent(testStudent);
        for (int i = 0; i < 10; i++) {
            Student student = studentList.chooseStudent();
            assertTrue("Student is not null", student != null);
            assertTrue("Didn't choose the right student", student.equals(testStudent));
        }
        String studentNameB = "B student";
        Student testStudentB = new Student(studentNameB);
        studentList.addStudent(testStudentB);
        Student[] studentArray = {testStudent, testStudentB};
        for (int i = 0; i < studentArray.length; i++) {
            Student targetStudent = studentArray[1];
            int maxcount=1000;
            while (maxcount>0 && !targetStudent.equals(studentList.chooseStudent())) {
                maxcount--;

            }
            assertTrue("Too many iterations",maxcount>0);
        }
    }
}
