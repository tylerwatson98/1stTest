package com.example.studentpicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ListStudentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_students);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_students, menu);
        return true;
    }


    public void addStudentAction(View v) {
        Toast.makeText(this,"Adding student", Toast.LENGTH_SHORT).show();
        StudentListController st = new StudentListController();
        EditText textView= (EditText) findViewById(R.id.addStudentNameText);
        st.addStudent(new Student(textView.getText().toString()));

    }
}
