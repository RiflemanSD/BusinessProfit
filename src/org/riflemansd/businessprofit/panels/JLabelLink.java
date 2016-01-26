package org.riflemansd.businessprofit.panels;

/**
 * Example of a jLabel Hyperlink and a jLabel Mailto
 */

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import javafx.scene.paint.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
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