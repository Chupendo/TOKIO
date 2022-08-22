package codes.practises.m3.p1;

import java.util.HashMap;
import java.util.Map;

import codes.practises.m3.p1.Constantes.ASIGNATURA;
import codes.practises.m3.p1.Constantes.NOTA;



public class Nota {
	private Map<Constantes.ASIGNATURA, Double> mapNota;
	
	/** Constructores **/
	public Nota() {
		this.mapNota = new HashMap<Constantes.ASIGNATURA, Double>();
	}
	
	public Nota(Constantes.ASIGNATURA asignatura,double calificacion) {
		this();
		addNota(asignatura,calificacion);
	}
	
	/**
	 * Añade una asignatura y una calificaicon a la coleccion
	 * @param asignatura
	 * 		ASIGNATURA a guardar
	 * @param calificacion
	 * 		double calificacion de la nota
	 */
	public void addNota(Constantes.ASIGNATURA asignatura,double calificacion) {
		this.mapNota.put(asignatura, calificacion);
	}
	
	/**
	 * Devuelve la calificacion de una asignatura
	 * @param asignatura
	 * 		ASIGNATURA con la calificacion a obtener
	 * @return calificacion
	 * 		double calificaicon de la asignatura
	 */
	public double getNota(Constantes.ASIGNATURA asignatura){
		double calificacion = this.mapNota.get(asignatura)==null?null:this.mapNota.get(asignatura);
		return calificacion;
	}
	
	/**
	 * Mensaje con las asignturas y calificioanes conteidas en la coleccion
	 * 
	 * @return msg
	 * 		String
	 */
	public String toString() {
		StringBuilder msg = new StringBuilder();
		if(mapNota.isEmpty())
			return "Vacia";
		
		mapNota.forEach((k,v)->msg.append("Asignatura: "+k+", Nota: "+v+"\n"));
		return msg.toString();
	}
	
	/**
	 * Calcula la media de las asignaturas en la coleccion
	 * 
	 * @return resultado
	 * 		NOTA con la media de las asignutras, 0 si la coleecion esta vacia
	 */
	public NOTA getMedia() {
		NOTA resultado = null;
		double sum = 0;
		if(this.mapNota.isEmpty()) {
			return resultado;
		}
		
		for(Map.Entry<ASIGNATURA, Double> entry : this.mapNota.entrySet()) {
			sum = sum + entry.getValue();
		}
		
		resultado = NOTA.Notable.parserNota((short) (sum/this.mapNota.size()));
		return resultado;
	}
	
}
