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
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class blink {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("blink.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blink.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		boolean[] init = new boolean[n];
		for(int i = 0; i < n; i++){
			if(Integer.parseInt(f.readLine()) == 0){
				init[i] = false;
			}
			else{
				init[i] = true;
			}
		}
		HashSet<Config> hs = new HashSet<Config>();
		ArrayList<Config> al = new ArrayList<Config>();
		blink bl = new blink();
		Config co = bl.new Config(init);
		hs.add(co);
		al.add(co);
		while(true){
			init = cycle(init);
			if(hs.contains(bl.new Config(init))){
				break;
			}
			else{
				Config c = bl.new Config(init);
				hs.add(c);
				al.add(c);
			}
		}
		Config c = bl.new Config(init);
		int start = 0;
		for(int i = 0; i < al.size(); i++){
			if(al.get(i).equals(c)){
				start = i;
				break;
			}
		}
		int cycle = al.size() - start;
		b -= (al.size() - 1);
		b = b % cycle;
		b = (b + cycle - 1) % cycle;
		boolean[] res = al.get((int) (start + b)).conf;
		for(int i = 0; i < res.length; i++){
			if(res[i]){
				out.println(1);
			}
			else{
				out.println(0);
			}
		}
		f.close();
		out.close();
		System.exit(0);
	}
	
	private static boolean[] cycle(boolean[] init) {
		boolean[] res = new boolean[init.length];
		for(int i = 0; i < init.length; i++){
			res[i] = init[i];
		}
		for(int i = 0; i < init.length; i ++){
			if(init[i]){
				res[(i+1)%res.length] = !init[(i+1)%res.length];
			}
		}
		return res;
	}

	class Config{
		boolean[] conf;
		public Config(boolean[] a) {
			conf = new boolean[a.length];
			for(int i = 0; i < a.length; i++){
				conf[i] = a[i];
			}
		}
		@Override
		public boolean equals(Object obj) {
			Config c = (Config) obj;
			for(int i = 0; i < conf.length; i++){
				if(conf[i] != c.conf[i]){
					return false;
				}
			}
			return true;
		}
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Arrays.hashCode(conf);
		}
		@Override
		public String toString() {
			String s = "";
			s+="[" + conf[0];
			for(int i = 1; i< conf.length; i++){
				s+="," + conf[i];
			}
			s+="]";
			return s;
		}
	}

}
