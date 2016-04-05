package tree;

import java.util.LinkedList;
import java.util.Queue;

class Node1{
	int data;
	Node1 left,right;
	public Node1(int item){
		this.data=item;
		this.left=this.right=null;
}
}
public class leveOrder {
     Node1 root;
	 Queue<Node1> myq=new LinkedList<Node1>();
	public void grtLevelOrder(Node1 root){
	myq.add(root);
	while(!myq.isEmpty()){
		Node1 temp=myq.poll();
		System.out.print(temp.data+" ");
		if(temp.left!=null){
			myq.add(temp.left);
		}
		if(temp.right!=null){
			myq.add(temp.right);
		}
		
	}
	}
	public static void main(String args[]){
		leveOrder obj1=new leveOrder();
		obj1.root=new Node1(50);
		obj1.root.left=new Node1(7);
		obj1.root.right=new Node1(2);
		obj1.root.left.left=new Node1(3);
		obj1.root.left.right=new Node1(5);
		obj1.root.right.left=new Node1(1);
		obj1.root.right.right=new Node1(30);
		obj1.grtLevelOrder(obj1.root);
		
	}
}
