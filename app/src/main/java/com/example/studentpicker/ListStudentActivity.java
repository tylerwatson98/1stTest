package com.example.studentpicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class ListStudentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_students);
        ListView listView = findViewById(R.id.studentListView);
        Collection<Student> students=  StudentListController.getStudentList().getStudents();
        final ArrayList<Student> list = new ArrayList<>(students);
        final ArrayAdapter <Student> studentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(studentAdapter);

        StudentListController.getStudentList().addListener(new Listener() {
            @Override
            public void update() {
                list.clear();
                Collection<Student> students=  StudentListController.getStudentList().getStudents();
                list.addAll(students);
                studentAdapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListStudentActivity.this,"delete "+list.get(position).toString(),Toast.LENGTH_SHORT).show();
                Student student =list.get(position);
                StudentListController.getStudentList().removeStudent(student);
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_students, menu);
        return true;
    }


    public void addStudentAction(View v) {
        Toast.makeText(this,"Adding student", Toast.LENGTH_SHORT).show();
        StudentListController st = new StudentListController();
        EditText textView= findViewById(R.id.addStudentNameText);
        st.addStudent(new Student(textView.getText().toString()));

    }
}
