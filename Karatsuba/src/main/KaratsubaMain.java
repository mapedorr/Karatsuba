package main;

import karatsuba.KaratsubaAlgoritmo;
import controlador.KaratsubaControlador;
import interfazgrafica.KaratsubaUI;

public class KaratsubaMain {

	/**
	 * Método de inicio de la aplicación
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Se crean los objetos de la aplicación
		KaratsubaAlgoritmo operador = new KaratsubaAlgoritmo();
		KaratsubaUI interfazGraficaUsuario = new KaratsubaUI(operador);
		@SuppressWarnings("unused")
		KaratsubaControlador controlador =new KaratsubaControlador(interfazGraficaUsuario, operador);

		interfazGraficaUsuario.setVisible(true);
	}

}
