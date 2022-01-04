package ar.edu.ort.tp1.recuperatorio.parte2.clases;

import ar.edu.ort.tp1.recuperatorio.parte1.clases.Buceo;
import edu.ort.tp1.u5.tda.Pila;
import edu.ort.tp1.u5.tda.nodos.PilaNodos;

/**
 * Buzo con autorización para bajar mas alla de los 30 metros.
 *
 */
public class BuzoTecnico extends Buzo {
	
	private Pila<Buceo> bitacora;

	public BuzoTecnico(String nombre, String nacionalidad, int edad) {
		super(nombre,nacionalidad,edad);
		this.bitacora = new PilaNodos<>();
	}

	@Override
	public boolean habilitadoBuceoProfundo() {
		return true;
	}

	@Override
	public boolean habilitadoBuceoMedio() {
		return true;
	}

	@Override
	public int cantidadDeEventos() {
		int cant = 0;
		Pila<Buceo> pilaAux = new PilaNodos<>();
		Buceo aux;
		
		while(!this.bitacora.isEmpty()) {
			aux = this.bitacora.pop();
			pilaAux.push(aux);
			cant++;
		}
		pasarElementos(this.bitacora,pilaAux);
		
		return cant;
	}

	private void pasarElementos(Pila<Buceo> bitacora, Pila<Buceo> pilaAux) {
		while(!pilaAux.isEmpty()) {
			bitacora.push(pilaAux.pop());
		}
	}

	@Override
	public void agregarABitacora(Buceo t) {
		this.bitacora.push(t);
		//System.out.println(t.toString());
		
	}

	@Override
	public boolean habilitado(int metros) {
		
		return true;
	}

	//TODO A completar

}
