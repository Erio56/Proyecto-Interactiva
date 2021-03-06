/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUsuario.vista;

import GestionUsuario.controlador.ControlUsuario;

/**
 *
 * @author Acer
 */
public class DetallesUsuario extends javax.swing.JFrame {

    ControlUsuario cu;

    /**
     * Creates new form DetallesUsuario
     */
    public DetallesUsuario() {
        initComponents();
        cu = new ControlUsuario();
        cu.setDetallesUsuario(this);
    }

    public void setId(String i) {
        txt_detalleId.setText(i);
    }

    public void setNombre(String i) {
        txt_detalleNombre.setText(i);
    }

    public void setApellido(String i) {
        txt_detalleApellido.setText(i);
    }

    public void setIdentificacion(String i) {
        txt_detalleIdentificacion.setText(i);
    }

    public void setCorreo(String i) {
        txt_detalleCorreo.setText(i);
    }

    public void setTelefono(String i) {
        txt_detalleTelefono.setText(i);
    }

    public void setContraseña(String i) {
        txt_detalleContraseña.setText(i);
    }

    public void setTipoUsuario(String i) {
        cbx_detalleTipoUsuario.setSelectedItem(i);
    }
    
    public void setEstado(String i){
        cbx_estado.setSelectedItem(i);
    }

    public String getId() {
        return txt_detalleId.getText();
    }

    public String getIdentificacion() {
        return txt_detalleIdentificacion.getText();
    }

    public String getNombre() {
        return txt_detalleNombre.getText();
    }

    public String getApellido() {
        return txt_detalleApellido.getText();
    }

    public String getCorreo() {
        return txt_detalleCorreo.getText();
    }

    public String getTelefono() {
        return txt_detalleTelefono.getText();
    }

    public String getContraseña() {
        return txt_detalleContraseña.getText();
    }

    public String getTipoUsuario() {
        return cbx_detalleTipoUsuario.getSelectedItem().toString();
    }
    
    public String getEstado(){
        return cbx_estado.getSelectedItem().toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_detalleId = new javax.swing.JLabel();
        txt_detalleId = new javax.swing.JTextField();
        lbl_detalleIdentificacion = new javax.swing.JLabel();
        txt_detalleIdentificacion = new javax.swing.JTextField();
        lbl_detalleNombre = new javax.swing.JLabel();
        txt_detalleNombre = new javax.swing.JTextField();
        lbl_detalleApellido = new javax.swing.JLabel();
        txt_detalleApellido = new javax.swing.JTextField();
        lbl_detalleTelefono = new javax.swing.JLabel();
        txt_detalleTelefono = new javax.swing.JTextField();
        lbl_detalleCorreo = new javax.swing.JLabel();
        txt_detalleCorreo = new javax.swing.JTextField();
        txt_detalleContraseña = new javax.swing.JTextField();
        lbl_detalleContraseña = new javax.swing.JLabel();
        lbl_detalleTipoUsuario = new javax.swing.JLabel();
        cbx_detalleTipoUsuario = new javax.swing.JComboBox<>();
        btn_detalleAceptar = new javax.swing.JButton();
        lbl_estado = new javax.swing.JLabel();
        cbx_estado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbl_detalleId.setText("Id:");

        txt_detalleId.setEditable(false);

        lbl_detalleIdentificacion.setText("Identificación:");

        lbl_detalleNombre.setText("Nombre:");

        lbl_detalleApellido.setText("Apellido:");

        lbl_detalleTelefono.setText("Telefono:");

        lbl_detalleCorreo.setText("Correo: ");

        lbl_detalleContraseña.setText("Contraseña: ");

        lbl_detalleTipoUsuario.setText("Tipo de Usuario:");

        cbx_detalleTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Agente Inmobiliario", "Cliente" }));

        btn_detalleAceptar.setText("Aceptar");
        btn_detalleAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_detalleAceptarActionPerformed(evt);
            }
        });

        lbl_estado.setText("Estado:");

        cbx_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Eliminado" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_detalleContraseña)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_detalleContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(lbl_detalleTipoUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbx_detalleTipoUsuario, 0, 1, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_detalleId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_detalleId, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(lbl_detalleIdentificacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_detalleIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_detalleNombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_detalleNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_detalleTelefono)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_detalleTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(lbl_detalleApellido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_detalleApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(lbl_detalleCorreo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_detalleCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(btn_detalleAceptar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(lbl_estado)
                        .addGap(18, 18, 18)
                        .addComponent(cbx_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_detalleId)
                    .addComponent(txt_detalleId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_detalleIdentificacion)
                    .addComponent(txt_detalleIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_detalleNombre)
                    .addComponent(txt_detalleNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_detalleApellido)
                    .addComponent(txt_detalleApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_detalleTelefono)
                    .addComponent(txt_detalleTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_detalleCorreo)
                    .addComponent(txt_detalleCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_detalleContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_detalleContraseña)
                    .addComponent(lbl_detalleTipoUsuario)
                    .addComponent(cbx_detalleTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_estado)
                    .addComponent(cbx_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btn_detalleAceptar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_detalleAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detalleAceptarActionPerformed
        cu.actualizarUsuario();
        this.dispose();
    }//GEN-LAST:event_btn_detalleAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(DetallesUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallesUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallesUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallesUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetallesUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_detalleAceptar;
    private javax.swing.JComboBox<String> cbx_detalleTipoUsuario;
    private javax.swing.JComboBox<String> cbx_estado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_detalleApellido;
    private javax.swing.JLabel lbl_detalleContraseña;
    private javax.swing.JLabel lbl_detalleCorreo;
    private javax.swing.JLabel lbl_detalleId;
    private javax.swing.JLabel lbl_detalleIdentificacion;
    private javax.swing.JLabel lbl_detalleNombre;
    private javax.swing.JLabel lbl_detalleTelefono;
    private javax.swing.JLabel lbl_detalleTipoUsuario;
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JTextField txt_detalleApellido;
    private javax.swing.JTextField txt_detalleContraseña;
    private javax.swing.JTextField txt_detalleCorreo;
    private javax.swing.JTextField txt_detalleId;
    private javax.swing.JTextField txt_detalleIdentificacion;
    private javax.swing.JTextField txt_detalleNombre;
    private javax.swing.JTextField txt_detalleTelefono;
    // End of variables declaration//GEN-END:variables
}
