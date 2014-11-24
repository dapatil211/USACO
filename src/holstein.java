/*
 ID: darshan4
 LANG: JAVA
 TASK: holstein
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class holstein {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static int[] cow;
	static int[][] feed;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
		int v = Integer.parseInt(f.readLine());
		cow = new int[v];
		StringTokenizer st = new StringTokenizer(f.readLine());
		for(int i = 0; i < v; i++){
			cow[i] = Integer.parseInt(st.nextToken());
		}
		int g = Integer.parseInt(f.readLine());
		feed = new int[g][v];
		for(int i = 0; i<g; i++){
			st = new StringTokenizer(f.readLine());
			for(int j = 0; j<v; j++){
				feed[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<String> works = new ArrayList<String>();
		for(int i = 1; i < Math.pow(2, g); i++){
			String s = Integer.toBinaryString(i);
			if(check(s)){
				works.add(s);
			}
		}
		int min = g;
		int size = works.size();
		for(int i = 0; i < size ; i++){
			String s = works.remove(0);
			int n = num1(s);
			if(n <= min){
				works.add(s);
				min = n;
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		size = works.size();
		for(int i = 0; i < size; i++){
			String s = works.remove(0);
			if(num1(s)==min){
				list.add(Integer.parseInt(s, 2));
			}
		}
		Collections.sort(list);
		String res = Integer.toBinaryString(list.get(list.size()-1));
		res = padzeros(res, feed.length);
		out.print(num1(res));
		for(int i = 0; i < res.length(); i++){
			if(res.charAt(i) == '1'){
				out.print(" " + (i+1));
			}
		}
		out.println();
		out.close();
		f.close();
		System.exit(0);
	}
	private static int num1(String s) {
		int res = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '1'){
				res++;
			}
		}
		return res;
	}
	private static boolean check(String s) {
		s = padzeros(s, feed.length);
		
		int[] cur = new int[cow.length];
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) == '1'){
				for(int j = 0; j<feed[0].length; j++){
					cur[j]+=feed[i][j];
				}
			}
		}
		for(int i = 0; i<cur.length; i++){
			if(cur[i]<cow[i]){
				return false;
			}
		}
		return true;
	}
	private static String padzeros(String s, int length) {
		while(s.length()<length){
			s = "0" +s;
		}
		return s;
		
	}

}
