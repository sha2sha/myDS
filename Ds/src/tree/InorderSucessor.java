package tree;

public class InorderSucessor {
       Node root=null;
	public int getInorderSucessor(Node root,Node n){
		if(n.right!=null){
			return min(n.right);
		}
		return searchAncestor(root,n);
		}

	private int searchAncestor(Node root, Node n) {
		Node succ=null;
		while(root!=null){
			if(n.data<root.data){
				succ=root;
				root=root.left;
			}
			else if(n.data>root.data){
				root=root.right;
			}
			else
				break;
			
		}
		return succ.data;
	}

	private int min(Node root) {
		while(root.left!=null){
			root=root.left;
		}
		return root.data;
	}
	
	public static void main(String args[]){
		InorderSucessor obj1=new InorderSucessor();
		obj1.root=new Node(20);
		obj1.root.left=new Node(8);
		obj1.root.right=new Node(22);
		obj1.root.left.left=new Node(4);
		obj1.root.left.right=new Node(12);
		obj1.root.left.right.left=new Node(10);
		obj1.root.left.right.right=new Node(14);
		System.out.println(obj1.getInorderSucessor(obj1.root,obj1.root.left.right.right));
}
}
