package tree;


public class level_spiral {
  Node root=null;
	public void print_spiral(){
	int height =Height(root);
	boolean isLeft=true;
	for(int i=1;i<=height;i++){
		printLevel(root,i,isLeft);
		isLeft=!isLeft;
	}
	
}
	private void printLevel(Node root2, int i, boolean isLeft) {
		if(root2==null){
			return; 
		}
		if(i==1){
			System.out.println("data is"+ root2.data);
		}
		else if(i>1){
	     if(isLeft){
	    	 printLevel(root2.left,i-1,isLeft);
	    	 printLevel(root2.right,i-1,isLeft);
	    	 
	     }
	     else{
	    	 printLevel(root2.right,i-1,isLeft);
	    	 printLevel(root2.left,i-1,isLeft);
	     }
			
			
		}
		
		}
	int Height(Node node)
	{
	    if (node==null)
	        return 0;
	    else
	    {
	       int lheight = Height(node.left);
	        int rheight = Height(node.right);
	 
	       
	        if (lheight > rheight)
	            return(lheight+1);
	        else return(rheight+1);
	    }
	}
	
	public static void main(String args[]){
		level_spiral obj1=new level_spiral();
		obj1.root=new Node(50);
		obj1.root.left=new Node(7);
		obj1.root.right=new Node(2);
		obj1.root.left.left=new Node(3);
		obj1.root.left.right=new Node(5);
		obj1.root.right.left=new Node(1);
		obj1.root.right.right=new Node(30);
		obj1.print_spiral();
		
	}


	
}
