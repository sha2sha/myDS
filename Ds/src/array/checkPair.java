package array;

public class checkPair {
public static boolean checkPairInArr(int arr[],int sum){
	int map[]=new int[100];
       for(int i=0;i<arr.length;i++){
    	   int temp=sum-arr[i];
    	   if(temp>0 && map[temp]==1){
    		   return true;
    	   }
    	   map[arr[i]]=1;
       }
       return false;
}
public static void main(String arg[]){
	int A[] = {1, 4, 45, 6, 10, 8};
    int n = 16;
    System.out.println(checkPairInArr(A,  n));
}
}