package graph_practice;

import graph_practice.practicequestion1.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class practiceQuestionpart2 {

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
		
		//int x=50;
		for(int i=0;i<input.length;i++){
			String arr[]=input[i].split("#");
			int s=mylist.indexOf(arr[0]);
			int d=mylist.indexOf(arr[1]);
			
			ConnectstoD(s,d);
			ConnectstoD(d,s);
		}
		
		int ss1=mylist.indexOf(s1);
        int dd1=mylist.indexOf(d1);
		int value=fordFulkerson(ss1,dd1,ver);
		
		
		return value;
		
	}
	
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
			}
		}
		
		
		}
		
	if(visited[d])
			{return true;}	
			
		return false;
	}
	
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
	
	public static void print(){
		for(int i=0;i<ver_length;i++){
		
			System.out.print(ver[i].name);
			System.out.print("--->");
			//System.out.print(ver[i].);
			//System.out.print("----->");
		    for(Neighbour nh=ver[i].nh;nh!=null;nh=nh.next){
		    	System.out.print(ver[nh.ver_no].name);
		 //   System.out.print("...wt is" +nh.wt);
		   // 	System.out.print("-->");
		    }
		   System.out.println();
			
		}}
	
	
	private static void ConnectstoD(int s1, int s2) {
		// TODO Auto-generated method stub
		
		ver[s1].nh=new Neighbour(1,s2,ver[s1].nh);
		
			}

	public static void main(String[] args) {
		//practiceQuestionpart2 p1= new practiceQuestionpart2();
		// String input3[]={"1#2","1#5","2#5","2#3","3#4","4#5","4#6"};  //1	
		 //String input3[]={"1#2","1#3","1#4","2#5","3#5","4#5"};  //3
	String input3[]={"1#2","2#3","2#4","1#5","3#6","4#6","5#6","1#6"};  //3
//	String input3[]={"1#2","2#3","2#4","1#5","3#6","4#6","5#6"};  //2
	//String input3[]={"1#2","2#3","2#4","1#5","3#6","4#6","5#6","1#6","6#7"};  //1
	
	 System.out.println(getGraph(input3));
	 print();
		System.out.println("------------------------");
	
	}
	
	
	
}
