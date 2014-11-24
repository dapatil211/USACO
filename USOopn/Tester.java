import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


public class Tester {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		int lines = 16;
		int columns = 2;
		int range = 14;
		Random rand = new Random();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blink.in")));
		out.println(16 + " " + 1000000000000000L);
		for(int i = 0; i < lines; i ++){
			if(rand.nextBoolean()){
				out.println(1);
			}
			else{
				out.println(0);
			}
			
		}
//			out.println(rand.nextInt(range));
		out.close();
	}

}

