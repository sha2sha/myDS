package tree;

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int item){
		data=item;
		left=right=null;
	}
}
public class tree_childSum {
       static Node root;
	public static void converter(Node root){
		int left=0;
		int right=0;
		
	if(root==null || (root.left==null && root.right==null)) return;
	converter(root.left);
	converter(root.right);
	if(root.left!=null){
     left=root.left.data;
	}
	if(root.right!=null){
	right=root.right.data;
	}
	int diff=((left+right)-root.data);
	if(diff>0){
		root.data=root.data+diff;
	}
	if(diff<0){
		changeChild(root,-diff);
	}
	}
	
	public static void changeChild(Node root,int diff){
		if(root.left!=null){
			root.left.data=root.left.data+diff;
			changeChild(root.left,diff);
		}
		else if(root.right!=null){
			root.right.data=root.right.data+diff;
			changeChild(root.right,diff);
		}
	}
	
	public static void main(String args[]){
		tree_childSum.root=new Node(50);
		tree_childSum.root.left=new Node(7);
		tree_childSum.root.right=new Node(2);
		tree_childSum.root.left.left=new Node(3);
		tree_childSum.root.left.right=new Node(5);
		tree_childSum.root.right.left=new Node(1);
		tree_childSum.root.right.right=new Node(30);
		printInorder(root);
		converter(root);
		System.out.println("after change");
		printInorder(root);
		
		
	}
	 static void printInorder(Node node) {
	        if (node == null) {
	            return;
	        }
	   printInorder(node.left);
	 System.out.print(node.data + " ");
	   printInorder(node.right);
	    }
	 
	
}
