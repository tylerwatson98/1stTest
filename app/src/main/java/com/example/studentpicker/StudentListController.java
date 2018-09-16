package com.example.studentpicker;

import java.io.IOException;

class StudentListController {
    private static StudentList studentList = null;
    static public StudentList getStudentList(){
        if (studentList == null) {
            try {
                studentList= StudentListManager.getManager().loadStudentList();
                studentList.addListener(new Listener() {
                    @Override
                    public void update() {
                        saveStudentList();
                    }
                });
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return studentList;
    }

    private static void saveStudentList(){
        try {
            StudentListManager.getManager().saveStudentList(getStudentList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Student chooseStudent() throws EmptyStudentListException{
        return getStudentList().chooseStudent();
    }

    public void addStudent(Student student){
        getStudentList().addStudent(student);
    }

    public void bulkImport(String text) {
        String [] lines= text.split("\n");
        StudentList sl = getStudentList();
        for (String line1 : lines) {
            String line = line1.trim();
            if (!line.equals("")) {
                Student s = new Student(line);
                studentList.addStudent(s);

            }
        }

    }
}
