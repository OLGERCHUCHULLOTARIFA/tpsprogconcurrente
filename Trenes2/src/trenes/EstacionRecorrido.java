package trenes;

import estadosYSentidos.Sentido;
import estadosYSentidos.SentidoPasajero;
import estadosYSentidos.SentidoPasajeroA;
import estadosYSentidos.SentidoPasajeroB;

public class EstacionRecorrido {
	
	public EstacionConcreta estacionConcreta;
	public EstacionRecorrido sigEstRecSenA;
	public EstacionRecorrido sigEstRecSenB;
	public Sentido sentidoA;
	public Sentido sentidoB;
	
	public EstacionRecorrido(EstacionConcreta estacion){
		this.estacionConcreta = estacion;
		this.sentidoA = Sentido.getA();
		this.sentidoB = Sentido.getB();
	}
	
	public String getNombre(){
		return this.estacionConcreta.nombre;
	}

	public SentidoPasajero sentidoMasCortoHasta(EstacionConcreta estacionDestino) {
		if(this.cantidadEstacionesSentido(estacionDestino, this.sentidoA) >  this.cantidadEstacionesSentido(estacionDestino, this.sentidoB)){
			return new SentidoPasajeroB();			
		}
		return new SentidoPasajeroA();			
	}

	public Integer cantidadEstacionesSentido(EstacionConcreta estacionDestino,
			Sentido sentido) {
		if(estacionDestino.equals(this.estacionConcreta)){
			throw new RuntimeException("Pap� ya est�s en esta estacion");			
		}
		EstacionRecorrido estacionDestinoR = estacionDestino.estacionRecorrido;
		EstacionRecorrido estacionsiguiente = sentido.siguienteEstacion(this);
		
		Integer distancia = 1;
		
		while(!estacionDestinoR.equals(estacionsiguiente)){
			distancia ++;
			estacionsiguiente = sentido.siguienteEstacion(estacionsiguiente);
			if(estacionsiguiente.equals(this)){
				throw new RuntimeException("Pap�, esa estaci�n no esta en este recorrido");			
			}
		}
		
		return distancia;
	}
}
