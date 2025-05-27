/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

/**
 *
 * @author kdeke
 */
public class Metodos {
    private static Usuarios cargoSeleccionado;

    public static void setCargo(Usuarios cargo) {
        cargoSeleccionado = cargo;
    }

    public static Usuarios getCargo() {
        return cargoSeleccionado;
    }   
}
