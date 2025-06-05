/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formularios;


import static Formularios.Agente.listaAgentes;
import static Formularios.Pagos.listaPagos;
import static Formularios.Visitas.listaVisitas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author kdeke
 */
public class Metodos {
    
    
    public static void configurarFondoCompleto(JFrame frame, JPanel panelPrincipal, String rutaImagen) {
    
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
    
    public static DefaultTableModel generarModeloCasasTodas() {
        String[] columnas = {
            "ID", "Tipo", "Ubicación", "Área",
            "Precio", "Estado", "Propietario", "Agente"
        };
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

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

    /**
     * 2. Devuelve un DefaultTableModel con las propiedades cuyo estado sea "Disponible".
     *    (Para el rol Cliente.)
     *    Columnas: {ID, Tipo, Ubicación, Área, Precio, Estado, Propietario, Agente}
     */
    public static DefaultTableModel generarModeloCasasDisponibles() {
        String[] columnas = {
            "ID", "Tipo", "Ubicación", "Área",
            "Precio", "Estado", "Propietario", "Agente"
        };
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Propiedades casa : Propiedades.listaCasas) {
            // Solo cargo si está "Disponible"
            if ("Disponible".equalsIgnoreCase(casa.getEstado())) {
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
        }
        return modelo;
    }

    /**
     * 3. Devuelve un DefaultTableModel con las propiedades de UN SOLO PROPIETARIO.
     *    (Para el rol Propietario.)
     *    Columnas: {ID, Tipo, Ubicación, Área, Precio, Estado}
     *    Nota: aquí omitimos Propietario y Agente en la tabla, ya que el dueño
     *    solo necesita ver sus propiedades.
     */
    public static DefaultTableModel generarModeloCasasPorPropietario(String propietarioId) {
        String[] columnas = {
            "ID", "Tipo", "Ubicación", "Área",
            "Precio", "Estado"
        };
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Propiedades casa : Propiedades.listaCasas) {
            if (casa.getPropietario().equalsIgnoreCase(propietarioId)) {
                modelo.addRow(new Object[]{
                    casa.getId(),
                    casa.getTipo(),
                    casa.getUbicacion(),
                    casa.getArea(),
                    casa.getPrecio(),
                    casa.getEstado()
                });
            }
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
//Leila creo metodo metodo para filtrar casas de propiedades segun el propietario


       

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
 public static List<Pagos> filtrarPagosPorUsuario(Usuarios usuario) {
    if (usuario == null) return Collections.emptyList();

    List<Pagos> pagosFiltrados = new ArrayList<>();
    String nombre = usuario.getNombres(); // antes usabas getUsuario()

    for (Pagos pago : listaPagos) {
        if (pago.getCliente().equalsIgnoreCase(nombre) || pago.getAgente().equalsIgnoreCase(nombre)) {
            pagosFiltrados.add(pago);
        }
    }
    return pagosFiltrados;
}
 public static DefaultTableModel generarModeloPagosFiltrados(Usuarios usuario) {
    DefaultTableModel modelo = new DefaultTableModel(
        new Object[]{"ID Pago", "Tipo Pago", "Propiedad ID", "Cliente", "Monto", "Estado", "Método Pago", "Agente"}, 0
    );

    List<Pagos> pagosFiltrados = filtrarPagosPorUsuario(usuario); // usa tu método de filtrado

    for (Pagos p : pagosFiltrados) {
        modelo.addRow(new Object[]{
            p.getIdPago(),
            p.getTipoPago(),
            p.getPropiedadId(),
            p.getCliente(),
            p.getMonto(),
            p.getEstado(),
            p.getMetodoPago(),
            p.getAgente()
        });
    }

    return modelo;
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
 public static String obtenerNombreDesdeID(String idUsuario) {

        if (Agente.listaAgentes != null) {
            for (Agente a : Agente.listaAgentes) {
                if (a.getUsuario().equals(idUsuario)) {
                    return a.getNombres() + " " + a.getApellidos();
                }
            }
        }

        if (ClienteUsuario.listaUsuariosCliente != null) {
            for (ClienteUsuario c : ClienteUsuario.listaUsuariosCliente) {
                if (c.getUsuario().equals(idUsuario)) {
                    return c.getNombres() + " " + c.getApellidos();
                }
            }
        }

        if (Propietario.listaPropietarios != null) {
            for (Propietario p : Propietario.listaPropietarios) {
                if (p.getUsuario().equals(idUsuario)) {
                    return p.getNombres() + " " + p.getApellidos();
                }
            }
        }

        if (gio.perrito != null && gio.perrito.getUsuario().equals(idUsuario)) {
            return gio.perrito.getNombres() + " " + gio.perrito.getApellidos();
        }

        // Si no se encuentra en ninguna lista, devuelve el mismo idUsuario
        return idUsuario;
    }
public static void cargarVisitasEnTabla(JTable tabla, List<Visitas> listaVisitas) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{
            "ID", "Fecha", "Agente", "Cliente", "Propiedad", "Estado"
        });

        for (Visitas v : listaVisitas) {
            String nombreAgente  = obtenerNombreDesdeID(v.getAgenteId());
            String nombreCliente = obtenerNombreDesdeID(v.getClienteId());

            modelo.addRow(new Object[]{
                v.getIdVisita(),
                v.getFecha(),
                nombreAgente,
                nombreCliente,
                v.getPropiedadId(),
                v.getEstado()
            });
        }

        tabla.setModel(modelo);
    }

    /**
     * Muestra diálogos para que el usuario (cliente o agente) seleccione agente y propiedad,
     * ingrese fecha y luego agrega la visita a la lista estática.
     */
    public static void agendarVisita(String clienteActual, JTable tablaVisitas) {
        // 1) Armar array de nombres de agentes para el diálogo
        String[] nombresAgentes = Agente.listaAgentes.stream()
            .map(a -> a.getNombres() + " " + a.getApellidos())
            .toArray(String[]::new);

        String nombreAgenteSeleccionado = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione un agente:",
            "Agendar Visita",
            JOptionPane.QUESTION_MESSAGE,
            null,
            nombresAgentes,
            null
        );

        if (nombreAgenteSeleccionado != null) {
            // 2) Obtener ID del agente a partir del nombre completo
            String idAgente = Agente.listaAgentes.stream()
                .filter(a -> (a.getNombres() + " " + a.getApellidos()).equals(nombreAgenteSeleccionado))
                .map(Agente::getUsuario)
                .findFirst()
                .orElse(null);

            if (idAgente != null) {
                // 3) Armar array de “ID - Tipo” de cada propiedad
                String[] propiedadesOpciones = Propiedades.listaCasas.stream()
                    .map(p -> p.getId() + " - " + p.getTipo())
                    .toArray(String[]::new);

                String propiedadSeleccionada = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una propiedad:",
                    "Agendar Visita",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    propiedadesOpciones,
                    null
                );

                if (propiedadSeleccionada != null) {
                    String propiedadId = propiedadSeleccionada.split(" - ")[0];
                    String fecha = JOptionPane.showInputDialog("Fecha (DD/MM/AAAA):");

                    if (fecha != null && !fecha.trim().isEmpty()) {
                        // 4) Construir nuevo ID de visita: “V” + (tamaño de la lista + 1)
                        String idVisita = "V" + (Visitas.listaVisitas.size() + 1);

                        // 5) Llamar a Visitas.agregarVisita(...)
                        Visitas.agregarVisita(
                            idVisita,
                            fecha,
                            obtenerDiaSemana(fecha), // Necesitas implementar este método en tu util
                            idAgente,
                            clienteActual,
                            propiedadId
                        );

                        JOptionPane.showMessageDialog(
                            null,
                            "Visita agendada con " + nombreAgenteSeleccionado
                        );

                        // 6) Actualizar la tabla completa (se podría recargar desde el botón)
                        cargarVisitasEnTabla(tablaVisitas, Visitas.listaVisitas);
                    }
                }
            }
        }
    }

