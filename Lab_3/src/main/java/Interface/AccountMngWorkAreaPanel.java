/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.AccountDirectory;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author luoqi
 */
public class AccountMngWorkAreaPanel extends javax.swing.JPanel {

    /**
     * Creates new form AccountMngWorkAreaPanel
     */
    private JPanel userProcessConrainer;
    private AccountDirectory accountDirectory;


    AccountMngWorkAreaPanel(JPanel userProcessConrainer, AccountDirectory accountDirectory) {
        initComponents();
        this.userProcessConrainer = userProcessConrainer;
        this.accountDirectory = accountDirectory;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createAccountBtn = new javax.swing.JButton();
        mngAccountBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 600));

        createAccountBtn.setText("Create Account");
        createAccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountBtnActionPerformed(evt);
            }
        });

        mngAccountBtn.setText("Manage Account");
        mngAccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngAccountBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mngAccountBtn)
                    .addComponent(createAccountBtn))
                .addContainerGap(484, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(createAccountBtn)
                .addGap(48, 48, 48)
                .addComponent(mngAccountBtn)
                .addContainerGap(319, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createAccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountBtnActionPerformed
        // TODO add your handling code here:
        CreateAccountPanel panel = new CreateAccountPanel(userProcessConrainer,accountDirectory);
        userProcessConrainer.add("CreateAccountPanel",panel);
        CardLayout layout = (CardLayout)userProcessConrainer.getLayout();
        layout.next(userProcessConrainer);
    }//GEN-LAST:event_createAccountBtnActionPerformed

    private void mngAccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngAccountBtnActionPerformed
        // TODO add your handling code here:
        ManageAccountPanel panel = new ManageAccountPanel(userProcessConrainer,accountDirectory);
        userProcessConrainer.add("ManageAccountPanel",panel);
        CardLayout layout = (CardLayout)userProcessConrainer.getLayout();
        layout.next(userProcessConrainer);
    }//GEN-LAST:event_mngAccountBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createAccountBtn;
    private javax.swing.JButton mngAccountBtn;
    // End of variables declaration//GEN-END:variables
}