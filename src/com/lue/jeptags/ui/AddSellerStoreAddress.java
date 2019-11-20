package com.lue.jeptags.ui;

import com.lue.jeptags.dao.SellerAddressDao;
import com.lue.jeptags.entity.CountryList;
import com.lue.jeptags.util.LoginValidation;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author lue
 */
public class AddSellerStoreAddress extends javax.swing.JFrame {

    private String country_id;
    static HashMap<String, String> country;

    /**
     * Creates new form NewJFrame6
     */
    public AddSellerStoreAddress() {
        initComponents();
        bin();
        setIcon();
        if(country==null)
        country = CountryList.getCountryList();
        
        Iterator iter = CountryList.getCountryList().keySet().iterator();
        while (iter.hasNext()) {
            this.countryCmb.addItem((String) CountryList.getCountryList().get(iter.next()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        lblAddressDetails = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblFname = new javax.swing.JLabel();
        txtFName = new javax.swing.JTextField();
        lblSAddress = new javax.swing.JLabel();
        txtSAddress = new javax.swing.JTextField();
        lblLName = new javax.swing.JLabel();
        txtLName = new javax.swing.JTextField();
        lblCity = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        lblCountry = new javax.swing.JLabel();
        countryCmb = new javax.swing.JComboBox<>();
        lblSProvince = new javax.swing.JLabel();
        txtSProvince = new javax.swing.JTextField();
        lblZipCode = new javax.swing.JLabel();
        txtZipCode = new javax.swing.JTextField();
        lblTelephone = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JTextField();
        lblLatitude = new javax.swing.JLabel();
        txtLatitude = new javax.swing.JTextField();
        lblLongitute = new javax.swing.JLabel();
        txtLongitude = new javax.swing.JTextField();
        btnSaveNewAddress = new javax.swing.JButton();
        btnAddressCancel = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
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

        lblAddressDetails.setBackground(new java.awt.Color(12, 30, 33));
        lblAddressDetails.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        lblAddressDetails.setForeground(new java.awt.Color(0, 51, 255));
        lblAddressDetails.setText("Add Seller Store Adress");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177)
                .addComponent(lblAddressDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddressDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel3.setBackground(new java.awt.Color(12, 30, 33));

        jPanel5.setBackground(new java.awt.Color(33, 30, 12));

        lblFname.setBackground(new java.awt.Color(12, 30, 33));
        lblFname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFname.setForeground(new java.awt.Color(255, 204, 0));
        lblFname.setText("FirstName:");

        txtFName.setBackground(new java.awt.Color(12, 30, 33));
        txtFName.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtFName.setForeground(new java.awt.Color(255, 204, 0));

        lblSAddress.setBackground(new java.awt.Color(12, 30, 33));
        lblSAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSAddress.setForeground(new java.awt.Color(255, 204, 0));
        lblSAddress.setText("Street Address:");

        txtSAddress.setBackground(new java.awt.Color(12, 30, 33));
        txtSAddress.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtSAddress.setForeground(new java.awt.Color(255, 204, 0));

        lblLName.setBackground(new java.awt.Color(12, 30, 33));
        lblLName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLName.setForeground(new java.awt.Color(255, 204, 0));
        lblLName.setText("Lastname");

        txtLName.setBackground(new java.awt.Color(12, 30, 33));
        txtLName.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtLName.setForeground(new java.awt.Color(255, 204, 0));

        lblCity.setBackground(new java.awt.Color(12, 30, 33));
        lblCity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCity.setForeground(new java.awt.Color(255, 204, 0));
        lblCity.setText("City:");

        txtCity.setBackground(new java.awt.Color(12, 30, 33));
        txtCity.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtCity.setForeground(new java.awt.Color(255, 204, 0));

        lblCountry.setBackground(new java.awt.Color(12, 30, 33));
        lblCountry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCountry.setForeground(new java.awt.Color(255, 204, 0));
        lblCountry.setText("Country:");

        countryCmb.setBackground(new java.awt.Color(12, 30, 33));
        countryCmb.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        countryCmb.setForeground(new java.awt.Color(255, 204, 0));
        countryCmb.setBorder(null);
        countryCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryCmbActionPerformed(evt);
            }
        });

        lblSProvince.setBackground(new java.awt.Color(12, 30, 33));
        lblSProvince.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSProvince.setForeground(new java.awt.Color(255, 204, 0));
        lblSProvince.setText("State/Province");

        txtSProvince.setBackground(new java.awt.Color(12, 30, 33));
        txtSProvince.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtSProvince.setForeground(new java.awt.Color(255, 204, 0));

        lblZipCode.setBackground(new java.awt.Color(12, 30, 33));
        lblZipCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblZipCode.setForeground(new java.awt.Color(255, 204, 0));
        lblZipCode.setText("Zip Code:");

        txtZipCode.setBackground(new java.awt.Color(12, 30, 33));
        txtZipCode.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtZipCode.setForeground(new java.awt.Color(255, 204, 0));

        lblTelephone.setBackground(new java.awt.Color(12, 30, 33));
        lblTelephone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTelephone.setForeground(new java.awt.Color(255, 204, 0));
        lblTelephone.setText("Telephone:");

        txtTelephone.setBackground(new java.awt.Color(12, 30, 33));
        txtTelephone.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtTelephone.setForeground(new java.awt.Color(255, 204, 0));

        lblLatitude.setBackground(new java.awt.Color(12, 30, 33));
        lblLatitude.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLatitude.setForeground(new java.awt.Color(255, 204, 0));
        lblLatitude.setText("Latitude:");

        txtLatitude.setBackground(new java.awt.Color(12, 30, 33));
        txtLatitude.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtLatitude.setForeground(new java.awt.Color(255, 204, 0));

        lblLongitute.setBackground(new java.awt.Color(12, 30, 33));
        lblLongitute.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLongitute.setForeground(new java.awt.Color(255, 204, 0));
        lblLongitute.setText("Longitude:");

        txtLongitude.setBackground(new java.awt.Color(12, 30, 33));
        txtLongitude.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtLongitude.setForeground(new java.awt.Color(255, 204, 0));

        btnSaveNewAddress.setBackground(new java.awt.Color(12, 30, 33));
        btnSaveNewAddress.setFont(new java.awt.Font("Traditional Arabic", 1, 30)); // NOI18N
        btnSaveNewAddress.setForeground(new java.awt.Color(0, 102, 255));
        btnSaveNewAddress.setText("Save");
        btnSaveNewAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveNewAddress.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSaveNewAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNewAddressActionPerformed(evt);
            }
        });

        btnAddressCancel.setBackground(new java.awt.Color(12, 30, 33));
        btnAddressCancel.setFont(new java.awt.Font("Traditional Arabic", 1, 30)); // NOI18N
        btnAddressCancel.setForeground(new java.awt.Color(255, 0, 0));
        btnAddressCancel.setText("Cancel");
        btnAddressCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddressCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddressCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddressCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSAddress)
                                    .addComponent(lblFname, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFName)
                                    .addComponent(txtSAddress)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblZipCode))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(countryCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtZipCode)
                                    .addComponent(txtLatitude)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblLatitude)
                                .addGap(263, 263, 263)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(btnSaveNewAddress)
                        .addGap(32, 32, 32)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAddressCancel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLName)
                                    .addComponent(lblCity, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtLName, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(txtCity)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSProvince)
                                    .addComponent(lblTelephone)
                                    .addComponent(lblLongitute))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSProvince, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(txtTelephone)
                                    .addComponent(txtLongitude))))
                        .addGap(28, 28, 28))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFname)
                    .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLName)
                    .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblSAddress))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCity))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCountry)
                    .addComponent(countryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSProvince)
                        .addComponent(txtSProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblZipCode)
                            .addComponent(txtZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelephone))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLatitude)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblLongitute))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveNewAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddressCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 85, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(12, 30, 33));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/JeptagBackground cropped 75.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("Software Design By Jeptags USA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(170, 170, 170))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(45, 45, 45))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1483, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 725, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bin() {
        setExtendedState(MAXIMIZED_BOTH);
    }


    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        redirectForm();
    }//GEN-LAST:event_btnBackActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?", "Jep Tags", JOptionPane.OK_CANCEL_OPTION);
        if (response != -1 && response != 2) {
            dispose();
            Login l = new Login();
            l.setVisible(true);
        }
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void countryCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryCmbActionPerformed
        String countryName = (String) countryCmb.getSelectedItem();
        for (String o : country.keySet()) {
            if (country.get(o).equals(countryName)) {
                country_id = (String) o;
            }
        }
    }//GEN-LAST:event_countryCmbActionPerformed

    private void btnAddressCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddressCancelActionPerformed
        txtFName.setText("");
        txtLName.setText("");
        txtCity.setText("");
        txtSAddress.setText("");
        txtSProvince.setText("");
        txtZipCode.setText("");
        txtLatitude.setText("");
        txtLongitude.setText("");
        countryCmb.setSelectedIndex(-1);
    }//GEN-LAST:event_btnAddressCancelActionPerformed

    private void btnSaveNewAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNewAddressActionPerformed

        boolean error = new SellerAddressDao().addStoreAddress(txtFName.getText(), txtLName.getText(), txtSAddress.getText(), txtCity.getText(), txtSProvince.getText(), country_id, txtZipCode.getText(), txtTelephone.getText(), txtLatitude.getText(), txtLongitude.getText());
        if (error) {
            JOptionPane.showMessageDialog(null, "Address saved Succesfully", "Success", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Error saving Address", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveNewAddressActionPerformed
    private void redirectForm() {
        if (LoginValidation.ROLE.equals("admin")) {
            this.dispose();
            new MainAdmin().setVisible(true);
        }
        if (LoginValidation.ROLE.equals("seller")) {
            this.dispose();
            new Main().setVisible(true);
        }
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/lue/jeptags/image/icon.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddressCancel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSaveNewAddress;
    private javax.swing.JComboBox<String> countryCmb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblAddressDetails;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblFname;
    private javax.swing.JLabel lblLName;
    private javax.swing.JLabel lblLatitude;
    private javax.swing.JLabel lblLongitute;
    private javax.swing.JLabel lblSAddress;
    private javax.swing.JLabel lblSProvince;
    private javax.swing.JLabel lblTelephone;
    private javax.swing.JLabel lblZipCode;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtLatitude;
    private javax.swing.JTextField txtLongitude;
    private javax.swing.JTextField txtSAddress;
    private javax.swing.JTextField txtSProvince;
    private javax.swing.JTextField txtTelephone;
    private javax.swing.JTextField txtZipCode;
    // End of variables declaration//GEN-END:variables
}
