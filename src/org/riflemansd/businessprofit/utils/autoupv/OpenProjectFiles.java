/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.riflemansd.businessprofit.utils.autoupv;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RiflemanSD
 */
public class OpenProjectFiles {

    public static void main(String[] args) {
        
        try {
            Desktop.getDesktop().open((new File("src")).getAbsoluteFile().getParentFile());
        } catch (IOException ex) {
            Logger.getLogger(OpenProjectFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("End...");
    }
}
