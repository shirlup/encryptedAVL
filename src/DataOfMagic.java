
public class DataOfMagic implements Comparable {
	//the information in the AVL tree
	private int [] privateKey;
	private String riddle;
	
	//constructor
	public DataOfMagic(int[] arr, String riddle){
		this.riddle = riddle;
		privateKey = new int [arr.length];
		for(int i=0 ; i<arr.length ; i++){
			privateKey[i]= arr[i];
		}		
	}
	
	public int [] getPrivateKey(){
		return privateKey;
	}
	public String getRiddle(){
		return riddle;
	}
	//compare between strings;
	public int compareTo (Object x ){ //compare with another dataOfMagic
		return riddle.compareTo(((DataOfMagic)x).getRiddle());
	}

	
}

	
