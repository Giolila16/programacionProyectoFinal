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
     private String id;
    private String tipo;
    private String ubicacion;
    private double area;
    private double valor;
    private String estado;
    private String descripcion;
    private String fotos; // ruta a la imagen
    private boolean disponible;
    private String propietario;

    public Propiedades(String id, String tipo, String ubicacion, double area, double valor, String estado,
                     String descripcion, String fotos, boolean disponible, String propietario) {
        this.id = id;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.area = area;
        this.valor = valor;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.disponible = disponible;
        this.propietario = propietario;
    }

    // Getters (puedes generar también setters si deseas editar)
    public String getId() { return id; }
    public String getTipo() { return tipo; }
    public String getUbicacion() { return ubicacion; }
    public double getArea() { return area; }
    public double getValor() { return valor; }
    public String getEstado() { return estado; }
    public String getDescripcion() { return descripcion; }
    public String getFotos() { return fotos; }
    public boolean isDisponible() { return disponible; }
    public String getPropietario() { return propietario; }
    
    private ArrayList<Propiedades> listaPropiedades = new ArrayList<>();

private void cargarPropiedades() {
    listaPropiedades.add(new Propiedades("P001", "Casa", "Av. 1 #10-20", 120.5, 150000000, "Disponible",
            "Casa familiar de 2 pisos", "/imagenes/casa1.jpg", true, "Luis Pérez"));
    
    listaPropiedades.add(new Propiedades("P002", "Apartamento", "Cra. 15 #45-60", 80.0, 100000000, "Reservado",
            "Apartamento moderno con balcón", "/imagenes/apto1.jpg", false, "Marta Gómez"));
    
    listaPropiedades.add(new Propiedades("P003", "Local", "Zona Centro", 50.0, 75000000, "Arrendado",
            "Local comercial remodelado", "/imagenes/local1.jpg", false, "Carlos Ruiz"));

    // Agrega 7 más con datos variados...
}
}
    

