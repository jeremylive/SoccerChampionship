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

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        opciones = new javax.swing.JComboBox<>();
        salir = new javax.swing.JButton();
        ejecutar = new javax.swing.JButton();
        crudEquipo = new javax.swing.JButton();
        crudPartido = new javax.swing.JButton();
        crudPartido1 = new javax.swing.JButton();

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

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

        crudPartido1.setBackground(new java.awt.Color(51, 51, 255));
        crudPartido1.setFont(new java.awt.Font("MS Gothic", 1, 12)); // NOI18N
        crudPartido1.setText("DICCIONARIO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(salir)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ejecutar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(crudPartido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(crudEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(crudPartido1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ejecutar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(crudEquipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(crudPartido)))
                .addGap(6, 6, 6)
                .addComponent(crudPartido1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                .addComponent(salir)
                .addContainerGap())
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crudEquipo;
    private javax.swing.JButton crudPartido;
    private javax.swing.JButton crudPartido1;
    private javax.swing.JButton ejecutar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> opciones;
    private javax.swing.JButton salir;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
