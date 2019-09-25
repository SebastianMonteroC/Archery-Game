public class Menu {
    private static Partida partida;
    private Interfaz interfaz;
    public int setsIngresados;
    public int flechasIngresadas;
    public String highScore;
    
    public Menu(){
        setsIngresados = 2;
        flechasIngresadas = 3;
        highScore = "nadie. No se ha jugado";
    }
    
    public void setInterfaz(Interfaz interfaz){
        this.interfaz = interfaz;
    }
    
    public int getSets(){
        return setsIngresados;
    }
    
    public int getFlechas(){
        return flechasIngresadas;
    }
    
    public void iniciarJuego(){
        partida = new Partida(setsIngresados, flechasIngresadas, interfaz);
        partida.jugar();
        highScore = partida.verificarHighScore();
    }
    
    public void cambiarSets(int setsIngresados){
        this.setsIngresados = setsIngresados;
        highScore = "nadie. No se ha jugado.";
    }
    
    public void cambiarFlechas(int flechasIngresadas){
        this.flechasIngresadas = flechasIngresadas;
        highScore = "nadie. No se ha jugado.";
    }
    

}
