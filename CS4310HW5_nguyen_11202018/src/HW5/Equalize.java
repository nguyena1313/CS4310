package HW5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Equalize {

	public static void main(String[] args) throws FileNotFoundException 
    { 
		
		File f = new File("decks.txt");
		Scanner sc = new Scanner(f);
		
		int first = sc.nextInt();
		
		int[] decks = new int[first];
		int[] decks2 = new int[first];
		//System.out.println(first);
		int dat = 0;
		int i=0;
		
		while(sc.hasNextInt()){
			dat = sc.nextInt();
			//System.out.println(dat);
			decks[i] = dat;
			i++;
			
			
		}
		
		int l = decks.length-1;
		for(int k=0; k< decks2.length; k++){
			decks2[k] = decks[l];
			l--;
		}
		
		System.out.println(Arrays.toString(decks2));
		System.out.println(Arrays.toString(decks));
		
		int moves = deck(decks);
		int moves2 = deck(decks2);
		System.out.println(moves);
		System.out.println(moves2);
		
    }
	
	
	
	
	 public static int deck(int[] ar)
	    {
	        int iter = 0;
	        boolean finished = false;
	        int total = 0;
			for(int i=0; i < ar.length; i++){
				total += ar[i];
			}
		    
			System.out.println(total);

	        if (ar.length == 0 || total % ar.length != 0) return 0; //can't do it
	        int target = total / ar.length;

	        int sum = 0;

	        while (!finished)
	        {
	            
	            finished = true;
	            boolean canMoveNext = true;

	            //first element
	            
	            if (ar[0] > target)
	            {
	            	finished = false;
	            	int diff = ar[0] - target;
	                ar[0]-=diff;
	                ar[1]+= diff;
	           
	                System.out.println("Step1: " +Arrays.toString(ar));
	                canMoveNext = ar[1] != 1;
	                iter++;
	            }

	            sum = ar[0];
	           
	            for (int i = 1; i < ar.length; i++)
	            {
	                if (!canMoveNext)
	                {
	                    canMoveNext = true;
	                    sum += ar[i];
	                 
	                    
	                    continue;
	                    
	                }

	                if (sum < i * target && ar[i] > 0)
	                {
	                    finished = false;
	                    int diff = target - ar[i-1];
	                    
	                    ar[i]-=diff;
	                    ar[i - 1]+=diff;
	                    sum++;
	                    iter++;
	                    System.out.println("Step3: " +Arrays.toString(ar));
	                  
	                }
	                else if (sum + ar[i] > (i + 1) * target && ar[i] > 0) //this can't happen for the last element so we are safe
	                {
	                    finished = false;
	                    int diff = ar[i] - target;
	                    ar[i]-=diff;
	                    ar[i + 1]+=diff;
	                    iter++;
	                    canMoveNext = ar[i + 1] != 1;
	                    System.out.println("Step4: " +Arrays.toString(ar));
	                }

	                sum += ar[i];
	                
	            }
	        }
	        System.out.println(Arrays.toString(ar));
	        return iter;
	    }
	 
	
}
