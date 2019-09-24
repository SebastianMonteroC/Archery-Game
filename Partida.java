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
        blanco = new Blanco();
        set = new Set(cantidadDeFlechas);
        juez = new Juez(blanco,jugador1,jugador2,set);
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

    public int getCantidadDeSets(){
        return cantidadDeSets;
    }
    
    public void jugar(){
        boolean turno = tirarMoneda(); //decide quien tira primero en la ronda - true: el usuario tira primero - false: la maquina tira primero
        for(int i = cantidadDeSets; i <= 0; --i){
            
            for(int j = set.getFlechas(); j <= 0; --j){
                ronda(turno);
                turno = !turno;
            }
        }
        
    }
    
    public void prueba(){
        double coordenadaXJugador1 = set.aplicarVientoDelSet(jugador1.tiro(1),true);
        double coordenadaYJugador1 = set.aplicarVientoDelSet(jugador1.tiro(1),false);
        System.out.println(coordenadaXJugador1);
        System.out.println(coordenadaYJugador1);
       
        int pinga = blanco.sacarPuntaje(coordenadaXJugador1,coordenadaYJugador1);
        
        juez.registrarPuntajeJugador1(pinga); 
        System.out.println(juez.getPuntajeMasAlto(1));
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
