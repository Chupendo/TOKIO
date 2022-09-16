package codes.practises.three;

import java.util.Arrays;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * Clase que modela una Bolsa que nos permita almacenar una colección desordenada de objetos en la que, 
 * al extraerlos, todos tengan la misma probabilidad de ser escogidos
 * 
 * @author Andrés Ruiz Peñuela
 * @version 1.0
 * @see Object
 * @see Random
 */
public class Bag {
	/** Marca el numero de elmentos de la lista **/
	private int limit;
	/** Matriz unidimensional de tipo Object **/
	private Object[] bag;
	
	/**
	 * Inizializa la instanica
	 */
	public Bag() {
		this.limit = 0;
		bag = init(limit);
	}
	
	/** Añade un elemento a la bolsa
	 * 
	 * @param e
	 * 		Object, elemnto a añadir a la bolsa
	 * @return boolean
	 * 		true si se a añadido el elemto a la bolsa, false en caso contrario
	 * 
	 */
    public boolean add(Object e) { 
    	try {
	    	this.limit++;
	    	bag = rediBag(bag);
	    	bag[this.limit-1]=e;
    	}catch (Exception ex) {
			return false;
		}
    	return true;
    }

    /** 
     * Elimina todos los elementos de la bolsa 
     * */
    public void clear() {
    	this.limit = 0;
    	bag = init(limit);
    }

    /** 
     * Comprueba si un objeto determinado está en la bolsa 
     * 
     * @param o
     * 		Object, elemento a comprobar
     * 
     * @return boolena
     * 		true si el elemento esta dentro de la lista, false en otro caso
     */
    public boolean contains(Object o) {
    	// Search the element in the bag.
    	Object result = Stream.of(bag).filter(item->item.equals(o)).findFirst().orElse(null);
    	
    	// return the result
        return result!=null?true:false;
    }

    /** 
     * Indica si la bolsa está vacía o no
     * 
     * @return boolean
     * 		true si la liste esta vacía, false en otro caso
     */
    public boolean isEmpty() { 
    	return this.limit==0?true:false;
    }

    /** 
     * Devuelve el número de elementos de la bolsa 
     * 
     * @return int
     * 		numero de elementos en la bosla
     * */
    public int size() {
        return this.limit;
    }

    /**
     * Extrae un elemento de la bolsa. Todos, independiente-
     * mente de como se hayan introducido tienen la misma
     * probabilidad de salir.
     * 
     * Ayuda: Usa la clase java.util.Random y su método
     * {@link java.util.Random#nextInt(int) nexInt} para obtener un entero aleatorio.
     * 
     * @return Object
     * 		null si la lsita esta vacía, un objecto de la lista
     */
    public Object extract() {
    	if(isEmpty())
    		return null;
    	
    	// Created a object of Random
    	Random rand = new Random();
    	
    	// Get a number random with same propability betwen 0 and list.length-1
    	int index = rand.nextInt(bag.length);
    	
    	// Return el number
        return bag[index];
    }
    
    
    /**
     * Redimensiona la bolsa, aumentando en una unidad su tamaño
     * 
     * @param data
     * 		Array de Object a redimensionar
     * 
     * @return Obejct[]
     * 		Array de Object redimensionada
     */
    private static Object[] rediBag(Object[] data) {
    	Object[] aux = new Object[data.length+1];
    	System.arraycopy(data, 0, aux, 0, data.length);
    	return aux;
    }
    
    
    /**
     * Inicializa un array unidimensional de objetos de una longitud dada
     * 
     * @param length
     * 		Tamaño del array
     * @return Object[]
     * 		Array unidimensional de length elements
     */
    private static Object[] init(int elements) {
    	return new Object[elements];
    }

    /**
     * Devueylve un mensaje con el número de elementos
     * y los elemntos de la bolsa.
     * 
     * @return String
     * 		Mensaje con infomracion de la instancia
     */
	@Override
	public String toString() {
		return "Bag [limit=" + limit + ", list=" + Arrays.toString(bag) + "]";
	}
    
}
