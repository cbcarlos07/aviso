/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alerta;

import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer i7
 */
public class Alerta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alert alerta = new Alert();
        try {
            alerta.alerta();
        } catch (AWTException ex) {
            Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
