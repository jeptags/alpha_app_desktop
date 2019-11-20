package com.lue.jeptags.ui;

import com.lue.jeptags.dao.SellerProfileDao;
import com.lue.jeptags.entity.CountryList;
import com.lue.jeptags.entity.SellerProfile;
import java.awt.Toolkit;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author lue
 */
public class Profile extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame6
     */
    public Profile() {
        initComponents();
        bin();
        populate();
        setIcon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblProfileDetails = new javax.swing.JLabel();
        lblFName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblStorename = new javax.swing.JLabel();
        lblStoreId = new javax.swing.JLabel();
        lblContry1 = new javax.swing.JLabel();
        lblContry = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblPCode = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        txtFName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtStorename = new javax.swing.JTextField();
        txtStoreId = new javax.swing.JTextField();
        txtStreet = new javax.swing.JTextField();
        txtCountry = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtPcode = new javax.swing.JTextField();
        txtPhoneNo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

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
                .addContainerGap())
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

        lblProfileDetails.setBackground(new java.awt.Color(12, 30, 33));
        lblProfileDetails.setFont(new java.awt.Font("Traditional Arabic", 1, 32)); // NOI18N
        lblProfileDetails.setForeground(new java.awt.Color(0, 51, 255));
        lblProfileDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProfileDetails.setText("Profile Details");
        lblProfileDetails.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblFName.setBackground(new java.awt.Color(12, 30, 33));
        lblFName.setFont(new java.awt.Font("Traditional Arabic", 1, 28)); // NOI18N
        lblFName.setForeground(new java.awt.Color(255, 204, 0));
        lblFName.setText("Full Name");

        lblEmail.setBackground(new java.awt.Color(12, 30, 33));
        lblEmail.setFont(new java.awt.Font("Traditional Arabic", 1, 28)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 204, 0));
        lblEmail.setText("E mail");

        lblStorename.setBackground(new java.awt.Color(12, 30, 33));
        lblStorename.setFont(new java.awt.Font("Traditional Arabic", 1, 28)); // NOI18N
        lblStorename.setForeground(new java.awt.Color(255, 204, 0));
        lblStorename.setText("Store Name");

        lblStoreId.setBackground(new java.awt.Color(12, 30, 33));
        lblStoreId.setFont(new java.awt.Font("Traditional Arabic", 1, 28)); // NOI18N
        lblStoreId.setForeground(new java.awt.Color(255, 204, 0));
        lblStoreId.setText("Store Id");

        lblContry1.setBackground(new java.awt.Color(12, 30, 33));
        lblContry1.setFont(new java.awt.Font("Traditional Arabic", 1, 28)); // NOI18N
        lblContry1.setForeground(new java.awt.Color(255, 204, 0));
        lblContry1.setText("Street");

        lblContry.setBackground(new java.awt.Color(12, 30, 33));
        lblContry.setFont(new java.awt.Font("Traditional Arabic", 1, 28)); // NOI18N
        lblContry.setForeground(new java.awt.Color(255, 204, 0));
        lblContry.setText("Country");

        lblCity.setBackground(new java.awt.Color(12, 30, 33));
        lblCity.setFont(new java.awt.Font("Traditional Arabic", 1, 28)); // NOI18N
        lblCity.setForeground(new java.awt.Color(255, 204, 0));
        lblCity.setText("City");

        lblPCode.setBackground(new java.awt.Color(12, 30, 33));
        lblPCode.setFont(new java.awt.Font("Traditional Arabic", 1, 28)); // NOI18N
        lblPCode.setForeground(new java.awt.Color(255, 204, 0));
        lblPCode.setText("Postal Code");

        lblPhone.setBackground(new java.awt.Color(12, 30, 33));
        lblPhone.setFont(new java.awt.Font("Traditional Arabic", 1, 28)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(255, 204, 0));
        lblPhone.setText("Phone No");

        txtFName.setEditable(false);
        txtFName.setBackground(new java.awt.Color(12, 30, 33));
        txtFName.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtFName.setForeground(new java.awt.Color(255, 204, 0));
        txtFName.setBorder(null);

        txtEmail.setEditable(false);
        txtEmail.setBackground(new java.awt.Color(12, 30, 33));
        txtEmail.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 204, 0));
        txtEmail.setBorder(null);

        txtStorename.setEditable(false);
        txtStorename.setBackground(new java.awt.Color(12, 30, 33));
        txtStorename.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtStorename.setForeground(new java.awt.Color(255, 204, 0));
        txtStorename.setBorder(null);

        txtStoreId.setEditable(false);
        txtStoreId.setBackground(new java.awt.Color(12, 30, 33));
        txtStoreId.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtStoreId.setForeground(new java.awt.Color(255, 204, 0));
        txtStoreId.setBorder(null);

        txtStreet.setEditable(false);
        txtStreet.setBackground(new java.awt.Color(12, 30, 33));
        txtStreet.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtStreet.setForeground(new java.awt.Color(255, 204, 0));
        txtStreet.setBorder(null);

        txtCountry.setEditable(false);
        txtCountry.setBackground(new java.awt.Color(12, 30, 33));
        txtCountry.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtCountry.setForeground(new java.awt.Color(255, 204, 0));
        txtCountry.setBorder(null);

        txtCity.setEditable(false);
        txtCity.setBackground(new java.awt.Color(12, 30, 33));
        txtCity.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtCity.setForeground(new java.awt.Color(255, 204, 0));
        txtCity.setBorder(null);

        txtPcode.setEditable(false);
        txtPcode.setBackground(new java.awt.Color(12, 30, 33));
        txtPcode.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtPcode.setForeground(new java.awt.Color(255, 204, 0));
        txtPcode.setBorder(null);

        txtPhoneNo.setEditable(false);
        txtPhoneNo.setBackground(new java.awt.Color(12, 30, 33));
        txtPhoneNo.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        txtPhoneNo.setForeground(new java.awt.Color(255, 204, 0));
        txtPhoneNo.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProfileDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFName)
                            .addComponent(lblEmail)
                            .addComponent(lblStorename)
                            .addComponent(lblContry)
                            .addComponent(lblCity)
                            .addComponent(lblPCode)
                            .addComponent(lblPhone)
                            .addComponent(lblStoreId)
                            .addComponent(lblContry1))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCountry)
                            .addComponent(txtPcode)
                            .addComponent(txtPhoneNo)
                            .addComponent(txtFName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtEmail)
                            .addComponent(txtStorename)
                            .addComponent(txtStoreId)
                            .addComponent(txtStreet)
                            .addComponent(txtCity))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblProfileDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFName)
                    .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStorename)
                    .addComponent(txtStorename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStoreId)
                    .addComponent(txtStoreId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContry1)
                    .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContry)
                    .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCity)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPCode)
                    .addComponent(txtPcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(12, 30, 33));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/JeptagBackground cropped 75.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(170, 170, 170))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel11.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 255));
        jLabel11.setText("Software Design By Jeptags USA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(793, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(255, 255, 255))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(696, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(61, 61, 61))
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

    private void populate() {
        SellerProfile profile = new SellerProfileDao().getSellerProfile();

        if (profile != null) {
            txtFName.setText((String) profile.getFullname());
            txtEmail.setText((String) profile.getEmail());
            txtStorename.setText((String) profile.getStorename());
            txtStoreId.setText((String) profile.getStoreid());
            txtStreet.setText((String) profile.getStreet());
            String country_id = (String) profile.getCountry_id();
            txtCity.setText((String) profile.getCity());
            txtPcode.setText((String) profile.getPostcode());
            txtPhoneNo.setText((String) profile.getTelephone());
            HashMap country = CountryList.getCountryList();
            Object value = country.get(country_id);
            txtCountry.setText((String) value);
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
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/lue/jeptags/image/icon.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblContry;
    private javax.swing.JLabel lblContry1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFName;
    private javax.swing.JLabel lblPCode;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblProfileDetails;
    private javax.swing.JLabel lblStoreId;
    private javax.swing.JLabel lblStorename;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtPcode;
    private javax.swing.JTextField txtPhoneNo;
    private javax.swing.JTextField txtStoreId;
    private javax.swing.JTextField txtStorename;
    private javax.swing.JTextField txtStreet;
    // End of variables declaration//GEN-END:variables
}
