/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.una.proyectoprogramadoii.model.doctor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author brimo
 */
public class DoctorContainer extends DoctorAdapter{
   private static Map<String,Doctor> container = new HashMap<>() ;
   public DoctorContainer() throws Exception{
       super();
       this.loadFile();
   }
   
   private void loadFile() throws Exception{
       for(Doctor d:this.read()){
           container.put(d.getId(),d);
       }
   }
   
   public boolean exist(String id){
       return container.containsKey(id);
   }
   
   public Doctor find(String id){
     if(!container.containsKey(id)){
         return container.get(id);
     }
     return null;
   }
   
   public boolean add(Doctor dc)throws Exception{
       if(!container.containsKey(dc.getId())){
           container.put(dc.getId(),dc);
           this.write(new ArrayList(container.values()));
           return true;
       }
       return false;
   }
   
   public boolean update(Doctor dc) throws Exception{
       if(container.containsKey(dc.getId())){
           container.put(dc.getId(), dc);
           this.write(new ArrayList(container.values()));
           return true;
       }
       return false;
   }
   
   public boolean delete(String id) throws Exception{
       if(container.containsKey(id)){
           container.remove(id);
           this.write(new ArrayList(container.values()));
           return true;
       }
       return false;
   }

   public List getAll(){
       return new ArrayList<>(container.values());
   }
   }
