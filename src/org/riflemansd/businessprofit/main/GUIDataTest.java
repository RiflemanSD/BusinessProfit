/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.riflemansd.businessprofit.main;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import org.riflemansd.businessprofit.panels.PreviewRow;
import org.riflemansd.jxsortabletable.JXSortableTable;

/**
 *
 * @author sotir
 */
public class GUIDataTest extends javax.swing.JFrame {
    private JXSortableTable table;
    private SearchPanel sPanel;
    private ResaultPanel resaultPanel;
    private int currSelectedRow;
    /**
     * Creates new form GUIDataTest
     */
    public GUIDataTest() {
        currSelectedRow = -1;
        
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        table = new JXSortableTable("ID,Ημερομηνία,Κατηγορία,Έσοδο/Έξοδο,Ποσό(€),Αιτιολογία,Παραδόσεις,Παραλαβές", 0, new Date(),"string","string",1.5,"s",1,1);
        
        //table.setRowSelectionAllowed(true);
        //table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int r = table.rowAtPoint(e.getPoint());
                if (r >= 0 && r < table.getRowCount()) {
                    table.setRowSelectionInterval(r, r);
                } else {
                    table.clearSelection();
                }

                currSelectedRow = table.getSelectedRow();
                if (currSelectedRow < 0)
                    return;
                if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
                    JPopupMenu popup = new JPopupMenu();
                    
                    JMenuItem previewItem = new JMenuItem("Preview");
                    previewItem.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Object[] row = table.getRowAt(currSelectedRow);
                            String[] datas = rowToString(row);
                            
                            PreviewRow pr = new PreviewRow(datas);
                            
                            pr.setLocationRelativeTo(null);
                            pr.setVisible(true);
                        }
                    });
                    popup.add(previewItem);
                    
                    JMenuItem deleteItem = new JMenuItem("Delete");
                    deleteItem.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int a = JOptionPane.showConfirmDialog(rootPane, "Πρόκειται να διαγραφοόυν όλα τα δεδομένα της γραμμής\nΕίστε σίγουρος ότι θέλετε να διαγραφούν?", "Διαγραφή Δεδομένων",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                            if (a == 0) {
                                Object[] row = table.getRowAt(currSelectedRow);
                                
                                int tid = -1;
                                int id = Integer.parseInt((String)row[0]);
                                String cat = (String) row[2];
                                String inout = (String) row[3];
                                
                                if (cat.equals("Δέματα") && inout.equals("Έσοδο")) {
                                    tid = 3;
                                }
                                else if (inout.equals("Έσοδο")) {
                                    tid = 2;
                                }
                                else if (inout.equals("Έξοδο")) {
                                    tid = 1;
                                }
                                
                                BusinessProfit.database.delete(tid, id);
                                
                                defineData();
                                JOptionPane.showMessageDialog(rootPane, "Τα δεδομένα της γραμμής διαγράφτηκαν", "Επιτυχία", JOptionPane.INFORMATION_MESSAGE);
            
                            }
                        }
                    });
                    popup.add(deleteItem);
                    
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        
        table.getColumn(0).sizeWidthToFit();
        table.getColumn(3).sizeWidthToFit();
        table.getColumn(4).sizeWidthToFit();
        table.getColumn(6).sizeWidthToFit();
        table.getColumn(7).sizeWidthToFit();
        
        tablePanel.setLayout(new BorderLayout());
        JScrollPane sc = new JScrollPane(table);
        tablePanel.add(sc, BorderLayout.CENTER);
        
        searchPanel.setLayout(new BorderLayout());
        sPanel = new SearchPanel(this);
        searchPanel.add(sPanel, BorderLayout.CENTER);
        
        rPanel.setLayout(new BorderLayout());
        resaultPanel = new ResaultPanel();
        rPanel.add(resaultPanel, BorderLayout.CENTER);
        
        defineData();
        
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    }

    public String[] rowToString(Object[] objects) {
        String[] datas = new String[8];
        
        datas[0] = (String)objects[0];
        datas[1] = BusinessProfit.database.dateToString((Date)objects[1]);
        datas[2] = (String)objects[2];
        datas[3] = (String)objects[3];
        datas[4] = "" + objects[4];
        datas[5] = (String)objects[5];
        datas[6] = "" + objects[6];
        datas[7] = "" + objects[7];
        
        return datas;
    }
    public Object[] stringToRow(String[] objects) {
        Object[] datas = new Object[8];
        
        datas[0] = Integer.parseInt(objects[0]);
        datas[1] = BusinessProfit.database.getDate(objects[1]);
        datas[2] = objects[2];
        datas[3] = objects[3];
        datas[4] = Double.parseDouble(objects[4]);
        datas[5] = objects[5];
        datas[6] = Integer.parseInt(objects[6]);
        datas[7] = Integer.parseInt(objects[7]);
        
        return datas;
    }
    
    public void defineData() {
        double inValue = 0;
        double outValue = 0;
        
        table.deleteAllRows();
        
        String[] in = BusinessProfit.database.getIn().split("\n");
        String[] out = BusinessProfit.database.getOut().split("\n");
        String[] packIn = BusinessProfit.database.getPackIn().split("\n");
        
        for (String i : in) {
            Object[] data = this.inToTableRow(i);
            if (data != null) {
                table.addRow(data);
                inValue += (double)data[4];
            }
        }
        for (String p : packIn) {
            Object[] data = this.packInToTableRow(p);
            if (data != null) {
                table.addRow(data);
                inValue += (double)data[4];
            }
        }
        for (String o : out) {
            Object[] data = this.outToTableRow(o);
            if (data != null) {
                table.addRow(data);
                outValue += (double)data[4];
            }
        }
        
        resaultPanel.updateProfit(inValue, outValue);
    }
    
    private Object[] inToTableRow(String in) {
        //"ID,Ημερομηνία,Κατηγορία,Έσοδο/Έξοδο,Ποσό(€),Αιτιολογία,Παραδόσεις,Παραλαβές"
        
        String cat = sPanel.getCategory();
        int index = sPanel.getInOut();
        
        String[] ind = in.split(",");
        Object[] objects = new Object[6];
        
        objects[2] = BusinessProfit.database.getCategory(Integer.parseInt(ind[1])).getName();
        if (!cat.equals("Όλες")) if (!cat.equals((String)objects[2])) return null;
        if (index != 0) if (index == 2)  return null;
        
        objects[1] = BusinessProfit.database.getDate(ind[4]);
        if (!checkDate((Date)objects[1])) return null;
        
        objects[0] = ind[0];
        objects[3] = "Έσοδο";
        objects[4] = Double.parseDouble(ind[2]);
        objects[5] = ind[3];
        
        return objects;
    }
    private Object[] outToTableRow(String out) {
        //"ID,Ημερομηνία,Κατηγορία,Έσοδο/Έξοδο,Ποσό(€),Αιτιολογία,Παραδόσεις,Παραλαβές"
        String cat = sPanel.getCategory();
        int index = sPanel.getInOut();
        
        String[] ind = out.split(",");
        Object[] objects = new Object[6];
        
        objects[2] = BusinessProfit.database.getCategory(Integer.parseInt(ind[1])).getName();
        if (!cat.equals("Όλες")) if (!cat.equals((String)objects[2])) return null;
        if (index != 0) if (index == 1)  return null;
        
        objects[1] = BusinessProfit.database.getDate(ind[4]);
        if (!checkDate((Date)objects[1])) return null;
        
        objects[0] = ind[0];
        objects[3] = "Έξοδο";
        objects[4] = Double.parseDouble(ind[2]);
        objects[5] = ind[3];
        
        return objects;
        
    }
    private Object[] packInToTableRow(String packIn) {
        //"ID,Ημερομηνία,Κατηγορία,Έσοδο/Έξοδο,Ποσό(€),Αιτιολογία,Παραδόσεις,Παραλαβές"
        String cat = sPanel.getCategory();
        int index = sPanel.getInOut();
        
        String[] ind = packIn.split(",");
        Object[] objects = new Object[8];
        
        objects[2] = BusinessProfit.database.getCategory(Integer.parseInt(ind[1])).getName();
        if (!cat.equals("Όλες")) if (!cat.equals((String)objects[2])) return null;
        if (index != 0) if (index == 2)  return null;
        
        objects[1] = BusinessProfit.database.getDate(ind[6]);
        
        if (!checkDate((Date)objects[1])) return null;
        
        objects[0] = ind[0];
        objects[3] = "Έσοδο";
        objects[4] = Double.parseDouble(ind[2]);
        objects[5] = ind[3];
        objects[6] = Integer.parseInt(ind[4]);
        objects[7] = Integer.parseInt(ind[5]);
        
        return objects;
        
    }
    
    private boolean checkDate(Date date) {
        Date[] dates = sPanel.getDates();
        
        if (this.sPanel.isDateSearch()) {
            if (dates[0].compareTo(dates[1]) == 0) {
                if (dates[0].compareTo(date) != 0) return false;
            }
            else {
               if (dates[0].compareTo(date) != 0 && dates[1].compareTo(date) != 0) {
                if (!((date).after(dates[0]) && (date).before(dates[1]))) return false;
               } 
            }
        }
        
        return true;
    }
    
    /**
     * 
     * @param o1 - 27-1-2016
     * @param o2 - 28-1-2016
     * @return o2 &gt; o1 = -1, o2 &lt; o1 = 1, o2 == o1 = 0
     */
    private int compare(Date o1, Date o2) {
        long n1 = o1.getTime();
        long n2 = o2.getTime();
        if (n1 < n2) {
            return -1;
        } else if (n1 > n2) {
            return 1;
        } else {
            return 0;
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

        tablePanel = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        rPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 0));

        tablePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 99, Short.MAX_VALUE)
        );

        getContentPane().add(tablePanel, java.awt.BorderLayout.CENTER);

        searchPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 74, Short.MAX_VALUE)
        );

        getContentPane().add(searchPanel, java.awt.BorderLayout.PAGE_START);

        rPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout rPanelLayout = new javax.swing.GroupLayout(rPanel);
        rPanel.setLayout(rPanelLayout);
        rPanelLayout.setHorizontalGroup(
            rPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        rPanelLayout.setVerticalGroup(
            rPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(rPanel, java.awt.BorderLayout.PAGE_END);

        jMenu1.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("jMenuItem3");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GUIDataTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIDataTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIDataTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIDataTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIDataTest test = new GUIDataTest();
                test.setVisible(true);
                
                test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel rPanel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel tablePanel;
    // End of variables declaration//GEN-END:variables
}
