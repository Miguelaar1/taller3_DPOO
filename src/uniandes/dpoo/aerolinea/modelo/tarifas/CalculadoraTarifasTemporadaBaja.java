package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{

	protected final int COSTO_POR_KM_NATURAL = 600;
	protected final int COSTO_POR_KM_CORPORATIVO = 900;
	protected final double DESCUENTO_PEQ = 0.02;
	protected final double DESCUENTO_MEDIANAS = 0.1;
	protected final double DESCUENTO_GRANDES = 0.2;
	
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		int costoBase, distance;
		Ruta rute = vuelo.getRuta();
		distance = calcularDistanciaVuelo(rute);
		String clientType = cliente.getTipoCliente();
		
		if (clientType.equals("Natural")) {
			costoBase = COSTO_POR_KM_NATURAL * distance;
		} else  {
			costoBase = COSTO_POR_KM_CORPORATIVO * distance;
		}
		return costoBase;
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		double discount = 0;
		String clientType = cliente.getTipoCliente();
		
		if (clientType.equals("Corporativo")) {
			ClienteCorporativo current = (ClienteCorporativo) cliente;
			if (current.getTamanoEmpresa() == 1) {
				discount = DESCUENTO_PEQ;
			} else if (current.getTamanoEmpresa() == 2) {
				discount = DESCUENTO_MEDIANAS;
			} else discount = DESCUENTO_GRANDES;
		}
		return discount;
	}
	
}
