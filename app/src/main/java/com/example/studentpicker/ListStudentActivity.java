package com.example.studentpicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

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
}
