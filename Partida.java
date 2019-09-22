import java.util.Random;
public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private Set set;
    private Juez juez;
    private Blanco blanco;
    private Interfaz interfaz;
    public int cantidadDeSets;
    public int cantidadDeFlechas;
    Random random = new Random();
    
    public Partida(int cantidadDeSets, int cantidadDeFlechas){
        jugador1 = new Jugador(true);
        jugador2 = new Jugador(false);
        juez = new Juez();
        blanco = new Blanco();
        setCantidadDeSets(cantidadDeSets);
        setCantidadDeFlechas(cantidadDeFlechas);
        interfaz = new Interfaz("Juego");
    }
    
    public void setCantidadDeSets(int cantidadDeSets){
        this.cantidadDeSets = cantidadDeSets;
    }
    
    public void setCantidadDeFlechas(int cantidadDeFlechas){
        this.cantidadDeFlechas = cantidadDeFlechas;
    }
    
    public void jugar(){
        boolean turno = tirarMoneda(); //decide quien tira primero en la ronda - true: el usuario tira primero - false: la maquina tira primero
        for(int i = cantidadDeSets; i <= 0; --i){
            set = new Set(cantidadDeFlechas);
            for(int j = set.getFlechas(); j <= 0; --j){
                ronda(turno);
                turno = !turno;
            }
        }
        
    }
    
    public void prueba(){
        set = new Set(1);
        System.out.println(set.aplicarVientoDelSet(jugador1.tiro(1),true));
        System.out.println(set.aplicarVientoDelSet(jugador1.tiro(1),false));
        
    }
    
    public boolean tirarMoneda(){
        return random.nextBoolean();
    }
    
    public void ronda(boolean turno){
        double coordenadaXJugador1 = 0.0;
        double coordenadaYJugador1 = 0.0;
        double coordenadaXJugador2 = 0.0;
        double coordenadaYJugador2 = 0.0;
        
        if(turno == true){
            coordenadaXJugador1 = set.aplicarVientoDelSet(jugador1.tiro(1),true);
            coordenadaYJugador1 = set.aplicarVientoDelSet(jugador1.tiro(1),false);
            coordenadaXJugador2 = set.aplicarVientoDelSet(jugador2.tiro(1),true);
            coordenadaYJugador2 = set.aplicarVientoDelSet(jugador2.tiro(1),false);
        }
        else{
            
        }
    }
}
