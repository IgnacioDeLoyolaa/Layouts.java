package P2_DianaHorizontal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Acerca extends JDialog implements ActionListener {
    private JButton b2;

    private JLabel l1,l2,l3,l4;

    public Acerca(Principal parent, boolean mode) {
        super(parent, mode);
        setLayout(null);
        setBounds(440, 70, 650, 500);

        b2 = new JButton("salir");
        b2.setBounds(115, 60, 200, 40);
        add(b2);

        l1 = new JLabel("Juan Navarro");
        l2 = new JLabel("JSlider: con esto hemos podido crear la barra deslizante y los niveles");
        l3 = new JLabel("JButton: este boton tiene como objetivo interactuar con el");
        l4 = new JLabel("JLabel: con esto hemos podido crear/añadir las etiquetas");


        l1.setBounds(100, 110, 400, 40);
        l2.setBounds(100, 160, 400, 40);
        l3.setBounds(100, 180, 400, 40);
        l4.setBounds(100, 200, 400, 40);

        add(l1);
        add(l2);
        add(l3);
        add(l4);

        b2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {
            setVisible(false);
        }
    }
}
