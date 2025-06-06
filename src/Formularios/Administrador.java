/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;


import static Formularios.Metodos.generarModeloPagosFiltrados;
import static Formularios.Visitas.listaVisitas;
import static Formularios.iniciosesion.usuarioLogueado;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author kdeke
 */

public class Administrador extends javax.swing.JFrame {
  //Leila coloco las tablas por defecto sin nada
    DefaultTableModel modelo;
   DefaultTableModel modeloClientes;
   DefaultTableModel modeloVisitas;
   DefaultTableModel modeloContratos;
   DefaultTableModel modeloP;
   DefaultTableModel modeloUsuario;
    private JPanel panelContenido;  
    private CardLayout cardLayout;
  private Usuarios usuarioLogueadoObj;
  
    
    public Administrador() {
}
public Administrador(Usuarios usuarioLogueado) {
    initComponents();
    this.usuarioLogueadoObj = usuarioLogueado;

    // Cargar ejemplos de datos
    Agente.cargarAgentesEjemplo();
    ClienteUsuario.cargarClientesUsuarioEjemplo();
    Propietario.cargarPropietariosEjemplo();
    gio.cargarAdministradorEjemplo();
    Visitas.cargarVisitasEjemplo();
    Propiedades.cargarCasasEjemplo();
     Reportes.cargarReportesEjemplo(); 
    

    // Configurar CardLayout para AdminBotones
    CardLayout cl = new CardLayout();
    AdminBotones.setLayout(cl);
    AdminBotones.add(ClientesBotPan,    "Cliente");
    AdminBotones.add(AgeBotPan,         "Agente");
    AdminBotones.add(PropietarioBotPan, "Propietario");
    AdminBotones.add(AdminBotPan,       "Administrador");
    mostrarPanelSegunCargo();

    // Cargar la tabla de propiedades según el rol del usuario
    cargarTablaPropiedadesSegunRol();
ReportesBasicosTable.setModel(Metodos.generarModeloReportes());
    // Ahora configuro el fondo y agrego los paneles al JFrame
    FondoPanel fondo = new FondoPanel();
    fondo.setLayout(new BorderLayout());
    
        setTitle("Machape Imbobiliaria");
    
    // Mover los paneles existentes al fondo
    fondo.add(AdminBotones, BorderLayout.NORTH);
    fondo.add(ParentPan,     BorderLayout.CENTER);
    getContentPane().removeAll();
    getContentPane().add(fondo);

    // Posicionar la ventana en el centro
    this.setLocationRelativeTo(this);

        // Agrega los paneles
        AdminBotones.add(ClientesBotPan, "Cliente");
        AdminBotones.add(AgeBotPan, "Agente");
        AdminBotones.add(PropietarioBotPan, "Propietario");
        AdminBotones.add(AdminBotPan, "Administrador");
        //Leila Coloco el llamado del metodo clientes para la tabla
        Clientes.cargarClientesEjemplo();
        modeloClientes = Metodos.generarTablaClientes();
        ClientesTable.setModel(modeloClientes);
        //Leila Llamo al metodo propiedades para la tabla de propiedades

cargarTablaPropiedadesSegunRol();
        Propiedades.cargarCasasEjemplo();
//        modelo = Metodos.generarModeloCasas();
      
        //Leila llamo al metodo de visitas para la tabla de visitas
        Visitas.cargarVisitasEjemplo();
//        modeloVisitas = Metodos.generarTablaVisitasCompleta();
      
        //Leila llamo al metodo de contratos
        Contratos.cargarContratosEjemplo();
        modeloContratos = Metodos.generarContratos();
        ContratosTable.setModel(modeloContratos);
        //leila llamo al metodo de pagos
        Pagos.cargarPagosEjemplo(); 
        PagosTable.setModel(Metodos.generarModeloPagosFiltrados(usuarioLogueado));
//      
        //Leila llamo al metodo de usuarios;
        //se llaman a las clases heredadas por Usuarios
        Agente.cargarAgentesEjemplo();
        Propietario.cargarPropietariosEjemplo();
        ClienteUsuario.cargarClientesUsuarioEjemplo();
        gio.cargarAdministradorEjemplo();
        //muestra los datos a la tabla
        modeloUsuario = Metodos.generarTablaUsuariosCompleta();
        UsuariosTable.setModel(modeloUsuario);
        
   
        
        mostrarPanelSegunCargo();
        
        Metodos.ponerImagenEscalada(CerrarAdBot, "/imagenes/Apagar.png");
        Metodos.ponerImagenEscalada(CerrarAgeBot, "/imagenes/Apagar.png");
        Metodos.ponerImagenEscalada(CerrarCliBot, "/imagenes/Apagar.png");
        Metodos.ponerImagenEscalada(CerrarProBot, "/imagenes/Apagar.png");
        Metodos.ponerImagenEscalada(CerrarRepAdBot, "/imagenes/Apagar.png");
        Metodos.ponerImagenEscalada(CerrarRepaBot, "/imagenes/Apagar.png");
    

    List<Visitas> visitasFiltradas = Metodos.filtrarVisitasPorUsuario(usuarioLogueadoObj);
    modeloVisitas = new DefaultTableModel();
    Metodos.cargarVisitasEnTabla(VisitasTable, visitasFiltradas);

    // Tabla de contratos
    Contratos.cargarContratosEjemplo();
    modeloContratos = Metodos.generarContratos();
    ContratosTable.setModel(modeloContratos);


    
 

    // Tabla de usuarios
    modeloUsuario = Metodos.generarTablaUsuariosCompleta();
    UsuariosTable.setModel(modeloUsuario);

    // Poner íconos en botones de cerrar
    Metodos.ponerImagenEscalada(CerrarAdBot,  "/imagenes/Apagar.png");
    Metodos.ponerImagenEscalada(CerrarAgeBot, "/imagenes/Apagar.png");
    Metodos.ponerImagenEscalada(CerrarCliBot, "/imagenes/Apagar.png");
    Metodos.ponerImagenEscalada(CerrarProBot, "/imagenes/Apagar.png");
}
    
