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
		lblHora.setText("Clima Actual: "+ c.tempMaxima + " C°");
		Timer t = new Timer(1000, updateClockAction);
		t.start();
	}

	ActionListener updateClockAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Date fecha =  new Date();
			SimpleDateFormat df = new SimpleDateFormat("kk:mm:ss");
			lblHora.setText("Hora actual: " + df.format(fecha));
		}
	};

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuBar6 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuBar7 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        lblHora = new javax.swing.JLabel();
        lblClima = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        tabCatalogo = new javax.swing.JMenu();
        tabAgregarVideo = new javax.swing.JMenuItem();
        tabEditarVideo = new javax.swing.JMenuItem();
        tabVideos = new javax.swing.JMenu();
        tabReproductor = new javax.swing.JMenuItem();
        tabLogout = new javax.swing.JMenu();
        tabSalir = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar3.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar3.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar4.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar4.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar5.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar5.add(jMenu8);

        jMenu9.setText("File");
        jMenuBar6.add(jMenu9);

        jMenu10.setText("Edit");
        jMenuBar6.add(jMenu10);

        jMenu11.setText("File");
        jMenuBar7.add(jMenu11);

        jMenu12.setText("Edit");
        jMenuBar7.add(jMenu12);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visualizador de vídeos - Inicio");

        lblHora.setFont(new java.awt.Font("IBM Plex Mono", 0, 24)); // NOI18N
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setText("Hora Actual: 00:00");

        lblClima.setFont(new java.awt.Font("IBM Plex Mono", 0, 14)); // NOI18N
        lblClima.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClima.setText("Clima Actual: 0°");

        tabCatalogo.setText("Catálogo");

        tabAgregarVideo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add_icon.png"))); // NOI18N
        tabAgregarVideo.setText("Añadir vídeo");
        tabAgregarVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabAgregarVideoActionPerformed(evt);
            }
        });
        tabCatalogo.add(tabAgregarVideo);

        tabEditarVideo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit_icon.png"))); // NOI18N
        tabEditarVideo.setText("Editar información de vídeos");
        tabEditarVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabEditarVideoActionPerformed(evt);
            }
        });
        tabCatalogo.add(tabEditarVideo);

        jMenuBar1.add(tabCatalogo);

        tabVideos.setText("Vídeos");

        tabReproductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/video_icon.png"))); // NOI18N
        tabReproductor.setText("Reproductor de vídeos");
        tabReproductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabReproductorActionPerformed(evt);
            }
        });
        tabVideos.add(tabReproductor);

        jMenuBar1.add(tabVideos);

        tabLogout.setText("Cerrar sesión");
        tabLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabLogoutActionPerformed(evt);
            }
        });

        tabSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout_icon.png"))); // NOI18N
        tabSalir.setText("Salir");
        tabSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabSalirActionPerformed(evt);
            }
        });
        tabLogout.add(tabSalir);

        jMenuBar1.add(tabLogout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHora, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblClima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClima)
                .addGap(69, 69, 69)
                .addComponent(lblHora)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabAgregarVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabAgregarVideoActionPerformed
        this.dispose();
        new AgregarVideo().setVisible(true);
    }//GEN-LAST:event_tabAgregarVideoActionPerformed

    private void tabLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabLogoutActionPerformed
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_tabLogoutActionPerformed

    private void tabSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabSalirActionPerformed
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_tabSalirActionPerformed

    private void tabReproductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabReproductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabReproductorActionPerformed

    private void tabEditarVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabEditarVideoActionPerformed
        this.dispose();
        new EditarVideo().setVisible(true);
    }//GEN-LAST:event_tabEditarVideoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuBar jMenuBar6;
    private javax.swing.JMenuBar jMenuBar7;
    private javax.swing.JLabel lblClima;
    private javax.swing.JLabel lblHora;
    private javax.swing.JMenuItem tabAgregarVideo;
    private javax.swing.JMenu tabCatalogo;
    private javax.swing.JMenuItem tabEditarVideo;
    private javax.swing.JMenu tabLogout;
    private javax.swing.JMenuItem tabReproductor;
    private javax.swing.JMenuItem tabSalir;
    private javax.swing.JMenu tabVideos;
    // End of variables declaration//GEN-END:variables
}
