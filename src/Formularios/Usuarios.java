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
    private String usuario;       // ID de usuario (ej. "ag1", "cli1", "prop2", "admin")
    private String contraseña;
    private String nombres;       // Nombre propio (ej. "Ana")
    private String apellidos;     // Apellidos (ej. "Gómez")
    private String cargo;         // Rol en el sistema ("Agente", "Cliente", "Propietario", "Administrador")

    public Usuarios(String usuario, String contraseña, String nombres, String apellidos, String cargo) {
        this.usuario    = usuario;
        this.contraseña = contraseña;
        this.nombres    = nombres;
        this.apellidos  = apellidos;
        this.cargo      = cargo;
    }

    public String getUsuario()   { return usuario; }
    public String getContraseña(){ return contraseña; }
    public String getNombres()   { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getCargo()     { return cargo; }

    @Override
    public String toString() {
        // Si en algún JComboBox o logs quieres mostrar "Ana Gómez (Agente)" por ejemplo:
        return nombres + " " + apellidos + " (" + cargo + ")";
    }

    /**
     * Lista de cargos para llenar, por ejemplo, un JComboBox de selección de perfil.
     * NO confundir con listas de usuarios reales.
     */
   public static List<String> listarCargos() {
    List<String> roles = new ArrayList<>();
    roles.add("Administrador");
    roles.add("Agente");
    roles.add("Propietario");
    roles.add("Cliente");
    return roles;
}
}

/** Subclase Agente */
class Agente extends Usuarios {
    public static ArrayList<Agente> listaAgentes = new ArrayList<>();

    public Agente(String usuario, String contraseña, String nombres, String apellidos) {
        super(usuario, contraseña, nombres, apellidos, "Agente");
    }

    /** Carga datos de ejemplo en listaAgentes */
    public static void cargarAgentesEjemplo() {
        if (listaAgentes.isEmpty()) {
            listaAgentes.add(new Agente("ag1", "123", "Ana", "Gomez"));
            listaAgentes.add(new Agente("ag2", "123", "Carlos", "Perez"));
            listaAgentes.add(new Agente("ag3", "123", "Jose", "Luna"));
            listaAgentes.add(new Agente("ag4", "123", "Andrea", "Mora"));
            listaAgentes.add(new Agente("ag5", "123", "Fernando", "Ruiz"));
            listaAgentes.add(new Agente("ag6", "123", "Pedro", "Salas"));
        }
    }
}

/** Subclase Propietario */
class Propietario extends Usuarios {
    public static ArrayList<Propietario> listaPropietarios = new ArrayList<>();

    public Propietario(String usuario, String contraseña, String nombres, String apellidos) {
        super(usuario, contraseña, nombres, apellidos, "Propietario");
    }

    /** Carga datos de ejemplo en listaPropietarios */
    public static void cargarPropietariosEjemplo() {
        if (listaPropietarios.isEmpty()) {
            listaPropietarios.add(new Propietario("prop1", "123", "Ana", "Vargas"));
            listaPropietarios.add(new Propietario("prop2", "123", "Sebastian", "Moreno"));
            listaPropietarios.add(new Propietario("prop3", "123", "Luis", "Torres"));
            listaPropietarios.add(new Propietario("prop4", "123", "Claudia", "Rojas"));
            listaPropietarios.add(new Propietario("prop5", "123", "Fernando", "Diaz"));
            listaPropietarios.add(new Propietario("prop6", "123", "Pedro", "Linares"));
        }
    }
}

/** Subclase ClienteUsuario */
class ClienteUsuario extends Usuarios {
    public static ArrayList<ClienteUsuario> listaUsuariosCliente = new ArrayList<>();

    public ClienteUsuario(String usuario, String contraseña, String nombres, String apellidos) {
        super(usuario, contraseña, nombres, apellidos, "Cliente");
    }

    /** Carga datos de ejemplo en listaUsuariosCliente */
    public static void cargarClientesUsuarioEjemplo() {
        if (listaUsuariosCliente.isEmpty()) {
            listaUsuariosCliente.add(new ClienteUsuario("cli1",  "123", "Carlos",   "López"));
            listaUsuariosCliente.add(new ClienteUsuario("cli2",  "123", "Jose",     "Martinez"));
            listaUsuariosCliente.add(new ClienteUsuario("cli3",  "123", "Laura",    "Torres"));
            listaUsuariosCliente.add(new ClienteUsuario("cli4",  "123", "Lucia",    "Ramos"));
            listaUsuariosCliente.add(new ClienteUsuario("cli5",  "123", "Camilo",   "Zapata"));
            listaUsuariosCliente.add(new ClienteUsuario("cli6",  "123", "Julian",   "Mejia"));
            listaUsuariosCliente.add(new ClienteUsuario("cli7",  "123", "Andrés",   "Gómez"));
            listaUsuariosCliente.add(new ClienteUsuario("cli8",  "123", "Maria",    "Salazar"));
            listaUsuariosCliente.add(new ClienteUsuario("cli9",  "123", "Sebastian","Ruiz"));
            listaUsuariosCliente.add(new ClienteUsuario("cli10", "123", "Ana",      "Moreno"));
        }
    }
}

/** Subclase Administrador (gio) */
class gio extends Usuarios {
    public static gio perrito;  // Objeto único para el administrador

    public gio(String usuario, String contraseña, String nombres, String apellidos) {
        super(usuario, contraseña, nombres, apellidos, "Administrador");
    }

    /** Carga el administrador de ejemplo */
    public static void cargarAdministradorEjemplo() {
        // Solo un administrador “estándar”
        if (perrito == null) {
            perrito = new gio("admin", "admin123", "Kevin", "Castro");
        }
    }
}
