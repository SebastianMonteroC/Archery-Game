public class Blanco{
	private int puntuacion;
	private Double pundoDeCaida;

	public Blanco(){
		puntuacion = 0; 
		pundoDeCaida = 0.0;
	}

	public int asignarPuntuacion(Double coordenadaX, Double coordenadaY){
		pundoDeCaida = Math.sqrt(Math.pow(coordenadaX-1,2) + Math.pow(coordenadaY-1,2));

		if (pundoDeCaida > 0.4) {
			puntuacion = 15;
		}
		else{
			if (pundoDeCaida > 0.05) {
				puntuacion = 20;
			}
			else{
				puntuacion = 100;
			}
		}
		return puntuacion;
	}  
}
