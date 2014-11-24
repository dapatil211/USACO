
/*
ID: your_id_here
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.*;

class test {
	public static void main (String [] args) throws IOException {
	  // Use BufferedReader rather than RandomAccessFile; it's much faster
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crossings.txt")));
//		Random rand = new Random();
//		out.println(100000);
//		for(int i = 0; i < 100000; i++){
//			int a = rand.nextInt(2000001) - 1000000;
//			int b = rand.nextInt(2000001) - 1000000;
//			out.println(a + " " + b);
//		}
//		out.close();
//		String s = "H";
//		String t = "H";
//		String st = "Confucius say: Madam, I'm Adam.";
//		System.out.println(s == "H");
//		boolean number = false;
//		for(int i = 1; i < 1000000; i ++){
//			if(gcd(8*i+3, 6*i+2) != 1){
//				System.out.println(8*i + 3 + ", " + 6*i +2);
//				number = true;
//			}
//		}
//		if(!number){
//			System.out.println("doesn't exist");
//		}
		System.out.println(gcd(4036081, 4036065));
	}

	private static int gcd(int i, int j) {
		if(i < j){
			int temp = j;
			j = i;
			i = temp;
		}
		int r = i % j;
		if(r == 0){
			return j;
		}
		else{
			return gcd(j, r);
		}
	}
}