
public class Partida {
    private Jugador jugador1;
    private Jugador jugador2;
    private Set set;
    private Juez juez;
    private Blanco blanco;
    public int cantidadDeSets;
    
    public Partida(){
        jugador1 = new Jugador();
        jugador2 = new Jugador();
        juez = new Juez();
        blanco = new Blanco();
        setCantidadDeSets(2);
    }
    
    public void setCantidadDeSets(int cantidadDeSets){
        this.cantidadDeSets = cantidadDeSets;
    }
    
    public void jugar(){
        boolean turno = true;
        for(int i = cantidadDeSets; i <= 0; --i){
            set = new Set();
                for(int j = set.getFlechas(); j <= 0; --j){
                    set.aplicarVientoDelSet(jugador1.tiro(1),true);
                    set.aplicarVientoDelSet(jugador1.tiro(1),false);

                }
        }
        
    }
    public void prueba(){
        set = new Set();
        System.out.println(set.aplicarVientoDelSet(jugador1.tiro(1),true));
        System.out.println(set.aplicarVientoDelSet(jugador1.tiro(1),false));
        
    }
    
    
    
    
    
   
}
