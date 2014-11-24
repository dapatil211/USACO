/*
 ID: darshan4
 LANG: JAVA
 TASK: castle
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;


public class castle {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static castle x = new castle();
	static ArrayList<Integer> sizes = new ArrayList<Integer>();
	static ArrayList<Integer> nsizes = new ArrayList<Integer>();
	static ArrayList<String> rem = new ArrayList<String>();
	static boolean[][] visited;
	static Node[][] graph;
	static int rooms = 0;
	public static void main(String[] args) throws IOException {
//		long p1 = System.currentTimeMillis();
		BufferedReader f = new BufferedReader(new FileReader("castle.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		graph = new Node[n][m];
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(f.readLine());
			for(int j = 0; j<m; j++){
				graph[i][j] = x.new Node(Integer.parseInt(st.nextToken()), i, j);
			}
		}
//		long p2 = System.currentTimeMillis();

		for(int i = 0; i < graph.length; i ++){
			for(int j = 0; j < graph[0].length; j++){
				if(!visited[i][j]){
					sizes.add(dfs(i, j));
					rooms++;
				}

			}
		}
//		long p3 = System.currentTimeMillis();

		for(int i = 0; i < graph.length; i ++){
			for(int j = 0; j < graph[0].length; j++){
				if(i!=0 && (graph[i][j].top)){
					graph[i][j].changeWall(0);
					nsizes.add(dfs(i,j));
					rem.add("" + (i+1) + " " + (j+1) + " " + "N");
					graph[i][j].changeWall(0);
				}
				if((j!= graph[0].length-1)&&graph[i][j].right){
					graph[i][j].changeWall(1);
					nsizes.add(dfs(i,j));
					rem.add("" + (i+1) + " " + (j+1) + " " + "E");
					graph[i][j].changeWall(1);
				}
			}
		}
//		long p4 = System.currentTimeMillis();

		out.println(rooms);
		out.println(Collections.max(sizes));
		int max = 0;
		String ms = "";
		int si = nsizes.size();
		for(int i = 0; i < si; i ++){
			int x = nsizes.remove(0);
			String s = rem.remove(0);
			if(x>=max){
				max = x;
				nsizes.add(x);
				rem.add(s);
			}
		}
		int ind = nsizes.indexOf(max);
		ms = rem.remove(ind);
		si = rem.size();
		for(int i = ind; i < si; i++){
			String s = rem.remove(ind);
			if(compare(s, ms)){
				ms = s;
			}
		}
		out.println(max);
		out.println(ms);
		out.close();
		f.close();
//		System.out.println((p2-p1)/1000.);
//		System.out.println((p3-p2)/1000.);
//		System.out.println((p4-p3)/1000.);
//		System.out.println((System.currentTimeMillis()-p4)/1000.);
		System.exit(0);
	}
	private static boolean compare(String s1, String s2){
		StringTokenizer x1 = new StringTokenizer(s1);
		StringTokenizer x2 = new StringTokenizer(s2);
		int u1 = Integer.parseInt(x1.nextToken());
		int h1 = Integer.parseInt(x1.nextToken());
		int u2 = Integer.parseInt(x2.nextToken());
		int h2 = Integer.parseInt(x2.nextToken());
		if(h1<h2){
			return true;
		}
		else if(h1>h2){
			return false;
		}
		if(u2<u1){
			return true;
		}
		else if(u2>u1){
			return false;
		}
		if(x1.nextToken().equals("N")){
			return true;
		}
		return false;
	}
	private static int dfs(int i, int j) {

		if(i < 0 || j < 0 || i >= graph.length || j >= graph[0].length){
			return 0;
		}		
		Stack<Node> s = new Stack<Node>();
		boolean[][] visit = new boolean[graph.length][graph[0].length];
		s.add(graph[i][j]);
		int result = 0;
		while(s.empty() == false){
			
			Node top = s.pop();

			if(top.i < 0 || top.j < 0 || top.i >= graph.length || top.j >= graph[0].length){
				continue;
			}
			if(visit[top.i][top.j]){
				continue;
			}
			visit[top.i][top.j] = true;
			visited[top.i][top.j] = true;
			result ++;
			if(!top.bot){
				s.push(graph[top.i+1][top.j]);
			}
			if(!top.left){
				s.push(graph[top.i][top.j-1]);
			}
			if(!top.right){
				s.push(graph[top.i][top.j+1]);
			}
			if(!top.top){
				s.push(graph[top.i-1][top.j]);
			}
		}
		return result;
	}
	class Node{
		boolean top, right, bot, left;
		int i, j;
		public Node(int n, int i, int j){
			this.i = i;
			this.j = j;
			if(n/8 == 1){
				bot = true;
				n-= 8;
			}
			if(n/4 == 1){
				right = true;
				n-= 4;
			}
			if(n/2 == 1){
				top = true;
				n-=2;
			}
			if(n == 1){
				left = true;
			}
		}
		public void changeWall(int n){
			if(n == 0){
				top = !top;
			}
			else{
				right = !right;
			}

			
		}
		@Override
		public boolean equals(Object obj) {
			Node x = (Node) obj;
			return ((i == x.i) && (j == x.j));
		}
	}

}
