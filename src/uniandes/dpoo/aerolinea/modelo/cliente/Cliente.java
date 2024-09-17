package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	
	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	
	public abstract String getTipoCliente();
	public abstract String getIdentificador();
	
	
	public Cliente() {
		this.tiquetesSinUsar = new ArrayList<Tiquete>();
		this.tiquetesUsados = new ArrayList<Tiquete>();
	}
	
	public void agregarTiquete(Tiquete tiquete) {
		this.tiquetesSinUsar.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes() {
		int totalSpent = 0;
		int biggestList;
		if (this.tiquetesSinUsar.size() >= this.tiquetesUsados.size()) {
			biggestList = this.tiquetesSinUsar.size();
		} else biggestList = this.tiquetesUsados.size();
		
		int i = 0;
		while (i < biggestList) {
			Tiquete current;
			if (i < this.tiquetesSinUsar.size()) {
				current = tiquetesSinUsar.get(i);
				totalSpent += current.getTarifa();
			}
			if (i < this.tiquetesUsados.size()) {
				current = tiquetesUsados.get(i);
				totalSpent += current.getTarifa();
			}
			i++;
		}
		return totalSpent;
	}
	
	public void usarTiquetes(Vuelo vuelo) {
		vuelo.getTiquetes()
		for (Tiquete current : tiquetesSinUsar) {
			
		}
	}

}
