package proyecto2;
//Bibliotecas a usar
import java.awt.BorderLayout;
import javax.swing.JComboBox;

/**
 *
 * @author live
 */
public class ventanaPrincipal extends javax.swing.JFrame 
{
    //Variables globales
    ControladorPrincipal controlador;
    
    //Constructor
    public ventanaPrincipal(ControladorPrincipal control) 
    {
        initComponents();
        backGro back = new backGro();
        this.add(back, BorderLayout.CENTER);
        this.pack();  
        
        this.controlador = control;
    }
    
    //Funciones
    public String getOpciones()
    {
        return opciones.getSelectedItem().toString();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(crudPartido1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(ejecutar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(crudPartido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(crudEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(crudEquipo)
                            .addComponent(ejecutar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(crudPartido)
                            .addComponent(crudPartido1)))
                    .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void ejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarActionPerformed
        controlador.logicaVentanaPrincipal();      
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crudEquipo;
    private javax.swing.JButton crudPartido;
    private javax.swing.JButton crudPartido1;
    private javax.swing.JButton ejecutar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> opciones;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
