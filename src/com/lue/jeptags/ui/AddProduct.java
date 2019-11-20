package com.lue.jeptags.ui;

import com.lue.jeptags.dao.BrandDao;
import com.lue.jeptags.dao.CategoryDao;
import com.lue.jeptags.dao.ProductDao;
import com.lue.jeptags.dao.SellerAddressDao;
import com.lue.jeptags.entity.CountryList;
import com.lue.jeptags.entity.SellerStoreAddress;
import com.lue.jeptags.json.reponse.BrandModal;
import com.lue.jeptags.json.reponse.CategoryModall;
import com.sun.glass.events.KeyEvent;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class AddProduct extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private String mode = "";
    private List<String> cat = new ArrayList<>();
    private List<String> subCat = new ArrayList<>();
    private List<String> catId1;
    private List<String> catName;
    private List<String> subCatId1 = new ArrayList<>();
    private List<String> subCatName = new ArrayList<>();
    private List<String> brandId = new ArrayList<>();
    private List<String> brandName = new ArrayList<>();
    private ListIterator<String> itr;
    private String catId, subCatId;
    private final CategoryDao catDao = new CategoryDao();
    private String imgFileName1, imgFileName2, imgFileName3, imgFileName4, imgFileName5 = " ";
    private String baseImage1, baseImage2, baseImage3, baseImage4, baseImage5 = "";
    DefaultTableModel model;
    private String brandValue, prodCondition = "";
