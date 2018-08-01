
import java.io.*;
import java.security.PrivateKey;

public class Bob {

    //Add Fields if needed

    public Bob(){
        //Complete Your Code Here
    }
//בוחרת באופן אקראי חידה מתוך המערך וקוראת לפונקציה solvePuzzle 
    public Pair<String,String> choosePuzzle(Puzzle[] puzzles){
		Pair <String,String> pair = solvePuzzle(puzzles[(int)(Math.random()*(puzzles.length))]);
		return pair;
    }
//מחזירה מספר סידורי של חידה ואת המפתח הסודי
    public Pair<String, String> solvePuzzle(Puzzle puz){
    	
    	int [] riddle = puz.getRiddle();
    	int [] privateKey = puz.getPrivateKey(); 
    	
    	Pair <String,String> pair = new Pair<String, String>(StaticFantastic.xor(StaticFantastic.sortArray(riddle)),StaticFantastic.xor(StaticFantastic.sortArray(privateKey)));	
    	return pair; 
    }
}
