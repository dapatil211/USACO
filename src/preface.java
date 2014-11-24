/*
 ID: darshan4
 LANG: JAVA
 TASK: preface
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class preface {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static int[] a = new int[7];
	public static void main(String[] args) throws IOException {
//		BufferedReader f = new BufferedReader(new FileReader("preface.txt"));
		BufferedReader f = new BufferedReader(new FileReader("preface.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
		int n = Integer.parseInt(f.readLine());
		for(int i = 1; i <= n; i++){
			roman(i);
		}
		
		int start = 0;
		for(int i = 0; i < 7; i++){
			if(a[i]!=0){
				start = i;
				break;
			}
		}
		for(int i = 6; i >= start; i--){
			switch(i){
				case 0: 
					out.println("M " + a[0]);
					break;
				case 1: 
					out.println("D " + a[1]);
					break;
				case 2: 
					out.println("C " + a[2]);
					break;
				case 3: 
					out.println("L " + a[3]);
					break;
				case 4: 
					out.println("X " + a[4]);
					break;
				case 5: 
					out.println("V " + a[5]);
					break;
				default: 
					out.println("I " + a[6]);
					break;
			}
		}
		out.close();
		f.close();
		System.exit(0);
	}
	private static void roman(int n){
		int q = n/1000;
		a[0] += q;
		n = n%1000;
		q = n/100;
		if(q > 4){
			if(q == 9){
				a[0]++;
				a[2]++;
			}
			else{
				a[1]++;
				a[2]+=(q-5);
			}
		}
		else{
			if(q == 4){
				a[1]++;
				a[2]++;
			}
			else{
				a[2]+=q;
			}
		}
		n = n %100;
		q = n/10;
		if(q > 4){
			if(q == 9){
				a[2]++;
				a[4]++;
			}
			else{
				a[3]++;
				a[4]+=(q-5);
			}
		}
		else{
			if(q == 4){
				a[4]++;
				a[3]++;
			}
			else{
				a[4]+=q;
			}
		}
		n = n %10;
		if(n == 9){
			a[6]++;
			a[4]++;
		}
		else if(n>4){
			a[5]++;
			a[6]+=(n-5);
		}
		else if(n==4){
			a[6]++;
			a[5]++;
		}
		else{
			a[6]+=n;
		}
	}

}
