package ar.edu.ort.tp1.recuperatorio.parte1;

import java.util.ArrayList;

import ar.edu.ort.tp1.recuperatorio.parte1.clases.CentroBuceo;
import ar.edu.ort.tp1.recuperatorio.parte1.clases.Mes;
import ar.edu.ort.tp1.recuperatorio.parte1.clases.Reserva;

public class Parte1 {

	public static void main(String[] args) {
		System.out.println("Recuperatorio TP1 - Parte 1 - Primer Parcial");

		System.out.println("-------------- Se crea el centro de buceo");
		CentroBuceo centro = new CentroBuceo("ORT Diving Center");

		System.out.println("-------------- Se cargan reservas");
		centro.cargarReservas(generarReservas());
		
		System.out.println("-------------- Se piden estadisticas");
		centro.mostrarEstadisticas();

		System.out.println("-------------- Se piden Cantidad de buceos con reserva para un mes.");
		centro.mostrarCantidadBuceosConReservasPorNombreMes("Agosto");
		centro.mostrarCantidadBuceosConReservasPorNombreMes("January");

		System.out.println("-------------- Se piden Cantidad de buceos con reserva para un nombre de buceo.");
		centro.mostrarCantidadMesesConReservasPorNombreBuceo("Los Reyunos");
		centro.mostrarCantidadMesesConReservasPorNombreBuceo("Mamá Viña");
	}

	private static ArrayList<Reserva> generarReservas() {
		ArrayList<Reserva> reservas = new ArrayList<>();

		reservas.add(new Reserva(Mes.ENERO, 9, "Buzo 1"));
		reservas.add(new Reserva(Mes.ENERO, 3, "Buzo 2"));
		reservas.add(new Reserva(Mes.ENERO, 4, "Buzo 3"));
		reservas.add(new Reserva(Mes.ENERO, 1, "Buzo 4"));
		reservas.add(new Reserva(Mes.ENERO, 10, "Buzo 5"));

		reservas.add(new Reserva(Mes.FEBRERO, 2, "Buzo 1"));
		reservas.add(new Reserva(Mes.FEBRERO, 5, "Buzo 2"));

		reservas.add(new Reserva(Mes.MARZO, 10, "Buzo 1"));
		reservas.add(new Reserva(Mes.MARZO, 1, "Buzo 2"));

		reservas.add(new Reserva(Mes.ABRIL, 4, "Buzo 4"));
		reservas.add(new Reserva(Mes.ABRIL, 5, "Buzo 5"));
		
		reservas.add(new Reserva(Mes.MAYO, 10, "Buzo 1"));
		reservas.add(new Reserva(Mes.MAYO, 2, "Buzo 2"));
		reservas.add(new Reserva(Mes.MAYO, 6, "Buzo 4"));
		reservas.add(new Reserva(Mes.MAYO, 10, "Buzo 5"));
		
		reservas.add(new Reserva(Mes.JUNIO, 3, "Buzo 5"));
		
		reservas.add(new Reserva(Mes.AGOSTO, 5, "Buzo 5"));
		reservas.add(new Reserva(Mes.AGOSTO, 10, "Buzo 33"));
		
		reservas.add(new Reserva(Mes.SEPTIEMBRE, 4, "Buzo 5"));
		
		reservas.add(new Reserva(Mes.OCTUBRE, 6, "Buzo 5"));
		
		reservas.add(new Reserva(Mes.NOVIEMBRE, 7, "Buzo 5"));
		
		reservas.add(new Reserva(Mes.DICIEMBRE, 4, "Buzo 5"));
		reservas.add(new Reserva(Mes.DICIEMBRE, 9, "Buzo 5"));
		reservas.add(new Reserva(Mes.DICIEMBRE, 10, "Buzo 5"));

		return reservas;
	}

}