    /**
     * Filtra la lista de visitas según el rol del usuario (instanceof) y su ID.
     * - Administrador: devuelve todas las visitas.
     * - Cliente: solo donde clienteId == usuario.getUsuario().
     * - Agente: solo donde agenteId == usuario.getUsuario().
     * - Propietario: no ve nada (lista vacía).
     */
    public static List<Visitas> filtrarVisitasPorUsuario(Usuarios usuario) {
        if (usuario instanceof gio) {
            // Administrador ve todo
            return Visitas.listaVisitas;
        }
        else if (usuario instanceof ClienteUsuario) {
            // Cliente ve sus propias visitas
            return Visitas.listaVisitas.stream()
                .filter(v -> v.getClienteId().equals(usuario.getUsuario()))
                .collect(Collectors.toList());
        }
        else if (usuario instanceof Agente) {
            // Agente ve las visitas donde es agente
            return Visitas.listaVisitas.stream()
                .filter(v -> v.getAgenteId().equals(usuario.getUsuario()))
                .collect(Collectors.toList());
        }
        // Propietario o cualquier otro rol no ve visitas
        return new ArrayList<>();
    }

    /**
     * Ejemplo de función auxiliar para convertir "DD/MM/AAAA" a día de la semana.
     * Tú debes implementar la lógica real si la necesitas.
     */
   
    

