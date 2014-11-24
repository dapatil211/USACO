/*
 ID: darshan4
 LANG: JAVA
 TASK: lamps
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class lamps {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("lamps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
		lamps l = new lamps();
		int n = Integer.parseInt(f.readLine());
		int c = Integer.parseInt(f.readLine());
		HashSet<Config> hs = new HashSet<Config>();
		hs.add(l.new Config(n));
		String on = f.readLine();
		String off = f.readLine();
		for(int i = 0; i <c; i++){
			HashSet<Config> hash = new HashSet<Config>();
			for(Config con : hs){				
				hash.add(l.new Config(con.turn(0)));
				hash.add(l.new Config(con.turn(1)));
				hash.add(l.new Config(con.turn(2)));
				hash.add(l.new Config(con.turn(3)));
			}
			hs = hash;
		}
		HashSet<Config> hash = new HashSet<Config>();
		for(Config con : hs){
			if(con.offPoss(off) && con.onPoss(on)){
				hash.add(con);
			}
		}
		hs = hash;
		Config[] a = new Config[hs.size()];
		a = hs.toArray(a);
		Arrays.sort(a);
		if(a.length>0){
			for(Config co : a){
				out.println(co);
			}
		}
		else{
			out.println("IMPOSSIBLE");
		}
		out.close();
		f.close();
		System.exit(0);
	}
	class Config implements Comparable<Config>{
		boolean[] arr;
		public Config(int n) {
			arr = new boolean[n];
			Arrays.fill(arr, true);
		}
		public Config(boolean[] arr) {
			this.arr = arr;
		}
		@Override

		public String toString() {
			String s = "";
			for(boolean i : arr){
				if(i){
					s+=1;
				}
				else{
					s+=0;
				}
			}
			return s;
		}
		@Override
		public boolean equals(Object arg0) {
			Config c = (Config) arg0;
			for(int i = 0; i < arr.length; i++){
				if(arr[i] != c.arr[i]){
					return false;
				}
			}
			return true;
		}
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Arrays.hashCode(arr);
		}
		public boolean[] turn(int n){
			boolean[] arr1 = Arrays.copyOf(arr, arr.length);
			if(n == 0){
				for(int i = 0; i < arr.length; i++){
					arr1[i] = !arr1[i];
				}
			}
			else if(n == 1){
				for(int i = 0; i < arr.length; i+=2){
					arr1[i] = !arr1[i];
				}
			}
			else if(n == 2){
				for(int i = 1; i < arr.length; i+=2){
					arr1[i] = !arr1[i];
				}
			}
			else{
				for(int i =0; i < arr.length; i+=3){
					arr1[i] = !arr1[i];
				}
			}
			return arr1;
		}
		public boolean onPoss(String on){
			StringTokenizer st = new StringTokenizer(on);
			int n = Integer.parseInt(st.nextToken());
			while(n != -1){
				if(!arr[n-1]){
					return false;
				}
				n = Integer.parseInt(st.nextToken());
			}
			return true;
		}
		public boolean offPoss(String off){
			StringTokenizer st = new StringTokenizer(off);
			int n = Integer.parseInt(st.nextToken());
			while(n != -1){
				if(arr[n-1]){
					return false;
				}
				n = Integer.parseInt(st.nextToken());
			}
			return true;
		}
		@Override
		public int compareTo(Config c) {
			for(int i = 0; i < arr.length; i++){
				if(arr[i]){
					if(!c.arr[i]){
						return 1;
					}
					else{
						continue;
					}
				}
				else{
					if(c.arr[i]){
						return -1;
					}
					else{
						continue;
					}
				}
			}
			return 0;
		}
	}

	
}
