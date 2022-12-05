package com.mycompany.pia.gui;
import com.mycompany.pia.Usuario;
import com.mycompany.pia.gui.Menu;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Registro extends javax.swing.JFrame {

    public Registro() {
        initComponents();
    }
    
    public void mostrarIcono(JLabel lbl, String path) {
        lbl.setIcon(
            new ImageIcon(
                new ImageIcon(
                        getClass().getResource(path)
                ).getImage()
            )
        );
    }

    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                lblTitulo = new javax.swing.JLabel();
                lblEmail = new javax.swing.JLabel();
                lblUser = new javax.swing.JLabel();
                lblPassword = new javax.swing.JLabel();
                txtEmail = new javax.swing.JTextField();
                txtUser = new javax.swing.JTextField();
                btnRegistro = new javax.swing.JButton();
                btnCancelar = new javax.swing.JButton();
                txtPassword = new javax.swing.JPasswordField();
                iconEmail = new javax.swing.JLabel();
                iconUser = new javax.swing.JLabel();
                iconPassword = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lblTitulo.setText("Registro de usuario");

                lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                lblEmail.setText("Correo electrónico:");

                lblUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                lblUser.setText("Nombre de usuario:");

                lblPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                lblPassword.setText("Contraseña:");

                txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

                txtUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

                btnRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                btnRegistro.setText("Registrarse");
                btnRegistro.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnRegistroActionPerformed(evt);
                        }
                });

                btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                btnCancelar.setText("Cancelar");
                btnCancelar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCancelarActionPerformed(evt);
                        }
                });

                txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

                iconEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                iconEmail.setToolTipText("");

                iconUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

                iconPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(182, 182, 182)
                                                .addComponent(btnRegistro)
                                                .addGap(35, 35, 35)
                                                .addComponent(btnCancelar))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(123, 123, 123)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtUser)
                                                        .addComponent(txtEmail)
                                                        .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(iconEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(iconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(iconPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(87, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(lblTitulo)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblEmail)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(iconEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblUser)
                                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(iconUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(iconPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblPassword)))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRegistro)
                                        .addComponent(btnCancelar))
                                .addGap(51, 51, 51))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        String email = txtEmail.getText();
        String username = txtUser.getText();
        String password = new String(txtPassword.getPassword());
        String error = "";
        boolean valido = true;
        
        Usuario user = new Usuario(email, username, password);
        
        if(user.validarEmail())
            mostrarIcono(iconEmail, "/ok_icon.png");
        else {
            valido = false;
            mostrarIcono(iconEmail, "/error_icon.png");
        }          
        
        if(user.validarUsername())
            mostrarIcono(iconUser, "/ok_icon.png");
        else {
            valido = false;
            mostrarIcono(iconUser, "/error_icon.png");
        }          
        
        if(user.validarPassword())
            mostrarIcono(iconPassword, "/ok_icon.png");
        else {
            valido = false;
            mostrarIcono(iconPassword, "/error_icon.png");
        }          
    }//GEN-LAST:event_btnRegistroActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnCancelar;
        private javax.swing.JButton btnRegistro;
        private javax.swing.JLabel iconEmail;
        private javax.swing.JLabel iconPassword;
        private javax.swing.JLabel iconUser;
        private javax.swing.JLabel lblEmail;
        private javax.swing.JLabel lblPassword;
        private javax.swing.JLabel lblTitulo;
        private javax.swing.JLabel lblUser;
        private javax.swing.JTextField txtEmail;
        private javax.swing.JPasswordField txtPassword;
        private javax.swing.JTextField txtUser;
        // End of variables declaration//GEN-END:variables
}