   private void cargarTablaPropiedadesSegunRol() {
    String rol = usuarioLogueadoObj.getCargo().toLowerCase();

    DefaultTableModel modelo = null;

    switch (rol) {
        case "administrador":
        case "agente":
            modelo = Metodos.generarModeloCasasTodas();
            break;

        case "cliente":
            modelo = Metodos.generarModeloCasasDisponibles();
            break;

        case "propietario":
            String propietarioId = usuarioLogueadoObj.getNombres(); // o getUsuario()
            modelo = Metodos.generarModeloCasasPorPropietario(propietarioId);
            break;

        default:
            modelo = new DefaultTableModel();
            break;
    }

    if (modelo != null) {
        PropiedadesTable.setModel(modelo);
    } else {
        System.out.println("Error: El modelo para la tabla de propiedades es null.");
    }
}
    //Leila actualizo el metodo para mostrar imagenes y elimino Systems innecesarios
  private void actualizarComboPropiedades() {
    ImagenesCombo.removeAllItems();
    for (Propiedades p : Propiedades.listaCasas) {
        ImagenesCombo.addItem(p.getId());
    }
}
    iniciosesion Devolver = new iniciosesion();
    public void actualizarTablaPagos() {
    PagosTable.setModel(Metodos.generarModeloPagosFiltrados(usuarioLogueadoObj));
}
   void mostrarPanelSegunCargo() {
    Usuarios cargo = Metodos.getCargo();

    if (cargo != null) {
       String nombreCargo = cargo.getCargo().toLowerCase();// ← CORREGIDO
        CardLayout cl = (CardLayout) AdminBotones.getLayout();

        switch (nombreCargo) {
            case "administrador":
                cl.show(AdminBotones, "Administrador");
                break;
            case "propietario":
                cl.show(AdminBotones, "Propietario");
                break;
            case "agente":
                cl.show(AdminBotones, "Agente");
                break;
            case "cliente":
                cl.show(AdminBotones, "Cliente");
        }
    }

}

   

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AdminBotones = new javax.swing.JPanel();
        RepAgeBotPan = new javax.swing.JPanel();
        ProDisAgeRepBot = new javax.swing.JButton();
        CliAgeRepBot = new javax.swing.JButton();
        VisAgeRepBot = new javax.swing.JButton();
        VolverAgeRepBot = new javax.swing.JButton();
        OpciAgeRepBot = new javax.swing.JButton();
        CerrarRepaBot = new javax.swing.JButton();
        ReportesBotPan = new javax.swing.JPanel();
        ProDispoRepBot = new javax.swing.JButton();
        IngresoComiRepBot = new javax.swing.JButton();
        ContVencerRepBot = new javax.swing.JButton();
        ProRegisRepBot = new javax.swing.JButton();
        ClientesRepBot = new javax.swing.JButton();
        VisitasRepBot = new javax.swing.JButton();
        ReportesBasicosRepBot = new javax.swing.JButton();
        OpcionesRepBot = new javax.swing.JButton();
        VolverRepBot = new javax.swing.JButton();
        CerrarRepAdBot = new javax.swing.JButton();
        AgeBotPan = new javax.swing.JPanel();
        SeguimientoAgeBot = new javax.swing.JButton();
        ClientesAgeBot = new javax.swing.JButton();
        VisitasAgeBot = new javax.swing.JButton();
        ArriendosAgeBot = new javax.swing.JButton();
        OpcionesAgeBot = new javax.swing.JButton();
        CerrarAgeBot = new javax.swing.JButton();
        ClientesBotPan = new javax.swing.JPanel();
        ContratosClieBot = new javax.swing.JButton();
        PropiedadesClieBot = new javax.swing.JButton();
        VisitasClieBot = new javax.swing.JButton();
        PagosClieBot = new javax.swing.JButton();
        OpcionesClieBot = new javax.swing.JButton();
        CerrarCliBot = new javax.swing.JButton();
        PropietarioBotPan = new javax.swing.JPanel();
        PropiedadesProBot = new javax.swing.JButton();
        VisitasProBot = new javax.swing.JButton();
        ContratosProBot = new javax.swing.JButton();
        PagosProBot = new javax.swing.JButton();
        OpcionesProBot = new javax.swing.JButton();
        CerrarProBot = new javax.swing.JButton();
        AdminBotPan = new javax.swing.JPanel();
        PropiedadesAdBot = new javax.swing.JButton();
        ClientesAdBot = new javax.swing.JButton();
        VisitasAdBot = new javax.swing.JButton();
        ContratosAdBot = new javax.swing.JButton();
        PagosAdBot = new javax.swing.JButton();
        ReportesAdBot = new javax.swing.JButton();
        UsuariosAdBot = new javax.swing.JButton();
        OpcionesAdBot = new javax.swing.JButton();
        CerrarAdBot = new javax.swing.JButton();
        ParentPan = new javax.swing.JPanel();
        VacioPan = new javax.swing.JPanel();
        PropImagenesPan = new javax.swing.JPanel();
        VolverProBot = new javax.swing.JButton();
        DetCasa = new javax.swing.JTextArea();
        ImagenesCombo = new javax.swing.JComboBox<>();
        ImagUnoLbl = new javax.swing.JLabel();
        VideoUnoLbl = new javax.swing.JLabel();
        ContratosPan = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ContratosTable = new javax.swing.JTable();
        EliminarConBot = new javax.swing.JButton();
        AgregarConBot = new javax.swing.JButton();
        ReportesPan = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        UsuariosPan = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        UsuariosTable = new javax.swing.JTable();
        ClientesPan = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ClientesTable = new javax.swing.JTable();
        EliminarCliBot = new javax.swing.JButton();
        PropiedadesPan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PropiedadesTable = new javax.swing.JTable();
        EliminarProBot = new javax.swing.JButton();
        AgregarProBot = new javax.swing.JButton();
        VerPropiBot = new javax.swing.JButton();
        PagosPan = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        PagosTable = new javax.swing.JTable();
        AgregarPagoBot = new javax.swing.JButton();
        VisitasPan = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        VisitasTable = new javax.swing.JTable();
        EliminarVisiBot = new javax.swing.JButton();
        AgregarVisiBot = new javax.swing.JButton();
        ReportesBasicosPan = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        ReportesBasicosTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AdminBotones.setOpaque(false);
        AdminBotones.setLayout(new java.awt.CardLayout());

        RepAgeBotPan.setBackground(new java.awt.Color(255, 204, 204));
        RepAgeBotPan.setOpaque(false);

