package graph;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class graph_temp {

	static Vertex ver[] ;
	static int ver_length;
	
	static class Neighbour{
		int wt;
		int ver_no;
		Neighbour next;
		public Neighbour(int wt, int ver_no, Neighbour next) {
			
			this.wt = wt;
			this.ver_no = ver_no;
			this.next = next;
		}
	
	}
	
	static class Vertex{
		String name;
		Neighbour nh;
		public Vertex(String name, Neighbour nh) {
		
			this.name = name;
			this.nh = nh;
		}
			
	}
	
	
	
	public static int getGraph(String input[]){
		String s1 = null;
		String d1=null;
		HashSet<String> hs =new HashSet<String>();
		for(int i=0;i<input.length;i++){
			String arr[]=input[i].split("#");
			if(i==0){
				s1=arr[0];
			}
			if(i==input.length-1){
				d1=arr[1];
			}
			hs.add(arr[0]);
			hs.add(arr[1]);
		}
		hs.remove(null);
		ArrayList<String> mylist=new ArrayList<String>(hs);
		ver_length=mylist.size();
		ver=new Vertex[ver_length];
		for(int i=0;i<ver_length;i++){
			ver[i]=new Vertex(mylist.get(i),null);
		}
	for(int i=0;i<input.length;i++){
			String arr[]=input[i].split("#");
			int s=mylist.indexOf(arr[0]);
			int d=mylist.indexOf(arr[1]);
			int wt=Integer.parseInt(arr[2]);
			ConnectstoD(s,d,wt);
			//ConnectstoD(d,s,wt);
		}
		
//		int ss1=mylist.indexOf(s1);
  //      int dd1=mylist.indexOf(d1);
	
       // int value=fordFulkerson(ss1,dd1,ver);
		
		
		return 0;
		
	}
	
	
	public static void Transpose_Graph(){
		Vertex newVer[]= new Vertex[ver.length];
		for (int j =0; j < ver.length; j++)
        {
            for(Neighbour nh=ver[j].nh;nh!=null;nh=nh.next){
		      
            	newVer[nh.ver_no].nh=new Neighbour(nh.wt,j,newVer[nh.ver_no].nh);
		}
            
            ver=newVer;
            
        }}
	
	
	
	
	
	
	
	
	
	
	
	//Bellman�Ford Algorithm find shortest paths from src to all vertices in the given graph. The graph may contain negative weight edges.
	
	
	public static void printArr(int dist[])
	{
	    System.out.println("Vertex   Distance from Source\n");
	    for (int i = 0; i < ver.length; ++i)
	        System.out.println( ver[i].name +"->"+ dist[i]);
	}
	
	
	// The main function that finds shortest distances from src to all other
	// vertices using Bellman-Ford algorithm.  The function also detects negative
	// weight cycle
	public static void BellmanFord(int src)
	{
	  
	    int dist[]=new int[ver.length];
	 
	    // Step 1: Initialize distances from src to all other vertices as INFINITE
	    for (int i = 0; i < ver.length; i++)
	    { 
	    dist[i]   = Integer.MAX_VALUE;
	  
	    }
	    dist[src] = 0;
		 
	    // Step 2: Relax all edges |V| - 1 times. A simple shortest path from src
	    // to any other vertex can have at-most |V| - 1 edges
	    for (int i = 1; i <= ver.length-1; i++)
	    {
	        for (int j = 0; j < ver.length; j++)
	        {
	        	
	        	 for(Neighbour nh=ver[j].nh;nh!=null;nh=nh.next){
	        	if (dist[j] != Integer.MAX_VALUE && dist[j] +nh.wt < dist[nh.ver_no])
	                dist[nh.ver_no] = dist[j] + nh.wt;
	        }
	    }}
	 
	    // Step 3: check for negative-weight cycles.  The above step guarantees
	    // shortest distances if graph doesn't contain negative weight cycle.
	    // If we get a shorter path, then there is a cycle.
	    for (int i = 0; i < ver.length; i++)
	    {
	    	 for(Neighbour nh=ver[i].nh;nh!=null;nh=nh.next){
	        int weight = nh.wt;
	        if (dist[i] != Integer.MAX_VALUE && dist[i] + weight < dist[nh.ver_no])
	            System.out.println("Graph contains negative weight cycle");
	    }
	    }
	    printArr(dist);
	 
	   // return;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Dijkstra�s shortest path algorithm
	//single source to all other vertices
	//Given a graph and a source vertex in graph, find shortest paths from source to all vertices in the given graph
	
	
	public int minDistance(int dist[], boolean sptSet[])
	{
	   // Initialize min value
	   int min = Integer.MAX_VALUE, min_index=0;
	 
	   for (int v = 0; v < ver.length; v++)
	     {if (sptSet[v] == false && dist[v] <= min)
	         min = dist[v];
	        min_index = v;
	     }
	   return min_index;
	}
	 
	// A utility function to print the constructed distance array
	public void printSolution(int dist[])
	{
	   System.out.println("Vertex   Distance from Source");
	   for (int i = 0; i < ver.length; i++)
	     System.out.println(ver[i].name+""+dist[i]);
	   
	}
	 
	// Funtion that implements Dijkstra's single source shortest path algorithm
	// for a graph represented using adjacency matrix representation
	void dijkstra(int src)
	{
	     int dist[]=new int[ver.length];     // The output array.  dist[i] will hold the shortest
	                      // distance from src to i
	 boolean sptSet[]=new boolean[ver.length]; // sptSet[i] will true if vertex i is included in shortest
	                     // path tree or shortest distance from src to i is finalized
	 
	     // Initialize all distances as INFINITE and stpSet[] as false
	     for (int i = 0; i < ver.length; i++)
	     { dist[i] = Integer.MAX_VALUE;
	        sptSet[i] = false;
	     }
	     // Distance of source vertex from itself is always 0
	     dist[src] = 0;
	 
	     // Find shortest path for all vertices
	     for (int count = 0; count < ver.length-1; count++)
	     {
	       // Pick the minimum distance vertex from the set of vertices not
	       // yet processed. u is always equal to src in first iteration.
	       int u = minDistance(dist, sptSet);
	 
	       // Mark the picked vertex as processed
	       sptSet[u] = true;
	 
	       // Update dist value of the adjacent vertices of the picked vertex.
	      
	 
	         // Update dist[v] only if is not in sptSet, there is an edge from 
	         // u to v, and total weight of path from src to  v through u is 
	         // smaller than current value of dist[v]
	    	   for(Neighbour nh=ver[u].nh;nh!=null;nh=nh.next){
	    	   if (!sptSet[nh.ver_no] && nh.wt!=0 && dist[u] != Integer.MAX_VALUE && dist[u]+nh.wt < dist[nh.ver_no])
	            dist[nh.ver_no] = dist[u] + nh.wt;
	     }
	     }
	     // print the constructed distance array
	     printSolution(dist);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//Prims
	
	//minkey return 
	static int minKey(int key[], boolean mstSet[])
	{
	   // Initialize min value
	   int minKey = Integer.MAX_VALUE, min_index = 0;
	 
	   for (int v = 0; v < key.length; v++){
	     if (mstSet[v] == false && key[v] < minKey){
	    	 minKey = key[v];
	        min_index = v;
	     }
	   }
	   return min_index;
	}
	 
	// A utility function to print the constructed MST stored in parent[]
	public static void printMST(int parent[])
	{
	  
	   for (int i = 1; i < ver.length; i++)
	       {System.out.print(ver[parent[i]].name+"-->"+ver[i].name);
	   for(Neighbour nh=ver[parent[i]].nh;nh!=null;nh=nh.next){
	                if(nh.ver_no==i){
	                	System.out.println(""+ "=="+nh.wt);
	                }
	   
	   }
	       }
	}
	 
	// Function to construct and print MST for a graph represented using adjacency
	// matrix representation
	public static void primMST()
	{
	     int parent[]=new int[ver.length]; // Array to store constructed MST
	     int key[]=new int[ver.length];  // Key values used to pick minimum weight edge in cut
	     boolean mstSet[]=new boolean[ver.length];   // To represent set of vertices not yet included in MST
	 
	    
	     for (int i = 0; i < ver.length; i++)
	        {
	    	 key[i] = Integer.MAX_VALUE; 
	       mstSet[i] = false;
	        }
	    // key[0] = 0;    
	     parent[0] = -1;  
	 
	  for (int count = 0; count < ver.length-1; count++)
	     {
	        int u = minKey(key, mstSet);
	        mstSet[u] = true;
	        for(Neighbour nh=ver[u].nh;nh!=null;nh=nh.next){
	    if ( nh.wt !=0 && mstSet[nh.ver_no] == false && nh.wt <  key[nh.ver_no])
	             parent[nh.ver_no]  = u;
	           key[nh.ver_no] = nh.wt;
	     }
	
	     }
	  printMST(parent);
	  }
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//DFS
	
	public void DFS(int start,boolean isvisited[]){
		
	isvisited[start]=true;
	System.out.println("visiting .."+ ver[start].name);
	for(Neighbour nh =ver[start].nh;nh !=null;nh=nh.next){
		
		if(!isvisited[nh.ver_no]){
			System.out.println("visiting.." +ver[start].name +"to." +ver[nh.ver_no].name );
			DFS(nh.ver_no,isvisited);
		}
	}
	}
		
		public void DFS_TIGGER(){
			boolean temp[]=new boolean[ver.length];
			for(int i=0;i<ver.length;i++){
				if(!temp[i]){
					System.out.println("starting at" +ver[i].name);
					DFS(i,temp);
					
				}
			}
			
		}
	
	
	
	
	
	
	public static void print(){
		for(int i=0;i<ver_length;i++){
		
			System.out.print(ver[i].name);
			System.out.print("--->");
			//System.out.print(ver[i].);
			//System.out.print("----->");
		    for(Neighbour nh=ver[i].nh;nh!=null;nh=nh.next){
		    	System.out.print(ver[nh.ver_no].name);
		      System.out.print("(wt->" +nh.wt+")");
		    	System.out.print("-->");
		    }
		   System.out.println();
			
		}}
	
	
	private static void ConnectstoD(int s1, int s2,int wt) {
		// TODO Auto-generated method stub
		
		ver[s1].nh=new Neighbour(wt,s2,ver[s1].nh);
		
			}
	
	
// CHECK IF THERE IS A PATH IN BETWEEN SOURCE TO DESTINATION	
public static boolean BFS(int s,int d,int parent[],Vertex ver[]){
		
		Queue<Integer> kue= new LinkedList<Integer>();
		kue.add(s);
		boolean visited[]=new boolean[ver.length];
		for(int i=0;i<ver.length;i++){
			parent[i]=-1;
			visited[i]=false;
		}
		while(!kue.isEmpty()){
		int temp=kue.poll();
		visited[temp]=true;
		
		for(Neighbour nh=ver[temp].nh;nh!=null;nh=nh.next){
			if(!visited[nh.ver_no] && nh.wt>0){
			//	visited[nh.ver_no]=true;
				kue.add(nh.ver_no);
				parent[nh.ver_no]=temp;
			}}}
		
	if(visited[d])
			{return true;}	
			
		return false;
	}
	
//call this function to know how path is possible by count from source to destination
// 

	public static int fordFulkerson(int s,int d,Vertex[] ver1){
		Vertex[] regraph=Arrays.copyOf(ver1,ver1.length);
		int parent[]=new int[ver_length];
		Integer max_flow=0;
	int counter=0;
		while(BFS(s,d,parent,regraph)){
			counter++;
			int path_flow=Integer.MAX_VALUE;
			 for (int v=d; v!=s; v=parent[v])
		        {
				    int weight=0;
		            int u = parent[v];
		            for(Neighbour nh=regraph[v].nh;nh!=null;nh=nh.next){
		    			if(nh.ver_no==u){
		    				weight=nh.wt;
		    			}
		    			}
		            path_flow = Math.min(path_flow, weight);
		        }
			 for (int v=d; v!=s; v=parent[v])
		        {
				 int u = parent[v];
				 for(Neighbour nh=regraph[v].nh;nh!=null;nh=nh.next){
		    			if(nh.ver_no==u){
		    			nh.wt=+path_flow;
		    			}}
				 for(Neighbour nh=regraph[u].nh;nh!=null;nh=nh.next){
		    			if(nh.ver_no==v){
		    			nh.wt=-path_flow;
		    			}}
				 
				 
		}
		
			 max_flow=max_flow+path_flow;
	}
		return counter;
	}
	
	
	//The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path problem. 
	//The problem is to find shortest distances between every pair of vertices in a given edge weighted directed Graph
	
	public void floydWarshell(int graph[][]){
		int V=graph.length;
		  int dist[][]=new int[V][V];
		int i, j, k;
		  
		   for (i = 0; i < V; i++)
		        for (j = 0; j < V; j++)
		            dist[i][j] = graph[i][j];
		 
		   for (k = 0; k < V; k++)
		    {
		        for (i = 0; i < V; i++)
		        {
		            for (j = 0; j < V; j++)
		            {
		               if (dist[i][k] + dist[k][j] < dist[i][j])
		                    dist[i][j] = dist[i][k] + dist[k][j];
		            }
		        }
		    }}
	
	
	
	
	public static void Topological_Sort(){
		
		boolean Visited[]=new boolean[ver.length];
		Stack<Integer> st=new Stack<Integer>();
		for(int i=0;i<ver.length;i++){
			if(!Visited[i]){
				toplogicalUtil(i,st,Visited);
			}
		}
		
		while(!st.isEmpty()){
			System.out.print(ver[st.pop()].name);
		}
	}
	
	
private static void toplogicalUtil(int i,Stack<Integer> st, boolean[] visited) {
	visited[i]=true;
	
	for(Neighbour nh=ver[i].nh;nh!=null;nh=nh.next){
		if(!visited[nh.ver_no]){
			toplogicalUtil(nh.ver_no,st,visited);
		}
	}
	
		st.push(i);
	}





	public static void main(String[] args) {
		
	String input3[]={"0#1#2","0#3#6","1#2#3","1#3#8","1#4#5","3#4#9","2#4#7"};  //3

	String input[]={"A#B#-1","A#C#4","B#C#3","B#D#2","D#B#1","B#E#2","E#D#-3","D#C#5"};
	
	 System.out.println(getGraph(input));
	 print();
		System.out.println("------------------------");
	//	primMST();
	//	BellmanFord(2);
	// Topological_Sort();
		Transpose_Graph();
		
	}
	
	
	
	
}
