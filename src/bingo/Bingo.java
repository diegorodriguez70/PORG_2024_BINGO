package bingo;

import java.util.Arrays;

public class Bingo {

	private int bingo[];

	public Bingo() {

		bingo = new int[90];

	}

	public boolean partida() throws InterruptedException {
		System.out.println("\n\n");

		Carton carton1 = new Carton();

		carton1.rellenar();
		carton1.imprimir();
		boolean ganador = false;
		int contador = 0;

		// buble para que se repita ssacar una bola hasta que haya un ganador o hasta
		// que se jueguen tantas veces como numero shay (90)
		// falta la condicion de que si se juegan varios cartones y uno ya es ganador se
		// acabe la partida
		while (!ganador && contador < 90) {

			int numero = sacarBola();
			// rellenar el bingo con las bolas unicas que van saliendo
			bingo[numero - 1] = numero;
			carton1.tachar(numero);
		//	Thread.sleep(3000);
			ganador = carton1.hayBingo();
			contador++;
		}

		if (ganador) {
			return true;
		} else
			return false;

	}

	private int sacarBola() throws InterruptedException {
		int numero = (int) (Math.random() * 90 + 1);
		// buble para que no se pueda repetir el numero que salga en la bola del bingo
		while (bingo[numero - 1] != 0) {
			numero = (int) (Math.random() * 90 + 1);
		}
		System.out.println(numero);
	//	Thread.sleep(3000);
		return numero;
	}

	public String toString() {
		return "Bingo [bingo=" + Arrays.toString(bingo) + "]";
	}

}
