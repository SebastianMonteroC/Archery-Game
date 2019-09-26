import java.util.Random;
public class Jugador {
    private String experiencia;
    private double rangoDeErrorMinimo;
    private double rangoDeErrorMaximo;
    private boolean esHumano;
    private int puntaje;
    private int setsGanados;
    private int estrategia;
    private double tiroAnterior;
    java.util.Random random = new java.util.Random();

    
    public Jugador(boolean esHumano){
        setExperiencia(randomNivel());
        generarRango();
        setEsHumano(esHumano);
        puntaje = 0;
        setsGanados = 0;
        estrategia = generarEstrategiaAleatoria();
        tiroAnterior = 1;
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
    
    public int generarEstrategiaAleatoria(){
        int estrategia = (int)((Math.random()*3)+1);
        return estrategia;
    }
    
    public double tiroAutomatico(){
        double tiro = 1;
        switch(estrategia){
            case 1:
                tiro = estrategia1() + falloAleatorio();
            break;
            case 2:
                
            break;
            case 3:
                tiro = estrategia3() + falloAleatorio();
            break;
        }
        tiroAnterior = tiro;
        return tiro;
    }
    
    public double estrategia1(){
        double coordenada = 1;
        coordenada += Math.random()*0.50;
        return coordenada;
    }
    
    public double estrategia3(){
        double coordenada = 1.0;
        double coordenadaAleatoria = (int) Math.random(3)+1;
        switch(coordenadaAleatoria){
            case 1:
                coordenada = 1.0;
            break;
            case 2:
                coordenada = 0.5;
            break; 
            case 3:
                coordenada = -0.5;
            break; 
        }
        return coordenada;
    }
}
