/*
ID: darshan4
LANG: JAVA
TASK: subset
 */
import java.io.*;
import java.util.*;

public class subset {

	public long solve(int n) {
		if (n * (n + 1) % 4 > 0) return 0;
		int sum = n * (n + 1) / 4;

		 // dp[sum][set_max]
		long[][] dp = new long[sum + 1][n + 1];

		for (int max = 1; max <= n; max++) {
			for (int s = 1; s <= sum; s++) {
				dp[s][max] = dp[s][max - 1];
				if (s - max >= 1) {
					dp[s][max] += dp[s - max][max - 1];
				}
				if (s == max) {
					dp[s][max] ++;
				}
			}
		}

		long res = dp[sum][n];
		return res / 2;
	}

	// DFS solution below, too slow for n = 39
	private int res;
	private int n;
	public int solve0(int n) {
		if (n * (n + 1) % 4 > 0) return 0;

		this.n = n;
		int sum = n * (n + 1) / 4;

		for (int i = 1; i <= n; i++) {
			dfs(sum, i);
		}

		return res / 2;
	}

	private void dfs(int sumToGo, int start) {
		if (sumToGo == start) {
			res++;
			return;
		}
		for (int i = start + 1; i <= Math.min(sumToGo - start, n); i++) {
			dfs(sumToGo - start, i);
		}
	}

	public static void main(String[] args) throws IOException {
		String problemName = "subset";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());

		long res = (new subset()).solve(n);

		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		out.println(res);
		out.close(); // close the output file
		f.close();
		System.exit(0); // don't omit this!
	}

}