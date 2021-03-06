package proyecto2;
//Bibliotecas a usar

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author live
 */
public class ventanaPrincipal extends javax.swing.JFrame {

    //Variables globales
    ControladorPrincipal controlador;

    //Constructor
    public ventanaPrincipal(ControladorPrincipal control) {
        initComponents();
        //this.tablaQuerysPrincipal.setModel(new DefaultTableModel());
        backGro back = new backGro();
        this.add(back, BorderLayout.CENTER);
        this.pack();

        this.controlador = control;
    }

    //Funciones
    public String getOpciones() {
        return opciones.getSelectedItem().toString();
    }

    public DefaultTableModel getTablaQuerysPrincipal() {
        return (DefaultTableModel) tablaQuerysPrincipal.getModel();
    }

    public void setTablaQuerysPrincipal(JTable tablaQuerysPrincipal) {
        this.tablaQuerysPrincipal = tablaQuerysPrincipal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        opciones = new javax.swing.JComboBox<>();
        salir = new javax.swing.JButton();
        ejecutar = new javax.swing.JButton();
        crudEquipo = new javax.swing.JButton();
        crudPartido = new javax.swing.JButton();
        crudPartido1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaQuerysPrincipal = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        parametro = new javax.swing.JTextField();
        ayuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Eliga el REPORTE que quiera realizar a la BD CAMPEONATO MUNDIAL DE FÚTBOL:");

        opciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EQUIPOS PARTICIPANTES POR CONFEDERACIÓN", "INFORME OFICIAL DEL PARTIDO", "GRUPOS Y CLASIFICACIONES", "TABLA GENERAL DE POSICIONES", "TABLA DE GOLEADORES" }));
        opciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionesActionPerformed(evt);
            }
        });

        salir.setBackground(new java.awt.Color(255, 102, 102));
        salir.setFont(new java.awt.Font("MS UI Gothic", 1, 12)); // NOI18N
        salir.setText("SALIR");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        ejecutar.setBackground(new java.awt.Color(51, 255, 51));
        ejecutar.setFont(new java.awt.Font("MS Gothic", 1, 12)); // NOI18N
        ejecutar.setText("EJECUTAR");
        ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarActionPerformed(evt);
            }
        });

        crudEquipo.setBackground(new java.awt.Color(51, 51, 255));
        crudEquipo.setFont(new java.awt.Font("MS Gothic", 1, 12)); // NOI18N
        crudEquipo.setText("EQUIPO[CRUD]");
        crudEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudEquipoActionPerformed(evt);
            }
        });

        crudPartido.setBackground(new java.awt.Color(51, 51, 255));
        crudPartido.setFont(new java.awt.Font("MS Gothic", 1, 12)); // NOI18N
        crudPartido.setText("PARTIDO[CRUD]");
        crudPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudPartidoActionPerformed(evt);
            }
        });

        crudPartido1.setBackground(new java.awt.Color(51, 51, 255));
        crudPartido1.setFont(new java.awt.Font("MS Gothic", 1, 12)); // NOI18N
        crudPartido1.setText("DICCIONARIO");
        crudPartido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudPartido1ActionPerformed(evt);
            }
        });

        tablaQuerysPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaQuerysPrincipal);

        jLabel2.setBackground(new java.awt.Color(51, 255, 51));
        jLabel2.setFont(new java.awt.Font("MS PGothic", 1, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Parametro");
        jLabel2.setOpaque(true);

        ayuda.setBackground(new java.awt.Color(255, 102, 102));
        ayuda.setFont(new java.awt.Font("MS UI Gothic", 1, 12)); // NOI18N
        ayuda.setText("AYUDA");
        ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(parametro, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(crudPartido1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(ejecutar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(crudPartido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(crudEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(crudEquipo)
                            .addComponent(ejecutar)
                            .addComponent(jLabel2)
                            .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(crudPartido)
                            .addComponent(crudPartido1)
                            .addComponent(parametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void ejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarActionPerformed
        controlador.logicaVentanaPrincipal(getOpciones(), parametro.getText());
    }//GEN-LAST:event_ejecutarActionPerformed
    private void opcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesActionPerformed
    }//GEN-LAST:event_opcionesActionPerformed
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
    }//GEN-LAST:event_salirActionPerformed
    private void crudPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudPartidoActionPerformed
        crudPartido interfaz = new crudPartido(controlador);
        interfaz.setLocationRelativeTo(null);
        interfaz.setVisible(true);
    }//GEN-LAST:event_crudPartidoActionPerformed

    private void crudEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudEquipoActionPerformed
        crudEquipo interfaz = new crudEquipo(controlador);
        interfaz.setLocationRelativeTo(null);
        interfaz.setVisible(true);
    }//GEN-LAST:event_crudEquipoActionPerformed

    private void ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaActionPerformed
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("manual_de_usuario_campeonato_mundial.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al abrir el Manual de usuario");
            }
        }
    }//GEN-LAST:event_ayudaActionPerformed

    private void crudPartido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudPartido1ActionPerformed
        try {
            controlador.consultaDD(parametro.getText());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al consultar el Diccionario de Datos");
        }
    }//GEN-LAST:event_crudPartido1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ayuda;
    private javax.swing.JButton crudEquipo;
    private javax.swing.JButton crudPartido;
    private javax.swing.JButton crudPartido1;
    private javax.swing.JButton ejecutar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> opciones;
    private javax.swing.JTextField parametro;
    private javax.swing.JButton salir;
    public static javax.swing.JTable tablaQuerysPrincipal;
    // End of variables declaration//GEN-END:variables
}
