/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.una.proyectoprogramadoii.model.doctor;

import com.una.proyectoprogramadoii.model.patient.Patient;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author brimo
 */
public class DoctorAdapter {
 private final String FILE_NAME = "doctors.txt";

    protected void write(ArrayList<Doctor> list)throws Exception{
        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            for(int i=0;i<list.size();i++){
                out.writeObject(list.get(i));
            }
            out.close();
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Error");
        }
    }

    protected ArrayList<Doctor> read() throws Exception{
        ObjectInputStream in;
        ArrayList<Doctor> list = new ArrayList<>();
        try{
            in =new ObjectInputStream(
                    new FileInputStream(FILE_NAME));
            if(in!=null){
                Doctor doc=(Doctor)in.readObject();
                while(doc!=null){
                    list.add(doc);
                    doc=(Doctor)in.readObject();
                }
            }
            in.close();
        }catch(IOException|ClassNotFoundException e){
            e.printStackTrace();
            if(!(e instanceof EOFException)){
                throw new Exception(e.getMessage());
            }
        }
        return list;
    }      
}
