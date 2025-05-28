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
public class Contratos {
    private String idContrato;
    private String tipoContrato; // Arriendo, Local, etc.
    private String cliente; // nombre
    private String agente;
    private int valorContrato;
    private String inicio; // Mes
    private String fin; // Mes

    public static ArrayList<Contratos> listaContratos = new ArrayList<>();

    public Contratos(String idContrato, String tipoContrato, String cliente, String agente,
                    int valorContrato, String inicio, String fin) {
        this.idContrato = idContrato;
        this.tipoContrato = tipoContrato;
        this.cliente = cliente;
        this.agente = agente;
        this.valorContrato = valorContrato;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getIdContrato() { return idContrato; }
    public String getTipoContrato() { return tipoContrato; }
    public String getCliente() { return cliente; }
    public String getAgente() { return agente; }
    public int getValorContrato() { return valorContrato; }
    public String getInicio() { return inicio; }
    public String getFin() { return fin; }

    public static void cargarContratosEjemplo() {
        listaContratos.add(new Contratos("C001", "Arriendo", "Carlos", "Ana", 50000, "Enero", "Diciembre"));
        listaContratos.add(new Contratos("C002", "Local", "Jose", "Ana", 30000, "Febrero", "Noviembre"));
        listaContratos.add(new Contratos("C003", "Finca", "Lucia", "Pedro", 60000, "Marzo", "Diciembre"));
        listaContratos.add(new Contratos("C004", "Casa", "Camilo", "Rosa", 40000, "Abril", "Octubre"));
        listaContratos.add(new Contratos("C005", "Apartamento", "Julian", "Marta", 30000, "Mayo", "Diciembre"));
    }
}
