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
        menu = new Menu();
        JFrame ventana = new JFrame("Arqueria");

        
        cargarImagen("pixil-frame-0.png", 500, 500);//Agrega una imagen a la ventana como fondo y ajusta su tamano, posicion y otras configuraciones
        
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
    
    public Interfaz(String mensaje){ ///CONSTRUCTOR DE INTERFAZ DE JUEGO
        JFrame ventana = new JFrame(mensaje);
        JTextField coordenadaX;
        JTextField coordenadaY;
        
        cargarImagen("pixil-frame-0.png",600,400);
        
        pack();
        setVisible(true);
        setLayout(null);
        setSize(600,400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        coordenadaX = new JTextField("2");
        coordenadaX.setPreferredSize(new Dimension(40,25));
        coordenadaX.setEditable(true);
        ventana.add(coordenadaX);
        
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
    
    public void crearBotonVerPuntaje(){
        verPuntaje = new JButton("Ver Puntajes");
        verPuntaje.setBounds(50,300,200,50);
        this.add(verPuntaje);
        verPuntaje.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
            }
        });
    }
    
    public void crearBotonCambiarFlechas(){
        cambiarFlechas = new JButton("Cambiar Flechas");
        cambiarFlechas.setBounds(50,250,200,50);
        this.add(cambiarFlechas);
        cambiarFlechas.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                pedirDato("FLECHAS");
            }
        });
    }
    
    public void crearBotonCambiarSets(){
        cambiarSets = new JButton("Cambiar Sets");
        cambiarSets.setBounds(50,200,200,50);
        this.add(cambiarSets);
        cambiarSets.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                pedirDato("SETS");
            }
        });
    }
    
    public void crearBotonIniciarJuego(){
        empezar = new JButton("Iniciar Partida");
        empezar.setBounds(50,150,200,50);
        this.add(empezar);
        empezar.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent evt){
                menu.iniciarJuego();
            }
        });
    }
    
    public void pedirDato(String mensaje){
        JTextField cantidad;
        JButton botonOk;
        JFrame ventana = new JFrame(mensaje);
        
        ventana.setVisible(true);
        ventana.setSize(250,100);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        cantidad = new JTextField("2");
        cantidad.setPreferredSize(new Dimension(40,25));
        cantidad.setEditable(true);
        ventana.add(cantidad);
        
        botonOk = new JButton("OK");
        ventana.add(botonOk);
        ventana.setLayout(new FlowLayout());
        botonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String setsString = cantidad.getText();
                int numeroEnEntero = 2;
                if(esEntero(setsString)){
                    numeroEnEntero = Integer.parseInt(cantidad.getText());
                }
                switch(mensaje){
                    case "SETS":
                    menu.cambiarSets(numeroEnEntero);
                    break;
                    case "FLECHAS":
                    menu.cambiarFlechas(numeroEnEntero);
                    break;
                }
                ventana.dispose();
            }
        });
    }
    
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
