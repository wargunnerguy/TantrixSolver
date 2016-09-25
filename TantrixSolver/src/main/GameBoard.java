package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class GameBoard {
	private static String[][] gameBoard = new String[][]{
		//värvide lugemine algab ülevalt paremalt ja liigub vasakule
		  {"y", "b", "r", "b", "r", "y"},
		  {"r", "r", "y", "y", "b", "b"},
		  {"b", "b", "g", "g", "y", "y"}
		};
	Queue<GameBoard> queue = new LinkedList<GameBoard>();
	//tagastab n-nda tile
	public static String[] getTile(int nTile){
		String[] vastus = getGameBoard()[nTile];
		return vastus;
	}
	public static void setTile(int nTile, String[] toThis){
		getGameBoard()[nTile] = toThis;
	}
		
	public static void swapTiles(int t1, int t2){
		//temp = esimene vahetatav tile
		String[] temp = getTile(t1);
		//esimene tile -> teine tile
		getGameBoard()[t1] = getTile(t2);
		//teine tile -> esimene vahetatav tile
		getGameBoard()[t2] = temp;
		
	}
	//keerab tile vasakule leftTurns võrra astmeid
	public static void turnTile(int tile, int leftTurns){
		System.out.println(tile+1 + ". tile pöörati " + leftTurns + "x vasakule");
		if(leftTurns > 5){
			System.err.println("Viga: leftTurns ei tohiks üle 5 olla! \n");
		}
		String[] temp = Stream.concat(Arrays.stream(getGameBoard()[tile]), Arrays.stream(getGameBoard()[tile])).toArray(String[]::new);
		System.arraycopy(temp, getGameBoard()[tile].length-leftTurns, getGameBoard()[tile], 0, getGameBoard()[tile].length);
	}
	public static String[][] getGameBoard() {
		return gameBoard;
	}
	public static void setGameBoard(String[][] gameBoard) {
		GameBoard.gameBoard = gameBoard;
	}
	
	//reeglid
	public void rules (int tile) {
	/////////
	/////////
	/////////
	int i = 0;
	/////////
	/////////
	/////////
	   switch (tile) {
	      case 0:
	         break;
	      case 1:
	         //1(0) == 0(3)
	         if (gameBoard[tile][0] == gameBoard[0][3])
	            break;
	         else {
	            for (i = 0; i <= gameBoard[tile].length; i++ ) {
	               if (gameBoard[tile][i] == gameBoard[0][3]) {
	                  /*kui leitakse esimene sobiv värv, siis kutsutakse esile turnTile,
	                  millele antakse kaasa tile väärtus ja õige värvi asukoht vektoril
	                  so i
	                   */
	                  turnTile(tile, i);
	                  break;
	               }
	            }
	         }

	         break;
	      case 2:
	         //2(1) == 0(4) && 2(2) == 1(5)
	         if (gameBoard[tile][1] == gameBoard[0][4] && gameBoard[tile][2] == gameBoard[1][5]) {
	            break;
	         }
	         else {
	            for (i = 0; i <= gameBoard[tile].length; i++ ){
	               if (gameBoard[tile][i] == gameBoard[0][4]){
	                  //kui on tegemist viimase elemendiga reas, siis tuleks kontrollida rea esimest elementi ka
	                  if (i == gameBoard[tile].length && gameBoard[tile][0] == gameBoard[1][5]) {
	                     turnTile(tile, i-1);
	                     break;
	                  }
	                  else if (gameBoard[tile][i+1] == gameBoard[1][5]){
	                     //i-1, kuna on vaja, et õige värv satuks postsioonile 1 mitte 0
	                     turnTile(tile, i-1);
	                     break;
	                  }

	               }
	               /* kuna sobivat kombinatsiooni ei leitud, siis tuleb järgmine tile võtta
	                ja kui uus tile sobib, siis tile'de asukohad vahetada. Kui ka uus tile ei sobi,
	                siis asukohti vahetada ei tohi, muidu tekib loop, ja tuleb võtta järgmine tile
	                */
	            }
	         }
	         break;
	      case 3:
	         //3(0) == 1(3)
	         if (gameBoard[tile][0] == gameBoard[1][3])
	            break;
	         else {
	            for (i = 0; i <= gameBoard[tile].length; i++ ) {
	               if (gameBoard[tile][i] == gameBoard[1][3]) {
	                  turnTile(tile, i);
	                  break;
	               }
	            }
	         }
	         break;
	      case 4:
	         //4(0) == 2(3) && 4(1) == 1(4) && 4(2) == 3(5)
	         if (gameBoard[tile][0] == gameBoard[2][3] && gameBoard[tile][1] == gameBoard[1][4] && gameBoard[tile][2] == gameBoard[3][5]) {
	            break;
	         }
	         else {
	            for (i = 0; i <= gameBoard[tile].length; i++ ){
	               if (gameBoard[tile][i] == gameBoard[1][4]){
	                  if (i == 0 && gameBoard[tile][1] == gameBoard[3][5] && gameBoard[tile][5] == gameBoard[2][3]) {
	                     turnTile(tile, i+1);
	                     break;
	                  }
	                  else if (i == gameBoard[tile].length && gameBoard[tile][0] == gameBoard[3][5] && gameBoard[tile][i-1] == gameBoard[2][3]) {
	                     turnTile(tile, i-1);
	                     break;
	                  }
	                  else if (gameBoard[tile][i+1] == gameBoard[1][5]){
	                     //i-1, kuna on vaja, et õige värv satuks postsioonile 1 mitte 0
	                     turnTile(tile, i-1);
	                     break;
	                  }

	               }
	               //see tile ei sobinud
	            }
	         }
	         break;
	      case 5:
	         //5(1) == 2(4) && 5(2) == 4(5)
	         if (gameBoard[tile][1] == gameBoard[2][4] && gameBoard[tile][2] == gameBoard[4][5]) {
	            break;
	         }
	         else {
	            for (i = 0; i <= gameBoard[tile].length; i++ ){
	               if (gameBoard[tile][i] == gameBoard[2][4]){
	                  //kui on tegemist viimase elemendiga reas, siis tuleks kontrollida rea esimest elementi ka
	                  if (i == gameBoard[tile].length && gameBoard[tile][0] == gameBoard[4][5]) {
	                     turnTile(tile, i-1);
	                     break;
	                  }
	                  else if (gameBoard[tile][i+1] == gameBoard[4][5]){
	                     //i-1, kuna on vaja, et õige värv satuks postsioonile 1 mitte 0
	                     turnTile(tile, i-1);
	                     break;
	                  }

	               }
	               //see tile ei sobinud
	            }
	         }
	         break;
	   }
	}

	
}
