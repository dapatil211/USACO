/*
 ID: darshan4
 LANG: JAVA
 TASK: numtri
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class numtri {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static Node[] tree;
	static Node[] row1;
	static Node[] row2;
	static numtri x = new numtri();

	public static void main(String[] args) throws IOException {
//		long p1 = System.currentTimeMillis();
//		BufferedReader f = new BufferedReader(new FileReader("numtri.txt"));
		BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
		int r = Integer.parseInt(f.readLine());
		tree = new Node[(r*(r+1))/2];
		row1 = new Node[1];
		row1[0] = x.new Node(Integer.parseInt(f.readLine()));
		for(int i = 1; i < r; i ++){
			StringTokenizer st = new StringTokenizer(f.readLine());
//
//			int start = (i * (i + 1))/2;
//			for(int j = 0; j <= i; j++){
//				tree[start + j] = x.new Node(Integer.parseInt(st.nextToken()));
//			}
			if(r == 500){
				System.out.println();
			}
			row2 = new Node[i+1];
			for(int j= 0;j < row2.length; j++){
				row2[j] = x.new Node(Integer.parseInt(st.nextToken()));
			}
			row2[0].check(row1[0].maxSum);
			row2[row2.length-1].check(row1[row1.length-1].maxSum);
			for(int j = 1; j<row2.length-1; j++){
				row2[j].check(row1[j].maxSum);
				row2[j].check(row1[j-1].maxSum);
			}
			row1 = row2;
		}
//		for(int i = 1; i < r; i++){
//			Node[] row1 = row(i);
//			Node[] row2 = row(i-1);
//			row1[0].check(row2[0].maxSum);
//			row1[row1.length-1].check(row2[row2.length-1].maxSum);
//			for(int j = 1; j<row1.length-1; j++){
//				row1[j].check(row2[j].maxSum);
//				row1[j].check(row2[j-1].maxSum);
//			}
//		}
		int maxSum = 0;
		for(int i = 0; i < row1.length; i++){
			if(row1[i].maxSum>maxSum){
				maxSum = row1[i].maxSum;
			}
		}
//		long p2 = System.currentTimeMillis();
//		System.out.println((p2-p1)/1000.);
		out.println(maxSum);
		out.close();
		f.close();
		System.exit(0);
	}
	
	private static Node[] row(int n){
		Node[] res = new Node[n+1];
		int start = (n * (n + 1))/2;
		for(int i = start; i < start + n + 1; i++){
			res[i-start] = tree[i];
		}
		return res;
	}
	
	class Node{
		int num;
		int maxSum = 0;
		public Node(int num){
			this.num = num;
			maxSum = num;
		}
		public void check(int sum){
			if((num + sum) > maxSum){
				maxSum = num+sum;
			}
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ""+maxSum;
		}
	}

}
