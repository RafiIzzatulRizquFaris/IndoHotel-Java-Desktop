/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indohotel.utility;

import com.toedter.calendar.JDateChooser;
import indohotel.masterform.AdminForm;
import indohotel.masterform.ManageRoomForm;
import indohotel.masterform.ManageUserForm;
import indohotel.transactform.CheckOutForm;
import indohotel.transactform.ReservationForm;
import java.awt.Color;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author risqu
 */
public class MyUtility {
    
    public String encryptingPassword(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bs = md.digest(input.getBytes());
            BigInteger bi = new BigInteger(1, bs);
            String hashText = bi.toString(16);
            while (hashText.length() < 32) {                
                hashText = "0" + hashText;
            }
            return hashText;
        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException(e); 
        }
    }
    
    public void intent(JFrame frameHide, JFrame frameShow) {
        frameHide.setVisible(false);
        frameShow.setVisible(true);
    }
    
    public void executeingQuery(String query, String success, String failed, AdminForm af, Koneksi conn){
        try{
            Statement s = conn.getKoneksi().createStatement();
            s.executeUpdate(query);
            JOptionPane.showMessageDialog(af, success, success, JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(af, failed, failed, JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.toString());
            System.out.println(failed);
        } finally{
            af.showData();
            af.clearField();
        }
    }
    
    public void executeingQuery(String query, String success, String failed, ManageUserForm form, Koneksi conn){
        try{
            Statement s = conn.getKoneksi().createStatement();
            s.executeUpdate(query);
            JOptionPane.showMessageDialog(form, success, success, JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(form, failed, failed, JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.toString());
            System.out.println(failed);
        } finally{
            form.showData();
            form.clearField();
        }
    }
    
    public void executeingQuery(String query, String success, String failed, ReservationForm rf, Koneksi conn){
        try{
            Statement s = conn.getKoneksi().createStatement();
            s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, success, success, JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, failed, failed, JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.toString());
            System.out.println(failed);
        } finally{
            rf.clearField();
        }
    }
    
    public void executeingQuery(String query, String success, String failed, CheckOutForm cof, Koneksi conn){
        try{
            Statement s = conn.getKoneksi().createStatement();
            s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, success, success, JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, failed, failed, JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.toString());
            System.out.println(failed);
        }
    }
    
    public void executeingQuery(String query, String success, String failed, ManageRoomForm mrf, Koneksi conn){
        try{
            Statement s = conn.getKoneksi().createStatement();
            s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, success, success, JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, failed, failed, JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.toString());
            System.out.println(failed);
        } finally{
            mrf.clearField();
        }
    }
    
    public void fillComboBox(JComboBox comboBox, String query, Koneksi conn, int column){
        comboBox.addItem("");
        try{
            Statement statement = conn.getKoneksi().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {                
                comboBox.addItem(rs.getString(column));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyUtility.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
    }
    
    public String choosenDate(JDateChooser jdc){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String cd = sdf.format(jdc.getDate());
        return cd;
    }
    
    public void setColor(JPanel panel){
        panel.setBackground(new Color(153,153,255));
    }
    
    public void resetColor(JPanel panel){
        panel.setBackground(new Color(204,102,255));
    }
    
    public int getSelectedRow(JTable table) {
        return table.getSelectedRow();
    }
}
