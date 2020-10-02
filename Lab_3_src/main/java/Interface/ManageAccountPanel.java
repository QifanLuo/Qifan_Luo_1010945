/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Business.AccountDirectory;
import Business.Account;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luoqi
 */
public class ManageAccountPanel extends javax.swing.JPanel {

    private JPanel userProcessConrainer;
    private AccountDirectory accountDirectory;



    ManageAccountPanel(JPanel userProcessConrainer, AccountDirectory accountDirectory) {
        initComponents();
        this.userProcessConrainer = userProcessConrainer;
        this.accountDirectory = accountDirectory; 
        populateTable();
    }
    
    
    private void populateTable(){
        
        DefaultTableModel dtm = (DefaultTableModel)accountsTbl.getModel();
        dtm.setRowCount(0);
        
        for(Account account : accountDirectory.getAccountList()){
            
            Object row[] = new Object[4];
            row[0] = account;
            row[1] = account.getAccountNumber();
            row[2] = account.getRoutingNumber();
            row[3] = account.getBalance();

            dtm.addRow(row);
            
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        accountsTbl = new javax.swing.JTable();
        searchBtn = new javax.swing.JButton();
        viewBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        accountNumTxt = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 600));

        accountsTbl.setBackground(new java.awt.Color(204, 204, 204));
        accountsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bank Name", "Account Number", "Routing Number", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(accountsTbl);
        if (accountsTbl.getColumnModel().getColumnCount() > 0) {
            accountsTbl.getColumnModel().getColumn(0).setResizable(false);
            accountsTbl.getColumnModel().getColumn(1).setResizable(false);
            accountsTbl.getColumnModel().getColumn(2).setResizable(false);
            accountsTbl.getColumnModel().getColumn(3).setResizable(false);
        }

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        viewBtn.setText("View Detail");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete Account");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        backBtn.setText("< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchBtn)
                        .addGap(18, 18, 18)
                        .addComponent(accountNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewBtn))
                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(backBtn)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn)
                    .addComponent(accountNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(viewBtn)
                .addGap(18, 18, 18)
                .addComponent(deleteBtn)
                .addContainerGap(172, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        Account result = accountDirectory.searchAccount(accountNumTxt.getText());
        
        if(result == null){
            JOptionPane.showMessageDialog(null, "Account Number you entered does not exist","Information",JOptionPane.INFORMATION_MESSAGE);
        }else{
            ViewDetailsPanel panel = new ViewDetailsPanel(userProcessConrainer,result);
            userProcessConrainer.add("ViewDetailsPanel",panel);
            CardLayout layout = (CardLayout)userProcessConrainer.getLayout();
            layout.next(userProcessConrainer);
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessConrainer.remove(this);
        CardLayout layout = (CardLayout)userProcessConrainer.getLayout();
        layout.previous(userProcessConrainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = accountsTbl.getSelectedRow();
        
        if(selectedRow >= 0){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to delete this account detail?", "Warning", dialogButton);
            
            if(dialogResult == JOptionPane.YES_OPTION){
                Account account = (Account)accountsTbl.getValueAt(selectedRow, 0);
                accountDirectory.deleteAccount(account);
                populateTable();
            }
            
     
        }else{
            JOptionPane.showMessageDialog(null, "Please select any row","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = accountsTbl.getSelectedRow();
        
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select any row to view details ","Warning",JOptionPane.WARNING_MESSAGE);

        }else{
            
            Account account = (Account)accountsTbl.getValueAt(selectedRow, 0); 
            ViewDetailsPanel panel = new ViewDetailsPanel(userProcessConrainer,account);
            
            userProcessConrainer.add("ViewDetailsPanel",panel);
            CardLayout layout = (CardLayout)userProcessConrainer.getLayout();
            layout.next(userProcessConrainer);
            
        }
        
        
    }//GEN-LAST:event_viewBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountNumTxt;
    private javax.swing.JTable accountsTbl;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables

}
