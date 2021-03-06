/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.sql.* ;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Bai2 extends javax.swing.JFrame {

    /**
     * Creates new form Bai2
     */
    ArrayList<HocSinh> listHS = new ArrayList<>();
    int Index1 , Index2 ;
    int k = 0 ;
    public Bai2() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        DoVaoCbb1();
        DoVaoCbb2();
        KetNoi();
        DoVaoTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtParentName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CbbStandard = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbbFees = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Standard"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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

        jLabel1.setText("Name");

        jLabel2.setText("Address");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        jLabel3.setText("ParentName");

        jLabel4.setText("ContactNo");

        jLabel5.setText("Standard");

        CbbStandard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbbStandardActionPerformed(evt);
            }
        });

        jLabel6.setText("Fees");

        jPanel1.setLayout(new java.awt.GridLayout(2, 4, 10, 10));

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew);

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        jPanel1.add(btnInsert);

        btnEdit.setText("Edit");
        jPanel1.add(btnEdit);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel1.add(btnNext);

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrevious);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                        .addComponent(txtParentName)
                                        .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(CbbStandard, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbbFees, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtParentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbbStandard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbbFees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // ????? v??o table
    private void DoVaoTable(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
        for( HocSinh x : listHS ){
           model.addRow( new Object[]{ x.getName() , x.getStandard() });
        }
        table.setModel(model);
    }
    
    // ????? ng?????c l???i
    private void HienNenTren( int k ){
        HocSinh sv = listHS.get(k);
        txtAddress.setText(sv.getAddress());
        txtContactNo.setText(sv.getContactNo());
        txtName.setText(sv.getName());
        txtParentName.setText(sv.getParentName());
        CbbStandard.setSelectedItem(sv.getStandard());
        cbbFees.setSelectedItem(sv.getFee());
    }
    
    // K???t n???i v???i SQL
    private void KetNoi(){
        try {
            try(  Connection con = ConnectSQL.OpenLink();
                  Statement stmt = con.createStatement();
                 ){
                 String sql = "select * from STUDENTS" ;
                 ResultSet rs =  stmt.executeQuery(sql);
                 listHS.clear();
                 while( rs.next() ){
                     HocSinh hs = new HocSinh();
                     hs.setName(rs.getString(2));
                     hs.setAddress(rs.getString(3));
                     hs.setParentName(rs.getString(4));
                     hs.setContactNo(rs.getString(5));
                     hs.setStandard(rs.getString(6));
                     hs.setFee(rs.getDouble(7));
                     listHS.add(hs);
                 }
                 DoVaoTable();
            }
        } catch (Exception e) {
        }
    }
    
    // ????? V??o c??c cbb
    private void DoVaoCbb1(){
        String[] name = {"Ch??? ????? ??u ti??n" , "Khen th?????ng" , "B???o Hi??m Y T???"} ;
        
        CbbStandard.setModel(new DefaultComboBoxModel(name));
    }
    
    private void DoVaoCbb2(){
        Double name[] = { 1500000.0, 2000000.0 , 6000000.0 };
        
        cbbFees.setModel( new DefaultComboBoxModel( name ));
    }
    
    // Clear c??c text field
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtAddress.setText("");
        txtContactNo.setText("");
        txtName.setText("");
        txtParentName.setText("");
        CbbStandard.setSelectedIndex(0);
        cbbFees.setSelectedIndex(0);
    }//GEN-LAST:event_btnNewActionPerformed

    // N??t tho??t 
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int chose = JOptionPane.showConfirmDialog(rootPane, "B???n c?? mu???n tho??t kh??ng ?", "X??c nh???m", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if( chose == JOptionPane.YES_OPTION ){
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    // Th??m th??ng tin v??o SQL
    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if( txtAddress.getText().isEmpty() || txtContactNo.getText().isEmpty() || txtName.getText().isEmpty() || txtParentName.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Vui l??ng nh???p ?????y ????? th??ng tin");
            return ;
        }
        
        try {
            Index1 = CbbStandard.getSelectedIndex();
            Index2 = cbbFees.getSelectedIndex();
            String sql = "Insert  STUDENTS values ( ? , ? , ? , ? ,? , ? )";
            try (  Connection con = ConnectSQL.OpenLink();
                   PreparedStatement pstmt = con.prepareStatement(sql);
                 ) {
                 pstmt.setString( 2, txtName.getText());
                 pstmt.setString( 3, txtAddress.getText());
                 pstmt.setString( 4, txtParentName.getText());
                 pstmt.setString(  5, txtContactNo.getText());
                 pstmt.setString( 6, CbbStandard.getItemAt(Index1));
                 pstmt.setDouble( 7, Double.valueOf(cbbFees.getItemAt(Index2)) );
                 
                 pstmt.executeUpdate();
                 KetNoi();
                 JOptionPane.showMessageDialog( this, "Nh???p th??nh c??ng");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    // X??a Th??ng tin trong Sql 
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            String sql = "delete from Student where ";
            try (  Connection con = ConnectSQL.OpenLink();
                   
                    ) {
                
            } 
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Click v??o table
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        Index1 = table.getSelectedRow();
        HienNenTren(Index1);
    }//GEN-LAST:event_tableMouseClicked

    // Next -> 
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        k-- ;
        if( k<0 ){
           JOptionPane.showMessageDialog(rootPane, "B???n ??ang ??? ?????u danh s??ch");            
            k = 0 ;
            return ;
        }
        table.setRowSelectionInterval(k, k);        
        HienNenTren(k);
    }//GEN-LAST:event_btnNextActionPerformed
    
    // Previous ->
    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        k++ ;
        if( k >= listHS.size() ){
            JOptionPane.showMessageDialog(rootPane, "B???n ??ang ??? cu???i danh s??ch");
            k = listHS.size() - 1 ;
            return ;
        }
        table.setRowSelectionInterval(k, k);
        HienNenTren(k);        
    }//GEN-LAST:event_btnPreviousActionPerformed

    // Update Th??ng tin
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
         try {
             String sql = "Update Student set ";
             try(  Connection con = ConnectSQL.OpenLink();
                   
                     ){
             
             }   
        } catch (Exception e) {
        }
   
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void CbbStandardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbbStandardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbbStandardActionPerformed

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
            java.util.logging.Logger.getLogger(Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bai2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbbStandard;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbFees;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtParentName;
    // End of variables declaration//GEN-END:variables
}
