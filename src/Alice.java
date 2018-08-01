

public class Alice {

	private Puzzle [] puzzlesArray;
	private AVLTree tree;

	public Alice(){
		this.tree = new AVLTree();
	}
	//deep copy of puzzles
	public Puzzle[] getPuzzlesCopy(){
		Puzzle[] puzzlesCopy = new Puzzle[puzzlesArray.length];
		for(int i = 0; i < puzzlesArray.length; i++){
			puzzlesCopy[i] = new Puzzle(puzzlesArray[i]);
		}
		return puzzlesCopy;
	}

	public void createPuzzles(int n, int k){
		puzzlesArray=new Puzzle[k];
		
		for( int i = 0 ; i < k ; i++ )
		{
			int[] privateKey = new int[n];	
			int[] riddle = new int[n];
			
			for( int j = 1; j <= n ; j++)
			{
				int random1 = (int) ((j-1)*Math.pow(n,3) + (int)(Math.random() * ((j*Math.pow(n,3)) - ((j-1)*Math.pow(n,3)))));  
			    int random2= (int) ((j-1)*Math.pow(n,3) + (int)(Math.random() * ((j*Math.pow(n,3)) - ((j-1)*Math.pow(n,3)))));
			    privateKey[j-1] = random1;
				riddle[j-1] = random2;
				//we got 2 sorted arrays
			}	
			
			DataOfMagic data = new DataOfMagic(privateKey,StaticFantastic.xor(riddle));
			Boolean found = tree.search(data);
			
			if(!found)
			{
				//if does not exist in tree
				tree.insert(data);
				
				//shuffle the arrays (we use copied arrays):
				
				int[] shu_privateKey = new int[n];
				int[] shu_riddle = new int[n];
				
				this.deepCopy(riddle, shu_riddle);
				this.deepCopy(privateKey, shu_privateKey);
				
				randomShuffleArray(shu_privateKey);
				randomShuffleArray(shu_riddle);
				
				
				puzzlesArray[i]= new Puzzle(shu_privateKey,shu_riddle); // insert shuffled puzzle to puzzles array
			}
			else //if exist in tree ,try to create puzzle again
				i=i-1;
		}
		
		
	}
		public Pair<String, Integer> findKey(String sIndex){
			Pair<int[], Integer> pair = tree.getPrivateKey(sIndex);
			Pair<String, Integer> pair1 = new Pair<String, Integer>(StaticFantastic.xor(pair.getKey()),pair.getValue());
			return pair1;	
		}

	public static void randomShuffleArray (int [] Arr){
		for (int i =0 ; i<Arr.length ; i++){
			swap(Arr,i,random(i,Arr.length-1));
		}	
	}
		    
	public static void swap (int[] Arr, int i ,int j){
		int temp = Arr [j];
		Arr[j]=Arr[i];
		Arr [i]= temp;
		
	}
	public static int random(int i , int j){
		int randomIndex =  i + (int)(Math.random() * ((j - i) + 1));
		return randomIndex;

	}
    //deep copy of array
	private static void deepCopy(int[] arr , int[] copyArr)
	{
		for (int i = 0; i < copyArr.length; i++) {
			copyArr[i] = arr[i];
		}
	}

}
