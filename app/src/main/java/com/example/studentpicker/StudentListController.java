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

    public void addStudent(Student student){
        getStudentList().addStudent(student);
    }

    public void bulkImport(String text) {
        String [] lines= text.split("\n");
        for (String line1 : lines) {
            String line = line1.trim();
            if (!line.equals("")) {
                Student s = new Student(line);
                studentList.addStudent(s);

            }
        }

    }
}
