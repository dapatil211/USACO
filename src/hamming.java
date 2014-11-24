/*
 ID: darshan4
 LANG: JAVA
 TASK: hamming
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


public class hamming {

	/**
	 * @param args
	 */
	static int n, b, d;
	static ArrayList<Integer> l = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
//		BufferedReader f = new BufferedReader(new FileReader("hamming.txt"));
		BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		l.add(0);
		for(int i = 1; i < Math.pow(2, b); i++){
			if(ham(i, d)){
				l.add(i);
				if(l.size() == n){
					break;
				}
			}
		}
		Collections.sort(l);
		int x = (l.size())/10;
		for(int i = 0; i < x; i++){
			out.print(l.remove(0));
			for(int j = 0; j < 9; j++){
				out.print(" " + l.remove(0));
			}
			out.println();
		}
		if(l.size()!=0){
			out.print(l.remove(0));
			for(int i = 0; i < l.size();){
				out.print(" " + l.remove(0));
			}
			out.println();
		}
		f.close();
		out.close();
		System.exit(0);
	}
	
	public static boolean ham(int a, int d){
		String s = padzeros(Integer.toBinaryString(a), b);
		String cur ="";
		for(int i = 0; i < l.size(); i++){
			cur = padzeros(Integer.toBinaryString(l.get(i)), b);
			if(diff(s, cur) < d){
				return false;
			}
		}
		return true;
	}

	private static int diff(String s, String cur) {
		int res = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i)!= cur.charAt(i)){
				res++;
			}
		}
		return res;
	}

	private static String padzeros(String s, int b2) {
		while(s.length() < b2){
			s = "0" + s;
		}
		return s;
	}

}
