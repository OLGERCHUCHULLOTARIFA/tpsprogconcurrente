package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para simular los recorridos
 * @author Tyno
 *
 */
public class Simulador {

	
	public static void main(String[] args) {
		//Creo las listas de Recorridos y le agrego las estacion creadas.
		List<Estacion> recorridoNormal=new ArrayList<Estacion>();
		List<Estacion> recorridoInverso=new ArrayList<Estacion>();
		Estacion peñarol= new Estacion("Peñarol");
		Estacion berazategui= new Estacion("Berazategui");
		Estacion keleti= new Estacion("Keleti");
		recorridoNormal.add(berazategui);
		recorridoNormal.add(peñarol);
		recorridoNormal.add(keleti);
		recorridoInverso.add(keleti);
		recorridoInverso.add(peñarol);
		recorridoInverso.add(berazategui);
		
		
		//Creo Los trenes e inicio la simulacion.
		Tren belgrano= new Tren("Belgrano", recorridoNormal);
		Tren roca= new Tren("Roca", recorridoInverso);
		belgrano.start();
		roca.start();
	}
	
}
