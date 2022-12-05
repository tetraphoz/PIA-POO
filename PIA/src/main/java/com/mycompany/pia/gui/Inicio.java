package com.mycompany.pia.gui;

import com.mycompany.pia.Clima;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class Inicio extends javax.swing.JFrame {

        public Inicio() {
                initComponents();
                Clima c = new Clima();
                c.obtenerClima();
		
                lblClima.setText("Clima Actual: " + c.tempMaxima + " C°");
                Timer t = new Timer(1000, updateClockAction);
                t.start();
        }

        ActionListener updateClockAction = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        Date fecha = new Date();
                        SimpleDateFormat df = new SimpleDateFormat("kk:mm:ss");
                        lblHora.setText("Hora actual: " + df.format(fecha));
                }
        };

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                lblHora = new javax.swing.JLabel();
                lblClima = new javax.swing.JLabel();
                jMenuBar1 = new javax.swing.JMenuBar();
                Catalogos = new javax.swing.JMenu();
                jMenu2 = new javax.swing.JMenu();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                lblHora.setFont(new java.awt.Font("IBM Plex Mono", 0, 24)); // NOI18N
                lblHora.setText("Hora Actual: 00:00");

                lblClima.setFont(new java.awt.Font("IBM Plex Mono", 0, 14)); // NOI18N
                lblClima.setText("Clima Actual: 0°");

                Catalogos.setText("File");
                jMenuBar1.add(Catalogos);

                jMenu2.setText("Videos");
                jMenuBar1.add(jMenu2);

                setJMenuBar(jMenuBar1);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(lblHora)
                                .addContainerGap(84, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblClima)
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblClima)
                                .addGap(68, 68, 68)
                                .addComponent(lblHora)
                                .addContainerGap(136, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JMenu Catalogos;
        private javax.swing.JMenu jMenu2;
        private javax.swing.JMenuBar jMenuBar1;
        private javax.swing.JLabel lblClima;
        private javax.swing.JLabel lblHora;
        // End of variables declaration//GEN-END:variables
}
