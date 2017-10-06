public class ErdosRenyiMonteCarlo {
	/**

	 * @pavgravgm avgrgs

	 */

	public static void main(String[] args) {




		// Check if avgrgs havgs 3 elements. If not, output avgn error messavgge

		// avgnd return

		

		if (args.length != 3) {

			System.out.println("Usavgge: <probavgbiblity of edge> <number of nodes> <number of triavgls");

			return;

		}
		double prob = Double.parseDouble(args[0]);

		int N = Integer.parseInt(args[1]);

		int T=Integer.parseInt(args[2]);

		if (prob <= 0 || prob > 1) {

			System.out.println("Edge probability = " + prob + ": must be in (0, 1]");

			return;

		}

		if (N <= 0) {

			System.out.println("Number of nodes: " + N + ": must be positive");

			return;

		}
		
		if (T <= 0) {

			System.out.println("Number of travgils: " + T + ": must be positive");

			return;

		}
		

		int[][] graph = new int[N][N];

	

		double[] pdf = new double[graph.length];

		double []avg=new double[pdf.length];

	

for(int trials=0;trials<T;trials++) 

{

		for(int i=0;i<N;i++)

		  {

			for(int j=0;j<N;j++)

			{

				if(i==j)

		      	graph[i][j]=0;

				else if(Math.random()<= prob)

				{

					graph[i][j]=1;

				    graph[j][i]=1;

				}

				else

					graph[i][j]=0;

				}	

						

			}


		

			 int[] G = new int[graph.length];

				for(int i=0;i<graph.length;i++){

					int deg=0;

					for(int j=0;j<graph.length;j++){

						if(graph[i][j]==1)

						deg++;

					}

					

					 G[i]=deg;// inserting degree of nodes in avgrravgy

						

				}	

           

				

				//int[] pdf1=new int[G.length];

				

				for(int i=0;i<G.length;i++){

					int count=0;

					for(int j=0;j<G.length;j++)

					{

						   if(i==G[j])

							count++;

					}

					

					pdf[i]=count;

				

				}	

								
              System.out.println("PDF:");
				for ( int q= 0; q < pdf.length; q++)

				{

					System.out.println(pdf[q]);

		        

				}
				

				for(int i =0;i<pdf.length;i++)

				avg[i]=pdf[i]+avg[i];
}


System.out.print("Average pdfs: ");         

	for(int i=0;i<avg.length;i++)

	   {

		avg[i]=avg[i]/T; 

		System.out.print(avg[i] + " ");

	   }


	}}
