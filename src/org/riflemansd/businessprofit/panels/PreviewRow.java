/* ~~ ﻿The PreviewRow is part of BusinessProfit. ~~
 * 
 * The BusinessProfit's classes and any part of the code 
 * cannot be copied/distributed without 
 * the permission of Sotiris Doudis
 * 
 * Github - RiflemanSD - https://github.com/RiflemanSD
 * 
 * Copyright © 2016 Sotiris Doudis | All rights reserved
 * 
 * License for BusinessProfit project - in GREEK language
 * 
 * Οποιοσδήποτε μπορεί να χρησιμοποιήσει το πρόγραμμα για προσωπική του χρήση. 
 * Αλλά απαγoρεύεται η πώληση ή διακίνηση του προγράμματος σε τρίτους.
 * 
 * Aπαγορεύεται η αντιγραφή ή διακίνηση οποιοδήποτε μέρος του κώδικα χωρίς 
 * την άδεια του δημιουργού. 
 * Σε περίπτωση που θέλετε να χρεισημοποιήσετε κάποια κλάση ή μέρος του κώδικα.
 * Πρέπει να συμπεριλάβεται στο header της κλάσης τον δημιουργό και link στην
 * αυθεντική κλάση (στο github).
 * 
 * ~~ ﻿Information about BusinessProfit project - in GREEK language ~~
 *  
 * Το BusinessProfit είναι ένα project για την αποθήκευση και επεξεργασία
 * των εσόδων/εξόδων μίας επιχείρησης με σκοπό να μπορεί ο επιχειρηματίας να καθορήσει 
 * το καθαρό κέρδος της επιχείρησης. Καθώς και να κρατάει κάποια σημαντικά
 * στατιστικά στοιχεία για τον όγκο της εργασίας κτλ..
 *  
 * Το project δημιουργήθηκε από τον Σωτήρη Δούδη. Φοιτητή πληροφορικής του Α.Π.Θ
 * για προσωπική χρήση. Αλλά και για όποιον άλλον πιθανόν το χρειαστεί.
 * 
 * Το project προγραμματίστηκε σε Java (https://www.java.com/en/download/).
 * Με χρήση του NetBeans IDE (https://netbeans.org/)
 * Για να το τρέξετε πρέπει να έχετε εγκαταστήσει την java.
 *  
 * Ο καθένας μπορεί δωρεάν να χρησιμοποιήσει το project αυτό. Αλλά δεν επιτρέπεται
 * η αντιγραφή/διακήνηση του κώδικα, χωρίς την άδεια του Δημιουργού (Δείτε την License).
 * 
 * Github - https://github.com/RiflemanSD/BusinessProfit
 * 
 * 
 * Copyright © 2016 Sotiris Doudis | All rights reserved
 */
package org.riflemansd.businessprofit.panels;

import javax.swing.JOptionPane;


/** <h1>﻿PreviewRow</h1>
 * 
 * <p></p>
 * 
 * <p>Last Update: 30/01/2016</p>
 * <p>Author: <a href=https://github.com/RiflemanSD>RiflemanSD</a></p>
 * 
 * <p>Copyright © 2016 Sotiris Doudis | All rights reserved</p>
 * 
 * @version 1.0.7
 * @author RiflemanSD
 */
public class PreviewRow extends javax.swing.JFrame {

    /**
     * Creates new form PreviewRow
     */
    public PreviewRow() {
        initComponents();
    }
    public PreviewRow(String[] data) {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        id.setText(data[0]);
        date.setText(data[1]);
        category.setText(data[2]);
        inout.setText(data[3]);
        value.setText(data[4]);
        info.setText(data[5]);
        par.setText(data[6]);
        pal.setText(data[7]);
    }

    public String[] getDatas() {
        String[] datas = new String[8];
        
        datas[0] = id.getText();
        datas[1] = date.getText();
        datas[2] = category.getText();
        datas[3] = inout.getText();
        datas[4] = info.getText();
        datas[5] = value.getText();
        datas[6] = par.getText();
        datas[7] = pal.getText();
        
        return datas;
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
        id = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        category = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inout = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        value = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        info = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        par = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Ημερομηνία");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Κατηγορία");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Έσοδο/Έξοδο");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Ποσό (€)");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Αιτιολογία");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Παραλαβές");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Παραδόσεις");

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inout, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(value, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(par, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(par, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(pal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Η επεξεργασία των δεδομένων δεν είναι ακόμη διαθέσιμη!");
        this.dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PreviewRow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PreviewRow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PreviewRow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PreviewRow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PreviewRow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField category;
    private javax.swing.JTextField date;
    private javax.swing.JTextField id;
    private javax.swing.JTextField info;
    private javax.swing.JTextField inout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField pal;
    private javax.swing.JTextField par;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField value;
    // End of variables declaration//GEN-END:variables
}
