package tree;

public class checkSumProperty_trick {
      Node root=null;
	public int checkSum(Node root){
		if(root==null) return 0;
		if(root.left==null && root.right==null) return root.data;
		int left=checkSum(root.left);
		int right=checkSum(root.right);
		if(left+right==root.data) 
			return left+right+root.data;
		else
			return -1;
	}
	public static void main(String args[]){
		checkSumProperty_trick obj1=new checkSumProperty_trick();
		obj1.root=new Node(26);
		obj1.root.left=new Node(10);
		obj1.root.right=new Node(3);
		obj1.root.left.left=new Node(4);
		obj1.root.left.right=new Node(6);
		obj1.root.right.right=new Node(3);
		 if(obj1.checkSum(obj1.root)!=-1){
			 System.out.println("true");
		 }
		 else{
			 System.out.println("false");
		 }
	
          
		
	}
}
