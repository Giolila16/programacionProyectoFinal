/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;


import static Formularios.iniciosesion.usuarioLogueado;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
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
   DefaultTableModel modeloPagos;
   DefaultTableModel modeloUsuario;
    private JPanel panelContenido;  
    private CardLayout cardLayout;
  
    private void llenarComboBoxConIDs() {
    ImagenesCombo.removeAllItems(); 
    for (Propiedades casa : Propiedades.listaCasas) {
        ImagenesCombo.addItem(casa.getId());
    }
    
}
    public Administrador() {
        initComponents();
        
       FondoPanel fondo = new FondoPanel();
    fondo.setLayout(new BorderLayout());
    
    // Mover los paneles existentes al fondo
    fondo.add(AdminBotones, BorderLayout.NORTH);
    fondo.add(ParentPan, BorderLayout.CENTER);
    
    // Reemplazar el contenido del JFrame
    getContentPane().removeAll();
    getContentPane().add(fondo);
        
        this.setLocationRelativeTo(this);
   Propiedades.cargarCasasEjemplo();

ImagenesCombo.addItem("-- Seleccione una propiedad --");
Metodos.cargarIdsEnCombo(ImagenesCombo);
ImagUnoLbl.setIcon(null); // Esto cargará todas las IDs existentes
 // Limpias la imagen
        //Leila agrega un cardlayout que ayudara a identificar que usuario va ingresar
        //en el inicio de sesion
        CardLayout cl = new CardLayout();//cardlayout creado
        ParentPan.setLayout(cl); // Asegura que el ParentPan use CardLayout

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
        Propiedades.cargarCasasEjemplo();
        modelo = Metodos.generarModeloCasas();
        PropiedadesTable.setModel(modelo);
        //Leila llamo al metodo de visitas para la tabla de visitas
        Visitas.cargarVisitasEjemplo();
        modeloVisitas = Metodos.generarTablaVisitasCompleta();
        VisitasTable.setModel(modeloVisitas);
        //Leila llamo al metodo de contratos
        Contratos.cargarContratosEjemplo();
        modeloContratos = Metodos.generarContratos();
        ContratosTable.setModel(modeloContratos);
        //leila llamo al metodo de pagos
        Pagos.cargarPagosEjemplo();
        modeloPagos = Metodos.generarPagos();
        PagosTable.setModel(modeloPagos);
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
        //Leila incluyo que la imagen cuando se inicialice se lean las propiedades atravez de la clase, sea nula la primera imagen de vista
        //y en el combo box aparezca la opcionn de seleccionar propiedad
    



    // Mueve los paneles existentes al fondo


        
    }
    //Leila actualizo el metodo para mostrar imagenes y elimino Systems innecesarios
  private void actualizarComboPropiedades() {
    ImagenesCombo.removeAllItems();
    for (Propiedades p : Propiedades.listaCasas) {
        ImagenesCombo.addItem(p.getId());
    }
}
    iniciosesion Devolver = new iniciosesion();
    
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
        AgeBotPan = new javax.swing.JPanel();
        SeguimientoAgeBot = new javax.swing.JButton();
        ClientesAgeBot = new javax.swing.JButton();
        VisitasAgeBot = new javax.swing.JButton();
        ArriendosAgeBot = new javax.swing.JButton();
        OpcionesAgeBot = new javax.swing.JButton();
        ClientesBotPan = new javax.swing.JPanel();
        ContratosClieBot = new javax.swing.JButton();
        PropiedadesClieBot = new javax.swing.JButton();
        VisitasClieBot = new javax.swing.JButton();
        PagosClieBot = new javax.swing.JButton();
        OpcionesClieBot = new javax.swing.JButton();
        PropietarioBotPan = new javax.swing.JPanel();
        PropiedadesProBot = new javax.swing.JButton();
        VisitasProBot = new javax.swing.JButton();
        ContratosProBot = new javax.swing.JButton();
        PagosProBot = new javax.swing.JButton();
        OpcionesProBot = new javax.swing.JButton();
        AdminBotPan = new javax.swing.JPanel();
        PropiedadesAdBot = new javax.swing.JButton();
        ClientesAdBot = new javax.swing.JButton();
        VisitasAdBot = new javax.swing.JButton();
        ContratosAdBot = new javax.swing.JButton();
        PagosAdBot = new javax.swing.JButton();
        ReportesAdBot = new javax.swing.JButton();
        UsuariosAdBot = new javax.swing.JButton();
        OpcionesAdBot = new javax.swing.JButton();
        ParentPan = new javax.swing.JPanel();
        VacioPan = new javax.swing.JPanel();
        PropImagenesPan = new javax.swing.JPanel();
        VolverProBot = new javax.swing.JButton();
        DetCasa = new javax.swing.JTextArea();
        ImagenesCombo = new javax.swing.JComboBox<>();
        ImagUnoLbl = new javax.swing.JLabel();
        ContratosPan = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ContratosTable = new javax.swing.JTable();
        ConElimi = new javax.swing.JButton();
        AgrCon = new javax.swing.JButton();
        ReportesPan = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        UsuariosPan = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        UsuariosTable = new javax.swing.JTable();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        ClientesPan = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ClientesTable = new javax.swing.JTable();
        jButton29 = new javax.swing.JButton();
        PropiedadesPan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PropiedadesTable = new javax.swing.JTable();
        EliminarProBot = new javax.swing.JButton();
        AgregarProBot = new javax.swing.JButton();
        VerPropiBot = new javax.swing.JButton();
        PagosPan = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        PagosTable = new javax.swing.JTable();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
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
                .addContainerGap(186, Short.MAX_VALUE))
        );
        RepAgeBotPanLayout.setVerticalGroup(
            RepAgeBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RepAgeBotPanLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(RepAgeBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProDisAgeRepBot, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CliAgeRepBot)
                    .addComponent(VisAgeRepBot)
                    .addComponent(VolverAgeRepBot)
                    .addComponent(OpciAgeRepBot, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
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

        javax.swing.GroupLayout ReportesBotPanLayout = new javax.swing.GroupLayout(ReportesBotPan);
        ReportesBotPan.setLayout(ReportesBotPanLayout);
        ReportesBotPanLayout.setHorizontalGroup(
            ReportesBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportesBotPanLayout.createSequentialGroup()
                .addGroup(ReportesBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(VisitasRepBot))
                    .addGroup(ReportesBotPanLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(IngresoComiRepBot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ReportesBasicosRepBot, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VolverRepBot, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OpcionesRepBot, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        ReportesBotPanLayout.setVerticalGroup(
            ReportesBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReportesBotPanLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
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
                .addGap(44, 44, 44))
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
                .addContainerGap(168, Short.MAX_VALUE))
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
                    .addComponent(OpcionesAgeBot))
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
                .addGap(134, 134, 134))
        );
        ClientesBotPanLayout.setVerticalGroup(
            ClientesBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientesBotPanLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(ClientesBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ContratosClieBot)
                    .addComponent(PropiedadesClieBot)
                    .addComponent(VisitasClieBot)
                    .addComponent(PagosClieBot)
                    .addComponent(OpcionesClieBot, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
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
                .addContainerGap(175, Short.MAX_VALUE))
        );
        PropietarioBotPanLayout.setVerticalGroup(
            PropietarioBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PropietarioBotPanLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(PropietarioBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PropiedadesProBot)
                    .addComponent(VisitasProBot)
                    .addComponent(ContratosProBot)
                    .addComponent(PagosProBot)
                    .addComponent(OpcionesProBot, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
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
                .addGap(128, 128, 128))
        );
        AdminBotPanLayout.setVerticalGroup(
            AdminBotPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminBotPanLayout.createSequentialGroup()
                .addGap(39, 39, 39)
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
                    .addComponent(UsuariosAdBot))
                .addContainerGap(19, Short.MAX_VALUE))
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
            .addGap(0, 529, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PropImagenesPanLayout.createSequentialGroup()
                .addContainerGap(665, Short.MAX_VALUE)
                .addComponent(VolverProBot)
                .addGap(97, 97, 97))
            .addGroup(PropImagenesPanLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(PropImagenesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ImagUnoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ImagenesCombo, 0, 266, Short.MAX_VALUE))
                .addGap(97, 97, 97)
                .addComponent(DetCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PropImagenesPanLayout.setVerticalGroup(
            PropImagenesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PropImagenesPanLayout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(PropImagenesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImagUnoLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DetCasa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(ImagenesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
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

        ConElimi.setText("Eliminar Datos");
        ConElimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConElimiActionPerformed(evt);
            }
        });

        AgrCon.setText("Agregar contrato");
        AgrCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgrConActionPerformed(evt);
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
                .addComponent(ConElimi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AgrCon)
                .addGap(323, 323, 323))
        );
        ContratosPanLayout.setVerticalGroup(
            ContratosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContratosPanLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ContratosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConElimi)
                    .addComponent(AgrCon))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jButton26.setText("Guardar");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setText("Editar");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton8.setText("Agregar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UsuariosPanLayout = new javax.swing.GroupLayout(UsuariosPan);
        UsuariosPan.setLayout(UsuariosPanLayout);
        UsuariosPanLayout.setHorizontalGroup(
            UsuariosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsuariosPanLayout.createSequentialGroup()
                .addGroup(UsuariosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UsuariosPanLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UsuariosPanLayout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jButton27)
                        .addGap(29, 29, 29)
                        .addComponent(jButton26)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        UsuariosPanLayout.setVerticalGroup(
            UsuariosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UsuariosPanLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(UsuariosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton27)
                    .addComponent(jButton26)
                    .addComponent(jButton8))
                .addGap(17, 17, 17))
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

        jButton29.setText("Eliminar");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
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
                        .addComponent(jButton29)))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        ClientesPanLayout.setVerticalGroup(
            ClientesPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientesPanLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton29)
                .addContainerGap(12, Short.MAX_VALUE))
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
                .addContainerGap(48, Short.MAX_VALUE)
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

        jButton30.setText("Guardar");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setText("Editar");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

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
                        .addGap(232, 232, 232)
                        .addComponent(jButton31)
                        .addGap(29, 29, 29)
                        .addComponent(jButton30)
                        .addGap(18, 18, 18)
                        .addComponent(AgregarPagoBot))
                    .addGroup(PagosPanLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        PagosPanLayout.setVerticalGroup(
            PagosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PagosPanLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PagosPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton31)
                    .addComponent(jButton30)
                    .addComponent(AgregarPagoBot))
                .addContainerGap(9, Short.MAX_VALUE))
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
                .addContainerGap(48, Short.MAX_VALUE)
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
                .addContainerGap(58, Short.MAX_VALUE)
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

