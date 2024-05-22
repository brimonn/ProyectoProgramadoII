/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.una.proyectoprogramadoii.model.patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author brimo
 */
public class PatientContainer extends PatientAdapter {
    private static Map<String, Patient> pat = new HashMap<>();
    
    public PatientContainer() throws Exception{
        super();
        this.loidFile();
    }

    private void loidFile() throws Exception {
         for(Patient s: this.read()){
            pat.put(s.getId(), s);
        }

    }

    public boolean exist(String id) {
        return pat.containsKey(id);
    }

    public Patient find(String id) {
        if (pat.containsKey(id)) {
            return pat.get(id);
        }
        return null;
    }

    public boolean add(Patient patient) throws Exception {
        if (!pat.containsKey(patient.getId())) {
            pat.put(patient.getId(), patient); // se agrega al container
            this.write(new ArrayList(pat.values())); //
            return true;
        }
        return false;
    }  
    
     public boolean update(Patient patient) throws Exception{  
         if(pat.containsKey(patient.getId())){
            pat.put(patient.getId(), patient); 
            this.write(new ArrayList(pat.values()));
            return true;
        }
            return false;
        
        
      }
    
    
    public boolean delete (String id) throws Exception{
          if(pat.containsKey(id)){
            pat.remove(id);
            this.write(new ArrayList(pat.values()));
            return true;
        }
        else{
            return false;
        }
    
    }
    
}
