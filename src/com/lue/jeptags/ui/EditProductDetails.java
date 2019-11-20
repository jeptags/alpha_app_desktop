package com.lue.jeptags.ui;

import com.lue.jeptags.util.gFunction;
import RFID.rfid_def;
import RFID.rfidlib_AIP_ISO15693;
import RFID.rfidlib_aip_iso14443A;
import RFID.rfidlib_reader;
import com.lue.jeptags.dao.CategoryDao;
import com.lue.jeptags.dao.ProductDao;
import com.lue.jeptags.entity.EditProductList;
import com.lue.jeptags.entity.Product;
import com.lue.jeptags.json.reponse.CategoryModall;
import com.lue.jeptags.util.EncodingVerify;
import com.lue.jeptags.util.LoginValidation;
import com.sun.glass.events.KeyEvent;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.ListIterator;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import com.lue.jeptags.util.ProductTags;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import javax.swing.filechooser.FileSystemView;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author lue
 */
public class EditProductDetails extends javax.swing.JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    private ProductDao pd = new ProductDao();
    private String imgFileName1, imgFileName2, imgFileName3, imgFileName4, imgFileName5 = "";
    private String baseImage1, baseImage2, baseImage3, baseImage4, baseImage5 = "";
    private List<String> cat, subCat;
    private List<String> catName, catId;
    private List<String> subCatName, subCatId;
    private ListIterator<String> itr, li;
    private String catId1, subCatId1 = "";
    private CategoryDao catDao = new CategoryDao();
   // private List productDetail = new ArrayList();
    private String prodId, qty = "";
    private String[] imgPath;
    private boolean b_inventoryFlg = false;
    private long m_hr = 0;
    private long m_ht = 0;
    DefaultTableModel model;
    private int nret1;
    Thread inventory;
    private String latitude, longitude = "";
    private List<String> tagDetails = new ArrayList<>();
    private int serial = 000;
    private String image64 = "";
    private boolean[] lbl = new boolean[5];
    private static final DateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    EditProductDetails(String product_id) {
        this.li = null;
        prodId = product_id;
        initComponents();
        bin();
        setIcon();

        LoadDriver();
        OpenDev();

        populateFields(prodId);
    }

    private void populateFields(String product) {

        String img = "";
        EditProductList productDetail = pd.getProductDetail(product);

           txtProdID.setText(product);

            txtProdName.setText(productDetail.getMessage().getName());

            catId1 = productDetail.getMessage().getCategory();
            subCatId1 = productDetail.getMessage().getSubcategory();

            txtAreaDesc.setText(productDetail.getMessage().getDescription());
            txtAreaDesc.setWrapStyleWord(true);
            txtAreaDesc.setLineWrap(true);
            txtWeight.setText(productDetail.getMessage().getWeight());
            txtPrice.setText(productDetail.getMessage().getPrice());
            brandTextField.setText(productDetail.getMessage().getBrand_name());
            qty = productDetail.getMessage().getQty();
            txtQty.setText(qty);
            lblQty.setText("QUANTITY: " + "  " + "/" + qty);

            img = Arrays.toString(productDetail.getMessage().getImage());
            latitude = ProductDao.latitude;
            longitude = ProductDao.longitude;
            

        cat = new ArrayList<>();
//        cat = catDao.getCategory();
//        catId = new ArrayList<>();
//        catName = new ArrayList<>();
//        itr = cat.listIterator();
//        while (itr.hasNext()) {
//            catId.add(itr.next());
//            catName.add(itr.next());
//        }

 CategoryModall catgMod=catDao.getCategory();
          catId=catgMod.getCatId1();
          catName=catgMod.getCatName();

        categoryCmb.setModel(new DefaultComboBoxModel(catName.toArray()));
        categoryCmb.setSelectedIndex(catId.indexOf(catId1));

        subCat = new ArrayList<>();
        subCat = catDao.getSubCategoryList(catId1);
        itr = subCat.listIterator();
        subCatId = new ArrayList<>();
        subCatName = new ArrayList<>();
        while (itr.hasNext()) {
            subCatId.add(itr.next());
            subCatName.add(itr.next());
        }

        subCategoryCmb.setModel(new DefaultComboBoxModel(subCatName.toArray()));
        subCategoryCmb.setSelectedIndex(subCatId.indexOf(subCatId1));

        img = img.replace("[", "");
        img = img.replace("]", "");
        imgPath = img.split(",");
        for (int i = 0; i < imgPath.length; i++) {
            try {
                URL url = new URL(imgPath[i]);
                Image image = ImageIO.read(url);
                if (image != null) {
                    image = image.getScaledInstance(180, 180, Image.SCALE_DEFAULT);

                    switch (i) {
                        case 0:
                            lblImg1.setIcon(new ImageIcon(image));
                            break;
                        case 1:
                            lblImg2.setIcon(new ImageIcon(image));
                            break;
                        case 2:
                            lblImg3.setIcon(new ImageIcon(image));
                            break;
                        case 3:
                            lblImg4.setIcon(new ImageIcon(image));
                            break;
                        case 4:
                            lblImg5.setIcon(new ImageIcon(image));
                            break;
                        default:
                            return;
                    }
                }

            } catch (MalformedURLException ex) {
//                Logger.getLogger(EditProductDetails.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("MalformedURLException--- " + ex);

            } catch (IOException ex) {
//                Logger.getLogger(EditProductDetails.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("IOException--- " + ex);
            }
        }
        ProductTags pt = new ProductTags();
        List<String> tags = pt.getProductTags(product);
        if (!tags.isEmpty()) {
            Iterator itr = tags.iterator();
             model = (DefaultTableModel) jTable2.getModel();
            while (itr.hasNext()) {
                serial++;
                model.insertRow(model.getRowCount(), new Object[]{serial, itr.next(), itr.next()});
            }
        }
        lblQty.setText("QUANTITY :" + serial + "/" + qty);
        lblProductId.setText("PRODUCT ID: " + product);
    }

    private void bin() {
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPnl = new javax.swing.JPanel();
        topPnl = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        imgPnl = new javax.swing.JPanel();
        lblImg4 = new javax.swing.JLabel();
        lblImg5 = new javax.swing.JLabel();
        lblImg3 = new javax.swing.JLabel();
        lblImg2 = new javax.swing.JLabel();
        lblImg1 = new javax.swing.JLabel();
        detailsPnl = new javax.swing.JPanel();
        descCount = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblJepTagId = new javax.swing.JLabel();
        txtProdID = new javax.swing.JTextField();
        prodNameLbl = new javax.swing.JLabel();
        txtProdName = new javax.swing.JTextField();
        categoryCmb = new javax.swing.JComboBox<>();
        prodSubIdLbl = new javax.swing.JLabel();
        subCategoryCmb = new javax.swing.JComboBox<>();
        prodIdLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDesc = new javax.swing.JTextArea();
        descLbl = new javax.swing.JLabel();
        weightLbl = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        quantityLbl = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        txtPrice = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        brandTextField = new javax.swing.JTextField();
        scanPnl = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        rb15693 = new javax.swing.JRadioButton();
        rb14443a = new javax.swing.JRadioButton();
        scnBtn = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        lblProductId = new javax.swing.JLabel();
        lblQty = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        importTag = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        mainPnl.setBackground(new java.awt.Color(12, 30, 33));
        mainPnl.setPreferredSize(new java.awt.Dimension(1350, 750));

        topPnl.setBackground(new java.awt.Color(12, 30, 33));
        topPnl.setPreferredSize(new java.awt.Dimension(1350, 90));

        jPanel3.setBackground(new java.awt.Color(51, 49, 17));

        backBtn.setBackground(new java.awt.Color(12, 30, 33));
        backBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 204, 0));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/back-arrow.png"))); // NOI18N
        backBtn.setText("Back");
        backBtn.setToolTipText("Click to go back to Main Page");
        backBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));
        backBtn.setContentAreaFilled(false);
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.setFocusPainted(false);
        backBtn.setMaximumSize(new java.awt.Dimension(55, 17));
        backBtn.setMinimumSize(new java.awt.Dimension(55, 17));
        backBtn.setPreferredSize(new java.awt.Dimension(52, 17));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("WE WILL PROTECT YOUR BRAND");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(376, 376, 376)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 352, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        javax.swing.GroupLayout topPnlLayout = new javax.swing.GroupLayout(topPnl);
        topPnl.setLayout(topPnlLayout);
        topPnlLayout.setHorizontalGroup(
            topPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPnlLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        topPnlLayout.setVerticalGroup(
            topPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        imgPnl.setBackground(new java.awt.Color(12, 30, 33));
        imgPnl.setPreferredSize(new java.awt.Dimension(480, 660));

        lblImg4.setBackground(new java.awt.Color(12, 30, 33));
        lblImg4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImg4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png"))); // NOI18N
        lblImg4.setToolTipText("Click to Add Image");
        lblImg4.setAutoscrolls(true);
        lblImg4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblImg4.setOpaque(true);
        lblImg4.setPreferredSize(new java.awt.Dimension(180, 180));
        lblImg4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblImg4MousePressed(evt);
            }
        });

        lblImg5.setBackground(new java.awt.Color(12, 30, 33));
        lblImg5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImg5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png"))); // NOI18N
        lblImg5.setToolTipText("Click to Add Image");
        lblImg5.setAutoscrolls(true);
        lblImg5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblImg5.setOpaque(true);
        lblImg5.setPreferredSize(new java.awt.Dimension(180, 180));
        lblImg5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblImg5MousePressed(evt);
            }
        });

        lblImg3.setBackground(new java.awt.Color(12, 30, 33));
        lblImg3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png"))); // NOI18N
        lblImg3.setToolTipText("Click to Add Image");
        lblImg3.setAutoscrolls(true);
        lblImg3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblImg3.setOpaque(true);
        lblImg3.setPreferredSize(new java.awt.Dimension(180, 180));
        lblImg3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblImg3MousePressed(evt);
            }
        });

        lblImg2.setBackground(new java.awt.Color(12, 30, 33));
        lblImg2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png"))); // NOI18N
        lblImg2.setToolTipText("Click to Add Image");
        lblImg2.setAutoscrolls(true);
        lblImg2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblImg2.setOpaque(true);
        lblImg2.setPreferredSize(new java.awt.Dimension(180, 180));
        lblImg2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblImg2MousePressed(evt);
            }
        });

        lblImg1.setBackground(new java.awt.Color(12, 30, 33));
        lblImg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png"))); // NOI18N
        lblImg1.setToolTipText("Click to Add Image");
        lblImg1.setAutoscrolls(true);
        lblImg1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblImg1.setOpaque(true);
        lblImg1.setPreferredSize(new java.awt.Dimension(180, 180));
        lblImg1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblImg1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout imgPnlLayout = new javax.swing.GroupLayout(imgPnl);
        imgPnl.setLayout(imgPnlLayout);
        imgPnlLayout.setHorizontalGroup(
            imgPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgPnlLayout.createSequentialGroup()
                .addGroup(imgPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imgPnlLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(lblImg5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(imgPnlLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(imgPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblImg3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(imgPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImg4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        imgPnlLayout.setVerticalGroup(
            imgPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imgPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImg2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(imgPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblImg3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImg4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(lblImg5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(787, Short.MAX_VALUE))
        );

        detailsPnl.setBackground(new java.awt.Color(12, 30, 33));
        detailsPnl.setPreferredSize(new java.awt.Dimension(480, 660));

        descCount.setBackground(new java.awt.Color(12, 30, 33));
        descCount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        descCount.setForeground(new java.awt.Color(255, 204, 0));
        descCount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descCountKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(12, 30, 33));

        lblJepTagId.setBackground(new java.awt.Color(12, 30, 33));
        lblJepTagId.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblJepTagId.setForeground(new java.awt.Color(255, 204, 0));
        lblJepTagId.setText("Product ID :");

        txtProdID.setEditable(false);
        txtProdID.setBackground(new java.awt.Color(12, 30, 33));
        txtProdID.setForeground(new java.awt.Color(255, 204, 0));
        txtProdID.setEnabled(false);
        txtProdID.setFocusable(false);

        prodNameLbl.setBackground(new java.awt.Color(12, 30, 33));
        prodNameLbl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        prodNameLbl.setForeground(new java.awt.Color(255, 204, 0));
        prodNameLbl.setText("Product Name :");

        txtProdName.setBackground(new java.awt.Color(12, 30, 33));
        txtProdName.setForeground(new java.awt.Color(255, 204, 0));

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

        prodSubIdLbl.setBackground(new java.awt.Color(12, 30, 33));
        prodSubIdLbl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        prodSubIdLbl.setForeground(new java.awt.Color(255, 204, 0));
        prodSubIdLbl.setText("Category :");

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

        prodIdLbl.setBackground(new java.awt.Color(12, 30, 33));
        prodIdLbl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        prodIdLbl.setForeground(new java.awt.Color(255, 204, 0));
        prodIdLbl.setText("Sub Category :");

        txtAreaDesc.setBackground(new java.awt.Color(12, 30, 33));
        txtAreaDesc.setColumns(20);
        txtAreaDesc.setForeground(new java.awt.Color(255, 204, 0));
        txtAreaDesc.setRows(5);
        txtAreaDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAreaDescKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtAreaDesc);

        descLbl.setBackground(new java.awt.Color(12, 30, 33));
        descLbl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        descLbl.setForeground(new java.awt.Color(255, 204, 0));
        descLbl.setText("Description :");

        weightLbl.setBackground(new java.awt.Color(12, 30, 33));
        weightLbl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        weightLbl.setForeground(new java.awt.Color(255, 204, 0));
        weightLbl.setText("Weight :");

        txtWeight.setBackground(new java.awt.Color(12, 30, 33));
        txtWeight.setForeground(new java.awt.Color(255, 204, 0));
        txtWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtWeightKeyTyped(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(12, 30, 33));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 204, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kg" }));

        quantityLbl.setBackground(new java.awt.Color(12, 30, 33));
        quantityLbl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        quantityLbl.setForeground(new java.awt.Color(255, 204, 0));
        quantityLbl.setText("Quantity :");

        txtQty.setBackground(new java.awt.Color(12, 30, 33));
        txtQty.setForeground(new java.awt.Color(255, 204, 0));
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQtyKeyTyped(evt);
            }
        });

        jComboBox4.setBackground(new java.awt.Color(12, 30, 33));
        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(255, 204, 0));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USD" }));

        txtPrice.setBackground(new java.awt.Color(12, 30, 33));
        txtPrice.setForeground(new java.awt.Color(255, 204, 0));
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
        });

        lblPrice.setBackground(new java.awt.Color(12, 30, 33));
        lblPrice.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(255, 204, 0));
        lblPrice.setText("Price :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 205, 0));
        jLabel4.setText("Brand Name:");

        brandTextField.setBackground(new java.awt.Color(34, 30, 28));
        brandTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        brandTextField.setForeground(new java.awt.Color(254, 205, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantityLbl)
                            .addComponent(weightLbl))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(prodIdLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(descLbl)
                                    .addComponent(lblPrice))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(categoryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(subCategoryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtProdName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(prodSubIdLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prodNameLbl)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblJepTagId, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtProdID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel4)))
                                .addGap(18, 18, 18)
                                .addComponent(brandTextField)))
                        .addGap(9, 9, 9))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJepTagId)
                    .addComponent(txtProdID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(brandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prodNameLbl)
                    .addComponent(txtProdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodSubIdLbl))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prodIdLbl)
                            .addComponent(subCategoryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(descLbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weightLbl)
                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityLbl)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout detailsPnlLayout = new javax.swing.GroupLayout(detailsPnl);
        detailsPnl.setLayout(detailsPnlLayout);
        detailsPnlLayout.setHorizontalGroup(
            detailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPnlLayout.createSequentialGroup()
                .addGroup(detailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailsPnlLayout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(descCount, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(detailsPnlLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        detailsPnlLayout.setVerticalGroup(
            detailsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(descCount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        scanPnl.setBackground(new java.awt.Color(12, 30, 33));
        scanPnl.setPreferredSize(new java.awt.Dimension(480, 660));

        javax.swing.GroupLayout scanPnlLayout = new javax.swing.GroupLayout(scanPnl);
        scanPnl.setLayout(scanPnlLayout);
        scanPnlLayout.setHorizontalGroup(
            scanPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        scanPnlLayout.setVerticalGroup(
            scanPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1077, Short.MAX_VALUE)
        );

        jSeparator2.setBackground(new java.awt.Color(102, 153, 255));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(12, 30, 33));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(12, 30, 33));

        rb15693.setBackground(new java.awt.Color(12, 30, 33));
        buttonGroup1.add(rb15693);
        rb15693.setForeground(new java.awt.Color(255, 204, 0));
        rb15693.setText("ISO15693");

        rb14443a.setBackground(new java.awt.Color(12, 30, 33));
        buttonGroup1.add(rb14443a);
        rb14443a.setForeground(new java.awt.Color(255, 204, 0));
        rb14443a.setText("ISO14443A");

        scnBtn.setBackground(new java.awt.Color(12, 30, 33));
        scnBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        scnBtn.setForeground(new java.awt.Color(255, 204, 0));
        scnBtn.setText("Scan JepTag");
        scnBtn.setBorder(null);
        scnBtn.setBorderPainted(false);
        scnBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scnBtn.setMaximumSize(new java.awt.Dimension(135, 30));
        scnBtn.setMinimumSize(new java.awt.Dimension(135, 30));
        scnBtn.setPreferredSize(new java.awt.Dimension(135, 30));
        scnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scnBtnActionPerformed(evt);
            }
        });

        stopBtn.setBackground(new java.awt.Color(12, 30, 33));
        stopBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        stopBtn.setForeground(new java.awt.Color(255, 204, 0));
        stopBtn.setText("Stop Scan");
        stopBtn.setBorder(null);
        stopBtn.setBorderPainted(false);
        stopBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stopBtn.setMaximumSize(new java.awt.Dimension(135, 30));
        stopBtn.setMinimumSize(new java.awt.Dimension(135, 30));
        stopBtn.setPreferredSize(new java.awt.Dimension(135, 30));
        stopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(12, 30, 33));
        updateBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 204, 0));
        updateBtn.setText("Update Details");
        updateBtn.setBorder(null);
        updateBtn.setBorderPainted(false);
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.setMaximumSize(new java.awt.Dimension(135, 30));
        updateBtn.setMinimumSize(new java.awt.Dimension(135, 30));
        updateBtn.setPreferredSize(new java.awt.Dimension(135, 30));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        delBtn.setBackground(new java.awt.Color(12, 30, 33));
        delBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        delBtn.setForeground(new java.awt.Color(255, 204, 0));
        delBtn.setText("Delete Product");
        delBtn.setBorder(null);
        delBtn.setBorderPainted(false);
        delBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delBtn.setMaximumSize(new java.awt.Dimension(135, 30));
        delBtn.setMinimumSize(new java.awt.Dimension(135, 30));
        delBtn.setPreferredSize(new java.awt.Dimension(135, 30));
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(rb15693)
                        .addGap(31, 31, 31)
                        .addComponent(rb14443a))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb15693)
                    .addComponent(rb14443a))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        lblProductId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblProductId.setForeground(new java.awt.Color(255, 204, 0));
        lblProductId.setText("PRODUCT ID: ");

        lblQty.setBackground(new java.awt.Color(0, 0, 0));
        lblQty.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblQty.setForeground(new java.awt.Color(255, 255, 255));
        lblQty.setText("QUANTITY :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SCAN CHIP TO PRODUCT");

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setAutoscrolls(true);

        jTable2.setBackground(new java.awt.Color(15, 30, 33));
        jTable2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 204, 0));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sl No.", "JepTag ID", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setColumnSelectionAllowed(true);
        jTable2.setDoubleBuffered(true);
        jTable2.setDragEnabled(true);
        jScrollPane4.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(15);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(140);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Softwre design By jeptags USA");

        importTag.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        importTag.setForeground(new java.awt.Color(0, 153, 255));
        importTag.setText("Import Chip");
        importTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importTagActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPnlLayout = new javax.swing.GroupLayout(mainPnl);
        mainPnl.setLayout(mainPnlLayout);
        mainPnlLayout.setHorizontalGroup(
            mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPnlLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPnlLayout.createSequentialGroup()
                        .addComponent(topPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 1414, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(mainPnlLayout.createSequentialGroup()
                        .addComponent(imgPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(detailsPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPnlLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPnlLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(lblProductId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPnlLayout.createSequentialGroup()
                                .addGroup(mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPnlLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(mainPnlLayout.createSequentialGroup()
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(58, 58, 58))
                                            .addGroup(mainPnlLayout.createSequentialGroup()
                                                .addComponent(lblQty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(72, 72, 72))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPnlLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel2)
                                        .addGap(72, 72, 72))
                                    .addGroup(mainPnlLayout.createSequentialGroup()
                                        .addGap(116, 116, 116)
                                        .addComponent(importTag)
                                        .addGap(199, 199, 199)))
                                .addComponent(scanPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(mainPnlLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        mainPnlLayout.setVerticalGroup(
            mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scanPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 1077, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPnlLayout.createSequentialGroup()
                .addComponent(topPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(imgPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 1454, Short.MAX_VALUE)
                        .addComponent(jSeparator2)
                        .addGroup(mainPnlLayout.createSequentialGroup()
                            .addComponent(detailsPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblProductId)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPnlLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(importTag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblQty)
                        .addGap(147, 147, 147)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(mainPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 1368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 759, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        boolean deleteProduct = pd.deleteProduct(prodId);
        if (deleteProduct) {
            JOptionPane.showMessageDialog(null, "Product deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
             int prodSize=UploadProduct.product.size();
            for(int i=0;i<prodSize;i++){
                 Product prod=UploadProduct.product.get(i);
                 if(prodId.equals(prod.getId())){
                     UploadProduct.product.remove(prod);
                     break;
                 }
             }
            UploadProduct upl = new UploadProduct();
            upl.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Product could not be deleted", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_delBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        for (int i = 0; i < imgPath.length; i++) {

            if (!lbl[i] && !imgPath[i].isEmpty() && imgPath[i] != null) {
                try {
                    byte[] imageBytes = IOUtils.toByteArray(new URL(imgPath[i]));

                    if (image64.isEmpty() || image64 == null) {
                        image64 = Base64.getEncoder().encodeToString(imageBytes);
                    } else {
                        image64 = image64 + ',' + Base64.getEncoder().encodeToString(imageBytes);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Image not found" + e);
                } catch (IOException ioe) {
                    System.out.println("Exception while reading the Image " + ioe);
                }
            }
        }

        String productId = txtProdID.getText();
        String productName = txtProdName.getText();
        String description = txtAreaDesc.getText();
        String weight = txtWeight.getText();
        String price = txtPrice.getText();
        String qty1 = txtQty.getText();
        boolean updateProduct = pd.updateProduct(productId, productName, catId1, subCatId1, description, weight, price, qty1, image64);
        if (!updateProduct) {
            JOptionPane.showMessageDialog(null, "Product updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Product could not be updated", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void scnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scnBtnActionPerformed
        if (!rb14443a.isSelected() && !rb15693.isSelected()) {
            JOptionPane.showMessageDialog(null, "Select a Tag Type", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nret1 != 0) {
            rb15693.setEnabled(true);
            rb14443a.setEnabled(true);
            scnBtn.setEnabled(true);
            stopBtn.setEnabled(false);
            delBtn.setEnabled(false);
        } else {
            scnBtn.setEnabled(false);
            stopBtn.setEnabled(true);
            delBtn.setEnabled(false);
            backBtn.setEnabled(false);
            logoutBtn.setEnabled(false);
            updateBtn.setEnabled(false);
            inventory = new Thread(EditProductDetails.this);
            inventory.start();
        }
    }//GEN-LAST:event_scnBtnActionPerformed

    private void stopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBtnActionPerformed
        rb15693.setEnabled(true);
        rb14443a.setEnabled(true);
        scnBtn.setEnabled(true);
        stopBtn.setEnabled(true);
        delBtn.setEnabled(true);
        updateBtn.setEnabled(true);
        backBtn.setEnabled(true);
        logoutBtn.setEnabled(true);

        rfidlib_reader.RDR_SetCommuImmeTimeout(EditProductDetails.this.m_hr);
        EditProductDetails.this.b_inventoryFlg = false;

    }//GEN-LAST:event_stopBtnActionPerformed

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        char vchar = evt.getKeyChar();
        if (Character.isLetter(vchar) && !evt.isAltDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPriceKeyTyped

    private void txtQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyTyped
        char vchar = evt.getKeyChar();
        if (!(Character.isDigit(vchar))
            || (vchar == KeyEvent.VK_BACKSPACE) || (vchar == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQtyKeyTyped

    private void txtWeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtWeightKeyTyped
        char vchar = evt.getKeyChar();
        if (Character.isLetter(vchar) && !evt.isAltDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_txtWeightKeyTyped

    private void txtAreaDescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaDescKeyTyped
        char vchar = evt.getKeyChar();
        descCount.setText(txtAreaDesc.getText().length() + "/200");

        if (txtAreaDesc.getText().length() >= 200) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAreaDescKeyTyped

    private void subCategoryCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subCategoryCmbActionPerformed
        String selectedSubCategory = (String) subCategoryCmb.getSelectedItem();
        itr = subCat.listIterator();
        while (itr.hasNext()) {
            String subCatName1 = itr.next();
            if (subCatName1.equals(selectedSubCategory)) {
                itr.previous();
                subCatId1 = itr.previous();
                break;
            }
        }
    }//GEN-LAST:event_subCategoryCmbActionPerformed

    private void categoryCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCmbActionPerformed
        if (subCategoryCmb.getItemCount() != 0) {
            subCategoryCmb.removeAllItems();
            subCat.clear();
            catName.clear();
        }
        String selectedCategory = (String) categoryCmb.getSelectedItem();
        itr = cat.listIterator();
        while (itr.hasNext()) {
            String catName1 = itr.next();
            if (catName1.equals(selectedCategory)) {
                itr.previous();
                catId1 = itr.previous();
                break;
            }
        }
        subCat = new ArrayList<>();
        subCat = catDao.getSubCategoryList(catId1);
        itr = subCat.listIterator();
        subCatName = new ArrayList<>();
        while (itr.hasNext()) {
            itr.next();
            subCatName.add(itr.next());
        }
        subCategoryCmb.setModel(new DefaultComboBoxModel(subCatName.toArray()));
    }//GEN-LAST:event_categoryCmbActionPerformed

    private void descCountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descCountKeyPressed
        descCount.setText(txtAreaDesc.getText().length() + "/200");
    }//GEN-LAST:event_descCountKeyPressed

    private void lblImg1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImg1MousePressed
        imgFileName1 = getImageFile();
        if (imgFileName1.isEmpty() || imgFileName1 == null) {
            lblImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png")));
        } else {
            lblImg1.setIcon(new ImageIcon(new ImageIcon(imgFileName1).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
            baseImage1 = convertImgToBase64(imgFileName1);
            if (image64.isEmpty() || image64 == null) {
                image64 = baseImage1;
            } else {
                image64 = image64 + ',' + baseImage1;
            }
            lbl[0] = true;
        }
    }//GEN-LAST:event_lblImg1MousePressed

    private void lblImg2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImg2MousePressed
        imgFileName2 = getImageFile();
        if (imgFileName2.isEmpty() || imgFileName2 == null) {
            lblImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png")));
        } else {
            lblImg2.setIcon(new ImageIcon(new ImageIcon(imgFileName2).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
            baseImage2 = convertImgToBase64(imgFileName2);
            if (image64.isEmpty() || image64 == null) {
                image64 = baseImage2;
            } else {
                image64 = image64 + ',' + baseImage2;
            }
            lbl[1] = true;
        }
    }//GEN-LAST:event_lblImg2MousePressed

    private void lblImg3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImg3MousePressed
        imgFileName3 = getImageFile();
        if (imgFileName3.isEmpty() || imgFileName3 == null) {
            lblImg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png")));
        } else {
            lblImg3.setIcon(new ImageIcon(new ImageIcon(imgFileName3).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
            baseImage3 = convertImgToBase64(imgFileName3);
            if (image64.isEmpty() || image64 == null) {
                image64 = baseImage3;
            } else {
                image64 = image64 + ',' + baseImage3;
            }
            lbl[2] = true;
        }
    }//GEN-LAST:event_lblImg3MousePressed

    private void lblImg5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImg5MousePressed
        imgFileName5 = getImageFile();
        if (imgFileName5.isEmpty() || imgFileName5 == null) {
            //            lblImg5.setIcon(new ImageIcon(new ImageIcon("/com/lue/jeptags/image/Plus Math-50.png").getImage()));
            lblImg5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png")));

        } else {
            lblImg5.setIcon(new ImageIcon(new ImageIcon(imgFileName5).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
            baseImage5 = convertImgToBase64(imgFileName5);
            if (image64.isEmpty() || image64 == null) {
                image64 = baseImage5;
            } else {
                image64 = image64 + ',' + baseImage5;
            }
            lbl[4] = true;
        }
    }//GEN-LAST:event_lblImg5MousePressed

    private void lblImg4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImg4MousePressed
        imgFileName4 = getImageFile();

        if (imgFileName4.isEmpty() || imgFileName4 == null) {
            //            lblImg4.setIcon(new ImageIcon(new ImageIcon("/com/lue/jeptags/image/Plus Math-50.png").getImage()));
            lblImg4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Plus Math-50.png")));

        } else {
            lblImg4.setIcon(new ImageIcon(new ImageIcon(imgFileName4).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));

            baseImage4 = convertImgToBase64(imgFileName4);
            if (image64.isEmpty() || image64 == null) {
                image64 = baseImage4;
            } else {
                image64 = image64 + ',' + baseImage4;
            }
            lbl[3] = true;
        }
    }//GEN-LAST:event_lblImg4MousePressed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        if (stopBtn.isEnabled()) {
            rfidlib_reader.RDR_SetCommuImmeTimeout(EditProductDetails.this.m_hr);
            EditProductDetails.this.b_inventoryFlg = false;
        }
        rfidlib_reader.RDR_Close(m_hr);
        m_hr = 0;
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?", "Jep Tags", JOptionPane.OK_CANCEL_OPTION);
        if (response != -1 && response != 2) {
            dispose();
            Login l = new Login();
            l.setVisible(true);
        }
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        jTable2.removeAll();
        if (stopBtn.isEnabled()) {
            rfidlib_reader.RDR_SetCommuImmeTimeout(EditProductDetails.this.m_hr);
            EditProductDetails.this.b_inventoryFlg = false;
        }
        rfidlib_reader.RDR_Close(m_hr);
        m_hr = 0;
        m_hr = 0;
        UploadProduct upl = new UploadProduct();
        upl.setVisible(true);
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void importTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importTagActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Select a CSV File");
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV", "csv", "CSV");
		jfc.addChoosableFileFilter(filter);

		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
                  
                    try{
			System.out.println(jfc.getSelectedFile().getPath());
                        
                             
                        File fl=jfc.getSelectedFile();
                        BufferedReader br=new BufferedReader(new FileReader(fl));
                        String line=null;
                        int serialNo=0;
                        while((line=br.readLine())!=null){
                          
                            String[]data=line.split(",");
                            // if import row doesn't have data skip that
                            if(data.length<2){
                                continue;
                            }
                             String tagid=data[0];
                             String tagType=data[1];
                             
                             if(tagid==null || tagid.equals(""))
                             {
                                 continue;
                             }else{
                                 AddTagToTable(tagType, tagid);
                             }
                             serialNo++;
                        }
                       
                       JOptionPane.showMessageDialog(rootPane, "Total Tag Imported "+serialNo);
                        
                    }catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                    }
                        
		}
        
    }//GEN-LAST:event_importTagActionPerformed

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

   private void LoadDriver() {
        String driPath = System.getProperty("user.dir") + "\\Drivers";
        rfidlib_reader.RDR_LoadReaderDrivers(driPath);
        int m_cnt = rfidlib_reader.RDR_GetLoadedReaderDriverCount();
        int nret = 0;
        for (int i = 0; i < m_cnt; i++) {
            char[] valueBuffer = new char[256];
            Integer nSize = 0;
            String sDes;
            nret = rfidlib_reader.RDR_GetLoadedReaderDriverOpt(i, rfid_def.LOADED_RDRDVR_OPT_CATALOG, valueBuffer, nSize);
            if (nret == 0) {
                sDes = String.copyValueOf(valueBuffer, 0, nSize);
                //if (sDes.equals(rfid_def.RDRDVR_TYPE_READER)) {
                if (sDes.equals(rfid_def.RDRDVR_TYPE_READER)) {
                    rfidlib_reader.RDR_GetLoadedReaderDriverOpt(i, rfid_def.LOADED_RDRDVR_OPT_NAME, valueBuffer, nSize);
                    sDes = String.copyValueOf(valueBuffer, 0, nSize);
                }
            }
        }
    }

    private void OpenDev() {
        String connstr = null;
        String sDevName = "RL8000";
        connstr = rfid_def.CONNSTR_NAME_RDTYPE + "=" + sDevName + ";"
                + rfid_def.CONNSTR_NAME_COMMTYPE + "=" + rfid_def.CONNSTR_NAME_COMMTYPE_USB + ";"
                + rfid_def.CONNSTR_NAME_HIDADDRMODE + "=" + "0" + ";"
                + rfid_def.CONNSTR_NAME_HIDSERNUM + "=";

        Long hrOut = new Long(0);

        int nret = rfidlib_reader.RDR_Open(connstr, hrOut);
        nret1 = nret;

        if (nret != 0) {
            String sRet = "Open device failed!err=" + nret;
            JOptionPane.showMessageDialog(null, sRet);
        }
        m_hr = hrOut;
    }

    @Override
    public void run() {
        b_inventoryFlg = true;
        long InvenParamSpecList = rfidlib_reader.RDR_CreateInvenParamSpecList();
        boolean b_iso15693 = rb15693.isSelected();
        boolean b_iso14443a = rb14443a.isSelected();
        if (InvenParamSpecList != 0) {
            byte AntennaID = 0;
            if (b_iso15693) {

                byte en_afi = 0;
                byte afi = (byte) Integer.parseInt("00");
                byte slot_type = 0;
                rfidlib_AIP_ISO15693.ISO15693_CreateInvenParam(InvenParamSpecList, AntennaID, en_afi, afi, slot_type);
            }
            if (b_iso14443a) {
                rfidlib_aip_iso14443A.ISO14443A_CreateInvenParam(InvenParamSpecList, AntennaID);
            }
        }
        byte newAI = rfid_def.AI_TYPE_NEW;
        int nret = 0;
        long dnhReport = 0;

        while (b_inventoryFlg) {
            byte[] AntennaIDs = new byte[64];
            nret = rfidlib_reader.RDR_TagInventory(m_hr, newAI, (byte) 0, AntennaIDs, InvenParamSpecList);
            if (nret != 0) {
                continue;
            }
            dnhReport = rfidlib_reader.RDR_GetTagDataReport(m_hr, rfid_def.RFID_SEEK_FIRST);

            while (dnhReport != 0) {
                newAI = rfid_def.AI_TYPE_NEW;
                if (b_iso15693) {
                    Integer aip_id = new Integer(0);
                    Integer tag_id = new Integer(0);
                    Integer ant_id = new Integer(0);
                    Byte dsfid = new Byte((byte) 0);
                    byte uid[] = new byte[8];
                    nret = rfidlib_AIP_ISO15693.ISO15693_ParseTagDataReport(dnhReport, aip_id, tag_id, ant_id, dsfid, uid);
                    if (nret == 0) {
                        String sUid = gFunction.encodeHexStr(uid);
                      Runnable addTagTotableThread=  new Runnable() {
                            @Override
                            public void run() {
                                AddTagToTable(GetTagtypeName(aip_id, tag_id), sUid);
                            }
                        };
                        System.out.println("Tag Read completed. Going to Upload to Cloud");
                      new Thread(addTagTotableThread).start();
                      
                      // Stoping REader
                      stopBtnActionPerformed(null);
                      
                        System.out.println("Writing Tag UID as NDEF message in encrypted form");
                    // Writing Tag UID as NDEF message in encrypted form
                     // String encryptedsUid=  Encryption.encrypt(sUid);
                        System.out.println("---- "+sUid);
                      byte[]newBlkData = gFunction.decodeHex(sUid); //encryptedsUid.getBytes();//gFunction.encodeHex(encryptedsUid.getBytes());
                                             
                                             byte addrMode =1;
                                             Long ht = new Long(0);
				byte[] m_uid = newBlkData;
				 nret = rfidlib_AIP_ISO15693.ISO15693_Connect(m_hr, rfid_def.RFID_ISO15693_PICC_ICODE_SLI_ID, 
						addrMode,m_uid, ht);
				if (nret!=0) {
					JOptionPane.showMessageDialog(null, "Connect tag failed!err="+nret);
					return;
				}
				m_ht = ht;
                                             
                      
                      if (newBlkData.length%4!=0) {
					JOptionPane.showMessageDialog(null, "The data of block is not right!");
				}
                                int blkAddr=0;
                                int blkNum=2;
				
				 nret = rfidlib_AIP_ISO15693.ISO15693_WriteMultipleBlocks(m_hr,m_ht,blkAddr,blkNum, newBlkData,4*blkNum);
				if (nret==0) {
					//JOptionPane.showMessageDialog(null, "Write block OK");
				}
				else {
					JOptionPane.showMessageDialog(null, "Write block failed!err = " + nret);
				}
                                System.out.println("Writing Tag UID as NDEF message in encrypted form");
                                
                                // Disconnecting from Tag
                             rfidlib_reader.RDR_TagDisconnect(m_hr,m_hr);
                             // Start the Reader
                             scnBtnActionPerformed(null);
                      
                    }
                }
                if (b_iso14443a) {
                    Integer aip_id = new Integer(0);
                    Integer tag_id = new Integer(0);
                    Integer ant_id = new Integer(0);
                    byte[] uid = new byte[32];
                    Byte uidlen = new Byte((byte) 0);

                    nret = rfidlib_aip_iso14443A.ISO14443A_ParseTagDataReport(dnhReport, aip_id, tag_id, ant_id, uid, uidlen);

                    if (nret == 0) {
                        String sUid = gFunction.encodeHexStr(uid, uidlen);
                        AddTagToTable(GetTagtypeName(aip_id, tag_id), sUid);
                    }
                }

                dnhReport = rfidlib_reader.RDR_GetTagDataReport(m_hr, rfid_def.RFID_SEEK_NEXT);
            }
        }

        if (InvenParamSpecList != 0) {
            rfidlib_reader.DNODE_Destroy(InvenParamSpecList);
        }
        rfidlib_reader.RDR_ResetCommuImmeTimeout(m_hr);
        b_inventoryFlg = false;
    }

    private String GetTagtypeName(int AIPType, int tagType) {
        String tagtypeName = "";
        if (AIPType == rfid_def.RFID_APL_ISO15693_ID && tagType == rfid_def.RFID_ISO15693_PICC_ICODE_SLI_ID) {
            tagtypeName = "NXP ICODE SLI";
        } else if (AIPType == rfid_def.RFID_APL_ISO15693_ID && tagType == rfid_def.RFID_ISO15693_PICC_TI_HFI_PLUS_ID) {
            tagtypeName = "Ti HF-I Plus";
        } else if (AIPType == rfid_def.RFID_APL_ISO15693_ID && tagType == rfid_def.RFID_ISO15693_PICC_ST_M24LRXX_ID) {
            tagtypeName = "ST M24LRxx";
        } else if (AIPType == rfid_def.RFID_APL_ISO15693_ID && tagType == rfid_def.RFID_ISO15693_PICC_FUJ_MB89R118C_ID) {
            tagtypeName = "Fujitsu MB89R118C";
        } else if (AIPType == rfid_def.RFID_APL_ISO15693_ID && tagType == rfid_def.RFID_ISO15693_PICC_ST_M24LR64_ID) {
            tagtypeName = "ST M24LR64";
        } else if (AIPType == rfid_def.RFID_APL_ISO15693_ID && tagType == rfid_def.RFID_ISO15693_PICC_ST_M24LR16E_ID) {
            tagtypeName = "ST M24LR16E";
        } else if (AIPType == rfid_def.RFID_APL_ISO15693_ID && tagType == rfid_def.RFID_ISO15693_PICC_ICODE_SLIX_ID) {
            tagtypeName = "NXP ICODE SLIX";
        } else if (AIPType == rfid_def.RFID_APL_ISO15693_ID && tagType == rfid_def.RFID_ISO15693_PICC_TIHFI_STANDARD_ID) {
            tagtypeName = "Ti HF-I Standard";
        } else if (AIPType == rfid_def.RFID_APL_ISO15693_ID && tagType == rfid_def.RFID_ISO15693_PICC_TIHFI_PRO_ID) {
            tagtypeName = "Ti HF-I Pro";
        } else if (AIPType == rfid_def.RFID_APL_ISO14443A_ID && tagType == rfid_def.RFID_ISO14443A_PICC_NXP_ULTRALIGHT_ID) {
            tagtypeName = "NXP Mifare Ultralight";
        } else if (AIPType == rfid_def.RFID_APL_ISO14443A_ID && tagType == rfid_def.RFID_ISO14443A_PICC_NXP_MIFARE_S50_ID) {
            tagtypeName = "NXP Mifare S50";
        } else if (AIPType == rfid_def.RFID_APL_ISO14443A_ID && tagType == rfid_def.RFID_ISO14443A_PICC_NXP_MIFARE_S70_ID) {
            tagtypeName = "NXP Mifare S70";
        } else {
            tagtypeName = "Unknown Tag";
        }
        return tagtypeName;
    }

    private void AddTagToTable(String tagName, String sUid) {
        int qty1 = Integer.parseInt(qty);
        if (serial < qty1) {
            List<String> message = new EncodingVerify().verify(LoginValidation.SELLER_ID, sUid, prodId, latitude, longitude);

            Calendar cal = Calendar.getInstance();

            switch (message.get(0)) {
                case "0":
                    JOptionPane.showMessageDialog(detailsPnl, message.get(1), "Error", JOptionPane.ERROR_MESSAGE);
                    break;

                case "1":
                    String jeptagId = message.get(1);
                    serial++;
                    tagDetails.add(tagName);
                    tagDetails.add(sUid);
                    model = (DefaultTableModel) jTable2.getModel();
                    model.insertRow(model.getRowCount(), new Object[]{serial, jeptagId, SDF.format(cal.getTime())});
                    lblQty.setText("QUANTITY :" + serial + "/" + qty);
                    break;
                default:
                    break;
            }
        } else {
            String message = "<html>" + "Quantity full for the Product." + "<br/>" + "No more tags can be scanned and added." + "</html>";
            JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/lue/jeptags/image/icon.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField brandTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> categoryCmb;
    private javax.swing.JButton delBtn;
    private javax.swing.JLabel descCount;
    private javax.swing.JLabel descLbl;
    private javax.swing.JPanel detailsPnl;
    private javax.swing.JPanel imgPnl;
    private javax.swing.JButton importTag;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblImg1;
    private javax.swing.JLabel lblImg2;
    private javax.swing.JLabel lblImg3;
    private javax.swing.JLabel lblImg4;
    private javax.swing.JLabel lblImg5;
    private javax.swing.JLabel lblJepTagId;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProductId;
    private javax.swing.JLabel lblQty;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel mainPnl;
    private javax.swing.JLabel prodIdLbl;
    private javax.swing.JLabel prodNameLbl;
    private javax.swing.JLabel prodSubIdLbl;
    private javax.swing.JLabel quantityLbl;
    private javax.swing.JRadioButton rb14443a;
    private javax.swing.JRadioButton rb15693;
    private javax.swing.JPanel scanPnl;
    private javax.swing.JButton scnBtn;
    private javax.swing.JButton stopBtn;
    private javax.swing.JComboBox<String> subCategoryCmb;
    private javax.swing.JPanel topPnl;
    private javax.swing.JTextArea txtAreaDesc;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProdID;
    private javax.swing.JTextField txtProdName;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtWeight;
    private javax.swing.JButton updateBtn;
    private javax.swing.JLabel weightLbl;
    // End of variables declaration//GEN-END:variables
}
