package graph_practice;

public class findminWeightbwnodes {

 static int V= 4;
static int INF=Integer.MAX_VALUE;
	 
	// A naive recursive function to count walks from u to v with k edges
	static int shortestPath(int graph[][], int u, int v, int k)
	{
	   // Base cases
	   if (k == 0 && u == v)             return 0;
	   if (k == 1 && graph[u][v] != INF) return graph[u][v];
	   if (k <= 0)                       return INF;
	 
	   // Initialize result
	   int res = INF;
	 
	   // Go to all adjacents of u and recur
	   for (int i = 0; i < V; i++)
	   {
	       if (graph[u][i] != INF && u != i && v != i)
	       {
	           int rec_res = shortestPath(graph, i, v, k-1);
	           if (rec_res != INF)
	              res = Math.min(res, graph[u][i] + rec_res);
	       }
	   }
	   return res;
	}
	 
	// driver program to test above function
public static void main(String[] args) 
	

	{
	    /* Let us create the graph shown in above diagram*/
	     int graph[][] = { {0, 10, 3, 2},
	                        {INF, 0, INF, 7},
	                        {INF, INF, 0, 6},
	                        {INF, INF, INF, 0}
	                      };
	    int u = 0, v = 3, k = 2;
	    System.out.println("Weight of the shortest path is ");
	          System.out.println(shortestPath(graph, u, v, k));
	 
	}
	
	

}