package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	
	private Cliente cliente;
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Vuelo vuelo;
	
	public Tiquete( String codigo, Vuelo vuelo, Cliente cliente, int tarifa) {
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.usado = false;
		this.vuelo = vuelo;
		this.cliente = cliente;
		
//		this.cliente.agregarTiquete(null);
		
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public Vuelo getVuelo() {
		return this.vuelo;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public int getTarifa() {
		return this.tarifa;
	}
	
	public void marcarComoUsado() {
		this.usado = true;
	}
	
	public boolean esUsado() {
		return usado;
	}
}
