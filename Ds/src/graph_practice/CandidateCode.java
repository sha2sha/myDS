package graph_practice;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
public class CandidateCode 
{ 
    
    static List<String> listmen;
static List<String> listwomen;
static int numberofmen;
static int numberofwomen;
	
	
	public static boolean bpm(int bpGraph[][], int u, boolean seen[], int matchR[])
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
	    
	    int matchR[]=new int[numberofwomen];
       for(int i=0;i<matchR.length;i++){
    	   matchR[i]=-1;
       }
	  
	    int result = 0; 
	    for (int u = 0; u < numberofmen; u++)
	    {
	        
	        boolean seen[]=new boolean[numberofwomen];
	      
	       
	        if (bpm(bpGraph, u, seen, matchR))
	            result++;
	    }
	    
	    for(int i=0;i<matchR.length;i++){
	    	if(matchR[i]==-1){
	    		return -1;
	    	}
	    }
	    
	    
	    return result;
	}
    
    
    
    
    public static int totalmatching(String[] input1)
    {
        int mygraph[][] = null;
		List<String> list1 = new ArrayList<String>();
	    List<String> list2 = new ArrayList<String>();
	if(input1.length!=0){
	

 
   
    
	for(int i=0;i<input1.length;i++){
		if(!input1[i].contains("#") ){
			return 0;
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
}
