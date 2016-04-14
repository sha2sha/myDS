package tree;

public class getLevel {
      Node root=null;
	public int getLevelofText(Node root,int level,int text){
		if(root==null) return 0;
		if(root.data==text){
		 return level;
		}
		int left=getLevelofText(root.left,level+1,text);
		if(left>0){
			return left;
		}
		return getLevelofText(root.right,level+1,text);
	
	}
	public static void main(String args[]){
		getLevel obj1=new getLevel();
		obj1.root=new Node(50);
		obj1.root.left=new Node(7);
		obj1.root.right=new Node(2);
		obj1.root.left.left=new Node(3);
		obj1.root.left.right=new Node(5);
		obj1.root.right.left=new Node(1);
		obj1.root.right.right=new Node(30);
		System.out.println(obj1.getLevelofText(obj1.root, 1,30));
          
		
	}
}
