package bilbioteca.fila.dinamica.generica.model;

public class Lista<T> {

	NoLista<T> primeiro;

	public Lista() {
		primeiro = null;
	}

	public boolean isEmpty() {
		if (primeiro == null) {
			return true;
		} else {
			return false;
		}

		
	}

	public int size() {
		int cont = 0;

		if (!isEmpty()) {
			NoLista<T> aux = primeiro;

			while (aux != null) {
				cont++;
				aux = aux.proximo;
			}
		}
		return cont;
	}

	private NoLista<T> getNo(int index) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}

		int tamanho = size();
		if (index < 0 || index > tamanho - 1) {
			throw new Exception("Index inválido");
		}

		int i = 0;
		NoLista<T> aux = primeiro;

		while (i < index) {
			aux = aux.proximo;
			i++;
		}

		return aux;
	}

	public void addFirst(T dado) {
		NoLista<T> aux = new NoLista<>();
		aux.dado = dado;
		aux.proximo = primeiro;
		primeiro = aux;
	}

	public void addLast(T dado) throws Exception {
		if (isEmpty()) {
			addFirst(dado);
			throw new Exception("Lista vazia, adicionando na primeira posição");
		}
		
		int tamanho = size();
		NoLista<T> no = new NoLista<>();
		NoLista<T> ultimo = new NoLista<>();
		
		ultimo = getNo(tamanho - 1);
		no.dado = dado;
		no.proximo = null;
		ultimo.proximo = no;
	}
	
	public void addNo(T dado, int index) throws Exception {
		int tamanho = size();
		if (index < 0 || index > tamanho) {
			throw new Exception("Index inválido");
		}
		
		if(index == 0) {
			addFirst(dado);
		} else if (index == tamanho) {
			addLast(dado);
		} else {
			NoLista<T> no = new NoLista<>();
			NoLista<T> ultimo = new NoLista<>();
			no.dado = dado;
			no.proximo = ultimo.proximo;
			ultimo.proximo = no;
		}
	}
	
	public void removeFirst() throws Exception{
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		
		primeiro = primeiro.proximo;
	}
	
	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		
		int tamanho = size();
		if (tamanho == 1) {
			removeFirst();
		} else { 
		
		NoLista<T> ultimo = new NoLista<>();
		ultimo = getNo(tamanho - 2);
		ultimo.proximo = null;
		}
	}
	
	public void remove (int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty list");
        }

        int size = size();
        if ((index < 0) || (index > size - 1)) {
            throw new Exception("Invalid index");
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            NoLista<T> last = getNo(index - 1);
            NoLista<T> node = getNo(index);
            last.proximo = node.proximo;
        }
	}
	
	public T get(int index) throws Exception{
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		
		int tamanho = size();
		if (index < 0 || index > tamanho - 1) {
			throw new Exception("Index inválido");
		}
		
		NoLista<T> no = getNo(index);
		return no.dado;
		
	}
}
