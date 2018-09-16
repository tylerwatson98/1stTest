/*
Student Picker: Randomly pick students to answer questions

Copyright (C)
 */



package com.example.studentpicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void editStudents(MenuItem menu){
        Toast.makeText(this,"Edit students", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, ListStudentActivity.class);
        startActivity(intent);
    }

    public void bulkImport (MenuItem menu){
        Toast.makeText(this,"Bulk Import", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, BulkImportActivity.class);
        startActivity(intent);
    }

    public void chooseAStudent(View v) {
        Toast.makeText(this,"choose a student", Toast.LENGTH_SHORT).show();
        StudentListController st = new StudentListController();
        try {
            Student s = st.chooseStudent();
            TextView view = (TextView) findViewById(R.id.chosenStudentTextView);
            view.setText(s.getName());
        } catch (EmptyStudentListException e) {
            Toast.makeText(this,"There are no students!", Toast.LENGTH_SHORT).show();
        }

    }
}
