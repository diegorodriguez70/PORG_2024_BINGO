package bingo;

import java.util.Arrays;

public class Carton {
	
	//Aqui en este vector guardamos los numeros del carton y lo vamo sa usar para saber luego si hay bingo y para tachar numeros
	private int cartonNums[];
	//en esta matriz guardamos los mismos numeros del cartn pero en formato matriz para hacerlo mas visual. Lo uso para el imprimir. 
	private int carton[][];


	public Carton() {

		cartonNums = new int[15];
		carton = new int[3][9];
		

	}

	
	public void  tachar(int numero) {
		
		for (int t=0; t<cartonNums.length;t++) {
			
			if(cartonNums[t]==numero) {
				//quitamos el numero de la matriz tambien para que se vea quitado
				for(int i=0;i<3;i++) {
					
					for(int j=0;j<9;j++) {
						
						if(carton[i][j]==cartonNums[t]) {
							
							carton[i][j]=0;
						}
					}
				}
				
				
				cartonNums[t]=0;
			}
		}
		
		imprimir();
	}

	public boolean hayBingo() {
		int contador=0;
		for (int i=0; i<cartonNums.length;i++) {
			
			if(cartonNums[i]==0) {
				contador++;
			}
		}

		if (contador==15) {
			
			return true;
		}
		return false;
		
	}


	public void rellenar() {

		boolean repetido = true;
		
		// Primero relleno toda la matriz con 0 (no hay ningun numero)
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				carton[i][j] = 0;
			}
		}
	
		//bucle para rellenar el vector del carton de bingo que vamos a usar despues 
		for (int i = 0; i < cartonNums.length; i++) {
			int numeroRellenar =0;
			//vamos a buscar un numero que no este repetido
			while (repetido) {
				numeroRellenar = (int) (Math.random() * 89 + 1);
				repetido = estaRepetido(numeroRellenar);

			}
			//rellenamos tanto el vector como la matriz con ese numero no repetido
			cartonNums[i]=numeroRellenar;
			rellenarcarton(cartonNums[i]);
			repetido = true;
		}

	}

	private boolean estaRepetido(int numero) {
		for (int i= 0 ; i<cartonNums.length; i++) {
			if(cartonNums[i]== numero) {
				return true;
			}
		}
		return false;
		
	}

	
	//metodo para rellenar la matriz con el carton  (Lo que se va a ver por pantalla aunque no se vaya a usar)
	private void rellenarcarton(int numero) {
		//miramos a ver donde se encuentra nuestro numero por decenas
		if (numero < 10) {
			//a filaToca(int, int) le vamos a mandar la fila en la que estamos y el numero que queremos poner
			carton[filaToca(0, numero)][0] = numero;
		} else if (numero >= 10 && numero < 20) {
			carton[filaToca(1, numero)][1] = numero;
		} else if (numero >= 20 && numero < 30) {
			carton[filaToca(2, numero)][2] = numero;
		} else if (numero >= 30 && numero < 40) {
			carton[filaToca(3, numero)][3] = numero;
		} else if (numero >= 40 && numero < 50) {
			carton[filaToca(4, numero)][4] = numero;
		} else if (numero >= 50 && numero < 60) {
			carton[filaToca(5, numero)][5] = numero;
		} else if (numero >= 60 && numero < 70) {
			carton[filaToca(6, numero)][6] = numero;
		} else if (numero >= 70 && numero < 80) {
			carton[filaToca(7, numero)][7] = numero;
		} else if (numero >= 80 && numero <= 90) {
			carton[filaToca(8, numero)][8] = numero;
		}

	}

	private int filaToca(int columna, int numero) {

		for (int i = 0; i < 3; i++) {
			if (carton[i][columna] == 0) {
				
				//bucle para settear los numeros en orden.
				//Primero la condicion de que la i!=0 o > 0 para que al hacer i -1 no nos salgamos de los limites
				//Segunda para saber si el numero que habia una casilla mas arriba es  mayor que el numero que vamos a poner 
				if(i>0 && carton[i-1][columna]>numero) {
					
					//en el caso de que se cumplan ambas. sobreescribimos la casilla en la que estamos con el numero de la casilla de arriba porque es mas grande
					carton[i][columna]=carton[i-1][columna];
					//devolvemos la casilla en la que vamos a poner el mas pequeño (la casilla anterior)
					return i-1;
				}
				
				return i;
			}

		}
		return 0;
	}

	public void imprimir() {

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 9; j++) {

				System.out.print("   " + carton[i][j]);

			}
			System.out.println("\n");

		}
		
		System.out.println(Arrays.toString(cartonNums));
	}


}
