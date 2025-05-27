/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

import java.util.ArrayList;

/**
 *
 * @author kdeke
 */
public class Propiedades {
     // Atributos de cada casa
    private String id;
    private String tipo;
    private String ubicacion;
    private String area;
    private String precio;
    private String estado;
    private String propietario;
    private String agente;

    // Lista de todas las casas
    public static ArrayList<Propiedades> listaCasas = new ArrayList<>();

    // Constructor
    public Propiedades(String id, String tipo, String ubicacion, String area, String precio,
                String estado, String propietario, String agente) {
        this.id = id;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.area = area;
        this.precio = precio;
        this.estado = estado;
        this.propietario = propietario;
        this.agente = agente;
    }

    // Getters
    public String getId() { return id; }
    public String getTipo() { return tipo; }
    public String getUbicacion() { return ubicacion; }
    public String getArea() { return area; }
    public String getPrecio() { return precio; }
    public String getEstado() { return estado; }
    public String getPropietario() { return propietario; }
    public String getAgente() { return agente; }

    // Método para cargar datos de ejemplo
    public static void cargarCasasEjemplo() {
        listaCasas.add(new Propiedades("23422", "Casa", "Zona A", "80", "50000", "Disponible", "Ana", "Carlos"));
        listaCasas.add(new Propiedades("21345", "Casa", "Aeropuerto", "10", "10000", "Disponible", "Ana", "Jose"));
        listaCasas.add(new Propiedades("02405", "Piña", "Zulia", "8", "20000", "Mantenimiento", "Sebastian", "Jose"));
        listaCasas.add(new Propiedades("02406", "Casa", "La Riviera", "10", "35000", "Disponible", "Andrea", "Carlos"));
        listaCasas.add(new Propiedades("02407", "Apartamento", "Caobos", "6", "28000", "Vendida", "Luis", "Maria"));
        listaCasas.add(new Propiedades("02408", "Finca", "El Pórtico", "20", "50000", "Disponible", "Claudia", "Andrés"));
        listaCasas.add(new Propiedades("02409", "Casa", "Panamericano", "9", "32000", "Arrendada", "Fernando", "Laura"));
        listaCasas.add(new Propiedades("02410", "Apartamento", "Belén", "7", "30000", "Disponible", "Marta", "Julian"));
        listaCasas.add(new Propiedades("02411", "Finca", "Guaramito", "25", "60000", "Mantenimiento", "Pedro", "Lucia"));
        listaCasas.add(new Propiedades("02412", "Casa", "San Luis", "11", "40000", "Vendida", "Rosa", "Camilo"));

    }
}

    

