package graph_practice;

import graph_practice.dijkstra.Vertex;

import java.util.ArrayList;
import java.util.Arrays;

public class bellmanFord {

	class Neighbour{
		int weight;
		int verno;
		Neighbour next;
		public Neighbour(int weight, int verno, Neighbour next) {
			super();
			this.weight = weight;
			this.verno = verno;
			this.next = next;
		}
		
	}
	
	class Vertex{
		String name;
		Neighbour nh;
		public Vertex(String name, Neighbour nh) {
			super();
			this.name = name;
			this.nh = nh;
		}
		
	}
	
	Vertex[] ver;
	int no_ver;
	ArrayList<String> arr;
	public bellmanFord(int v,ArrayList<String> arr){
		this.no_ver=v;
		this.ver=new Vertex[v];
		for(int i=0;i<ver.length;i++){
			ver[i]=new Vertex(arr.get(i),null);
		}
		this.arr=arr;
	}
	
	
	public void ConnectStoD(String s,String d,int wt){
		int ss=arr.indexOf(s);
		int dd=arr.indexOf(d);
		ver[ss].nh=new Neighbour(wt,dd,ver[ss].nh);
		}
	
	public void print(){
		
		for(int i=0;i<ver.length;i++){
			System.out.print(ver[i].name);
			System.out.print("---->");
			for(Neighbour n=ver[i].nh;n!=null;n=n.next){
				System.out.print(ver[n.verno].name);
				System.out.print("-->");
			}
System.out.println();			
		}
		
	}
	
	
	
	public void belmanAlgo(String sc){
		int src=arr.indexOf(sc);
		int dis[]=new int[no_ver];
		for(int i=0;i<no_ver;i++){
			dis[i]=Integer.MAX_VALUE;
		}
		dis[src]=0;
		
		for(int i=0;i<no_ver;i++){
			
			for(int j=0;j<no_ver;j++){
				for(Neighbour n=ver[j].nh;n!=null;n=n.next){
			        if( dis[j]!=Integer.MAX_VALUE && dis[j] + n.weight < dis[n.verno]){
			        	dis[n.verno]=n.weight+dis[j];
			        }
					
					
				}
			}	}
		
		

			
			for(int j=0;j<no_ver;j++){
				for(Neighbour n=ver[j].nh;n!=null;n=n.next){
			        if( dis[j]!=Integer.MAX_VALUE && dis[j] + n.weight < dis[n.verno]){
			        	System.out.println("cycle");
			        }}}
					
			
		
			printSolution(dis);
		
		
		
		
	}
	
	private void printSolution(int[] dist) {
		// TODO Auto-generated method stub
		System.out.println("vertex distance from src");
		for(int i=0;i<ver.length;i++){
			System.out.print(ver[i].name);
			System.out.print("----  ");
			System.out.println(dist[i]);
			System.out.println();
		}
		
	}
	
	
	
	public static void main(String[] args) {
	
		ArrayList<String> arr=new ArrayList<String>();
		arr.addAll(Arrays.asList("A","B","C","D","E"));
		bellmanFord bf=new bellmanFord(arr.size(),arr);
		bf.ConnectStoD("A", "B",-1);bf.ConnectStoD("A", "C",4);bf.ConnectStoD("B", "E",2);
		bf.ConnectStoD("B", "D",2);bf.ConnectStoD("B", "C",3);bf.ConnectStoD("E", "D",-3);
		bf.ConnectStoD("D", "C",5);bf.ConnectStoD("D", "B",1);
		bf.print();
		bf.belmanAlgo("A");
	
		
		
	}
	
	
	
	
	
}