PropiedadesTable.setModel(modelo);
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

    private void ConElimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConElimiActionPerformed
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
    }//GEN-LAST:event_ConElimiActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
      int fila = ClientesTable.getSelectedRow();
    if (fila >= 0) {
        // Eliminar de la lista
        Clientes.listaClientes.remove(fila);
        
        // Eliminar de la tabla
        DefaultTableModel modelo = (DefaultTableModel) ClientesTable.getModel();
        modelo.removeRow(fila);
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");}
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
   String usuarioActual = iniciosesion.usuarioLogueado;
Metodos.crearPago(usuarioActual);
actualizarTablaPagos();
    }//GEN-LAST:event_jButton31ActionPerformed

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
int[] columnasAocultar = {4, 5}; // Teléfono y Email
        Metodos.ocultarColumnas(PropiedadesTable, columnasAocultar);    
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

// Validar si hay un valor seleccionado
if (idSeleccionado == null || idSeleccionado.equals("-- Seleccione una propiedad --")) {
    DetCasa.setText(""); // limpiar descripción
    ImagUnoLbl.setIcon(null); // limpiar imagen
    return;
}

// Buscar y mostrar la descripción e imagen
for (Propiedades p : Propiedades.listaCasas) {
    if (p.getId().equals(idSeleccionado)) {
        
        // Mostrar descripción
        DetCasa.setText(p.getDescripcion());

        // Cargar imagen
        String ruta = p.getRuta(); 

        ImageIcon iconoOriginal = null;
        if (ruta.startsWith("/")) {
            URL urlRecurso = Administrador.class.getResource(ruta);
            if (urlRecurso != null) {
                iconoOriginal = new ImageIcon(urlRecurso);
            }
        }

        if (iconoOriginal == null) {
            File archivo = new File(ruta);
            if (archivo.exists()) {
                iconoOriginal = new ImageIcon(ruta);
            }
        }

        if (iconoOriginal != null) {
            Image img = iconoOriginal.getImage().getScaledInstance(
                ImagUnoLbl.getWidth(),
                ImagUnoLbl.getHeight(),
                Image.SCALE_SMOOTH
            );
            ImagUnoLbl.setIcon(new ImageIcon(img));
        } else {
            ImagUnoLbl.setIcon(null);
            JOptionPane.showMessageDialog(this,
                "No se encontró la imagen para la propiedad:\n" + ruta,
                "Imagen no hallada", JOptionPane.WARNING_MESSAGE);
        }

        break; // salir del for, ya encontramos la propiedad
    }}  

    }//GEN-LAST:event_ImagenesComboActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
  
    }//GEN-LAST:event_jButton8ActionPerformed

    private void AgregarVisiBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarVisiBotActionPerformed
