public class Blanco{
    public int puntaje;
    public double radioDelBlancoMayor;
    public double radioDelBlancoIntermedio;
    public double radioDelBlancoMenor;
    public double centroX;
    public double centroY;


    
    public Blanco(){
        setPuntaje(0);
        centroX = 1;
        centroY = 1;
        radioDelBlancoMayor = 1;
        radioDelBlancoIntermedio = 0.5;
        radioDelBlancoMenor = 0.1;
    }
    
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    
    
    public int sacarPuntaje(double coordenadaX, double coordenadaY){
        if(Math.sqrt(Math.pow((coordenadaX - 1),2) + Math.pow((coordenadaY - 1),2)) > radioDelBlancoMayor){
            setPuntaje(0);
        }
        else{
            if(Math.sqrt(Math.pow((coordenadaX - 1),2) + Math.pow((coordenadaY - 1),2))  > radioDelBlancoIntermedio){
                setPuntaje(15);
            }
            else{
                if(Math.sqrt(Math.pow((coordenadaX - 1),2) + Math.pow((coordenadaY - 1),2)) > radioDelBlancoMenor){
                    setPuntaje(20);
                }
                else{
                    setPuntaje(100);
                }
            }
        }
        return puntaje;
    }
}
