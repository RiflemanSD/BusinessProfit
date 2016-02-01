/* ~~ ﻿The JLabelLink is part of BusinessProfit. ~~
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

/**
 * Example of a jLabel Hyperlink and a jLabel Mailto
 */
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/** <h1>﻿JLabelLink</h1>
 * 
 * <p></p>
 * 
 * <p>Last Update: 26/01/2016</p>
 * <p>Author: <a href=https://github.com/RiflemanSD>RiflemanSD</a></p>
 * 
 * <p>Copyright © 2016 Sotiris Doudis | All rights reserved</p>
 * 
 * @version 1.0.7
 * @author RiflemanSD
 */
public class JLabelLink extends JLabel implements MouseListener {
    private String link;
    
    public JLabelLink() {
        //super("<html><a href=\"\">" + "http://www.google.com/" + "</a></html>");
        this.link = "https://github.com/RiflemanSD";
        this.setText(link);
        
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setForeground(java.awt.Color.blue);
        Font font = new Font("Tahoma", Font.PLAIN, 10);
        Map attributes = font.getAttributes();
        
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        this.setFont(font.deriveFont(attributes));
        
        this.addMouseListener(this);
    }
    
    public JLabelLink(String link) {
        //super("<html><a href=\"\">" + link + "</a></html>");
        super(link);
        this.link = link;
        
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setForeground(java.awt.Color.blue);
        Font font = this.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        this.setFont(font.deriveFont(attributes));
        
        this.addMouseListener(this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        
        frame.setTitle("jLabelLinkExample");
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        JPanel pan = new JPanel();
        frame.setContentPane(pan);
        
        pan.add(new JLabelLink("https://github.com/RiflemanSD"));
        
        frame.setVisible(true);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Desktop.getDesktop().browse(new URI(link));
        } catch (URISyntaxException | IOException ex) {
            //It looks like there's a problem
            System.err.println(ex);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setForeground(java.awt.Color.red);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setForeground(new java.awt.Color(128,0,128));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
