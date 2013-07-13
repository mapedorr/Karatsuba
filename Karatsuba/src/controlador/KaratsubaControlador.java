package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import constantes.Constantes;
import interfazgrafica.KaratsubaUI;
import karatsuba.KaratsubaAlgoritmo;

public class KaratsubaControlador {
	
	/**
	 * Atributos de la clase
	 */
	private KaratsubaUI interfazGrafica;
	private KaratsubaAlgoritmo operador;
	
	
	/**
	 * Método contrsuctor
	 * 
	 * @param interfazGrafica Objeto de la vista
	 * @param operador Objeto del nucleo
	 */
	public KaratsubaControlador(KaratsubaUI interfazGrafica,
			KaratsubaAlgoritmo operador) {
		super();
		
		//Se asignan al controlador los objetos de vista (presentación)
		//y operación de datos
		this.interfazGrafica = interfazGrafica;
		this.operador = operador;
		
		//Se asigna a la vista el objeto que controlará 
		//los eventos del botón Multiplicar
		interfazGrafica.asignarListenerBotonMultiplicar(new BotonMultiplicarListener());
	}

	/**
	 * Clase de control de eventos
	 */
	class BotonMultiplicarListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				//Se deshabilita el formulario
				interfazGrafica.deshabilitarFormulario();
				
				//Se eliminan mensajes de error y se limpia el campo del resultado
				interfazGrafica.mostrarErrorCampo("", interfazGrafica.getErrorCampoX());
				interfazGrafica.mostrarErrorCampo("", interfazGrafica.getErrorCampoY());
				operador.setResultadoOperacion(null);
				interfazGrafica.establecerResultado();
				
				//Se obtienen los valores de los campos en el formulario
				String numeroX = interfazGrafica.obtenerNumeroX();
				String numeroY = interfazGrafica.obtenerNumeroY();
				
				//Se crean los valores a operar para x y y
				BigInteger x = null;
				BigInteger y = null;
				
				//Se realiza la verificación de conversión a número
				try {
					x = new BigInteger(numeroX);
				} catch (NumberFormatException e2) {
					//Se reporta el error y se muestra en pantalla el mensaje
					System.err.println("Valor no numérico en X");
					interfazGrafica.mostrarErrorCampo(Constantes.ERROR_NUMERICO, interfazGrafica.getErrorCampoX());
				}				
				try {
					y = new BigInteger(numeroY);
				} catch (NumberFormatException e2) {
					//Se reporta el error y se muestra en pantalla el mensaje
					System.err.println("Valor no numérico en Y");
					interfazGrafica.mostrarErrorCampo(Constantes.ERROR_NUMERICO, interfazGrafica.getErrorCampoY());
				}
				
				//Se verifica que los números sean mayores o iguales a cero
				if(x.compareTo(BigInteger.ZERO) >= 0 && y.compareTo(BigInteger.ZERO) >= 0){
					//Si los valores son mayores a cero, se realiza la multiplicación
					//con el algoritmo de Karatsuba
					operador.multiplicar(x, y);
					//Se actualiza el resultado en pantalla
					interfazGrafica.establecerResultado();
				}else{
					//Si alguno de los valores es menor que cero se muestra el mensaje
					//de error en pantalla
					if(x.compareTo(BigInteger.ZERO) < 0){
						System.err.println("Valor en X negativo");
						interfazGrafica.mostrarErrorCampo(Constantes.ERROR_NUMERO_NEGATIVO, interfazGrafica.getErrorCampoX());
					}
					
					if(y.compareTo(BigInteger.ZERO) < 0){
						System.err.println("Valor en Y negativo");
						interfazGrafica.mostrarErrorCampo(Constantes.ERROR_NUMERO_NEGATIVO, interfazGrafica.getErrorCampoY());
					}
				}	
			} catch (Exception error) {
				//Se reporta el error
				System.err.println("Error " + error.getMessage());
			} finally {
				//Se vuelven a habilitar los campos en el formulario
				interfazGrafica.habilitarFormulario();
			}
		}
	};

}
