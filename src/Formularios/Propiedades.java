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
    // Atributos generales
    private String id;
    private String tipo;
    private String ubicacion;
    private String area;
    private String precio;
    private String estado;
    private String propietario;
    private String agente;
    private String rutaImagen;

    // Nuevos atributos físicos
    private int habitaciones;
    private int pisos;
    private int cocinas;
    private int banios;
    private String otros;

    // Lista de todas las casas
    public static ArrayList<Propiedades> listaCasas = new ArrayList<>();

    // Constructor COMPLETO
    public Propiedades(String id, String tipo, String ubicacion, String area, String precio,
                       String estado, String propietario, String agente, String ruta,
                       int habitaciones, int pisos, int cocinas, int banios, String otros) {
        this.id = id;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.area = area;
        this.precio = precio;
        this.estado = estado;
        this.propietario = propietario;
        this.agente = agente;
        this.rutaImagen = ruta;
        this.habitaciones = habitaciones;
        this.pisos = pisos;
        this.cocinas = cocinas;
        this.banios = banios;
        this.otros = otros;
    }

    // Constructor sin imagen ni detalles (para compatibilidad si necesitas)
    public Propiedades(String id, String tipo, String ubicacion, String area, String precio,
                       String estado, String propietario, String agente) {
        this(id, tipo, ubicacion, area, precio, estado, propietario, agente, "", 0, 0, 0, 0, "");
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
    public String getRuta() { return rutaImagen; }

    public int getHabitaciones() { return habitaciones; }
    public int getPisos() { return pisos; }
    public int getCocinas() { return cocinas; }
    public int getBanios() { return banios; }
    public String getOtros() { return otros; }

    // Carga de ejemplos
    public static void cargarCasasEjemplo() {
        if (listaCasas.isEmpty()) {
            listaCasas.add(new Propiedades("23422", "Casa", "Zona A", "80", "50000", "Disponible", "Ana", "Carlos", "/imagenes/23422.jpg", 3, 2, 1, 2, "patio amplio"));
            listaCasas.add(new Propiedades("21345", "Casa", "Aeropuerto", "10", "10000", "Disponible", "Ana", "Jose", "/imagenes/21345.jpg", 2, 1, 1, 1, "Zona de juegos"));
            listaCasas.add(new Propiedades("02405", "Casa", "Zulia", "8", "20000", "Mantenimiento", "Sebastian", "Jose", "/imagenes/02405.jpg", 2, 1, 1, 1, "Taller de trabajo"));
            listaCasas.add(new Propiedades("02406", "Casa", "La Riviera", "10", "35000", "Disponible", "Andrea", "Carlos", "/imagenes/02405.jpg", 3, 2, 1, 2, "terraza"));
            listaCasas.add(new Propiedades("02407", "Apartamento", "Caobos", "6", "28000", "Vendida", "Luis", "Maria", "/imagenes/02407.jpg", 1, 1, 1, 1, "Sala de cine"));
            listaCasas.add(new Propiedades("02408", "Local", "El Pórtico", "20", "50000", "Disponible", "Claudia", "Andrés", "/imagenes/02408.jpg", 0, 1, 0, 1, "Garaje"));
            listaCasas.add(new Propiedades("02409", "Casa", "Panamericano", "9", "32000", "Arrendada", "Fernando", "Laura", "/imagenes/02409.jpg", 2, 1, 1, 1, "jacuzzi"));
            listaCasas.add(new Propiedades("02410", "Apartamento", "Belén", "7", "30000", "Disponible", "Marta", "Julian", "/imagenes/02410.jpg", 2, 1, 1, 1, "Muebleria interna"));
            listaCasas.add(new Propiedades("02411", "Finca", "Guaramito", "25", "60000", "Mantenimiento", "Pedro", "Lucia", "/imagenes/02411.jpg", 4, 1, 1, 1, "jardín con árboles"));
            listaCasas.add(new Propiedades("02412", "Casa", "San Luis", "11", "40000", "Vendida", "Rosa", "Camilo", "/imagenes/02412.jpg", 3, 2, 1, 2, "garaje cerrado"));
        }
    }
public String getDescripcion() {
return 
   " La Propiedad con ID: " + id + "\n"
    + " es de Tipo: " + tipo + "\n"
    + " Ubicada en: " + ubicacion + "\n"
    + " con un área de: " + area + " m²\n"
    + " cuenta con:" + "\n"
    + habitaciones + " Habitaciones: "  + "\n"
    + pisos + " Pisos: " + "\n"
    + cocinas + " Cocinas: "  + "\n"
    + banios + " Baños: "  +"\n"
    +  " Y " + otros + " Incluido";
}

} 

