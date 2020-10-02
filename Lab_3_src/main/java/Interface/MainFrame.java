/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Business.AccountDirectory;
import java.awt.CardLayout;
/**
 *
 * @author luoqi
 */
public class MainFrame extends javax.swing.JFrame {
    
    private AccountDirectory accountDirectory;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.accountDirectory= new AccountDirectory();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        topjPanel = new javax.swing.JPanel();
        accountMngBtn = new javax.swing.JButton();
        userProcessConrainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        topjPanel.setBackground(new java.awt.Color(204, 204, 255));

        accountMngBtn.setBackground(new java.awt.Color(204, 255, 204));
        accountMngBtn.setText("Account Manager");
        accountMngBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountMngBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topjPanelLayout = new javax.swing.GroupLayout(topjPanel);
        topjPanel.setLayout(topjPanelLayout);
        topjPanelLayout.setHorizontalGroup(
            topjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topjPanelLayout.createSequentialGroup()
                .addContainerGap(483, Short.MAX_VALUE)
                .addComponent(accountMngBtn)
                .addGap(33, 33, 33))
        );
        topjPanelLayout.setVerticalGroup(
            topjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topjPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(accountMngBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(topjPanel);

        userProcessConrainer.setBackground(new java.awt.Color(204, 204, 204));
        userProcessConrainer.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(userProcessConrainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accountMngBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountMngBtnActionPerformed
        // TODO add your handling code here:
        AccountMngWorkAreaPanel panel = new AccountMngWorkAreaPanel(userProcessConrainer,accountDirectory);
        userProcessConrainer.add("AccountMngWorkAreaPanel",panel);
        CardLayout layout = (CardLayout)userProcessConrainer.getLayout();
        layout.next(userProcessConrainer);
        
        
    }//GEN-LAST:event_accountMngBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountMngBtn;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel topjPanel;
    private javax.swing.JPanel userProcessConrainer;
    // End of variables declaration//GEN-END:variables
}