String usuarioActual = iniciosesion.usuarioLogueado;
Metodos.agendarVisita(usuarioActual);
actualizarTablaVisitas();}

private void actualizarTablaVisitas() {
    String usuarioActual = iniciosesion.usuarioLogueado;
    VisitasTable.setModel(Metodos.generarTablaVisitasCliente(usuarioActual));

    }//GEN-LAST:event_AgregarVisiBotActionPerformed

    private void AgrConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgrConActionPerformed
       String usuarioActual = iniciosesion.usuarioLogueado;
    Metodos.crearContrato(usuarioActual);
    actualizarTablaContratos();}
    private void actualizarTablaContratos() {
    ContratosTable.setModel(Metodos.generarContratos());

    }//GEN-LAST:event_AgrConActionPerformed

    private void AgregarPagoBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPagoBotActionPerformed
     String usuarioActual = iniciosesion.usuarioLogueado;
     Metodos.crearPago(usuarioActual);
actualizarTablaPagos();}
private void actualizarTablaPagos() {
    PagosTable.setModel(Metodos.generarPagos());

    }//GEN-LAST:event_AgregarPagoBotActionPerformed

    private void AgregarProBotActionPerformed(java.awt.event.ActionEvent evt) {                                              
 // Leila agrego un metodo para pedir los datos al usuario
      Metodos.agregarNuevaPropiedadConImagen(PropiedadesTable, ImagenesCombo, ImagUnoLbl);
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
    private javax.swing.JButton AgrCon;
    private javax.swing.JButton AgregarPagoBot;
    private javax.swing.JButton AgregarProBot;
    private javax.swing.JButton AgregarVisiBot;
    private javax.swing.JButton ArriendosAgeBot;
    private javax.swing.JButton CliAgeRepBot;
    private javax.swing.JButton ClientesAdBot;
    private javax.swing.JButton ClientesAgeBot;
    private javax.swing.JPanel ClientesBotPan;
    private javax.swing.JPanel ClientesPan;
    private javax.swing.JButton ClientesRepBot;
    private javax.swing.JTable ClientesTable;
    private javax.swing.JButton ConElimi;
    private javax.swing.JButton ContVencerRepBot;
    private javax.swing.JButton ContratosAdBot;
    private javax.swing.JButton ContratosClieBot;
    private javax.swing.JPanel ContratosPan;
    private javax.swing.JButton ContratosProBot;
    private javax.swing.JTable ContratosTable;
    private javax.swing.JTextArea DetCasa;
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
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
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
