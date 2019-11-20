package com.lue.jeptags.ui;

import com.lue.jeptags.dao.SellerAddressDao;
import com.lue.jeptags.dao.SellerProfileDao;
import com.lue.jeptags.entity.CountryList;
import com.lue.jeptags.entity.Sellers;
import com.lue.jeptags.util.LoginValidation;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author lue
 */
public class MainAdmin extends javax.swing.JFrame {

    List<Sellers> sellers;
    private String seller_id = "";
    SellerAddressDao sdao = new SellerAddressDao();

    /**
     * Creates new form AdminAdmin
     */
    public MainAdmin() {
        initComponents();
        setIcon();
        centerFrame();
        bin();
        sellers = new SellerProfileDao().getSellerList();
        populateData();

    }

    private void bin() {
        setExtendedState(MAXIMIZED_BOTH);
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/lue/jeptags/image/icon.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addressPnl = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblStreetV = new javax.swing.JLabel();
        lblZipV = new javax.swing.JLabel();
        lblCityV = new javax.swing.JLabel();
        lblContryV = new javax.swing.JLabel();
        lblStateV = new javax.swing.JLabel();
        lblTelephoneV = new javax.swing.JLabel();
        uploadProdBtn = new javax.swing.JButton();
        lblFNameV = new javax.swing.JLabel();
        lblStoreNameV = new javax.swing.JLabel();
        lblEmailV = new javax.swing.JLabel();
        scanNFCBtn = new javax.swing.JButton();
        mainPnl = new javax.swing.JPanel();
        topPnl = new javax.swing.JPanel();
        logoutBtn = new javax.swing.JButton();
        sellerPnl1 = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        sellerJList = new javax.swing.JList<>();
        txtSearch = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        addressPnl.setBackground(new java.awt.Color(12, 30, 33));
        addressPnl.setPreferredSize(new java.awt.Dimension(1040, 680));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Full Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("Email");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("Store Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("Store Address");

        jPanel3.setBackground(new java.awt.Color(12, 30, 33));
        jPanel3.setForeground(new java.awt.Color(255, 204, 0));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 0));
        jLabel5.setText("Street Address");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("City");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 0));
        jLabel7.setText("State");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 0));
        jLabel8.setText("Zip");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 204, 0));
        jLabel9.setText("Country");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 0));
        jLabel10.setText("Telephone/Mobile");

        lblStreetV.setBackground(new java.awt.Color(12, 30, 33));
        lblStreetV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStreetV.setForeground(new java.awt.Color(255, 204, 0));

        lblZipV.setBackground(new java.awt.Color(12, 30, 33));
        lblZipV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblZipV.setForeground(new java.awt.Color(255, 204, 0));

        lblCityV.setBackground(new java.awt.Color(12, 30, 33));
        lblCityV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCityV.setForeground(new java.awt.Color(255, 204, 0));

        lblContryV.setBackground(new java.awt.Color(12, 30, 33));
        lblContryV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblContryV.setForeground(new java.awt.Color(255, 204, 0));

        lblStateV.setBackground(new java.awt.Color(12, 30, 33));
        lblStateV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStateV.setForeground(new java.awt.Color(255, 204, 0));

        lblTelephoneV.setBackground(new java.awt.Color(12, 30, 33));
        lblTelephoneV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTelephoneV.setForeground(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCityV, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStreetV, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContryV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblZipV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addComponent(lblStateV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblTelephoneV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lblStreetV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lblCityV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(lblStateV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(lblZipV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblContryV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTelephoneV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel10)
                        .addGap(49, 49, 49))))
        );

        uploadProdBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        uploadProdBtn.setForeground(new java.awt.Color(255, 204, 0));
        uploadProdBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/blue 75.png"))); // NOI18N
        uploadProdBtn.setText("Upload Products");
        uploadProdBtn.setBorder(null);
        uploadProdBtn.setBorderPainted(false);
        uploadProdBtn.setContentAreaFilled(false);
        uploadProdBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadProdBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        uploadProdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadProdBtnActionPerformed(evt);
            }
        });

        lblFNameV.setBackground(new java.awt.Color(12, 30, 33));
        lblFNameV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFNameV.setForeground(new java.awt.Color(255, 204, 0));

        lblStoreNameV.setBackground(new java.awt.Color(12, 30, 33));
        lblStoreNameV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStoreNameV.setForeground(new java.awt.Color(255, 204, 0));

        lblEmailV.setBackground(new java.awt.Color(12, 30, 33));
        lblEmailV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEmailV.setForeground(new java.awt.Color(255, 204, 0));

        scanNFCBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        scanNFCBtn.setForeground(new java.awt.Color(255, 204, 0));
        scanNFCBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/blue 75.png"))); // NOI18N
        scanNFCBtn.setText("Scan Jeptags");
        scanNFCBtn.setBorder(null);
        scanNFCBtn.setBorderPainted(false);
        scanNFCBtn.setContentAreaFilled(false);
        scanNFCBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scanNFCBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        scanNFCBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanNFCBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addressPnlLayout = new javax.swing.GroupLayout(addressPnl);
        addressPnl.setLayout(addressPnlLayout);
        addressPnlLayout.setHorizontalGroup(
            addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addressPnlLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addressPnlLayout.createSequentialGroup()
                        .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFNameV, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmailV, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(addressPnlLayout.createSequentialGroup()
                        .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addressPnlLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66))
                            .addGroup(addressPnlLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)))
                        .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStoreNameV, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scanNFCBtn)
                    .addComponent(uploadProdBtn))
                .addGap(72, 72, 72))
        );
        addressPnlLayout.setVerticalGroup(
            addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addressPnlLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFNameV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addressPnlLayout.createSequentialGroup()
                        .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(lblEmailV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(lblStoreNameV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addGroup(addressPnlLayout.createSequentialGroup()
                        .addComponent(scanNFCBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(uploadProdBtn)
                        .addGap(36, 36, 36))))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(12, 30, 33));
        setUndecorated(true);
        setResizable(false);

        mainPnl.setBackground(new java.awt.Color(12, 30, 33));
        mainPnl.setPreferredSize(new java.awt.Dimension(1350, 750));

        topPnl.setBackground(new java.awt.Color(12, 30, 33));
        topPnl.setPreferredSize(new java.awt.Dimension(1350, 70));

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

        javax.swing.GroupLayout topPnlLayout = new javax.swing.GroupLayout(topPnl);
        topPnl.setLayout(topPnlLayout);
        topPnlLayout.setHorizontalGroup(
            topPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPnlLayout.createSequentialGroup()
                .addContainerGap(1258, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        topPnlLayout.setVerticalGroup(
            topPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        sellerPnl1.setBackground(new java.awt.Color(12, 30, 33));
        sellerPnl1.setPreferredSize(new java.awt.Dimension(310, 680));

        jScrollPane.setBackground(new java.awt.Color(12, 30, 33));
        jScrollPane.setBorder(null);
        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        sellerJList.setBackground(new java.awt.Color(12, 30, 33));
        sellerJList.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sellerJList.setForeground(new java.awt.Color(255, 204, 0));
        jScrollPane.setViewportView(sellerJList);

        txtSearch.setBackground(new java.awt.Color(12, 30, 33));
        txtSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(255, 204, 0));

        searchBtn.setBackground(new java.awt.Color(12, 30, 33));
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/search.png"))); // NOI18N
        searchBtn.setContentAreaFilled(false);
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sellerPnl1Layout = new javax.swing.GroupLayout(sellerPnl1);
        sellerPnl1.setLayout(sellerPnl1Layout);
        sellerPnl1Layout.setHorizontalGroup(
            sellerPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sellerPnl1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(sellerPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sellerPnl1Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBtn))))
        );
        sellerPnl1Layout.setVerticalGroup(
            sellerPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sellerPnl1Layout.createSequentialGroup()
                .addGroup(sellerPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sellerPnl1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel5.setBackground(new java.awt.Color(12, 30, 33));
        jPanel5.setPreferredSize(new java.awt.Dimension(1040, 680));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Scan part 640.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 255));
        jLabel11.setText("Software Design By Jeptags USA");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 255));
        jButton1.setText("Import Tag");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(132, 132, 132)
                .addComponent(jLabel11)
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPnlLayout = new javax.swing.GroupLayout(mainPnl);
        mainPnl.setLayout(mainPnlLayout);
        mainPnlLayout.setHorizontalGroup(
            mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPnlLayout.createSequentialGroup()
                .addGroup(mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPnlLayout.createSequentialGroup()
                        .addComponent(sellerPnl1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(topPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 1384, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        mainPnlLayout.setVerticalGroup(
            mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPnlLayout.createSequentialGroup()
                .addComponent(topPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sellerPnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1384, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 1384, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void uploadProdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadProdBtnActionPerformed

        LoginValidation.SELLER_ID = seller_id;

        UploadProduct upl = new UploadProduct();
        upl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_uploadProdBtnActionPerformed

    private void scanNFCBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanNFCBtnActionPerformed
        ScanJepTags scj = new ScanJepTags();
        scj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_scanNFCBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
       String search = txtSearch.getText();
        sellerJList.removeAll();
        DefaultListModel model = new DefaultListModel();
        for (Sellers sellers1 : sellers) {
            if ((sellers1.getSeller_id().contains(search)) || (sellers1.getFullname().contains(search)) || (sellers1.getEmail().contains(search))) {
                seller_id = sellers1.getSeller_id();
                String list = "<html>"
                        + "Seller Id:   " + sellers1.getSeller_id()
                        + "<br/>"
                        + "Name:    " + sellers1.getFullname()
                        + "<br/>"
                        + "Email:    " + sellers1.getEmail()
                        + "<br/>"
                        + "<br/>"
                        + "</html>";
                model.addElement(list);
            }
        }
        sellerJList.setModel(model);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         ImportTagId iti=new ImportTagId();
        iti.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void populateData() {
        DefaultListModel model = new DefaultListModel();
        for (Sellers sellers1 : sellers) {
            String list = "<html>"
                    + "Seller Id:   " + sellers1.getSeller_id()
                    + "<br/>"
                    + "Name:    " + sellers1.getFullname()
                    + "<br/>"
                    + "Email:    " + sellers1.getEmail()
                    + "<br/>"
                    + "<br/>"
                    + "</html>";
            model.addElement(list);
        }
        sellerJList.setModel(model);
        sellerJList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();

                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());

                    seller_id = (sellers.get(index).getSeller_id());
                    lblFNameV.setText(sellers.get(index).getFullname());
                    lblEmailV.setText(sellers.get(index).getEmail());
                    lblStoreNameV.setText(sellers.get(index).getStorename());
                    lblStreetV.setText(sellers.get(index).getStreet());
                    lblZipV.setText(sellers.get(index).getPostcode());
                    lblCityV.setText(sellers.get(index).getCity());

                    HashMap country = CountryList.getCountryList();
                    Object value = country.get(sellers.get(index).getCountry_id());
                    lblContryV.setText((String) value);
                    LoginValidation.SELLER_ID = seller_id;
                    SellerAddressDao sdao = new SellerAddressDao();
                    if (!sdao.checkSellerDefaultAddress()) {
                        dispose();
                        AddSellerStoreAddress asdsa = new AddSellerStoreAddress();
//                        AddSellerStoreAddress asdsa = new AddSellerStoreAddress();
                        asdsa.setVisible(true);
                    } else {

                        if (!sdao.checkStoreAddressStatus()) {
                            addressPnl.remove(uploadProdBtn);
                            uploadProdBtn.setEnabled(false);
                            uploadProdBtn.setVisible(false);
                            addressPnl.repaint();
                            addressPnl.revalidate();
//            JOptionPane.showMessageDialog(centerPanel, "Your Address has not been approved", "Information", JOptionPane.INFORMATION_MESSAGE);

                            jPanel5.removeAll();
                            addressPnl.setVisible(true);
                            jPanel5.setLayout(new java.awt.BorderLayout());
                            jPanel5.add(addressPnl);
                            jPanel5.repaint();
                            jPanel5.revalidate();
                        } else {
                            jPanel5.removeAll();
                            addressPnl.setVisible(true);
                            jPanel5.setLayout(new java.awt.BorderLayout());
                            jPanel5.add(addressPnl);
                            jPanel5.repaint();
                            jPanel5.revalidate();
                        }
                    }
                }
            }
        });

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addressPnl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel lblCityV;
    private javax.swing.JLabel lblContryV;
    private javax.swing.JLabel lblEmailV;
    private javax.swing.JLabel lblFNameV;
    private javax.swing.JLabel lblStateV;
    private javax.swing.JLabel lblStoreNameV;
    private javax.swing.JLabel lblStreetV;
    private javax.swing.JLabel lblTelephoneV;
    private javax.swing.JLabel lblZipV;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel mainPnl;
    private javax.swing.JButton scanNFCBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JList<String> sellerJList;
    private javax.swing.JPanel sellerPnl1;
    private javax.swing.JPanel topPnl;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JButton uploadProdBtn;
    // End of variables declaration//GEN-END:variables

}
