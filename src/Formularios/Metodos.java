/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;

import static Formularios.Clientes.listaClientes;
import static Formularios.Propiedades.listaCasas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author kdeke
 */
public class Metodos {
    
    
    public static void configurarFondoCompleto(JFrame frame, JPanel panelPrincipal, String rutaImagen) {
    try {
        ImageIcon icon = new ImageIcon(Metodos.class.getResource(rutaImagen));
        if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            throw new RuntimeException("No se pudo cargar la imagen: " + rutaImagen);
        }

        JPanel fondo = new JPanel(new BorderLayout()) {
            private Image img = icon.getImage();
            
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        panelPrincipal.setOpaque(false);
        fondo.add(panelPrincipal, BorderLayout.CENTER);
        frame.setContentPane(fondo);
        frame.revalidate();
        
    } catch (Exception e) {
        System.err.println("Error al configurar fondo: " + e.getMessage());
        e.printStackTrace();
    }
}
    
     public static String obtenerDiaSemana(String fecha) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formato.parse(fecha);
            
            SimpleDateFormat formatoDia = new SimpleDateFormat("EEEE", new java.util.Locale("es"));
            return formatoDia.format(date);
        } catch (Exception e) {
            return "Fecha inválida";
        }
    }
   private static Usuarios cargo;

public static void setCargo(Usuarios u) {
    cargo = u;
}

