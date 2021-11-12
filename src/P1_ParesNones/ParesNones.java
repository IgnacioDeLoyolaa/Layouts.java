package P1_ParesNones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParesNones extends JFrame implements ActionListener {

    JButton boton1, boton2, boton3, boton4, boton5;
    JLabel label1, label2, label3;
    int numero, maquina;

    public ParesNones() {

        setLayout(null);
        //Creacion de JLabel
        label1 = new JLabel("Selecciona un numero");
        label1.setBounds(60, 50, 200, 30);
        add(label1);
        label2 = new JLabel("Jugador1 --> Pares");
        label2.setBounds(0, 10, 200, 20);
        add(label2);
        label3 = new JLabel("Maquina --> Impares");
        label3.setBounds(160, 10, 200, 20);
        add(label3);

        //Creacion de JButton
        boton1 = new JButton("1");
        boton2 = new JButton("2");
        boton3 = new JButton("3");
        boton4 = new JButton("4");
        boton5 = new JButton("5");


        boton1.setBounds(50, 100, 50, 50);
        boton2.setBounds(130, 100, 50, 50);
        boton3.setBounds(50, 180, 50, 50);
        boton4.setBounds(130, 180, 50, 50);
        boton5.setBounds(90, 260, 50, 50);


        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5);

        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
        boton4.addActionListener(this);
        boton5.addActionListener(this);

        //Ponemos caracteristicas de el JFrame
        setTitle("Pares o Nones");
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        etiquetas(label1);
        etiquetas(label2);
        etiquetas(label3);

        colores(boton1);
        colores(boton2);
        colores(boton3);
        colores(boton4);
        colores(boton5);

    }
    //Asignamos un valor a cada boton. Hacemos tambien un numero aleatorio que propone la maquina
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boton1 || e.getSource() == boton2 || e.getSource() == boton3 || e.getSource() == boton4 || e.getSource() == boton5) {
            if (e.getSource() == boton1) {
                numero = 1;
            }
            if (e.getSource() == boton2) {
                numero = 2;
            }
            if (e.getSource() == boton3) {
                numero = 3;
            }
            if (e.getSource() == boton4) {
                numero = 4;
            }
            if (e.getSource() == boton5) {
                numero = 5;
            }
            maquina = (int) (Math.random() * 5 + 1);
            Secparesnones resultado = new Secparesnones(this, true, numero, maquina);
            resultado.setVisible(true);
        }

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
        etiqueta.setFont(new Font("MONOSPACE", Font.PLAIN, 16));
    }

    public static void main(String[] args) {
        ParesNones pn = new ParesNones();
        pn.setBounds(10, 10, 320, 400);
        pn.setVisible(true);
        }

    }
