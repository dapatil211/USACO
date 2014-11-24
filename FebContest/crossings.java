/*
ID: darshan4
LANG: JAVA
TASK: crossings
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.StringTokenizer;


public class crossings {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("crossings.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crossings.out")));
	    int numCows = Integer.parseInt(f.readLine());
	    HashMap<Integer, Integer> cows = new HashMap<Integer, Integer>();
	    for(int i = 0; i < numCows; i++){
	    	StringTokenizer st = new StringTokenizer(f.readLine());
	    	cows.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	    }
	    List<Entry<Integer,Integer>> entries = new ArrayList<Entry<Integer,Integer>>(cows.entrySet());
	    Collections.sort(entries, new setSorter());
	    int unsafecows = 0;
	    while(!entries.isEmpty()){
	    	unsafecows += findInts(entries.get(0), entries);
	    }
	    out.println(numCows-unsafecows);
	    out.close();
	    f.close();
	    System.exit(0);
	}
	
	public static int findInts(Entry<Integer, Integer> entry, List<Entry<Integer,Integer>> entries){
		int maxInt = 0;
		int numunsafe = 0;
		ListIterator<Entry<Integer, Integer>> it = entries.listIterator();
    	while(it.hasNext()){
    		if(checkInt(entry, it.next())){
    			maxInt = it.nextIndex()-1;
    		}
    	}
    	if (maxInt == 0){
    		entries.remove(0);
    	}
    	else{
    		for(int i = maxInt; i >= 0; i--){
    			entries.remove(i);
				numunsafe  ++;
    		}
    	}
    	return numunsafe;
	}
	
	public static boolean checkInt(Entry<Integer, Integer> i, Entry<Integer, Integer> j){
		
		if(i.getKey() - j.getKey() > 0 && i.getValue() - j.getValue() > 0){
			return false;
		}
		else if(i.getKey() - j.getKey() < 0 && i.getValue() - j.getValue() < 0){
			return false;
		}
		else{
			return true;
		}
	}
	static class setSorter implements Comparator<Entry<Integer, Integer>>{

		@Override
		public int compare(Entry<Integer, Integer> arg0,
				Entry<Integer, Integer> arg1) {
			if(arg0.getKey() > arg1.getKey()){
				return 1;
			}
			else{
				return -1;
			}
		}
		
	}
}