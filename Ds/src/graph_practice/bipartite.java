package graph_practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
public class bipartite {

	
	static List<String> listmen;
	static List<String> listwomen;
	static int numberofmen;
	static int numberofwomen;


	public static boolean bpm(int bpGraph[][], int u, boolean seen[], Integer matchR[])
		{
		   
		    for (int v = 0; v < numberofwomen ; v++)
		    {
		       
		        if (bpGraph[u][v]==1 && !seen[v])
		        {
		            seen[v] = true; 
		           
		            if (matchR[v] < 0 || bpm(bpGraph, matchR[v], seen, matchR))
		            {
		                matchR[v] = u;
		                return true;
		            }
		        }
		    }
		    return false;
		}
		
	public static int maxBPM(int bpGraph[][])
		{
		    
		  
		   HashSet<ArrayList<Integer>> s = new HashSet<ArrayList<Integer>>(); 
	 	    int co=0;
		  
		    List<Integer[]> action = new ArrayList<Integer[]>();
		    ArrayList<Integer> arrayList ;
		    for(int i=0;i<numberofmen;i++){
		    	int x=numberofmen;
		    	
		    	 Integer[] matchR=new Integer[numberofwomen];
				    
			       for(int j=0;j<matchR.length;j++){
			    	   matchR[j]=-1;
			       }
			       
		    	for (int u = i; u <x ; u++)
		    {
			   
			  boolean seen[]=new boolean[numberofwomen];
		      
		       
		        if (bpm(bpGraph, u, seen, matchR))
		        {
		        	co++;
		     	    		
		     	    }
		       
		        	
		    }	for (int u = 0; u <i ; u++)
		    {
			   
			  boolean seen[]=new boolean[numberofwomen];
		       if (bpm(bpGraph, u, seen, matchR))
		        {
		        	co++;
		     	    		
		     	    }
		        
		  }
		    
		    
		    
		    	 for(int k=0;k<matchR.length;k++){
		     	    	
		     	    	if(matchR[k]==-1){
		     	    		break;
		     	    	}
		     	    	if(k==matchR.length-1){
		     	    		
		     	    		action.add(matchR);
		     	    		  arrayList = new ArrayList<Integer>(Arrays.asList(matchR));  	    		
		     	    		s.add(arrayList);
		     	    	}
		     	    	
		    	 }
		    	  
		    	
		    	    }
		    
		    
	      return s.size()>0?s.size():-1;
		}


	 public static int totalmatching(String[] input1)
	    {
	        
	        int mygraph[][] = null;
			List<String> list1 = new ArrayList<String>();
		    List<String> list2 = new ArrayList<String>();
		if(input1.length!=0){
		
	 
	   
	    
		for(int i=0;i<input1.length;i++){
			if(!input1[i].contains("#") ){
				return -1;
			}
			
	        String[] str = input1[i].split("#");
			
			 list1.add(str[0]);
		       for(int j=1;j<str.length;j++){
	               list2.add(str[j]);
		          }
		            
	        	}
		
		 HashSet <String> set1 = new HashSet <String>();
		 HashSet <String> set2 = new HashSet <String>();
		 
	  set1.addAll(list1);
		set2.addAll(list2);
		  set1.remove(null); set2.remove(null);
		String[] menArray = set1.toArray(new String[0]);
		String[] womenArray=set2.toArray(new String[0]);
		 listmen = new ArrayList<String>(Arrays.asList(menArray));
		 listwomen=new ArrayList<String>(Arrays.asList(womenArray));
		  numberofmen=listmen.size();
		  numberofwomen=listwomen.size();
		  mygraph=new int[numberofmen][numberofwomen];
			
		  for(int i=0;i<input1.length;i++){
				String[] str = input1[i].split("#");
				  for(int j=1;j<str.length;j++){
		               
			    	  mygraph[listmen.indexOf(str[0])][listwomen.indexOf(str[j])]=1 ; 
			    	   }
			            
		        	}
		  
		  
		  if(numberofwomen!=numberofmen){
			  return -1;
		  }
		  
		}
		return maxBPM(mygraph);
	        
	        
	        
	    }
	
	
	public static void main(String[] args) {
		
//String[] input={"M1#W2#W4","M2#W1#W2","M3#W1#W3#W4","M4#W4#W5","M5#W4"};
//String[] input={"M1#W2#W4","M2#W1#W2","M3#W1#W3#W4","M4#W4#W5","M5"};
	//	String[] input={"M1#W4","M2#W1#W2","M3#W1#W3#W4","M4#W4#W5","M5#W4"};
		
String[] input={"M1#W6#W10","M2#W1#W5","M3#W1#W3#W5#W9","M4#W3#W4","M5#W2#W6","M6#W1#W2#W6","M7#W1#W7#W8","M8#W8#W10","M9#W3#W9","M10#W10"};
	   
	  System.out.println(totalmatching(input));
	 
	}
	
}

