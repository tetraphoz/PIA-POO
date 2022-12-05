package com.mycompany.pia.gui;

import com.mycompany.pia.Video;
import com.mycompany.pia.db.VideoManager;
import java.awt.event.ItemEvent;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EditarVideo extends javax.swing.JFrame {
    private final ImageIcon iconError48 = new ImageIcon(new ImageIcon(
            getClass().getResource("/error_icon_48px.png")).getImage());
    private final ImageIcon iconCheck48 = new ImageIcon(new ImageIcon(
        getClass().getResource("/ok_icon_48px.png")).getImage());
    
    String[] columnas = {"ID", "Nombre", "Artista", "Ubicación vídeo", "Ubicación imagen"};
    DefaultTableModel tm = new DefaultTableModel(columnas, 0);
    VideoManager vm = new VideoManager();
    
    private JFileChooser fileChooser = new JFileChooser();
    private Path videoPath = null;
    private Path imagePath = null;
    
    public EditarVideo() {
        initComponents();
        tblPrincipal.setModel(tm);
        cbxIDVideo.removeAllItems();
        vm.cargarVideos(tm, cbxIDVideo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        lblTitulo = new javax.swing.JLabel();
        lbl_ID = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblArtista = new javax.swing.JLabel();
        lblVideo = new javax.swing.JLabel();
        lbl_Imagen = new javax.swing.JLabel();
        cbxIDVideo = new javax.swing.JComboBox<>();
        btnImagen = new javax.swing.JButton();
        btnVideo = new javax.swing.JButton();
        txtArtista = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrincipal = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        tabAgregarVideo = new javax.swing.JMenuItem();
        tabEditarVideo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        tabReproductor = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        tabHome = new javax.swing.JMenuItem();
        tabSalir = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visualizador de vídeos - Editar vídeo");
        setMinimumSize(new java.awt.Dimension(660, 600));
        setPreferredSize(new java.awt.Dimension(660, 600));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Editar vídeo");

        lbl_ID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_ID.setText("ID de vídeo:");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setText("Nombre:");

        lblArtista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblArtista.setText("Artista:");

        lblVideo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblVideo.setText("Ubicación del vídeo:");

        lbl_Imagen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Imagen.setText("Ubicación de la imagen:");

        cbxIDVideo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxIDVideo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxIDVideoItemStateChanged(evt);
            }
        });

        btnImagen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnImagen.setText("Seleccionar archivo");
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });

        btnVideo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVideo.setText("Seleccionar archivo");
        btnVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVideoActionPerformed(evt);
            }
        });

        txtArtista.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tblPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Artista", "Ubicación Vídeo", "Ubicación Imagen"
            }
        ));
        jScrollPane1.setViewportView(tblPrincipal);

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar vídeo");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnActualizar.setText("Actualizar información de vídeo");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

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
        tabEditarVideo.setText("Editar información de vídeo");
        jMenu1.add(tabEditarVideo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Vídeos");

        tabReproductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/video_icon.png"))); // NOI18N
        tabReproductor.setText("Reproductor de vídeos");
        tabReproductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabReproductorActionPerformed(evt);
            }
        });
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
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(31, 31, 31))
                            .addComponent(lbl_ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblArtista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(38, 38, 38)))
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVideo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_Imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVideo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtArtista)
                    .addComponent(txtNombre)
                    .addComponent(cbxIDVideo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(79, 79, 79))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(246, 246, 246)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ID)
                    .addComponent(cbxIDVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblArtista)
                    .addComponent(txtArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVideo)
                    .addComponent(btnVideo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Imagen)
                    .addComponent(btnImagen))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabReproductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabReproductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabReproductorActionPerformed

    private void tabAgregarVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabAgregarVideoActionPerformed
        this.dispose();
        new AgregarVideo().setVisible(true);
    }//GEN-LAST:event_tabAgregarVideoActionPerformed

    private void tabSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabSalirActionPerformed
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_tabSalirActionPerformed

    private void cbxIDVideoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxIDVideoItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            Video v = vm.obtenerDatosVideo(Integer.parseInt(cbxIDVideo.getSelectedItem().toString()));
            if(v != null) {
                txtNombre.setText(v.getName());
                txtArtista.setText(v.getArtist());
                videoPath = v.getVideoPath();
                imagePath = v.getImagePath();
            }
        }
    }//GEN-LAST:event_cbxIDVideoItemStateChanged

    private void btnVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVideoActionPerformed
        int returnVal = fileChooser.showOpenDialog(fileChooser);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            videoPath = Paths.get(file.getAbsolutePath());
        }
    }//GEN-LAST:event_btnVideoActionPerformed

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        int returnVal = fileChooser.showOpenDialog(fileChooser);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            imagePath = Paths.get(file.getAbsolutePath());
        }
    }//GEN-LAST:event_btnImagenActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int id = Integer.parseInt(cbxIDVideo.getSelectedItem().toString());
        String name = txtNombre.getText();
        String artist = txtArtista.getText();
        Video v = new Video(id, name, artist, videoPath, imagePath);

        if(vm.actualizarVideo(v)) {    
            JOptionPane.showMessageDialog(rootPane,
                    "Vídeo actualizado exitosamente.",
                    "Actualizar vídeo", 1, iconCheck48);
        } else {
            JOptionPane.showMessageDialog(rootPane,
                    "Error al actualizar el vídeo.",
                    "Actualizar vídeo", 0, iconError48);
        }
        this.dispose();
        new EditarVideo().setVisible(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int id = Integer.parseInt(cbxIDVideo.getSelectedItem().toString());
        String name = txtNombre.getText();
        String artist = txtArtista.getText();
        Video v = new Video(id, name, artist, videoPath, imagePath);

        if(vm.eliminarVideo(id)) {    
            JOptionPane.showMessageDialog(rootPane,
                    "Vídeo eliminado exitosamente.",
                    "Eliminar vídeo", 1, iconCheck48);
        } else {
            JOptionPane.showMessageDialog(rootPane,
                    "Error al eliminar el vídeo.",
                    "Eliminar vídeo", 0, iconError48);
        }
        this.dispose();
        new EditarVideo().setVisible(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tabHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabHomeActionPerformed
        this.dispose();
        new Inicio().setVisible(true);
    }//GEN-LAST:event_tabHomeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImagen;
    private javax.swing.JButton btnVideo;
    private javax.swing.JComboBox<String> cbxIDVideo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArtista;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVideo;
    private javax.swing.JLabel lbl_ID;
    private javax.swing.JLabel lbl_Imagen;
    private javax.swing.JMenuItem tabAgregarVideo;
    private javax.swing.JMenuItem tabEditarVideo;
    private javax.swing.JMenuItem tabHome;
    private javax.swing.JMenuItem tabReproductor;
    private javax.swing.JMenuItem tabSalir;
    private javax.swing.JTable tblPrincipal;
    private javax.swing.JTextField txtArtista;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}