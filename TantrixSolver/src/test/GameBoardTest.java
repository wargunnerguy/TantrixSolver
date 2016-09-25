package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.GameBoard;

public class GameBoardTest {

	@Test
	public void testSwapTiles() {
		GameBoard g = new GameBoard();
		GameBoard.setGameBoard(new String[][]{
			  {"y", "b", "r", "b", "r", "y"},
			  {"r", "r", "y", "y", "b", "b"},
			  {"b", "b", "g", "g", "y", "y"}
			});
			assertArrayEquals(new String[]{"y", "b", "r", "b", "r", "y"}, GameBoard.getGameBoard()[0]);
			g.swapTiles(0, 1);
			assertArrayEquals(new String[]{"r", "r", "y", "y", "b", "b"}, GameBoard.getGameBoard()[0]);
	}
	@Test
	public void testTurnTile(){
		GameBoard g = new GameBoard();
		GameBoard.setGameBoard(new String[][]{
			  {"y", "b", "r", "b", "r", "y"}
			});
			assertArrayEquals(new String[]{"y", "b", "r", "b", "r", "y"}, GameBoard.getGameBoard()[0]);
			g.turnTile(0, 1);
			assertArrayEquals(new String[]{"y", "y", "b", "r", "b", "r"}, GameBoard.getGameBoard()[0]);
			g.turnTile(0, 1);
			assertArrayEquals(new String[]{"r", "y", "y", "b", "r", "b"}, GameBoard.getGameBoard()[0]);
			g.turnTile(0, 1);
			assertArrayEquals(new String[]{"b", "r", "y", "y", "b", "r"}, GameBoard.getGameBoard()[0]);
			g.turnTile(0, 1);
			assertArrayEquals(new String[]{"r", "b", "r", "y", "y", "b"}, GameBoard.getGameBoard()[0]);
			g.turnTile(0, 1);
			assertArrayEquals(new String[]{"b", "r", "b", "r", "y", "y"}, GameBoard.getGameBoard()[0]);
	}

}
