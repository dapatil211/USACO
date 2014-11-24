/*
 ID: darshan4
 PROG: zerosum
 LANG: JAVA
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class zerosum {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static ArrayList<String[]> l = new ArrayList<String[]>();
	static ArrayList<String[]> works = new ArrayList<String[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("zerosum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));
		int n = Integer.parseInt(f.readLine());
		String[] x = new String[2*n-1];
		for(int i = 0; i < n; i++){
			x[2*i] = ""+(i+1);
		}
		l.add(x);
		perm(1, n);
		
		int size = l.size();
		for(int i = 0; i < size; i++){
			String[] p = l.remove(0);
			if(eval(p) == 0){
				works.add(p);
			}
		}
		size = works.size();
		for(int i = 0; i <size; i++){
			out.println(print(works.remove(0)));
		}
		out.close();
		f.close();
		System.exit(0);
	}
	private static String print(String[] x){
		String s = "";
		for(int i = 0; i < x.length; i++){
			s+= x[i];
		}
		return s;
	}
	private static void perm(int x, int n){
		if(x>= 2*n-1){
			return;
		}
		int s = l.size();
		for(int i = 0; i < s; i++){
			String[] st1 = l.remove(0);
			String[] st2 = copy(st1);
			String[] st3 = copy(st1);
			st1[x] = " ";
			st2[x] = "+";
			st3[x] = "-";
			l.add(st1);
			l.add(st2);
			l.add(st3);
		}
		perm(x+2, n);
	}
	private static String[] copy(String[] n){
		String[] st = new String[n.length];
		for(int i = 0; i < n.length; i++){
			if(n[i]!=null){
				st[i] = new String(n[i]);
			}
		}
		return st;
	}
	private static int eval(String[] ar){
		String temp = ar[0];
		ArrayList<Integer> a= new ArrayList<Integer>(); 
		for(int i = 1; i < ar.length; i+=2){
			if(ar[i].equals(" ")){
				temp+=ar[i+1];
			}
			else if(ar[i].equals("-")){
				a.add(Integer.parseInt(temp));
				temp = "-" + ar[i+1];
			}
			else{
				a.add(Integer.parseInt(temp));
				temp = ar[i+1];
			}
		}
		a.add(Integer.parseInt(temp));
		int size = a.size();
		int res = 0;
		for(int i = 0; i < size; i++){
			res += a.remove(0);
		}
		return res;
	}
}
