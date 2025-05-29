/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

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
}
