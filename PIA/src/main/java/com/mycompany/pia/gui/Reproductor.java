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
import javax.swing.JButton;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class Reproductor extends javax.swing.JFrame {
    private final ImageIcon iconFav = new ImageIcon(new ImageIcon(
            getClass().getResource("/heart_icon_fav.png")).getImage());
    private final ImageIcon iconNofav = new ImageIcon(new ImageIcon(
            getClass().getResource("/heart_icon_nofav.png")).getImage());
    
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
        VideoManager vm = new VideoManager();
        List<Video> catalogo = vm.cargarVideos();
        boolean favoritesAreLoaded = false;
        
        java.awt.GridLayout songsPanelLayout = new java.awt.GridLayout(20, 2);
        songsPanel.setLayout(songsPanelLayout);
        for(int i = 0; i < 2; i++) {
            for(Video v : catalogo) {
                JPanel songPanel1 = new JPanel();
                VideoLabel lblSongImage = new VideoLabel();
                JLabel lblSongName = new JLabel();
                JLabel lblSongArtist = new JLabel();
                JButton btnFavorite = new JButton();
                
                if(favoritesAreLoaded && v.getIsFavorite())
                    continue;
                else if(!favoritesAreLoaded && !v.getIsFavorite())
                    continue;
                
                songPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                lblSongImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                lblSongName.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                lblSongArtist.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                javax.swing.GroupLayout songPanel1Layout = new javax.swing.GroupLayout(songPanel1);
                songPanel1.setLayout(songPanel1Layout);

                songPanel1Layout.setHorizontalGroup(
                        songPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(songPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(lblSongImage, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(songPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblSongName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblSongArtist, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                                .addComponent(btnFavorite, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addContainerGap())
                );

                songPanel1Layout.setVerticalGroup(
                        songPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(songPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(songPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(songPanel1Layout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(lblSongName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lblSongArtist, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                                                        .addComponent(btnFavorite, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
                                                .addComponent(lblSongImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addContainerGap())
                );
                initImages(lblSongImage, v.getImagePath(), v.getVideoPath(), 70, 60);

                lblSongImage.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblImagenMouseClicked(evt, v.getVideoPath().toAbsolutePath().toString());
                    }
                });

                btnFavorite.addMouseListener(new java.awt.event.MouseAdapter() {
                   public void mouseClicked(java.awt.event.MouseEvent evt) {
                       if(btnFavorite.getIcon().equals(iconNofav)) {
                           btnFavorite.setIcon(iconFav);
                           v.setIsFavorite(true);
                           vm.actualizarVideo(v);
                       }
                       else {
                           btnFavorite.setIcon(iconNofav);
                           v.setIsFavorite(false);
                           vm.actualizarVideo(v);
                       }
                   }
                });

                lblSongName.setText(v.getName());
                lblSongArtist.setText(v.getArtist());
                
                if(v.getIsFavorite())
                    btnFavorite.setIcon(iconFav);
                else
                    btnFavorite.setIcon(iconNofav);
                
                btnFavorite.setOpaque(false);
                btnFavorite.setContentAreaFilled(false);
                btnFavorite.setBorderPainted(false);

                songsPanel.add(songPanel1);
            }
            favoritesAreLoaded = true;
        }
    }

    private void lblImagenMouseClicked(java.awt.event.MouseEvent evt, String urlVideo) {
        mediaPlayerComponent.mediaPlayer().media().startPaused(urlVideo);
        mediaPlayerComponent.mediaPlayer().controls().play();
    }

    public void initImages(VideoLabel lbl, Path urlImage, Path urlVideo, int width, int height) {
        ImageIcon icon = new ImageIcon(new ImageIcon(urlImage.toAbsolutePath().toString()).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
        lbl.setIcon(icon);
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        tabAgregarVideo = new javax.swing.JMenuItem();
        tabEditarVideo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        tabReproductor = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        tabHome = new javax.swing.JMenuItem();
        tabSalir = new javax.swing.JMenuItem();

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu1.setText("Catálogo");

        tabAgregarVideo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add_icon.png"))); // NOI18N
        tabAgregarVideo.setText("Añadir vídeo");
        tabAgregarVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabAgregarVideoActionPerformed(evt);
            }
        });
        jMenu1.add(tabAgregarVideo);

        tabEditarVideo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit_icon.png"))); // NOI18N
        tabEditarVideo.setText("Editar información de vídeos");
        tabEditarVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabEditarVideoActionPerformed(evt);
            }
        });
        jMenu1.add(tabEditarVideo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Vídeos");

        tabReproductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/video_icon.png"))); // NOI18N
        tabReproductor.setText("Reproductor de vídeos");
        jMenu2.add(tabReproductor);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Cerrar sesión");

        tabHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_icon.png"))); // NOI18N
        tabHome.setText("Menú de inicio");
        tabHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabHomeActionPerformed(evt);
            }
        });
        jMenu3.add(tabHome);

        tabSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout_icon.png"))); // NOI18N
        tabSalir.setText("Salir");
        tabSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabSalirActionPerformed(evt);
            }
        });
        jMenu3.add(tabSalir);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

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

    private void tabAgregarVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabAgregarVideoActionPerformed
        mediaPlayerComponent.mediaPlayer().controls().pause();
        this.dispose();
        new AgregarVideo().setVisible(true);
    }//GEN-LAST:event_tabAgregarVideoActionPerformed

    private void tabEditarVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabEditarVideoActionPerformed
        mediaPlayerComponent.mediaPlayer().controls().pause();
        this.dispose();
        new EditarVideo().setVisible(true);
    }//GEN-LAST:event_tabEditarVideoActionPerformed

    private void tabHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabHomeActionPerformed
        mediaPlayerComponent.mediaPlayer().controls().pause();
        this.dispose();
        new Inicio().setVisible(true);
    }//GEN-LAST:event_tabHomeActionPerformed

    private void tabSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabSalirActionPerformed
        mediaPlayerComponent.mediaPlayer().controls().pause();
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_tabSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPane;
    private javax.swing.JPanel songsPanel;
    private javax.swing.JMenuItem tabAgregarVideo;
    private javax.swing.JMenuItem tabEditarVideo;
    private javax.swing.JMenuItem tabHome;
    private javax.swing.JMenuItem tabReproductor;
    private javax.swing.JMenuItem tabSalir;
    // End of variables declaration//GEN-END:variables
}
