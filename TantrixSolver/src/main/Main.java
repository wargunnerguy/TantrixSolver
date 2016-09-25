package main;


public class Main {

	public static void main(String[] args) {
//		System.out.println(Arrays.deepToString(GameBoard.getGameBoard()));
//		GameBoard.turnTile(0, 3);
//		System.out.println(Arrays.deepToString(GameBoard.getGameBoard()));
		Search sr = new Search("breadthFirst");
		sr.breadthFirst();
		
	}

}
