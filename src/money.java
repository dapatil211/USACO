/*
 ID: darshan4
 LANG: JAVA
 TASK: money
 */
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class money {

	/**
	 * @param args
	 */
	public static void main (String[] args) throws IOException {
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(new FileReader("money.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));

		V = sc.nextInt();
		N = sc.nextInt();
		val = new int[V];
		for(int i = 0; i < V;i++)
			val[i] = sc.nextInt();

		dp = new long[N+1][V+1];
		for(int i = 0; i <= N;i++)
			Arrays.fill(dp[i],-1);	

		for(int sum = 0; sum <= N;sum++)
		{
			for(int max = V; max >= 0;max--)
			{
				if(sum == 0) dp[sum][max] = 1;
				else
				{
					long ways = 0;
					for(int i = max; i < V;i++)
					{						
						if(sum-val[i] < 0) continue;
						ways += dp[sum-val[i]][i];
					}
					dp[sum][max] = ways;
				}
			}
		}
		sc.close();
		out.println(dp[N][0]);
		out.close();        
		System.out.println(System.currentTimeMillis()-start);
		System.exit(0);                     
	}
	static int V,N;
	static int val[];
	static long[][] dp;
}
