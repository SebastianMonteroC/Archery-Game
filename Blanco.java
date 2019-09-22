public class Blanco{
    public int puntaje;
    public double radioDelBlancoMayor;
    public double radioDelBlancoIntermedio;
    public double radioDelBlancoMenor;


    
    public Blanco(){
        setPuntaje(0);
        radioDelBlancoMayor = 1;
        radioDelBlancoIntermedio = 0.5;
        radioDelBlancoMenor = 0.1;
    }
    
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }

    
    public int sacarPuntaje(int coordenadaX, int coordenadaY){
        
        return puntaje;
    }
}
