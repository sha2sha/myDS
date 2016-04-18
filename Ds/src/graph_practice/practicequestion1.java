package graph_practice;

import graph_practice.BFS.Neighbour;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class practicequestion1 {

	static vertex ver[];
	static int ver_size;
	class Neighbour{
		int vertno;
		float wh;
		Neighbour next;
		public Neighbour(int verno,float wh,Neighbour nxt){
			this.next=nxt;
			this.vertno=verno;
			this.wh=wh;
			
		}
	}
	class vertex{
		String name;
		Neighbour nh;
	    float data; 
		public vertex(String name, Neighbour nh,float data) {
		
			this.name = name;
			this.nh = nh;
			this.data=data;
		}
		}
	
	public float production_value(String[] input1){
		
		Set<String> set =new HashSet<String>();
		for(int i=0;i<input1.length;i++){
			String temp[]=input1[i].split("#");
			set.add(temp[0]);
			set.add(temp[1]);
		}
		set.remove(null);
		ArrayList<String> arr1 =new ArrayList<String>(set);
		ver_size=arr1.size();
	//	iniatilizeValues(arr1,length);
		ver=new vertex[ver_size];
		for(int i=0;i<arr1.size();i++){
			ver[i]=new vertex(arr1.get(i),null,0);
		}
		
		for(int i=0;i<input1.length;i++){
			String temp[]=input1[i].split("#");
			int s=arr1.indexOf(temp[0]);
			int d=arr1.indexOf(temp[1]);
			connectStoD(s,d,0);	
			connectStoD(d,s,0);
			}
		
		
return 0;
		
	}
	
	public float getBFS(int s,int d){
		boolean visited[]=new boolean[ver_size];
		Queue<Integer> kue= new LinkedList<Integer>();
		kue.add(s);
		float maxvalue=Float.MIN_VALUE;
		int maxsize=0;
		float x=1000;
		ver[s].data=x;
while(!kue.isEmpty()){
	int temp_size=0;
			int temp=kue.poll();
			visited[temp]=true;
			
			for(Neighbour nh=ver[temp].nh;nh!=null;nh=nh.next){
				 if(!visited[nh.vertno]){
				temp_size++;
				 }
				}
			
			
			for(Neighbour nh=ver[temp].nh;nh!=null;nh=nh.next){
			   nh.wh=ver[temp].data/temp_size;
			   ver[nh.vertno].data= ver[nh.vertno].data+nh.wh;
			   if(!visited[nh.vertno]){
				   kue.add(nh.vertno);
				   visited[nh.vertno]=true;
				   }
			   if(ver[temp].data > maxvalue){
					if(temp!=s){  
				   maxvalue=ver[temp].data;
					}
				  }
			   
			   
				}
			}









		return maxvalue;
        
		}
	
	public void print(){
		for(int i=0;i<ver.length;i++){
		
			System.out.print(ver[i].name);
			System.out.print("--->");
			System.out.print(ver[i].data);
			System.out.print("----->");
		    for(Neighbour nh=ver[i].nh;nh!=null;nh=nh.next){
		    	System.out.print(ver[nh.vertno].name);
		    	System.out.print("...wt is" +nh.wh);
		    	System.out.print("-->");
		    }
		   System.out.println();
			
		}}
	
public void connectStoD(int s,int d,int wt){
		
		ver[s].nh=new Neighbour(d,wt,ver[s].nh);
		
}
	
	
	
	
	


	public static void main(String[] args) {
		practicequestion1 p1= new practicequestion1();
		 String input3[]={"1#2","1#5","2#5","2#3","3#4","4#5","4#6"};	
		System.out.println(p1.production_value(input3));
		System.out.println("------------------------");
		p1.print();
	}
	
	
	
}
