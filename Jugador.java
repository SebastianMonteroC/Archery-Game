import java.util.Random;
public class Jugador {
    public String experiencia;
    public double rangoDeErrorMinimo;
    public double rangoDeErrorMaximo;
    public boolean esHumano;
    java.util.Random random = new java.util.Random();

    
    public Jugador(boolean esHumano){
        setExperiencia(randomNivel());
        generarRango();
        setEsHumano(esHumano);
    }
    
    public void setEsHumano(boolean esHumano){
        this.esHumano = esHumano;
    }
    
    public boolean getEsHumano(){
        return esHumano;
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
    
    public String getExperiencia(){
        return experiencia;
    }
 
    public double getRangoDeErrorMinimo(){
        return rangoDeErrorMinimo;
    }
    
    public double getRangoDeErrorMaximo(){
        return rangoDeErrorMaximo;
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
