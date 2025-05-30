/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

import static Formularios.Clientes.listaClientes;
import static Formularios.Propiedades.listaCasas;
import java.awt.Graphics;
import java.awt.Image;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kdeke
 */
public class Metodos {
    private static Usuarios cargoSeleccionado;

    public static void setCargo(Usuarios cargo) {
        cargoSeleccionado = cargo;
    }

    public static Usuarios getCargo() {
        return cargoSeleccionado;
    }
    
    public static JPanel crearPanelConFondoMadera() {
    return new JPanel() {
        private Image imagen = new ImageIcon(getClass().getResource("/imagenes/Madera.jpg")).getImage();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    };
}
    //Metodo para pasar a la tabla de propiedades
    
    public static DefaultTableModel generarModeloCasas() {
     
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ID", "Tipo", "Ubicación", "Área", "Precio", "Estado", "Propietario", "Agente"}, 0
        );

        for (Propiedades casa : Propiedades.listaCasas) {
            modelo.addRow(new Object[]{
                casa.getId(),
                casa.getTipo(),
                casa.getUbicacion(),
                casa.getArea(),
                casa.getPrecio(),
                casa.getEstado(),
                casa.getPropietario(),
                casa.getAgente()
            });
        }

        return modelo;
    
    }
//metodo para ver a los clientes en tablas 
public static DefaultTableModel generarTablaClientes() {
     
    DefaultTableModel modelo = new DefaultTableModel(
            
        new Object[]{"ID", "Nombres", "Apellidos", "Correo", "Telefono", "Cedula", "Propiedades"}, 0
    );

    for (Clientes cliente : Clientes.listaClientes) {
        modelo.addRow(new Object[]{
            cliente.getIdCliente(),
            cliente.getNombres(),
            cliente.getApellidos(),
            cliente.getCorreo(),
            cliente.getTelefono(), 
            cliente.getCedula(),
            cliente.getPropiedadAsignada()
        });
    }
    return modelo;
}
//Leila creo metodo de visitas
    public static DefaultTableModel generarVisitas() {
        DefaultTableModel modeloo = new DefaultTableModel(
                new Object[]{"ID Visita", "Fecha", "Agente", "Propiedad ID", "Estado"}, 0
        );
        for (Visitas visitas : Visitas.listaVisitas) {
            modeloo.addRow(new Object[]{
                visitas.getIdVisita(),
                visitas.getFecha(),
                visitas.getAgente(),
                visitas.getPropiedadId(),
                visitas.getEstado()
            });
        }
        return modeloo;

    }
    //Metodo para contratos
    public static DefaultTableModel generarContratos() {
    DefaultTableModel modelo = new DefaultTableModel(
        new Object[]{"ID", "Tipo", "Propiedad", "Cliente", "Agente", "Estado", "Valor", "Inicio", "Fin", "Días Restantes"}, 0
    );

    for (Contratos contrato : Contratos.listaContratos) {
        //Toma el año actual del sistema
        int añoActual = LocalDate.now().getYear();
        //mes de finalizacion del contrato
        String mesFinTexto = contrato.getFin().toLowerCase();
        
        //Se convierte en un numero
        int mesFinNumero = obtenerNumeroMes(mesFinTexto);//Obtener numero mes hace que se vuelva un numero
        long diasRestantes = 0;

        if (mesFinNumero != -1) {
            //Construye un dia exacto
            LocalDate fechaFin = LocalDate.of(añoActual, mesFinNumero, 1).withDayOfMonth(
                LocalDate.of(añoActual, mesFinNumero, 1).lengthOfMonth()
            );
            //calcula cuantos dias faltan
            diasRestantes = java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), fechaFin);
            if (diasRestantes < 0) diasRestantes = 0;
        }

        modelo.addRow(new Object[]{
            contrato.getIdContrato(),
            contrato.getTipoContrato(),
            contrato.getIdPropiedad(),
            contrato.getCliente(),
            contrato.getAgente(),
            contrato.getEstado(),
            contrato.getValor(),
            contrato.getInicio(),
            contrato.getFin(),
            diasRestantes
        });
    }

    return modelo;
}

// Método auxiliar para convertir meses en español a números
public static int obtenerNumeroMes(String mes) {
    switch (mes.toLowerCase()) {
        case "enero": return 1;
        case "febrero": return 2;
        case "marzo": return 3;
        case "abril": return 4;
        case "mayo": return 5;
        case "junio": return 6;
        case "julio": return 7;
        case "agosto": return 8;
        case "septiembre": return 9;
        case "octubre": return 10;
        case "noviembre": return 11;
        case "diciembre": return 12;
        default: return -1;
    }
}
    }
