import java.util.Random;
public class Jugador {
    public String experiencia;
    public double rangoDeErrorMinimo;
    public double rangoDeErrorMaximo;
    public boolean esHumano;
    private int puntaje;
    private int setsGanados;
    java.util.Random random = new java.util.Random();

    
    public Jugador(boolean esHumano){
        setExperiencia(randomNivel());
        generarRango();
        setEsHumano(esHumano);
        puntaje = 0;
        setsGanados = 0;
    }
    
    public void setEsHumano(boolean esHumano){
        this.esHumano = esHumano;
    }
    
    public void setExperiencia(String experiencia){
        this.experiencia = experiencia;
    }
    
    public void setRangoDeErrorMinimo(double rangoDeErrorMinimo){
        this.rangoDeErrorMinimo = rangoDeErrorMinimo;
    }
    
    public void setRangoDeErrorMaximo(double rangoDeErrorMaximo){
        this.rangoDeErrorMaximo = rangoDeErrorMaximo;
    }

    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }

    public void setSetsGanados(int setsGanados){
        this.setsGanados = setsGanados;
    }
    
    public String getExperiencia(){
        return experiencia;
    }
 
    public double getRangoDeErrorMinimo(){
        return rangoDeErrorMinimo;
    }
    
    public double getRangoDeErrorMaximo(){
        return rangoDeErrorMaximo;
    }

    public int getPuntaje(){
        return puntaje;
    }
    
    public int getSetsGanados(){
        return setsGanados;
    }
    
    public void agregarPuntaje(int puntaje){
        this.puntaje += puntaje;
    }

    
    public String randomNivel(){
        String[] nivelesDisponibles = {"Novato","Intermedio","Profesional"};
        int nivelAleatorio = random.nextInt(nivelesDisponibles.length);
        String aleatorioObtenido = nivelesDisponibles[nivelAleatorio];
        return aleatorioObtenido;
    }
    
    public void generarRango(){
        double rangoFinal = 0;
        switch (experiencia) {
            case "Novato":
                setRangoDeErrorMinimo(-1.0);
                setRangoDeErrorMaximo(1.0);
            break;
            case "Intermedio":
                setRangoDeErrorMinimo(-0.25);
                setRangoDeErrorMaximo(0.25);
            break;
            case "Profesional":
                setRangoDeErrorMinimo(-0.05);
                setRangoDeErrorMaximo(0.05);
            break;
        }
    }
    
    public double falloAleatorio(){
        double valorAleatorio = new Random().nextDouble();
        double valorAleatorioEnRango = rangoDeErrorMinimo + (valorAleatorio * (rangoDeErrorMaximo - rangoDeErrorMinimo));
        return valorAleatorioEnRango; 
    }
    
    public double tiro(double coordenada){
        double coordenadaConError = coordenada + falloAleatorio();
        return coordenadaConError;
    }
}
