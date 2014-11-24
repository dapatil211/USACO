import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class concom {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileReader("concom.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));
		int n = in.nextInt();
		int[][] vals = new int[n][n];
		ArrayList<ArrayList<Integer>> controls = new ArrayList<ArrayList<Integer>>(); 
		for(int i = 0; i < n; i++){
			int k = in.nextInt(), j = in.nextInt(), p = in.nextInt();
			vals[k][j] = p;
		}
		refresh(vals, controls);
	}

	private static void refresh(int[][] vals, ArrayList<ArrayList<Integer>> controls) {
		for(int i = 0; i < controls.size(); i++){
			for(int j : controls.get(i)){
				
			}
		}
		
	}

}