public static Usuarios getCargo() {
    return cargo;
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
     
    DefaultTableModel modeloC = new DefaultTableModel(
            
        new Object[]{"ID", "Nombres", "Apellidos", "Correo", "Telefono", "Cedula", "Propiedades"}, 0
    );

    for (Clientes cliente : Clientes.listaClientes) {
        modeloC.addRow(new Object[]{
            cliente.getIdCliente(),
            cliente.getNombres(),
            cliente.getApellidos(),
            cliente.getCorreo(),
            cliente.getTelefono(), 
            cliente.getCedula(),
            cliente.getPropiedadAsignada()
        });
    }
    return modeloC;
}
//Leila creo metodo de visitas
public static DefaultTableModel generarTablaVisitasCompleta() {
    DefaultTableModel modelo = new DefaultTableModel(
        new Object[]{"ID", "Fecha", "Día", "Cliente", "Agente", "Propiedad", "Estado"}, 0
    );

    for (Visitas visita : Visitas.listaVisitas) {
        // Buscar nombre del CLIENTE
        String nombreCliente = buscarNombre(visita.getCliente(), 
            ClienteUsuario.listaUsuariosCliente, 
            Propietario.listaPropietarios);
        
        // Buscar nombre del AGENTE
        String nombreAgente = buscarNombre(visita.getAgente(), 
            Agente.listaAgentes, 
            null);

        modelo.addRow(new Object[]{
            visita.getIdVisita(),
            visita.getFecha(),
            visita.getDiaSemana(),
            nombreCliente,   // Ej: "Ana López"
            nombreAgente,    // Ej: "Carlos Pérez"
            visita.getPropiedadId(),
            visita.getEstado()
        });
    }
    return modelo;
}
private static String buscarNombre(String usuarioId, 
                                 ArrayList<? extends Usuarios> lista1, 
                                 ArrayList<? extends Usuarios> lista2) {
    // Buscar en la primera lista (ej: Clientes)
    for (Usuarios usuario : lista1) {
        if (usuario.getUsuario().equals(usuarioId)) {
            return usuario.getNombres() + " " + usuario.getApellidos();
        }
    }
    
    // Buscar en la segunda lista (ej: Propietarios) si existe
    if (lista2 != null) {
        for (Usuarios usuario : lista2) {
            if (usuario.getUsuario().equals(usuarioId)) {
                return usuario.getNombres() + " " + usuario.getApellidos();
            }
        }
    }
    
    return usuarioId; // Si no se encuentra, devolver el ID original
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
//Metodo para pagos
 public static DefaultTableModel generarPagos() {
        DefaultTableModel modeloa = new DefaultTableModel(
                new Object[]{"ID Pago", "Tipo Pago", "Propiedad ID", "Cliente", "Monto", " Estado", "Metodo Pago", "Agente"}, 0
        );
        for (Pagos pagos : Pagos.listaPagos) {
            modeloa.addRow(new Object[]{
                pagos.getIdPago(),
                pagos.getTipoPago(),
                pagos.getPropiedadId(),
                pagos.getCliente(),
                pagos.getMonto(),
                pagos.getEstado(),
                pagos.getMetodoPago(),
                pagos.getAgente()
            });
        }
        return modeloa;
    }
    public static DefaultTableModel generarTablaUsuariosCompleta() {
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"Usuario", "Contraseña", "Nombres", "Apellidos", "Cargo"}, 0
        );

        //  Agregar Agentes
        agregarUsuariosDeLista(modelo, new ArrayList<>(Agente.listaAgentes));
        
        //  Agregar Propietarios
        agregarUsuariosDeLista(modelo, new ArrayList<>(Propietario.listaPropietarios));
        
        //  Agregar Clientes
        agregarUsuariosDeLista(modelo, new ArrayList<>(ClienteUsuario.listaUsuariosCliente));
        
        //  Agregar Administrador 
        if (gio.perrito != null) {
            agregarUsuario(modelo, gio.perrito);
        }

        return modelo;
    }

    // Método para agregar un usuario individual
    private static void agregarUsuario(DefaultTableModel modelo, Usuarios usuario) {
        modelo.addRow(new Object[]{
            usuario.getUsuario(),
            usuario.getContraseña(),
            usuario.getNombres(),
            usuario.getApellidos(),
            usuario.getCargo()
        });
    }

    // Método auxiliar para agregar una lista de usuarios
    private static void agregarUsuariosDeLista(DefaultTableModel modelo, ArrayList<? extends Usuarios> listaUsuarios) {
        for (Usuarios usuario : listaUsuarios) {
            agregarUsuario(modelo, usuario);
        }}
    //Agregar visita para Contratos
    
  
    
    //AGREGAR VISITA PARA CLIENTE
  public static void agendarVisita(String clienteActual) {
    // Agentes
    String[] nombresAgentes = Agente.listaAgentes.stream()
        .map(a -> a.getNombres() + " " + a.getApellidos())
        .toArray(String[]::new);

    String nombreAgente = (String) JOptionPane.showInputDialog(
        null, "Seleccione un agente:", "Agendar Visita",
        JOptionPane.QUESTION_MESSAGE, null, nombresAgentes, null);

    if (nombreAgente != null) {
        String idAgente = Agente.listaAgentes.stream()
            .filter(a -> (a.getNombres() + " " + a.getApellidos()).equals(nombreAgente))
            .map(Agente::getUsuario)
            .findFirst().orElse(null);

        if (idAgente != null) {
            // PROPIEDADES
            String[] propiedadesOpciones = Propiedades.listaCasas.stream()
                .map(p -> p.getId() + " - " + p.getTipo()) // Ej: "P001 - Casa en el centro"
                .toArray(String[]::new);

            String propiedadSeleccionada = (String) JOptionPane.showInputDialog(
                null, "Seleccione una propiedad:", "Agendar Visita",
                JOptionPane.QUESTION_MESSAGE, null, propiedadesOpciones, null);

            if (propiedadSeleccionada != null) {
                // Extraer solo el ID antes del guión
                String propiedadId = propiedadSeleccionada.split(" - ")[0];

                String fecha = JOptionPane.showInputDialog("Fecha (DD/MM/AAAA):");

                if (fecha != null && !fecha.isEmpty()) {
                    String idVisita = "V" + (Visitas.listaVisitas.size() + 1);
                    Visitas.agregarVisita(
                        idVisita,
                        fecha,
                        obtenerDiaSemana(fecha),
                        idAgente,
                        clienteActual,
                        propiedadId
                    );
                    JOptionPane.showMessageDialog(null, "Visita agendada con " + nombreAgente);
                }
            }
        }
    }
}
  public static DefaultTableModel generarTablaVisitasCliente(String usuarioCliente) {
    DefaultTableModel modelo = new DefaultTableModel(
        new Object[]{"ID", "Fecha", "Día", "Agente", "Propiedad", "Estado"}, 0
    );

    Visitas.listaVisitas.stream()
        .filter(v -> v.getCliente().equals(usuarioCliente))
        .forEach(v -> modelo.addRow(new Object[]{
            v.getIdVisita(),
            v.getFecha(),
            v.getDiaSemana(),
            v.getAgente(),
            v.getPropiedadId(),
            v.getEstado()
        }));

    return modelo;
}
  public static Usuarios verificarUsuario(String usuario, String contraseña) {
    for (ClienteUsuario c : ClienteUsuario.listaUsuariosCliente) {
        if (c.getUsuario().equals(usuario) && c.getContraseña().equals(contraseña)) {
            return c;
        }
    }

    for (Agente a : Agente.listaAgentes) {
        if (a.getUsuario().equals(usuario) && a.getContraseña().equals(contraseña)) {
            return a;
        }
    }

    for (Propietario p : Propietario.listaPropietarios) {
        if (p.getUsuario().equals(usuario) && p.getContraseña().equals(contraseña)) {
            return p;
        }
    }

    if (gio.perrito != null && gio.perrito.getUsuario().equals(usuario) && gio.perrito.getContraseña().equals(contraseña)) {
        return gio.perrito;
    }

    return null; // si no se encuentra
}
   public static void agregarNuevaPropiedadConImagen(JTable tabla, JComboBox<String> comboBoxIds, JLabel imagenLabel) {
    if (Agente.listaAgentes.isEmpty()) {
        Agente.cargarAgentesEjemplo();
    }

    String[] nombresAgentes = Agente.listaAgentes.stream()
            .map(a -> a.getNombres() + " " + a.getApellidos())
            .toArray(String[]::new);
    String[] estadoOpciones = {"Disponible", "Reservado", "Vendido", "Arrendado", "Mantenimiento"};

    JComboBox<String> comboEstado = new JComboBox<>(estadoOpciones);
    JComboBox<String> comboAgente = new JComboBox<>(nombresAgentes);

    JLabel previewImagen = new JLabel();
    previewImagen.setPreferredSize(new Dimension(200, 150));
    previewImagen.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    final String[] rutaImagen = {null};

    JButton btnSeleccionarImagen = new JButton("Seleccionar imagen");
    btnSeleccionarImagen.addActionListener(e -> {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona una imagen para la propiedad");
        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            String nombreArchivo = archivoSeleccionado.getName();
            String rutaDestino = "imagenes_cargadas/" + nombreArchivo;

            File carpetaDestino = new File("imagenes_cargadas");
            if (!carpetaDestino.exists()) carpetaDestino.mkdir();

            try {
                Files.copy(archivoSeleccionado.toPath(), new File(rutaDestino).toPath(), StandardCopyOption.REPLACE_EXISTING);
                rutaImagen[0] = rutaDestino;

                ImageIcon icono = new ImageIcon(rutaDestino);
                Image imgEscalada = icono.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
                previewImagen.setIcon(new ImageIcon(imgEscalada));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al copiar la imagen: " + ex.getMessage());
            }
        }
    });

    JPanel panelImagen = new JPanel(new BorderLayout(5, 5));
    panelImagen.add(previewImagen, BorderLayout.CENTER);
    panelImagen.add(btnSeleccionarImagen, BorderLayout.SOUTH);

    // Generar ID automático
    String idGenerado = String.format("02411", Propiedades.listaCasas.size() + 1);
    JLabel lblIdGenerado = new JLabel(idGenerado);

    // Campos de texto básicos (sin ID manual)
    JTextField txtTipo = new JTextField();
    JTextField txtUbicacion = new JTextField();
    JTextField txtArea = new JTextField();
    JTextField txtPrecio = new JTextField();
    JTextField txtPropietario = new JTextField();

    // Campos para descripción (números)
    JTextField txtHabitaciones = new JTextField();
    JTextField txtPisos = new JTextField();
    JTextField txtCocinas = new JTextField();
    JTextField txtBanios = new JTextField();
    JTextField txtOtros = new JTextField();

    JPanel panelCampos = new JPanel(new GridLayout(0, 2, 5, 5));
    panelCampos.add(new JLabel("ID (auto):")); panelCampos.add(lblIdGenerado);
    panelCampos.add(new JLabel("Tipo:")); panelCampos.add(txtTipo);
    panelCampos.add(new JLabel("Ubicación:")); panelCampos.add(txtUbicacion);
    panelCampos.add(new JLabel("Área:")); panelCampos.add(txtArea);
    panelCampos.add(new JLabel("Precio:")); panelCampos.add(txtPrecio);
    panelCampos.add(new JLabel("Propietario:")); panelCampos.add(txtPropietario);
    panelCampos.add(new JLabel("Habitaciones:")); panelCampos.add(txtHabitaciones);
    panelCampos.add(new JLabel("Pisos:")); panelCampos.add(txtPisos);
    panelCampos.add(new JLabel("Cocinas:")); panelCampos.add(txtCocinas);
    panelCampos.add(new JLabel("Baños:")); panelCampos.add(txtBanios);
    panelCampos.add(new JLabel("Otros:")); panelCampos.add(txtOtros);
    panelCampos.add(new JLabel("Estado:")); panelCampos.add(comboEstado);
    panelCampos.add(new JLabel("Agente:")); panelCampos.add(comboAgente);

    JPanel panelFinal = new JPanel(new BorderLayout(10, 10));
    panelFinal.add(panelCampos, BorderLayout.CENTER);
    panelFinal.add(panelImagen, BorderLayout.EAST);

    int respuesta = JOptionPane.showConfirmDialog(null, panelFinal, "Agregar Propiedad", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    if (respuesta == JOptionPane.OK_OPTION) {
        String id = idGenerado;
        String tipo = txtTipo.getText().trim();
        String ubicacion = txtUbicacion.getText().trim();
        String area = txtArea.getText().trim();
        String precio = txtPrecio.getText().trim();
        String propietario = txtPropietario.getText().trim();
        String estado = (String) comboEstado.getSelectedItem();
        String agente = (String) comboAgente.getSelectedItem();
        String strHabitaciones = txtHabitaciones.getText().trim();
        String strPisos = txtPisos.getText().trim();
        String strCocinas = txtCocinas.getText().trim();
        String strBanios = txtBanios.getText().trim();
        String otros = txtOtros.getText().trim();

        // Validar campos vacíos y que la imagen esté seleccionada
        if (tipo.isEmpty() || ubicacion.isEmpty() || area.isEmpty() || precio.isEmpty() ||
            propietario.isEmpty() || strHabitaciones.isEmpty() || strPisos.isEmpty() || strCocinas.isEmpty() ||
            strBanios.isEmpty() || otros.isEmpty() || rutaImagen[0] == null) {
            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos y selecciona una imagen.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Convertir los campos numéricos a int
        int habitaciones;
        int pisos;
        int cocinas;
        int banios;
        try {
            habitaciones = Integer.parseInt(strHabitaciones);
            pisos = Integer.parseInt(strPisos);
            cocinas = Integer.parseInt(strCocinas);
            banios = Integer.parseInt(strBanios);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Los campos de Habitaciones, Pisos, Cocinas y Baños deben ser números enteros.", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear el objeto Propiedades
        Propiedades nueva = new Propiedades(
            id,
            tipo,
            ubicacion,
            area,
            precio,
            estado,
            propietario,
            agente,
            rutaImagen[0],
            habitaciones,
            pisos,
            cocinas,
            banios,
            otros
        );
        Propiedades.listaCasas.add(nueva);

        // Agregar fila a la tabla
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addRow(new Object[]{id, tipo, ubicacion, area, precio, estado, propietario, agente});

        // Actualizar comboBoxIds
        comboBoxIds.addItem(nueva.getId());
        comboBoxIds.setSelectedItem("-- Seleccione una propiedad --");

        // Mostrar imagen cargada
        ImageIcon iconoOriginal = new ImageIcon(rutaImagen[0]);
        Image img = iconoOriginal.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
        imagenLabel.setIcon(new ImageIcon(img));
    }
}


public static void cargarIdsEnCombo(JComboBox<String> comboBox) {
    comboBox.removeAllItems();
    comboBox.addItem("-- Seleccione una propiedad --"); 

    for (Propiedades p : Propiedades.listaCasas) {
        comboBox.addItem(p.getId());
    }
}
public static void crearContrato(String clienteActual) {
    // 1. Tipo de contrato
    String[] tiposContrato = {"Arriendo", "Venta"};
    String tipo = (String) JOptionPane.showInputDialog(null, "Tipo de contrato:", "Nuevo Contrato",
            JOptionPane.QUESTION_MESSAGE, null, tiposContrato, tiposContrato[0]);

    if (tipo == null) return;

    // 2. Agente
    String[] nombresAgentes = Agente.listaAgentes.stream()
            .map(a -> a.getNombres() + " " + a.getApellidos())
            .toArray(String[]::new);

    String nombreAgente = (String) JOptionPane.showInputDialog(null, "Seleccione un agente:", "Nuevo Contrato",
            JOptionPane.QUESTION_MESSAGE, null, nombresAgentes, null);

    if (nombreAgente == null) return;

    String usuarioAgente = Agente.listaAgentes.stream()
            .filter(a -> (a.getNombres() + " " + a.getApellidos()).equals(nombreAgente))
            .map(Agente::getUsuario)
            .findFirst().orElse("Desconocido");

    // 3. Propiedad
    String[] propiedadesOpciones = Propiedades.listaCasas.stream()
            .map(p -> p.getId() + " - " + p.getTipo())
            .toArray(String[]::new);

    String propiedadSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una propiedad:",
            "Nuevo Contrato", JOptionPane.QUESTION_MESSAGE, null, propiedadesOpciones, null);

    if (propiedadSeleccionada == null) return;

    String propiedadId = propiedadSeleccionada.split(" - ")[0];

    // 4. Valor
    String valorStr = JOptionPane.showInputDialog("Ingrese el valor del contrato:");
    if (valorStr == null || valorStr.isEmpty()) return;

    int valor;
    try {
        valor = Integer.parseInt(valorStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Valor inválido.");
        return;
    }

    // 5. Inicio y fin
    String mesInicio = JOptionPane.showInputDialog("Mes de inicio (Ej: Enero):");
    if (mesInicio == null || mesInicio.isEmpty()) return;

    String mesFin = JOptionPane.showInputDialog("Mes de finalización (Ej: Junio):");
    if (mesFin == null || mesFin.isEmpty()) return;

    // 6. Crear contrato
    String idContrato = "C00" + (Contratos.listaContratos.size() + 1);

    Contratos nuevo = new Contratos(idContrato, tipo, propiedadId, clienteActual, usuarioAgente,
            "Activo", valor, mesInicio, mesFin);

    Contratos.listaContratos.add(nuevo);

    JOptionPane.showMessageDialog(null, "Contrato creado exitosamente con ID: " + idContrato);
}
//Metodo para ocultar columnas
private static final Map<JTable, Map<Integer, TableColumn>> columnasOcultasMap = new HashMap<>();

    public static void ocultarColumnas(JTable tabla, int[] indicesColumnas) {
        TableColumnModel columnModel = tabla.getColumnModel();
        Map<Integer, TableColumn> columnasOcultas = columnasOcultasMap.computeIfAbsent(tabla, k -> new HashMap<>());

        for (int i = 0; i < indicesColumnas.length; i++) {
            int index = indicesColumnas[i];

            for (int j = 0; j < columnModel.getColumnCount(); j++) {
                TableColumn col = columnModel.getColumn(j);
                if (col.getModelIndex() == index) {
                    columnasOcultas.put(index, col);
                    columnModel.removeColumn(col);
                    break;
                }
            }
        }
    }
//Metodo para mostrar columnas ocultas o modificadas
    public static void mostrarColumnasOcultas(JTable tabla) {
        Map<Integer, TableColumn> columnasOcultas = columnasOcultasMap.get(tabla);
        if (columnasOcultas == null || columnasOcultas.isEmpty()) return;

        TableColumnModel columnModel = tabla.getColumnModel();

        // Ordenar las columnas por su índice original para mantener el orden correcto
        List<Integer> indicesOrdenados = new ArrayList<>(columnasOcultas.keySet());
        Collections.sort(indicesOrdenados);

        for (int index : indicesOrdenados) {
            TableColumn col = columnasOcultas.get(index);
            columnModel.addColumn(col);
        }

        columnasOcultas.clear();
    }


}



    
