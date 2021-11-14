package P5_Formulario;

import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame {
    CardLayout tarjetas;
    JPanel panelTarjetas;
    JButton siguiente, anterior, salir, finalizar, editor;
    JLabel lnombre, lemail, lcontrasena, lpais, lprovincia, lulti;
    JTextField tnombre, temail;
    JTextArea textoarea;
    JComboBox pais, provincia;
    JCheckBox datos;
    JPasswordField pcontra;
    JPanel barratexto, tarjeta1, tarjeta2, tarjeta3, tarjeta4, tarjeta5;
    int contador = 1;
    JEditorPane texto2;
    Graphics2D g2d;
    String linea = "";
    //Patron para comprobar email y contraseÃ±a
    String password = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$";
    String correo = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";


    public Layout() {
        initPantalla();
        initTarjetas();
        initBotones();
        initPantalla2();
    }
    public void paint(Graphics g) {
        super.paint(g);
        g2d = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(900, 100, Color.BLUE, 770, 900, Color.RED);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, 90, 350);

    }

    private void initTarjeta1() {
        tarjeta1.setLayout(null);
        textoarea = new JTextArea("Bienvenido estos son los pasos del formulario \n " +
                "1.Debes rellenar los campos de nombre,email y contraseÃ±a \n " +
                "2.Debes seleccionar el campo de pais y provincia \n " +
                "3.Te aÃ±ade todos los datos en un fichero");
        textoarea.setBounds(30, 10, 350, 250);
        textoarea.setLineWrap(true);
        textoarea.setEditable(false);
        textoarea.setBackground(getContentPane().getBackground());
        barratexto.add(textoarea);
        tarjeta1.add(barratexto);
        tarjeta1.add(textoarea);

    }

    //
}