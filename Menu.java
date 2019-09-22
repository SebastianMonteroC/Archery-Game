public class Menu {
    private Partida partida;
    public int setsIngresados;
    public int flechasIngresadas;
    
    public Menu(){
        setsIngresados = 2;
        flechasIngresadas = 3;
    }
    
    public void iniciarJuego(){
        Partida partida = new Partida(setsIngresados, flechasIngresadas);
        partida.jugar();
    }
    
    public void cambiarSets(int sets){
        setsIngresados = sets;
    }
    
    public void cambiarFlechas(int flechas){
        flechasIngresadas = flechas;
    }
    
}
