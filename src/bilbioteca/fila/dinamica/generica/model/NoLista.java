package bilbioteca.fila.dinamica.generica.model;

public class NoLista <T> {

	T dado;
	NoLista proximo;
	
	@Override
	public String toString() {
		return "NoLista [dado=" + dado + ", proximo=" + proximo + "]";
	}
	

}
