package main;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		GameBoard t = new GameBoard();
		System.out.println(Arrays.deepToString(t.gameBoard));
		t.turnTile(0, 3);
		System.out.println(Arrays.deepToString(t.gameBoard));
	}

}
