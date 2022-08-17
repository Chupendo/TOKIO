package relaciones.herencia.ejemplo;

import java.util.ArrayList;
import java.util.List;

public class CentroComercial {
	private List<Cliente> clientes;
	private List<Tienda> tiendas;
	
	public CentroComercial() {
		clientes = new ArrayList<Cliente>();
		tiendas = new ArrayList<Tienda>();
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public List<Tienda> getTiendas() {
		return tiendas;
	}
	public void setTiendas(List<Tienda> tiendas) {
		this.tiendas = tiendas;
	}
	
	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void borrarCliente(Cliente cliente) {
		clientes.remove(cliente);
	}
	
	public void nuevaTienda() {
		tiendas.add(new Tienda("Zara", 1, 120));
	}
	
	public List<Cliente> verClientes(){
		return clientes;
	}
	
	public List<Tienda> verTienda(){
		return tiendas;
	}
}
