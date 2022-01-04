package ar.edu.ort.tp1.recuperatorio.parte2;

import ar.edu.ort.tp1.recuperatorio.parte1.clases.Buceo;
import ar.edu.ort.tp1.recuperatorio.parte2.clases.BuzoAdvancedOpenWater;
import ar.edu.ort.tp1.recuperatorio.parte2.clases.BuzoOpenWater;
import ar.edu.ort.tp1.recuperatorio.parte2.clases.BuzoTecnico;
import ar.edu.ort.tp1.recuperatorio.parte2.clases.CentroBuceoAvanzado;

public class Parte2 {

	public static void main(String[] args) {
		System.out.println("Recuperatorio TP1 - Parte 2 - Segundo Parcial");
		CentroBuceoAvanzado cba = new CentroBuceoAvanzado("ORT Advanced Diving Center");

		System.out.println("Se Agregan buceos");
		agregarBuceos(cba);

		System.out.println("Se registran buceadores");
		registrarBuceadores(cba);
		
		System.out.println("Listados");
		cba.listarErroresCronologico();
		cba.mostrarCantidadDeBuceosPorBuzoRegistrado();
	}

	private static void agregarBuceos(CentroBuceoAvanzado cba) {

		agregarBuceo(cba, new Buceo(6, "Isla Victoria", 18));
		agregarBuceo(cba, new Buceo(2, "Dique Piedras Moras", 23));
		agregarBuceo(cba, new Buceo(8, "Parque Nacional de Tierra del Fuego", 20));
		agregarBuceo(cba, new Buceo(4, "Los Reyunos", 25));
		agregarBuceo(cba, null);
		agregarBuceo(cba, new Buceo(1, "Dique Segunda Usina", 35));
		agregarBuceo(cba, new Buceo(10, "Puerto Madryn", 30));
		agregarBuceo(cba, new Buceo(5, "Nahuel Huapi", 22));
		agregarBuceo(cba, new Buceo(7, "Golfo San Matías", 30));
		agregarBuceo(cba, new Buceo(9, "Pirámides", 25));
		agregarBuceo(cba, new Buceo(3, "Bosque sumergido de Villa Traful", 20));
	}

	private static void agregarBuceo(CentroBuceoAvanzado cba, Buceo b) {
		//TODO COMPLETAR
		try {
			cba.agregarBuceo(b);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void registrarBuceadores(CentroBuceoAvanzado cba) {
		registrarBuceadorOpenWater(cba, "Juan", "Argentino", 23, 3);
		registrarBuceadorOpenWater(cba, "John", "Norteamericano", 16, 1);
		registrarBuceadorOpenWater(cba, "Catalina", "Argentina", 23, 5);
		registrarBuceadorOpenWater(cba, "Catalina", "Argentina", 23, 10);

		registrarBuceadorAdvanced(cba, "Esteban", "Argentino", 23, 3);
		registrarBuceadorAdvanced(cba, "", "Chileno", 23, 3);
		registrarBuceadorAdvanced(cba, "Ricardo", "Español", 23, 7);
		registrarBuceadorAdvanced(cba, "Juana", null, 23, 7);
		registrarBuceadorAdvanced(cba, "Carolina", "Argentina", 23, 1);

		registrarBuceadorTecnico(cba, "Maximiliano", "Argentino", 23, 1);
		registrarBuceadorTecnico(cba, "Maximiliano", "Argentino", 23, 144);
		registrarBuceadorTecnico(cba, "Juana", "Argentina", 23, 2);
		registrarBuceadorTecnico(cba, "Josefa", "Argentino", 23, 7);
	}

	private static void registrarBuceadorOpenWater(CentroBuceoAvanzado cba, String nombre, String nacionalidad,
			int edad, int idBuceo) {
		//TODO COmpletar
		try {
			cba.registrarBuceo(new BuzoOpenWater(nombre, nacionalidad, edad), idBuceo);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void registrarBuceadorAdvanced(CentroBuceoAvanzado cba, String nombre, String nacionalidad, int edad,
			int idBuceo) {
		//TODO COmpletar
		try {
			cba.registrarBuceo(new BuzoAdvancedOpenWater(nombre, nacionalidad, edad), idBuceo);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void registrarBuceadorTecnico(CentroBuceoAvanzado cba, String nombre, String nacionalidad, int edad,
			int idBuceo) {
		
//		TODO COMPLETAR
		try {
			cba.registrarBuceo(new BuzoTecnico(nombre, nacionalidad, edad), idBuceo);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

}
