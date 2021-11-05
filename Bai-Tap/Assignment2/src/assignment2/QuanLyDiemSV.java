/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import Heper.Check;
import Heper.ConnectSQL;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class QuanLyDiemSV extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyDiemSV
     */
    ArrayList<DiemSinhVien> listDiemSV = new ArrayList<>();
    ArrayList<String> listMaSV = new ArrayList<>();
    int Index = 0 ;
    DangNhap st  = new DangNhap();
        
    public QuanLyDiemSV() {
        initComponents();
        setSize(710, 620);
        setResizable(false);
        setLocationRelativeTo(null);
        ChayChu();
        DoiMau();
        if( st.CheckDangNhap == true ){
            KetNoi();      
        }
    }
    
    // Chạy Chữ
    public void ChayChu(){
        lbTieuDe.setText("  Quản Lý Điểm Sinh Viên");
        Thread st = new Thread(){
            
            public void run(){
                try {
                    while (true) {                        
                         String st = lbTieuDe.getText();
                         char fisrt = st.charAt(0) ;
                         lbTieuDe.setText( st.substring(1, st.length()  ) + fisrt );    
                         Thread.sleep(500);
                    }
                } catch (Exception e) {
                }
            }
        };
        st.start();
    }    
    
    // ĐỔ màu cho tiêu đề
    public void DoiMau(){
         Thread st = new Thread(){
             Random rand = new Random();
             @Override
             public void run(){
                 try {
                     while (true) {                         
                         int a = rand.nextInt(255);
                         int b = rand.nextInt(255);
                         int c = rand.nextInt(255);
                         Color color = new Color(a , b ,c);
                         lbTieuDe.setForeground(color) ;
                         Thread.sleep(100);                       
                     }
                 } catch (InterruptedException ex) {
                 }
             }
         };
         st.start();
    }   
    
    // Kết nối nối SQL
    private void KetNoi(){
         try {
             String sql = "select HoTen, STUDENTS.MaSV , TiengAnh , TinHoc , GDTC " +
                          "from GRADE right outer join STUDENTS on GRADE.MaSV = STUDENTS.MaSV";
             try (   Connection con = ConnectSQL.OpenLink();
                     Statement pstmt = con.createStatement();
                     ){
                     ResultSet rs = pstmt.executeQuery(sql);
                     listDiemSV.clear();
                     while( rs.next() ){
                          DiemSinhVien sv = new DiemSinhVien();
                          sv.setMaSV(rs.getString("MaSV"));
                          sv.setHoten(rs.getString("HoTen"));
                          sv.setTiengAnh(rs.getDouble("TiengAnh"));
                          sv.setTinHoc(rs.getDouble("TinHoc"));
                          sv.setGiaoDuc(rs.getDouble("GDTC"));
                          listDiemSV.add(sv);
                     }
             }
             DoVaoBang();
        } catch (Exception e) {
        }
    }

    // Thêm vào bảng và sắp xếp
    private void DoVaoBang(){
         int k ;
         DefaultTableModel model = (DefaultTableModel) table.getModel() ;
         model.setRowCount(0);
         
         listDiemSV.sort( (a , b) -> {
            return Double.compare( b.getDiemTB(), a.getDiemTB() );
         });
         
         if( listDiemSV.size() < 3 ){
             k = listDiemSV.size();
         }else{
             k = 3 ;
         }
         
         for( int i=0 ; i<k ; i++  ){
             DiemSinhVien x = listDiemSV.get(i);
             model.addRow( new Object[] { x.getMaSV() , x.getHoten() , x.getTiengAnh() , x.getTinHoc() , x.getGiaoDuc() , x.getDiemTB()});
         }
    }    
    
    // Làm mới các textField 
    private void LamTrangTxt(){
        lbHoTen.setText("");
        lbDiemTB.setText("");
        txtTiengAnh.setText("");
        txtGDCD.setText("");
        txtTinHoc.setText("");
        txtMaSV.setText("");
        txtTimKiem.setText("");    
    }
    
    // Làm Trắng một vài text Field 
    private void LamTrangTxt2(){
        lbDiemTB.setText("");
        txtTiengAnh.setText("");
        txtGDCD.setText("");
        txtTinHoc.setText("");
        txtTimKiem.setText(""); 
    }  
    
    // Hàm Hiển thị thông tin nên txt
    private void HienThiThongTin( int k ){
        DiemSinhVien sv = listDiemSV.get(k) ;
        lbDiemTB.setText(String.valueOf(sv.getDiemTB()));
        lbHoTen.setText(sv.getHoten());
        txtMaSV.setText(sv.getMaSV());
        txtGDCD.setText(String.valueOf(sv.getGiaoDuc()));
        txtTiengAnh.setText(String.valueOf(sv.getTiengAnh()));
        txtTinHoc.setText(String.valueOf(sv.getTinHoc()));
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        lbTieuDe = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        txtGDCD = new javax.swing.JTextField();
        txtTiengAnh = new javax.swing.JTextField();
        txtTinHoc = new javax.swing.JTextField();
        lbHoTen = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbDiemTB = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(null);

        lbTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTieuDe.setText("QUẢN LÝ ĐIỂM SINH VIÊN");
        jPanel1.add(lbTieuDe);
        lbTieuDe.setBounds(0, 20, 710, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Tìm Kiếm Theo Mã SV:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 100, 160, 30);
        jPanel1.add(txtTimKiem);
        txtTimKiem.setBounds(220, 100, 280, 30);

        jLabel3.setBackground(new java.awt.Color(0, 0, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 51));
        jLabel3.setText("Họ Tên:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 200, 60, 16);

        btnFind.setBackground(new java.awt.Color(204, 255, 255));
        btnFind.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFind.setForeground(new java.awt.Color(0, 0, 0));
        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Search.png"))); // NOI18N
        btnFind.setText("Tìm Kiếm");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        jPanel1.add(btnFind);
        btnFind.setBounds(540, 100, 120, 30);

        jLabel5.setBackground(new java.awt.Color(0, 0, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText("Mã SV:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(80, 240, 50, 21);

        jLabel6.setBackground(new java.awt.Color(0, 0, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("Tiếng Anh:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 280, 80, 21);

        jLabel7.setBackground(new java.awt.Color(0, 0, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("Tin Học:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(70, 320, 60, 21);

        jLabel8.setBackground(new java.awt.Color(0, 0, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("Giáo Dục TC:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 360, 100, 21);
        jPanel1.add(txtMaSV);
        txtMaSV.setBounds(180, 232, 190, 30);

        txtGDCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGDCDActionPerformed(evt);
            }
        });
        jPanel1.add(txtGDCD);
        txtGDCD.setBounds(180, 352, 190, 30);
        jPanel1.add(txtTiengAnh);
        txtTiengAnh.setBounds(180, 272, 190, 30);
        jPanel1.add(txtTinHoc);
        txtTinHoc.setBounds(180, 312, 190, 30);

        lbHoTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbHoTen.setForeground(new java.awt.Color(255, 153, 0));
        jPanel1.add(lbHoTen);
        lbHoTen.setBounds(180, 200, 140, 20);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setText("Điểm TB");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(440, 240, 80, 25);

        lbDiemTB.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbDiemTB.setForeground(new java.awt.Color(255, 153, 0));
        lbDiemTB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbDiemTB);
        lbDiemTB.setBounds(440, 290, 80, 40);

        btnExit.setBackground(new java.awt.Color(204, 255, 255));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExit.setForeground(new java.awt.Color(0, 0, 0));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logout (1).png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);
        btnExit.setBounds(560, 410, 100, 30);

        jButton6.setBackground(new java.awt.Color(204, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/next (2).png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(290, 400, 80, 40);

        jButton3.setBackground(new java.awt.Color(204, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/next (1).png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(390, 400, 80, 40);

        btnNew.setBackground(new java.awt.Color(204, 255, 255));
        btnNew.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNew.setForeground(new java.awt.Color(0, 0, 0));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew);
        btnNew.setBounds(560, 210, 100, 30);

        btnSave.setBackground(new java.awt.Color(204, 255, 255));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 0, 0));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);
        btnSave.setBounds(560, 260, 100, 30);

        btnDelete.setBackground(new java.awt.Color(204, 255, 255));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);
        btnDelete.setBounds(560, 310, 100, 30);

        btnUpdate.setBackground(new java.awt.Color(204, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Edit.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);
        btnUpdate.setBounds(560, 360, 100, 30);

        jButton9.setBackground(new java.awt.Color(204, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/previous (2).png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(190, 400, 80, 40);

        jButton10.setBackground(new java.awt.Color(204, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/back.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(90, 400, 80, 40);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SV", "Họ Tên", "Tiếng Anh", "Tin Học", "GDCD", "Điêm TB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 480, 690, 130);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 0));
        jLabel11.setText("3 sinh viên có điểm cao nhất");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(10, 450, 160, 20);

        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/c35e3c1baa7be93127b11f5e2de8ba8f.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 710, 620);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGDCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGDCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGDCDActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
         Index = table.getSelectedRow();
         HienThiThongTin(Index);
    }//GEN-LAST:event_tableMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }   
        LamTrangTxt();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }   
        boolean sk  = true ; 
        
        for( int i=0 ; i<listDiemSV.size() ; i++ ){
            DiemSinhVien sv = listDiemSV.get(i);
            if( txtTimKiem.getText().equalsIgnoreCase(sv.getMaSV())){
                 HienThiThongTin(i);
                 Index = i ;
                 sk = false;
                 break; 
            }
        }
        
        if( sk == true )  JOptionPane.showMessageDialog(rootPane, "Mã SV bạn tìm không tồn tại");
    }//GEN-LAST:event_btnFindActionPerformed
    // Check mã xem có ở trong Bảng điểm k
    private boolean checkMa(){
        try {
            try (  Connection con = ConnectSQL.OpenLink() ;
                   Statement stmt = con.createStatement();
                    ){
                   String sql = "select MaSV from GRADE" ;
                   ResultSet rs = stmt.executeQuery(sql);
                   
                   while ( rs.next() ) {                    
                       if( rs.getString("MaSV").equalsIgnoreCase(txtMaSV.getText())){
                            return true ;
                       }
                }
            }
        } catch (Exception e) {
        }
        return false ;
    }
    
    // thêm mã sv từ bang sinh viên vào list
    private void ListSV(){
        try {
            String sql = "select MaSV from STUDENTS";
            try(   Connection con = ConnectSQL.OpenLink();
                   Statement stmt = con.createStatement();
                    ){
                   ResultSet rs = stmt.executeQuery(sql);
                   
                   while( rs.next() ){
                       listMaSV.add(rs.getString("MaSV"));
                   }
            }
        } catch (Exception e) {
        }
    }
    
    // Check Ma có ở trong bảng sinh viên k
    private boolean CheckMaTrung(){
        ListSV();
        for( int i=0 ; i<listMaSV.size() ; i++ ){
            if( listMaSV.get(i).equalsIgnoreCase(txtMaSV.getText())){
                return true ;
            }
        }
        return false ;
    }
    
    // Save file
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }   
        
        if( txtGDCD.getText().isEmpty() || txtTiengAnh.getText().isEmpty() || txtMaSV.getText().isEmpty() 
                 || txtTinHoc.getText().isEmpty() ){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin vào các ô trống");
            return ;
        }
        
        if( Check.CheckMa(txtMaSV.getText())== false ){
            JOptionPane.showMessageDialog(rootPane, "Yêu cầu nhập đúng định dạng");
            return ;
        }
        
        if( Check.CheckDoDaiMa(txtMaSV.getText()) == false ){
            JOptionPane.showMessageDialog(rootPane, "Yêu cầu Mã SV > 7 ký tự");
            return ;
        }
        
        if( checkMa() == true ){
            JOptionPane.showMessageDialog(rootPane, "Mã đã được nhập điểm rồi");
            return;
        }
        
        if( CheckMaTrung() == false ){
            JOptionPane.showMessageDialog(rootPane, "Mã SV không tồn tại trong danh sách Sinh Viên");
            return ; 
        }
        
        if( Check.CheckDiem( txtTiengAnh.getText()) == false || Check.CheckDiem( txtGDCD.getText()) == false || Check.CheckDiem( txtTinHoc.getText()) == false ){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập điểm trong khoảng 1 -> 10");
            return ;            
        }        
        
        try {
            String sql = "insert GRADE values ( ? , ? , ? , ? , ? )" ;
            try(   Connection con = ConnectSQL.OpenLink();
                   PreparedStatement pstmt = con.prepareCall(sql);
                   ){
                   pstmt.setInt( 1, Integer.parseInt(txtMaSV.getText().substring(2))  );
                   pstmt.setString(2, txtMaSV.getText());
                   pstmt.setDouble( 3, Double.valueOf(txtTiengAnh.getText()) );
                   pstmt.setDouble( 4, Double.valueOf(txtTinHoc.getText()) );
                   pstmt.setDouble( 5, Double.valueOf(txtGDCD.getText()) );
                   
                   pstmt.executeUpdate();
                   JOptionPane.showMessageDialog(rootPane, "Bạn Đã Thêm Thành Công");
            }
        } catch (Exception e) {
        }
        KetNoi();
    }//GEN-LAST:event_btnSaveActionPerformed

    // Delete
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }   
        
        int chose = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa không?", "Xác Nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if( chose == JOptionPane.NO_OPTION ){
           return ;
        }
        
        try {
            String sql =  "delete from GRADE where MaSV = ?" ;
            try(   Connection con = ConnectSQL.OpenLink();
                   PreparedStatement pstmt = con.prepareCall(sql);
               ){
                   pstmt.setString(1, txtMaSV.getText());
                   pstmt.executeUpdate();
                   LamTrangTxt();
                   JOptionPane.showMessageDialog(rootPane , "Bạn Xóa Thành Công");
                }
        } catch (Exception e) {
        }
        KetNoi();
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Upadate
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }   
        
        if( txtGDCD.getText().isEmpty() || txtTiengAnh.getText().isEmpty() || txtMaSV.getText().isEmpty() 
                 || txtTinHoc.getText().isEmpty() ){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin vào các ô trống");
            return ;
        }        
        
        if( checkMa() == false ){
            JOptionPane.showMessageDialog(rootPane, "Yêu Cầu Mã Sinh Viên phải trùng với data");
            return ;
        }

        if( Check.CheckDiem( txtTiengAnh.getText()) == false || Check.CheckDiem( txtGDCD.getText()) == false || Check.CheckDiem( txtTinHoc.getText()) == false ){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập điểm trong khoảng 1 -> 10");
            return ;            
        }  
        
        try {
            String sql = "Update GRADE set TiengAnh = ? , TinHoc = ?, GDTC = ? where MaSV = ?";
            try(   Connection con = ConnectSQL.OpenLink();
                   PreparedStatement pstmt = con.prepareCall(sql);
                    ){
                  pstmt.setDouble(1,Double.valueOf(txtTiengAnh.getText()) );
                  pstmt.setDouble(2,Double.valueOf(txtTinHoc.getText()) );
                  pstmt.setDouble(3,Double.valueOf(txtGDCD.getText()) );
                  pstmt.setString(4, txtMaSV.getText());
                  pstmt.executeUpdate();
                  JOptionPane.showMessageDialog(rootPane, "Bạn Update thành công");
            }   
        } catch (Exception e) {
        }
        KetNoi();      
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }  
        DangNhap db = new DangNhap();
        db.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    // nút hiển thị thông tin của sinh viên đầu
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
         if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }   
         
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }
        Index = 0 ;
        HienThiThongTin(Index);
        if( checkMa() == false ){
            LamTrangTxt2();
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    // nút previous
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }       
        int k = 0 ;
        Index-- ;
        if( Index <= 0 ){
            Index = 0 ;
            k = 1 ;
        }
        HienThiThongTin(Index);
        if( checkMa() == false ){
            LamTrangTxt2();
        }
        if( k==1 ) JOptionPane.showMessageDialog(rootPane, "bạn đang ở đầu danh sách");
    }//GEN-LAST:event_jButton9ActionPerformed

    // nút next
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }    
        int k = 0 ;
        Index++ ;
        if( Index  >= listDiemSV.size() - 1 ){
            Index = listDiemSV.size() -1 ;
            k = 1 ;
        }
        HienThiThongTin(Index);
        if( checkMa() == false ){
            LamTrangTxt2();
        }
        if( k == 1 ) JOptionPane.showMessageDialog(rootPane, "bạn đang ở cuối danh sách");
    }//GEN-LAST:event_jButton6ActionPerformed

    // hiển thị điểm của sinh viên ở cuối
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        } 
        Index = listDiemSV.size() - 1 ;
        HienThiThongTin(Index);
        if( checkMa() == false ){
            LamTrangTxt2();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiemSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiemSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiemSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiemSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyDiemSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDiemTB;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbTieuDe;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtGDCD;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtTiengAnh;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTinHoc;
    // End of variables declaration//GEN-END:variables
}
