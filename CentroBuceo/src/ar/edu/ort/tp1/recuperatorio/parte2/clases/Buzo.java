package ar.edu.ort.tp1.recuperatorio.parte2.clases;

import ar.edu.ort.tp1.recuperatorio.parte1.clases.Buceo;
import edu.ort.tp1.u5.tda.Cola;
import edu.ort.tp1.u5.tda.nodos.ColaNodos;

public abstract class Buzo implements BuceoProfundo, Bitacorado<Buceo> {

	private static final String NOMBRE_INVALIDO = "Nombre inválido";
	private static final String NACIONALIDAD_INVALIDA = "Nacionalidad inválida";
	private static final String EDAD_INVALIDA = "Un buzo no puede ser menor de edad";
	private static final int MAYOR_EDAD = 18;
	private String nombre;
	private String nacionalidad;
	private int edad;

	/**
	 * Constructor del buzo, los buzos deben tener al menos de 18 años.
	 * 
	 * @param nombre - No puede estar vacío ni ser nulo.
	 * @param nacionalidad - No puede estar vacío ni ser nulo.
	 * @param edad debe ser válida.
	 */
	public Buzo(String nombre, String nacionalidad, int edad) {
		this.setNombre(nombre);
		this.setNacionalidad(nacionalidad);
		this.setEdad(edad);
	}

	
	
	public void setNombre(String nombre) {
		if(nombre.isEmpty() || nombre == null) {
			throw new IllegalArgumentException(NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
	}

	public void setNacionalidad(String nacionalidad) {
		if(nacionalidad == null || nacionalidad.isEmpty()) {
			throw new IllegalArgumentException(NACIONALIDAD_INVALIDA);
		}
		this.nacionalidad = nacionalidad;
		
	}

	public void setEdad(int edad) {
		if(edad<MAYOR_EDAD) {
			throw new IllegalArgumentException(EDAD_INVALIDA);
		}
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {
		return "Buzo [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", edad=" + edad + "]";
	}

	public abstract boolean habilitado(int metros);

}
