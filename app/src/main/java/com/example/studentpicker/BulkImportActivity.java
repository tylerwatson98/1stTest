package com.example.studentpicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class BulkImportActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulk_student_import);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.bulk_student_import, menu);
        return true;

    }
}