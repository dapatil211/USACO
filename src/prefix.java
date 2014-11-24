/*
 ID: darshan4
 LANG: JAVA
 TASK: prefix
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;


public class prefix {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static HashSet<Integer> current = new HashSet<Integer>();
	static boolean[] all;
	static String str;
	static ArrayList<String> prim = new ArrayList<String>();
	static StringBuilder match;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("prefix.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
//		long p1 = System.currentTimeMillis();
		StringTokenizer st = new StringTokenizer(f.readLine());
		String s = st.nextToken();
		while(!s.equals(".")){
			prim.add(s);
			s = st.nextToken();
			if(!st.hasMoreTokens()){
				st = new StringTokenizer(f.readLine());
			}
		}
		
//		long p2 = System.currentTimeMillis();
//		str = st.nextToken();
//		String cur = f.readLine();
//		while(cur != null){
//			str += cur;
//			cur = f.readLine();
//		}
		match = new StringBuilder(200010);
		match.append(st.nextToken());
		while(f.ready()){
			match.append(f.readLine());
		}
		all = new boolean[match.length()];
//		long p3 = System.currentTimeMillis();
		current.add(0);
		while(!current.isEmpty()){
//			if(current.contains(new Integer(999))){
//				int x = 0;
//			}
			Integer[] arr = new Integer[current.size()];
			arr = current.toArray(arr);
			for(int n : arr){
				find(n);
			}
		}
//		long p4 = System.currentTimeMillis();
//		System.out.println((p4-p1)/1000.);
//		System.out.println((p2-p1)/1000.);
//		System.out.println((p3-p2)/1000.);
//		System.out.println((p4-p3)/1000.);

		int max = 0;
		for(int i = all.length-1; i >= 0; i--){
			if(all[i]){
				max = i+1;
				break;
			}
		}
		out.println(max);
		out.close();
		f.close();
		System.exit(0);
	}
	private static void find(int n){
		current.remove(n);
		for(String s : prim){
			if(match.length()>=n+s.length() && all.length>=(n+s.length())&&match.substring(n, n+s.length()).equals(s) && !all[n+s.length()-1]){
				current.add(n+s.length());
				all[n+s.length()-1] = true;
			}
		}
		
		
	}

}
