package com.example.studentpicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudentListManager{
    private static final String prefFile= "StudentList";
    private static final String slkey = "studentList";
    private final Context context;


    @SuppressLint("StaticFieldLeak")
    static private StudentListManager studentListManager=null;


    public static void initManger(Context context){
        if(studentListManager==null){
            if(context==null){
                throw new RuntimeException("Missing context for StudentListManager");
            }
            studentListManager=new StudentListManager(context);
        }
    }

    public static StudentListManager getManager(){
        if(studentListManager==null){
            throw new RuntimeException("Did not initialize manager");
            }
        return studentListManager;
    }


    private StudentListManager(Context context){
        this.context= context;
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

    private static StudentList studentListFromString(String studentListData) throws ClassNotFoundException, IOException{
        ByteArrayInputStream bi = new ByteArrayInputStream(Base64.decode(studentListData,Base64.DEFAULT));
        ObjectInputStream oi =new ObjectInputStream(bi);
        return (StudentList)oi.readObject();
    }

    private static String studentListToString(StudentList sl) throws IOException{
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
        editor.apply();
    }



        }