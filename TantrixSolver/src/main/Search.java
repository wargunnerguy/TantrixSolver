package main;

import java.util.Arrays;

public class Search {
	String searchMethod;
	static String[][] solution = new String[3][6];

	Search(String searchMethod){
		this.searchMethod = searchMethod;
	}
	
	
	
	//breadth first search
	void breadthFirst(){
		
		
		solution[0] = GameBoard.getGameBoard()[0];
		System.out.println(Arrays.deepToString(solution));
		System.out.println(Arrays.toString(GameBoard.getGameBoard()[0]));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Depth first search
	void depthFirst(){
		
	}
	//A* search
	void aStar(){
		
	}

	public void setSolutionTile(int tile, String[] solution) {
		Search.solution[tile] = solution;
	}
	public String[][] getSolution() {
		return Search.solution;
	}
}
