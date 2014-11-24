/*
 ID: darshan4
 LANG: JAVA
 TASK: milk3
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


public class milk3 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static int capacityA;
	static int capacityB;
	static int capacityC;
	static milk3 a = new milk3();
	static HashSet<node> seen = new HashSet<node>();
	static HashSet<Integer> A0 = new HashSet<Integer>();


	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		capacityA = Integer.parseInt(st.nextToken());
		capacityB = Integer.parseInt(st.nextToken());
		capacityC = Integer.parseInt(st.nextToken());
		
		node root = a.new node(0, 0, capacityC);
		pour(root);
		Object[] arr = A0.toArray();
		Arrays.sort(arr);
		out.print(arr[0]);
		for(int i = 1; i < arr.length; i++){
			out.print(" " + arr[i]);
		}
		out.println();
		f.close();
		out.close();
		System.exit(0);
	}
	
	private static void pour(node root) {
		if(seen.contains(root)){
			return;
		}
		seen.add(root);
		if(root.aEmpty()){
			A0.add(root.c);
		}
		node[] newNodes = new node[6];
		newNodes[0] = transfer(0, 1, root);
		newNodes[1] = transfer(1, 0, root);
		newNodes[2] = transfer(2, 1, root);
		newNodes[3] = transfer(1, 2, root);
		newNodes[4] = transfer(0, 2, root);
		newNodes[5] = transfer(2, 0, root);
		for(int i = 0; i < 6; i++){
			pour(newNodes[i]);
		}
		
	}
	private static node transfer(int x, int y, node root){
		int capacity = 0;
		int milk = 0;
		if(y == 0){
			milk = root.a;
			if(x == 1){
				capacity = capacityB - root.b;
				if(milk > capacity){
					milk -= capacity;
					capacity = 0;
					return a.new node(milk, capacityB-capacity, root.c);
				}
				else{
					capacity -= milk;
					milk = 0;
					return a.new node(milk, capacityB-capacity, root.c);
				}
			}
			else{
				capacity = capacityC - root.c;
				if(milk > capacity){
					milk -= capacity;
					capacity = 0;
					return a.new node(milk, root.b , capacityC-capacity);
				}
				else{
					capacity -= milk;
					milk = 0;
					return a.new node(milk, root.b , capacityC-capacity);
				}
			}
		}
		else if(y == 1){
			milk = root.b;
			if(x == 0){
				capacity = capacityA - root.a;
				if(milk > capacity){
					milk -= capacity;
					capacity = 0;
					return a.new node(capacityA-capacity, milk, root.c);
				}
				else{
					capacity -= milk;
					milk = 0;
					return a.new node(capacityA-capacity, milk, root.c);
				}
			}
			else{
				capacity = capacityC - root.c;
				if(milk > capacity){
					milk -= capacity;
					capacity = 0;
					return a.new node(root.a, milk , capacityC-capacity);
				}
				else{
					capacity -= milk;
					milk = 0;
					return a.new node(root.a, milk , capacityC-capacity);
				}
			}
		}
		else{
			milk = root.c;
			if(x == 0){
				capacity = capacityA - root.a;
				if(milk > capacity){
					milk -= capacity;
					capacity = 0;
					return a.new node(capacityA-capacity, root.b, milk);
				}
				else{
					capacity -= milk;
					milk = 0;
					return a.new node(capacityA-capacity, root.b, milk);
				}
			}
			else{
				capacity = capacityB - root.b;
				if(milk > capacity){
					milk -= capacity;
					capacity = 0;
					return a.new node(root.a, capacityB-capacity, milk);
				}
				else{
					capacity -= milk;
					milk = 0;
					return a.new node(root.a, capacityB-capacity, milk);
				}
			}
		}
		
		
	}
	class node{
		int a;
		int b;
		int c;
		public node(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		public boolean aEmpty(){
			return(a == 0);
		}
		
		@Override
		public boolean equals(Object obj) {
			node x = (node) obj;
			return(a == x.a && b == x.b && c == x.c);
		}
		@Override
	    public int hashCode() {
	        return Arrays.hashCode( new int[] { a, b, c } );
	    }
		
		@Override
		public String toString() {
			return("["+a + ", " + b + ", " + c+"]");
		}
	}

}
