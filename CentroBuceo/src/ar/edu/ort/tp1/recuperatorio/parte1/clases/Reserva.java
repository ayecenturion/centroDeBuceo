package ar.edu.ort.tp1.recuperatorio.parte1.clases;

public class Reserva {

	private Mes mes;
	private int idBuceo;
	private String buzo;

	public Reserva(Mes mes, int idBuceo, String buzo) {
		super();
		this.mes = mes;
		this.idBuceo = idBuceo;
		this.buzo = buzo;
	}

	public Mes getMes() {
		return mes;
	}

	public int getIdBuceo() {
		return idBuceo;
	}

	public String getBuzo() {
		return buzo;
	}

}
