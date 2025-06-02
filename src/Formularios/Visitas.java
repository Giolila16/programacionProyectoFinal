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
public class Visitas {
 

    private String idVisita;
    private String fecha; // Formato: "DD/MM/AAAA" (mejor para ordenamiento)
    private String diaSemana; // "Lunes", "Martes", etc.
    private String agente;
    private String cliente; // Nuevo: para identificar quién agenda
    private String propiedadId;
    private String estado; // "Programada", "Cancelada", "Reprogramada"

    public static ArrayList<Visitas> listaVisitas = new ArrayList<>();

    // Constructor actualizado
    public Visitas(String idVisita, String fecha, String diaSemana, String agente, 
                  String cliente, String propiedadId, String estado) {
        this.idVisita = idVisita;
        this.fecha = fecha;
        this.diaSemana = diaSemana;
        this.agente = agente;
        this.cliente = cliente;
        this.propiedadId = propiedadId;
        this.estado = estado;
    }

    // Getters
    public String getIdVisita() { return idVisita; }
    public String getFecha() { return fecha; }
    public String getDiaSemana() { return diaSemana; }
    public String getAgente() { return agente; }
    public String getCliente() { return cliente; }
    public String getPropiedadId() { return propiedadId; }
    public String getEstado() { return estado; }
    
     public static void cargarVisitasEjemplo() {
        if (listaVisitas.isEmpty()) {
            listaVisitas.add(new Visitas("V1", "01/06/2025", "Lunes", "Ana", "Carlos", "23422", "Programada"));
            listaVisitas.add(new Visitas("V2", "02/06/2025", "Martes", "Fernando", "Jose", "21345", "Cancelada"));
            listaVisitas.add(new Visitas("V3", "06/06/2025", "Martes", "Pedro", "Julian", "02410", "Programada"));
        }} 
public static void agregarVisita(String idVisita, String fecha, String diaSemana, 
                                   String agente, String cliente, String propiedadId) {
        listaVisitas.add(new Visitas(
            idVisita, 
            fecha, 
            diaSemana, 
            agente, 
            cliente, 
            propiedadId, 
            "Programada" // Estado inicial
        ));
        
}
     
}
