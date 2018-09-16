package com.example.studentpicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BulkImportActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bulk_student_import);
        StudentListManager.initManger(this.getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.bulk_student_import, menu);
        return true;

    }

    public void addStudentAction(View v){
        EditText view = findViewById(R.id.bulkStudentText);
        String text = view.getText().toString();
        StudentListController st = new StudentListController();
        st.bulkImport(text);
        view.setText("");
        Toast.makeText(this,"Thanks for the students", Toast.LENGTH_SHORT).show();
    }
}