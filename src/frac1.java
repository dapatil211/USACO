/*
 ID: darshan4
 LANG: JAVA
 TASK: frac1
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;


public class frac1 {

	/**
	 * @param args
	 */
	class fraction implements Comparable<fraction>{
		int num, den;
		double val;
		public fraction(int num, int den) {
			this.num = num;
			this.den = den;
			val = (double) num/den;
		}
		@Override
		public boolean equals(Object obj) {
			fraction x = (fraction) obj;
			return x.val == val;
		}
		@Override
		public int compareTo(fraction o) {
			if(val>o.val)
				return 1;
			else if(val<o.val){
				return -1;
			}
			else
				return 0;
		}
		@Override
		public String toString() {
			return num + "/" + den;
		}
		@Override
		public int hashCode()
		{return Double.valueOf(val).hashCode();}
		
	}
	static HashSet<fraction> x = new HashSet<fraction>();
	static frac1 c = new frac1();
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
		int n = Integer.parseInt(f.readLine());
		for(int i = 1; i <= n; i++){
			for(int j = 0; j <= i; j++){
				x.add(c.new fraction(j, i));
			}
		}
//		System.out.println(c.new fraction(0, 5).equals(c.new fraction(0,1)));
		fraction[] a = new fraction[x.size()];
		a = x.toArray(a);
		Arrays.sort(a);
		for(int i = 0; i < a.length; i++){
			out.println(a[i]);
		}
		f.close();
		out.close();
		System.exit(0);
	}

}
