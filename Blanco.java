public class Blanco{
	private int puntuacion;

	public Blanco(){
		puntuacion = 0; 
	}

	public int asignarPuntuacion(Double coordenadaX, Double coordenadaY){
		if (coordenadaX > 0.4 && coordenadaY > 0.4) {
			puntuacion = 15;
		}
		else{
			if (coordenadaX > 0.05 && coordenadaY > 0.05) {
				puntuacion = 20;
			}
			else{
				puntuacion = 100;
			}
		}
		
		return puntuacion;
	}
    
}
