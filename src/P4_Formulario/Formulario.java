package P4_Formulario;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Formulario extends JFrame implements ChangeListener, ActionListener {

    private JLabel lnombre, lapellidos, ldireccion, ltelefono, lDNI, lcodigopostal, lemail, lcontraseña, lpoblacion, lprovypais, lsexo, lidiomas, lcarta;
    private JTextField nombre, apellidos, direccion, telefono, DNI, codigopostal, email, poblacion,OtrosId;
    private JPasswordField contra;
    private JComboBox pais, provincia;
    private JRadioButton hombre, mujer, otros;
    private ButtonGroup gruposexo;
    private JCheckBox Español, Ingles, Frances, Aleman, Italiano, Otros;
    private JButton generardatos;
    private JTextArea cartapres;
    private JEditorPane texto2;
    private JScrollPane scrollpanel1, scrollpanel2;
    private JMenuBar menuBar;
    private JMenu Formato, Acciones, Colores, Tamaño;
    private JMenuItem color1, color2, color3, color4, color5, tamaño1, tamaño2, tamaño3, tamaño4, tamaño5, Limpiar, Salir;
    String generaIdioma = "";
    String CambiarColores = "";
    String CambiarTamano = "";
    String tamano ="";

    public Formulario(){
        setLayout(null);

        /* Creamos el JMenuBar y lo asociamos con el JFrame */
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        /* Creamos el  JMenu y lo pasamos como parámetro al JMenuBar mediante el método add */
        Formato = new JMenu("Formato");
        menuBar.add(Formato);
        Acciones = new JMenu("Acciones");
        menuBar.add(Acciones);

        Colores = new JMenu("Color");
        Formato.add(Colores);
        Tamaño = new JMenu("Tamaño");
        Formato.add(Tamaño);

        Limpiar = new JMenuItem("Limpiar");
        Acciones.add(Limpiar);
        Limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Limpiar) {
                    nombre.setText("");
                    apellidos.setText("");
                    direccion.setText("");
                    telefono.setText("");
                    DNI.setText("");
                    codigopostal.setText("");
                    email.setText("");
                    contra.setText("");
                    poblacion.setText("");
                    pais.setSelectedIndex(0);
                    gruposexo.clearSelection();
                    Español.setSelected(false);
                    Ingles.setSelected(false);
                    Aleman.setSelected(false);
                    Frances.setSelected(false);
                    Italiano.setSelected(false);
                    Otros.setSelected(false);
                    OtrosId.setText("");
                    cartapres.setText("");
                }
            }
        });
        Salir = new JMenuItem("Salir");
        Acciones.add(Salir);
        Salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Añadimos los item al menu Formato
        color1 = new JMenuItem("Rojo");
        Colores.add(color1);
        color2 = new JMenuItem("Verde");
        Colores.add(color2);
        color3 = new JMenuItem("Azul");
        Colores.add(color3);
        color4 = new JMenuItem("Naranja");
        Colores.add(color4);
        color5 = new JMenuItem("Negro");
        Colores.add(color5);

        tamaño1 = new JMenuItem("Tamaño 1");
        Tamaño.add(tamaño1);
        tamaño2 = new JMenuItem("Tamaño 2");
        Tamaño.add(tamaño2);
        tamaño3 = new JMenuItem("Tamaño 3");
        Tamaño.add(tamaño3);
        tamaño4 = new JMenuItem("Tamaño 4");
        Tamaño.add(tamaño4);
        tamaño5 = new JMenuItem("Tamaño 5");
        Tamaño.add(tamaño5);

        lnombre = new JLabel("Nombre");
        lnombre.setBounds(10, 10, 200, 20);
        add(lnombre);
        nombre = new JTextField();
        nombre.setBounds(10, 30, 200, 20);
        add(nombre);

        lapellidos = new JLabel("Apellidos");
        lapellidos.setBounds(10, 50, 200, 20);
        add(lapellidos);
        apellidos = new JTextField();
        apellidos.setBounds(10, 70, 200, 20);
        add(apellidos);

        ldireccion = new JLabel("Direccion");
        ldireccion.setBounds(10, 90, 200, 20);
        add(ldireccion);
        direccion = new JTextField();
        direccion.setBounds(10, 110, 200, 20);
        add(direccion);

        ltelefono = new JLabel("Telefono");
        ltelefono.setBounds(10, 130, 200, 20);
        add(ltelefono);
        telefono = new JTextField();
        telefono.setBounds(10, 150, 200, 20);
        add(telefono);

        lDNI = new JLabel("DNI");
        lDNI.setBounds(10, 170, 200, 20);
        add(lDNI);
        DNI = new JTextField();
        DNI.setBounds(10, 190, 200, 20);
        add(DNI);

        lcodigopostal = new JLabel("Codigo Postal");
        lcodigopostal.setBounds(10, 210, 200, 20);
        add(lcodigopostal);
        codigopostal = new JTextField();
        codigopostal.setBounds(10, 230, 200, 20);
        add(codigopostal);

        lemail = new JLabel("Email");
        lemail.setBounds(10, 250, 200, 20);
        add(lemail);
        email = new JTextField();
        email.setBounds(10, 270, 200, 20);
        add(email);

        lcontraseña = new JLabel("Contraseña");
        lcontraseña.setBounds(10, 290, 200, 20);
        add(lcontraseña);
        contra = new JPasswordField();
        contra.setBounds(10, 310, 200, 20);
        add(contra);

        lpoblacion = new JLabel("Poblacion");
        lpoblacion.setBounds(10, 330, 200, 20);
        add(lpoblacion);
        poblacion = new JTextField();
        poblacion.setBounds(10, 350, 200, 20);
        add(poblacion);

        lprovypais = new JLabel("Pais y Provincia");
        lprovypais.setBounds(10, 370, 200, 20);
        add(lprovypais);

        lsexo = new JLabel("Sexo");
        lsexo.setBounds(10, 430, 200, 20);
        add(lsexo);

        lidiomas = new JLabel("Idiomas");
        lidiomas.setBounds(10, 470, 200, 20);
        add(lidiomas);

        lcarta = new JLabel("Carta de presentacion");
        lcarta.setBounds(10, 540, 200, 20);
        add(lcarta);

        //Creo el boton generar datos
        generardatos = new JButton("Generar datos personales");
        generardatos.setBounds(10, 620, 200, 20);
        add(generardatos);

        generardatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == generardatos) {
                    GenerarDatos();

                    CambiarTamano();
                    CambiarColores();
                }
            }
        });

        //Creo el Jtexarea para poder escribir
        cartapres = new JTextArea();
        cartapres.setBounds(10, 560, 300, 50);
        add(cartapres);

        //Añadimos el Scrollpanel
        scrollpanel1 = new JScrollPane(cartapres);
        scrollpanel1.setBounds(10, 560, 300, 50);
        add(scrollpanel1);

        //Creamos el JEditor panel
        texto2 = new JEditorPane();
        scrollpanel2 = new JScrollPane(texto2);
        scrollpanel2.setBounds(400, 10, 300, 550);
        add(scrollpanel2);

        //Si sólo queremos mostrar texto HTML, debemos deshabilitar la edición del editor
        texto2.setEditable(false);
        texto2.setContentType("text/html"); // Marcamos el editor para que use HTML

        //Creo los 6 Checkbox y los añado
        Español = new JCheckBox("Español");
        Español.setBounds(10, 490, 80, 30);
        Español.addChangeListener(this);
        add(Español);
        Ingles = new JCheckBox("Ingles");
        Ingles.setBounds(90, 490, 80, 30);
        Ingles.addChangeListener(this);
        add(Ingles);
        Frances = new JCheckBox("Frances");
        Frances.setBounds(170, 490, 80, 30);
        Frances.addChangeListener(this);
        add(Frances);
        Aleman = new JCheckBox("Aleman");
        Aleman.setBounds(10, 510, 80, 30);
        Aleman.addChangeListener(this);
        add(Aleman);
        Italiano = new JCheckBox("Italiano");
        Italiano.setBounds(90, 510, 80, 30);
        Italiano.addChangeListener(this);
        add(Italiano);

        OtrosId= new JTextField();
        OtrosId.setBounds(170,540,80,25);
        add(OtrosId);
        OtrosId.setVisible(false);

        Otros = new JCheckBox("Otros");
        Otros.setBounds(170, 510, 80, 30);
        Otros.addChangeListener(this);
        add(Otros);

        Otros.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (Otros.isSelected()) {
                    //Otros.setVisible(true);
                    OtrosId.setVisible(true);

                } else {
                    OtrosId.setVisible(false);
                    OtrosId.setText("");
                }
            }
        });

        //Creo un nuevo grupo de botones
        gruposexo = new ButtonGroup();
        //Creo los 3 radioButton con su ChangeListener
        hombre = new JRadioButton("Hombre");
        hombre.setBounds(10, 450, 80, 20);
        hombre.addChangeListener(this);
        add(hombre);
        gruposexo.add(hombre);

        mujer = new JRadioButton("Mujer");
        mujer.setBounds(90, 450, 80, 20);
        mujer.addChangeListener(this);
        add(mujer);
        gruposexo.add(mujer);

        otros = new JRadioButton("Otros");
        otros.setBounds(170, 450, 80, 20);
        otros.addChangeListener(this);
        add(otros);
        gruposexo.add(otros);

        //Creamos los combobox de paises y provincias
        pais = new JComboBox();
        pais.setBounds(10, 390, 150, 20);
        add(pais);

        provincia = new JComboBox();
        provincia.setBounds(10, 410, 150, 20);
        add(provincia);

        pais.addItem("");
        pais.addItem("España");
        pais.addItem("Italia");

        String españa[] = {"Alava", "Albacete", "Alicante", "Almería", "Asturias", "Avila", "Badajoz", "Barcelona", "Burgos", "Cáceres", "Cádiz", "Cantabria", "Castellón", "Ciudad Real", "Córdoba", "La Coruña", "Cuenca", "Gerona", "Granada", "Guadalajara", "Guipúzcoa", "Huelva", "Huesca", "Islas Baleares", "Jaén", "León", "Lérida", "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Orense", "Palencia", "Las Palmas", "Pontevedra", "La Rioja", "Salamanca", "Segovia", "Sevilla", "Soria", "Tarragona", "Santa Cruz de Tenerife", "Teruel", "Toledo", "Valencia", "Valladolid", "Vizcaya", "Zamora", "Zaragoza"};
        String italia[] = {"Roma", "Turin", "Napoles", "Milan", "Bari", "Florencia", "Bolonia", "Génova", "Venecia", "Regio de Calabria"};

        pais.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                provincia.removeAllItems();
                if (pais.getSelectedItem().equals("España")) {
                    for (int i = 0; i < españa.length; i++) {
                        provincia.addItem(españa[i]);
                    }
                } else if (pais.getSelectedItem().equals("Italia")) {
                    for (int i = 0; i < italia.length; i++) {
                        provincia.addItem(italia[i]);
                    }
                } else {
                }
            }
        });

    }

    public void CambiarTamano() {
        tamaño1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarTamano= "tamaño1";
                tamano += 5f;
                GenerarDatos();
            }
        });
        tamaño2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarTamano= "tamaño2";
                tamano += 10f;
                GenerarDatos();
            }
        });
        tamaño3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarTamano= "tamaño3";
                tamano += 15f;
                GenerarDatos();
            }
        });
        tamaño4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarTamano= "tamaño4";
                tamano += 25f;
                GenerarDatos();

            }
        });
        tamaño5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarTamano= "tamaño5";
                tamano += 35f;
                GenerarDatos();
            }
        });

    }

    public void CambiarColores() {
        color1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarColores = "red";
                GenerarDatos();
            }
        });
        color2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarColores = "green";
                GenerarDatos();
            }
        });
        color3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarColores = "blue";
                GenerarDatos();
            }
        });
        color4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarColores = "orange";
                GenerarDatos();
            }
        });
        color5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarColores = "black";
                GenerarDatos();
            }
        });
    }


    private void GenerarDatos() {

        CambiarTamano();
        CambiarColores();
        texto2.setText(
                "<font color= "+CambiarColores+">"+
                "<font size='"+CambiarTamano+"'>"+
                        "<p> Nombre: " + nombre.getText() + "</p>" +
                        "<p> Apellidos: " + apellidos.getText() + "</p>" +
                        "<p> Direccion: " + direccion.getText() + "</p>" +
                        "<p> Telefono: " + telefono.getText() + "</p>" +
                        "<p> DNI: " + DNI.getText() + "</p>" +
                        "<p> Codigo postal: " + codigopostal.getText() + "</p>" +
                        "<p> Email: " + email.getText() + "</p>" +
                        "<p> Contraseña: " + contra.getText() + "</p>" +
                        "<p> Poblacion: " + poblacion.getText() + "</p>" +
                        "<p> Sexo: " + generaSexo() + "</p>" +
                        "<p> Idioma: " + generaIdioma + "</p>"+ OtrosId.getText() +
                       "<p> Carta de Presentacion: " +cartapres.getText()+ "</p>" +
                "<font color= "+CambiarColores+">"+
                "<font size='"+CambiarTamano+"'>"
        );
    }

    public String generaSexo() {
        String sexo = "";
        if (hombre.isSelected()) {
            sexo += "Hombre";
        } else if (mujer.isSelected()) {
            sexo += "Mujer";
        } else if (otros.isSelected()) {
            sexo += "Otros";
        }
        return sexo;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        try {
            generaIdioma = "";
            if (Español.isSelected()) {
                generaIdioma += "Español, ";
            }
            if (Ingles.isSelected()) {
                generaIdioma += "Ingles, ";
            }
            if (Aleman.isSelected()) {
                generaIdioma += "Aleman, ";
            }
            if (Italiano.isSelected()) {
                generaIdioma += "Italiano, ";
            }
            if (Frances.isSelected()) {
                generaIdioma += "Frances, ";
            }
            if (Otros.isSelected()) {
                generaIdioma += "  ,";
            }
            generaIdioma = generaIdioma.substring(0, generaIdioma.length() - 2);
        } catch (Exception pswd) {
        }
    }

    public static void main(String[] args) {
        Formulario formularioCombobox = new Formulario();
        formularioCombobox.setDefaultCloseOperation(EXIT_ON_CLOSE);
        formularioCombobox.setBounds(0, 0, 750, 720);
        formularioCombobox.setTitle("Formulario Datos Personales");
        formularioCombobox.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}