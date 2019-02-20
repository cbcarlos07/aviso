/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alerta;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author acer i7
 */
public class Alert {
    public void alerta() throws AWTException{
        
        
        if (!SystemTray.isSupported()) {
        System.out.println("SystemTray is not supported");
            return;
          }

          SystemTray tray = SystemTray.getSystemTray();
          Toolkit toolkit = Toolkit.getDefaultToolkit();
          Image image = toolkit.getImage("src/img/adventista.png");

          PopupMenu menu = new PopupMenu();

          MenuItem messageItem = new MenuItem("Show Message");
          messageItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              System.out.println("asdf");
            }
          });
          menu.add(messageItem);

          MenuItem closeItem = new MenuItem("Close");
          closeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              System.exit(0);
            }
          });
          menu.add(closeItem);
          TrayIcon icon = new TrayIcon(image, "Alerta para finalizar oração", menu);
          icon.setImageAutoSize(true);

          image = toolkit.getImage("src/img/adventista.png");
          icon.setImage(image);
          tray.add(icon);
          
          try {
            FileInputStream input = new FileInputStream("src/audio/audio.mp3"); 
            PausablePlayer player = new PausablePlayer(input);

            // start playing
            player.play();
           // player.stop();
            // after 5 secs, pause
            /*Thread.sleep(5000);
            System.out.println("Pause");
            player.pause();    
            */
            // after 5 secs, resume
            /*Thread.sleep(5000);
            System.out.println("Resume");
            player.resume();*/
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
