import java.util.Random;
public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private Set set;
    private Juez juez;
    private Blanco blanco;
    private Interfaz interfaz;
    private Partida partida;
    private int cantidadDeSets;
    private int cantidadDeFlechas;
   
    
    Random random = new Random();
    
    public Partida(int cantidadDeSets, int cantidadDeFlechas, Interfaz interfaz){
        jugador1 = new Jugador(true);
        jugador2 = new Jugador(false);
        juez = new Juez(blanco,jugador1,jugador2,set);
        blanco = new Blanco();
        this.interfaz = interfaz;
        setCantidadDeSets(cantidadDeSets);
        setCantidadDeFlechas(cantidadDeFlechas);
    }
    
    public void setCantidadDeSets(int cantidadDeSets){
        this.cantidadDeSets = cantidadDeSets;
    }
    
    public void setCantidadDeFlechas(int cantidadDeFlechas){
        this.cantidadDeFlechas = cantidadDeFlechas;
    }
    
    public void jugar(){
        String ganador = "";
        boolean turno = tirarMoneda(); //decide quien tira primero en la ronda - true: el usuario tira primero - false: la maquina tira primero
        int setNumero = 1;
        for(int i = cantidadDeSets; i > 0; --i){
            set = new Set(cantidadDeFlechas);
            interfaz.mensaje("Set: " + setNumero);
            setNumero++;
            int rondaNumero = 1;
            for(int j = set.getFlechas(); j > 0; --j){
                interfaz.mensaje("Ronda: " + rondaNumero + "\nEs el turno del jugador " + turnoDeJugador(turno));
                rondaNumero++;
                ronda(turno);
                turno = !turno;
            }
            interfaz.mensaje(juez.definirGanadorDeSet());
            juez.reiniciarSet();
            //se registra quien gano el set en la clase Juez
        }
        ganador = juez.definirGanadorDePartida();
        interfaz.mensaje(ganador);
        if(ganador == "Empate"){
            desempate();
        }
        verificarHighScore();
        //se registra quien gano la partida en la clase Juez
    }
    
    public String verificarHighScore(){
        String puntajeMasAlto = "" + juez.getPuntajeMasAlto();
        if(jugador1.getPuntaje() > juez.getValorDePuntajeMasAlto()){
            puntajeMasAlto = juez.verificarPuntaje(jugador1.getPuntaje(),interfaz.ingresarNombre());
        }
        return juez.getPuntajeMasAlto();
    }
    
    public void desempate(){
        interfaz.mensaje("MUERTE SUBITA: EL PRIMERO EN SACAR UNA CALIFICACION MAYOR GANA");
        boolean hayGanador = false;
        boolean turno = tirarMoneda();
        int tiro1 = 0;
        int tiro2 = 0;
        while(!hayGanador){
            tiro1 = realizarTiro(jugador1);
            tiro2 = realizarTiro(jugador2);
            hayGanador = juez.compararTiros(tiro1,tiro2);      
        }
        
        if(tiro1 > tiro2){
            interfaz.mensaje("FELICIDADES! Ha ganado en desempate.");
        }
        else{
            interfaz.mensaje("Press F to pay respects... Ha perdido en desempate");
        }
        
    }
    
    public int realizarTiro(Jugador jugador){
        double coordenadaX = 0;
        double coordenadaY = 0;
        int puntaje = 0;
        if(jugador.getEsHumano()){
            double[] coordenadasRecibidas = interfaz.ingresarCoordenadas();
            coordenadaX = jugador.tiro(coordenadasRecibidas[0]);
            coordenadaY = jugador.tiro(coordenadasRecibidas[1]);
        
            coordenadaX = set.aplicarVientoDelSet(coordenadaX,true);
            coordenadaY = set.aplicarVientoDelSet(coordenadaY,false);
            
            puntaje = blanco.sacarPuntaje(coordenadaX, coordenadaY);
            interfaz.mensaje("Jugador 1\nCoordenada X: " + coordenadaX + "- CoordenadaY: " + coordenadaY + "\n Gana " + puntaje + " puntos por el tiro");
        }
        else{
            coordenadaX = jugador.tiroAutomatico();
            coordenadaY = jugador.tiroAutomatico();
            
            coordenadaX = set.aplicarVientoDelSet(coordenadaX,true);
            coordenadaY = set.aplicarVientoDelSet(coordenadaY,false);
            
            puntaje = blanco.sacarPuntaje(coordenadaX,coordenadaY);
            interfaz.mensaje("Jugador 2\nCoordenada X: " + coordenadaX + "CoordenadaY: " + coordenadaY + "\n Gana " + puntaje + "puntos por el tiro");
        }
        
        return puntaje;
        
    }
    
    public boolean tirarMoneda(){
        return random.nextBoolean();
    }
    
    public void ronda(boolean turno){
        int resultadoDeTiroJugador1;
        int resultadoDeTiroJugador2;

        if(turno == true){
            juez.registrarPuntajeJugador1(realizarTiro(jugador1));
            juez.registrarPuntajeJugador2(realizarTiro(jugador2));
        }
        else{
            juez.registrarPuntajeJugador2(realizarTiro(jugador2));
            juez.registrarPuntajeJugador1(realizarTiro(jugador1));
        }
    }
    
    public int turnoDeJugador(boolean turno){
        int turnoDeJugador = 2;
        if(turno){
            turnoDeJugador = 1;
        }
        return turnoDeJugador;
    }
}
