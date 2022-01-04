package ar.edu.ort.tp1.recuperatorio.parte2.clases;

import ar.edu.ort.tp1.recuperatorio.parte1.clases.Buceo;
import edu.ort.tp1.u5.tda.Cola;
import edu.ort.tp1.u5.tda.ListaOrdenada;
import edu.ort.tp1.u5.tda.Pila;
import edu.ort.tp1.u5.tda.nodos.ColaNodos;
import edu.ort.tp1.u5.tda.nodos.PilaNodos;

public class CentroBuceoAvanzado {

	private static final String BUCEO_INVALIDO = "Buceo Inválido";
	private static final String BUCEO_NO_DISP = "Buceo no disponible.";
	private static final String NO_HABILITADO = "Buzo no habilitado por profundidad";
	// TODO A completar atribuos.
	private ListaBuceosPorId buceosDisponibles;
	private String nombre;
	private Pila<String> logDeErrores;
	private Pila<Buzo> buzosRegistrados;

	public CentroBuceoAvanzado(String nombre) {
		// TODO A completar
		this.nombre = nombre;
		this.buceosDisponibles = new ListaBuceosPorId();
		this.logDeErrores = new PilaNodos<>();
		this.buzosRegistrados = new PilaNodos<>();
	}

	/**
	 * Se registra un buceo para un determinado buzo. si ocurre un error se registra
	 * en el log de errores, pero no se aborta la ejecución.
	 * 
	 * -El buzo no puede ser nulo.
	 * 
	 * -El buceo cuyo id se indica, debe estar en la colección de buceos disponibles.
	 * 
	 * -El buzo debe estar habilitado para realizar el buceo seleccionado.
	 * 
	 * -De poder registrar al buzo, se debe agregar el buceo a su bitacora y
	 * agregarlo a los buzos registrados, que deben estar almacenados de forma
	 * cronológica.
	 * 
	 * @param buzo    Que desea bucear.
	 * @param idBuceo Identificador del buceo que el buzo quiere hacer.
	 */
	public void registrarBuceo(Buzo buzo, Integer idBuceo) {
		Buceo buceo;
		if(!this.buceosDisponibles.exists(idBuceo)) {
			this.logDeErrores.push(BUCEO_NO_DISP);
			//System.out.println(BUCEO_NO_DISP);
		}else {
			buceo = this.buceosDisponibles.search(idBuceo);
			if(buzo != null && buzo.habilitado(buceo.getProfundidad())) {
					this.buzosRegistrados.push(buzo);
					buzo.agregarABitacora(buceo);
			}else {
				this.logDeErrores.push(NO_HABILITADO);
				//System.out.println(NO_HABILITADO);
			}
		}
		
	}

	public void agregarBuceo(Buceo b) {
		if(b == null) {
			throw new IllegalArgumentException(BUCEO_INVALIDO);
		}else {
			this.buceosDisponibles.add(b);
		}
		
	}

	public void listarErroresCronologico() {
		System.out.println("Mostrando errores en forma cronoógica");
		
		Cola<String> cronologico = mostrarCronologico();
		String cent = "@";
		String aux;
		
		cronologico.add(cent);
		aux = cronologico.remove();
		
		while(aux != cent) {
			System.out.println(aux);
			cronologico.add(aux);
			aux = cronologico.remove();
		}
		
		System.out.println("------------------");
	}


	private Cola<String> mostrarCronologico() {
		Cola<String> cola = new ColaNodos<>();
		Pila<String> pilaAux = new PilaNodos<>();
		
		while(!this.logDeErrores.isEmpty()) {
			pilaAux.push(this.logDeErrores.pop());
		}
		while(!pilaAux.isEmpty()) {
			cola.add(pilaAux.pop());
		}
		
		return cola;
	}
	

	public void mostrarCantidadDeBuceosPorBuzoRegistrado() {
		// TODO A completar
		System.out.println("Cantidad de buceos realizados por los buzos registrados en " + this.nombre);
		
		Pila<Buzo> pilaAux = new PilaNodos<>();
		
		Buzo aux;
		
		while(!this.buzosRegistrados.isEmpty()) {
			aux = this.buzosRegistrados.pop();
			pilaAux.push(aux);
			System.out.println("--El buzo " + aux.toString() + " realizó " + aux.cantidadDeEventos() + " buceos según su bitácora");
			
		}
	
	}
}
