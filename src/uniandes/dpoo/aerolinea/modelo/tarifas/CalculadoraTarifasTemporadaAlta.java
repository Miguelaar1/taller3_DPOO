package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{

	protected final int COSTO_POR_KM = 1000;
	
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		Ruta rute = vuelo.getRuta();
		return this.COSTO_POR_KM * calcularDistanciaVuelo(rute);
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		return 0;
	}
	
}
