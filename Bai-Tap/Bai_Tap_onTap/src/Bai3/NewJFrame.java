/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;

import javax.swing.table.DefaultTableModel;
import java.sql.* ;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    DefaultTableModel model_table ;
    public NewJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        model_table = (DefaultTableModel)  table.getModel();
        DoVaoCbb();
        
    }

    private void DoVaoCbb(){
        try {
            try  (  Connection con = ConnectSQL.OpenLink();
                    Statement stmt = con.createStatement();
                    
                    ){
                   String sql = "select MaMH from MONHOC";
                   ResultSet rs = stmt.executeQuery(sql);
                   
                   while ( rs.next() ) {                    
                       cbbMonHoc.addItem(rs.getString(1));
                }
                
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }
    
    private void DoVaoTable(){
        int count = 0 ;
        try {
            String sql = "select SINHVIEN.MaSV ,HoTenSV , diem  from DIEM join SINHVIEN on SINHVIEN.MaSV = DIEM.Masv where MaMH = ? ";
            try  (  Connection con = ConnectSQL.OpenLink();
                    PreparedStatement stmt = con.prepareCall(sql);
                    
                    ){
                   stmt.setString(1, cbbMonHoc.getSelectedItem().toString());
                   ResultSet rs = stmt.executeQuery();
                   model_table.setRowCount(0);
                   while ( rs.next() ) {                    
                       model_table.addRow(new Object[] { rs.getString(1) , rs.getString(2) , rs.getFloat(3)});
                       count++;
                }
                
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }  
        if( count > 0 ) {
             table.setRowSelectionInterval( 0, 0);
             HienThiNenTxt(0);
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

        jLabel1 = new javax.swing.JLabel();
        cbbMonHoc = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        txtDiem = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Môn Học");

        cbbMonHoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMonHocItemStateChanged(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SV", "Họ Tên ", "Điểm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        jLabel2.setText("Mã SV");

        jLabel3.setText("Họ Tên");

        jLabel4.setText("Điểm");

        txtHoTen.setEditable(false);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbbMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbMonHocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMonHocItemStateChanged
       ClearTxt();
        DoVaoTable();
    }//GEN-LAST:event_cbbMonHocItemStateChanged

    private void HienThiNenTxt( int k ){
        txtDiem.setText(table.getValueAt(k, 2).toString());
         txtMaSV.setText(table.getValueAt(k, 0).toString());
          txtHoTen.setText(table.getValueAt(k, 1).toString());    
    }
    
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int kh = table.getSelectedRow();
        HienThiNenTxt(kh);
    }//GEN-LAST:event_tableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            String sql = "delete from DIEM where Masv = ? and MaMH = ? ";
            try  (  Connection con = ConnectSQL.OpenLink();
                    PreparedStatement stmt = con.prepareCall(sql);
                    ){
                   stmt.setString(1, txtMaSV.getText() );
                   stmt.setString(2, cbbMonHoc.getSelectedItem().toString());
                   stmt.executeUpdate();
                   ClearTxt();
                   DoVaoTable();
                   JOptionPane.showMessageDialog(rootPane, "delete is successfully");              
            }
        } catch (Exception e) {
        }       
    }//GEN-LAST:event_jButton3ActionPerformed

    private Boolean CheckTrung(){
       try {
            try  (  Connection con = ConnectSQL.OpenLink();
                    Statement stmt = con.createStatement();
                    ){
                   String sql = "select * from DIEM";
                   ResultSet rs = stmt.executeQuery(sql);
                   
                   while ( rs.next() ) {                    
                       if( txtMaSV.getText().equalsIgnoreCase(rs.getString(1)) && cbbMonHoc.getSelectedItem().toString().equalsIgnoreCase(rs.getString(2)))
                           return true ;
                  }
            }
           } catch (Exception e) {
        }    
           return false ;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if( CheckTrung()== true ){
           JOptionPane.showMessageDialog(rootPane, "ma trung roi");
           return ;           
       }
        
       if( CheckDiem() == false ){
           JOptionPane.showMessageDialog(rootPane, "diem nam trong khoang tu 0->10");
           return ;
       }        
        try {
            String sql = "insert into DIEM values ( ? , ? , ? )";
            try  (  Connection con = ConnectSQL.OpenLink();
                    PreparedStatement stmt = con.prepareCall(sql);
                    ){
                   stmt.setFloat(3, Float.valueOf(txtDiem.getText()));
                   stmt.setString(1, txtMaSV.getText() );
                   stmt.setString(2, cbbMonHoc.getSelectedItem().toString());
                   stmt.executeUpdate();
                   ClearTxt();
                   DoVaoTable();
                   JOptionPane.showMessageDialog(rootPane, "Insert  is successfully");              
            }
        } catch (Exception e) {
        }  
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean CheckDiem(){
        try {
            Double db = Double.valueOf(txtDiem.getText());
            if( db >= 0 && db <= 10 )
                return true;
        } catch (Exception e) {
            return false ;
        }
        return false ;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if( CheckDiem() == false ){
           JOptionPane.showMessageDialog(rootPane, "diem nam trong khoang tu 0->10");
           return ;
       }
        
        try {
            String sql = "Update DIEM set diem = ? where Masv = ? and MaMH = ? ";
            try  (  Connection con = ConnectSQL.OpenLink();
                    PreparedStatement stmt = con.prepareCall(sql);
                    ){
                   stmt.setFloat(1, Float.valueOf(txtDiem.getText()));
                   stmt.setString(2, txtMaSV.getText() );
                   stmt.setString(3, cbbMonHoc.getSelectedItem().toString());
                   stmt.executeUpdate();
                   ClearTxt();
                   DoVaoTable();
                   JOptionPane.showMessageDialog(rootPane, "Update  is successfully");              
            }
        } catch (Exception e) {
        }  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ClearTxt(){
       txtDiem.setText("");
       txtHoTen.setText("");
       txtMaSV.setText("");
    }
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbMonHoc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSV;
    // End of variables declaration//GEN-END:variables
}
