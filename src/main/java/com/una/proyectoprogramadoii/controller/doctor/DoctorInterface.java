/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.una.proyectoprogramadoii.controller.doctor;

/**
 *
 * @author brimo
 */
public interface DoctorInterface {
    public String store(String data[]);
    public String[] getById(String id);
    public String modify(String data[]);
    public String delete(String id);
    public String[][] getAll();
}
