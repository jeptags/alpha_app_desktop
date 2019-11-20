package com.lue.jeptags.ui;

import com.lue.jeptags.dao.SellerAddressDao;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author lue
 */
public class Main extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    String seller_ID;

    public Main() {
        initComponents();
        bin();
        setIcon();
        SellerAddressDao sdao = new SellerAddressDao();
        if (!sdao.checkStoreAddressStatus()) {
            leftPanel.remove(uploadProductsLbl);
//            JOptionPane.showMessageDialog(centerPanel, "Your Address has not been approved", "Information", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void bin() {
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        uploadProductsLbl = new javax.swing.JLabel();
        btnProfile = new javax.swing.JButton();
        btnContactUs = new javax.swing.JButton();
        rightPanel = new javax.swing.JPanel();
        scanJepTagsLbl = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        imgLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(12, 30, 33));

        leftPanel.setBackground(new java.awt.Color(12, 30, 33));
        leftPanel.setPreferredSize(new java.awt.Dimension(235, 502));

        uploadProductsLbl.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        uploadProductsLbl.setForeground(new java.awt.Color(255, 204, 0));
        uploadProductsLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uploadProductsLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/blue 75.png"))); // NOI18N
        uploadProductsLbl.setText("Upload Product");
        uploadProductsLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadProductsLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        uploadProductsLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uploadProductsLblMouseClicked(evt);
            }
        });

        btnProfile.setBackground(new java.awt.Color(12, 30, 33));
        btnProfile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnProfile.setForeground(new java.awt.Color(255, 204, 0));
        btnProfile.setText("Profile");
        btnProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        btnProfile.setContentAreaFilled(false);
        btnProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        btnContactUs.setBackground(new java.awt.Color(12, 30, 33));
        btnContactUs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnContactUs.setForeground(new java.awt.Color(255, 204, 0));
        btnContactUs.setText("Contact Us");
        btnContactUs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        btnContactUs.setContentAreaFilled(false);
        btnContactUs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnContactUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContactUsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnContactUs, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(uploadProductsLbl)
                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnContactUs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(231, 231, 231)
                .addComponent(uploadProductsLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rightPanel.setBackground(new java.awt.Color(12, 30, 33));
        rightPanel.setPreferredSize(new java.awt.Dimension(235, 54));

        scanJepTagsLbl.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        scanJepTagsLbl.setForeground(new java.awt.Color(255, 204, 0));
        scanJepTagsLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scanJepTagsLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/blue 75.png"))); // NOI18N
        scanJepTagsLbl.setText("Scan JepTags");
        scanJepTagsLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scanJepTagsLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        scanJepTagsLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scanJepTagsLblMouseClicked(evt);
            }
        });

        logoutBtn.setBackground(new java.awt.Color(12, 30, 33));
        logoutBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 204, 0));
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/logout (1).png"))); // NOI18N
        logoutBtn.setToolTipText("Click to Logout");
        logoutBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtn.setLabel("Logout");
        logoutBtn.setName("logoutBtn"); // NOI18N
        logoutBtn.setOpaque(true);
        logoutBtn.setPreferredSize(new java.awt.Dimension(90, 35));
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("Software Design By Jeptags USA");

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scanJepTagsLbl)
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scanJepTagsLbl)
                .addGap(183, 183, 183)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        centerPanel.setBackground(new java.awt.Color(12, 30, 33));

        imgLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/JeptagBackground cropped.png"))); // NOI18N

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(centerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addComponent(centerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?", "Jep Tags", JOptionPane.OK_CANCEL_OPTION);

        if (response != -1 && response != 2) {
            dispose();
            Login l = new Login();
            l.setVisible(true);
        }
    }//GEN-LAST:event_logoutBtnActionPerformed

    
    private void scanJepTagsLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scanJepTagsLblMouseClicked
        ScanJepTags scj = new ScanJepTags();
        scj.setVisible(true);
        dispose();
    }//GEN-LAST:event_scanJepTagsLblMouseClicked

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        Profile pf = new Profile();
        pf.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnContactUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContactUsActionPerformed
        ContactUs pf = new ContactUs();
        pf.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnContactUsActionPerformed

    private void uploadProductsLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadProductsLblMouseClicked
         UploadProduct upl = new UploadProduct();
        upl.setVisible(true);
        dispose();
    }//GEN-LAST:event_uploadProductsLblMouseClicked

    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/lue/jeptags/image/icon.png")));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContactUs;
    private javax.swing.JButton btnProfile;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel imgLbl;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel scanJepTagsLbl;
    private javax.swing.JLabel uploadProductsLbl;
    // End of variables declaration//GEN-END:variables
}
