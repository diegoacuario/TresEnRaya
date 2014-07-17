

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Maticruzgudinhernad extends JFrame implements ActionListener {
Funciones f;
    //Etiquetas del JFrame 
    JLabel l1, l2, l3, l4, l5;

    // Cuadros de Textos 
    JTextField jugador1, jugador2;

    //Opciones de radio 
    JRadioButton computador, jugador;
    ButtonGroup opciones;

    //Boton empezar a jugar 
    JButton jugar;

    public Maticruzgudinhernad() {
        f= new Funciones();
        setSize(300, 300);
        setLocationRelativeTo(null);
        crearJugadores();
    }

    public void crearJugadores() {

        setTitle("Tres en Raya");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        // Creacion de las etiquetas de la pantalla y asignamos tamaño de la etiqueta 
        l1 = new JLabel(">Jugadores<");
        l1.setSize(100, 20);
        l2 = new JLabel("Jugador # 1:");
        l2.setSize(100, 20);
        l4 = new JLabel("Jugador # 2:");
        l4.setSize(100, 20);
//Fuentes a los controles JLabel 
        l1.setFont(new Font("Calibri", 1, 18));
        l1.setForeground(Color.blue);
        l2.setFont(new Font("Calibri", 1, 14));
        l4.setFont(new Font("Calibri", 1, 14));

        // Creacion de los Cuadros de texto para el ingreso de nombres 
        jugador1 = new JTextField("");
        jugador1.setSize(50, 20);
        jugador2 = new JTextField("");
        jugador2.setSize(50, 20);

        // Opciones, creacion de radio button 
        opciones = new ButtonGroup();
        computador = new JRadioButton("Computadora");
        computador.setSelected(true);
        computador.setSize(100, 20);
        jugador = new JRadioButton("Jugador");
        jugador.setSize(100, 20);
        opciones.add(computador);
        opciones.add(jugador);

        // Boton para jugar 
        jugar = new JButton("Jugar");
        jugar.setSize(50, 20);

        // Añadimos el listener al boton 
        jugar.addActionListener(this);

        // Añadimos los controles al JFrame 
        add(l1);
        add(new Label());
        add(l2);
        add(jugador1);
        add(l4);
        add(new Label());
        add(computador);
        add(new Label());
        add(jugador);
        add(jugador2);
        add(jugar);
        setVisible(true);
    }

    // Metodos para manejar Eventos// 

    public void actionPerformed(ActionEvent e) {

        //Validar que se haya ingresado el nick al jugador 1 
        if (jugador1.getText().trim().equals("")) {
            f.visualizaDialogo(this, "Ingresa el nombre del jugador 1", "Indica el nombre", 2000, 1);
        } else {

            //Validar que el segundo jugador haya ingresado nombre si se selecciono jugar contra otro jugador 
            if (jugador.isSelected() && jugador2.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "InGrEsE El NiCk al JuGaDOr 2");
                f.visualizaDialogo(this, "Ingresa el nombre del jugador 2", "Indica el nombre", 2000, 1);
            } else {

                //Sortear quien juega primero aleatoriamente 
                int empieza = (int) (Math.random() * 2 + 1);
                String jug1, jug2;

 //Cojemos el nombre del jugador que va a empezar 
                //Si es uno escojemos el nombre que ingreso el primer jugador 
                if (empieza == 1) {
                    jug1 = jugador1.getText();
                    if (jugador.isSelected() && !jugador2.getText().trim().equals("")) {
                        jug2 = jugador2.getText();
                    } else {
                        jug2 = "Computadora";
                    }

                } else {
                    //Si es 2 se verifica si se juga contra otro jugador o contra la computadora 
                    if (jugador.isSelected() && !jugador2.getText().trim().equals("")) {
                        jug1 = jugador2.getText();
                    } else {
                        jug1 = "Computadora";
                    }
                    jug2 = jugador1.getText();
                }
                f.visualizaDialogo(this, "Empieza el jugador"+jug1, "Indica que jugador empieza", 2000, 1);
                setVisible(false);
                dispose();
                new Raya(jug1, jug2);
            }
        }
    }

   
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        }
        new Maticruzgudinhernad();
    }
}
