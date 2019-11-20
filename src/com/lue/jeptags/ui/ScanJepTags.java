package com.lue.jeptags.ui;

import com.lue.jeptags.util.gFunction;
import RFID.rfid_def;
import RFID.rfidlib_AIP_ISO15693;
import RFID.rfidlib_aip_iso14443A;
import RFID.rfidlib_reader;
import com.lue.jeptags.util.CheckTags;
import com.lue.jeptags.util.LoginValidation;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lue
 */
public class ScanJepTags extends javax.swing.JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    private long m_hr = 0;
    private long m_ht = 0;
    boolean b_inventoryFlg = false;
    String seller_id = LoginValidation.SELLER_ID;
    String sUid = "";
    Thread p1;
    int nret1;

    public ScanJepTags() {
        System.setProperty("jdk.tls.disabledAlgorithms", "MD5, SHA1, RC4, RSA");
        initComponents();
        centerFrame();
        bin();
        setIcon();
        scanBtn.setEnabled(true);
        stopBtn.setEnabled(false);
        LoadDriver();
        OpenDev();
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

    private void bin() {
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPnl = new javax.swing.JPanel();
        topPnl = new javax.swing.JPanel();
        logoutBtn = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        scanBtn = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();
        bodyPnl = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainPnl.setBackground(new java.awt.Color(21, 21, 21));
        mainPnl.setPreferredSize(new java.awt.Dimension(1350, 750));

        topPnl.setBackground(new java.awt.Color(12, 30, 33));

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

        scanBtn.setBackground(new java.awt.Color(12, 30, 33));
        scanBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        scanBtn.setForeground(new java.awt.Color(255, 204, 0));
        scanBtn.setText("Scan");
        scanBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), 2));
        scanBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanBtnActionPerformed(evt);
            }
        });

        stopBtn.setBackground(new java.awt.Color(12, 30, 33));
        stopBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stopBtn.setForeground(new java.awt.Color(255, 0, 0));
        stopBtn.setText("Stop");
        stopBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), 2));
        stopBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topPnlLayout = new javax.swing.GroupLayout(topPnl);
        topPnl.setLayout(topPnlLayout);
        topPnlLayout.setHorizontalGroup(
            topPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 482, Short.MAX_VALUE)
                .addComponent(scanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 455, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topPnlLayout.setVerticalGroup(
            topPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(topPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(topPnlLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(topPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stopBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scanBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        bodyPnl.setBackground(new java.awt.Color(12, 30, 33));
        bodyPnl.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/lue/jeptags/image/Scan part.png"))); // NOI18N
        bodyPnl.add(jLabel1, java.awt.BorderLayout.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 150, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Software Design By Jeptags USA");
        bodyPnl.add(jLabel2, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout mainPnlLayout = new javax.swing.GroupLayout(mainPnl);
        mainPnl.setLayout(mainPnlLayout);
        mainPnlLayout.setHorizontalGroup(
            mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bodyPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
        );
        mainPnlLayout.setVerticalGroup(
            mainPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPnlLayout.createSequentialGroup()
                .addComponent(topPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bodyPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1344, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 797, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        if (stopBtn.isEnabled()) {
            rfidlib_reader.RDR_SetCommuImmeTimeout(ScanJepTags.this.m_hr);
            ScanJepTags.this.b_inventoryFlg = false;
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

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        rfidlib_reader.RDR_Close(m_hr);
        m_hr = 0;

        if (LoginValidation.ROLE.equals("admin")) {
            dispose();
            new MainAdmin().setVisible(true);
        } else if (LoginValidation.ROLE.equals("seller")) {
            dispose();
            new Main().setVisible(true);
        }

    }//GEN-LAST:event_btnBackActionPerformed

    private void scanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanBtnActionPerformed
        try {

            p1 = new Thread(ScanJepTags.this);
            p1.start();
            if (nret1 != 0) {
                scanBtn.setEnabled(true);
                stopBtn.setEnabled(false);

            } else {
                scanBtn.setEnabled(false);
                stopBtn.setEnabled(true);
                btnBack.setEnabled(false);
                logoutBtn.setEnabled(false);
            }
        } catch (Exception ex) {
//            Logger.getLogger(ScanJepTags.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Exception occured while enabling scan---- " + ex.toString());
        }
    }//GEN-LAST:event_scanBtnActionPerformed

    private void stopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBtnActionPerformed
        rfidlib_reader.RDR_SetCommuImmeTimeout(ScanJepTags.this.m_hr);
        ScanJepTags.this.b_inventoryFlg = false;
        stopBtn.setEnabled(false);
        scanBtn.setEnabled(true);
        btnBack.setEnabled(true);
        logoutBtn.setEnabled(true);
    }//GEN-LAST:event_stopBtnActionPerformed

    private void LoadDriver() {
        try {

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
                    if (sDes.equals(rfid_def.RDRDVR_TYPE_READER)) {
                        rfidlib_reader.RDR_GetLoadedReaderDriverOpt(i, rfid_def.LOADED_RDRDVR_OPT_NAME, valueBuffer, nSize);
                        sDes = String.copyValueOf(valueBuffer, 0, nSize);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception While loading driver-- " + e);
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
        boolean b_iso15693 = true;
        boolean b_iso14443a = true;

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
                        sUid = gFunction.encodeHexStr(uid);
                        try {

                            CheckTags ck = new CheckTags();
                            List sendPost = ck.sendPost(sUid);
                            if (sendPost.get(0) == "0") {
                                EncodeScanUI0 eui0 = new EncodeScanUI0(sendPost);
                                ShowNonGenuine showNonGenuine = new ShowNonGenuine();
                            } else if (sendPost.get(0) == "1") {
                                ShowGenuine showGenuine = new ShowGenuine();
                                EncodeScanUI1 eui0 = new EncodeScanUI1(sendPost);
                            } else if (sendPost.get(0) == "2") {
                                ShowGenuine showGenuine = new ShowGenuine();
                                EncodeScanUI2 eui0 = new EncodeScanUI2(sendPost);

                            }

                        } catch (Exception ex) {
                            Logger.getLogger(ScanJepTags.class.getName()).log(Level.SEVERE, null, ex);
                        }
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
                        sUid = gFunction.encodeHexStr(uid, uidlen);
                        try {

                            CheckTags ck = new CheckTags();
                            // ck.tagsScan(sUid);
                            List sendPost = ck.sendPost(sUid);
                            if (sendPost.get(0) == "0") {
                                EncodeScanUI0 eui0 = new EncodeScanUI0(sendPost);
                            } else if (sendPost.get(0) == "1") {
                                EncodeScanUI1 eui0 = new EncodeScanUI1(sendPost);
                            } else if (sendPost.get(0) == "2") {
                                EncodeScanUI2 eui0 = new EncodeScanUI2(sendPost);

                            }

                        } catch (Exception ex) {
                            System.out.println("Exception---- " + ex.toString());
                        }
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

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/lue/jeptags/image/icon.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPnl;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel mainPnl;
    private javax.swing.JButton scanBtn;
    private javax.swing.JButton stopBtn;
    private javax.swing.JPanel topPnl;
    // End of variables declaration//GEN-END:variables

}
