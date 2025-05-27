/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kdeke
 */
public class Usuarios {
    
    private String nombreCargo;
    private String Usuario;
    private String Nombre;
    private String Telefono;
    private String Cargo;
    
    

    public Usuarios(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    @Override
    public String toString() {
        return nombreCargo;
    }

    public static List<Usuarios> obtenerCargos() {
        List<Usuarios> lista = new ArrayList<>();
        lista.add(new Usuarios("Administrador"));
        lista.add(new Usuarios("Agente"));
        lista.add(new Usuarios("Propietario"));
        lista.add(new Usuarios("Cliente"));
        return lista;
    }
    
    
}
