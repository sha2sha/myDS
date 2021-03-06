package graph_practice;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Queue;
public class mycode1234 
{ 
    static Vertex[] ver;
    static int ver_len;
      static class Neighbour{
      int ver_no;
      int wt;
      Neighbour next;
      public Neighbour(int ver,int w,Neighbour n){
      this.ver_no=ver;
      this.wt=w;
      this.next=n; 
    }
    }
    
    static class Vertex{
    String name;
    Neighbour nh;
    public Vertex(String na,Neighbour n){ 
    
     this.name=na;
     this.nh=n;
    }
     }
     
    public static void ConnectStoD(int s,int d){
    
    ver[s].nh=new Neighbour(d,1,ver[s].nh);
    }
   
  public static boolean BFS(int s,int d,int parent[],Vertex[] vr){
  
  Queue<Integer> kqu =new LinkedList<Integer>(); 
  boolean visited[] =new boolean[vr.length];
  kqu.add(s);
  for(int i=0;i<ver_len;i++){ 
      
      visited[i]=false; 
      parent[i]=-1;
  }
  

 while(!kqu.isEmpty()){
 int temp=kqu.poll();
 visited[temp]=true;
 for(Neighbour nh =vr[temp].nh; nh!=null;nh=nh.next){
 if(!visited[nh.ver_no] && nh.wt >0)
  {
  
  visited[nh.ver_no]=true;
  parent[nh.ver_no]=temp;
  kqu.add(nh.ver_no);
  
  } } 
 }
  
 if(visited[d]){
 return true;
 }
  
  return false;
  
  }
  
  
  
   public static int Fulk(int s,int d,Vertex[] ve){
    
   Vertex[] newVer =Arrays.copyOf(ve,ve.length);
   int parent[]=new int[ver_len];
   int count=0;
   while(BFS(s,d,parent,newVer)){
   count++;
   int maxflow=Integer.MAX_VALUE;
   for(int v=d;v!=s;v=parent[v]){
   int u=parent[v];
    int weight=0;
    for(Neighbour nh =newVer[v].nh; nh!=null;nh=nh.next){
    if(nh.ver_no==u){
    weight=nh.wt;
    }
   }
   maxflow=Math.min(maxflow,weight);
   
   }
    
    for(int v=d;v!=s ;v=parent[v]){  
    int u=parent[v];
   for(Neighbour nh =newVer[v].nh; nh!=null;nh=nh.next){  
    if(nh.ver_no==u){
    nh.wt=nh.wt+maxflow;
    }
   }

    for(Neighbour nh =newVer[u].nh; nh!=null;nh=nh.next){
    if(nh.ver_no==v){
    nh.wt=nh.wt-maxflow;
    }
   }
   }
  
   }
   
   return count;
   
   
   
   }
   
    
   
    public static int minRoads(String[] input1)
  {
      String arr[];
       HashSet<String> hs =new HashSet<String>();
      int start=Integer.MAX_VALUE; 
      int end=Integer.MIN_VALUE; 
      
     for(int i=0;i<input1.length;i++){
      
        arr=input1[i].split("#");
      
       int x=Integer.parseInt(arr[0]);
       int y=Integer.parseInt(arr[1]);
       start=Math.min(x,Math.min(y,start));
       end=Math.max(x,Math.max(y,end));
       
       hs.add(arr[0]);  
       hs.add(arr[1]);
       } 
       hs.remove(null); 
       
       
       
        ArrayList<String> arrlist =new ArrayList<String>(hs);
        ver_len=arrlist.size(); 
        ver=new Vertex[ver_len];
        for(int i=0;i<ver_len;i++){
        ver[i]=new Vertex(arrlist.get(i),null); 
        }
       
       
        
        for(int i=0;i<input1.length;i++){
        String a[];
        a=input1[i].split("#");
        int s=arrlist.indexOf(a[0]);
        int d=arrlist.indexOf(a[1]);
        
          
        ConnectStoD(s,d);
        ConnectStoD(d,s);
        
        }  
        int ss=arrlist.indexOf(Integer.toString(start));
        int dd=arrlist.indexOf(Integer.toString(end));
                
        return Fulk(ss,dd,ver);
         
    
}
    
    public static void main(String[] args) {
    	String input3[]={"1#2","1#5","2#5","2#3","3#4","4#5","4#6"}; 	
    	System.out.println(minRoads(input3));
    	
	}
    

}