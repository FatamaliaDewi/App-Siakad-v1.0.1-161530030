
package Forms;

import Tools.KoneksiDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FrMenu extends javax.swing.JFrame {
    
    KoneksiDB getCnn = new KoneksiDB();
    Connection _Cnn;
    
 
    String vid_user, vnama_user, vpass, vlev_user;
    String sqlselect;
    IfrUser fruser;
    IfrJurusan frjurusan;
    IfrProdi frprodi;
    IfrTahunAngkatan frta;
    IfrLapMahasiswa frlapmhs;
    
    public FrMenu() {
        initComponents();
        fruser =new IfrUser();
        frjurusan = new IfrJurusan();
        frprodi = new IfrProdi();
        frta = new IfrTahunAngkatan();
        frlapmhs = new IfrLapMahasiswa();
        
        this.setExtendedState(this.getExtendedState () | FrMenu.MAXIMIZED_BOTH);
        disabledMenu();
        txtIDUser.requestFocus(true);
    }

    private void disabledMenu(){
        mnSistem.setEnabled(false);
        mnMaster.setEnabled(false);
        mnMahasiswa.setEnabled(false);
    }
    
    private void enabledMenu(){
        mnSistem.setEnabled(true);
        mnMaster.setEnabled(true);
        mnMahasiswa.setEnabled(true);
    }
    
    void userAdministrator(){
        mnSistem.setVisible(true);
        mnMaster.setVisible(true);
        mnMahasiswa.setVisible(true);
    }
    
    void userKemahasiswaan(){
        mnSistem.setVisible(true);
        mnUser.setText("Ubah Password");
        mnMaster.setVisible(false);
        mnMahasiswa.setVisible(true);
    }
    
    
    
    private void aksilogin(){
        if(txtIDUser.getText().equals("")|| txtPassword.getText().equals("")){
            JOptionPane.showMessageDialog(this, "ID User dan Password belum diisi");
        }else{
            vid_user = txtIDUser.getText();
            vpass = txtPassword.getText();
            try{
                _Cnn = null;
                _Cnn = getCnn.getConnection();
                sqlselect = "select * from tbuser where id_user='"+vid_user+"' "
                        + " and pass=md5('"+vpass+"') ";
                Statement stat = _Cnn.createStatement();
                ResultSet res = stat.executeQuery(sqlselect);
                if(res.first()){
                    vlev_user = res.getString("lev_user");
                    vnama_user = res.getString("nama_user");
                    lblKeterangan.setText("ID. User : "+vid_user+" - "+vnama_user+
                            "   | Lev. User : "+vlev_user);
                    panelLogin.setVisible(false);
                    enabledMenu();
                    if(vlev_user.equals("Administrator")){
                        userAdministrator();
                    }else if(vlev_user.equals("Staff Kemahasiswaan")){
                        userKemahasiswaan();
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "ID. User dan Password salah ");
                }
            
            }catch(SQLException se){
                JOptionPane.showMessageDialog(this, "Error method aksilogin() : " +se);
            }
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JDesktopPane();
        panelLogin = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txtIDUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblKeterangan1 = new javax.swing.JPanel();
        lblKeterangan = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnSistem = new javax.swing.JMenu();
        mnUser = new javax.swing.JMenuItem();
        mnKeluar = new javax.swing.JMenuItem();
        mnMaster = new javax.swing.JMenu();
        mnTA = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnJurusan = new javax.swing.JMenuItem();
        mnProdi = new javax.swing.JMenuItem();
        mnMahasiswa = new javax.swing.JMenu();
        mnDataMhs = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnLaporanMhs = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("App Siakad v.1.0 161530030");

        panelMenu.setPreferredSize(new java.awt.Dimension(857, 532));

        jPanel2.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N

        txtIDUser.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "ID. User"));
        txtIDUser.setOpaque(false);
        txtIDUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDUserActionPerformed(evt);
            }
        });

        txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Password"));
        txtPassword.setOpaque(false);
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/login-blue.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/small_logout.png"))); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN SIAKAD V.1.0");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("-{Sistem Informasi Akademik Oemah Codinger}-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword)
                            .addComponent(txtIDUser)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panelLogin.addTab("Login User", new javax.swing.ImageIcon(getClass().getResource("/Icons/Admin-Schoolar-Icon.png")), jPanel2); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icon-login.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 255));
        jLabel5.setText("SISTEM INFORMASI AKADEMIK");

        jLabel6.setFont(new java.awt.Font("IrisUPC", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 102, 255));
        jLabel6.setText("Sekolah Tinggi Oemah Codinger <STOC>");

        jLabel7.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 102, 255));
        jLabel7.setText("oemahcodinger.com");

        panelMenu.setLayer(panelLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelMenu.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelMenu.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelMenu.setLayer(jSeparator3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelMenu.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelMenu.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addComponent(jSeparator3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        lblKeterangan1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblKeterangan.setText("ID User : ....| Lev User : ....");

        javax.swing.GroupLayout lblKeterangan1Layout = new javax.swing.GroupLayout(lblKeterangan1);
        lblKeterangan1.setLayout(lblKeterangan1Layout);
        lblKeterangan1Layout.setHorizontalGroup(
            lblKeterangan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblKeterangan1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lblKeterangan1Layout.setVerticalGroup(
            lblKeterangan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblKeterangan1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKeterangan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mnSistem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/1 - Sistem.png"))); // NOI18N
        mnSistem.setText("Sistem");

        mnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/1 - user.png"))); // NOI18N
        mnUser.setText("User");
        mnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUserActionPerformed(evt);
            }
        });
        mnSistem.add(mnUser);

        mnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/small_logout.png"))); // NOI18N
        mnKeluar.setText("Keluar");
        mnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnKeluarActionPerformed(evt);
            }
        });
        mnSistem.add(mnKeluar);

        jMenuBar1.add(mnSistem);

        mnMaster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/2 - Master.png"))); // NOI18N
        mnMaster.setText("Master");

        mnTA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/2 - master small.png"))); // NOI18N
        mnTA.setText("Tahun Angkatan");
        mnTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTAActionPerformed(evt);
            }
        });
        mnMaster.add(mnTA);
        mnMaster.add(jSeparator1);

        mnJurusan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/2 - master small.png"))); // NOI18N
        mnJurusan.setText("Jurusan");
        mnJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnJurusanActionPerformed(evt);
            }
        });
        mnMaster.add(mnJurusan);

        mnProdi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/2 - master small.png"))); // NOI18N
        mnProdi.setText("Program Studi");
        mnProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnProdiActionPerformed(evt);
            }
        });
        mnMaster.add(mnProdi);

        jMenuBar1.add(mnMaster);

        mnMahasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/3 - Mahasiswa.png"))); // NOI18N
        mnMahasiswa.setText("Mahasiswa");

        mnDataMhs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/3 - mahasiswa small.png"))); // NOI18N
        mnDataMhs.setText("Data Mahasiswa");
        mnDataMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDataMhsActionPerformed(evt);
            }
        });
        mnMahasiswa.add(mnDataMhs);
        mnMahasiswa.add(jSeparator2);

        mnLaporanMhs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/report-small2.png"))); // NOI18N
        mnLaporanMhs.setText("Laporan Data Mahasiswa");
        mnLaporanMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnLaporanMhsActionPerformed(evt);
            }
        });
        mnMahasiswa.add(mnLaporanMhs);

        jMenuBar1.add(mnMahasiswa);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKeterangan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(panelMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKeterangan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnProdiActionPerformed
        if (!frprodi.getVisible() && !frprodi.isShowing()) {
            frprodi = new IfrProdi();
            panelMenu.add(frprodi);
            frprodi.setVisible(true);
        }

    }//GEN-LAST:event_mnProdiActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        aksilogin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void mnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUserActionPerformed
        if (!fruser.getVisible() && !fruser.isShowing()) {
            fruser = new IfrUser();
            panelMenu.add(fruser);
            fruser.setVisible(true);
        }   
    }//GEN-LAST:event_mnUserActionPerformed

    private void mnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnKeluarActionPerformed
        int jawab = JOptionPane.showConfirmDialog(this, "Apakah anda akan keluar dari sistem?","Informasi",
                JOptionPane.YES_NO_OPTION);
        if(jawab == JOptionPane.YES_OPTION){
            System.exit(0);
        }

    }//GEN-LAST:event_mnKeluarActionPerformed

    private void mnTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTAActionPerformed
        if (!frta.getVisible() && !frta.isShowing()) {
            frta = new IfrTahunAngkatan();
            panelMenu.add(frta);
            frta.setVisible(true);
        }
    }//GEN-LAST:event_mnTAActionPerformed

    private void mnJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnJurusanActionPerformed
        if (!frjurusan.getVisible() && !frjurusan.isShowing()) {
            frjurusan = new IfrJurusan();
            panelMenu.add(frjurusan);
            frjurusan.setVisible(true);
        }

    }//GEN-LAST:event_mnJurusanActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        aksilogin();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtIDUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDUserActionPerformed
        txtPassword.requestFocus(true);
    }//GEN-LAST:event_txtIDUserActionPerformed

    private void mnLaporanMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnLaporanMhsActionPerformed
        if (!frlapmhs.getVisible() && !frlapmhs.isShowing()) {
            frlapmhs = new IfrLapMahasiswa();
            panelMenu.add(frlapmhs);
            frlapmhs.setVisible(true);
        }
    }//GEN-LAST:event_mnLaporanMhsActionPerformed

    private void mnDataMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDataMhsActionPerformed
        IfrMahasiswa fr = new IfrMahasiswa();
        panelMenu.add(fr);
        fr.setVisible(true);
        fr.getDesktopPane().getDesktopManager().maximizeFrame(fr);

    }//GEN-LAST:event_mnDataMhsActionPerformed

    
   public static void main(String[] args) throws UnsupportedLookAndFeelException,
           IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
       try{
           com.jtattoo.plaf.mcwin.McWinLookAndFeel.setTheme("Default", "Java Swing", "");
           UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
           SwingUtilities.updateComponentTreeUI(new FrMenu());
       } finally {
           new FrMenu().setVisible(true);
       }
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblKeterangan;
    private javax.swing.JPanel lblKeterangan1;
    private javax.swing.JMenuItem mnDataMhs;
    private javax.swing.JMenuItem mnJurusan;
    private javax.swing.JMenuItem mnKeluar;
    private javax.swing.JMenuItem mnLaporanMhs;
    private javax.swing.JMenu mnMahasiswa;
    private javax.swing.JMenu mnMaster;
    private javax.swing.JMenuItem mnProdi;
    private javax.swing.JMenu mnSistem;
    private javax.swing.JMenuItem mnTA;
    private javax.swing.JMenuItem mnUser;
    private javax.swing.JTabbedPane panelLogin;
    private javax.swing.JDesktopPane panelMenu;
    private javax.swing.JTextField txtIDUser;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}

