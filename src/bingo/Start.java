package bingo;

public class Start {

	public static void main(String[] args) throws InterruptedException {

		Bingo bingo = new Bingo();
		boolean partida=bingo.partida();
		System.out.println(bingo);

		if (partida) {
			System.out.println("\n\nGanaste");
		}
	}

}
