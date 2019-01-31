package hw4;


public class Union 
{ 
  int[] rank, set; 
  int n; 

  // Constructor 
  public Union(int n) 
  { 
      rank = new int[n]; 
      set = new int[n]; 
      this.n = n; 
      makeSet(); 
      
  } 

  // creates each guest as a table (set)
  void makeSet() 
  { 
      for (int i=0; i<n; i++) 
      { 
          // all elements are own set initially
          set[i] = i; 
      } 
  } 

  // return parent of passed integer
  int find(int x) 
  { 
      // Finds the representative of the set 
      // that x is an element of 
      if (set[x]!=x) 
      { 
          // if x is not the parent of itself 
          // Then x is not the representative of 
          // his set, 
          set[x] = find(set[x]); 

          // so we recursively call Find on its parent 
          // and move i's node directly under the 
          // representative of this set 
      } 

      return set[x]; 
  } 

  //unites set that contains x and set that contains y
  void union(int x, int y) 
  { 
      // Find representatives of two sets 
      int xRoot = find(x), yRoot = find(y); 

     // elements are in set already  
      if (xRoot == yRoot) {
    	 // System.out.println("this has already been ran");
          return; 
  }

       // x less than y
      if (rank[xRoot] < rank[yRoot]) 

          //move x under y 
          set[xRoot] = yRoot; 

      // y rank less than x rank
      else if (rank[yRoot] < rank[xRoot]) 

          //move y under x
          set[yRoot] = xRoot; 

      // same rank
      else{ 
          // set them equal 
          set[yRoot] = xRoot; 

          //increment rank by 1
          rank[xRoot] = rank[xRoot] + 1; 
          
      } 
  } 
} 