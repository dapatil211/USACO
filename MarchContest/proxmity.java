/*
ID: darshan4
LANG: JAVA
TASK: proximity
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class proxmity {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("proximity.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("proximity.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] ids = new int[n];
		for(int i = 0; i < n; i++){
			ids[i] = Integer.parseInt(f.readLine());
		}
		HashMap <Integer, Integer> hm = new HashMap<Integer, Integer>();
		ArrayList<Integer> crowded = new ArrayList<Integer>();
		for(int i = 0; i < n; i++){
			if(hm.containsKey(ids[i])){
				if((hm.get(ids[i]) - i) <= k){
					crowded.add(ids[i]);
				}
			}
			hm.put(ids[i], i);
		}
		int max = -1;
		Integer[] crowds = new Integer[crowded.size()];
		crowded.toArray(crowds);
		for(int i = 0; i < crowded.size(); i++){
			if(crowds[i] > max){
				max = crowds[i];
			}
		}
		out.println(max);
		out.close();
		f.close();
		System.exit(0);

	}

}