        ProDisAgeRepBot.setText("Pro. Disponibilidad");
        ProDisAgeRepBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProDisAgeRepBotActionPerformed(evt);
            }
        });

        CliAgeRepBot.setText("Clientes");
        CliAgeRepBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CliAgeRepBotActionPerformed(evt);
            }
        });

        VisAgeRepBot.setText("Visitas");
        VisAgeRepBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisAgeRepBotActionPerformed(evt);
            }
        });

        VolverAgeRepBot.setText("Volver");
        VolverAgeRepBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverAgeRepBotActionPerformed(evt);
            }
        });

        OpciAgeRepBot.setText("Cerrar Sesion");
        OpciAgeRepBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpciAgeRepBotActionPerformed(evt);
            }
        });

        CerrarRepaBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarRepaBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RepAgeBotPanLayout = new javax.swing.GroupLayout(RepAgeBotPan);
        RepAgeBotPan.setLayout(RepAgeBotPanLayout);
        RepAgeBotPanLayout.setHorizontalGroup(
            RepAgeBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RepAgeBotPanLayout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(ProDisAgeRepBot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CliAgeRepBot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VisAgeRepBot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VolverAgeRepBot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OpciAgeRepBot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(CerrarRepaBot, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        RepAgeBotPanLayout.setVerticalGroup(
            RepAgeBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RepAgeBotPanLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(RepAgeBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProDisAgeRepBot, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CliAgeRepBot)
                    .addComponent(VisAgeRepBot)
                    .addComponent(VolverAgeRepBot)
                    .addComponent(OpciAgeRepBot, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RepAgeBotPanLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(CerrarRepaBot, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        AdminBotones.add(RepAgeBotPan, "card7");

        ReportesBotPan.setBackground(new java.awt.Color(204, 204, 255));
        ReportesBotPan.setOpaque(false);

        ProDispoRepBot.setText("Pro. disponibilidad");
        ProDispoRepBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProDispoRepBotActionPerformed(evt);
            }
        });

        IngresoComiRepBot.setText("Ingreso Comision");
        IngresoComiRepBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresoComiRepBotActionPerformed(evt);
            }
        });

        ContVencerRepBot.setText("Contratos por vencer");
        ContVencerRepBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContVencerRepBotActionPerformed(evt);
            }
        });

        ProRegisRepBot.setText("Pro. Registradas");
        ProRegisRepBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProRegisRepBotActionPerformed(evt);
            }
        });

        ClientesRepBot.setText("Clientes");
        ClientesRepBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesRepBotActionPerformed(evt);
            }
        });

        VisitasRepBot.setText("Visitas");
        VisitasRepBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisitasRepBotActionPerformed(evt);
            }
        });

        ReportesBasicosRepBot.setText("Reportes Basicos");
        ReportesBasicosRepBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportesBasicosRepBotActionPerformed(evt);
            }
        });

        OpcionesRepBot.setText("Cerrar Sesion");
        OpcionesRepBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionesRepBotActionPerformed(evt);
            }
        });

        VolverRepBot.setText("Volver");
        VolverRepBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverRepBotActionPerformed(evt);
            }
        });

        CerrarRepAdBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarRepAdBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ReportesBotPanLayout = new javax.swing.GroupLayout(ReportesBotPan);
        ReportesBotPan.setLayout(ReportesBotPanLayout);
        ReportesBotPanLayout.setHorizontalGroup(
            ReportesBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportesBotPanLayout.createSequentialGroup()
                .addGroup(ReportesBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReportesBotPanLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(IngresoComiRepBot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ReportesBasicosRepBot, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VolverRepBot, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OpcionesRepBot, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ReportesBotPanLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(ProDispoRepBot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ContVencerRepBot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProRegisRepBot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClientesRepBot, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VisitasRepBot)))
                .addGap(30, 30, 30)
                .addComponent(CerrarRepAdBot, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        ReportesBotPanLayout.setVerticalGroup(
            ReportesBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportesBotPanLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(ReportesBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReportesBotPanLayout.createSequentialGroup()
                        .addComponent(CerrarRepAdBot, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ReportesBotPanLayout.createSequentialGroup()
                        .addGroup(ReportesBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProDispoRepBot)
                            .addComponent(ContVencerRepBot)
                            .addComponent(ProRegisRepBot)
                            .addComponent(ClientesRepBot)
                            .addComponent(VisitasRepBot))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ReportesBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IngresoComiRepBot)
                            .addComponent(ReportesBasicosRepBot)
                            .addComponent(VolverRepBot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(OpcionesRepBot))
                        .addGap(44, 44, 44))))
        );

        AdminBotones.add(ReportesBotPan, "card6");

        AgeBotPan.setBackground(new java.awt.Color(204, 204, 255));
        AgeBotPan.setOpaque(false);

        SeguimientoAgeBot.setText("Seguimiento");
        SeguimientoAgeBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeguimientoAgeBotActionPerformed(evt);
            }
        });

        ClientesAgeBot.setText("Mis Clientes");
        ClientesAgeBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesAgeBotActionPerformed(evt);
            }
        });

        VisitasAgeBot.setText("Visitas");
        VisitasAgeBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisitasAgeBotActionPerformed(evt);
            }
        });

        ArriendosAgeBot.setText("Arriendos");
        ArriendosAgeBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArriendosAgeBotActionPerformed(evt);
            }
        });

        OpcionesAgeBot.setText("Cerrar Sesion");
        OpcionesAgeBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionesAgeBotActionPerformed(evt);
            }
        });

        CerrarAgeBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarAgeBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AgeBotPanLayout = new javax.swing.GroupLayout(AgeBotPan);
        AgeBotPan.setLayout(AgeBotPanLayout);
        AgeBotPanLayout.setHorizontalGroup(
            AgeBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgeBotPanLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(ArriendosAgeBot)
                .addGap(18, 18, 18)
                .addComponent(VisitasAgeBot)
                .addGap(18, 18, 18)
                .addComponent(ClientesAgeBot)
                .addGap(18, 18, 18)
                .addComponent(SeguimientoAgeBot)
                .addGap(18, 18, 18)
                .addComponent(OpcionesAgeBot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(CerrarAgeBot, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        AgeBotPanLayout.setVerticalGroup(
            AgeBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgeBotPanLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(AgeBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeguimientoAgeBot)
                    .addComponent(ClientesAgeBot)
                    .addComponent(VisitasAgeBot)
                    .addComponent(ArriendosAgeBot)
                    .addComponent(OpcionesAgeBot)
                    .addComponent(CerrarAgeBot, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        AdminBotones.add(AgeBotPan, "agente");

        ClientesBotPan.setBackground(new java.awt.Color(0, 51, 51));
        ClientesBotPan.setOpaque(false);

        ContratosClieBot.setText("Mis Contratos");
        ContratosClieBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContratosClieBotActionPerformed(evt);
            }
        });

        PropiedadesClieBot.setText("Buscar Propiedades");
        PropiedadesClieBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropiedadesClieBotActionPerformed(evt);
            }
        });

        VisitasClieBot.setText("Visitas");
        VisitasClieBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisitasClieBotActionPerformed(evt);
            }
        });

        PagosClieBot.setText("Pagos");
        PagosClieBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagosClieBotActionPerformed(evt);
            }
        });

        OpcionesClieBot.setText("Cerrar Sesion");
        OpcionesClieBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionesClieBotActionPerformed(evt);
            }
        });

        CerrarCliBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarCliBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ClientesBotPanLayout = new javax.swing.GroupLayout(ClientesBotPan);
        ClientesBotPan.setLayout(ClientesBotPanLayout);
        ClientesBotPanLayout.setHorizontalGroup(
            ClientesBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClientesBotPanLayout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addComponent(PropiedadesClieBot)
                .addGap(18, 18, 18)
                .addComponent(VisitasClieBot)
                .addGap(18, 18, 18)
                .addComponent(ContratosClieBot)
                .addGap(18, 18, 18)
                .addComponent(PagosClieBot)
                .addGap(18, 18, 18)
                .addComponent(OpcionesClieBot, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(CerrarCliBot, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        ClientesBotPanLayout.setVerticalGroup(
            ClientesBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientesBotPanLayout.createSequentialGroup()
                .addGroup(ClientesBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ClientesBotPanLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(ClientesBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ContratosClieBot)
                            .addComponent(PropiedadesClieBot)
                            .addComponent(VisitasClieBot)
                            .addComponent(PagosClieBot)
                            .addComponent(OpcionesClieBot, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ClientesBotPanLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(CerrarCliBot, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        AdminBotones.add(ClientesBotPan, "visitante");

        PropietarioBotPan.setBackground(new java.awt.Color(51, 255, 102));
        PropietarioBotPan.setOpaque(false);

        PropiedadesProBot.setText("Mis Propiedades");
        PropiedadesProBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropiedadesProBotActionPerformed(evt);
            }
        });

        VisitasProBot.setText("Visitas");
        VisitasProBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisitasProBotActionPerformed(evt);
            }
        });

        ContratosProBot.setText("Contratos");
        ContratosProBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContratosProBotActionPerformed(evt);
            }
        });

        PagosProBot.setText("Pagos");
        PagosProBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagosProBotActionPerformed(evt);
            }
        });

        OpcionesProBot.setText("Cerrar Sesion");
        OpcionesProBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionesProBotActionPerformed(evt);
            }
        });

        CerrarProBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarProBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PropietarioBotPanLayout = new javax.swing.GroupLayout(PropietarioBotPan);
        PropietarioBotPan.setLayout(PropietarioBotPanLayout);
        PropietarioBotPanLayout.setHorizontalGroup(
            PropietarioBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PropietarioBotPanLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(PropiedadesProBot)
                .addGap(18, 18, 18)
                .addComponent(VisitasProBot)
                .addGap(18, 18, 18)
                .addComponent(ContratosProBot)
                .addGap(18, 18, 18)
                .addComponent(PagosProBot)
                .addGap(18, 18, 18)
                .addComponent(OpcionesProBot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(CerrarProBot, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        PropietarioBotPanLayout.setVerticalGroup(
            PropietarioBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PropietarioBotPanLayout.createSequentialGroup()
                .addGroup(PropietarioBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PropietarioBotPanLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(PropietarioBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PropiedadesProBot)
                            .addComponent(VisitasProBot)
                            .addComponent(ContratosProBot)
                            .addComponent(PagosProBot)
                            .addComponent(OpcionesProBot, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PropietarioBotPanLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(CerrarProBot, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        AdminBotones.add(PropietarioBotPan, "propietario");

        AdminBotPan.setBackground(new java.awt.Color(102, 102, 255));
        AdminBotPan.setOpaque(false);

        PropiedadesAdBot.setText("Propiedades");
        PropiedadesAdBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropiedadesAdBotActionPerformed(evt);
            }
        });

        ClientesAdBot.setText("Clientes");
        ClientesAdBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesAdBotActionPerformed(evt);
            }
        });

        VisitasAdBot.setText("Visitas");
        VisitasAdBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisitasAdBotActionPerformed(evt);
            }
        });

        ContratosAdBot.setText("Contratos");
        ContratosAdBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContratosAdBotActionPerformed(evt);
            }
        });

        PagosAdBot.setText("Pagos");
        PagosAdBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagosAdBotActionPerformed(evt);
            }
        });

        ReportesAdBot.setText("Reportes");
        ReportesAdBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportesAdBotActionPerformed(evt);
            }
        });

        UsuariosAdBot.setText("Usuarios");
        UsuariosAdBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuariosAdBotActionPerformed(evt);
            }
        });

        OpcionesAdBot.setText("Cerrar Sesion");
        OpcionesAdBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionesAdBotActionPerformed(evt);
            }
        });

        CerrarAdBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarAdBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdminBotPanLayout = new javax.swing.GroupLayout(AdminBotPan);
        AdminBotPan.setLayout(AdminBotPanLayout);
        AdminBotPanLayout.setHorizontalGroup(
            AdminBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminBotPanLayout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addGroup(AdminBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AdminBotPanLayout.createSequentialGroup()
                        .addComponent(UsuariosAdBot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OpcionesAdBot))
                    .addGroup(AdminBotPanLayout.createSequentialGroup()
                        .addComponent(PropiedadesAdBot)
                        .addGap(18, 18, 18)
                        .addComponent(ClientesAdBot)
                        .addGap(18, 18, 18)
                        .addComponent(VisitasAdBot)
                        .addGap(18, 18, 18)
                        .addComponent(ContratosAdBot)))
                .addGap(18, 18, 18)
                .addComponent(PagosAdBot)
                .addGap(18, 18, 18)
                .addComponent(ReportesAdBot)
                .addGap(30, 30, 30)
                .addComponent(CerrarAdBot, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        AdminBotPanLayout.setVerticalGroup(
            AdminBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminBotPanLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(AdminBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CerrarAdBot, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AdminBotPanLayout.createSequentialGroup()
                        .addGroup(AdminBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PropiedadesAdBot)
                            .addComponent(ClientesAdBot)
                            .addComponent(VisitasAdBot)
                            .addComponent(ContratosAdBot)
                            .addComponent(PagosAdBot)
                            .addComponent(ReportesAdBot))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AdminBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OpcionesAdBot, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UsuariosAdBot))))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        AdminBotones.add(AdminBotPan, "admin");

        getContentPane().add(AdminBotones, java.awt.BorderLayout.PAGE_START);

        ParentPan.setOpaque(false);
        ParentPan.setLayout(new java.awt.CardLayout());

        VacioPan.setOpaque(false);

        javax.swing.GroupLayout VacioPanLayout = new javax.swing.GroupLayout(VacioPan);
        VacioPan.setLayout(VacioPanLayout);
        VacioPanLayout.setHorizontalGroup(
            VacioPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 834, Short.MAX_VALUE)
        );
        VacioPanLayout.setVerticalGroup(
            VacioPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        ParentPan.add(VacioPan, "card12");

        PropImagenesPan.setOpaque(false);

        VolverProBot.setText("Volver");
        VolverProBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverProBotActionPerformed(evt);
            }
        });

        DetCasa.setColumns(20);
        DetCasa.setRows(5);
        DetCasa.setEnabled(false);

        ImagenesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImagenesComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PropImagenesPanLayout = new javax.swing.GroupLayout(PropImagenesPan);
        PropImagenesPan.setLayout(PropImagenesPanLayout);
        PropImagenesPanLayout.setHorizontalGroup(
            PropImagenesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PropImagenesPanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VolverProBot)
                .addGap(97, 97, 97))
            .addGroup(PropImagenesPanLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(ImagUnoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PropImagenesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ImagenesCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DetCasa, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(VideoUnoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        PropImagenesPanLayout.setVerticalGroup(
            PropImagenesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PropImagenesPanLayout.createSequentialGroup()
                .addGroup(PropImagenesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PropImagenesPanLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ImagUnoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PropImagenesPanLayout.createSequentialGroup()
                        .addContainerGap(90, Short.MAX_VALUE)
                        .addGroup(PropImagenesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DetCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VideoUnoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(56, 56, 56)
                .addComponent(ImagenesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(VolverProBot)
                .addGap(58, 58, 58))
        );

        ParentPan.add(PropImagenesPan, "card10");

        ContratosPan.setOpaque(false);

        ContratosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tipo", "Propiedad", "Cliente", "Agente", "Estado", "Valor", "Inicio", "Fin", "Dias Restantes"
            }
        ));
        jScrollPane4.setViewportView(ContratosTable);
        if (ContratosTable.getColumnModel().getColumnCount() > 0) {
            ContratosTable.getColumnModel().getColumn(1).setResizable(false);
        }

        EliminarConBot.setText("Eliminar Datos");
        EliminarConBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarConBotActionPerformed(evt);
            }
        });

        AgregarConBot.setText("Agregar contrato");
        AgregarConBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarConBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContratosPanLayout = new javax.swing.GroupLayout(ContratosPan);
        ContratosPan.setLayout(ContratosPanLayout);
        ContratosPanLayout.setHorizontalGroup(
            ContratosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContratosPanLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContratosPanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EliminarConBot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AgregarConBot)
                .addGap(323, 323, 323))
        );
        ContratosPanLayout.setVerticalGroup(
            ContratosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContratosPanLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ContratosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EliminarConBot)
                    .addComponent(AgregarConBot))
                .addGap(27, 27, 27))
        );

        ParentPan.add(ContratosPan, "card8");

        ReportesPan.setOpaque(false);

        jButton24.setText("Guardar");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setText("Editar");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton7.setText("Agregar");

        javax.swing.GroupLayout ReportesPanLayout = new javax.swing.GroupLayout(ReportesPan);
        ReportesPan.setLayout(ReportesPanLayout);
        ReportesPanLayout.setHorizontalGroup(
            ReportesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportesPanLayout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jButton25)
                .addGap(29, 29, 29)
                .addComponent(jButton24)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addContainerGap(296, Short.MAX_VALUE))
        );
        ReportesPanLayout.setVerticalGroup(
            ReportesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportesPanLayout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addGroup(ReportesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton25)
                    .addComponent(jButton24)
                    .addComponent(jButton7))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        ParentPan.add(ReportesPan, "card7");

        UsuariosPan.setOpaque(false);

        UsuariosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Contraseña", "Nombres", "Apellidos", "Cargo"
            }
        ));
        jScrollPane5.setViewportView(UsuariosTable);

        javax.swing.GroupLayout UsuariosPanLayout = new javax.swing.GroupLayout(UsuariosPan);
        UsuariosPan.setLayout(UsuariosPanLayout);
        UsuariosPanLayout.setHorizontalGroup(
            UsuariosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsuariosPanLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );
        UsuariosPanLayout.setVerticalGroup(
            UsuariosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UsuariosPanLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        ParentPan.add(UsuariosPan, "card6");

        ClientesPan.setOpaque(false);

        ClientesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombres", "Apellidos", "Correo", "Telefono", "Cedula", "Propiedades"
            }
        ));
        jScrollPane2.setViewportView(ClientesTable);

        EliminarCliBot.setText("Eliminar");
        EliminarCliBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCliBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ClientesPanLayout = new javax.swing.GroupLayout(ClientesPan);
        ClientesPan.setLayout(ClientesPanLayout);
        ClientesPanLayout.setHorizontalGroup(
            ClientesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientesPanLayout.createSequentialGroup()
                .addGroup(ClientesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ClientesPanLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ClientesPanLayout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(EliminarCliBot)))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        ClientesPanLayout.setVerticalGroup(
            ClientesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientesPanLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EliminarCliBot)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        ParentPan.add(ClientesPan, "card2");

        PropiedadesPan.setOpaque(false);

        PropiedadesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", null, null, null, null, null},
                {"", "", null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tipo", "Ubicación", "Área", "Precio", "Estado", "Propietario"
            }
        ));
        jScrollPane1.setViewportView(PropiedadesTable);

        EliminarProBot.setText("Eliminar Datos");
        EliminarProBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarProBotActionPerformed(evt);
            }
        });

        AgregarProBot.setText("Agregar");
        AgregarProBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarProBotActionPerformed(evt);
            }
        });

        VerPropiBot.setText("Ver Propiedades");
        VerPropiBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerPropiBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PropiedadesPanLayout = new javax.swing.GroupLayout(PropiedadesPan);
        PropiedadesPan.setLayout(PropiedadesPanLayout);
        PropiedadesPanLayout.setHorizontalGroup(
            PropiedadesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PropiedadesPanLayout.createSequentialGroup()
                .addGroup(PropiedadesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PropiedadesPanLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PropiedadesPanLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(EliminarProBot)
                        .addGap(18, 18, 18)
                        .addComponent(AgregarProBot)
                        .addGap(18, 18, 18)
                        .addComponent(VerPropiBot)))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        PropiedadesPanLayout.setVerticalGroup(
            PropiedadesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PropiedadesPanLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PropiedadesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EliminarProBot)
                    .addComponent(AgregarProBot)
                    .addComponent(VerPropiBot))
                .addGap(13, 13, 13))
        );

        ParentPan.add(PropiedadesPan, "card5");

        PagosPan.setBackground(new java.awt.Color(51, 255, 102));
        PagosPan.setOpaque(false);

        PagosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID de Pago", "Motivo Pago", "Propiedad", "Cliente", "Monto", "Estado", "Método de pago", "Agente"
            }
        ));
        jScrollPane6.setViewportView(PagosTable);

        AgregarPagoBot.setText("Agregar");
        AgregarPagoBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarPagoBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PagosPanLayout = new javax.swing.GroupLayout(PagosPan);
        PagosPan.setLayout(PagosPanLayout);
        PagosPanLayout.setHorizontalGroup(
            PagosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PagosPanLayout.createSequentialGroup()
                .addGroup(PagosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PagosPanLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PagosPanLayout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(AgregarPagoBot)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        PagosPanLayout.setVerticalGroup(
            PagosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PagosPanLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AgregarPagoBot)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        ParentPan.add(PagosPan, "card4");

        VisitasPan.setOpaque(false);

        VisitasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Visita", "Fecha", "Dia", "Agente", "Cliente", "Arriendos", "Estado"
            }
        ));
        jScrollPane7.setViewportView(VisitasTable);

        EliminarVisiBot.setText("Eliminar Datos");
        EliminarVisiBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarVisiBotActionPerformed(evt);
            }
        });

        AgregarVisiBot.setText("Agregar");
        AgregarVisiBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarVisiBotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout VisitasPanLayout = new javax.swing.GroupLayout(VisitasPan);
        VisitasPan.setLayout(VisitasPanLayout);
        VisitasPanLayout.setHorizontalGroup(
            VisitasPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VisitasPanLayout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
            .addGroup(VisitasPanLayout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(EliminarVisiBot)
                .addGap(18, 18, 18)
                .addComponent(AgregarVisiBot)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        VisitasPanLayout.setVerticalGroup(
            VisitasPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VisitasPanLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(VisitasPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EliminarVisiBot)
                    .addComponent(AgregarVisiBot))
                .addGap(13, 13, 13))
        );

        ParentPan.add(VisitasPan, "card3");

        ReportesBasicosPan.setOpaque(false);

        ReportesBasicosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Propiedad", "Cliente", "Agente", "Valor Venta", "Comision", "Ingreso Neto"
            }
        ));
        jScrollPane8.setViewportView(ReportesBasicosTable);

        javax.swing.GroupLayout ReportesBasicosPanLayout = new javax.swing.GroupLayout(ReportesBasicosPan);
        ReportesBasicosPan.setLayout(ReportesBasicosPanLayout);
        ReportesBasicosPanLayout.setHorizontalGroup(
            ReportesBasicosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportesBasicosPanLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        ReportesBasicosPanLayout.setVerticalGroup(
            ReportesBasicosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReportesBasicosPanLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        ParentPan.add(ReportesBasicosPan, "card9");

        getContentPane().add(ParentPan, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClientesAdBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesAdBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(ClientesPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_ClientesAdBotActionPerformed

    private void PropiedadesAdBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropiedadesAdBotActionPerformed

cargarTablaPropiedadesSegunRol();
        ParentPan.removeAll();
        ParentPan.add(PropiedadesPan);
        ParentPan.repaint();
        ParentPan.revalidate();
        Metodos.mostrarColumnasOcultas(PropiedadesTable);
        
    }//GEN-LAST:event_PropiedadesAdBotActionPerformed

    private void VisitasAdBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisitasAdBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(VisitasPan);
        ParentPan.repaint();
        ParentPan.revalidate();
        
    }//GEN-LAST:event_VisitasAdBotActionPerformed

    private void ContratosAdBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContratosAdBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(ContratosPan);
        ParentPan.repaint();
        ParentPan.revalidate();
        Metodos.mostrarSoloColumnas(ContratosTable,new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
    }//GEN-LAST:event_ContratosAdBotActionPerformed

    private void PagosAdBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagosAdBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(PagosPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_PagosAdBotActionPerformed

    private void ReportesAdBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportesAdBotActionPerformed
        AdminBotones.removeAll();
        AdminBotones.add(ReportesBotPan);
        AdminBotones.repaint();
        AdminBotones.revalidate();
    }//GEN-LAST:event_ReportesAdBotActionPerformed

    private void UsuariosAdBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosAdBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(UsuariosPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_UsuariosAdBotActionPerformed

    private void EliminarProBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarProBotActionPerformed
int fila = PropiedadesTable.getSelectedRow();
    if (fila >= 0) {
        // Eliminar de la lista
        Propiedades.listaCasas.remove(fila);
        
        // Eliminar de la tabla
        DefaultTableModel modelo = (DefaultTableModel) PropiedadesTable.getModel();
        modelo.removeRow(fila);
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
    }
    }//GEN-LAST:event_EliminarProBotActionPerformed

    private void EliminarConBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarConBotActionPerformed
    int fila = ContratosTable.getSelectedRow();
    if (fila >= 0) {
        // Eliminar de la lista
        Contratos.listaContratos.remove(fila);
        
        // Eliminar de la tabla
        DefaultTableModel modelo = (DefaultTableModel) ContratosTable.getModel();
        modelo.removeRow(fila);
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
    }
    }//GEN-LAST:event_EliminarConBotActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void EliminarCliBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarCliBotActionPerformed
      int fila = ClientesTable.getSelectedRow();
    if (fila >= 0) {
        // Eliminar de la lista
        Clientes.listaClientes.remove(fila);
        
        // Eliminar de la tabla
        DefaultTableModel modelo = (DefaultTableModel) ClientesTable.getModel();
        modelo.removeRow(fila);
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");}
    }//GEN-LAST:event_EliminarCliBotActionPerformed

    private void EliminarVisiBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarVisiBotActionPerformed
        int fila = VisitasTable.getSelectedRow();
    if (fila >= 0) {
        // Eliminar de la lista
        Visitas.listaVisitas.remove(fila);
        
        // Eliminar de la tabla
        DefaultTableModel modelo = (DefaultTableModel) VisitasTable.getModel();
        modelo.removeRow(fila);
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
    }
    }//GEN-LAST:event_EliminarVisiBotActionPerformed

    private void OpcionesAdBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionesAdBotActionPerformed
    
    Devolver.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_OpcionesAdBotActionPerformed

    private void OpcionesProBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionesProBotActionPerformed
        
    Devolver.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_OpcionesProBotActionPerformed

    private void OpcionesClieBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionesClieBotActionPerformed
        
    Devolver.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_OpcionesClieBotActionPerformed

    private void OpcionesAgeBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionesAgeBotActionPerformed
        
    Devolver.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_OpcionesAgeBotActionPerformed

    private void PropiedadesProBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropiedadesProBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(PropiedadesPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_PropiedadesProBotActionPerformed

    private void ArriendosAgeBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArriendosAgeBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(PropiedadesPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_ArriendosAgeBotActionPerformed

    private void VisitasAgeBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisitasAgeBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(VisitasPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_VisitasAgeBotActionPerformed

    private void ClientesAgeBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesAgeBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(ClientesPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_ClientesAgeBotActionPerformed

    private void SeguimientoAgeBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeguimientoAgeBotActionPerformed
        AdminBotones.removeAll();
        AdminBotones.add(RepAgeBotPan);
        AdminBotones.repaint();
        AdminBotones.revalidate();
    }//GEN-LAST:event_SeguimientoAgeBotActionPerformed

    private void PropiedadesClieBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropiedadesClieBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(PropiedadesPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_PropiedadesClieBotActionPerformed

    private void VisitasClieBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisitasClieBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(VisitasPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_VisitasClieBotActionPerformed

    private void ContratosClieBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContratosClieBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(ContratosPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_ContratosClieBotActionPerformed

    private void PagosClieBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagosClieBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(PagosPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_PagosClieBotActionPerformed

    private void VisitasProBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisitasProBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(VisitasPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_VisitasProBotActionPerformed

    private void ContratosProBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContratosProBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(ContratosPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_ContratosProBotActionPerformed

    private void PagosProBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagosProBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(PagosPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_PagosProBotActionPerformed

    private void ProDisAgeRepBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProDisAgeRepBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(PropiedadesPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_ProDisAgeRepBotActionPerformed

    private void CliAgeRepBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CliAgeRepBotActionPerformed

        ParentPan.removeAll();
        ParentPan.add(ClientesPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_CliAgeRepBotActionPerformed

    private void VisAgeRepBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisAgeRepBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(VisitasPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_VisAgeRepBotActionPerformed

    private void VolverAgeRepBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverAgeRepBotActionPerformed
        AdminBotones.removeAll();
        AdminBotones.add(AgeBotPan);
        AdminBotones.repaint();
        AdminBotones.revalidate();
    }//GEN-LAST:event_VolverAgeRepBotActionPerformed

    private void OpciAgeRepBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpciAgeRepBotActionPerformed
        
    Devolver.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_OpciAgeRepBotActionPerformed

    private void ProDispoRepBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProDispoRepBotActionPerformed
    ParentPan.removeAll();
    ParentPan.add(PropiedadesPan);
    ParentPan.repaint();
    ParentPan.revalidate();
Metodos.mostrarSoloColumnas(PropiedadesTable, new int[]{0, 5});   
    }//GEN-LAST:event_ProDispoRepBotActionPerformed

    private void IngresoComiRepBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresoComiRepBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(ReportesBasicosPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_IngresoComiRepBotActionPerformed

    private void ContVencerRepBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContVencerRepBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(ContratosPan);
        ParentPan.repaint();
        ParentPan.revalidate();
        Metodos.mostrarColumnasOcultas(ContratosTable);
    }//GEN-LAST:event_ContVencerRepBotActionPerformed

    private void ProRegisRepBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProRegisRepBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(PropiedadesPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_ProRegisRepBotActionPerformed

    private void ClientesRepBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesRepBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(ClientesPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_ClientesRepBotActionPerformed

    private void VisitasRepBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisitasRepBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(VisitasPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_VisitasRepBotActionPerformed

    private void ReportesBasicosRepBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportesBasicosRepBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(ReportesBasicosPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_ReportesBasicosRepBotActionPerformed

    private void VolverRepBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverRepBotActionPerformed
        AdminBotones.removeAll();
        AdminBotones.add(AdminBotPan);
        AdminBotones.repaint();
        AdminBotones.revalidate();
    }//GEN-LAST:event_VolverRepBotActionPerformed

    private void OpcionesRepBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionesRepBotActionPerformed
        Devolver.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_OpcionesRepBotActionPerformed

    private void VerPropiBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerPropiBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(PropImagenesPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_VerPropiBotActionPerformed

    private void VolverProBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverProBotActionPerformed
        ParentPan.removeAll();
        ParentPan.add(PropiedadesPan);
        ParentPan.repaint();
        ParentPan.revalidate();
    }//GEN-LAST:event_VolverProBotActionPerformed

    private void ImagenesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImagenesComboActionPerformed
String idSeleccionado = (String) ImagenesCombo.getSelectedItem();

    // Limpiar todo al inicio
    DetCasa.setText("");
    ImagUnoLbl.setIcon(null);
    VideoUnoLbl.setIcon(null);

    // Validar selección
    if (idSeleccionado == null || idSeleccionado.equals("-- Seleccione una propiedad --")) {
        return;
    }

    // Buscar propiedad seleccionada
    for (Propiedades p : Propiedades.listaCasas) {
        if (p.getId().equals(idSeleccionado)) {
            // Mostrar descripción
            DetCasa.setText(p.getDescripcion());

            // Cargar imagen principal
            cargarImagen(p.getRuta(), ImagUnoLbl, "imagen de la propiedad");

            // Cargar GIF solo si tiene ruta definida
            if (p.getRutaGif() != null && !p.getRutaGif().isEmpty()) {
                cargarGif(p.getRutaGif(), VideoUnoLbl);
            }
            break;
        }
    }
}

private void cargarImagen(String ruta, JLabel label, String tipoImagen) {
    if (ruta == null || ruta.isEmpty()) {
        label.setIcon(null);
        JOptionPane.showMessageDialog(this,
            "No se ha especificado una ruta para la " + tipoImagen,
            tipoImagen + " no disponible",
            JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    try {
        ImageIcon icono;
        if (ruta.startsWith("/")) {
            URL url = getClass().getResource(ruta);
            if (url != null) {
                icono = new ImageIcon(url);
            } else {
                // Intentar cargar como archivo si no se encuentra como recurso
                File imgFile = new File(ruta.substring(1));
                if (imgFile.exists()) {
                    icono = new ImageIcon(imgFile.getAbsolutePath());
                } else {
                    throw new FileNotFoundException("No se encontró el recurso: " + ruta);
                }
            }
        } else {
            File imgFile = new File(ruta);
            if (imgFile.exists()) {
                icono = new ImageIcon(ruta);
            } else {
                throw new FileNotFoundException("No se encontró el archivo: " + ruta);
            }
        }

        if (icono.getImage() != null) {
            Image img = icono.getImage().getScaledInstance(
                label.getWidth(), 
                label.getHeight(), 
                Image.SCALE_SMOOTH
            );
            label.setIcon(new ImageIcon(img));
        }
    } catch (Exception e) {
        label.setIcon(null);
        JOptionPane.showMessageDialog(this,
            "Error al cargar la " + tipoImagen + ":\n" + e.getMessage(),
            "Error",
            JOptionPane.WARNING_MESSAGE);
    }
}

private void cargarGif(String ruta, JLabel label) {
    try {
        // Eliminar barras diagonales adicionales
        ruta = ruta.replaceAll("/+$", "");
        
        ImageIcon gifIcon;
        if (ruta.startsWith("/")) {
            URL gifUrl = getClass().getResource(ruta);
            if (gifUrl == null) {
                throw new FileNotFoundException("No se encontró el GIF en: " + ruta);
            }
            gifIcon = new ImageIcon(gifUrl);
        } else {
            File gifFile = new File(ruta);
            if (!gifFile.exists()) {
                throw new FileNotFoundException("No se encontró el archivo GIF: " + ruta);
            }
            gifIcon = new ImageIcon(ruta);
        }

        // No escalar el GIF para mantener la animación
        label.setIcon(gifIcon);
        
    } catch (Exception e) {
        label.setIcon(null);
        JOptionPane.showMessageDialog(this,
            "Error al cargar el GIF:\n" + e.getMessage(),
            "Error en GIF",
            JOptionPane.WARNING_MESSAGE);
    }
  

    }//GEN-LAST:event_ImagenesComboActionPerformed

    private void AgregarVisiBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarVisiBotActionPerformed
 String user = iniciosesion.usuarioLogueado;

    // 1. Agregamos la visita
    Metodos.agendarVisita(user, VisitasTable);

    // 2. Volvemos a cargar todas las visitas si el filtro falla
    if (usuarioLogueadoObj != null) {
        List<Visitas> visitasFiltradas = Metodos.filtrarVisitasPorUsuario(usuarioLogueadoObj);
        Metodos.cargarVisitasEnTabla(VisitasTable, visitasFiltradas);
    } else {
        JOptionPane.showMessageDialog(this, "Error: usuario no encontrado.");
        Metodos.cargarVisitasEnTabla(VisitasTable, listaVisitas); // Carga todo como emergencia
    }
    }//GEN-LAST:event_AgregarVisiBotActionPerformed

    private void AgregarConBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarConBotActionPerformed
       String usuarioActual = iniciosesion.usuarioLogueado;
    Metodos.crearContrato(usuarioActual);
    actualizarTablaContratos();}
    private void actualizarTablaContratos() {
    ContratosTable.setModel(Metodos.generarContratos());

    }//GEN-LAST:event_AgregarConBotActionPerformed

    private void AgregarPagoBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPagoBotActionPerformed
     Metodos.crearPago(usuarioLogueado);
actualizarTablaPagos();// usuarioActual es del tipo Usuarios


    }//GEN-LAST:event_AgregarPagoBotActionPerformed

    private void CerrarCliBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarCliBotActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CerrarCliBotActionPerformed

    private void CerrarAdBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarAdBotActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CerrarAdBotActionPerformed

    private void CerrarProBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarProBotActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CerrarProBotActionPerformed

    private void CerrarAgeBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarAgeBotActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CerrarAgeBotActionPerformed

    private void CerrarRepaBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarRepaBotActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CerrarRepaBotActionPerformed

    private void CerrarRepAdBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarRepAdBotActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CerrarRepAdBotActionPerformed

    private void AgregarProBotActionPerformed(java.awt.event.ActionEvent evt) {                                              
 // Leila agrego un metodo para pedir los datos al usuario
      Metodos.agregarNuevaPropiedadConImagen(PropiedadesTable, ImagenesCombo, ImagUnoLbl, VideoUnoLbl);
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdminBotPan;
    public javax.swing.JPanel AdminBotones;
    private javax.swing.JPanel AgeBotPan;
    private javax.swing.JButton AgregarConBot;
    private javax.swing.JButton AgregarPagoBot;
    private javax.swing.JButton AgregarProBot;
    private javax.swing.JButton AgregarVisiBot;
    private javax.swing.JButton ArriendosAgeBot;
    private javax.swing.JButton CerrarAdBot;
    private javax.swing.JButton CerrarAgeBot;
    private javax.swing.JButton CerrarCliBot;
    private javax.swing.JButton CerrarProBot;
    private javax.swing.JButton CerrarRepAdBot;
    private javax.swing.JButton CerrarRepaBot;
    private javax.swing.JButton CliAgeRepBot;
    private javax.swing.JButton ClientesAdBot;
    private javax.swing.JButton ClientesAgeBot;
    private javax.swing.JPanel ClientesBotPan;
    private javax.swing.JPanel ClientesPan;
    private javax.swing.JButton ClientesRepBot;
    private javax.swing.JTable ClientesTable;
    private javax.swing.JButton ContVencerRepBot;
    private javax.swing.JButton ContratosAdBot;
    private javax.swing.JButton ContratosClieBot;
    private javax.swing.JPanel ContratosPan;
    private javax.swing.JButton ContratosProBot;
    private javax.swing.JTable ContratosTable;
    private javax.swing.JTextArea DetCasa;
    private javax.swing.JButton EliminarCliBot;
    private javax.swing.JButton EliminarConBot;
    private javax.swing.JButton EliminarProBot;
    private javax.swing.JButton EliminarVisiBot;
    private javax.swing.JLabel ImagUnoLbl;
    private javax.swing.JComboBox<String> ImagenesCombo;
    private javax.swing.JButton IngresoComiRepBot;
    private javax.swing.JButton OpciAgeRepBot;
    private javax.swing.JButton OpcionesAdBot;
    private javax.swing.JButton OpcionesAgeBot;
    private javax.swing.JButton OpcionesClieBot;
    private javax.swing.JButton OpcionesProBot;
    private javax.swing.JButton OpcionesRepBot;
    private javax.swing.JButton PagosAdBot;
    private javax.swing.JButton PagosClieBot;
    private javax.swing.JPanel PagosPan;
    private javax.swing.JButton PagosProBot;
    private javax.swing.JTable PagosTable;
    private javax.swing.JPanel ParentPan;
    private javax.swing.JButton ProDisAgeRepBot;
    private javax.swing.JButton ProDispoRepBot;
    private javax.swing.JButton ProRegisRepBot;
    private javax.swing.JPanel PropImagenesPan;
    private javax.swing.JButton PropiedadesAdBot;
    private javax.swing.JButton PropiedadesClieBot;
    private javax.swing.JPanel PropiedadesPan;
    private javax.swing.JButton PropiedadesProBot;
    private javax.swing.JTable PropiedadesTable;
    private javax.swing.JPanel PropietarioBotPan;
    private javax.swing.JPanel RepAgeBotPan;
    private javax.swing.JButton ReportesAdBot;
    private javax.swing.JPanel ReportesBasicosPan;
    private javax.swing.JButton ReportesBasicosRepBot;
    private javax.swing.JTable ReportesBasicosTable;
    private javax.swing.JPanel ReportesBotPan;
    private javax.swing.JPanel ReportesPan;
    private javax.swing.JButton SeguimientoAgeBot;
    private javax.swing.JButton UsuariosAdBot;
    private javax.swing.JPanel UsuariosPan;
    private javax.swing.JTable UsuariosTable;
    private javax.swing.JPanel VacioPan;
    private javax.swing.JButton VerPropiBot;
    private javax.swing.JLabel VideoUnoLbl;
    private javax.swing.JButton VisAgeRepBot;
    private javax.swing.JButton VisitasAdBot;
    private javax.swing.JButton VisitasAgeBot;
    private javax.swing.JButton VisitasClieBot;
    private javax.swing.JPanel VisitasPan;
    private javax.swing.JButton VisitasProBot;
    private javax.swing.JButton VisitasRepBot;
    private javax.swing.JTable VisitasTable;
    private javax.swing.JButton VolverAgeRepBot;
    private javax.swing.JButton VolverProBot;
    private javax.swing.JButton VolverRepBot;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    // End of variables declaration//GEN-END:variables
class FondoPanel extends JPanel {
    private Image imagen;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        imagen = new ImageIcon(getClass().getResource("/imagenes/Menus.jpg")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}
}
