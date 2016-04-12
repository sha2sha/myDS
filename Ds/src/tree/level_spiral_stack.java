package tree;

import java.util.Stack;

public class level_spiral_stack {
	Node root=null;
    Stack<Node> st1=new Stack<Node>();
    Stack<Node> st2=new Stack<Node>();
	public void getSpiral(Node root){
	st1.push(root);
	while(!st1.isEmpty() || !st2.isEmpty()){
		
		while(!st1.isEmpty()){
			Node temp=st1.pop();
		System.out.println(temp.data);
		if(temp.left!=null){
			st2.push(temp.left);
			}
		if(temp.right!=null){
			st2.push(temp.right);
		}
			
		}
		while(!st2.isEmpty()){
			Node temp=st2.pop();
		System.out.println(temp.data);
		if(temp.left!=null){
			st1.push(temp.right);
			}
		if(temp.right!=null){
			st1.push(temp.left);
		}
			
		}
		
		}
	
	
}
	public static void main(String args[]){
		level_spiral_stack obj1=new level_spiral_stack();
		obj1.root=new Node(50);
		obj1.root.left=new Node(7);
		obj1.root.right=new Node(2);
		obj1.root.left.left=new Node(3);
		obj1.root.left.right=new Node(5);
		obj1.root.right.left=new Node(1);
		obj1.root.right.right=new Node(30);
		obj1.getSpiral(obj1.root);
		
	}

	
}
