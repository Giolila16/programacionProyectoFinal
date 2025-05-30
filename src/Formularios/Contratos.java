/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

import java.util.ArrayList;

/**
 *LEILA ACOMODO METODO DE CONTRATOS YA QUE ESTABAN SIN SENTIDO
 * @author kdeke
 */
public class Contratos {
  private String idContrato;
    private String tipoContrato; // Ej: Arriendo, Venta
    private String idPropiedad;  // ID de la propiedad (enlace con Propiedades)
    private String cliente;      // Nombre del cliente
    private String agente;       // Nombre del agente
    private String estado;       // Activo, Finalizado, Cancelado
    private int valor;           // Valor del contrato
    private String inicio;       // Mes de inicio
    private String fin;          // Mes de finalización

    public static ArrayList<Contratos> listaContratos = new ArrayList<>();

    public Contratos(String idContrato, String tipoContrato, String idPropiedad, String cliente, String agente,
                    String estado, int valor, String inicio, String fin) {
        this.idContrato = idContrato;
        this.tipoContrato = tipoContrato;
        this.idPropiedad = idPropiedad;
        this.cliente = cliente;
        this.agente = agente;
        this.estado = estado;
        this.valor = valor;
        this.inicio = inicio;
        this.fin = fin;
    }

    // Getters
    public String getIdContrato() { return idContrato; }
    public String getTipoContrato() { return tipoContrato; }
    public String getIdPropiedad() { return idPropiedad; }
    public String getCliente() { return cliente; }
    public String getAgente() { return agente; }
    public String getEstado() { return estado; }
    public int getValor() { return valor; }
    public String getInicio() { return inicio; }
    public String getFin() { return fin; }

    public static void cargarContratosEjemplo() {
        listaContratos.add(new Contratos("C001", "Arriendo", "21345", "José Morales", "Jose", "Activo", 10000, "Enero", "Junio"));
        listaContratos.add(new Contratos("C002", "Venta", "02412", "Camilo Arias", "Camilo", "Finalizado", 40000, "Febrero", "Abril"));
        listaContratos.add(new Contratos("C003", "Arriendo", "02406", "Carlos Ruiz", "Carlos", "Activo", 35000, "Marzo", "Agosto"));
        listaContratos.add(new Contratos("C004", "Local", "02410", "Laura Gómez", "Julian", "Cancelado", 30000, "Enero", "Marzo"));
        listaContratos.add(new Contratos("C005", "Finca", "02408", "Andrés Peña", "Andrés", "Activo", 50000, "Abril", "Octubre"));
        listaContratos.add(new Contratos(" ", " ", " ", " ", " ", " ", 0, " ", " "));
        listaContratos.add(new Contratos(" ", " ", " ", " ", " ", " ", 0, " ", " "));
        listaContratos.add(new Contratos(" ", " ", " ", " ", " ", " ", 0, " ", " "));
        
    }
}
