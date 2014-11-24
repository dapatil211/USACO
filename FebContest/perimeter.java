/*
ID: darshan4
LANG: JAVA
TASK: perimeter
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class perimeter {

	/**
	 * @param args
	 * @throws IOException 
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("perimeter.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
	    int numBales = Integer.parseInt(f.readLine());
	    int[] xVal = new int[numBales];
	    int[] yVal = new int[numBales];
	    for(int i = 0; i < numBales; i ++){
	    	StringTokenizer st = new StringTokenizer(f.readLine());
	    	xVal[i] = Integer.parseInt(st.nextToken());
	    	yVal[i] = Integer.parseInt(st.nextToken());
	    }
	    int[] xcop = Arrays.copyOf(xVal, xVal.length);
	    int[] ycop = Arrays.copyOf(yVal, yVal.length);
	    Arrays.sort(xcop);
	    Arrays.sort(ycop);
	    int xlength = xcop[xcop.length-1] - xcop[0]+1;
	    int ylength = ycop[ycop.length-1] - ycop[0]+1;
	    boolean[][] field = new boolean[xlength][ylength];
	    for(int i = 0; i < xVal.length; i++){
	    	field[xVal[i] - xcop[0]][yVal[i] - ycop[0]] = true;
	    	xVal[i] -= xcop[0];
	    	yVal[i] -= ycop[0];
	    }
	    int perimeter = 0;
	    for(int i = 0; i < numBales; i++){
	    	perimeter += findPerimeter(xVal[i], yVal[i], field);
	    }
	    out.println(perimeter);
	    out.close();
	    f.close();
	    System.exit(0);
	}
	public static int findPerimeter(int x, int y, boolean[][] field){
		int perimeter = 0;
		for(int i = 0; i < 4; i ++){
			perimeter += sideOpen(x, y, i, field);
		}
		return perimeter;
	}
	public static int sideOpen(int x, int y, int dir, boolean[][] field){
		if(dir == 0){
			if(x-1<0){
				return 1;
			}
			else if(field[x-1][y]){
				return 0;
			}
			else{
				int hit = 0;
				for(int i = x; i >= 0; i--){
					if(field[i][y]){
						hit++;
					}
				}
				if(hit%2 == 0){
					return 1;
				}
				else{
					return 0;
				}
			}
		}
		else if(dir == 1){
			if(y+1>=field[0].length){
				return 1;
			}
			else if(field[x][y+1]){
				return 0;
			}
			else{
				int hit = 0;
				for(int i = y; i < field[0].length; i ++){
					if(field[x][i]){
						hit++;
					}
				}
				if(hit%2 == 0){
					return 1;
				}
				else{
					return 0;
				}
			}
		}
		else if(dir == 2){
			if(x+1>=field.length){
				return 1;
			}
			else if(field[x+1][y]){
				return 0;
			}
			else{
				int hit = 0;
				for(int i = x; i < field.length; i ++){
					if(field[i][y]){
						hit++;
					}
				}
				if(hit%2 == 0 || hit==1){
					return 1;
				}
				else{
					return 0;
				}
			}
		}
		else{
			if(y-1<0){
				return 1;
			}
			else if(field[x][y-1]){
				return 0;
			}
			else{
				int hit = 0;
				for(int i = y; i >= 0; i --){
					if(field[x][i]){
						hit++;
					}
				}
				if(hit%2 == 0){
					return 1;
				}
				else{
					return 0;
				}
			}
		}
	}
}
