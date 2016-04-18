package array;

public class reverseArr {
 public void reverseArray(int arr[],int d,int n){
	 reverseUtil(arr,0,d-1);
	 reverseUtil(arr,d,n-1);
	 reverseUtil(arr,0,n-1); 	 
 }
public void reverseUtil(int arr[],int start,int end){
    if(start>=end) return;
    int temp=arr[start];
    arr[start]=arr[end];
    arr[end]=temp;
    reverseUtil(arr,start+1,end-1);
    
}
public void printArr(int arr[]){
	for(int i=0;i<arr.length;i++){
		System.out.print(arr[i]+ "");
			}
	System.out.println();
	
}
public static void main(String args[]){
	reverseArr rev=new reverseArr();
	int arr[]={1,2,3,4,5,6,7};
	rev.printArr(arr);
	rev.reverseArray(arr, 2, arr.length);
	rev.printArr(arr);
}
}