  //obtener nombre del cliente 
  public static String getNombreClientePorUsuario(String usuario) {
    for (ClienteUsuario c : ClienteUsuario.listaUsuariosCliente) {
        if (c.getUsuario().equals(usuario)) {
            return c.getNombres() + " " + c.getApellidos();
        }
    }
    return "Desconocido";
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
    String idGenerado = String.format("02413", Propiedades.listaCasas.size() + 1);
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

    // 3. Propiedad
    String[] propiedadesOpciones = Propiedades.listaCasas.stream()
            .map(p -> p.getId() + " - " + p.getTipo())
            .toArray(String[]::new);

    String propiedadSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una propiedad:",
            "Nuevo Contrato", JOptionPane.QUESTION_MESSAGE, null, propiedadesOpciones, null);

    if (propiedadSeleccionada == null) return;

    String propiedadId = propiedadSeleccionada.split(" - ")[0];

    // 4. Valor (obligatorio)
    int valor;
    while (true) {
        String valorStr = JOptionPane.showInputDialog(null, "Ingrese el valor del contrato:",
                "Nuevo Contrato", JOptionPane.PLAIN_MESSAGE);
        if (valorStr == null) return;
        if (!valorStr.trim().isEmpty()) {
            try {
                valor = Integer.parseInt(valorStr);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Este campo no puede estar vacío.");
        }
    }

    // 5. Meses (obligatorio)
    String mesInicio = "", mesFin = "";
    while (mesInicio.trim().isEmpty()) {
        mesInicio = JOptionPane.showInputDialog(null, "Mes de inicio (Ej: Enero):",
                "Nuevo Contrato", JOptionPane.PLAIN_MESSAGE);
        if (mesInicio == null) return;
    }
    while (mesFin.trim().isEmpty()) {
        mesFin = JOptionPane.showInputDialog(null, "Mes de finalización (Ej: Junio):",
                "Nuevo Contrato", JOptionPane.PLAIN_MESSAGE);
        if (mesFin == null) return;
    }

    // 6. Verificar si el contrato está en el pasado
    Map<String, Integer> mesesOrden = new HashMap<>();
mesesOrden.put("Enero", 1);
mesesOrden.put("Febrero", 2);
mesesOrden.put("Marzo", 3);
mesesOrden.put("Abril", 4);
mesesOrden.put("Mayo", 5);
mesesOrden.put("Junio", 6);
mesesOrden.put("Julio", 7);
mesesOrden.put("Agosto", 8);
mesesOrden.put("Septiembre", 9);
mesesOrden.put("Octubre", 10);
mesesOrden.put("Noviembre", 11);
mesesOrden.put("Diciembre", 12);

    int mesActual = LocalDate.now().getMonthValue();
    int fin = mesesOrden.getOrDefault(mesFin, 0);

    String estado = (fin < mesActual) ? "Cancelado" : "Activo";

    // 7. Crear contrato
    String idContrato = "C00" + (Contratos.listaContratos.size() + 1);

    Contratos nuevo = new Contratos(idContrato, tipo, propiedadId, clienteActual, nombreAgente,
            estado, valor, mesInicio, mesFin);

    Contratos.listaContratos.add(nuevo);

    JOptionPane.showMessageDialog(null, "Contrato creado con ID: " + idContrato + "\nEstado: " + estado,
            "Nuevo Contrato", JOptionPane.INFORMATION_MESSAGE);
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

public static void crearPago(String clienteActual) {
    // 1. Tipo de pago
    String[] tiposPago = {"Arriendo", "Venta", "Finca", "Local", "Casa", "Apartamento"};
    String tipoPago = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de pago:",
            "Nuevo Pago", JOptionPane.QUESTION_MESSAGE, null, tiposPago, tiposPago[0]);
    if (tipoPago == null) return;

    // 2. Seleccionar propiedad
    String[] propiedadesOpciones = Propiedades.listaCasas.stream()
            .map(p -> p.getId() + " - " + p.getTipo())
            .toArray(String[]::new);

    String propiedadSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una propiedad:",
            "Nuevo Pago", JOptionPane.QUESTION_MESSAGE, null, propiedadesOpciones, null);
    if (propiedadSeleccionada == null) return;

