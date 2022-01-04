package ar.edu.ort.tp1.recuperatorio.parte2.clases;

import ar.edu.ort.tp1.recuperatorio.parte1.clases.Buceo;
import edu.ort.tp1.u5.tda.nodos.ListaOrdenadaNodos;

public class ListaBuceosPorId extends ListaOrdenadaNodos<Integer, Buceo> {

	@Override
	public int compare(Buceo dato1, Buceo dato2) {
		return dato1.getId() - dato2.getId();
	}

	@Override
	public int compareByKey(Integer clave, Buceo elemento) {
		return clave - elemento.getId();
	}

}
