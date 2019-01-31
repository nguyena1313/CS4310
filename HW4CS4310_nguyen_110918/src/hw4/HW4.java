package hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HW4 {

	public static void main(String[] args) throws FileNotFoundException {
		

		File f = new File("data.txt");
		Scanner sc = new Scanner(f);
		String first = sc.nextLine();
		//System.out.println(first);
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		//int num = Integer.parseInt(s);
		//System.out.println(s);
		
		
         while(sc.hasNextLine()) {
			

        	String s = sc.nextLine();
        	
        	if(!s.equals("")){
        	String[] num = s.split(" ");
            int[] numbers = new int[num.length];
        	//System.out.println(s);
        	for(int j=0; j<num.length; j++){
        		
        		numbers[j]= Integer.parseInt(num[j]);
        		
        	}
        	for (int i=0; i < num.length; i++){
        	list.add(numbers[i]);
        	}
        	
        	
        	
        	}
        	
        	else if(s.equals("")){
        	
        	if(!list.isEmpty()){
        	int guests = list.get(0);
        	int relations = list.get(1);
        	//System.out.println("Guests: " +guests);
        	//System.out.println("Relations: " +relations);
        	Union u = new Union(guests);
        	double start;
        	double end;
        	
        	start = System.nanoTime();
        	for(int i=1; i<=relations; i++){
              //System.out.println("(" +(list.get(2*i)-1)+ "), (" +(list.get(2*i+1)-1)+ ")");
              int x = (list.get(2*i)-1);
              int y = (list.get(2*i+1)-1);
              
              if (u.find(x) == u.find(y)) {
            	//System.out.println("Doing nothing");
              }
                  
              else{
             u.union(x, y);
        	  guests--;
              }
        		
        	}
        	
        	end = System.nanoTime();
        	
        	double time = end-start;
        	
        	//System.out.println("Time: " +time);
        	
            int tables = guests;
            System.out.println(tables);
        	list.removeAll(list);
        	}
			
        	}
		}
		
		
         
         if(!list.isEmpty()){
         int guests = list.get(0);
     	int relations = list.get(1);
     	//System.out.println("Guests: " +guests);
     	//System.out.println("Relations: " +relations);
     	Union u = new Union(guests);
     	
     	double start;
    	double end;
    	
    	start = System.nanoTime();
    	
     	for(int i=1; i<=relations; i++){
           
           int x = (list.get(2*i)-1);
           int y = (list.get(2*i+1)-1);
          
           if (u.find(x) == u.find(y)){
               //System.out.println("Do nothing");
           }
           else{
          u.union(x, y);
     	  guests--; 
     	  }
	}
     	
     	
     	end = System.nanoTime();
    	
    	double time = end-start;
    	
    	//System.out.println("Time: " +time);
     	 int tables = guests;
         System.out.println(tables);
	}
	}

}
