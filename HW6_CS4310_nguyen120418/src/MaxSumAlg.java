public class MaxSumAlg {
	static int maxSum = 0;
	static int currSum =0;
	static Node maxChild=null;
	
	

	public void maxSum(Node root, int sum){
		
		//checks if root is null
		if(root!=null){
			
			//gets initial root weight
			sum=sum+root.weight;
			
			
			//checks if sum is greater than maxSum, if true then update maxChild and maxSum
			if(sum>maxSum && root.left==null && root.right==null){
				maxChild = root;
				maxSum = sum;
			}
			
			//recursive method to get max
			maxSum(root.left,sum);
			maxSum(root.right,sum);
		}
	}
	
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root = new Node(7);
		Node a = new Node(3);
		Node b = new Node(8);
		root.left = a;
		root.right = b;
		
		Node c = new Node(8);
		Node d = new Node(1);
		Node e = new Node(0);
		
		a.left = c;
		a.right = d;
		b.left = d;
		b.right = e;
		
		Node f = new Node(2);
		Node g = new Node(7);
		Node h = new Node(4);
		Node i = new Node(4);
		
		c.left = f;
		c.right = g;
		d.left = g;
		d.right = h;
		e.left = h;
		e.right = i;
		
		Node j = new Node(4);
		Node k = new Node(5);
		Node l = new Node(2);
		Node m = new Node(6);
		Node n = new Node(5);
		
		f.left = j;
		f.right = k;
		g.left= k;
		g.right = l;
		h.left = l;
		h.right = m;
		i.left =m;
		i.right = n;
		
		
		
		
		
		

		MaxSumAlg max = new MaxSumAlg();
		double start = System.nanoTime();
		max.maxSum(root,0);
		double end = System.nanoTime();
		
		System.out.println(end-start + " ns");
		System.out.println(+maxSum);
		

	}
}

