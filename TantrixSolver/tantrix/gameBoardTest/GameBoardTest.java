package gameBoardTest;

import static org.junit.Assert.*;

import org.junit.Test;

import main.GameBoard;

public class GameBoardTest {

	@Test
	public void testSwapTiles() {
		GameBoard g = new GameBoard();
		g.gameBoard = new String[][]{
			  {"y", "b", "r", "b", "r", "y"},
			  {"r", "r", "y", "y", "b", "b"},
			  {"b", "b", "g", "g", "y", "y"}
			};
			assertArrayEquals(new String[]{"y", "b", "r", "b", "r", "y"}, g.gameBoard[0]);
			g.swapTiles(0, 1);
			assertArrayEquals(new String[]{"r", "r", "y", "y", "b", "b"}, g.gameBoard[0]);
	}
	@Test
	public void testTurnTile(){
		GameBoard g = new GameBoard();
		g.gameBoard = new String[][]{
			  {"y", "b", "r", "b", "r", "y"}
			};
			assertArrayEquals(new String[]{"y", "b", "r", "b", "r", "y"}, g.gameBoard[0]);
			g.turnTile(0, 1);
			assertArrayEquals(new String[]{"y", "y", "b", "r", "b", "r"}, g.gameBoard[0]);
			g.turnTile(0, 1);
			assertArrayEquals(new String[]{"r", "y", "y", "b", "r", "b"}, g.gameBoard[0]);
			g.turnTile(0, 1);
			assertArrayEquals(new String[]{"b", "r", "y", "y", "b", "r"}, g.gameBoard[0]);
			g.turnTile(0, 1);
			assertArrayEquals(new String[]{"r", "b", "r", "y", "y", "b"}, g.gameBoard[0]);
			g.turnTile(0, 1);
			assertArrayEquals(new String[]{"b", "r", "b", "r", "y", "y"}, g.gameBoard[0]);
	}

}
