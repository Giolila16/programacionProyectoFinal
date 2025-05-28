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
public class Pagos {
    private String idPago;
    private String tipoPago;
    private String propiedadId;
    private String cliente;
    private int monto;
    private String estado;
    private String metodoPago;
    private String agente;

    public static ArrayList<Pagos> listaPagos = new ArrayList<>();

    public Pagos(String idPago, String tipoPago, String propiedadId, String cliente, int monto,
                 String estado, String metodoPago, String agente) {
        this.idPago = idPago;
        this.tipoPago = tipoPago;
        this.propiedadId = propiedadId;
        this.cliente = cliente;
        this.monto = monto;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.agente = agente;
    }

    public String getIdPago() { return idPago; }
    public String getTipoPago() { return tipoPago; }
    public String getPropiedadId() { return propiedadId; }
    public String getCliente() { return cliente; }
    public int getMonto() { return monto; }
    public String getEstado() { return estado; }
    public String getMetodoPago() { return metodoPago; }
    public String getAgente() { return agente; }

    public static void cargarPagosEjemplo() {
        listaPagos.add(new Pagos("10001", "Arriendo", "23422", "Carlos", 40000, "Pagado", "Efectivo", "Ana"));
        listaPagos.add(new Pagos("10002", "Arriendo", "21345", "Jose", 30000, "Pendiente", "Tarjeta", "Ana"));
        listaPagos.add(new Pagos("10003", "Local", "02405", "Jose", 20000, "Pagado", "Efectivo", "Sebastian"));
        listaPagos.add(new Pagos("10004", "Finca", "02408", "Andrés", 50000, "Pendiente", "Tarjeta", "Claudia"));
        listaPagos.add(new Pagos("10005", "Casa", "02409", "Laura", 32000, "Pagado", "Efectivo", "Fernando"));
        listaPagos.add(new Pagos("10006", "Apartamento", "02410", "Julian", 30000, "Pendiente", "Tarjeta", "Marta"));
        listaPagos.add(new Pagos("10007", "Finca", "02411", "Lucia", 60000, "Pagado", "Tarjeta", "Pedro"));
        listaPagos.add(new Pagos("10008", "Casa", "02412", "Camilo", 40000, "Pagado", "Efectivo", "Rosa"));
    }
}


