import java.util.ArrayList;

public class Juez{
    private Blanco blanco;
    private Jugador jugador1;
    private Jugador jugador2;
    private Set set;
    private ArrayList<Set> sets;

    private int cantidadDeSets;
    

    private int puntajesRegistradosJugador1;
    private int puntajesRegistradosJugador2;

    private int puntajeMasAlto;
    

    public Juez(Blanco blanco, Jugador jugador1, Jugador jugador2, Set set){
        this.blanco = blanco;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.set = set;
        sets = new ArrayList();
        puntajesRegistradosJugador1 = 0;
        puntajesRegistradosJugador2 = 0;
    }

    public void reiniciar(){
        puntajesRegistradosJugador1 = 0;
        puntajesRegistradosJugador2 = 0;
        puntajeMasAlto = 0;
    }

    public void agregarSet(Set set){
        sets.add(set);
    }

    public void registrarPuntajeJugador1(int puntaje){
        puntajesRegistradosJugador1 += puntaje;
        jugador1.agregarPuntaje(puntaje);
    }

    public void registrarPuntajeJugador2(int puntaje){
        puntajesRegistradosJugador2 += puntaje;
        jugador2.agregarPuntaje(puntaje);
    }

    public void setPuntajeMasAlto(){
        
    }

    public String getPuntajeMasAlto(int numeroDeSet){
        Set set = sets.get(numeroDeSet-1);
        int puntanjeMasAltoXSet = set.getPuntajeMasAlto();
        return "En el set: " + numeroDeSet + " el puntaje más alto fue: " + puntanjeMasAltoXSet + " del " + set.getGanador();

    }
    //Pero, Que pasa si Dios quiere ver quien gano x set con y puntos?




}