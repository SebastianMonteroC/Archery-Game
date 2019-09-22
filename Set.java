public class Set{
   private Viento viento;
   public int flechas;
   public int puntajeJugador1;
   public int puntajeJugador2;
   
   public Set(int cantidadDeFlechas){
       viento = new Viento();
       setFlechas(cantidadDeFlechas);
   }
   
   public void setFlechas(int flechas){
       this.flechas = flechas;
   }
   
   public void setPuntajeJugador1(int puntajeJugador1){
       this.puntajeJugador1 = puntajeJugador1;
   }
   public void setPuntajeJugador2(int puntajeJugador2){
       this.puntajeJugador2 = puntajeJugador2;
   }
  
   public int getFlechas(){
       return flechas;
   }
   
   public int getPuntajeJugador1(){
       return puntajeJugador1;
   }
   
   public int getPuntajeJugador2(){
       return puntajeJugador2;
   }
   public double aplicarVientoDelSet(double coordenada, boolean abscisa){
       return viento.aplicarViento(coordenada, abscisa);
   }
}
