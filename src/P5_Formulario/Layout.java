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

    }
}