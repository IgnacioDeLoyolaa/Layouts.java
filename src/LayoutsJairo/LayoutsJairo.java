package LayoutsJairo;

import java.awt.*;
import static java.awt.BorderLayout.*;
import static java.awt.Font.PLAIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.border.LineBorder;

public class LayoutsJairo extends JFrame{

    BorderLayout JFrameBorderLayout; //borderLayout para el JFrame
    JPanel panelOeste, panelSur, panelCentro; //paneles del JFrame
    JPanel tarjetaBienvenida, tarjetaDatos, tarjetaUbicacion, tarjetaResultado, tarjetaCompletado; //paneles para als tarjetas
    FlowLayout izquierdaFlowLayout, centroFlowLayout, derechaFlowLayout;
    CardLayout panelCentroCardLayout; //cardLayout para el panel centro del JFrame
    JButton botonAnterior, botonSiguiente, botonExaminar; //botones del panelSur para cambiar las tarjetas y para guardar el archivo
    JLabel tituloBienvenida, tituloDatos, tituloUbicacion, tituloResultado, tituloCompletado; //labels para los títulos de las tarjetas
    JTextArea textAreaBienvenida, textAreaResultado, textAreaCompletado; //textAreas
    JLabel labelOeste, labelNombre, labelEmail, labelClave, labelPais, labelProvincia, labelExaminar; //labels campos
    JLabel errorNombre, errorEmail, errorClave1, errorClave2; //labels para errores
    JTextField textFieldNombre, textFieldEmail; //textfields
    JPasswordField passwordFieldClave; //passwordfield
    Pattern patronEmail;
    JComboBox comboBoxPais, comboBoxProvincia;  //combobox
    Color colorGrisClarito = new Color(230,230,230); //color gris clarito
    Color colorDegradado = new Color(156, 186, 167); //color para el degradado
    String nombre, email, clave, pais, provincia, resultado, rutaGuardar; //Strings para almacenar el resultado;
    File ficheroUbicacion, ficheroGuardar; //para las provincias o estados
    JCheckBox checkBoxGuardar; //para guardar el resultado
    JFileChooser fileChooser; //para elegir el directorio
    BufferedImage imagenOeste;

    public LayoutsJairo(){

        initLayouts();
        initPanelOeste();
        initPanelSur();
        initPanelCentro();
        initTarjetaBienvenida();
        initTarjetaDatos();
        initTarjetaUbicacion();
        initTarjetaResultado();
        initTarjetaCompletado();
        initPantalla();

    }

    private void initLayouts(){

        //Centro el JFrame en la pantalla
        setLocationRelativeTo(null);

        //Inicializo BorderLayout (para el JFrame)
        JFrameBorderLayout = new BorderLayout(0,0);
        setLayout(JFrameBorderLayout);

        //Inicializo FlowLayouts para usarlos en los paneles del JFrame y de las tarjetas
        izquierdaFlowLayout = new FlowLayout(FlowLayout.LEFT,10,10);
        derechaFlowLayout = new FlowLayout(FlowLayout.RIGHT,20,20);
        centroFlowLayout = new FlowLayout(FlowLayout.CENTER,0,0);

        //Inicializo CardLayout para el panelCentro
        panelCentroCardLayout = new CardLayout();

    }

