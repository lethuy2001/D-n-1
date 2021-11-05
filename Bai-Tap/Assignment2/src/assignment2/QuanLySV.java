/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import Heper.Check;
import Heper.ConnectSQL;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class QuanLySV extends javax.swing.JFrame {

    /**
     * Creates new form QuanLySinhVien
     */
    DefaultTableModel table_model ;
    int Index ;
    File source  ; 
    File destImage ;
    String nameImage = null ;
    boolean CheckImg  ;
    DangNhap st  ;    
    public QuanLySV() {
        initComponents();
        setSize(661, 602);
        setResizable(false);
        setLocationRelativeTo(null);
        table_model = (DefaultTableModel) table.getModel();
        CheckImg = false;
        DoiMau();
        ChayChu();
        if( st.CheckDangNhap == true ){
            KetNoi();
        }          
    }

    // Hàm Chạy Chữ
    public void ChayChu(){
        lbTieuDe.setText(" Quản Lý Sinh Viên");
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
    
    // Hàm Đổ Màu Cho Chữ
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

    // Kết nối Với SQL
    private void KetNoi(){
        try {
            try(   Connection con = ConnectSQL.OpenLink();
                   Statement stmt = con.createStatement();
                    ){
                   String sql = "select * from STUDENTS";
                   ResultSet rs = stmt.executeQuery(sql);
                  
                   table_model.setRowCount(0);
                   while( rs.next() ){
                       Vector vs = new Vector();
                       vs.add(rs.getString("MaSV"));
                       vs.add(rs.getString("HoTen"));
                       vs.add(rs.getString("Email"));
                       vs.add(rs.getString("SoDT"));
                       vs.add(rs.getInt("GioiTinh") == 1 ? "Nam" : "Nữ" );
                       vs.add(rs.getString("DiaChi"));
                       vs.add(rs.getString("Hinh"));
                       table_model.addRow(vs);
                   }
            }
        } catch (Exception e) {
        }
    }

    // hàm hiển thị nên cách textField 
    private void HienThiNguocLai( int k ){
         txtMaSV.setText( table.getValueAt(k, 0).toString() );
         txtHoTen.setText( table.getValueAt(k, 1).toString() );
         txtEmail.setText( table.getValueAt(k, 2).toString() );
         txtSoDT.setText( table.getValueAt(k, 3).toString() );
         if( table.getValueAt(k, 4).toString().equalsIgnoreCase("Nam")){
             CheckNam.setSelected(true);
         }else{
             CheckNu.setSelected(true);
         }
         txtDiaChi.setText( table.getValueAt(k, 5).toString() );           
         ImageIcon icon = new ImageIcon("img/"+ table.getValueAt(k, 6).toString() + ".jpg" );
         lbHienThiAnh.setIcon(icon);
    }                             

    // Hàm làm trắng các textField
    private void LamTrangTxt(){
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtHoTen.setText("");
        txtMaSV.setText("");
        txtSoDT.setText("");
        CheckNam.setSelected(true);
        lbHienThiAnh.setIcon(null);   
        CheckImg = false ;
    }    
    
    // Check mã MaSV có trùng không
    private boolean CheckMa(){
        for( int i=0 ; i<table_model.getRowCount() ; i++ ){
             if( txtMaSV.getText().equalsIgnoreCase(table.getValueAt(i, 0).toString() ) ){
                 return true ;
             }
        }
        return false ;
    }
    // Copy ảnh sang file img trong assi
    private void CopyImg(){
       try {
            String name = txtMaSV.getText() ;
            File file = new File("img/" + txtMaSV.getText() + ".jpg");
            if( file.exists() ){
               file.delete();            
            }
              
            destImage = new File("img/" + name + ".jpg");
//          fullpath = file.getAbsolutePath();
            nameImage = destImage.getName();
       
//          link gốc, link đích đến, tên ảnh sau khi sao chép
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream(source);
                os = new FileOutputStream(destImage);
                byte[] buffer = new byte[1024 * 2];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
            } finally {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            }
            //  link gốc, link đích đến, tên ảnh sau khi sao chép
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lbTieuDe = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSoDT = new javax.swing.JTextField();
        txtMaSV = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        CheckNu = new javax.swing.JRadioButton();
        CheckNam = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        lbHienThiAnh = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(null);

        lbTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTieuDe.setText("QUẢN LÝ SINH VIÊN");
        jPanel1.add(lbTieuDe);
        lbTieuDe.setBounds(-3, 26, 660, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("Mã SV:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 110, 50, 16);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Họ Tên:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 150, 60, 16);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText("Email:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(80, 190, 50, 16);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("Số ĐT:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(70, 230, 50, 16);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("Giới Tính:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 270, 70, 16);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("Địa Chỉ:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(60, 310, 60, 16);
        jPanel1.add(txtHoTen);
        txtHoTen.setBounds(160, 140, 190, 30);
        jPanel1.add(txtEmail);
        txtEmail.setBounds(160, 180, 190, 30);
        jPanel1.add(txtSoDT);
        txtSoDT.setBounds(160, 220, 190, 30);
        jPanel1.add(txtMaSV);
        txtMaSV.setBounds(160, 100, 190, 30);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SV", "Họ Tên", "Email", "Số ĐT", "Giới Tính", "Địa Chỉ", "Hình"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 430, 640, 150);

        buttonGroup1.add(CheckNu);
        CheckNu.setForeground(new java.awt.Color(255, 153, 0));
        CheckNu.setText("Nữ");
        jPanel1.add(CheckNu);
        CheckNu.setBounds(250, 270, 60, 20);

        buttonGroup1.add(CheckNam);
        CheckNam.setForeground(new java.awt.Color(255, 153, 0));
        CheckNam.setSelected(true);
        CheckNam.setText("Nam");
        jPanel1.add(CheckNam);
        CheckNam.setBounds(160, 270, 70, 20);

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane2.setViewportView(txtDiaChi);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(160, 310, 210, 86);

        jPanel2.setLayout(null);

        lbHienThiAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHienThiAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHienThiAnhMouseClicked(evt);
            }
        });
        jPanel2.add(lbHienThiAnh);
        lbHienThiAnh.setBounds(0, 0, 120, 150);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(430, 100, 120, 150);

        btnDelete.setBackground(new java.awt.Color(204, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);
        btnDelete.setBounds(400, 330, 100, 30);

        btnSave.setBackground(new java.awt.Color(204, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);
        btnSave.setBounds(530, 280, 100, 30);

        btnUpdate.setBackground(new java.awt.Color(204, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Edit.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);
        btnUpdate.setBounds(530, 330, 100, 30);

        btnFind.setBackground(new java.awt.Color(204, 255, 255));
        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Search.png"))); // NOI18N
        btnFind.setText("Search");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        jPanel1.add(btnFind);
        btnFind.setBounds(400, 380, 100, 30);

        btnExit.setBackground(new java.awt.Color(204, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logout (1).png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);
        btnExit.setBounds(530, 382, 100, 30);

        btnNew.setBackground(new java.awt.Color(204, 255, 255));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Add.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew);
        btnNew.setBounds(400, 280, 100, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/c35e3c1baa7be93127b11f5e2de8ba8f.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 660, 601);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // nút new
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }        
          LamTrangTxt();
    }//GEN-LAST:event_btnNewActionPerformed

    // ấn vào table rồi hiển thị nên
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        Index = table.getSelectedRow();
        HienThiNguocLai(Index);
    }//GEN-LAST:event_tableMouseClicked

    // nut save
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }  
        
        try {
            if( txtDiaChi.getText().isEmpty() || txtEmail.getText().isEmpty() || txtHoTen.getText().isEmpty() 
                    || txtMaSV.getText().isEmpty() || txtSoDT.getText().isEmpty() ){
                 JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin");
                 return ;
            }
            
            if( CheckMa() == true ){
                JOptionPane.showMessageDialog(rootPane, "Mã SV trùng rồi");
                return ;
            }
            
            if( Check.CheckDoDaiMa(txtMaSV.getText()) == false ){
                JOptionPane.showMessageDialog(rootPane, "Mã SV phải lớn hơn 7 ký tự");
                return ;
            }
            
            if( Check.CheckMa(txtMaSV.getText()) == false ){
                JOptionPane.showMessageDialog(rootPane, "Yêu cầu nhập đúng định dạng");
                return ;
            }
           
            if( Check.CheckTen(txtHoTen.getText()) == false ){
                JOptionPane.showMessageDialog(rootPane, "Yêu cầu tên k có ký tự đặc biệt");
                return ;               
            }            
            
            if( Check.CheckEmail(txtEmail.getText()) == false ){
                JOptionPane.showMessageDialog(rootPane, "Yếu cầu email dúng định dạng @fpt.edu.vn");
                return ;               
            }                
            
            if( Check.CheckSDT(txtSoDT.getText()) == false ){
                JOptionPane.showMessageDialog(rootPane, "Yêu cầu sdt phải có 10 số");
                return ;
            }
            
            String sql = "insert STUDENTS values ( ? , ? , ? ,? , ? , ? , ?)";
            try (  Connection con = ConnectSQL.OpenLink();
                   PreparedStatement pstmt = con.prepareCall(sql);
                    ){
                   pstmt.setString( 1, txtMaSV.getText());
                   pstmt.setString( 2, txtHoTen.getText());
                   pstmt.setString( 3, txtEmail.getText());
                   pstmt.setString( 4, txtSoDT.getText());
                   pstmt.setInt( 5, CheckNam.isSelected() ? 1 : 0);
                   pstmt.setString( 6 , txtDiaChi.getText());  
                   if( CheckImg == true ){
                       CopyImg(); 
                       nameImage =txtMaSV.getText();
                   }else{
                       nameImage = "Unknown" ;
                       CheckImg = false ;
                       
                   }
                   pstmt.setString( 7, nameImage );  
                   pstmt.executeUpdate();
                   JOptionPane.showMessageDialog(rootPane, "Bạn đã thêm thành công");
            }
            KetNoi();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    // Chọn ảnh
    private void lbHienThiAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHienThiAnhMouseClicked
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }  
        try {
            JFileChooser jfc = new JFileChooser();
            int result = jfc.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                source = jfc.getSelectedFile();
                lbHienThiAnh.setIcon(new ImageIcon(source.getAbsolutePath()));
                CheckImg = true ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }//GEN-LAST:event_lbHienThiAnhMouseClicked

    // Delete
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }  
        
        int chose = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xóa k?", "Comfirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if( chose == JOptionPane.NO_OPTION ){
           return ;
        }
        
        Index = table.getSelectedRow();
        if( Index == -1 ){
             JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn dòng bạn muốn xóa");
             return ;
        }
        
        
        try {
            String sql = "delete from GRADE where MaSV = ? "  +
                         "delete from STUDENTS where MaSV = ? " ;
                         
            try(   Connection con = ConnectSQL.OpenLink();
                   PreparedStatement pstmt = con.prepareCall(sql);
               ){
                   pstmt.setString(1, table.getValueAt( Index, 0).toString() );
                   pstmt.setString(2, table.getValueAt( Index, 0).toString() );
                   pstmt.executeUpdate();
                   LamTrangTxt();
                   JOptionPane.showMessageDialog(rootPane , "Bạn Xóa Thành Công");
                }
        } catch (Exception e) {
        }
        KetNoi();
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Update
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }  
        
        Index = table.getSelectedRow();        
        if( Index == -1 ){
             JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn dòng bạn muốn cập nhập");
             return ;
        }
        
        if (Check.CheckDoDaiMa(txtMaSV.getText()) == false) {
            JOptionPane.showMessageDialog(rootPane, "Mã SV phải lớn hơn 7 ký tự");
            return;
        }

        if (Check.CheckMa(txtMaSV.getText()) == false) {
            JOptionPane.showMessageDialog(rootPane, "Yêu cầu nhập đúng định dạng");
            return;
        }

        if (Check.CheckTen(txtHoTen.getText()) == false) {
            JOptionPane.showMessageDialog(rootPane, "Yêu cầu tên k có ký tự đặc biệt");
            return;
        }

        if (Check.CheckEmail(txtEmail.getText()) == false) {
            JOptionPane.showMessageDialog(rootPane, "Yếu cầu email dúng định dạng @fpt.edu.vn");
            return;
        }

        if (Check.CheckSDT(txtSoDT.getText()) == false) {
            JOptionPane.showMessageDialog(rootPane, "Yêu cầu sdt phải có 10 số");
            return;
        }

        try {
            String sql = "Update STUDENTS set HoTen = ? , Email =? , SoDT = ?, GioiTinh = ? , DiaChi = ?, Hinh = ? where MaSV = ?"  ;
            try(  Connection con = ConnectSQL.OpenLink();
                  PreparedStatement pstmt = con.prepareCall(sql);
                   ){
                  pstmt.setString(1, txtHoTen.getText());
                  pstmt.setString(2, txtEmail.getText());
                  pstmt.setString(3, txtSoDT.getText());
                  pstmt.setInt(4, CheckNam.isSelected() ? 1 : 0 );
                  pstmt.setString(5, txtDiaChi.getText()); 
                  
                  if( CheckImg == true ){
//                       File file = new File("img/" + txtMaSV.getText() + ".jpg");
//                       file.delete();
                       CopyImg();
                       int sk = nameImage.lastIndexOf('.');
                       nameImage = nameImage.substring(0, sk);                       
                  }else{
                       nameImage = txtMaSV.getText();
                       CheckImg = false ;
                  }
                  pstmt.setString(6,  nameImage);
                  pstmt.setString(7, txtMaSV.getText());
                  pstmt.executeUpdate();
                  JOptionPane.showMessageDialog(rootPane, "Cập Nhập Thành Công");
            }
        } catch (Exception e) {
        }
        KetNoi();
    }//GEN-LAST:event_btnUpdateActionPerformed

    // Search
    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }  
        
        String input = JOptionPane.showInputDialog(rootPane, "Vui lòng nhập mã bạn muốn tìm");
        boolean checkInput = false ;
        
        if( input == null ){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập mã bạn muốn tìm");
            return  ;
        }
            
        for( int i=0 ; i<table.getRowCount() ; i++ ){
            if( table.getValueAt(i, 0).toString().equalsIgnoreCase(input) ){
                HienThiNguocLai(i);
                table.setRowSelectionInterval(i, i);
                checkInput = true ;
                break ;
            }
        }
        if( checkInput == false ) JOptionPane.showMessageDialog(rootPane, "Mã SV bạn cần tìm không có");
    }//GEN-LAST:event_btnFindActionPerformed

    // nut exit
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        if( st.CheckDangNhap == false ){
            JOptionPane.showMessageDialog(rootPane, "Mời đăng nhập");
            return;
        }  
        DangNhap dn = new DangNhap();
        dn.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton CheckNam;
    private javax.swing.JRadioButton CheckNu;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbHienThiAnh;
    private javax.swing.JLabel lbTieuDe;
    private javax.swing.JTable table;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtSoDT;
    // End of variables declaration//GEN-END:variables
}
