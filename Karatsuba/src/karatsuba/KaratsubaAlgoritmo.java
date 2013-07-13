package karatsuba;

import java.math.BigInteger;

public class KaratsubaAlgoritmo {
	
	private BigInteger resultadoOperacion;
	
	/**
	 * Método constructor
	 */
	public KaratsubaAlgoritmo(){
	}
	
	/**
	 * Método que multiplica los enteros recibidos con el
	 * algoritmo de Karatsuba
	 * 
	 * @param x
	 * @param y
	 */
	public void multiplicar(BigInteger x, BigInteger y) {
		resultadoOperacion = karatsuba(x, y);
	}
	
	/**
	 * Método que realiza la multiplicación de Karatsuba 
	 * Nota: Basado en el pseudocódigo presentado en http://en.wikipedia.org/wiki/Karatsuba_algorithm
	 * 
	 * @param x
	 * @param y
	 * @return El resultado de la multiplicación de x y y
	 */
	public BigInteger karatsuba(BigInteger x, BigInteger y){
		//Si alguno de los valores es inferior a 10 se usa
		//la multiplicación normal
		if(x.compareTo(BigInteger.TEN) < 0
				|| y.compareTo(BigInteger.TEN) < 0){
			return x.multiply(y);
		}
		
		//Se obtiene el número de digitos mayor entre los dos números
		int m = Math.max(x.toString().length(), y.toString().length());
		//El mayor número de digitos se divide en 2
		m = (int) Math.round(m / 2.0);
		
		//Control de números con tamaños diferentes
		if(m >= y.toString().length()
				|| m >= x.toString().length()){
			//Si el valor de m es superior o igual a la cantidad de
			//dígitos del número más pequeño en tamaño, se vuelve
			//a calcular con relación a dicho tamaño
			m = Math.min(x.toString().length(), y.toString().length());
			m = (int) Math.round(m / 2.0);
		}
		
		//Se obtienen los valores de las variables x0, x1, y0, y1
		BigInteger x0;
		BigInteger x1;
		BigInteger y0;
		BigInteger y1;
		
		String stringX0 = ""; 
		String stringY0 = ""; 
		String stringX1 = ""; 
		String stringY1 = "";
		
		if(x.toString().length() >= 3 && y.toString().length() >= 3){
			//Si el tamaño de alguno de los números es superior o
			//igual a 3 se obtienen las cifras de cada número
			int contador = 0;
			do {
				//Se obtienen las diferentes partes del primer número
				int digitoX = x.mod(BigInteger.TEN).intValue();
				x = x.divide(BigInteger.TEN);
				if(contador < m)
					stringX0 = digitoX + stringX0;
				else
					stringX1 = digitoX + stringX1;
				contador++;
			} while (x.compareTo(BigInteger.ZERO) > 0);
			
			contador = 0;
			do {
				//Se obtienen las partes del segundo número
				int digitoY = y.mod(BigInteger.TEN).intValue();
				y = y.divide(BigInteger.TEN);
				if(contador < m)
					stringY0 = digitoY + stringY0;
				else
					stringY1 = digitoY + stringY1;
				contador++;
			} while (y.compareTo(BigInteger.ZERO) > 0);
			
			//Las partes obtenidas se asignan a sus respectivas variables
			x0 = new BigInteger(stringX0);
			x1 = new BigInteger(stringX1);
			y0 = new BigInteger(stringY0);
			y1 = new BigInteger(stringY1);
		}else{
			//Se ninguno de los número está conformado por más
			//de 3 dígitos entonces se realiza una multiplicación normal
			return x.multiply(y);
		}
		
		//Se inicia el cálculo de las variables Z
		BigInteger z0;
		BigInteger z1;
		BigInteger z2;
		if(x.toString().length() >= 4 
				|| y.toString().length() >= 4){
			//Se realizan las tres multiplicaciones de forma
			//recursiva sólo para numeros iguales o superiores
			//a 4 dígitos
			
			//z0 = x0y0 --->
			z0 = karatsuba(x0, y0);
			//z2 = x1y1 --->
			z2 = karatsuba(x1, y1); 
			//z1 = (x1 + x0)(y1 + y0) - z2 - z0
			z1 = karatsuba(x0.add(x1), y0.add(y1));//(x1 + x0)(y1 + y0)
		}else{
			//Si ninguno de los números supera 3 dígitos se realiza
			//la multiplicación para cada variable Z sin usar recursividad
			z0 = x0.multiply(y0);
			z2 = x1.multiply(y1);
			z1 = (x0.add(x1)).multiply(y0.add(y1));
		}
		
		//Se completa el cálculo de la variable z1
		z1 = z1.subtract(z2).subtract(z0);//(x1 + x0)(y1 + y0) - z2 - z0
		
		//xy = z2B^2m + z1B^m + z0
		BigInteger parteZ2 = z2.multiply(BigInteger.TEN.pow(m * 2));//z2B^2m
		BigInteger parteZ1 = z1.multiply(BigInteger.TEN.pow(m));//z1B^m
		BigInteger parteZ0 = z0;//z0
		
		//Se suman las variables Z para completar la multiplicación
		return parteZ2.add(parteZ1.add(parteZ0));//z2B^2m + z1B^m + z0
	}

	//---------------- ---------------- ----------------
    //Métodos GET y SET de los atributos de la clase
    //---------------- ---------------- ----------------

	public BigInteger getResultadoOperacion() {
		return resultadoOperacion;
	}

	public void setResultadoOperacion(BigInteger resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}	

}
