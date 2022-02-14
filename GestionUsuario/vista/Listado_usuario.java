/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUsuario.vista;

import GestionUsuario.controlador.ControlUsuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class Listado_usuario extends javax.swing.JPanel {

    ControlUsuario cu;
    /**
     * Creates new form Listado
     */
    String columnas[] = {"Id", "Identificacion", "Nombre", "Apellido", "Telefono"};
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public Listado_usuario() {
        initComponents();
        cu = new ControlUsuario();
        cu.setListado(this);
        cu.listado();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbe_usuarios = new javax.swing.JTable();
        lbl_listadoUsuarios = new javax.swing.JLabel();
        btn_detallesUsuario = new javax.swing.JButton();

        tbe_usuarios.setModel(modelo);
        jScrollPane1.setViewportView(tbe_usuarios);

        lbl_listadoUsuarios.setText("Listado Usuarios");

        btn_detallesUsuario.setText("Detalles");
        btn_detallesUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_detallesUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(lbl_listadoUsuarios))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btn_detallesUsuario)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_listadoUsuarios)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btn_detallesUsuario)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_detallesUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detallesUsuarioActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(this, "¿Desea ver los detalles de este usuario?") == JOptionPane.YES_OPTION) {
                int id;
                id = Integer.parseInt(modelo.getValueAt(tbe_usuarios.getSelectedRow(), 0).toString());
                cu.consultarUsuarioId(id);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar primero un usuario");
        }
    }//GEN-LAST:event_btn_detallesUsuarioActionPerformed

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_detallesUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_listadoUsuarios;
    private javax.swing.JTable tbe_usuarios;
    // End of variables declaration//GEN-END:variables
}
