package com.example.studentpicker;


import junit.framework.TestCase;

import java.io.IOException;

public class StudentListManagerTest extends TestCase {

    public void testStudentToString(){
        StudentList sl=new StudentList();
        Student testStudent=new Student("TestStudent");
        sl.addStudent(testStudent);
        try{
            String str= StudentListManager.studentListToString(sl);
            assertTrue("String is to small", str.length()>0);
            StudentList sl2 = StudentListManager.studentListFromString(str);
            assertTrue("Sl2 does not contain test student",sl2.contains(testStudent));
        } catch (IOException e){
            e.printStackTrace();
            assertTrue("IOException thrown "+e.toString(), false);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            assertTrue("Class not found exception thrown "+e.toString(), false);
        }
    }

    public void testStudentListManager() {
        try {
            StudentList sl = new StudentList();
            Student testStudent = new Student("TestStudent");
            sl.addStudent(testStudent);
            StudentListManager slm = new StudentListManager();
            slm.saveStudentList(sl);
            StudentList sl2 = slm.loadStudentList();
            assertTrue("Sl2 size not consistent", sl2.size()==1);
            assertTrue("Test student is not in student list 2", sl2.contains(testStudent));
            assertTrue("Testcase is in student list", sl.contains(testStudent));
        } catch (IOException e) {
            e.printStackTrace();
            assertTrue("IOException thrown "+e.toString(), false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            assertTrue("Class not found exception thrown "+e.toString(), false);
        }

    }
}
