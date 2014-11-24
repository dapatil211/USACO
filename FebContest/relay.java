/*
ID: darshan4
LANG: JAVA
TASK: relay
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;


public class relay {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	static HashMap<Integer, Boolean> loopyCows = new HashMap<Integer, Boolean>();
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("relay.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("relay.out")));
		int numCows = Integer.parseInt(f.readLine());
		int[] arr = new int[numCows];
		for(int i = 0; i < numCows; i++){
			arr[i] = Integer.parseInt(f.readLine())-1;
		}
		int nonLoopy = 0;
		for(int i = 0; i < numCows; i++){
			if(!isLoopy(arr, i, new HashMap<Integer, Boolean>())){
				nonLoopy ++;
			}
		}
		out.println(nonLoopy);
		f.close();
		out.close();
		System.exit(0);
	}
	
	public static boolean isLoopy(int[] arr, int cow, HashMap<Integer, Boolean> cowsSeen){
		if(arr[cow] == -1){
			return false;
		}
		else if(loopyCows.containsKey(cow)){
			return true;
		}
		else if(loopyCows.containsKey(arr[cow])||cowsSeen.containsKey(arr[cow])){
			for(Integer key : cowsSeen.keySet()){
				loopyCows.put(key, null);
			}
			return true;
		}
		else{
			cowsSeen.put(cow, null);
			return isLoopy(arr, arr[cow], cowsSeen);
		}
	}

}
