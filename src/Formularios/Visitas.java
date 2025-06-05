/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author kdeke
 */
public class Visitas {

    private String idVisita;
    private String fecha;
    private String diaSemana;
    private String agenteId;   // Guarda el ID del agente (ej. "ag1")
    private String clienteId;  // Guarda el ID del cliente (ej. "cli1")
    private String propiedadId;
    private String estado;

    public static ArrayList<Visitas> listaVisitas = new ArrayList<>();

    public Visitas(String idVisita, String fecha, String diaSemana, String agenteId,
                   String clienteId, String propiedadId, String estado) {
        this.idVisita   = idVisita;
        this.fecha      = fecha;
        this.diaSemana  = diaSemana;
        this.agenteId   = agenteId;
        this.clienteId  = clienteId;
        this.propiedadId = propiedadId;
        this.estado     = estado;
    }

    public String getIdVisita()   { return idVisita; }
    public String getFecha()      { return fecha; }
    public String getDiaSemana()  { return diaSemana; }
    public String getAgenteId()   { return agenteId; }
    public String getClienteId()  { return clienteId; }
    public String getPropiedadId(){ return propiedadId; }
    public String getEstado()     { return estado; }

    /** 
     * Carga datos de ejemplo usando los IDs reales de usuario 
     * (asegúrate de que esos IDs existan en Agente, ClienteUsuario, etc.). 
     */
    public static void cargarVisitasEjemplo() {
        if (listaVisitas.isEmpty()) {
            listaVisitas.add(new Visitas(
                "V1", "01/06/2025", "Lunes",
                "ag1",    // ID de agente
                "cli1",   // ID de cliente
                "23422",
                "Programada"
            ));
            listaVisitas.add(new Visitas(
                "V2", "02/06/2025", "Martes",
                "ag5",    // ID de agente
                "cli2",   // ID de cliente
                "21345",
                "Cancelada"
            ));
            listaVisitas.add(new Visitas(
                "V3", "06/06/2025", "Martes",
                "ag6",    // ID de agente
                "cli6",   // ID de cliente
                "02410",
                "Programada"
            ));
        }
    }

    /**
     * Agrega una nueva visita a la lista, con estado "Programada".
     */
    public static void agregarVisita(String idVisita, String fecha, String diaSemana,
                                     String agenteId, String clienteId, String propiedadId) {
        listaVisitas.add(new Visitas(idVisita, fecha, diaSemana, agenteId, clienteId, propiedadId, "Programada"));
    }

    /**
     * Filtra visitas para un usuario dado (según cargo y usuarioId).
     * - Administrador ve TODAS las visitas.
     * - Agente ve solo las visitas donde él es agenteId.
     * - Cliente ve solo las visitas donde él es clienteId.
     * - Propietario no ve ninguna (por ahora).
     */
    public static ArrayList<Visitas> getVisitasPara(String usuarioId, String cargo) {
        if (cargo.equalsIgnoreCase("Administrador")) {
            return listaVisitas;
        } 
        else if (cargo.equalsIgnoreCase("Agente")) {
            // Agente debe ver las visitas donde v.getAgenteId().equals(usuarioId)
            return (ArrayList<Visitas>) listaVisitas.stream()
                .filter(v -> v.getAgenteId().equals(usuarioId))
                .collect(Collectors.toList());
        } 
        else if (cargo.equalsIgnoreCase("Cliente")) {
            // Cliente ve las visitas donde v.getClienteId().equals(usuarioId)
            return (ArrayList<Visitas>) listaVisitas.stream()
                .filter(v -> v.getClienteId().equals(usuarioId))
                .collect(Collectors.toList());
        }
        // Propietario u otros roles no ven visitas
        return new ArrayList<>();
    }
}
