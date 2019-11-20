package com.lue.jeptags.ui;

import com.lue.jeptags.dao.ProductDao;
import com.lue.jeptags.entity.Product;
import com.lue.jeptags.util.CheckProductApproval;
import com.lue.jeptags.util.LoginValidation;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author lue
 */
public class UploadProduct extends javax.swing.JFrame {

    DefaultTableModel model;

    String seller_Id;
    int rowCount = 0;
    String prodId;
    List prIds;
    private TableRowSorter<DefaultTableModel> sorter;
    public static  List<Product> product;

    public UploadProduct() {
        prIds = new ArrayList();
        initComponents();
        bin();
        setIcon();
        populateData();
        scPane.getViewport().setBackground(new Color(12, 30, 33));
        addJeptagBtn.setVisible(false);
         
    }

    private void bin() {
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        scPane = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        logoutBtn = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        addJeptagBtn = new javax.swing.JButton();
        addNewProductBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainPanel.setBackground(new java.awt.Color(12, 30, 33));
        mainPanel.setPreferredSize(new java.awt.Dimension(909, 750));

        scPane.setBackground(new java.awt.Color(12, 30, 33));
        scPane.setBorder(null);
        scPane.setForeground(new java.awt.Color(255, 204, 0));
        scPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scPane.setDoubleBuffered(true);
        scPane.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        scPane.setHorizontalScrollBar(null);
        scPane.setPreferredSize(new java.awt.Dimension(467, 0));

        jTable1.setBackground(new java.awt.Color(12, 30, 33));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 204, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.N", "Image", "Details"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
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
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setDoubleBuffered(true);
        jTable1.setIntercellSpacing(new java.awt.Dimension(1, 2));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        scPane.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

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
        logoutBtn.setPreferredSize(new java.awt.Dimension(90, 35));
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

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

        addJeptagBtn.setBackground(new java.awt.Color(12, 30, 33));
        addJeptagBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addJeptagBtn.setForeground(new java.awt.Color(255, 204, 0));
        addJeptagBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/blue 75g.png"))); // NOI18N
        addJeptagBtn.setText(" + JepTag");
        addJeptagBtn.setBorderPainted(false);
        addJeptagBtn.setContentAreaFilled(false);
        addJeptagBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addJeptagBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addJeptagBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJeptagBtnActionPerformed(evt);
            }
        });

        addNewProductBtn.setBackground(new java.awt.Color(12, 30, 33));
        addNewProductBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/icon_blue__0008_layer-160.png"))); // NOI18N
        addNewProductBtn.setToolTipText("Add New Product");
        addNewProductBtn.setBorder(null);
        addNewProductBtn.setBorderPainted(false);
        addNewProductBtn.setContentAreaFilled(false);
        addNewProductBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addNewProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewProductBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setText("Search Product");

        searchTextField.setBackground(new java.awt.Color(51, 51, 51));
        searchTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchTextField.setForeground(new java.awt.Color(255, 204, 51));

        jPanel1.setBackground(new java.awt.Color(12, 30, 33));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Software Desing by Jeptags USA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scPane, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addNewProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addJeptagBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 381, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(addJeptagBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addNewProductBtn))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scPane, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1371, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if (LoginValidation.ROLE.equals("admin")) {
            MainAdmin ad = new MainAdmin();
            ad.setVisible(true);
            dispose();
        } else if (LoginValidation.ROLE.equals("seller")) {
            Main ad = new Main();
            ad.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        int i = jTable1.getSelectedRow();
        prodId = (String) prIds.get(i);
        if (!new CheckProductApproval().productApproved(String.valueOf(prodId))) {
            addJeptagBtn.setVisible(true);
            addJeptagBtn.setToolTipText("The Product has not been approved.");
            addJeptagBtn.setEnabled(false);
        } else {
            addJeptagBtn.setVisible(true);
            addJeptagBtn.setToolTipText("Add JepTag and edit product details.");
            addJeptagBtn.setEnabled(true);
        }
    }//GEN-LAST:event_jTable1MousePressed

    private void addJeptagBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJeptagBtnActionPerformed
        EditProductDetails epd = new EditProductDetails(prodId);
        epd.setVisible(true);
        dispose();
    }//GEN-LAST:event_addJeptagBtnActionPerformed

    private void addNewProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewProductBtnActionPerformed
        new AddProduct().setVisible(true);
        dispose();
    }//GEN-LAST:event_addNewProductBtnActionPerformed

    private void populateData() {
          jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
           //Whenever filterText changes, invoke newFilter.
        searchTextField.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        newFilter();
                    }
                });
        if(product==null){
           product   = new ProductDao().getProducts();
        }

        int i = 0;

        if (product.size() > 0) {
            rowCount = product.size();
             String[]columnName={"S.N","Image","Details"};
            model = new DefaultTableModel(columnName,rowCount) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }
            };
            jTable1.setRowHeight(100);
             int serial=1;
             
            for (Product prod : product) {
                Vector<Object> data = new Vector<>();
                data.add(serial);
                serial++;
                data.add(prod.getImage());
                String data1 = "<html>"
                        + "<div>"
                        + "<p>Product Id:  " + prod.getId() + "      Category:  " + prod.getCategory() + "</p>"
                        + "<p>Product Name: " + prod.getName() + "</p>"
                        + "</div>"
                        + "</html>";

                data.add(data1);
                prIds.add(prod.getId());
                model.insertRow(i, data);
                i++;
            }
        }
        model.setRowCount(rowCount);
         sorter = new TableRowSorter<DefaultTableModel>(model);
         jTable1.setRowSorter(sorter);
        jTable1.setModel(model);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(new UploadProduct.ImageRenderer());
         jTable1.getColumnModel().getColumn(0).setMaxWidth(35);
         jTable1.getColumnModel().getColumn(1).setMaxWidth(185);
        model.fireTableDataChanged();
    }
    
    /** 
     * Update the row filter regular expression from the expression in
     * the text box.
     */
    private void newFilter() {
        RowFilter<DefaultTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter("(?i)"+searchTextField.getText(), 2);
           
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/lue/jeptags/image/icon.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJeptagBtn;
    private javax.swing.JButton addNewProductBtn;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scPane;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables

    private class ImageRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = new JLabel();

            if (value != null) {
                label.setHorizontalAlignment(JLabel.CENTER);
                try {
                    URL url = new URL((String) value);
                    Image image = ImageIO.read(url);
                    image = image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                    label.setIcon(new ImageIcon(image));
                } catch (IOException ex) {
//                    Logger.getLogger(ImageRenderer.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Excception--- " + ex);
                }
                if (isSelected) {
                    setBackground(Color.yellow);
                }
            }
            return label;
        }
    }
}
