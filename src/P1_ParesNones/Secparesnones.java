package P1_ParesNones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Secparesnones extends JFrame implements ActionListener {

    JButton boton;
    JLabel eleccion, eMaquina, ganador;
    int resultado;
    String mensaje;

    public Secparesnones(ParesNones parent, boolean modal, int numero, int maquina){

        //Caracteristicas del Jframe, Jbutton y JLabel
        setLayout(null);
        setBounds(500,10,400,400);

        boton = new JButton("Cerrar y volver");
        boton.setBounds(90,300,200,40);
        add(boton);

        boton.addActionListener(this);

        eleccion = new JLabel("Tu numero es: " + numero);
        eMaquina = new JLabel("Maquina elige: " + maquina);
        eleccion.setBounds(20,20,100,40);
        eMaquina.setBounds(180,20,100,40);
        add(eleccion);
        add(eMaquina);

        resultado = (numero + maquina) %2;
        if(resultado==0){
            mensaje = "Enhorabuena!! Has ganado";
        }
        else
            mensaje = "Has perdido. Prueba de nuevo!!";


        ganador = new JLabel(mensaje);
        ganador.setBounds(100,50,200,200);
        add(ganador);
        ganador.setForeground(Color.RED);

        colores(boton);
        etiquetas(eleccion);
        etiquetas(eMaquina);


        setTitle("Pares o Nones");
        getContentPane().setBackground(Color.BLACK);


    }
    //Creación de métodos para los JButton y JLabel. Con ellos ahorramos código seleccionando color y fuente.

    public void colores(JButton botones){
        botones.setBackground(Color.WHITE);
        botones.setForeground(Color.BLACK);
        botones.setFont(new Font("MONOSPACE", Font.PLAIN, 22));

    }

    public void etiquetas(JLabel etiqueta){
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setBackground(Color.WHITE);

    }
    //Si se pulsa el boton desaparece la página y nos permite volver a usar la anterior
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton){
            setVisible(false);
        }

    }
}