public class Menu {
    private static Interfaz interfaz;
    private static Partida partida;
    public static int setsIngresados;
    public static int flechasIngresadas;
    public static int puntajeMasAlto;
    public static String nombreDeHighScore;
    
    
    public Menu(){
        interfaz = new Interfaz();
        setsIngresados = 2;
        flechasIngresadas = 3;
    }
    
    public static void iniciarJuego(){
        partida = new Partida(setsIngresados, flechasIngresadas, interfaz);
        partida.jugar();
    }
    
    public static void cambiarSets(){
        setsIngresados = interfaz.cambiarDato("sets");
        puntajeMasAlto = Juez.reiniciarPuntajeMasAlto();
    }
    
    public static void cambiarFlechas(){
        flechasIngresadas = interfaz.cambiarDato("flechas");
        puntajeMasAlto = Juez.reiniciarPuntajeMasAlto();
    }
    
    public static void setPuntaje(int puntaje,String nombre){
        puntajeMasAlto = puntaje;
        nombreDeHighScore = nombre;
    }
}
