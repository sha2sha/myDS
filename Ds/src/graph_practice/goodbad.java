package graph_practice;

public class goodbad {

	public static int myfun(int input1[],int input2)
	{
		int leng=input1.length;
		int result[]=new int[leng];
		if(input2>leng || input2<=0){
			return -1;
		}
		
		result[0]=1;
	
		
		if(input1[0] >2 || input1[0]<0) return -1;
			
		if(input1[1] >3 || input1[1]<0) return -1;
			
		if(input1[leng-1]>2 ||input1[leng-1]<0) return -1;
			
			
		if(leng==1 && input2==1)
			{return result[0];}
		
		result[1]=input1[0]-result[0];
		if(leng==2){
			return result[input2-1];
		}
		
		
		
		for(int i=2;i<leng;i++){
		
			if(input1[i]>3){
				return -1;
			}
			result[i]=input1[i-1]-result[i-1]-result[i-2];
			
		}
		
	if(input2<=leng){
			return result[input2-1];
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		int arr[]={2,2,1,1,1};
	
		System.out.println(myfun(arr,4));
		
	}
	
}
