package tree;

public class childSumProperty {
	Node root=null;

   public void covertIntoSum(Node root){
	   if(root==null|| (root.left==null && root.right==null)){
		   return;
	   }
	   else{
		   covertIntoSum(root.left);
			covertIntoSum(root.right);
			int rightSum=0;
			int leftSum=0;
      if(root.left!=null){	
   leftSum=root.left.data;
            }
	if(root.right!=null){
	rightSum=root.right.data;
	}
	int diff=(leftSum+rightSum)-root.data;
	if(diff>0){
		root.data=root.data+diff;
	}
	else if(diff<0){
		covertChildNodes(root,-diff);
		}
	
	
	}}
   

private void covertChildNodes(Node root, int diff) {
	if(root.left!=null){
		root.left.data=root.left.data+diff;
		covertChildNodes(root.left,diff);
	}
	else if(root.right!=null){
		root.right.data=root.right.data+diff;
		covertChildNodes(root.right,diff);
	}
	
	
}

public void InOrder(Node root){
	if(root==null) return;
	InOrder(root.left);
	System.out.print(root.data+" ");
	InOrder(root.right);
	
}
public static void main(String args[]){
	childSumProperty obj1=new childSumProperty();
	obj1.root=new Node(50);
	obj1.root.left=new Node(7);
	obj1.root.right=new Node(2);
	obj1.root.left.left=new Node(3);
	obj1.root.left.right=new Node(5);
	obj1.root.right.left=new Node(1);
	obj1.root.right.right=new Node(30);
	obj1.InOrder(obj1.root);
	System.out.println();
	obj1.covertIntoSum(obj1.root);
	obj1.InOrder(obj1.root);

	
}
}
