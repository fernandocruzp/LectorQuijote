package mx.ciencias;

import java.util.NoSuchElementException;

/**
 * Clase abtracta para estructuras lineales restringidas a operaciones
 * mete/saca/mira.
 */
public abstract class MeteSaca<T> {

    /**
     * Clase interna protegida para nodos.
     */
    protected class Nodo {
        /** El elemento del nodo. */
        public T elemento;
        /** El siguiente nodo. */
        public Nodo siguiente;

        /**
         * Construye un nodo con un elemento.
         * @param elemento el elemento del nodo.
         */
        public Nodo(T elemento) {
            this.elemento=elemento;
        }
    }

    /** La cabeza de la estructura. */
    protected Nodo cabeza;
    /** El rabo de la estructura. */
    protected Nodo rabo;

    /**
     * Agrega un elemento al extremo de la estructura.
     * @param elemento el elemento a agregar.
     */
    public abstract void mete(T elemento);

    /**
     * Elimina el elemento en un extremo de la estructura y lo regresa.
     * @return el elemento en un extremo de la estructura.
     * @throws NoSuchElementException si la estructura está vacía.
     */
    public T saca() throws NoSuchElementException{
        if(cabeza==null) throw new NoSuchElementException();
	T eleme= cabeza.elemento;
	cabeza=cabeza.siguiente;
	if(cabeza==null) rabo=null;
	return eleme;
    }

    /**
     * Nos permite ver el elemento en un extremo de la estructura, sin sacarlo
     * de la misma.
     * @return el elemento en un extremo de la estructura.
     * @throws NoSuchElementException si la estructura está vacía.
     */
    public T mira() throws NoSuchElementException{
        if(cabeza==null) throw new NoSuchElementException();
	T eleme= cabeza.elemento;
	return eleme;
    }

    /**
     * Nos dice si la estructura está vacía.
     * @return <code>true</code> si la estructura no tiene elementos,
     *         <code>false</code> en otro caso.
     */
    public boolean esVacia() {
         return cabeza==null;
    }

    /**
     * Compara la estructura con un objeto.
     * @param object el objeto con el que queremos comparar la estructura.
     * @return <code>true</code> si el objeto recibido es una instancia de la
     *         misma clase que la estructura, y sus elementos son iguales en el
     *         mismo orden; <code>false</code> en otro caso.
     */
    @Override public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
	    return false;
	@SuppressWarnings("unchecked")
	    MeteSaca<T> lista = (MeteSaca<T>)o;
	Nodo n=cabeza;
	Nodo cosa=lista.cabeza;
	while(n!=null && cosa!=null){
	    if(!n.elemento.equals(cosa.elemento)){
		return false;
	    }
	    n=n.siguiente;
	    cosa=cosa.siguiente;
	}
	return n==cosa;
    }
}
