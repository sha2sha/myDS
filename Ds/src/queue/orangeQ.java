package queue;


import java.util.LinkedList;
import java.util.Queue;

class temp{
	int x;
	int y;
}
public class orangeQ {
static Queue<temp> myQueue =new LinkedList<temp>();
	
	public static void  miniTimeReq(int orange[][],int R,int C){
		
	for(int i=0;i<R;i++){
		for(int j=0;j<C;j++){
			if(orange[i][j]==2){
                 temp obj1=null;
                 obj1.x=i;
                 obj1.y=j;
				myQueue.add(obj1);				
			}
		}
	}
	
	
		
		
		
		
		
		
		
	}
	
}
