/*
ID: darshan4
LANG: JAVA
TASK: assign
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class assign {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("assign.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("assign.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String[][] cows = new String[n][n];
		for(int i = 0; i < n; i ++){
			for(int j = 0; j < cows[i].length; j++){
				if(i == j){
					cows[i][j] = "S";
				}
				else{
					cows[i][j] = "U";
				}
			}
		}
		
		for(int i = 0; i < k; i ++){
			st = new StringTokenizer(f.readLine());
			cows = setRels(cows, st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		boolean imp = false;
		bigLoop:
		for(int i = n-1; i >= 0; i--){
			for(int j = 0; j < n; j++){
				if(cows[i][j] != "U"){
					cows = upOne(cows, i, j);
					if(cfI(cows, i)){
						imp = true;
						break bigLoop;
					}
				}
			}
		}
		boolean[] checked = new boolean[n];
		int counter = 1;
		for(int i = 0; i < n; i++){
			if(!checked[i]){
				ArrayList<Integer> l = checkforD(cows, i);
				ArrayList<Integer> m = checkforS(cows, i);
				if(l.size() == 0){
					counter *= 3;
				}
				else{
					counter *= 6;
					int ls = l.size();
					for(int j = 0; j < ls; j++){
						checked[l.remove(0)] = true;
					
					}
				}
				int ms = m.size();
				for(int j = 0; j < ms; j++){
					checked[m.remove(0)] = true;
				}
			}
			checked[i] = true;
		}
		
//		int n = 13;
//		ArrayList<String> combos = new ArrayList<String>();
//		combos = perm(combos, "", n);
//		System.out.println(combos.size());
		if(imp){
			out.println("0");
		}
		else{
			out.println(counter);
		}
		f.close();
		out.close();
		System.exit(0);
	}

	private static ArrayList<Integer> checkforS(String[][] cows, int i) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int j = 0; j < cows[i].length; j++){
			if(cows[i][j].equalsIgnoreCase("S")){
				l.add(j);
			}
		}
		return l;
	}

	private static ArrayList<Integer> checkforD(String[][] cows, int i) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int j = 0; j < cows[i].length; j++){
			if(cows[i][j].equalsIgnoreCase("D")){
				l.add(j);
			}
		}
		return l;
	}

	private static boolean cfI(String[][] cows, int i) {
		for(int j = 0; j < cows[i].length; j ++){
			if(cows[i][j].equalsIgnoreCase("I")){
				return true;
			}
		}
		return false;
	}

	private static String[][] upOne(String[][] cows, int i, int j) {
		if(cows[i][j].equalsIgnoreCase("S")){
			for(int k = 0; k < cows.length; k ++){
				if(!cows[j][k].equalsIgnoreCase(cows[i][k]) && !cows[i][k].equalsIgnoreCase("U")){
					cows[i][k] = "I";
				}
				else if(cows[j][k].equalsIgnoreCase("S")){
					cows[i][k] = "S";
				}
				else if(cows[j][k].equalsIgnoreCase("D")){
					cows[i][k] = "D";
				}
			}
		}
		else{
			for(int k = 0; k < cows.length; k ++){
				if(cows[j][k].equalsIgnoreCase(cows[i][k]) && !cows[j][k].equalsIgnoreCase("U")){
					cows[i][k] = "I";
				}
				else if(cows[j][k].equalsIgnoreCase("S")){
					cows[i][k] = "D";
				}
				else if(cows[j][k].equalsIgnoreCase("D")){
					cows[i][k] = "S";
				}
			}
		}
		return cows;
	}

	private static String[][] setRels(String[][] cows, String rel, int i, int j) {
		cows[i-1][j-1] = rel;
		cows[j-1][i-1] = rel;
		return cows;
	}

//	private static ArrayList<String> perm(ArrayList<String> combos, String st, int n) {
//		if(n == 0){
//			combos.add(st);
//			return combos;
//		}
//		else{
//			perm(combos, st + "H", n-1);
//			perm(combos, st + "J", n-1);
//			perm(combos, st + "G", n-1);
//			return combos;
//		}
//	}

}
