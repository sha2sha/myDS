package tree;

import java.util.HashMap;

public class vertical_sum {
	Node root=null;
public void getVerSum(Node root){
	HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	getVerSumUtil(root,hm,0);
	if(hm!=null){
	System.out.println(hm.entrySet());
}}

private void getVerSumUtil(Node root, HashMap<Integer, Integer> hm,Integer level) {
   if(root==null)
	   return;
   getVerSumUtil(root.left,hm,level-1);
   int preSum=hm.get(level)==null?0:hm.get(level);
   hm.put(level, preSum+root.data);
   getVerSumUtil(root.right,hm,level+1);
	}

public static void main(String args[]){
	vertical_sum obj1=new vertical_sum();
	obj1.root=new Node(1);
	obj1.root.left=new Node(2);
	obj1.root.right=new Node(3);
	obj1.root.left.left=new Node(4);
	obj1.root.left.right=new Node(5);
	obj1.root.right.left=new Node(6);
	obj1.root.right.right=new Node(7);
	 obj1.getVerSum(obj1.root);
	

      
	
}
}
