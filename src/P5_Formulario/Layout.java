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
    private void initTarjeta2() {
        tarjeta2.setLayout(null);

        lnombre = new JLabel("Nombre");
        lnombre.setBounds(120, 20, 80, 30);
        tarjeta2.add(lnombre);
        tnombre = new JTextField();
        tnombre.setBounds(120, 50, 150, 30);
        tarjeta2.add(tnombre);

        lcontrasena = new JLabel("Contrasena");
        lcontrasena.setBounds(120, 80, 80, 30);
        tarjeta2.add(lcontrasena);
        pcontra = new JPasswordField();
        pcontra.setBounds(120, 110, 150, 30);
        tarjeta2.add(pcontra);

        lemail = new JLabel("Email");
        lemail.setBounds(120, 140, 80, 30);
        tarjeta2.add(lemail);
        temail = new JTextField();
        temail.setBounds(120, 170, 150, 30);
        tarjeta2.add(temail);

    }
    private void initTarjeta3() {
        tarjeta3.setLayout(null);

        lpais = new JLabel("Pais");
        lpais.setBounds(120, 40, 80, 30);
        tarjeta3.add(lpais);
        pais = new JComboBox();
        pais.setBounds(120, 80, 150, 20);
        tarjeta3.add(pais);

        lprovincia = new JLabel("Provincia/Estado");
        lprovincia.setBounds(120, 120, 125, 30);
        tarjeta3.add(lprovincia);
        provincia = new JComboBox();
        provincia.setBounds(120, 160, 150, 20);
        tarjeta3.add(provincia);

        pais.addItem("");
        pais.addItem("EspaÃ±a");
        pais.addItem("EEUU");

        pais.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                provincia.removeAllItems();
                if (pais.getSelectedItem().equals("EspaÃ±a")) {
                    leerEspana();
                } else if (pais.getSelectedItem().equals("EEUU")) ;
                {
                    leerEstados();
                }
            }
        });
        private void leerEspana() {
            File fichprovincia = new File(".\\src\\P5_Layouts\\Provincia.txt");
            try {
                BufferedReader leer_provincia = new BufferedReader(new FileReader(fichprovincia));

                while ((linea = leer_provincia.readLine()) != null) {
                    provincia.addItem(linea);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        private void leerEstados() {
            File fichestado = new File(".\\src\\P5_Layouts\\Estados.txt");

            try {
                BufferedReader leer_estado = new BufferedReader(new FileReader(fichestado));

                while ((linea = leer_estado.readLine()) != null) {
                    provincia.addItem(linea);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            private void initTarjeta4() {
                tarjeta4.setLayout(null);

                texto2 = new JEditorPane();
                texto2.setBounds(25, 10, 340, 230);
                texto2.setContentType("text/html"); // Marcamos el editor para que use HTML
                tarjeta4.add(texto2);

                finalizar = new JButton("Finalizar");
                finalizar.setBounds(25, 250, 100, 35);
                tarjeta4.add(finalizar);

                datos = new JCheckBox("Desea poner los datos en un fichero");
                datos.setBounds(150, 250, 300, 35);
                tarjeta4.add(datos);

                datos.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        if (datos.isSelected()) {
                            JFileChooser file = new JFileChooser();
                            file.showSaveDialog(Layouts.this);
                            File guarda = file.getSelectedFile();
                            if (guarda != null) {
                                FileWriter save = null;
                                try {
                                    save = new FileWriter(guarda + ".txt");
                                    save.write(texto2.getText());
                                    save.close();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    }
                });

                private void initTarjeta5() {
                    tarjeta5.setLayout(null);

                    lulti = new JLabel("Registro Completado");
                    lulti.setFont(new Font("MONOSPACED", PLAIN, 16));
                    lulti.setBounds(150, 10, 200, 30);
                    tarjeta5.add(lulti);

                    editor = new JButton();
                    editor.setBackground(getContentPane().getBackground());
                    editor.setBounds(150, 75, 120, 200);
                    editor.setContentAreaFilled(false);
                    ImageIcon iconos = new ImageIcon("C:\\Documents\\DAM\\Desarrollo de Interfaces\\Desarrollo Interfaces\\DInterfacesejes\\src\\P5_Layouts\\pulgararriba.png");
                    Image iconoEscalado = iconos.getImage().getScaledInstance(editor.getWidth(), editor.getHeight(), Image.SCALE_SMOOTH);
                    Icon ico2 = new ImageIcon(iconoEscalado);

                    editor.setIcon(ico2);
                    tarjeta5.add(editor);

                }
                private void initBotones() {

                    salir.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });

                    siguiente.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            contador++;
                            tarjetas.next(panelTarjetas);
                            if (contador == 3) {
                                initComprobar();
                            }
                            if (contador == 4) {
                                texto2.setText(
                                        "<p> Nombre: " + tnombre.getText() + "</p>" +
                                                "<p> ContraseÃ±a: " + pcontra.getText() + "</p>" +
                                                "<p> Email: " + temail.getText() + "</p>" +
                                                "<p> Pais: " + pais.getSelectedItem() + "</p>" +
                                                "<p> Provincia: " + provincia.getSelectedItem() + "</p>");

                            }
                            if (contador == 6) {
                                URL url = getClass().getResource("pulgararriba.png");
                                editor.setText("<img src=" + url + " width=250 height=250></img>");
                            }
                        }
                    });
                    anterior.addActionListener((new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tarjetas.previous(panelTarjetas);
                            contador--;
                        }
                    }));
                    finalizar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });

                    private void initPantalla2() {

                        setSize(500, 400);
                        setTitle("Practica Layouts");
                        setDefaultCloseOperation(EXIT_ON_CLOSE);
                        setVisible(true);
                        setResizable(false);

                    }

                    public static void main(String[] args) {
                        new Layouts();
                    }
}