public class DegDist {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Given a graph represented as an adjacency matrix. 
		// Make sure you try different graphs before submitting.
		int[][] graph = {
				{ 0, 0, 1, 1, 1, 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 0 },
			    { 1, 0, 0, 1, 1, 1, 0, 1, 1, 0 },
			    { 1, 0, 1, 0, 1, 1, 0, 0, 1, 1 },
				{ 1, 0, 1, 1, 0, 0, 0, 1, 1, 0 },
				{ 0, 1, 1, 1, 0, 0, 1, 0, 1, 1 },
				{ 1, 1, 0, 0, 0, 1, 0, 1, 1, 1 },
				{ 1, 1, 1, 0, 1, 0, 1, 0, 0, 0 },
				{ 0, 1, 1, 1, 1, 1, 1, 0, 0, 1 },
				{ 0, 0, 0, 1, 0, 1, 1, 0, 1, 0 },
				
		};
		/*int[][]graph={	{0, 0, 0, 1, 1},
				{0, 0, 1, 1, 1},
				{0, 1, 0, 0, 0},
				{1, 1, 0, 0, 1},
				{1, 1, 0, 1, 0},
			};*/
		// Declare, create and initialise an array to G pdf
		// Note that we need space for an extra element since some nodes
		// may have a degree of 0.
		int[] G = new int[graph.length];
		// Compute pdf: Each pdf[i] Gs the total number of nodes in $G$
		// having degree i.
		int deg=0;
		for(int i=0;i<graph.length;i++){
			for(int j=0;j<graph.length;j++){
				if(graph[i][j]==1){
					deg++;
				}
			}
	         	G[i]=deg;		
		}
		int[] pdf=new int[graph.length+1];
		int count=0;
		for(int i=0;i<graph.length;i++){
			for(int j=0;j<graph.length;j++)
			{
				   if(i==G[j])
					count++;
			}
			
			pdf[i]=count;
		} 	
		int[] cdf = new int[graph.length+1];
		
		// Compute cdf: Each cdf[i] Gs the total number of nodes 
		// having degree <= i.
		int count1=0;
		for(int i=0;i<graph.length;i++){
			for(int j=0;j<graph.length;j++)
			{
				   if(G[j]<=i)
					count1++;
			}
			
			cdf[i]=count1;
		} 	
		// Use cdf to find the median degree medDeg
		// Print out everything
		System.out.print("pdf: ");
	for (int i = 0; i < pdf.length; i++)
			System.out.print("pdf["+i+"]="+pdf[i] + ", ");
		System.out.println();
		
		System.out.print("cdf: ");
		for (int i = 0; i < cdf.length; i++)
			System.out.print("cdf["+i+"]="+cdf[i] + ", ");
		System.out.println();
		
		
		double medDeg;
		if(cdf.length%2==0)
			medDeg=((cdf.length/2)+(cdf.length/2+1))/2;
		else
			medDeg=(cdf.length+1)/2;

		 System.out.println("Median degree: " + medDeg);

	}}
