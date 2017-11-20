package proyecto2;

/**
 *
 * @author live
 */
public class crudPartido extends javax.swing.JFrame 
{
    //Variables globales
    ControladorPrincipal control;
    
    
    public crudPartido(ControladorPrincipal controll) 
    {
        initComponents();
        
        this.control = controll;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        rud = new javax.swing.JButton();
        crear = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CRUD (Create Read Update Delete) DE PARTIDOS");

        rud.setText("[LEER|ACTUALIZAR|BORRAR]");
        rud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rudActionPerformed(evt);
            }
        });

        crear.setText("[CREAR]");
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(crear)
                        .addGap(41, 41, 41)
                        .addComponent(rud)
                        .addGap(51, 51, 51)
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(crear, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(rud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();       
    }//GEN-LAST:event_salirActionPerformed

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
        interfazPartidos interfaz = new interfazPartidos(control);
        interfaz.setLocationRelativeTo(null);
        interfaz.setVisible(true);            
    }//GEN-LAST:event_crearActionPerformed

    private void rudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rudActionPerformed
        interfazPartido_RUD interfaz = new interfazPartido_RUD(control);
        interfaz.setLocationRelativeTo(null);
        interfaz.setVisible(true);      
    }//GEN-LAST:event_rudActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton rud;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables

}
