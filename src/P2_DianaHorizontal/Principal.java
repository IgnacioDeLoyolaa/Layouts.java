package P2_DianaHorizontal;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.SystemColor.info;

public class Principal extends JFrame implements ActionListener, ChangeListener {

    JSlider j1, j2;
    JLabel l1;
    JButton b1;

    public Principal() {
        inicioBotones();
        inicioDeslizador();
        inicioPantalla();

        l1 = new JLabel("");
        l1.setBounds(50, 540, 700, 40);
    }

    private void inicioBotones() {
        b1 = new JButton("Acerca De");
        b1.setBounds(70, 80, 120, 60);
        b1.addActionListener(this);
        add(b1);


    }

    private void inicioDeslizador() {
        //JSlider barra deslizadora
        j1 = new JSlider(0, 100, 50);
        j1.setBounds(200, 140, 250, 40);
        j1.setMajorTickSpacing(100);
        j1.setPaintTicks(false);
        j1.setPaintLabels(true);
        add(j1);

        j1.addChangeListener(this);

        //JSlider para niveles
        j2 = new JSlider(1, 3, 2);
        j2.setBounds(68, 200, 125, 40);
        j2.setMajorTickSpacing(1);
        j2.setPaintLabels(true);
        j2.setPaintTicks(true);
        add(j2);

        j2.addChangeListener(this);

    }

    private void inicioPantalla() {
        setSize(1240, 385);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void ventana2(JLabel texto) {
        // aparece la ventana secundaria
        Secundaria se = new Secundaria(this, true, texto);
        se.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b1){
            Acerca acerca = new Acerca(this,true);
            acerca.setVisible(true);

        }
    }
    //public void reiniciar(){
    //    j1.setValue(0);
    //}

    @Override
    public void stateChanged(ChangeEvent e) {

        if (e.getSource() == j1) {
            int numero = j1.getValue();
            String text = Integer.toString(numero);

            if (numero != 0) {

                if (numero == 50) {
                    l1.setText(text + "¡Enhorabuena, acertaste!");
                    l1.setForeground(Color.red);
                    ventana2(l1);
                } else if (numero >= 40 && numero <= 60) {
                    l1.setText(text + "Has estado cerca, prueba otra vez");
                    l1.setForeground(Color.ORANGE);
                    ventana2(l1);
                } else {
                    l1.setText(text);
                    l1.setForeground(Color.GREEN);
                    ventana2(l1);
                }

            }
        }

        if(e.getSource()== j2){
            int niveles = j2.getValue();

            if(niveles == 1){
                j1.setBounds(200,140,100,40);
            }
            if(niveles == 2){
                j1.setBounds(200,140,200,40);
            }
            if(niveles == 3){
                j1.setBounds(200,140,300,40);
            }
        }

    }

    public static void main (String[]args){
        Principal principal = new Principal();
        principal.setBounds(0, 0, 700, 300);
        principal.setVisible(true);
    }
}
