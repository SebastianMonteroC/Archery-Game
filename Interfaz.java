import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    
public class Interfaz extends JFrame{
    private JButton empezar;
    private JButton cambiarSets;
    private JButton cambiarFlechas;
    private JButton verPuntaje;
    private JButton salir;
    private Menu menu;
    
    
    public Interfaz() { //CONSTRUCTOR DE INTERFAZ DE MENU PRINCIPAL
        //Crea una instancia de la clase Menu para pasarle lo que el usuario haga y crea una ventana
        JFrame ventana = new JFrame("Arqueria");

        
        cargarImagen("pixelMenu.png", 500, 500);//Agrega una imagen a la ventana como fondo y ajusta su tamano, posicion y otras configuraciones
        
        pack();
        setVisible(true);
        setLayout(null);
        setSize(500,500);
        setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //BOTONES
        
        //Boton de iniciar juego
        crearBotonIniciarJuego();
        
        //Boton de cambiar el numero de sets
        crearBotonCambiarSets();
        
        //Boton de cambiar el numero de flechas
        crearBotonCambiarFlechas();
        
        //Boton para ver el puntaje mayor
        crearBotonVerPuntaje();
        
        //Boton de salir
        crearBotonSalir();
    }
    
    //metodo que recibe las coordenadas para realizar el tiro
    
    public double[] ingresarCoordenadas(){
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
          
        double coordenadaX = 1.0;
        double coordenadaY = 1.0;
          
        double[] coordenadas = new double[2];
    
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("X:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Y:"));
        myPanel.add(yField);
    
        int result = JOptionPane.showConfirmDialog(null, myPanel, "Ingrese las coordenadas de su tiro ", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try{
                coordenadaX = Double.parseDouble(xField.getText());
                coordenadaY = Double.parseDouble(yField.getText());
                mensaje("Coordenadas Recibidas: Realizando Tiro");
            }
            catch(Exception e){
                mensaje("Coordenadas Invalidas: Realizando Tiro Aleatorio");
                coordenadaX = Math.random();
                coordenadaY = Math.random();
            }  
        }
        if(result == JOptionPane.CANCEL_OPTION){
            mensaje("Juego Terminado");
        }
      coordenadas[0] = coordenadaX;
      coordenadas[1] = coordenadaY;
      return coordenadas;
    }
    
    public String ingresarNombre(){
        JTextField nombreField = new JTextField(6);
        String nombreDeUsuario = "";
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Ingrese su nombre: "));
        myPanel.add(nombreField);
        myPanel.add(Box.createHorizontalStrut(15));
        int result = JOptionPane.showConfirmDialog(null, myPanel, "HIGH SCORE", JOptionPane.OK_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            mensaje("HIGH SCORE GUARDADO CON EXITO!");
            nombreDeUsuario = nombreField.getText();
        }
        return nombreDeUsuario;
    }
    //crea un joptionpane con el mensaje ingresado
    public void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje,"Arqueria",1);
    }
    
    /* METODOS QUE CREAN BOTONES */
     
    public void crearBotonSalir(){
        salir = new JButton("Salir");
        salir.setBounds(50,350,200,50);
        this.add(salir);
        salir.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent evt){
               System.exit(0);
            }
        });
    }
    
    //Crea el boton para ver el puntaje mas altos
    public void crearBotonVerPuntaje(){
        verPuntaje = new JButton("Ver Puntajes");
        verPuntaje.setBounds(50,300,200,50);
        this.add(verPuntaje);
        verPuntaje.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                mensaje("Puntaje mas alto es: " + Menu.puntajeMasAlto + " hecho por " + Menu.nombreDeHighScore);
            }
        }); 
    }
    
    //crea el boton para cambiar la cantidad de sets
    public void crearBotonCambiarFlechas(){
        cambiarFlechas = new JButton("Cambiar Flechas");
        cambiarFlechas.setBounds(50,250,200,50);
        this.add(cambiarFlechas);
        cambiarFlechas.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
               Menu.cambiarFlechas();
            }
        });
    }
    
    //crea el boton para cambiar la cantidad de sets
    
    public void crearBotonCambiarSets(){
        cambiarSets = new JButton("Cambiar Sets");
        cambiarSets.setBounds(50,200,200,50);
        this.add(cambiarSets);
        cambiarSets.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
               Menu.cambiarSets();
            }
        });
    }
    
    //crea el boton para iniciar el juego
    public void crearBotonIniciarJuego(){
        empezar = new JButton("Iniciar Partida");
        empezar.setBounds(50,150,200,50);
        this.add(empezar);
        empezar.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent evt){
                Menu.iniciarJuego();
            }
        }); 
    }
    
    //Metodo que cambia la cantidad de flechas o sets dependiendo del mensaje que se ingresa
    
    public int cambiarDato(String mensaje){
          JTextField xField = new JTextField(5);
          
          int valorIngresado = 1;
    
          JPanel myPanel = new JPanel();
          myPanel.add(new JLabel(mensaje));
          myPanel.add(xField);
          myPanel.add(Box.createHorizontalStrut(15));
    
          int result = JOptionPane.showConfirmDialog(null, myPanel, "Ingrese la cantidad de " + mensaje + ": ", JOptionPane.OK_CANCEL_OPTION);
          if (result == JOptionPane.OK_OPTION) {
              if(esEntero(xField.getText())){
                  valorIngresado = Integer.parseInt(xField.getText());
              }
         }
            return valorIngresado;
      }
    
    // verifica si un String es entero
    public boolean esEntero(String datoIngresado){
        int numeroPrueba = 0;
        boolean esEntero;
        try{
            numeroPrueba += Integer.parseInt(datoIngresado);
            esEntero = true;
        }
        catch(Exception e){
            esEntero = false;
        }
        return esEntero;
    }
    
    //Cargar la imagen del menu
    
    public void cargarImagen(String path, int sizeX, int sizeY){
        Image img = Toolkit.getDefaultToolkit().getImage(path);
        Image newImg = img.getScaledInstance(sizeX, sizeY, Image.SCALE_DEFAULT);
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(newImg, 1, 1, null);
            }
        });
        }
        
}
