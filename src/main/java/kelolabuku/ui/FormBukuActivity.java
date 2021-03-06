/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelolabuku.ui;

import kelolabuku.database.BukuDatasource;
import kelolabuku.models.Buku;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User-1
 */
public class FormBukuActivity extends javax.swing.JFrame {
    
    /**
     * Creates new form FormBukuActivity
     */
    public FormBukuActivity() {
        initComponents();
    }

    private Buku buku;
    
    private void showError(String message){
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    private void showSucceed(String message){
        JOptionPane.showMessageDialog(this, message, "Sukses", JOptionPane.INFORMATION_MESSAGE);
    }
    private void showOldDataOf(Buku buku){
        judulField.setText(buku.getJudulBuku());
        pengarangField.setText(buku.getPengarang());
        
        String penerbit = buku.getPenerbit();
        switch(penerbit){
            case "Yudhistira": yudhistiraRb.setSelected(true);break;
            case "Gramedia": gramediaRb.setSelected(true);break;
            case "Aitlangga": airlanggaRb.setSelected(true);break;
            default: ygLainRb.setSelected(true);break;
        }
        tahunTerbitCb.setSelectedItem(String.valueOf(buku.getTahunTerbit()));
    }
    public void setBuku(Buku buku){
        this.buku = buku;
        showOldDataOf(buku);
    }
    private String getSelectedPenerbit(){
        if(yudhistiraRb.isSelected()){
            return "Yudhistira";
        } else if(gramediaRb.isSelected()){
            return "Gramedia";
        } else if(airlanggaRb.isSelected()){
            return "Airlangga";
        } else if(ygLainRb.isSelected()){
            return "Yang Lain";
        } else{
            return "";
        }
    }
    private boolean validateAllInput(){
        String judul = judulField.getText();
        if(judul.isEmpty()){
            showError("Judul buku masih kosong");
            return false;
        }
        String pengarang = pengarangField.getText();
        if(pengarang.isEmpty()){
            showError("Pengarang buku masih kosong");
            return false;
        }
        String penerbit = getSelectedPenerbit();
        if(penerbit.isEmpty()){
            showError("Penerbit belum ada yang dipilih");
            return false;
        }
        String tahunTerbit = tahunTerbitCb.getSelectedItem().toString();
        if(tahunTerbit.isEmpty()){
            showError("Tahun terbit belum ada yang dipilih");
            return false;
        }
        return true;
    }
    private void collectDataFor(Buku buku){
        String judul = judulField.getText();
        String pengarang = pengarangField.getText();
        String penerbit = getSelectedPenerbit();
        String tahunTerbit = tahunTerbitCb.getSelectedItem().toString();
        
        buku.setJudulBuku(judul);
        buku.setPengarang(pengarang);
        buku.setPenerbit(penerbit);
        buku.setTahunTerbit(Integer.parseInt(tahunTerbit));
    }
    private void saveNewData(){
        buku = new Buku();
        collectDataFor(buku);
        BukuDatasource datasource = new BukuDatasource();
        try{
            datasource.save(buku);
            showSucceed("Data buku berhasil disimpan");
        } catch(SQLException e){
            showError("Data buku gagal disimpan");
            e.printStackTrace();
        }
    }
    private void updateData(){
        collectDataFor(buku);
        BukuDatasource datasource = new BukuDatasource();
        try{
            datasource.update(buku);
            showSucceed("Data buku berhasil diperbaharui");
        } catch(SQLException e){
            showError("Data buku gagal diperbaharui");
            e.printStackTrace();
        }
    }
    private void simpan(){
        if(!validateAllInput()){
            return;
        }
        if(buku != null){
            updateData();
        } else{
            saveNewData();
        }
    }
    @Override
    public void setTitle(String title){
        super.setTitle(title); // To change body of generated methods, choose Tools | Templates.
        titleActivity.setText(title);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        buttonGroup1 = new javax.swing.ButtonGroup();
        label1 = new java.awt.Label();
        titleActivity = new javax.swing.JLabel();
        judulField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pengarangField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        yudhistiraRb = new javax.swing.JRadioButton();
        airlanggaRb = new javax.swing.JRadioButton();
        gramediaRb = new javax.swing.JRadioButton();
        ygLainRb = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        tahunTerbitCb = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        label1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label1.setText("Form Buku");

        titleActivity.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        titleActivity.setText("Judul");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Pengarang");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Penerbit");

        buttonGroup1.add(yudhistiraRb);
        yudhistiraRb.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        yudhistiraRb.setText("Yudhistira");
        yudhistiraRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yudhistiraRbActionPerformed(evt);
            }
        });

        buttonGroup1.add(airlanggaRb);
        airlanggaRb.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        airlanggaRb.setText("Airlangga");
        airlanggaRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airlanggaRbActionPerformed(evt);
            }
        });

        buttonGroup1.add(gramediaRb);
        gramediaRb.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        gramediaRb.setText("Gramedia");
        gramediaRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gramediaRbActionPerformed(evt);
            }
        });

        buttonGroup1.add(ygLainRb);
        ygLainRb.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ygLainRb.setText("Yang Lain");
        ygLainRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ygLainRbActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Tahun Terbit");

        tahunTerbitCb.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tahunTerbitCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2001", "2002", "2003", "2004" }));
        tahunTerbitCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahunTerbitCbActionPerformed(evt);
            }
        });

        saveBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        saveBtn.setText("Simpan");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cancelBtn.setText("Batal");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titleActivity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tahunTerbitCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pengarangField)
                            .addComponent(judulField)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(yudhistiraRb, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(gramediaRb, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(airlanggaRb, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ygLainRb, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 93, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveBtn)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleActivity)
                    .addComponent(judulField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pengarangField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yudhistiraRb)
                            .addComponent(gramediaRb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ygLainRb)
                            .addComponent(airlanggaRb))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tahunTerbitCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yudhistiraRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yudhistiraRbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yudhistiraRbActionPerformed

    private void airlanggaRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airlanggaRbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_airlanggaRbActionPerformed

    private void gramediaRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gramediaRbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gramediaRbActionPerformed

    private void ygLainRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ygLainRbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ygLainRbActionPerformed

    private void tahunTerbitCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahunTerbitCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tahunTerbitCbActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        simpan();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FormBukuActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBukuActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBukuActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBukuActivity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBukuActivity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton airlanggaRb;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JRadioButton gramediaRb;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JTextField judulField;
    private java.awt.Label label1;
    private javax.swing.JTextField pengarangField;
    private javax.swing.JButton saveBtn;
    private javax.swing.JComboBox<String> tahunTerbitCb;
    private javax.swing.JLabel titleActivity;
    private javax.swing.JRadioButton ygLainRb;
    private javax.swing.JRadioButton yudhistiraRb;
    // End of variables declaration//GEN-END:variables
}
