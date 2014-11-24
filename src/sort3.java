/*
 ID: darshan4
 LANG: JAVA
 TASK: sort3
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class sort3 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws  
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
		int n = Integer.parseInt(f.readLine());
		int swaps = 0;
		int[] nums = new int[n];
		for(int i = 0; i< n; i++){
			nums[i] = Integer.parseInt(f.readLine());
		}
		int n1 = 0, n2 = 0;
		for(int i : nums){
			if(i == 1){
				n1++;
			}
			else if(i == 2){
				n2++;
			}
		}
		int w12 = 0, w13 = 0, w21 = 0, w23 = 0, w31 = 0, w32 = 0;
		for(int i = 0; i < n1; i++){
			if (nums[i] == 2){
				w12++;
			}
			else if (nums[i] == 3){
				w13++;
			}
		}
		for(int i = n1; i < n1 + n2; i++){
			if (nums[i] == 1){
				w21++;
			}
			else if (nums[i] == 3){
				w23++;
			}
		}
		for(int i = n1+n2; i < nums.length; i++){
			if (nums[i] == 2){
				w32++;
			}
			else if (nums[i] == 1){
				w31++;
			}
		}
		if(w21>w12){
			swaps += w12;
			w21-= w12;
			w12 = 0;
			swaps += w21;
			w23+=w21;
			w13-=w21;
		}
		else{
			swaps += w21;
			w12-=w21;
			w21 = 0;
			swaps += w12;
			w13+=w12;
			w23-=w12;
		}
		if(w31>w13){ 
			swaps += w13;
			w31-= w13;
			w13 = 0;
			swaps += w31;
			w32+=w31;
			w12-=w31;
		}
		else{
			swaps += w31;
			w13-=w31;
			w31 = 0;
			swaps += w13;
			w12+=w13;
			w32-=w13;
		}
		if(w23>w32){
			swaps += w32;
			w23-= w32;
			w32 = 0;
			swaps += w23;
			w21+=w23;
			w31-=w23;
		}
		else{
			swaps += w23;
			w32-=w23;
			w23 = 0;
			swaps += w32;
			w31+=w32;
			w21-=w32;
		}
		out.println(swaps);
		out.close();
		f.close();
		System.exit(0);
	}

}
