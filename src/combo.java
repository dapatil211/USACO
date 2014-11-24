/*
 ID: darshan4
 LANG: JAVA
 TASK: combo
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;


public class combo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new FileReader(new File("combo.in")));
		PrintWriter out = new PrintWriter(new FileWriter(new File("combo.out")));
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		HashSet<comb> valid = new HashSet<comb>();
		combo c = new combo();
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int fx = Integer.parseInt(st.nextToken());
		int fy = Integer.parseInt(st.nextToken());
		int fz = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int mx = Integer.parseInt(st.nextToken());
		int my = Integer.parseInt(st.nextToken());
		int mz = Integer.parseInt(st.nextToken());
		for(int x = -2; x <= 2; x++){
			for(int y = -2; y <= 2; y++){
				for(int z = -2; z <= 2; z++){
					valid.add(c.new comb((fx + x + n) % n, (fy + y + n) % n, (fz + z + n) % n));
					valid.add(c.new comb((mx + x + n) % n, (my + y + n) % n, (mz + z + n) % n));
				}
			}
		}
//		System.out.println(valid.size());
		out.println(valid.size());
		out.close();
		bf.close();
		System.exit(0);
	}
	
	private class comb{
		int x, y, z;
		public comb(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		@Override
		public boolean equals(Object obj) {
			comb c = (comb) obj;
			return c.x == x && c.y == y && c.z == z;
		}
		@Override
		public int hashCode() {
			String s = "" + x + y + z;
			return s.hashCode();
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.format("[%d, %d, %d]", x, y, z);
		}
	}

}
