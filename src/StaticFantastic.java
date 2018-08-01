
public class StaticFantastic {
	
	public static String xor (int [] arr){
		String s="";
		
		for(int i=0; i<arr.length ;i++){
			int counter=0;
			int j= arr[i];
			while (j >= 1){
				if(j%2 == 1){
					j = j/2;
					counter=counter+1;
				}
				else j = j/2;
			}
			if (counter%2 ==0)
				s=s+"0";
			else
				s=s+"1";
		}
		return s;
	}
	
	public static int[] sortArray(int[] arr) {
		int[] ans = new int[arr.length];
		for (int i = 1; i <= arr.length; i=i+1) {
			int index = (int) (arr[i - 1] / (Math.pow(arr.length, 3)));
			ans[index] = arr[i - 1];
		}
		return ans;
	}
	
}
