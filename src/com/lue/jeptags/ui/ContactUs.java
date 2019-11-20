package com.lue.jeptags.ui;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

/**
 *
 * @author lue
 */
public class ContactUs extends javax.swing.JFrame {

    private Desktop desktop;
    private String url = "";
    private final String jep = "<html>" + "JepTags is the solution about anti-counterfieters on the world"
            + "<br/>" + "has started up in SIlicon Valley CA,with happy provides "
            + "<br/>" + "a full-service system for brand owner, Trader,Exporter looking for"
            + "<br/>" + " complete cost effective to protecting your business and your customer." + "</html>";

    /**
     * Creates new form ContactUs
     */
    public ContactUs() {
        initComponents();
        bin();
        setIcon();
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }
        lblText.setText(jep);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblText = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnSendFeedback = new javax.swing.JButton();
        lblFb = new javax.swing.JLabel();
        lblYoutube = new javax.swing.JLabel();
        lblTwitter = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(12, 30, 33));

        jPanel2.setBackground(new java.awt.Color(12, 30, 33));

        btnBack.setBackground(new java.awt.Color(12, 30, 33));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 204, 0));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/back-arrow.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.setToolTipText("Click to go back to Main Page");
        btnBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        btnBack.setContentAreaFilled(false);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.setFocusPainted(false);
        btnBack.setMaximumSize(new java.awt.Dimension(55, 17));
        btnBack.setMinimumSize(new java.awt.Dimension(55, 17));
        btnBack.setPreferredSize(new java.awt.Dimension(52, 17));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        logoutBtn.setBackground(new java.awt.Color(12, 30, 33));
        logoutBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 204, 0));
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/logout (1).png"))); // NOI18N
        logoutBtn.setToolTipText("Click to Logout");
        logoutBtn.setActionCommand("Logout");
        logoutBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtn.setLabel("Logout");
        logoutBtn.setName("logoutBtn"); // NOI18N
        logoutBtn.setPreferredSize(new java.awt.Dimension(90, 35));
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(12, 30, 33));

        jLabel2.setBackground(new java.awt.Color(12, 30, 33));
        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 33)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("ANTI-COUNTERFEITING");

        jLabel5.setBackground(new java.awt.Color(12, 30, 33));
        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("AUTHENTICITY GUARENTEED 100% ");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setBackground(new java.awt.Color(12, 30, 33));
        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("SERVICE ONLINE 24 x 7");

        lblText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblText.setForeground(new java.awt.Color(255, 204, 0));
        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(147, 147, 147))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addContainerGap(318, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(12, 30, 33));

        btnSendFeedback.setBackground(new java.awt.Color(12, 30, 33));
        btnSendFeedback.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSendFeedback.setForeground(new java.awt.Color(255, 204, 0));
        btnSendFeedback.setText("Send Feedback");
        btnSendFeedback.setBorderPainted(false);
        btnSendFeedback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSendFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendFeedbackActionPerformed(evt);
            }
        });

        lblFb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/1495211853_social_facebook_box_blue.png"))); // NOI18N
        lblFb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFbMouseClicked(evt);
            }
        });

        lblYoutube.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/1495212065_Youtube.png"))); // NOI18N
        lblYoutube.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblYoutube.setIconTextGap(0);
        lblYoutube.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblYoutubeMouseClicked(evt);
            }
        });

        lblTwitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/1495212032_square-twitter.png"))); // NOI18N
        lblTwitter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTwitter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTwitterMouseClicked(evt);
            }
        });

        jLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/JeptagBackground cropped 75.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("Software Design By Jeptags USA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(lblFb)
                        .addGap(18, 18, 18)
                        .addComponent(lblTwitter)
                        .addGap(29, 29, 29)
                        .addComponent(lblYoutube))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnSendFeedback))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel)))
                .addContainerGap(272, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(53, 53, 53))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSendFeedback)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTwitter)
                    .addComponent(lblFb)
                    .addComponent(lblYoutube))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1385, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 801, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bin() {
        setExtendedState(MAXIMIZED_BOTH);
    }

    private void onLaunchBrowser() {
        try {
            desktop.browse(URI.create(url));
        } catch (IOException ioe) {
            System.out.println("The system cannot find the " + url);
            System.out.println("IOException-- " + ioe);
        }

    }

    private void onLaunchMail() {
        String mailTo = "";
        URI uriMailTo = null;
        try {
            if (mailTo.length() > 0) {
                uriMailTo = new URI("mailto", mailTo, null);
                desktop.mail(uriMailTo);
            } else {
                desktop.mail();
            }
        } catch (IOException | URISyntaxException ioe) {
            System.out.println("Exception --- " + ioe);
        }
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Main ad = new Main();
        ad.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?", "Jep Tags", JOptionPane.OK_CANCEL_OPTION);
        if (response != -1 && response != 2) {
            dispose();
            Login l = new Login();
            l.setVisible(true);
        }
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void btnSendFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendFeedbackActionPerformed
        onLaunchMail();
    }//GEN-LAST:event_btnSendFeedbackActionPerformed

    private void lblFbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFbMouseClicked
        url = "https://www.facebook.com/jep.tags.9";
        onLaunchBrowser();
    }//GEN-LAST:event_lblFbMouseClicked

    private void lblYoutubeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblYoutubeMouseClicked
        url = "https://www.youtube.com/channel/UC2rrWBC_QUOdcD1KtF9RgDg";
        onLaunchBrowser();
    }//GEN-LAST:event_lblYoutubeMouseClicked

    private void lblTwitterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTwitterMouseClicked
        url = "https://twitter.com/jep_tags?lang=en";
        onLaunchBrowser();
    }//GEN-LAST:event_lblTwitterMouseClicked
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/lue/jeptags/image/icon.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSendFeedback;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblFb;
    private javax.swing.JLabel lblText;
    private javax.swing.JLabel lblTwitter;
    private javax.swing.JLabel lblYoutube;
    private javax.swing.JButton logoutBtn;
    // End of variables declaration//GEN-END:variables
}
