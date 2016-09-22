package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class GameBoard {
	public String[][] gameBoard = new String[][]{
		//värvide lugemine algab ülevalt paremalt ja liigub vasakule
		  {"y", "b", "r", "b", "r", "y"},
		  {"r", "r", "y", "y", "b", "b"},
		  {"b", "b", "g", "g", "y", "y"}
		};
	Queue<GameBoard> queue = new LinkedList<GameBoard>();
	//tagastab n-nda tile
	public String[] getTile(int nTile){
		String[] vastus = gameBoard[nTile];
		return vastus;
	}
	public void setTile(int nTile, String[] toThis){
		gameBoard[nTile] = toThis;
	}
		
	public void swapTiles(int t1, int t2){
		//temp = esimene vahetatav tile
		String[] temp = getTile(t1);
		//esimene tile -> teine tile
		gameBoard[t1] = getTile(t2);
		//teine tile -> esimene vahetatav tile
		gameBoard[t2] = temp;
		
	}
	//keerab tile vasakule leftTurns võrra astmeid
	public void turnTile(int tile, int leftTurns){
		System.out.println(tile+1 + ". tile pöörati " + leftTurns + "x vasakule");
		if(leftTurns > 5){
			System.err.println("Viga: leftTurns ei tohiks üle 5 olla! \n");
		}
		String[] temp = Stream.concat(Arrays.stream(gameBoard[tile]), Arrays.stream(gameBoard[tile])).toArray(String[]::new);
		System.arraycopy(temp, gameBoard[tile].length-leftTurns, gameBoard[tile], 0, gameBoard[tile].length);
	}
	
}
