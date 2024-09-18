package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	
	private Avion avion;
	private String fecha;
	private Ruta ruta;
	private Map<String, Tiquete> tiquetes;
	
	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		this.avion = avion;
		this.fecha = fecha;
		this.ruta = ruta;
		this.tiquetes = new HashMap<String, Tiquete>();
	}
	
	public Ruta getRuta() {
		return this.ruta;
	}
	
	public String getFecha() {
		return this.fecha;
	}
	
	public Avion getAvion() {
		return this.avion;
	}
	
	public Collection<Tiquete> getTiquetes(){
		Collection<Tiquete> tiquetes = this.tiquetes.values();
		return tiquetes;
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException{
		
		int tarifa = calculadora.calcularTarifa(this, cliente);
		
		for (int i = 0; i < cantidad; i++) {
			if (tiquetes.size() < avion.getCapacidad()) {
				Tiquete newTicket = GeneradorTiquetes.generarTiquete(this, cliente, tarifa);
				tiquetes.put(fecha, newTicket);	
			} else throw new VueloSobrevendidoException(this);
		}
		return cantidad;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.equals(obj);
	}
}
