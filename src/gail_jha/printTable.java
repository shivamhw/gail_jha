/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gail_jha;

import static gail_jha.Main_Pager.con;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shivam
 */
public class printTable extends javax.swing.JFrame {

    /**
     * Creates new form printTable
     * @param st
     * @param la
     */
    public printTable(String st,String la){
              initComponents();
                   setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/GAIL_logo.gif")));
          setLocationRelativeTo(null);
        try {
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery("select id from main_db where dt='"+st+"'");
            rs.next();
            int startID = rs.getInt(1);
            rs.close();
            int endID = 0;
            rs = sta.executeQuery("select id from main_db where dt='"+la+"'");
            while(rs.next())
                endID = rs.getInt(1);
            rs.close();
         //   System.out.println(" "+startID+endID);
            while(startID<=endID){
                rs = sta.executeQuery("select * from main_db where id="+startID+"");
                rs.next();
                String ack = rs.getString(2);
                String loc = rs.getString(6);
                String des = rs.getString(7);
                int status = rs.getInt(4);
                 String date = rs.getString(3);
                 String typ1 = rs.getString(5);
                String com = rs.getString(9);
                 String stat= "";
                 switch (status) {
                case 0:
                    stat = "Pending";
                    break;
                case 1:
                    stat = "In Progress";
                    break;
                default:
                    stat = "Completed";
                    break;
            }
           // System.out.println(ack+" "+loc);
            DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
            d1.addRow(new Object []{ack,date,typ1,stat,des,com});
            startID++;
            rs.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Empty Records");
            Logger.getLogger(printTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    public printTable(String la){
          initComponents();
          setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/GAIL_logo.gif")));
          setLocationRelativeTo(null);
                try{
        Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from main_db where dt='"+la+"'");
            while(rs.next()){
                String ack = rs.getString(2);
              String loc = rs.getString(6);
              String des = rs.getString(7);
              int status = rs.getInt(4);
              String date = rs.getString(3);
              String typ1 = rs.getString(5);
              String com = rs.getString(9);
              String stat= "";
            switch (status) {
                case 0:
                    stat = "Pending";
                    break;
                case 1:
                    stat = "In Progress";
                    break;
                default:
                    stat = "Completed";
                    break;
            }
            DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
            d1.addRow(new Object []{ack,date,typ1,stat,des,com});
        }rs.close();
        
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No Records Found!");
            Logger.getLogger(printTable.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    
    }
    public printTable() {
        initComponents();
               setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/GAIL_logo.gif")));
            setLocationRelativeTo(null);
        try{
        Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from main_db");
            while(rs.next()){
                String ack = rs.getString(2);
              String loc = rs.getString(6);
              String des = rs.getString(7);
              int status = rs.getInt(4);
              String date = rs.getString(3);
              String typ1 = rs.getString(5);
              String com = rs.getString(9);
              String stat= "";
            switch (status) {
                case 0:
                    stat = "Pending";
                    break;
                case 1:
                    stat = "In Progress";
                    break;
                default:
                    stat = "Completed";
                    break;
            }
            DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
            d1.addRow(new Object []{ack,date,typ1,stat,des,com});
        }rs.close();
        
    }   catch (SQLException ex) {
                   JOptionPane.showMessageDialog(this, "Error 108");
            Logger.getLogger(printTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    printTable(String type, int i) {
          initComponents();
          setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/GAIL_logo.gif")));
          setLocationRelativeTo(null);
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from main_db where cid='"+type+"'");
            while(rs.next()){
              String ack = rs.getString(2);
              String loc = rs.getString(6);
              String des = rs.getString(7);
              int status = rs.getInt(4);
              String date = rs.getString(3);
              String typ1 = rs.getString(5);
              String com = rs.getString(9);
              String stat= "";
            switch (status) {
                case 0:
                    stat = "Pending";
                    break;
                case 1:
                    stat = "In Progress";
                    break;
                default:
                    stat = "Completed";
                    break;
            }
            DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
            d1.addRow(new Object []{ack,date,typ1,stat,des,com});
        }rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(printTable.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reports");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ACK No", "Date", "Complain Type", "Status", "Description", "Comment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(200);
        }

        jButton1.setText("View Detail");
        jButton1.setMaximumSize(new java.awt.Dimension(111, 25));
        jButton1.setMinimumSize(new java.awt.Dimension(111, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Copy ACK");
        jButton2.setMaximumSize(new java.awt.Dimension(111, 25));
        jButton2.setMinimumSize(new java.awt.Dimension(111, 25));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Print Table");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gradient-white-yellow-linear-1920x1080-c2-ffffff-ffffe0-a-300-f-14.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(700, 700, 700)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(570, 570, 570)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        String nm = (String) jTable1.getValueAt(selectedRow, 0);
        new Update(nm).setVisible(true);
// JOptionPane.showMessageDialog(this, nm);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        String nm = (String) jTable1.getValueAt(selectedRow, 0);
        StringSelection stringSelection = new StringSelection(nm);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
        JOptionPane.showMessageDialog(this, "Ack Copied To Clipboard");
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            jTable1.print();        // TODO add your handling code here:
        } catch (PrinterException ex) {
            Logger.getLogger(printTable.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(printTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(printTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(printTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(printTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new printTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
