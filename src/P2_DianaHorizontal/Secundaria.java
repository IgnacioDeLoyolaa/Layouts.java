package P2_DianaHorizontal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Secundaria extends JDialog implements ActionListener {

    private JButton volver;

    public Secundaria(Principal parent, boolean modal, JLabel l1) {
        super(parent, modal);

        //layouts
        setLayout(null);
        setBounds(440, 10, 410, 210);

        //Boton
        volver = new JButton("Cerrar y volver");
        volver.setBounds(115, 60, 200, 40);
        add(volver);

        l1.setBounds(100, 110, 400, 40);
        add(l1);

        volver.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == volver) {
            setVisible(false);
            // Principal p = new Principal();
        }

    }
}
