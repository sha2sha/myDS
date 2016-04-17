package graph_practice;

import java.util.ArrayList;
import java.util.Arrays;

public class dijkstra {
Vertex ver[];
	class Neighbour{
		int verno;
		int wh;
		public Neighbour(int verno, int wh, Neighbour nh) {
			super();
			this.verno = verno;
			this.wh = wh;
			this.next = nh;
		}
		Neighbour next;
		}
	
	class Vertex{
		String name;
		Neighbour list;
		public Vertex(String name, Neighbour nh) {
			super();
			this.name = name;
			this.list = nh;
		}
		
		}
	
	public dijkstra(ArrayList<String> arr){
		int l=arr.size();
		ver=new Vertex[l];
		for(int i=0;i<ver.length;i++){
			ver[i]=new Vertex(arr.get(i),null);
		}
	}
	
	
	public void Djk_algo(String src,ArrayList<String> arr){
		int dist[]=new int[ver.length];
		boolean sptSet[]=new boolean[ver.length];
		int indexs=arr.indexOf(src);
		
		for(int i=0;i<ver.length;i++){
			dist[i]=Integer.MAX_VALUE;
			sptSet[i]=false;
		}
		dist[indexs]=0;
		
		for(int count=0;count<ver.length;count++){
			int u=minDist(dist,sptSet);
			sptSet[u]=true;
		for(Neighbour nh=ver[u].list;nh!=null;nh=nh.next){
			if(!sptSet[nh.verno] && dist[u]!=Integer.MAX_VALUE && dist[u]+nh.wh < dist[nh.verno]){
				dist[nh.verno]=dist[u]+nh.wh;
			}
			
		}
			
		}
		
		
		printSolution(dist);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void printSolution(int[] dist) {
		// TODO Auto-generated method stub
		System.out.println("vertex distance from src");
		for(int i=0;i<ver.length;i++){
			System.out.print(ver[i].name);
			System.out.print("----");
			System.out.println(dist[i]);
			System.out.println();
		}
		
	}


	private int minDist(int[] dist, boolean[] sptSet) {
		// TODO Auto-generated method stub
		int min=Integer.MAX_VALUE;
		int index=0;
		for(int i=0;i<ver.length;i++){
			if(sptSet[i]==false && dist[i]<=min){
				min=dist[i]; index=i;
			}	}
		
		return index;
	}


	public void connectStoD(String s,String d,int wt,ArrayList<String> arr){
		
		int indexs=arr.indexOf(s);
		int indexd=arr.indexOf(d);
		
	ver[indexs].list=new Neighbour(indexd,wt,ver[indexs].list); 
		}
	
	public void print(){
		System.out.println();
		for(int i=0;i<ver.length;i++){
			System.out.print(ver[i].name);
			System.out.print("--->");
			for(Neighbour n=ver[i].list;n!=null;n=n.next){
				System.out.print(ver[n.verno].name);
				System.out.print("-->");
			}
			System.out.println();
		}
	}
	
	
	
	public static void main(String[] args) {
		ArrayList<String> arr =new ArrayList<String>();
		arr.addAll(Arrays.asList("0","1","2","3","4","5","6","7","8"));
		dijkstra dk =new dijkstra(arr);
		dk.connectStoD("0", "1", 4,arr);
		dk.connectStoD("0", "7", 8,arr);
		dk.connectStoD("1", "2", 8,arr);
		dk.connectStoD("1", "7", 11,arr);
		dk.connectStoD("1", "0", 4,arr);
		dk.connectStoD("2", "3", 7,arr);dk.connectStoD("2", "1", 8,arr);
		dk.connectStoD("2", "8", 2,arr);
		dk.connectStoD("2", "5", 4,arr);
		dk.connectStoD("3", "4", 9,arr);
		dk.connectStoD("3", "5", 14,arr);
		dk.connectStoD("3", "2", 7,arr);
		dk.connectStoD("4", "3", 9,arr);
		dk.connectStoD("4", "5", 10,arr);dk.connectStoD("5", "4", 10,arr);dk.connectStoD("5", "3", 14,arr);
		dk.connectStoD("5", "2", 4,arr);dk.connectStoD("5", "6", 2,arr);dk.connectStoD("6", "5", 2,arr);
		dk.connectStoD("6", "8", 6,arr);dk.connectStoD("6", "7", 1,arr);dk.connectStoD("7", "6", 1,arr);
		dk.connectStoD("7", "8", 7,arr);dk.connectStoD("7", "1", 11,arr);dk.connectStoD("7", "0", 8,arr);
		dk.connectStoD("8", "7", 7,arr);dk.connectStoD("8", "6", 6,arr);dk.connectStoD("8", "2", 2,arr);
		
		dk.print();
		dk.Djk_algo("0", arr);
		
		
		
	//	Integer[] otherList = new Integer[] {1,2,3,4,5};
//		arList.addAll(Arrays.asList(otherList));
		
		
	}
	
	
	
}
