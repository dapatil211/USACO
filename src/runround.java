/*
 ID: darshan4
 LANG: JAVA
 TASK: runround
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class runround {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("runround.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
		long n = Long.parseLong(f.readLine());
		long i;
		for(i = n+1; i < Long.MAX_VALUE; i++){
			if(isRound(i)){
				break;
			}
		}
		out.println(i);
		f.close();
		out.close();
		System.exit(0);
	}
	private static boolean isRound(long i2){
		if(!unique(i2)){
			return false;
		}
		String s = ""+i2;
		int l = s.length();
		int d = Character.getNumericValue(s.charAt(0));
		boolean[] visited = new boolean[l];
		visited[0] = true;
		int curInd = 0;
		for(int i = 0; i < l-1; i++){
			curInd = (curInd + d) % l;
			if(visited[curInd]){
				return false;
			}
			visited[curInd] = true;
			d = Character.getNumericValue(s.charAt(curInd));
		}
		if((curInd + d)%l == 0){
			return true;
		}
		else{
			return false;
		}
	}
	private static boolean unique(long i2) {
		String s = ""+i2;
		boolean[] visited = new boolean[10];
		visited[0] = true;
		for(int i = 0; i < s.length(); i++){
			int x = Character.getNumericValue(s.charAt(i));
			if(visited[x]){
				return false;
			}
			visited[x] = true;
		}
		return true;
	}
	

}
