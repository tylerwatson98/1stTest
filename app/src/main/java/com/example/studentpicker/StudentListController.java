package com.example.studentpicker;

public class StudentListController {
    private static StudentList studentList = null;
    static public StudentList getStudentList(){
        if (studentList == null) {
            studentList = new StudentList();
        }
        return studentList;
    }

    public Student chooseStudent() throws EmptyStudentListException{
        return getStudentList().chooseStudent();
    }
}
