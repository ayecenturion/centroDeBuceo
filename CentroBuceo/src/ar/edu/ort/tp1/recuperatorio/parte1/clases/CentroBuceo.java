package ar.edu.ort.tp1.recuperatorio.parte1.clases;

import java.util.ArrayList;

public class CentroBuceo {

	private static final int CANTIDAD_BUCEOS = 10;
	private Buceo[] puntosDeBuceo;
	private String nombre;
	private int[][] reservasCargadas;
	private int cantReservas;

	public CentroBuceo(String nombre) {
		this.nombre = nombre;
		puntosDeBuceo = new Buceo[CANTIDAD_BUCEOS];
		cargarBuceos();
		reservasCargadas = new int[Mes.values().length][CANTIDAD_BUCEOS];
	}
	
	

	private void cargarBuceos() {
		puntosDeBuceo[5] = new Buceo(6, "Isla Victoria", 18);
		puntosDeBuceo[1] = new Buceo(2, "Dique Piedras Moras", 23);
		puntosDeBuceo[7] = new Buceo(8, "Parque Nacional de Tierra del Fuego", 20);
		puntosDeBuceo[3] = new Buceo(4, "Los Reyunos", 25);
		puntosDeBuceo[0] = new Buceo(1, "Dique Segunda Usina", 35);
		puntosDeBuceo[9] = new Buceo(10, "Puerto Madryn", 30);
		puntosDeBuceo[4] = new Buceo(5, "Nahuel Huapi", 22);
		puntosDeBuceo[6] = new Buceo(7, "Golfo San Matías", 30);
		puntosDeBuceo[8] = new Buceo(9, "Pirámides", 25);
		puntosDeBuceo[2] = new Buceo(3, "Bosque sumergido de Villa Traful", 20);
	
	}

	/**
	 * Carga las reservas pasadas por parámetro en la estructura correspondiente del centro de buceo.
	 * @param reservas
	 */
	public void cargarReservas(ArrayList<Reserva> reservas) {
		int cant = 0;
		for (Reserva r : reservas) {
			reservasCargadas[r.getMes().ordinal()][r.getIdBuceo()-1] = cant + 1;
		}
		setCantReservas(reservas.size());
		System.out.println("Se procesaron " + reservas.size() + " reservas");
		
	}

	private void setCantReservas(int cantReservas) {
		this.cantReservas = cantReservas;
	}



	public void mostrarEstadisticas() {
		System.out.println("Estadisticas del centro de buceo: " + nombre);

		this.mostrarCantidadDeReservasPorMes();
		this.mostrarPromedioDeReservasPorBuceo();

	}

	private void mostrarCantidadDeReservasPorMes() {
		int cant = 0;
		System.out.println();
		System.out.println("---Cantidad de reservas por mes---");
		for (int i = 0; i < reservasCargadas.length; i++) {
			for (int j = 0; j < reservasCargadas[i].length; j++) {
				cant += reservasCargadas[i][j];
			}
			System.out.println("Reservas mes " + (i+1) + " : " + cant);
			cant = 0;
		}

	}

	private void mostrarPromedioDeReservasPorBuceo() {
		int cant = 0;
		
		System.out.println();
		System.out.println("---Promedio de reservas por punto de buceo---");
		for (int j = 0; j < reservasCargadas[0].length; j++) {
			for (int i = 0; i < reservasCargadas.length; i++) {
				cant += reservasCargadas[i][j];
			}
			System.out.println("Punto " + puntosDeBuceo[j].getNombrePuntoBuceo() + " " + (double) cant/puntosDeBuceo.length);
			cant = 0;
		}
	}

	public void mostrarCantidadMesesConReservasPorNombreBuceo(String nombreBuceo) {
		int idBuceo = obtenerIdPorNombre(nombreBuceo);
		int cant = 0;
		if(idBuceo != -1) {
			cant = obtenerCant(idBuceo);
			System.out.println("El buceo " + puntosDeBuceo[idBuceo] + " tiene " + cant + " reservas.");
		}else {
			System.out.println("Buceo no encontrado");
		}
	}
	
	private int obtenerCant(int idBuceo) {
		int cant = 0;
		for (int i = 0; i < reservasCargadas.length; i++) {
				cant += reservasCargadas[i][idBuceo];
		}
		return cant;
	}

	private int obtenerIdPorNombre(String nombreBuceo) {
		int id = -1;
		boolean encontrado = false;
		int i=0;
		
		while(i<puntosDeBuceo.length && !encontrado) {
			if (puntosDeBuceo[i].getNombrePuntoBuceo().equals(nombreBuceo)) {
				encontrado=true;
				id=i;
			}else {
				i++;
			}
			
		}
		
		return id;
	}



	public void mostrarCantidadBuceosConReservasPorNombreMes(String nombreMes) {
		int posMes = obtenerPosPorNombre(nombreMes);
		
		int cant = 0;
		if(posMes != -1) {
			cant = obtenerCantBuceos(posMes);
			System.out.println("El mes de " + nombreMes + " tiene " + cant + " reservas.");
		}else {
			System.out.println("Mes no encontrado");
		}
	}



	private int obtenerCantBuceos(int posMes) {
		int cant = 0;
		
		for (int i = 0; i < reservasCargadas[posMes].length; i++) {
			cant += reservasCargadas[posMes][i];
		}
		
		return cant;
	}



	private int obtenerPosPorNombre(String nombreMes) {
		int pos = -1;
		boolean encontrado = false;
		int i=0;
		Mes[] meses = Mes.values();
		
		while(i<meses.length && !encontrado) {
			if (meses[i].name().equalsIgnoreCase(nombreMes)) {
				encontrado=true;
				pos=i;
			}else {
				i++;
			}
		}
		
		return pos;
	}

}
