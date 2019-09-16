import java.util.Random;

public class Viento {
    public String intensidad;
    public double rangoDeVientoMinimo;
    public double rangoDeVientoMaximo;
    public double valorActualDeViento;
    public double direccionDeViento;
    java.util.Random random = new java.util.Random();
    
    public Viento(){
        setIntensidad(randomIntensidad());
        sacarRango();
        intensidadVientoAleatorio();
        direccionVientoAleatorio();
    }
    
    public void setIntensidad(String intensidad){
        this.intensidad = intensidad;
    }
    
    public void setRangoDeVientoMinimo(double rangoDeVientoMinimo){
        this.rangoDeVientoMinimo = rangoDeVientoMinimo;
    }
    
    public void setRangoDeVientoMaximo(double rangoDeVientoMaximo){
        this.rangoDeVientoMaximo = rangoDeVientoMaximo;
    }
    
    public void setDireccionDeViento(double direccionDeViento){
        this.direccionDeViento = direccionDeViento;
    }
    
    public void setValorActualDeViento(double valorActualDeViento){
        this.valorActualDeViento = valorActualDeViento;
    }
    
    public String getIntensidad(){
        return intensidad;
    }
    
    public double getRangoDeVientoMinimo(){
        return rangoDeVientoMinimo;
    }
    
    public double getRangoDeVientoMaximo(){
        return rangoDeVientoMaximo;
    }
    
    public double getDireccionDeViento(){
        return direccionDeViento;
    }
    
    public double getValorActualDeViento(){
        return valorActualDeViento;
    }
    
    public String randomIntensidad(){
        String[] intensidadesDisponibles = {"Leve","Moderado","Fuerte"};
        int intensidadAleatoria = random.nextInt(intensidadesDisponibles.length);
        String aleatorioObtenido = intensidadesDisponibles[intensidadAleatoria];
        return aleatorioObtenido;
    }
    
    public void sacarRango(){
        int rangoDeFinal = 0;
        switch (intensidad) {
            case "Leve":
                setRangoDeVientoMinimo(0.0);
                setRangoDeVientoMaximo(0.2);
            break;
            case "Moderado":
                setRangoDeVientoMinimo(0.0);
                setRangoDeVientoMaximo(0.5);
            break;
            case "Fuerte":
                setRangoDeVientoMinimo(0.0);
                setRangoDeVientoMaximo(1.0);
            break;
        }

    }
    
    public void intensidadVientoAleatorio(){
        double valorAleatorio = new Random().nextDouble();
        double valorAleatorioEnRango = rangoDeVientoMinimo + (valorAleatorio * (rangoDeVientoMaximo - rangoDeVientoMinimo));
        setValorActualDeViento(valorAleatorioEnRango); 
    }
    
    public void direccionVientoAleatorio(){
        double direccionAleatoria = new Random().nextDouble();
        double direccionAleatoriaEnRango = 0.0 + (direccionAleatoria * (2*Math.PI - 0.0));
        setDireccionDeViento(direccionAleatoriaEnRango);
    }
    
    public double aplicarViento(double coordenada, boolean abscisas){
        intensidadVientoAleatorio();
        if(abscisas){ //si es coordenada X, se aplica el coseno
            coordenada = coordenada + valorActualDeViento * Math.cos(direccionDeViento);
    }
        else{ //Si no es X, es Y y se aplica seno
            coordenada = coordenada + valorActualDeViento * Math.sin(direccionDeViento);
    }
        return coordenada;
    }
}
