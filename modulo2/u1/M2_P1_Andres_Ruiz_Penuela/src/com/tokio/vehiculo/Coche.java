package com.tokio.vehiculo;

import java.util.Arrays;

/**
 * Clase Coche cuenta con dos clases internas estaticas finales denominadas Rueda y Chasis.
 * 
 * La clase Chasis es privada, por lo que para acceder a los atributos de la clase
 * se han de definir métodos de acceso en la clase externa públicos
 * 
 * La clase Rueda es publica, por lo que no es necesario definir metodos de 
 * acceso a los atributos de la misma.
 * 
 * Los atributos de todas las clases son de tipo protected, por lo que solo se podran
 * usar en clases defindias en el mismo paquete, o clases que herende de Coche.
 * 
 * @author Andrés Ruiz Peñuela
 * @version 1.0
 *
 */
public class Coche {
	protected String matricula;
	protected String marca;
	protected String modelo;
	protected float potencia;
	protected float velocidad;
	protected Chasis chasis = new Chasis();
	protected Rueda[] rueda = new Rueda[4];
	
	private static final class Chasis{
		protected String material;
		protected float peso;
		public String getMaterial() {
			return material;
		}
		public void setMaterial(String material) {
			this.material = material;
		}
		public float getPeso() {
			return peso;
		}
		public void setPeso(float peso) {
			this.peso = peso;
		}
		@Override
		public String toString() {
			return "Chasis [material=" + material + ", peso=" + peso + "]";
		}
		
		
	}
	
	public static final class Rueda{
		public static enum TIPO {Seco, Lluvia};
		protected float medida;
		TIPO tipo;
		protected String marca;
		protected String modelo;
		public float getMedida() {
			return medida;
		}
		public void setMedida(float medida) {
			this.medida = medida;
		}
		public TIPO getTipo() {
			return tipo;
		}
		public void setTipo(TIPO tipo) {
			this.tipo = tipo;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		@Override
		public String toString() {
			return "Rueda [medida=" + medida + ", tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo + "]";
		}
		
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}

	public float getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}

	public Chasis getChasis() {
		return chasis;
	}

	public void setChasis(Chasis chasis) {
		this.chasis = chasis;
	}

	public Rueda[] getRueda() {
		return rueda;
	}

	public void setRueda(Rueda[] rueda) {
		this.rueda = rueda;
	}

	/* attr chasis */
	public void setMaterialChasis(String material) {
		this.chasis.setMaterial(material);
	}
	
	public String getMaterialChasis() {
		return this.chasis.getMaterial();
	}
	
	public void setPesoChasis(float peso) {
		this.chasis.setPeso(peso);
	}
	
	public float getPesoChasis() {
		return this.chasis.getPeso();
	}
	

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", potencia=" + potencia
				+ ", velocidad=" + velocidad + ", chasis=" + chasis + ", rueda=" + Arrays.toString(rueda) + "]";
	}
	
	
}