//    online  = 237 offline  = 238
    private String address = "";
    private static String lati, longi;
    private String country_id = "";
    private String image64 = "";

    public AddProduct() {

        bin();
        initComponents();
        setIcon();
        getSellerAddress();
//        cat = catDao.getCategory();
//        itr = cat.listIterator();
//        catName.add("----Select----");
//        catId1.add("0");
//        while (itr.hasNext()) {
//            catId1.add(itr.next());
//            catName.add(itr.next());
//        }
          CategoryModall catgMod=catDao.getCategory();
          catId1=catgMod.getCatId1();
          catName=catgMod.getCatName();

        categoryCmb.setModel(new DefaultComboBoxModel(catName.toArray()));
        BrandDao br = new BrandDao();

//        brand = br.getBrand();
//        ListIterator<String> itrBrand;
//        itrBrand = brand.listIterator();
//        brandId.add("0");
//        brandName.add("---Select----");
//        while (itrBrand.hasNext()) {
//            brandId.add(itrBrand.next());
//            brandName.add(itrBrand.next());
//        }
        BrandModal brandModal=br.getBrand();
        brandId=brandModal.getBrandId();
        brandName=brandModal.getBrandName();

        brandNameCmb.setModel(new DefaultComboBoxModel(brandName.toArray()));
        //if(countryCmb.getItemCount()<1){
        Iterator iter = CountryList.getCountryList().keySet().iterator();
        while (iter.hasNext()) {
            this.countryCmb.addItem((String) CountryList.getCountryList().get(iter.next()));
        }
       // }
    }

    private void bin() {
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addressPnl = new javax.swing.JPanel();
        lblFname = new javax.swing.JLabel();
        lblLName = new javax.swing.JLabel();
        lblSAddress = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        lblSProvince = new javax.swing.JLabel();
        lblZipCode = new javax.swing.JLabel();
        txtFName = new javax.swing.JTextField();
        txtLName = new javax.swing.JTextField();
        txtSAddress = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtSProvince = new javax.swing.JTextField();
        txtZipCode = new javax.swing.JTextField();
        lblAddressDetails = new javax.swing.JLabel();
        countryCmb = new javax.swing.JComboBox<>();
        lblLatitude = new javax.swing.JLabel();
        txtLatitude = new javax.swing.JTextField();
        lblLongitute = new javax.swing.JLabel();
        btnAddressCancel = new javax.swing.JButton();
        txtLongitude = new javax.swing.JTextField();
        btnSaveNewAddress = new javax.swing.JButton();
        txtTelephone = new javax.swing.JTextField();
        lblTelephone = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlMain = new javax.swing.JPanel();
        productDetailsPnl = new javax.swing.JPanel();
        lblProductName = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        lblCategory = new javax.swing.JLabel();
        categoryCmb = new javax.swing.JComboBox<>();
        lblDescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDescription = new javax.swing.JTextArea();
        lblWeight = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        subCategoryCmb = new javax.swing.JComboBox<>();
        lblSubCategory = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtWeight = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        descCount = new javax.swing.JLabel();
        btnSaveProduct = new javax.swing.JButton();
        lblBrandName = new javax.swing.JLabel();
        lblProdCondition = new javax.swing.JLabel();
        prodConditionCmb = new javax.swing.JComboBox<>();
        brandNameCmb = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        addressArea = new javax.swing.JTextArea();
        imagesPanel = new javax.swing.JPanel();
        lblAd1 = new javax.swing.JLabel();
        lblAd2 = new javax.swing.JLabel();
        lblAd3 = new javax.swing.JLabel();
        lblAd4 = new javax.swing.JLabel();
        lblAd5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        topPanel = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        addressPnl.setBackground(new java.awt.Color(12, 30, 33));

        lblFname.setBackground(new java.awt.Color(12, 30, 33));
        lblFname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFname.setForeground(new java.awt.Color(255, 204, 0));
        lblFname.setText("Firstname");

        lblLName.setBackground(new java.awt.Color(12, 30, 33));
        lblLName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLName.setForeground(new java.awt.Color(255, 204, 0));
        lblLName.setText("Lastname");

        lblSAddress.setBackground(new java.awt.Color(12, 30, 33));
        lblSAddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSAddress.setForeground(new java.awt.Color(255, 204, 0));
        lblSAddress.setText("Street Address");

        lblCity.setBackground(new java.awt.Color(12, 30, 33));
        lblCity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCity.setForeground(new java.awt.Color(255, 204, 0));
        lblCity.setText("City");

        lblCountry.setBackground(new java.awt.Color(12, 30, 33));
        lblCountry.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCountry.setForeground(new java.awt.Color(255, 204, 0));
        lblCountry.setText("Country");

        lblSProvince.setBackground(new java.awt.Color(12, 30, 33));
        lblSProvince.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSProvince.setForeground(new java.awt.Color(255, 204, 0));
        lblSProvince.setText("State/Province");

        lblZipCode.setBackground(new java.awt.Color(12, 30, 33));
        lblZipCode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblZipCode.setForeground(new java.awt.Color(255, 204, 0));
        lblZipCode.setText("Zip Code");

        txtFName.setBackground(new java.awt.Color(12, 30, 33));
        txtFName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFName.setForeground(new java.awt.Color(255, 204, 0));

        txtLName.setBackground(new java.awt.Color(12, 30, 33));
        txtLName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtLName.setForeground(new java.awt.Color(255, 204, 0));

        txtSAddress.setBackground(new java.awt.Color(12, 30, 33));
        txtSAddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSAddress.setForeground(new java.awt.Color(255, 204, 0));

        txtCity.setBackground(new java.awt.Color(12, 30, 33));
        txtCity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCity.setForeground(new java.awt.Color(255, 204, 0));

        txtSProvince.setBackground(new java.awt.Color(12, 30, 33));
        txtSProvince.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSProvince.setForeground(new java.awt.Color(255, 204, 0));

        txtZipCode.setBackground(new java.awt.Color(12, 30, 33));
        txtZipCode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtZipCode.setForeground(new java.awt.Color(255, 204, 0));

        lblAddressDetails.setBackground(new java.awt.Color(12, 30, 33));
        lblAddressDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAddressDetails.setForeground(new java.awt.Color(255, 204, 0));
        lblAddressDetails.setText("Fill Address Details");

        countryCmb.setBackground(new java.awt.Color(12, 30, 33));
        countryCmb.setForeground(new java.awt.Color(255, 204, 0));
        countryCmb.setBorder(null);
        countryCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryCmbActionPerformed(evt);
            }
        });

        lblLatitude.setBackground(new java.awt.Color(12, 30, 33));
        lblLatitude.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLatitude.setForeground(new java.awt.Color(255, 204, 0));
        lblLatitude.setText("Latitude");

        txtLatitude.setBackground(new java.awt.Color(12, 30, 33));
        txtLatitude.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtLatitude.setForeground(new java.awt.Color(255, 204, 0));

        lblLongitute.setBackground(new java.awt.Color(12, 30, 33));
        lblLongitute.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLongitute.setForeground(new java.awt.Color(255, 204, 0));
        lblLongitute.setText("Longitude");

        btnAddressCancel.setBackground(new java.awt.Color(12, 30, 33));
        btnAddressCancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddressCancel.setForeground(new java.awt.Color(255, 204, 0));
        btnAddressCancel.setText("Cancel");
        btnAddressCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddressCancelActionPerformed(evt);
            }
        });

        txtLongitude.setBackground(new java.awt.Color(12, 30, 33));
        txtLongitude.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtLongitude.setForeground(new java.awt.Color(255, 204, 0));

        btnSaveNewAddress.setBackground(new java.awt.Color(12, 30, 33));
        btnSaveNewAddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveNewAddress.setForeground(new java.awt.Color(255, 204, 0));
        btnSaveNewAddress.setText("Save");
        btnSaveNewAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNewAddressActionPerformed(evt);
            }
        });

        txtTelephone.setBackground(new java.awt.Color(12, 30, 33));
        txtTelephone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTelephone.setForeground(new java.awt.Color(255, 204, 0));

        lblTelephone.setBackground(new java.awt.Color(12, 30, 33));
        lblTelephone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTelephone.setForeground(new java.awt.Color(255, 204, 0));
        lblTelephone.setText("Telephone");

        javax.swing.GroupLayout addressPnlLayout = new javax.swing.GroupLayout(addressPnl);
        addressPnl.setLayout(addressPnlLayout);
        addressPnlLayout.setHorizontalGroup(
            addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addressPnlLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addressPnlLayout.createSequentialGroup()
                        .addComponent(lblAddressDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(addressPnlLayout.createSequentialGroup()
                        .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addressPnlLayout.createSequentialGroup()
                                .addComponent(lblLongitute, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(txtLongitude))
                            .addGroup(addressPnlLayout.createSequentialGroup()
                                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblLatitude, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblFname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblLName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblSAddress, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblCountry, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblZipCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblSProvince, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtZipCode)
                                    .addComponent(txtSProvince)
                                    .addComponent(txtCity)
                                    .addComponent(countryCmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtLName)
                                    .addComponent(txtSAddress)
                                    .addComponent(txtLatitude)
                                    .addComponent(txtFName)
                                    .addComponent(txtTelephone, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(addressPnlLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(btnSaveNewAddress)
                                .addGap(21, 21, 21)
                                .addComponent(btnAddressCancel)
                                .addGap(0, 70, Short.MAX_VALUE)))
                        .addGap(25, 25, 25))))
        );
        addressPnlLayout.setVerticalGroup(
            addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addressPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddressDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFname)
                    .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLName)
                    .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSAddress))
                .addGap(18, 18, 18)
                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCity)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCountry)
                    .addComponent(countryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSProvince)
                    .addComponent(txtSProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblZipCode)
                    .addComponent(txtZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelephone))
                .addGap(18, 18, 18)
                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLatitude)
                    .addComponent(txtLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLongitute)
                    .addComponent(txtLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(addressPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddressCancel)
                    .addComponent(btnSaveNewAddress))
                .addGap(50, 50, 50))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/noimage.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(12, 30, 33));
        setUndecorated(true);
        setResizable(false);

        pnlMain.setBackground(new java.awt.Color(12, 30, 33));
        pnlMain.setAutoscrolls(true);
        pnlMain.setPreferredSize(new java.awt.Dimension(1350, 750));

        productDetailsPnl.setBackground(new java.awt.Color(12, 30, 33));
        productDetailsPnl.setPreferredSize(new java.awt.Dimension(556, 660));

        lblProductName.setBackground(new java.awt.Color(12, 30, 33));
        lblProductName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblProductName.setForeground(new java.awt.Color(255, 204, 0));
        lblProductName.setText("Product Name");

        txtProductName.setBackground(new java.awt.Color(12, 30, 33));
        txtProductName.setForeground(new java.awt.Color(255, 204, 0));

        lblCategory.setBackground(new java.awt.Color(12, 30, 33));
        lblCategory.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCategory.setForeground(new java.awt.Color(255, 204, 0));
        lblCategory.setText("Category");

        categoryCmb.setBackground(new java.awt.Color(12, 30, 33));
        categoryCmb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        categoryCmb.setForeground(new java.awt.Color(255, 204, 0));
        categoryCmb.setBorder(null);
        categoryCmb.setPreferredSize(new java.awt.Dimension(6, 20));
        categoryCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryCmbActionPerformed(evt);
            }
        });

        lblDescription.setBackground(new java.awt.Color(12, 30, 33));
        lblDescription.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(255, 204, 0));
        lblDescription.setText("Description");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBar(null);

        txtAreaDescription.setBackground(new java.awt.Color(12, 30, 33));
        txtAreaDescription.setColumns(20);
        txtAreaDescription.setForeground(new java.awt.Color(255, 204, 0));
        txtAreaDescription.setLineWrap(true);
        txtAreaDescription.setRows(5);
        txtAreaDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAreaDescriptionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtAreaDescription);

        lblWeight.setBackground(new java.awt.Color(12, 30, 33));
        lblWeight.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWeight.setForeground(new java.awt.Color(255, 204, 0));
        lblWeight.setText("Weight");

        lblPrice.setBackground(new java.awt.Color(12, 30, 33));
        lblPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(255, 204, 0));
        lblPrice.setText("Price");

        lblQuantity.setBackground(new java.awt.Color(12, 30, 33));
        lblQuantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(255, 204, 0));
        lblQuantity.setText("Quantity");

        txtPrice.setBackground(new java.awt.Color(12, 30, 33));
        txtPrice.setForeground(new java.awt.Color(255, 204, 0));
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
        });

        txtQuantity.setBackground(new java.awt.Color(12, 30, 33));
        txtQuantity.setForeground(new java.awt.Color(255, 204, 0));
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantityKeyTyped(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(12, 30, 33));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 0, 0));
        btnCancel.setText("Cancel");
        btnCancel.setBorder(null);
        btnCancel.setBorderPainted(false);
        btnCancel.setContentAreaFilled(false);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setFocusPainted(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        subCategoryCmb.setBackground(new java.awt.Color(12, 30, 33));
        subCategoryCmb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        subCategoryCmb.setForeground(new java.awt.Color(255, 204, 0));
        subCategoryCmb.setBorder(null);
        subCategoryCmb.setPreferredSize(new java.awt.Dimension(6, 20));
        subCategoryCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subCategoryCmbActionPerformed(evt);
            }
        });

        lblSubCategory.setBackground(new java.awt.Color(12, 30, 33));
        lblSubCategory.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSubCategory.setForeground(new java.awt.Color(255, 204, 0));
        lblSubCategory.setText("Sub Category");

        jComboBox1.setBackground(new java.awt.Color(12, 30, 33));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 204, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kg" }));

        txtWeight.setBackground(new java.awt.Color(12, 30, 33));
        txtWeight.setForeground(new java.awt.Color(255, 204, 0));
        txtWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWeightActionPerformed(evt);
            }
        });
        txtWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtWeightKeyTyped(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(12, 30, 33));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 204, 0));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USD" }));

        descCount.setBackground(new java.awt.Color(12, 30, 33));
        descCount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        descCount.setForeground(new java.awt.Color(255, 204, 0));

        btnSaveProduct.setBackground(new java.awt.Color(255, 255, 255));
        btnSaveProduct.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSaveProduct.setForeground(new java.awt.Color(0, 102, 204));
        btnSaveProduct.setText("Save ");
        btnSaveProduct.setBorder(null);
        btnSaveProduct.setBorderPainted(false);
        btnSaveProduct.setContentAreaFilled(false);
        btnSaveProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveProduct.setFocusPainted(false);
        btnSaveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProductActionPerformed(evt);
            }
        });

        lblBrandName.setBackground(new java.awt.Color(12, 30, 33));
        lblBrandName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblBrandName.setForeground(new java.awt.Color(255, 204, 0));
        lblBrandName.setText("Brand Name");

        lblProdCondition.setBackground(new java.awt.Color(12, 30, 33));
        lblProdCondition.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblProdCondition.setForeground(new java.awt.Color(255, 204, 0));
        lblProdCondition.setText("Product Condition");

        prodConditionCmb.setBackground(new java.awt.Color(12, 30, 33));
        prodConditionCmb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prodConditionCmb.setForeground(new java.awt.Color(255, 204, 0));
        prodConditionCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New", "Refurbished" }));
        prodConditionCmb.setBorder(null);
        prodConditionCmb.setPreferredSize(new java.awt.Dimension(6, 20));
        prodConditionCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodConditionCmbActionPerformed(evt);
            }
        });

        brandNameCmb.setBackground(new java.awt.Color(12, 30, 33));
        brandNameCmb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        brandNameCmb.setForeground(new java.awt.Color(255, 204, 0));
        brandNameCmb.setBorder(null);
        brandNameCmb.setPreferredSize(new java.awt.Dimension(6, 20));
        brandNameCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandNameCmbActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(12, 30, 33));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Address");

        addressArea.setEditable(false);
        addressArea.setBackground(new java.awt.Color(12, 30, 33));
        addressArea.setColumns(20);
        addressArea.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        addressArea.setForeground(new java.awt.Color(255, 204, 0));
        addressArea.setRows(2);
        addressArea.setBorder(null);
        jScrollPane2.setViewportView(addressArea);

        javax.swing.GroupLayout productDetailsPnlLayout = new javax.swing.GroupLayout(productDetailsPnl);
        productDetailsPnl.setLayout(productDetailsPnlLayout);
        productDetailsPnlLayout.setHorizontalGroup(
            productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productDetailsPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(productDetailsPnlLayout.createSequentialGroup()
                        .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescription)
                            .addComponent(lblSubCategory))
                        .addGap(73, 73, 73)
                        .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(categoryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(prodConditionCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(brandNameCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subCategoryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblBrandName)
                    .addComponent(lblProductName)
                    .addComponent(lblProdCondition)
                    .addComponent(lblCategory)
                    .addGroup(productDetailsPnlLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(jScrollPane2))
                    .addGroup(productDetailsPnlLayout.createSequentialGroup()
                        .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrice)
                            .addGroup(productDetailsPnlLayout.createSequentialGroup()
                                .addComponent(lblWeight)
                                .addGap(56, 56, 56)
                                .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPrice)
                                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnSaveProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancel)
                            .addGroup(productDetailsPnlLayout.createSequentialGroup()
                                .addComponent(lblQuantity)
                                .addGap(31, 31, 31)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productDetailsPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(descCount, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        productDetailsPnlLayout.setVerticalGroup(
            productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productDetailsPnlLayout.createSequentialGroup()
                .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productDetailsPnlLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBrandName))
                    .addComponent(brandNameCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProdCondition)
                    .addComponent(prodConditionCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductName)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCategory)
                    .addComponent(categoryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubCategory)
                    .addComponent(subCategoryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productDetailsPnlLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(productDetailsPnlLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(lblDescription)))
                .addGap(2, 2, 2)
                .addComponent(descCount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productDetailsPnlLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)))
                .addGap(25, 25, 25)
                .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWeight)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantity))
                .addGap(25, 25, 25)
                .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(productDetailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        imagesPanel.setBackground(new java.awt.Color(12, 30, 33));
        imagesPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imagesPanel.setPreferredSize(new java.awt.Dimension(249, 660));

        lblAd1.setBackground(new java.awt.Color(12, 30, 33));
        lblAd1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png"))); // NOI18N
        lblAd1.setToolTipText("Click to Add Image");
        lblAd1.setAutoscrolls(true);
        lblAd1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblAd1.setOpaque(true);
        lblAd1.setPreferredSize(new java.awt.Dimension(150, 140));
        lblAd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAd1MousePressed(evt);
            }
        });

        lblAd2.setBackground(new java.awt.Color(12, 30, 33));
        lblAd2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png"))); // NOI18N
        lblAd2.setToolTipText("Click to Add Image");
        lblAd2.setAutoscrolls(true);
        lblAd2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblAd2.setOpaque(true);
        lblAd2.setPreferredSize(new java.awt.Dimension(150, 140));
        lblAd2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAd2MousePressed(evt);
            }
        });

        lblAd3.setBackground(new java.awt.Color(12, 30, 33));
        lblAd3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAd3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png"))); // NOI18N
        lblAd3.setToolTipText("Click to Add Image");
        lblAd3.setAutoscrolls(true);
        lblAd3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblAd3.setOpaque(true);
        lblAd3.setPreferredSize(new java.awt.Dimension(100, 100));
        lblAd3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAd3MousePressed(evt);
            }
        });

        lblAd4.setBackground(new java.awt.Color(12, 30, 33));
        lblAd4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAd4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png"))); // NOI18N
        lblAd4.setToolTipText("Click to Add Image");
        lblAd4.setAutoscrolls(true);
        lblAd4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblAd4.setOpaque(true);
        lblAd4.setPreferredSize(new java.awt.Dimension(100, 100));
        lblAd4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAd4MousePressed(evt);
            }
        });

        lblAd5.setBackground(new java.awt.Color(12, 30, 33));
        lblAd5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAd5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png"))); // NOI18N
        lblAd5.setToolTipText("Click to Add Image");
        lblAd5.setAutoscrolls(true);
        lblAd5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblAd5.setOpaque(true);
        lblAd5.setPreferredSize(new java.awt.Dimension(100, 100));
        lblAd5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblAd5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout imagesPanelLayout = new javax.swing.GroupLayout(imagesPanel);
        imagesPanel.setLayout(imagesPanelLayout);
        imagesPanelLayout.setHorizontalGroup(
            imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imagesPanelLayout.createSequentialGroup()
                        .addComponent(lblAd1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(lblAd2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(imagesPanelLayout.createSequentialGroup()
                        .addComponent(lblAd3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(lblAd5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagesPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblAd4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)))
                .addGap(20, 20, 20))
        );
        imagesPanelLayout.setVerticalGroup(
            imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagesPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAd1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAd2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAd3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAd5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(lblAd4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(0, 102, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 102, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator1.setOpaque(true);
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 660));

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("Software Design By Jeptags USA");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(imagesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(productDetailsPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(74, 74, 74))))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(imagesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(productDetailsPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );

        imagesPanel.getAccessibleContext().setAccessibleName("");
        imagesPanel.getAccessibleContext().setAccessibleDescription("");

        topPanel.setBackground(new java.awt.Color(51, 51, 0));
        topPanel.setPreferredSize(new java.awt.Dimension(1350, 90));

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 204));
        jLabel3.setText("WE WILL PROTECT YOUR BRAND");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(333, 333, 333)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1349, Short.MAX_VALUE))
                    .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearAllControls();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProductActionPerformed
        Boolean bName = true, condition = true, bPName = true, bCat = true, bSubCat = true, bDesc = true, bWeight = true, bPrice = true, bQuantity = true, img = true;

        if (brandNameCmb.getSelectedIndex() >= 0) {
            int index = brandNameCmb.getSelectedIndex();
            brandValue = (String) brandId.get(index);
        }

        String message1 = "<html><b> These fields cannot be left blank \n";
        String message2 = "<html><b> These fields cannot be left blank \n";

        if (image64.isEmpty() || image64 == null) {
            String noImgPath = jLabel2.getIcon().toString();
            noImgPath = noImgPath.replaceFirst("file", "");
            noImgPath = noImgPath.substring(1);
            image64 = convertImgToBase64(noImgPath);
        }

        if (brandNameCmb.getSelectedIndex() < 1) {
            bName = false;
            message1 = message1 + "Brand Name" + "\n";
            message2 = message2 + "Brand Name" + "\n";

        }
        if (prodConditionCmb.getSelectedItem() == null) {
            message1 = message1 + "Product Condition" + "\n";
            message2 = message2 + "Product Condition" + "\n";
        }
        if (txtProductName.getText().isEmpty()) {
            bPName = false;
            message1 = message1 + "Product Name" + "\n";
            message2 = message2 + "Product Name" + "\n";
        }
        if (categoryCmb.getSelectedItem() == null) {
            bCat = false;
            message1 = message1 + "Category" + "\n";
            message2 = message2 + "Category" + "\n";
        }
        if (subCategoryCmb.getSelectedItem() == null) {
            bSubCat = false;
            message1 = message1 + " Sub Category" + "\n";
            message2 = message2 + "Sub Category" + "\n";
        }
        if (txtAreaDescription.getText().isEmpty()) {
            bDesc = false;
            message1 = message1 + "Description" + "\n";
            message2 = message2 + "Description" + "\n";
        }
        if (txtWeight.getText().isEmpty()) {
            bWeight = false;
            message2 = message2 + "Weight" + "\n";
        }
        if (txtPrice.getText().isEmpty()) {
            bPrice = false;
            message2 = message2 + "Price" + "\n";
        }
        if (txtQuantity.getText().isEmpty()) {
            bQuantity = false;
            message1 = message1 + "Quantity" + "\n";
            message2 = message2 + "Quantity" + "\n";
        }
        JPanel panel = new JPanel();
        JRadioButton rb1 = new JRadioButton("Offline");
        JRadioButton rb2 = new JRadioButton("Online");

        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);

        panel.add(rb1);
        panel.add(rb2);

        JOptionPane.showMessageDialog(productDetailsPnl, panel);

        if (rb1.isSelected()) {
            mode = "238";
            if (bName == false || condition == false || bPName == false || bCat == false || bSubCat == false || bDesc == false || bQuantity == false) {
                JOptionPane.showMessageDialog(null, message1, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else if (rb2.isSelected()) {
            mode = "237";
            if (bName == false || condition == false || bPName == false || bCat == false || bSubCat == false || bDesc == false || bWeight == false || bQuantity == false || bPrice == false) {
                JOptionPane.showMessageDialog(null, message2, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        String productName = txtProductName.getText();
        String category;
        if (subCategoryCmb.getItemCount() == 0) {
            category = catId;
        } else {
            category = subCatId;
        }
        String description = txtAreaDescription.getText();
        String weight = txtWeight.getText();
        String price = txtPrice.getText();
        String quantity = txtQuantity.getText();

        ProductDao pr = new ProductDao();

        boolean status = pr.uploadProduct(brandValue, prodCondition, productName, category, description, weight, price, quantity, address, mode, image64);
        if (!status) {
            JOptionPane.showMessageDialog(productDetailsPnl, "Product could not be saved", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(productDetailsPnl, "Product saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

            UploadProduct upl = new UploadProduct();
            upl.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnSaveProductActionPerformed

    private void categoryCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCmbActionPerformed
        if (categoryCmb.getSelectedIndex() > 0) {
            if (subCategoryCmb.getItemCount() != 0) {
                subCategoryCmb.removeAllItems();
                subCat.clear();
                subCatId1.clear();
                subCatName.clear();
            }
            catId = catId1.get(categoryCmb.getSelectedIndex());

            subCat = catDao.getSubCategoryList(catId);
            itr = subCat.listIterator();

            subCatId1.add("0");
            subCatName.add("----Select----");
            while (itr.hasNext()) {
                subCatId1.add(itr.next());
                subCatName.add(itr.next());
            }
            subCategoryCmb.setModel(new DefaultComboBoxModel(subCatName.toArray()));
    }//GEN-LAST:event_categoryCmbActionPerformed
    }

    private void subCategoryCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subCategoryCmbActionPerformed
        if (subCategoryCmb.getItemCount() != 0) {
            subCatId = subCatId1.get(subCategoryCmb.getSelectedIndex());
        }
    }//GEN-LAST:event_subCategoryCmbActionPerformed

    private void txtWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWeightActionPerformed

    }//GEN-LAST:event_txtWeightActionPerformed

    private void txtWeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWeightKeyTyped
        char vchar = evt.getKeyChar();
        if (Character.isLetter(vchar) && !evt.isAltDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_txtWeightKeyTyped

    private void txtQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyTyped
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar))
                || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantityKeyTyped

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        char vchar = evt.getKeyChar();
        if (Character.isLetter(vchar) && !evt.isAltDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPriceKeyTyped

    private void prodConditionCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodConditionCmbActionPerformed
        if (prodConditionCmb.getSelectedItem() == "New") {
            prodCondition = "446";
        } else if (prodConditionCmb.getSelectedItem() == "Refurbished") {
            prodCondition = "447";
        }
    }//GEN-LAST:event_prodConditionCmbActionPerformed

    private void brandNameCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandNameCmbActionPerformed

    }//GEN-LAST:event_brandNameCmbActionPerformed

    private void btnSaveNewAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNewAddressActionPerformed
        String address1 = txtFName.getText()
                + txtLName.getText() + ','
                + txtCity.getText() + ','
                + txtSAddress.getText() + ','
                + txtSProvince.getText() + ','
                + txtZipCode.getText() + ','
                + country_id + ','
                + txtTelephone.getText() + ','
                + txtLatitude.getText() + ','
                + txtLongitude.getText();
        address = address1;
        boolean error = new SellerAddressDao().addStoreAddress(txtFName.getText(), txtLName.getText(), txtSAddress.getText(), txtCity.getText(), txtSProvince.getText(), country_id, txtZipCode.getText(), txtTelephone.getText(), txtLatitude.getText(), txtLongitude.getText());
        if (error) {
            JOptionPane.showMessageDialog(null, "Address saved Succesfully", "Success", JOptionPane.PLAIN_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Error saving Address", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveNewAddressActionPerformed

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

    private void countryCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryCmbActionPerformed
        String countryName = (String) countryCmb.getSelectedItem();
        HashMap country = CountryList.getCountryList();
        for (Object o : country.keySet()) {
            if (country.get(o).equals(countryName)) {
                country_id = (String) o;
            }
        }
    }//GEN-LAST:event_countryCmbActionPerformed

    private void lblAd2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAd2MousePressed
        imgFileName2 = getImageFile();
        if (imgFileName2.isEmpty() || imgFileName2 == null) {
//            lblAd2.setIcon(new ImageIcon(new ImageIcon("/com/lue/jeptags/image/Plus Math-50.png").getImage()));
            lblAd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png")));

        } else {
            lblAd2.setIcon(new ImageIcon(new ImageIcon(imgFileName2).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
            baseImage2 = convertImgToBase64(imgFileName2);
            if (image64.isEmpty() || image64 == null) {
                image64 = baseImage2;
            } else {
                image64 = image64 + ',' + baseImage2;
            }
        }
    }//GEN-LAST:event_lblAd2MousePressed

    private void lblAd1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAd1MousePressed
        imgFileName1 = getImageFile();
        if (imgFileName1.isEmpty() || imgFileName1 == null) {
//            lblAd1.setIcon(new ImageIcon(new ImageIcon("/com/lue/jeptags/image/Plus Math-50.png").getImage()));
            lblAd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png")));
        } else {
            lblAd1.setIcon(new ImageIcon(new ImageIcon(imgFileName1).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
            baseImage1 = convertImgToBase64(imgFileName1);
            if (image64.isEmpty() || image64 == null) {
                image64 = baseImage1;
            } else {
                image64 = image64 + ',' + baseImage1;
            }
        }
    }//GEN-LAST:event_lblAd1MousePressed

    private void lblAd3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAd3MousePressed
        imgFileName3 = getImageFile();
        if (imgFileName3.isEmpty() || imgFileName3 == null) {
//            lblAd3.setIcon(new ImageIcon(new ImageIcon("/com/lue/jeptags/image/Plus Math-50.png").getImage()));
            lblAd3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png")));

        } else {
            lblAd3.setIcon(new ImageIcon(new ImageIcon(imgFileName3).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
            baseImage3 = convertImgToBase64(imgFileName3);
            if (image64.isEmpty() || image64 == null) {
                image64 = baseImage3;
            } else {
                image64 = image64 + ',' + baseImage3;
            }
        }
    }//GEN-LAST:event_lblAd3MousePressed

    private void lblAd5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAd5MousePressed
        imgFileName5 = getImageFile();
        if (imgFileName5.isEmpty() || imgFileName5 == null) {
//            lblAd5.setIcon(new ImageIcon(new ImageIcon("/com/lue/jeptags/image/Plus Math-50.png").getImage()));
            lblAd5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png")));

        } else {
            lblAd5.setIcon(new ImageIcon(new ImageIcon(imgFileName5).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
            baseImage5 = convertImgToBase64(imgFileName5);
            if (image64.isEmpty() || image64 == null) {
                image64 = baseImage4;
            } else {
                image64 = image64 + ',' + baseImage5;
            }
        }
    }//GEN-LAST:event_lblAd5MousePressed

    private void lblAd4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAd4MousePressed
        imgFileName4 = getImageFile();
        if (imgFileName4.isEmpty() || imgFileName4 == null) {
//            lblAd4.setIcon(new ImageIcon(new ImageIcon("/com/lue/jeptags/image/Plus Math-50.png").getImage()));
            lblAd4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png")));

        } else {
            lblAd4.setIcon(new ImageIcon(new ImageIcon(imgFileName4).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
            baseImage4 = convertImgToBase64(imgFileName4);
            if (image64.isEmpty() || image64 == null) {
                image64 = baseImage4;
            } else {
                image64 = image64 + ',' + baseImage4;
            }
        }
    }//GEN-LAST:event_lblAd4MousePressed

    private void txtAreaDescriptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaDescriptionKeyTyped
        char vchar = evt.getKeyChar();
        descCount.setText(txtAreaDescription.getText().length() + "/200");

        if (txtAreaDescription.getText().length() >= 200) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAreaDescriptionKeyTyped

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?", "Jep Tags", JOptionPane.OK_CANCEL_OPTION);
        if (response != -1 && response != 2) {
            dispose();
            Login l = new Login();
            l.setVisible(true);
        }
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        UploadProduct upl = new UploadProduct();
        upl.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    public String getImageFile() {
        String fileName = "";
        try {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(filter);
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                fileName = fileChooser.getSelectedFile().toString();
            }
        } catch (HeadlessException e) {
            System.out.println("Exception" + e.toString());
        }
        return fileName;

    }

    private String convertImgToBase64(String image) {
        String base64Image = "";
        String imgFile = image;

        File file = new File(imgFile);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a Image file from file system
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);
            base64Image = Base64.getEncoder().encodeToString(imageData);
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
        return base64Image;
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/lue/jeptags/image/icon.png")));
    }

    private void clearAllControls() {
        brandNameCmb.setSelectedIndex(0);
        categoryCmb.setSelectedIndex(0);
        subCategoryCmb.setSelectedIndex(0);
        prodConditionCmb.setSelectedIndex(0);

        txtProductName.setText("");
        txtAreaDescription.setText("");
        txtWeight.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
    }

    private void getSellerAddress() {
        SellerAddressDao sdao = new SellerAddressDao();
        SellerStoreAddress addressL = sdao.getSellerStoreAddress();
        String lblAddress = "";
        if (!addressL.toString().isEmpty() || addressL.toString() != null) {
            address = addressL.getStreet();

            address = address + ',' + addressL.getCity();

            address = address + ',' + addressL.getPostcode();

            Object nameCountry = CountryList.getCountryList().get(addressL.getCountry_id());
            address = address + ',' + addressL.getCountry_id();

            address = address + ',' + addressL.getGeo_latitude();
            lati = addressL.getGeo_latitude();

            address = address + ',' + addressL.getGeo_longitude();
            longi = addressL.getGeo_longitude();

            lblAddress = "<html>" + addressL.getStreet()
                    + "<br/>" + addressL.getCity()
                    + "<br/>" + addressL.getPostcode()
                    + "<br/>" + nameCountry + "</html>";

        }
        addressArea.setText(address);
        addressArea.setLineWrap(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressArea;
    private javax.swing.JPanel addressPnl;
    private javax.swing.JComboBox<String> brandNameCmb;
    private javax.swing.JButton btnAddressCancel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSaveNewAddress;
    private javax.swing.JButton btnSaveProduct;
    private javax.swing.JComboBox<String> categoryCmb;
    private javax.swing.JComboBox<String> countryCmb;
    private javax.swing.JLabel descCount;
    private javax.swing.JPanel imagesPanel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAd1;
    private javax.swing.JLabel lblAd2;
    private javax.swing.JLabel lblAd3;
    private javax.swing.JLabel lblAd4;
    private javax.swing.JLabel lblAd5;
    private javax.swing.JLabel lblAddressDetails;
    private javax.swing.JLabel lblBrandName;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblFname;
    private javax.swing.JLabel lblLName;
    private javax.swing.JLabel lblLatitude;
    private javax.swing.JLabel lblLongitute;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProdCondition;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSAddress;
    private javax.swing.JLabel lblSProvince;
    private javax.swing.JLabel lblSubCategory;
    private javax.swing.JLabel lblTelephone;
    private javax.swing.JLabel lblWeight;
    private javax.swing.JLabel lblZipCode;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JComboBox<String> prodConditionCmb;
    private javax.swing.JPanel productDetailsPnl;
    private javax.swing.JComboBox<String> subCategoryCmb;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextArea txtAreaDescription;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtLatitude;
    private javax.swing.JTextField txtLongitude;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSAddress;
    private javax.swing.JTextField txtSProvince;
    private javax.swing.JTextField txtTelephone;
    private javax.swing.JTextField txtWeight;
    private javax.swing.JTextField txtZipCode;
    // End of variables declaration//GEN-END:variables

}
