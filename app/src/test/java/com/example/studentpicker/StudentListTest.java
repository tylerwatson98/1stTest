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
        assertTrue("Student List Size", studentList.size() == 1);
        assertTrue("", studentList.contains(testStudent));
    }

    public void testGetStudents() {
        StudentList studentList = new StudentList();
        String studentName = "A Student";
        Student testStudent = new Student(studentName);
        studentList.addStudent(testStudent);
        assertTrue("Student List Size", studentList.size() == 1);
        assertTrue("", studentList.contains(testStudent));
    }

    public void testRemoveStudentList() {
        StudentList studentList = new StudentList();
        String studentName = "A Student";
        Student testStudent = new Student(studentName);
        studentList.addStudent(testStudent);
        assertTrue("Student List Size not empty", studentList.size() == 1);
        assertTrue("", studentList.contains(testStudent));
        studentList.removeStudent(testStudent);
        assertTrue("Student List Size", studentList.size() == 0);
        assertFalse("Test Student Still Contained", false);
    }

    public void testChooseStudent() throws EmptyStudentListException {
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
        for (Student aStudentArray : studentArray) {
            Student targetStudent = studentArray[1];
            int maxcount = 1000;
            while (maxcount > 0 && !targetStudent.equals(studentList.chooseStudent())) {
                maxcount--;
            }
            assertTrue("Too many iterations", maxcount > 0);
        }
    }

    public void testChooseEmptyStudentList(){
        StudentList studentList = new StudentList();
        try {
            Student s = studentList.chooseStudent();
            assertFalse("We couldn not reach here", s==null);
            assertTrue("We couldn not reach here", false);
        } catch (EmptyStudentListException a){
            assertTrue("We couldn not reach here", true);
        }

    }

    boolean updated=false;
    public void testNotifyListeners() {
        StudentList studentList = new StudentList();
        updated = false;
        Listener l = new Listener() {
            @Override
            public void update() {
                StudentListTest.this.updated=true;
            }
        };
        studentList.addListener(l);
        studentList.addStudent(new Student("Newbie"));
        assertTrue("Student list didnt send update",this.updated);
    }

    public void testRemoveListeners() {
        StudentList studentList = new StudentList();
        updated = false;
        Listener l = new Listener() {
            @Override
            public void update() {
                StudentListTest.this.updated=true;
            }
        };
        studentList.addListener(l);
        studentList.removeListener(l);
        studentList.addStudent(new Student("Newbie"));
        assertFalse("Student list didnt send update",this.updated);
    }

}
