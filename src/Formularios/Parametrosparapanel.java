/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

import javax.swing.table.DefaultTableModel;

/**
 *Creado para definir modelo editable por tablas
 * 
 * @author USUARIO
 */
public class Parametrosparapanel {
public static class ModeloTablaEditable extends DefaultTableModel {
    private boolean editable = false;

    public ModeloTablaEditable(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isEditable() {
        return editable;
    }
}}

