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
        lista.add(new Usuarios("--Seleccione Cargo--"));
        lista.add(new Usuarios("Administrador"));
        lista.add(new Usuarios("Agente"));
        lista.add(new Usuarios("Propietario"));
        lista.add(new Usuarios("Cliente"));
        return lista;
    }
    
     private String usuario;
    private String contraseña;
    private String nombres;
    private String apellidos;
    private String cargo;

    public Usuarios(String usuario, String contraseña, String nombres, String apellidos, String cargo) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
    }

    public String getUsuario() { return usuario; }
    public String getContraseña() { return contraseña; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getCargo() { return cargo; }
}

class Agente extends Usuarios {
    public static ArrayList<Agente> listaAgentes = new ArrayList<>();
    public Agente(String usuario, String contraseña, String nombres, String apellidos) {
        super(usuario, contraseña, nombres, apellidos, "Agente");
    }

    public static void cargarAgentesEjemplo() {
        listaAgentes.add(new Agente("ag1", "123", "Ana", "Gomez"));
        listaAgentes.add(new Agente("ag2", "123", "Carlos", "Perez"));
        listaAgentes.add(new Agente("ag3", "123", "Jose", "Luna"));
        listaAgentes.add(new Agente("ag4", "123", "Andrea", "Mora"));
        listaAgentes.add(new Agente("ag5", "123", "Fernando", "Ruiz"));
        listaAgentes.add(new Agente("ag6", "123", "Pedro", "Salas"));
    }
}

class Propietario extends Usuarios {
    public static ArrayList<Propietario> listaPropietarios = new ArrayList<>();
    public Propietario(String usuario, String contraseña, String nombres, String apellidos) {
        super(usuario, contraseña, nombres, apellidos, "Propietario");
    }

    public static void cargarPropietariosEjemplo() {
        listaPropietarios.add(new Propietario("prop1", "123", "Ana", "Vargas"));
        listaPropietarios.add(new Propietario("prop2", "123", "Sebastian", "Moreno"));
        listaPropietarios.add(new Propietario("prop3", "123", "Luis", "Torres"));
        listaPropietarios.add(new Propietario("prop4", "123", "Claudia", "Rojas"));
        listaPropietarios.add(new Propietario("prop5", "123", "Fernando", "Diaz"));
        listaPropietarios.add(new Propietario("prop6", "123", "Pedro", "Linares"));
    }
}

class ClienteUsuario extends Usuarios {
    public static ArrayList<ClienteUsuario> listaUsuariosCliente = new ArrayList<>();
    public ClienteUsuario(String usuario, String contraseña, String nombres, String apellidos) {
        super(usuario, contraseña, nombres, apellidos, "Cliente");
    }

    public static void cargarClientesUsuarioEjemplo() {
        listaUsuariosCliente.add(new ClienteUsuario("cli1", "123", "Carlos", "López"));
        listaUsuariosCliente.add(new ClienteUsuario("cli2", "123", "Jose", "Martinez"));
        listaUsuariosCliente.add(new ClienteUsuario("cli3", "123", "Laura", "Torres"));
        listaUsuariosCliente.add(new ClienteUsuario("cli4", "123", "Lucia", "Ramos"));
        listaUsuariosCliente.add(new ClienteUsuario("cli5", "123", "Camilo", "Zapata"));
        listaUsuariosCliente.add(new ClienteUsuario("cli6", "123", "Julian", "Mejia"));
        listaUsuariosCliente.add(new ClienteUsuario("cli7", "123", "Andrés", "Gómez"));
        listaUsuariosCliente.add(new ClienteUsuario("cli8", "123", "Maria", "Salazar"));
        listaUsuariosCliente.add(new ClienteUsuario("cli9", "123", "Sebastian", "Ruiz"));
        listaUsuariosCliente.add(new ClienteUsuario("cli10", "123", "Ana", "Moreno"));
    }
}

class gio extends Usuarios {
    public static gio perrito;
    public gio(String usuario, String contraseña, String nombres, String apellidos) {
        super(usuario, contraseña, nombres, apellidos, "Administrador");
    }

    public static void cargarAdministradorEjemplo() {
        perrito = new gio("admin", "admin123", "Sofia", "Castro");
    }
}
