/*
ID: darshan4
LANG: JAVA
TASK: cowrace
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class cowrace {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cowrace.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowrace.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer> bessieTime = new ArrayList<Integer>();
		ArrayList<Integer> bessieSpeed = new ArrayList<Integer>();
		ArrayList<Integer> elsieTime = new ArrayList<Integer>();
		ArrayList<Integer> elsieSpeed = new ArrayList<Integer>();

		for(int i = 0; i < n; i ++){
			st = new StringTokenizer(f.readLine());
			bessieSpeed.add(Integer.parseInt(st.nextToken()));
			bessieTime.add(Integer.parseInt(st.nextToken()));
		}
		for(int i = 0; i < m; i ++){
			st = new StringTokenizer(f.readLine());
			elsieSpeed.add(Integer.parseInt(st.nextToken()));
			elsieTime.add(Integer.parseInt(st.nextToken()));
		}
		boolean leadb = (bessieTime.get(0)*bessieSpeed.get(0) > (elsieTime.get(0)*elsieSpeed.get(0)));
		int bessiedist = 0;
		int elsiedist = 0;
		int counter = 0;
		while(true){
			int bt = bessieTime.get(0);
			int et = elsieTime.get(0);
			boolean bessie = (bt < et);
			if(bessie){
				bessiedist+= (bt * bessieSpeed.get(0));
				elsiedist+= (bt * elsieSpeed.get(0));
				elsieTime.set(0, et-bessieTime.remove(0));
				bessieSpeed.remove(0);		
			}
			else{
				bessiedist+= (et * bessieSpeed.get(0));
				elsiedist+= (et* elsieSpeed.get(0));
				bessieTime.set(0, bt- elsieTime.remove(0));
				elsieSpeed.remove(0);
			}
			
			if(leadb && elsiedist>bessiedist){
				counter ++;
				leadb = !leadb;
			}
			else if(!leadb && elsiedist<bessiedist){
				counter++;
				leadb = !leadb;
			}
			if(bessieTime.size() == 0 || elsieTime.size() == 0){
				break;
			}
			if(bessieTime.get(0) == 0){
				bessieTime.remove(0);
				bessieSpeed.remove(0);
			}
			if(elsieTime.get(0) == 0){
				elsieTime.remove(0);
				elsieSpeed.remove(0);
			}
		}
		out.println(counter);
		f.close();
		out.close();
		System.exit(0);
	}
}
