package tree;

public class findPathAndMaxSum {
	Node root=null;

	public void printAllPath(Node root,int arr[],int length){
		if(root==null) return;
		
		arr[length]=root.data;
		length++;
		if(root.left==null && root.right==null){
			  printPath(arr,length);
		}
		printAllPath(root.left,arr,length);
		printAllPath(root.right,arr,length);
		
	}

	private void printPath(int[] arr, int length) {
		for(int i=0;i<length;i++){
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		}
	
	public static void main(String args[]){
		findPathAndMaxSum obj1=new findPathAndMaxSum();
		int arr[]=new int[1000];
		obj1.root=new Node(1);
		obj1.root.left=new Node(2);
		obj1.root.right=new Node(3);
		obj1.root.left.left=new Node(4);
		obj1.root.left.right=new Node(5);
		obj1.root.right.left=new Node(6);
		obj1.root.right.right=new Node(7);
		 obj1.printAllPath(obj1.root,arr,0);
		

	      
		
	}
}
