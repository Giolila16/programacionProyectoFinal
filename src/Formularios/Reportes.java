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
public class Reportes {

    private String año;
    private String idPropiedad;
    private String cliente;
    private String agente;
    private int valorVenta;
    private double comisionAgente;
    private double ingresoNeto;

    public static ArrayList<Reportes> listaReportes = new ArrayList<>();

    public Reportes( String año, String idPropiedad, String cliente, String agente, int valorVenta) {
  
        this.año = año;
        this.idPropiedad = idPropiedad;
        this.cliente = cliente;
        this.agente = agente;
        this.valorVenta = valorVenta;
        this.comisionAgente = valorVenta * 0.03;
        this.ingresoNeto = valorVenta - comisionAgente;
    }

    // Getters
   
    public String getAño() { return año; }
    public String getIdPropiedad() { return idPropiedad; }
    public String getCliente() { return cliente; }
    public String getAgente() { return agente; }
    public int getValorVenta() { return valorVenta; }
    public double getComisionAgente() { return comisionAgente; }
    public double getIngresoNeto() { return ingresoNeto; }

    
    public static void cargarReportesEjemplo() {
        listaReportes.add(new Reportes( "2025", "02403", "Ana", "Maria", 28000));
        listaReportes.add(new Reportes( "2025", "02404", "Ana", "Camilo", 40000));
        listaReportes.add(new Reportes( "2025", "02405", "Sebastian", "Carlos", 35000));
        listaReportes.add(new Reportes( "2025", "21406", "Andrea", "Jose", 10000));
  
    }
}
