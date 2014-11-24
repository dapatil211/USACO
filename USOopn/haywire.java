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
import java.util.Arrays;
import java.util.StringTokenizer;


public class haywire {

	/**
	 * @param args
	 */
	static int[] stalls;
	static friendgroup[] fg;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("haywire.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haywire.out")));
		haywire h = new haywire();
		int n = Integer.parseInt(f.readLine());
		fg = new friendgroup[n];
		stalls = new int[n];
		StringTokenizer st;
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(f.readLine());
			fg[i] = h.new friendgroup(i, Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
			stalls[i] = i;
		}
		int[] rep = swapcyc();
		while(!Arrays.equals(rep, stalls)){
			stalls = rep;
			rep = swapcyc();
		}
		out.println(calc(stalls));
		f.close();
		out.close();
		System.exit(0);
	}
	private static int[] swapcyc() {
		int value = calc(stalls);
		int[] arr = stalls.clone();
		for(int i = 0; i < fg.length; i++){
			for(int j = i+1; j < fg.length; j++){
				int[] rep = swap(i, j, arr.clone());
				int x = calc(rep);
				
				if(x<value){
					value = x;
					arr = rep;
				}
			}
		}
		return arr;
	}
	private static int[] swap(int i, int j, int[] arr){
		int x = arr[i];
		arr[i] = arr[j];
		arr[j] = x;
		return arr;
	}
	private static int calc(int[] stalls){
		int counter = 0;
		for(int i = 0; i < fg.length; i++){
			counter+=fg[i].total(stalls);
		}
		return counter/2;
	}
	class friendgroup{
		int num, f1, f2, f3;
		public friendgroup(int num, int f1, int f2, int f3) {
			this.num = num;
			this.f1 = f1-1;
			this.f2 = f2-1;
			this.f3 = f3-1;
		}
		private int total(int[] stalls){
			int counter = 0;
			counter += Math.abs(find(num, stalls)-find(f1, stalls));
			counter += Math.abs(find(num, stalls)-find(f2, stalls));
			counter += Math.abs(find(num, stalls)-find(f3, stalls));
			return counter;
		}
		private int find(int num, int[] stalls){
			for(int i = 0; i < stalls.length; i++){
				if(stalls[i] == num){
					return i;
				}
			}
			return 0;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return num + " => " + f1 + ", " +f2 + ", "+f3 + ", ";
		}
	}
}
