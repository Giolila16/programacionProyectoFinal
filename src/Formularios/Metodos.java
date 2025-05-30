/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

import static Formularios.Clientes.listaClientes;
import static Formularios.Propiedades.listaCasas;
import java.awt.Graphics;
import java.awt.Image;
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
        listaCasas.clear();
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
     listaClientes.clear();
    DefaultTableModel modelo = new DefaultTableModel(
        new Object[]{"ID", "Nombres", "Apellidos", "Correo", "Telefono", "Cedula", "Propiedades"}, 0
    );

    System.out.println("Cantidad de clientes: " + Clientes.listaClientes.size()); 

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
}