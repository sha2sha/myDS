
package graph_practice;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class BFS{
	
	
	 Vertex vertex[];
	class Neighbour{
		int weight;
		int vertno;
		Neighbour next;
		public Neighbour(int weight, int vertno, Neighbour nh) {
			super();
			this.weight = weight;
			this.vertno = vertno;
			this.next = nh;
		}
		
	}
	
	class Vertex{
		String name;
		Neighbour addlist;
		public Vertex(String name, Neighbour addlist) {
			super();
			this.name = name;
			this.addlist = addlist;
		}
	}
	
	
	public BFS(){
	vertex=new Vertex[5];
	for(int i=0;i<vertex.length;i++){
		vertex[i]=new Vertex("A"+i,null);
	}
	
	}
	
	public void connectStoD(int s,int d,int wt){
		
		vertex[s].addlist=new Neighbour(wt,d,vertex[s].addlist);
		
}
	
	public boolean BFS_ispath(int s,int d){
		boolean visited[]=new boolean[vertex.length];
		boolean ispath=false;
		Queue<Integer> que=new LinkedList<Integer>();
		que.add(s);
		while(!que.isEmpty()){
			int temp=que.poll();
			visited[temp]=true;
	for(Neighbour nh=vertex[temp].addlist;nh!=null;nh=nh.next){
		System.out.println();
		if(!visited[nh.vertno]){
			
			que.add(nh.vertno);
			visited[nh.vertno]=true;
		}
	}
			if(visited[d]==true){
				ispath=true;
			}
			
			
		}
		
		return ispath;
	}
	
	public void print(){
		for(int i=0;i<vertex.length;i++){
		
			System.out.print(vertex[i].name);
			System.out.print("----->");
		    for(Neighbour nh=vertex[i].addlist;nh!=null;nh=nh.next){
		    	System.out.print(vertex[nh.vertno].name);
		    	System.out.print("-->");
		    }
		    System.out.println();
			
		}
		
		
	}
	
	
public static void main(String[] args) {
		
		BFS bfs= new BFS();
		bfs.connectStoD(0, 1,5);
		bfs.connectStoD(0, 2,5);
		bfs.connectStoD(0, 3,5);
		bfs.connectStoD(1, 3,5);
		bfs.connectStoD(1, 2,5);
		bfs.connectStoD(1, 4,5);
	//	System.out.println(bfs.BFS_ispath(0, 1));
		System.out.println(bfs.BFS_ispath(0, 4));
		bfs.print();
		
		
		
		
	}
	
	
	
	
	
	
}



	