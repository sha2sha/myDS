package tree;

public class printAnsestor_recursion {
          Node root=null;
	public boolean printAnses(Node root,int data){
		if(root==null) return false;
		if(root.data==data) return true;
		if(printAnses(root.left,data)||printAnses(root.right,data)){
		  System.out.println(root.data);
		  return true;
		}
		return false;
				}
	
	
	public static void main(String args[]){
		printAnsestor_recursion obj1=new printAnsestor_recursion();
		obj1.root=new Node(50);
		obj1.root.left=new Node(7);
		obj1.root.right=new Node(2);
		obj1.root.left.left=new Node(3);
		obj1.root.left.right=new Node(5);
		obj1.root.right.left=new Node(1);
		obj1.root.right.right=new Node(30);
		obj1.printAnses(obj1.root,30);
		
	}
}
