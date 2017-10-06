public class GraphStats {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		int[][] G = {	{0, 0, 0, 1, 1},
				{0, 0, 1, 1, 1},
				{0, 1, 0, 0, 0},
				{1, 1, 0, 0, 1},
				{1, 1, 0, 1, 0},
			};
		//Calculating Number of Nodes in the graph
 		 int N = G.length;
        //Calculating the number of edges in the graph
		int e = 0;
		for(int i=0;i<N;i++)
		e=e+G[i].length;
		//Undirected graph has edges half of that of directed graph
		e=e/2;

	int minDeg = N;
	int maxDeg = 0; 
	double avgDeg = 0.0;
				
	for(int i=0;i<N;i++)
	{
		int deg = G[i].length; 
				
		if(deg<minDeg)
		minDeg=deg;
				
		if(deg>maxDeg)
		maxDeg=deg;
				
		avgDeg = avgDeg+(double)deg;
	}
	avgDeg = avgDeg / N;
				
	System.out.println("N=" + N + " e=" + e + " min degree=" + minDeg + " max degree=" + maxDeg + " average degree=" + avgDeg);
}

}