    String propiedadId = propiedadSeleccionada.split(" - ")[0];

    // 3. Monto
    int monto = 0;
    while (true) {
        String montoStr = JOptionPane.showInputDialog(null, "Ingrese el monto del pago:", "Nuevo Pago", JOptionPane.PLAIN_MESSAGE);
        if (montoStr == null || montoStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un monto válido.");
            continue;
        }
        try {
            monto = Integer.parseInt(montoStr);
            if (monto <= 0) throw new NumberFormatException();
            break;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Monto inválido. Ingrese un número positivo.");
        }
    }

    // 4. Método de pago
    String[] metodos = {"Efectivo", "Tarjeta", "Transferencia"};
    String metodoPago = (String) JOptionPane.showInputDialog(null, "Seleccione el método de pago:",
            "Nuevo Pago", JOptionPane.QUESTION_MESSAGE, null, metodos, metodos[0]);
    if (metodoPago == null) return;

    // 5. Agente (solo nombres)
    String[] nombresAgentes = Agente.listaAgentes.stream()
            .map(Agente::getNombres)
            .toArray(String[]::new);

    String nombreAgente = (String) JOptionPane.showInputDialog(null, "Seleccione un agente:",
            "Nuevo Pago", JOptionPane.QUESTION_MESSAGE, null, nombresAgentes, null);
    if (nombreAgente == null) return;

    // 6. Estado del pago
    String[] estados = {"Pagado", "Pendiente"};
    String estado = (String) JOptionPane.showInputDialog(null, "Seleccione el estado del pago:",
            "Nuevo Pago", JOptionPane.QUESTION_MESSAGE, null, estados, estados[0]);
    if (estado == null) return;

    // 7. ID automático basado en el último ID existente
    int maxId = Pagos.listaPagos.stream()
            .mapToInt(p -> Integer.parseInt(p.getIdPago()))
            .max().orElse(10000); // por defecto si está vacío
    String idPago = String.valueOf(maxId + 1);

    // 8. Crear y guardar el pago
    Pagos nuevoPago = new Pagos(idPago, tipoPago, propiedadId, clienteActual, monto,
            estado, metodoPago, nombreAgente);
    Pagos.listaPagos.add(nuevoPago);

    JOptionPane.showMessageDialog(null, "Pago creado exitosamente con ID: " + idPago,
            "Nuevo Pago", JOptionPane.INFORMATION_MESSAGE);
}
//Metodo para ajustar tamaño de imagen a el boton
public static void ponerImagenEscalada(JButton boton, String rutaImagen) {
        ImageIcon imagenOriginal = new ImageIcon(Metodos.class.getResource(rutaImagen));

        // Escalar la imagen cuando el botón cambie de tamaño
        boton.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int ancho = boton.getWidth();
                int alto = boton.getHeight();

                if (ancho > 0 && alto > 0) {
                    Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
                    boton.setIcon(new ImageIcon(imagenEscalada));
                    boton.setText(""); // Opcional: eliminar texto del botón
                }
            }
        });
    }
 public static DefaultTableModel generarModeloReportes() {
    String[] columnas = {"Año", "ID Propiedad", "Cliente", "Agente", "Valor Venta", "Comisión Agente (3%)", "Ingreso Neto"};
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

    for (Reportes r : Reportes.listaReportes) {
        Object[] fila = {
            r.getAño(),
            r.getIdPropiedad(),
            r.getCliente(),
            r.getAgente(),
            r.getValorVenta(),
            String.format("%.2f", r.getComisionAgente()),
            String.format("%.2f", r.getIngresoNeto())
        };
        modelo.addRow(fila);
    }

    return modelo;}
}
