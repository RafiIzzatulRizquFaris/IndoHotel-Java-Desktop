/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indohotel.transactform;

import indohotel.utility.Koneksi;
import indohotel.utility.MyUtility;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author risqu
 */
public class CheckOutForm extends javax.swing.JInternalFrame {

    DefaultTableModel modelReservation = new DefaultTableModel();
    MyUtility mu = new MyUtility();
    Koneksi conn = new Koneksi();
    String reservationDefaultQuery = "SELECT reservasi.*, pelanggan.nama_pelanggan, kamar.nomor_kamar FROM reservasi, pelanggan, kamar WHERE reservasi.id_pelanggan = pelanggan.id_pelanggan AND reservasi.id_kamar = kamar.id_kamar";
    String idPayment = "";
    String totalPayment = "";
    String totalTax = "";
    
    public CheckOutForm() {
        initComponents();
        
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI uI = (BasicInternalFrameUI) this.getUI();
        uI.setNorthPane(null);
        
        this.setPreferredSize(new Dimension(506, 395));
        setSize(new Dimension(506, 395));
        
        table_reservation.setModel(modelReservation);
        modelReservation.addColumn("ID Reservation");
        modelReservation.addColumn("Name");
        modelReservation.addColumn("Room Number");
        modelReservation.addColumn("Check In Date");
        modelReservation.addColumn("ID Customer");
        modelReservation.addColumn("ID Room");
        
        showData(reservationDefaultQuery);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_reservation = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tf_payment = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_tax = new javax.swing.JTextField();
        tf_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btn_checkout = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tf_balance = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_total_payment = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        table_reservation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_reservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table_reservationMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(table_reservation);

        jLabel1.setText("Checkout Date :");

        tf_payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_paymentActionPerformed(evt);
            }
        });
        tf_payment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_paymentKeyReleased(evt);
            }
        });

        jLabel2.setText("Tax");

        tf_tax.setEditable(false);

        tf_search.setText("Search with room number");
        tf_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_searchFocusGained(evt);
            }
        });

        btn_search.setText("Search");
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_searchMousePressed(evt);
            }
        });
        btn_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btn_searchKeyReleased(evt);
            }
        });

        btn_checkout.setText("Check Out");
        btn_checkout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_checkoutMousePressed(evt);
            }
        });

        jLabel3.setText("Payment");

        jButton3.setBackground(new java.awt.Color(153, 153, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Submit");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });

        jLabel4.setText("Balance");

        tf_balance.setEditable(false);
        tf_balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_balanceActionPerformed(evt);
            }
        });

        jLabel5.setText("Total Payment");

        tf_total_payment.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_search))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_checkout))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(45, 45, 45)
                                .addComponent(tf_payment))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(50, 50, 50)
                                .addComponent(tf_balance))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(tf_total_payment, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(69, 69, 69)
                                .addComponent(tf_tax)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_checkout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tf_total_payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tf_tax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_reservationMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_reservationMousePressed

    }//GEN-LAST:event_table_reservationMousePressed

    private void tf_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_paymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_paymentActionPerformed

    private void tf_balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_balanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_balanceActionPerformed

    private void tf_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_searchFocusGained
        tf_search.setText(null);
    }//GEN-LAST:event_tf_searchFocusGained

    private void btn_checkoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_checkoutMousePressed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String checkoutDate = sdf.format(jDateChooser1.getDate());
        int i = mu.getSelectedRow(table_reservation);
        String idReservation = modelReservation.getValueAt(i, 0).toString();
        String idCustomer = modelReservation.getValueAt(i, 4).toString();
        String idRoom = modelReservation.getValueAt(i, 5).toString();
        mu.executeingQuery("INSERT INTO `roomcheckout` (`id_checkout`, `id_reservasi`, `id_pelanggan`, `id_kamar`, `tgl_checkout`) VALUES (NULL, '"+idReservation+"', '"+idCustomer+"', '"+idRoom+"', '"+checkoutDate+"');", "Success Checkout", "Checkout Failed", this, conn);
        showData(reservationDefaultQuery);
        makePayment(idReservation);
    }//GEN-LAST:event_btn_checkoutMousePressed

    private void btn_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_searchKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchKeyReleased

    private void btn_searchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMousePressed
        showData("SELECT reservasi.*, pelanggan.nama_pelanggan, kamar.nomor_kamar FROM reservasi, pelanggan, kamar WHERE reservasi.id_pelanggan = pelanggan.id_pelanggan AND reservasi.id_kamar = kamar.id_kamar AND kamar.nomor_kamar = '"+tf_search.getText().trim()+"'");
    }//GEN-LAST:event_btn_searchMousePressed

    private void tf_paymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_paymentKeyReleased
        tf_balance.setText(String.valueOf(Integer.parseInt(tf_payment.getText().trim()) - Integer.parseInt(totalPayment) + Integer.parseInt(totalTax)));
    }//GEN-LAST:event_tf_paymentKeyReleased

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        if (Integer.parseInt(tf_balance.getText().trim()) < 0) {
            System.out.println("Pembayaran kurang");
        }else{
            int allPayment = Integer.parseInt(totalPayment) + Integer.parseInt(totalTax);
            mu.executeingQuery("UPDATE `pembayaran` SET `total_pembayaran` = '"+allPayment+"' WHERE `pembayaran`.`id_pembayaran` = '"+idPayment+"';", "Payment Success", "Payment Failed", this, conn);
        }
    }//GEN-LAST:event_jButton3MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_checkout;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable table_reservation;
    private javax.swing.JTextField tf_balance;
    private javax.swing.JTextField tf_payment;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_tax;
    private javax.swing.JTextField tf_total_payment;
    // End of variables declaration//GEN-END:variables

    private void showData(String query) {
        int row = table_reservation.getRowCount();
        for (int i = 0; i < row; i++) {
            modelReservation.removeRow(0);
        }
        
        try{
            Statement statement = conn.getKoneksi().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                String[] data = {rs.getString(1), rs.getString(5), rs.getString(6), rs.getString(4), rs.getString(2), rs.getString(3)};
                modelReservation.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationForm.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString() + " in func Show Data");
        }
    }

    private void makePayment(String idReservation) {
        String query = "SELECT pembayaran.id_pembayaran, pembayaran.total_pembayaran FROM pembayaran, roomcheckout WHERE roomcheckout.id_reservasi = '"+idReservation+"' AND roomcheckout.id_checkout = pembayaran.id_checkout";
        try{
            Statement st = conn.getKoneksi().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                idPayment = rs.getString(1);
                totalPayment = rs.getString(2);
                totalTax = String.valueOf(Integer.parseInt(totalPayment) * 3 / 100);
                tf_total_payment.setText(totalPayment);
                tf_tax.setText(totalTax);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckOutForm.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
    }
}