    private void initPanelOeste(){

        panelOeste = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, colorDegradado, 0, getHeight(), colorGrisClarito);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        }; //Inicializo panel con gradiente
        panelOeste.setBackground(Color.DARK_GRAY); //Color de fondo
        add(panelOeste,WEST); //Lo añado al oeste del JFrame
        panelOeste.setPreferredSize(new Dimension(200,520)); //Establezco dimensiones del panel
        panelOeste.setLayout(centroFlowLayout); //Establezco layout para los elementos internos

        //Logo
        try {
            imagenOeste = ImageIO.read(new File("src\\LayoutsJairo\\pulgararriba.png"));
        } catch (IOException ex) {
        }
        labelOeste = new JLabel(new ImageIcon(imagenOeste));
        labelOeste.setPreferredSize(new Dimension(100,230));
        panelOeste.add(labelOeste);

    }

    private void initPanelSur(){

        panelSur = new JPanel(); //Inicializo panel
        panelSur.setBackground(colorGrisClarito); //Color de fondo
        add(panelSur,SOUTH); //Lo añado al sur del JFrame
        panelSur.setPreferredSize(new Dimension(800,80)); //Establezco dimensiones del panel
        panelSur.setLayout(derechaFlowLayout); //Establezco layout para los elementos internos

        //Añado botones anterior y siguiente
        initBotonAnterior();
        initBotonSiguiente();

    }

    private void initPanelCentro(){

        panelCentro = new JPanel(); //Inicializo panel
        panelCentro.setBackground(colorGrisClarito); //Color de fondo
        add(panelCentro,CENTER); //Lo añado al oeste del JFrame
        panelCentro.setPreferredSize(new Dimension(600,520)); //Establezco dimensiones del panel
        panelCentro.setLayout(panelCentroCardLayout); //Establezco layout para los elementos internos

    }

    private void initTarjetaBienvenida(){

        tarjetaBienvenida = new JPanel(); //Inicializo panel
        tarjetaBienvenida.setBackground(colorGrisClarito); //Color de fondo
        tarjetaBienvenida.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //Establezco un padding con un borde transparente
        tarjetaBienvenida.setLayout(izquierdaFlowLayout); //Establezco layout para los elementos internos

        tituloBienvenida = new JLabel("Bienvenido al panel de registro"); //Inicializo título
        tituloBienvenida.setPreferredSize(new Dimension(600,100));
        tituloBienvenida.setFont(new Font("ARIAL",PLAIN,32));
        tarjetaBienvenida.add(tituloBienvenida);

        textAreaBienvenida = new JTextArea(); //Inicializo textArea
        textAreaBienvenida.setBackground(colorGrisClarito); //Color de fondo
        textAreaBienvenida.setEditable(false); //Lo hago no editable
        textAreaBienvenida.setBorder(null); //Le quito el borde
        textAreaBienvenida.setFont(new Font("ARIAL",PLAIN,16));  //Establezco fuente
        textAreaBienvenida.setText("Por favor, lee detalladamente las siguientes instrucciones:\n\n" +
                "1.  Rellena tu nombre y apellidos y proporciona un email válido.\n" +
                "2.  Introduce una contraseña entre 8 y 16 caracteres que contenga al\n" +
                "     menos un dígito, una mayúscula, una minúscula y un carácter extraño.\n" +
                "3.  Escoge tu país y provincia o estado de residencia.\n" +
                "4.  Comprueba los datos y selecciona si quieres guardarlos en un fichero.\n" +
                "5.  Haz clic en Finalizar para completar el registro.\n"
        ); //Establezco texto
        tarjetaBienvenida.add(textAreaBienvenida); //Lo añado a la tarjeta

        panelCentro.add(tarjetaBienvenida, "Bienvenida"); //Añado la tarjeta al panel de tarjetas

        panelCentroCardLayout.show(panelCentro, "Bienvenida"); //Muestro la primera tarjeta

    }

    private void initTarjetaDatos(){

        tarjetaDatos = new JPanel(); //Inicializo panel
        tarjetaDatos.setBackground(colorGrisClarito); //Color de fondo
        tarjetaDatos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //Establezco un padding con un borde transparente
        tarjetaDatos.setLayout(izquierdaFlowLayout); //Establezco layout para los elementos internos

        tituloDatos = new JLabel("Datos personales"); //Inicializo título
        tituloDatos.setPreferredSize(new Dimension(600,100));
        tituloDatos.setFont(new Font("ARIAL",PLAIN,32));
        tarjetaDatos.add(tituloDatos);

        labelNombre = new JLabel("Nombre:"); //Inicializo label nombre
        labelNombre.setPreferredSize(new Dimension(140,35));
        labelNombre.setFont(new Font("ARIAL",PLAIN,16));
        tarjetaDatos.add(labelNombre);

        textFieldNombre = new JTextField(); //Inicializo el textfield nombre
        textFieldNombre.setPreferredSize(new Dimension(400,35));
        textFieldNombre.setFont(new Font("ARIAL",PLAIN,16));
        textFieldNombre.setBorder(new LineBorder(Color.BLACK));
        tarjetaDatos.add(textFieldNombre);

        errorNombre = new JLabel(""); //Inicializo error nombre
        errorNombre.setPreferredSize(new Dimension(550,35));
        errorNombre.setFont(new Font("ARIAL",PLAIN,14));
        errorNombre.setForeground(Color.RED);
        errorNombre.setHorizontalAlignment(RIGHT);
        tarjetaDatos.add(errorNombre);

        labelEmail = new JLabel("Email:"); //Inicializo label email
        labelEmail.setPreferredSize(new Dimension(140,35));
        labelEmail.setFont(new Font("ARIAL",PLAIN,16));
        tarjetaDatos.add(labelEmail);

        textFieldEmail = new JTextField(); //Inicializo el textfield email
        textFieldEmail.setPreferredSize(new Dimension(400,35));
        textFieldEmail.setFont(new Font("ARIAL",PLAIN,16));
        textFieldEmail.setBorder(new LineBorder(Color.BLACK));
        tarjetaDatos.add(textFieldEmail);

        errorEmail = new JLabel(""); //Inicializo error email
        errorEmail.setPreferredSize(new Dimension(550,35));
        errorEmail.setFont(new Font("ARIAL",PLAIN,14));
        errorEmail.setForeground(Color.RED);
        errorEmail.setHorizontalAlignment(RIGHT);
        tarjetaDatos.add(errorEmail);

        labelClave = new JLabel("Clave:"); //Inicializo label clave
        labelClave.setPreferredSize(new Dimension(140,35));
        labelClave.setFont(new Font("ARIAL",PLAIN,16));
        tarjetaDatos.add(labelClave);

        passwordFieldClave = new JPasswordField(); //Inicializo el passwordfield clave
        passwordFieldClave.setPreferredSize(new Dimension(400,35));
        passwordFieldClave.setFont(new Font("ARIAL",PLAIN,16));
        passwordFieldClave.setBorder(new LineBorder(Color.BLACK));
        tarjetaDatos.add(passwordFieldClave);

        errorClave1 = new JLabel(""); //Inicializo error clave1
        errorClave1.setPreferredSize(new Dimension(550,14));
        errorClave1.setFont(new Font("ARIAL",PLAIN,14));
        errorClave1.setForeground(Color.RED);
        errorClave1.setHorizontalAlignment(RIGHT);
        tarjetaDatos.add(errorClave1);

        errorClave2 = new JLabel("");//Inicializo error clave2
        errorClave2.setPreferredSize(new Dimension(550,14));
        errorClave2.setFont(new Font("ARIAL",PLAIN,14));
        errorClave2.setForeground(Color.RED);
        errorClave2.setHorizontalAlignment(RIGHT);
        tarjetaDatos.add(errorClave2);

        panelCentro.add(tarjetaDatos, "Datos"); //Añado la tarjeta al panel de tarjetas

    }

    private void initTarjetaUbicacion(){

        tarjetaUbicacion = new JPanel(); //Inicializo panel
        tarjetaUbicacion.setBackground(colorGrisClarito); //Color de fondo
        tarjetaUbicacion.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //Establezco un padding con un borde transparente
        tarjetaUbicacion.setLayout(izquierdaFlowLayout); //Establezco layout para los elementos internos

        tituloUbicacion = new JLabel("País y provincia/estado"); //Inicializo título
        tituloUbicacion.setPreferredSize(new Dimension(600,100));
        tituloUbicacion.setFont(new Font("ARIAL",PLAIN,32));
        tarjetaUbicacion.add(tituloUbicacion);

        labelPais = new JLabel("País:"); //Inicializo label pais
        labelPais.setPreferredSize(new Dimension(140,35));
        labelPais.setFont(new Font("ARIAL",PLAIN,16));
        tarjetaUbicacion.add(labelPais);

        comboBoxPais = new JComboBox(); //Inicializo combobox paises
        comboBoxPais.setPreferredSize(new Dimension(400,35));
        comboBoxPais.setFont(new Font("ARIAL",PLAIN,16));
        comboBoxPais.addItem("España");
        comboBoxPais.addItem("EEUU");
        comboBoxPais.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                //LLamo al método que carga el combo de provnicas / estados
                addProvincias(comboBoxPais.getSelectedItem().toString());
            }

        });
        tarjetaUbicacion.add(comboBoxPais);

        labelProvincia = new JLabel("Provincia/Estado:"); //Inicializo label provincia
        labelProvincia.setPreferredSize(new Dimension(140,35));
        labelProvincia.setFont(new Font("ARIAL",PLAIN,16));
        tarjetaUbicacion.add(labelProvincia);

        comboBoxProvincia = new JComboBox(); //Inicializo combobox provincias
        comboBoxProvincia.setPreferredSize(new Dimension(400,35));
        comboBoxProvincia.setFont(new Font("ARIAL",PLAIN,16));
        addProvincias("España");
        tarjetaUbicacion.add(comboBoxProvincia);

        panelCentro.add(tarjetaUbicacion, "Ubicacion"); //Añado la tarjeta al panel de tarjetas

    }

    private void initTarjetaResultado(){

        tarjetaResultado = new JPanel(); //Inicializo panel
        tarjetaResultado.setBackground(colorGrisClarito); //Color de fondo
        tarjetaResultado.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //Establezco un padding con un borde transparente
        tarjetaResultado.setLayout(izquierdaFlowLayout); //Establezco layout para los elementos internos

        tituloResultado = new JLabel("Resultado"); //Inicializo título
        tituloResultado.setPreferredSize(new Dimension(600,100));
        tituloResultado.setFont(new Font("ARIAL",PLAIN,32));
        tarjetaResultado.add(tituloResultado);

        textAreaResultado = new JTextArea(); //Inicializo textArea
        textAreaResultado.setPreferredSize(new Dimension(600,200));
        textAreaResultado.setBackground(colorGrisClarito); //Color de fondo
        textAreaResultado.setEditable(false); //Lo hago no editable
        textAreaResultado.setBorder(null); //Le quito el borde
        textAreaResultado.setFont(new Font("ARIAL",PLAIN,16));  //Establezco fuente
        textAreaResultado.setText("Estos son los datos introducidos:\n\n" + resultado); //Establezco texto
        tarjetaResultado.add(textAreaResultado); //Lo añado a la tarjeta

        checkBoxGuardar = new JCheckBox("Marque esta opción para guardar el resultado en un fichero"); //Inicializo label checkbox
        checkBoxGuardar.setPreferredSize(new Dimension(600,35));
        checkBoxGuardar.setBorder(null);
        checkBoxGuardar.setFont(new Font("ARIAL",PLAIN,16));
        tarjetaResultado.add(checkBoxGuardar);
        //Acciones
        checkBoxGuardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                checkGuardar();

            }
        });

        botonExaminar = new JButton("Examinar...");
        botonExaminar.setPreferredSize(new Dimension(100,25));
        botonExaminar.setFont(new Font("ARIAL",PLAIN,16));
        botonExaminar.setOpaque(true);
        botonExaminar.setFocusPainted(false);
        botonExaminar.setBackground(colorGrisClarito);
        botonExaminar.setBorder(new LineBorder(Color.DARK_GRAY));
        botonExaminar.setForeground(Color.BLACK);
        botonExaminar.setVisible(false);
        tarjetaResultado.add(botonExaminar); //Lo añado al panel
        //Acciones
        botonExaminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                initChooser();

            }
        });

        labelExaminar = new JLabel("Por favor, selecciona un directorio"); //Inicializo labelChooser
        labelExaminar.setPreferredSize(new Dimension(400,25));
        labelExaminar.setFont(new Font("ARIAL",PLAIN,14));
        labelExaminar.setForeground(Color.RED);
        labelExaminar.setVisible(false);
        tarjetaResultado.add(labelExaminar);

        panelCentro.add(tarjetaResultado, "Resultado"); //Añado la tarjeta al panel de tarjetas

    }

    private void initTarjetaCompletado(){

        tarjetaCompletado = new JPanel(); //Inicializo panel
        tarjetaCompletado.setBackground(colorGrisClarito); //Color de fondo
        tarjetaCompletado.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //Establezco un padding con un borde transparente
        tarjetaCompletado.setLayout(izquierdaFlowLayout); //Establezco layout para los elementos internos

        tituloCompletado = new JLabel("Gracias por completar el registro"); //Inicializo título
        tituloCompletado.setPreferredSize(new Dimension(600,100));
        tituloCompletado.setFont(new Font("ARIAL",PLAIN,32));
        tarjetaCompletado.add(tituloCompletado);

        textAreaCompletado = new JTextArea(); //Inicializo textArea
        textAreaCompletado.setBackground(colorGrisClarito); //Color de fondo
        textAreaCompletado.setPreferredSize(new Dimension(600,100));
        textAreaCompletado.setEditable(false); //Lo hago no editable
        textAreaCompletado.setBorder(null); //Le quito el borde
        textAreaCompletado.setFont(new Font("ARIAL",PLAIN,16));  //Establezco fuente
        tarjetaCompletado.add(textAreaCompletado); //Lo añado a la tarjeta

        panelCentro.add(tarjetaCompletado, "Completado"); //Añado la tarjeta al panel de tarjetas

    }

    private void initPantalla(){

        setTitle("Layouts Jairo");
        setSize(800,700);
        //setMinimumSize(new Dimension(800,600));
        setResizable(false);
        //getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        validate();

    }

    private void initBotonAnterior(){

        botonAnterior = new JButton("Anterior");
        botonAnterior.setPreferredSize(new Dimension(100,40));
        botonAnterior.setFont(new Font("ARIAL",PLAIN,18));
        botonAnterior.setOpaque(true);
        botonAnterior.setFocusPainted(false);
        botonAnterior.setBackground(colorGrisClarito);
        botonAnterior.setBorder(new LineBorder(Color.DARK_GRAY));
        botonAnterior.setForeground(Color.BLACK);
        panelSur.add(botonAnterior); //Lo añado al panelSur

        //Deshabilito el botón de anterior (al iniciar)
        botonAnterior.setEnabled(false);

        //Acciones
        botonAnterior.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                //Tarjeta anterior
                panelCentroCardLayout.previous(panelCentro);

                //Compruebo si tengo que deshabilitar o no botón anterior
                checkPrimeraTarjeta();
            }
        });

    }

    private void initBotonSiguiente(){

        botonSiguiente = new JButton("Siguiente");
        botonSiguiente.setPreferredSize(new Dimension(100,40));
        botonSiguiente.setFont(new Font("ARIAL",PLAIN,18));
        botonSiguiente.setOpaque(true);
        botonSiguiente.setFocusPainted(false);
        botonSiguiente.setBackground(colorGrisClarito);
        botonSiguiente.setBorder(new LineBorder(Color.DARK_GRAY));
        botonSiguiente.setForeground(Color.BLACK);
        panelSur.add(botonSiguiente); //Lo añado al panelSur

        //Acciones
        botonSiguiente.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                //Recojo datos
                if (getDatos()){

                    //Compruebo si tengo que deshabilitar o no botón anterior
                    checkPrimeraTarjeta();

                    //Compruebo si tengo que deshabilitar o no botón anterior y botón de salir
                    checkUltimaTarjeta();

                }

                //Recojo ubicación
                getUbicacion();

            }
        });

    }

    //Compruebo si tengo que deshabilitar o no botón anterior
    private void checkPrimeraTarjeta(){

        if (tarjetaBienvenida.isShowing() == true){
            botonAnterior.setEnabled(false);
        }
        else{
            botonAnterior.setEnabled(true);
        }

    }

    //Compruebo si tengo que deshabilitar o no botón anterior y botón de salir
    private void checkUltimaTarjeta(){

        //Acción tarjeta siguiente (o salir)
        if (tarjetaCompletado.isShowing() == true){
            System.exit(0);
        }
        else{
            panelCentroCardLayout.next(panelCentro);
        }

        //Compruebo si ha llegado al final de la última tarjeta
        if (tarjetaCompletado.isShowing() == true){
            botonSiguiente.setText("Salir");
            botonAnterior.setEnabled(false);
            if (checkBoxGuardar.isSelected()){
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter(rutaGuardar, false));
                    out.write(resultado);
                    out.newLine();
                    out.close();
                } catch (IOException ex) {
                }
                textAreaCompletado.setText("Los datos se han guardado correctamente en:\n\n" + rutaGuardar); //Establezco texto
            }
        }
        else{
            botonSiguiente.setText("Siguiente");
        }

    }

    private void addProvincias(String paisSeleccionado){

        //Borro todos los items del combobox
        comboBoxProvincia.removeAllItems();

        //Inicializo fichero según país
        if (paisSeleccionado.equals("España")){
            ficheroUbicacion = new File("src\\LayoutsJairo\\provincias.txt");
        }
        else{
            ficheroUbicacion = new File("src\\LayoutsJairo\\estados.txt");
        }

        //Leo el fichero por líneas y relleno el combobox de provincias
        try(FileReader fileStream = new FileReader(ficheroUbicacion);

            BufferedReader bufferedReader = new BufferedReader( fileStream ) ) {

            String linea = null;
            while( (linea = bufferedReader.readLine()) != null ) {
                comboBoxProvincia.addItem(linea);
            }

        }
        catch ( FileNotFoundException ex ) {
        }
        catch ( IOException ex ) {
        }

    }

    private boolean getDatos(){

        if (tarjetaDatos.isShowing() == true){

            //Nombre
            nombre = textFieldNombre.getText();
            if (nombre.equals("")){
                errorNombre.setText("El nombre no puede estar vacío");
                textFieldNombre.requestFocus();
                return false;
            }
            else{
                errorNombre.setText("");
            }
            //Email
            email = textFieldEmail.getText();
            if (email.equals("") || !checkEmail(email)){
                errorEmail.setText("El email no es válido");
                textFieldEmail.requestFocus();
                return false;
            }
            else{
                errorEmail.setText("");
            }
            //Clave
            clave = String.valueOf(passwordFieldClave.getPassword());
            if (clave.equals("") || !checkClave(clave)){
                errorClave1.setText("La clave debe tener entre 8 y 16 caracteres y al menos");
                errorClave2.setText("una mayúscula, una minúscula, un dígito y un carácter extraño");
                passwordFieldClave.requestFocus();
                return false;
            }
            else{
                errorClave1.setText("");
                errorClave2.setText("");
            }
            //Si todo es válido
            return true;
        }
        else{
            return true;
        }

    }

    private boolean checkEmail(String textoEmail){

        Pattern patronEmail = Pattern.compile("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})$");
        return patronEmail.matcher(textoEmail).find();

    }

    private boolean checkClave(String textoClave){

        int minuscula = 0;
        int mayuscula = 0;
        int especial = 0;
        int numero = 0;

        if (textoClave.length()>= 8 && textoClave.length()<= 16){

            for (int i = 0; i < textoClave.length(); i++){

                char c = textoClave.charAt(i);
                if(Character.isUpperCase(c)){
                    mayuscula++;
                }
                if(Character.isLowerCase(c)){
                    minuscula++;
                }
                if(Character.isDigit(c)){
                    numero++;
                }
                if(c>=33&&c<=46||c==64){
                    especial++;
                }

            }

            if (mayuscula > 0 && minuscula > 0 && numero > 0 && especial > 0){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }

    }

    private void getUbicacion(){

        if (tarjetaResultado.isShowing() == true){

            pais = comboBoxPais.getSelectedItem().toString();
            provincia = comboBoxProvincia.getSelectedItem().toString();

            resultado = "Nombre: " + nombre +
                    "\nEmail: " + email +
                    "\nClave: " + clave +
                    "\nPaís: " + pais +
                    "\nProvincia / Estado: " + provincia;

            textAreaResultado.setText("Estos son los datos introducidos:\n\n" + resultado); //Establezco texto

        }

    }

    private void checkGuardar(){

        if (checkBoxGuardar.isSelected()){
            botonExaminar.setVisible(true);
            labelExaminar.setVisible(true);
        }
        else{
            botonExaminar.setVisible(false);
            labelExaminar.setVisible(false);
        }

    }

    private void initChooser(){

        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        fileChooser.setDialogTitle("Elige un directorio");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            rutaGuardar = fileChooser.getSelectedFile()+"/datos.txt";
            labelExaminar.setText(rutaGuardar); //Muestro la ruta del fichero
            labelExaminar.setForeground(Color.BLACK);
            ficheroGuardar = new File(rutaGuardar);
        }
        else{
            labelExaminar.setText("Por favor, selecciona un directorio"); //Muestro la ruta del fichero
            labelExaminar.setForeground(Color.RED);
        }

    }

    public static void main( String args[] ) {

        new LayoutsJairo();

    }

}

