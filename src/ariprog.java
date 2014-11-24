/*
ID: darshan4
LANG: JAVA
TASK: ariprog
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
//import java.util.Iterator;


public class ariprog {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
		int n = Integer.parseInt(f.readLine());
		int m = Integer.parseInt(f.readLine());
	    int interval_limit = (2 * m*m + 1) / (n - 1);  

		ArrayList<Integer> li = new ArrayList<Integer>();
		boolean[] values = new boolean[2*m*m + 1];
		for(int i = 0; i <= m; i ++){
			for(int j = i; j <= m; j++){
				int x = i*i + j*j;
				values[x] = true;
				li.add(x);
			}
		}
		HashSet<ans> hs = new HashSet<ans>();
		Collections.sort(li);
//		Iterator<Integer> it1 = li.iterator();
//		while(it1.hasNext()){ 
//			int square = it1.next();
//			Iterator<Integer> it = li.iterator();
//			while(it.hasNext()){
//				int o = it.next()-square;
//				if(o!=0 && seqWorks(square, o, values, n)){
//					ans a = new ariprog().new ans(square, o);
//					if(!hs.contains(a))
//					hs.add(a);
//				}
//			}
//			
//			
//		}
		 for (int i = 1; i < interval_limit+1; i++) {  
		        int limit = (2 * m*m + 1 - (n - 1) * i);  
		        for (int k = 0; k < li.size() && li.get(k) < limit; k++) {  
			        if (seqWorks(li.get(k), i, values, n)) {  
			            hs.add(new ariprog().new ans(li.get(k), i));
			              
			        }  
		        }  
		    }  
		Object[] a = hs.toArray();
		Arrays.sort(a);
		
		if(a.length == 0){
			out.println("NONE");
		}
		for(int i = 0; i < a.length; i++){
			out.println(a[i]);
		}
		f.close();
		out.close();
		System.exit(0);
	}

	private static boolean seqWorks(int square, int k, boolean[] values, int n) {
		for(int i = 0; i < n; i++){
			try{
				if(!values[square + i*k]){
					return false;
				}
			}catch(ArrayIndexOutOfBoundsException e){
				return false;
			}
			
		}
		return true;
	}
	
	class ans implements Comparable<ans>{
		
		int square;
		int diff;
		@Override
		public int compareTo(ans o) {
			int x = diff - o.diff;
			if(x==0){
				x = square-o.square;
			}
			return x;
		}
		@Override
	    public int hashCode() {
	        return Arrays.hashCode( new int[] { square, diff } );
	    }
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			ans a = (ans) obj;
			return(a.diff == diff && a.square == square);
		}
		public ans(int square, int diff) {
			this.square = square;
			this.diff = diff;
		}
		@Override
		public String toString() {
		    return square + " " + diff;
		  }
	}

}
