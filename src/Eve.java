

import java.io.*;
import java.security.PrivateKey;

/**
 * Created by tomercoh on 16/04/2016.
 */
public class Eve {
	
	//Add Fields if needed

    public Eve(){}

    public Pair<String, Integer> findKey(String index, Puzzle[] puzzles){
    	
    	for(int i = 0; i<puzzles.length; i=i+1){
    		if ( solvePuzzle(puzzles[i]).getKey().equals(index)){
    			int counter=i+1;
    			return new Pair <String, Integer>(solveArray(puzzles[i].getPrivateKey()),counter);
    		}
    	}
    	return null;
    	
    }

    private String solveArray(int[] riddle) {
    
		return StaticFantastic.xor(StaticFantastic.sortArray (riddle));
	}

	public Pair<String, String> solvePuzzle(Puzzle puz){
		int [] riddle = puz.getRiddle();
    	int [] privateKey = puz.getPrivateKey(); 
    		 	
    	return new Pair<String, String>(StaticFantastic.xor(StaticFantastic.sortArray(riddle)),StaticFantastic.xor(StaticFantastic.sortArray(privateKey)));	
    	
    }    
 }
