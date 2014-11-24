/*
ID: darshan4
LANG: JAVA
TASK: crypt1
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class crypt1 {

	private static int[] assigned  = new int[5];
	 private static int[] possibleNumbers;
	 private static int solutionCount=0;
	// private static int optionCount=0;
	 
	 public static void main(String[] args) throws NumberFormatException, IOException
	 {
	  BufferedReader reader = new BufferedReader(new FileReader("crypt1.in"));
	  int possibleNumbersCount = Integer.parseInt(reader.readLine());
	  StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
	 
	  possibleNumbers = new int[possibleNumbersCount];
	  for(int i=0;i<possibleNumbersCount;i++) {
	   possibleNumbers[i]=Integer.parseInt(tokenizer.nextToken());
	  }
	  Arrays.sort(possibleNumbers);
	  
	  assignAndSolve(0);
	  PrintWriter out = new PrintWriter("crypt1.out");
	  out.println(solutionCount);
	  out.close();
	//  System.out.println(optionCount);
	  reader.close();
	  System.exit(0);
	 }

	 private static void assignAndSolve(int assignedCount) {
	  if(assignedCount == 5) {
	//   optionCount++;
	   int upper = assigned[0] + (assigned[1]*10) + (assigned[2]*100);
	   int partialProduct1= upper* assigned[3];
	   if(!isValid(partialProduct1,3)) {
	    return;
	   }
	   int partialProduct2= upper*assigned[4];
	   if(!isValid(partialProduct2, 3)) {
	    return;
	   }
	   int sumOfPartialProducts = partialProduct1 + (10*partialProduct2);
	   if(!isValid(sumOfPartialProducts,4)) {
	    return;
	   }
	//   System.out.println(assigned[2] + " " + assigned[1] + " " + assigned[0] + "\n  " + assigned[3] + " " + assigned[4]);
	   solutionCount++;
	  }
	  else {   
	   for(int i=0;i<possibleNumbers.length;i++) {
	    assigned[assignedCount]= possibleNumbers[i];
	    assignAndSolve(assignedCount+1);
	   }
	  }
	 }
	 
	 private static boolean isValid(int number, int digitCount)
	 {
	  int count = (number ==0) ? 1 : (int)Math.log10(number) + 1;
	  if(count!=digitCount) {
	   return false;
	  }
	  while(number>0) {
	   int thisDigit=number%10;
	   if(!(Arrays.binarySearch(possibleNumbers, thisDigit)>=0)) {
	    return false;
	   }
	   number= number/10;
	  }
	  return true;
	 }
	}
