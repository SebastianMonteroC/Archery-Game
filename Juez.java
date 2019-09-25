import java.util.ArrayList;

public class Juez{
    private Blanco blanco;
    private Jugador jugador1;
    private Jugador jugador2;
    private Set set;

    private int cantidadDeSets;
    private int puntajePorSetJ1 = 0;
    private int puntajePorSetJ2 = 0;
    private int puntajeDePartidaJ1 = 0;
    private int puntajeDePartidaJ2 = 0;
    private int setsGanadosJ1 = 0;
    private int setsGanadosJ2 = 0;
    private int puntajeMasAlto;
    private String puntajeMasAltoConNombre;
    

    public Juez(Blanco blanco, Jugador jugador1, Jugador jugador2, Set set){
        this.blanco = blanco;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.set = set;

        
    }

    public void reiniciarSet(){
        puntajePorSetJ1 = 0;
        puntajePorSetJ2 = 0;
    }
    
    public int reiniciarPuntajeMasAlto(){
        puntajeMasAlto = 0;
        puntajeMasAltoConNombre = "nadie. No se ha jugado";
        return puntajeMasAlto;
    }

    public void registrarPuntajeJugador1(int puntaje){
        puntajePorSetJ1 += puntaje;
        puntajeDePartidaJ1 += puntaje;
        jugador1.agregarPuntaje(puntaje);
    }

    public void registrarPuntajeJugador2(int puntaje){
        puntajePorSetJ2 += puntaje;
        puntajeDePartidaJ2 += puntaje;
        jugador2.agregarPuntaje(puntaje);
    }
    
    public int getValorDePuntajeMasAlto(){
        return puntajeMasAlto;
    }
    public String getPuntajeMasAlto(){
        return puntajeMasAltoConNombre;
    }

    public String verificarPuntaje(int puntaje,String nombre){
        if(puntaje > puntajeMasAlto){
            puntajeMasAlto = puntaje;
            puntajeMasAltoConNombre = nombre + " con " + puntaje + " puntos.";
        }
        return puntajeMasAltoConNombre;
    }
    
    public String definirGanadorDeSet(){
        String ganador = "";
        if(puntajePorSetJ1 > puntajePorSetJ2){
            ganador = "Gana el jugador 1 con " + puntajePorSetJ1 + " puntos.\nEl jugador 2 tuvo " + puntajePorSetJ2 + " puntos.";
            setsGanadosJ1 += 1;
        }
        else{
            if(puntajePorSetJ2 > puntajePorSetJ1){
                ganador = "Gana el jugador 2 con " + puntajePorSetJ2 + " puntos.\nEl jugador 1 tuvo " + puntajePorSetJ1 + " puntos.";
                setsGanadosJ2 += 1;
            }
            else{
                if(puntajePorSetJ2 == puntajePorSetJ1){
                    ganador = "Empate. Ambos jugadores tuvieron: " + puntajePorSetJ1 + " puntos.";
                }
            }
        }
        return ganador;
    }
    
    public String definirGanadorDePartida(){
        String ganadorPartida = "";
        if(setsGanadosJ1 > setsGanadosJ2){
            ganadorPartida = "FELICIDADES!\nGana la partida el jugador 1 con " + puntajeDePartidaJ1 + " puntos.\nEl jugador 2 tuvo " + puntajeDePartidaJ2 + " puntos.";
        }
        else{
            if(setsGanadosJ2 > setsGanadosJ1){
                ganadorPartida = "F to pay respects...\nGana la partida el jugador 2 con " + puntajeDePartidaJ2 + " puntos.\nEl jugador 1 tuvo " + puntajeDePartidaJ1 + " puntos.";

            }
            else{
                if(setsGanadosJ2 == setsGanadosJ1){
                    ganadorPartida = "Empate";                    
                }
            }
        }
        return ganadorPartida;
    }
    
    public boolean compararTiros(int puntajeJ1, int puntajeJ2){
        boolean hayGanador = false;
        if(puntajeJ1 > puntajeJ2){
            hayGanador = true;
        }
        else{
            if(puntajeJ2 > puntajeJ1){
                hayGanador = true;
            }
        }
        return hayGanador;
    }
    
    public String devolverGanadorDesempate(String jugador){
        return "Ha ganado el jugador " + jugador;
    }
    

}