/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Clientes {
    
    private String idCliente;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String cedula;
    private String propiedadAsignada; // Casa, Lote, etc.

    public static ArrayList<Clientes> listaClientes = new ArrayList<>();

    public Clientes(String idCliente, String nombres, String apellidos, String correo, String telefono, String cedula, String propiedadAsignada) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
        this.propiedadAsignada = propiedadAsignada;
    }

    public String getIdCliente() { return idCliente; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getCedula() { return cedula; }
    public String getPropiedadAsignada() { return propiedadAsignada; }

    public static void cargarClientesEjemplo() {
        //Leila Agrego el codigo con un condicional para que no se repitan los datos en la tabla
        if (listaClientes.isEmpty()) {
        listaClientes.add(new Clientes("223", "Carlos", "Ramírez", "carlosr@mail.com", "3001112233", "1098765432", "Casa"));
        listaClientes.add(new Clientes("566", "Laura", "Morales", "lauram@mail.com", "3015556677", "1091234567", "Apartamento"));
        listaClientes.add(new Clientes("434", "Camilo", "Gómez", "camilog@mail.com", "3029993344", "1087654321", "Casa"));
        listaClientes.add(new Clientes("869", "Maria", "Fernández", "mariaf@mail.com", "3041239876", "1076543210", "Apartamento"));
        listaClientes.add(new Clientes("464", "Jose", "Martínez", "josem@mail.com", "3051114455", "1091122334", "Casa"));
        listaClientes.add(new Clientes("646", "Ana", "Torres", "anatorres@mail.com", "3009991122", "1094455667", "Finca"));
        listaClientes.add(new Clientes("323", "Lucia", "Rojas", "luciar@mail.com", "3038765432", "1099988776", "Finca"));
        listaClientes.add(new Clientes("643", "Sebastian", "Mejía", "sebastianm@mail.com", "3007778899", "1088997766", "Casa"));
        listaClientes.add(new Clientes("423", "Andrea", "Vargas", "andreav@mail.com", "3023332211", "1096655443", "Casa"));
        listaClientes.add(new Clientes("453", "Julian", "Hernández", "julianh@mail.com", "3042223344", "1077889922", "Apartamento"));
    }}
}

