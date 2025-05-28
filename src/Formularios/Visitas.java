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
    private String fecha; // Lunes, Martes, etc.
    private String agente;
    private String propiedadId;
    private String estado; // Programada, Cancelada, Reprogramar

    public static ArrayList<Visitas> listaVisitas = new ArrayList<>();

    public Visitas(String idVisita, String fecha, String agente, String propiedadId, String estado) {
        this.idVisita = idVisita;
        this.fecha = fecha;
        this.agente = agente;
        this.propiedadId = propiedadId;
        this.estado = estado;
    }

    public String getIdVisita() { return idVisita; }
    public String getFecha() { return fecha; }
    public String getAgente() { return agente; }
    public String getPropiedadId() { return propiedadId; }
    public String getEstado() { return estado; }

    public static void cargarVisitasEjemplo() {
        listaVisitas.add(new Visitas("01", "Lunes", "Carlos", "23422", "Programada"));
        listaVisitas.add(new Visitas("02", "Martes", "Jose", "21345", "Cancelada"));
        listaVisitas.add(new Visitas("03", "Miércoles", "Sebastian", "02405", "Reprogramar"));
        listaVisitas.add(new Visitas("04", "Jueves", "Andrea", "02406", "Programada"));
        listaVisitas.add(new Visitas("05", "Viernes", "Pedro", "02411", "Programada"));
    }
}
