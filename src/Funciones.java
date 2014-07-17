
import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class Funciones {
     public void visualizaDialogo(Component padre, String texto, String titulo, int tiempoVisible, int tipo) {
        JOptionPane option = new JOptionPane(texto, tipo);
        JDialog dialogo = option.createDialog(padre, titulo);
        Thread hilo = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(tiempoVisible);
                    if (dialogo.isVisible()) {
                        dialogo.setVisible(false);
                    }
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        };
        hilo.start();
        dialogo.setVisible(true);
                
    }
}
