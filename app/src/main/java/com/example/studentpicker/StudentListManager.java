package com.example.studentpicker;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudentListManager{
    static final String prefFile= "StudentList";
    static final String slkey = "studentList";
    Context context;

    public StudentListManager(){
        this.context=context;
    }

    public StudentList loadStudentList() throws ClassNotFoundException, IOException{
        SharedPreferences settings= context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        String studentListData = settings.getString(slkey,"");
        if(studentListData.equals("")){
            return new StudentList();
        }
        else{
            return studentListFromString(studentListData);
        }
    }

    static public StudentList studentListFromString(String studentListData) throws ClassNotFoundException, IOException{
        ByteArrayInputStream bi = new ByteArrayInputStream(Base64.decode(studentListData,Base64.DEFAULT));
        ObjectInputStream oi =new ObjectInputStream(bi);
        return (StudentList)oi.readObject();
    }

    static public String studentListToString(StudentList sl) throws IOException{
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo =new ObjectOutputStream(bo);
        oo.writeObject(sl);
        oo.close();
        byte bytes[] = bo.toByteArray();
        return Base64.encodeToString(bytes,Base64.DEFAULT);
    }

    public void saveStudentList(StudentList sl) throws IOException {
        SharedPreferences settings= context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= settings.edit();
        editor.putString(slkey,studentListToString(sl));
        editor.commit();
    }



        }