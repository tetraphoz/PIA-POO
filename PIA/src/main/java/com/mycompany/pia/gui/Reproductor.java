package com.mycompany.pia.gui;

import java.awt.BorderLayout;
import java.nio.file.Path;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mycompany.pia.Video;
import com.mycompany.pia.VideoLabel;
import com.mycompany.pia.db.VideoManager;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class Reproductor extends javax.swing.JFrame {
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

    public Reproductor() {
        initComponents();
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        initPanels();
    }

    public void initPanels() {

        var vm = new VideoManager();
        List<Video> catalogo = vm.leerCatalogo();

        java.awt.GridLayout songsPanelLayout = new java.awt.GridLayout(catalogo.size(), 1);
        songsPanel.setLayout(songsPanelLayout);

        for (Video v : catalogo) {
            JPanel songPanel1 = new JPanel();
            VideoLabel lblSongImage = new VideoLabel();
            JLabel lblSongName = new JLabel();
            JLabel lblSongArtist = new JLabel();
            lblSongName.setText("Nombre Canción");
            lblSongArtist.setText("Nombre Artista");
            songPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            lblSongImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            lblSongName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            lblSongArtist.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            javax.swing.GroupLayout songPanel1Layout = new javax.swing.GroupLayout(songPanel1);
            songPanel1.setLayout(songPanel1Layout);
            songPanel1Layout.setHorizontalGroup(songPanel1Layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(songPanel1Layout.createSequentialGroup().addContainerGap()
                            .addComponent(lblSongImage, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(songPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSongName, javax.swing.GroupLayout.DEFAULT_SIZE,
                                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSongArtist, javax.swing.GroupLayout.DEFAULT_SIZE, 274,
                                            Short.MAX_VALUE))
                            .addContainerGap()));
            songPanel1Layout.setVerticalGroup(songPanel1Layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(songPanel1Layout.createSequentialGroup().addContainerGap().addGroup(songPanel1Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(songPanel1Layout.createSequentialGroup().addGap(6, 6, 6)
                                    .addComponent(lblSongName, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
                                            lblSongArtist, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                            .addComponent(lblSongImage, javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap()));

            initImages(lblSongImage, v.getImagePath(), v.getVideoPath(), 70, 60);
            lblSongImage.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    lblImagenMouseClicked(evt, v.getVideoPath().toAbsolutePath().toString());
                }
            });
            songsPanel.add(songPanel1);
        }
    }

    private void lblImagenMouseClicked(java.awt.event.MouseEvent evt, String urlVideo) {
        mediaPlayerComponent.mediaPlayer().media().startPaused(urlVideo);
        mediaPlayerComponent.mediaPlayer().controls().play();
    }

    public void initImages(VideoLabel lbl, Path urlImage, Path urlVideo, int width, int height) {
        lbl.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(urlImage.toAbsolutePath().toString())).getImage()
                .getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH)));
        lbl.setUrlVideo(urlVideo.toAbsolutePath().toString());
    }

    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jScrollPane1 = new javax.swing.JScrollPane();
                songsPanel = new javax.swing.JPanel();
                mainPane = new javax.swing.JPanel();
                contentPane = new javax.swing.JPanel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                songsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                songsPanel.setAutoscrolls(true);

                javax.swing.GroupLayout songsPanelLayout = new javax.swing.GroupLayout(songsPanel);
                songsPanel.setLayout(songsPanelLayout);
                songsPanelLayout.setHorizontalGroup(
                        songsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 401, Short.MAX_VALUE)
                );
                songsPanelLayout.setVerticalGroup(
                        songsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 464, Short.MAX_VALUE)
                );

                jScrollPane1.setViewportView(songsPanel);

                mainPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                mainPane.setPreferredSize(new java.awt.Dimension(711, 200));

                contentPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
                contentPane.setLayout(contentPaneLayout);
                contentPaneLayout.setHorizontalGroup(
                        contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 691, Short.MAX_VALUE)
                );
                contentPaneLayout.setVerticalGroup(
                        contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
                );

                javax.swing.GroupLayout mainPaneLayout = new javax.swing.GroupLayout(mainPane);
                mainPane.setLayout(mainPaneLayout);
                mainPaneLayout.setHorizontalGroup(
                        mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );
                mainPaneLayout.setVerticalGroup(
                        mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel contentPane;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JPanel mainPane;
        private javax.swing.JPanel songsPanel;
        // End of variables declaration//GEN-END:variables
}
