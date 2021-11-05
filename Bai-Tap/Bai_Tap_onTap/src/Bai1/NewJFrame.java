/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;
import java.awt.JobAttributes;
import java.sql.* ;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
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
        setResizable(false);
        setLocationRelativeTo(null);
        model_table = (DefaultTableModel) table.getModel();
        DoVaoCbb();
        
    }
    
    private void DoVaoCbb(){
        try {
            try (  Connection con = ConnectSQL.OpenLink();
                   Statement stmt = con.createStatement() ;
                    ){
                   String sql = "select MaSV from SINHVIEN" ;
                   ResultSet rs = stmt.executeQuery(sql);
                   
                   while ( rs.next() ) {                    
                       cbbMaSV.addItem(rs.getString("MaSV"));
                }
            }
        } catch (Exception e) {
        }
    }
    
    private void DoVaoTable(){
        int count = 0 ;
        try {
            String sql = "select MONHOC.MaMH , TenMH , diem from DIEM join MONHOC on MONHOC.MaMH = DIEM.MaMH where Masv = ? " ;
            try (  Connection con = ConnectSQL.OpenLink();
                   PreparedStatement stmt = con.prepareCall(sql) ;
                    ){
                   stmt.setString(1, cbbMaSV.getSelectedItem().toString() );
                   ResultSet rs = stmt.executeQuery();
                   
                   model_table.setRowCount(0);
                   while ( rs.next() ) {                    
                       model_table.addRow( new Object[]{ rs.getString("MaMH") , rs.getString("TenMH") , rs.getDouble("diem")} );
                       count++ ;
                }
            }
        } catch (Exception e) {
        }       
        if( count > 0 ){
            table.setRowSelectionInterval(0, 0);
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
        cbbMaSV = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaMon = new javax.swing.JTextField();
        txtTenMon = new javax.swing.JTextField();
        txtDiem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Sinh Viên: ");

        cbbMaSV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMaSVItemStateChanged(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Môn", "Tên Môn", "Điểm"
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

        jLabel2.setText("Mã Môn Học:");

        jLabel3.setText("Tên Môn");

        jLabel4.setText("Điểm");

        txtTenMon.setEditable(false);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbbMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(52, 52, 52)
                                .addComponent(txtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbMaSVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMaSVItemStateChanged
        ClearTxt();
        DoVaoTable();
    }//GEN-LAST:event_cbbMaSVItemStateChanged

    private void HienThiNenTxt( int k ){
        
        txtMaMon.setText( table.getValueAt(  k, 0).toString() );
        txtTenMon.setText( table.getValueAt(  k, 1).toString() );
        txtDiem.setText( table.getValueAt(  k, 2).toString() );    
    }
    
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int Index = table.getSelectedRow();
        HienThiNenTxt(Index);
    }//GEN-LAST:event_tableMouseClicked

    private void ClearTxt(){
        txtDiem.setText("");
        txtMaMon.setText("");
        txtTenMon.setText("");
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String sql = "delete from DIEM where Masv = ? and MaMH = ? ";
            try (   Connection con = ConnectSQL.OpenLink();
                    PreparedStatement stmt = con.prepareCall(sql);
                    ){
                    stmt.setString(1, cbbMaSV.getSelectedItem().toString());
                    stmt.setString(2, txtMaMon.getText());
                    stmt.executeUpdate();
                    ClearTxt();
                    JOptionPane.showMessageDialog(rootPane, "delete is successfully");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private boolean CheckDiem(){
        try {
            Double db = Double.valueOf(txtDiem.getText());
            if( db >= 0 && db <= 10 ) 
                 return true ;
        } catch (Exception e) {
            return false ;
        }
        return false ;
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if( CheckDiem() == false ){
            JOptionPane.showMessageDialog(rootPane, "Diem Trung Roi");
            return ;
        }
        
        try {
            String sql = "Update DIEM set diem = ? where Masv = ? and MaMH = ? ";
            try (   Connection con = ConnectSQL.OpenLink();
                    PreparedStatement stmt = con.prepareCall(sql);
                    ){
                    stmt.setFloat(1, Float.valueOf(txtDiem.getText()));
                    stmt.setString(2, cbbMaSV.getSelectedItem().toString());
                    stmt.setString(3, txtMaMon.getText());
                    
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(rootPane, "Update is successfully");
            }
        } catch (Exception e) {
        }        
    }//GEN-LAST:event_jButton3ActionPerformed

    private boolean CheckTrung(){
        try {
            try (  Connection con = ConnectSQL.OpenLink();
                   Statement stmt = con.createStatement() ;
                    ){
                   String sql = "select * from DIEM" ;
                   ResultSet rs = stmt.executeQuery(sql);
                   
                   while ( rs.next() ) {                    
                       if( rs.getString("Masv").equalsIgnoreCase(cbbMaSV.getSelectedItem().toString()) && rs.getString("MaMH").equalsIgnoreCase(txtMaMon.getText()))
                            return true ;
                }
            }
        } catch (Exception e) {
        }        
        return false ;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if( CheckTrung() == true ) {
            JOptionPane.showMessageDialog(rootPane, "Ma Trung Roi");
            return ;
        }
        
        if (CheckDiem() == false) {
            JOptionPane.showMessageDialog(rootPane, "Diem Trung Roi");
            return;
        }
        
        try {
            String sql = "insert DIEM values ( ? , ? , ?) ";
            try (   Connection con = ConnectSQL.OpenLink();
                    PreparedStatement stmt = con.prepareCall(sql);
                    ){
                    stmt.setFloat(3, Float.valueOf(txtDiem.getText()));
                    stmt.setString(1, cbbMaSV.getSelectedItem().toString());
                    stmt.setString(2, txtMaMon.getText());
                    
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(rootPane, "Insert is successfully");
            }
        } catch (Exception e) {
        }  
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JComboBox<String> cbbMaSV;
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
    private javax.swing.JTextField txtMaMon;
    private javax.swing.JTextField txtTenMon;
    // End of variables declaration//GEN-END:variables
}