/*
ID: darshan4
LANG: JAVA
TASK: photo
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class photo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("photo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] breaks = new boolean[n];
		int[][] pairs = new int[k][2];
		for(int i = 0; i <k; i++){
			st = new StringTokenizer(f.readLine());
			pairs[i][0] = Integer.parseInt(st.nextToken())-1;
			pairs[i][1] = Integer.parseInt(st.nextToken())-1;
		}
		for(int i = 0; i < k; i ++){
			int x = pairs[i][0];
			int y = pairs[i][1]-1;
			for(int j = i+1; j<k; j++){
				if(included(x, y, pairs[j])){
					y = pairs[j][1]-1;
				}
			}
			boolean noneed = false;
			for(int j = x; j<y; j++){
				if(breaks[j]){
					noneed = true;
				}
			}
			if(!noneed){
				breaks[y] = true;
			}
		}
		int counter = 1;
		for(int i = 0; i< breaks.length; i++){
			if(breaks[i]){
				counter++;
			}
		}
		out.println(counter);
		f.close();
		out.close();
		System.exit(0);
	}

	private static boolean included(int x, int y, int[] pairs) {
		int dx = pairs[0]-x;
		int dy = pairs[1]-y;
		if(dx>=0 && dy<0){
			return true;
		}
		else{
			return false;
		}
	}

}
