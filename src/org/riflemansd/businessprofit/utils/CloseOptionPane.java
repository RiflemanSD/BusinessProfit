package org.riflemansd.businessprofit.utils;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CloseOptionPane {

   @SuppressWarnings("serial")
   private static void createAndShowGui() {
      final JLabel label = new JLabel();
      int timerDelay = 1000;
      
      label.setText("Closing in " + 5 + " seconds");
      
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            
            JOptionPane.showMessageDialog(null, label);
         }
      });
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            JOptionPane.showOptionDialog(null, "hello", "hello", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, new JButton[]{(new JButton("ok"))},null);
         }
      });
      
      
      new Timer(timerDelay , new ActionListener() {
         int timeLeft = 5;

         @Override
         public void actionPerformed(ActionEvent e) {
            if (timeLeft > 0) {
               timeLeft--;
                System.out.println("Closing in " + timeLeft + " seconds");
            } else {
               ((Timer)e.getSource()).stop();
               Window win = SwingUtilities.getWindowAncestor(label);
               win.dispose();
            }
         }
      }){{setInitialDelay(0);}}.start();
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}