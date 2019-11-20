package com.lue.jeptags.ui;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author lue
 */
public class EncodeScanUI1 extends javax.swing.JFrame {

    private Desktop desktop;
    private Desktop.Action action = Desktop.Action.OPEN;
    String url = "";

    public EncodeScanUI1() {
        initComponents();
        centerFrame();
    }

    public EncodeScanUI1(List sendPost) {
        initComponents();
        centerFrame();
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }
        Iterator itr = sendPost.iterator();
        itr.next();
        lblProdID.setText("ID:" + itr.next());
        lblProdName.setText("Name:" + itr.next());
        url = itr.next().toString();
        showSplash();
    }

    private void centerFrame() {
        Dimension windowSize;
        windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }

    private void showSplash() {
        setVisible(true);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblJepTag = new javax.swing.JLabel();
        lblProdName = new javax.swing.JLabel();
        lblProdID = new javax.swing.JLabel();
        goToShoppingBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(12, 30, 33));
        setUndecorated(true);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBackground(new java.awt.Color(12, 30, 33));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(330, 300));

        lblJepTag.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblJepTag.setForeground(new java.awt.Color(255, 204, 0));
        lblJepTag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/^9CAA7273D6A88ACA18241AF5CD0882A77F42FF17C76039B1CF^pimgpsh_fullsize_distr.png"))); // NOI18N
        lblJepTag.setText("JepTagShop.com");
        lblJepTag.setIconTextGap(6);

        lblProdName.setBackground(new java.awt.Color(12, 30, 33));
        lblProdName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblProdName.setForeground(new java.awt.Color(255, 204, 0));

        lblProdID.setBackground(new java.awt.Color(12, 30, 33));
        lblProdID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblProdID.setForeground(new java.awt.Color(255, 204, 0));

        goToShoppingBtn.setBackground(new java.awt.Color(12, 30, 33));
        goToShoppingBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        goToShoppingBtn.setForeground(new java.awt.Color(255, 204, 0));
        goToShoppingBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/cart.png"))); // NOI18N
        goToShoppingBtn.setText("Go to Shopping");
        goToShoppingBtn.setBorder(null);
        goToShoppingBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goToShoppingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToShoppingBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJepTag, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProdID, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProdName, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(goToShoppingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJepTag)
                .addGap(18, 18, 18)
                .addComponent(lblProdID, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblProdName, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(goToShoppingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goToShoppingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToShoppingBtnActionPerformed
        onLaunchBrowser();
    }//GEN-LAST:event_goToShoppingBtnActionPerformed
    private void onLaunchBrowser() {
        try {
            desktop.browse(URI.create(url));
        } catch (IOException ioe) {
            System.out.println("The system cannot find the " + url);
            System.out.println("IOException-- " + ioe);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goToShoppingBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblJepTag;
    private javax.swing.JLabel lblProdID;
    private javax.swing.JLabel lblProdName;
    // End of variables declaration//GEN-END:variables
}
