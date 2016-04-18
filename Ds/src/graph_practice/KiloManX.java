package graph_practice;

import java.util.TreeSet;

public class KiloManX {
	
	   boolean ddd = false ;
	int[] s2ia(String s) {
	  int[]r=new int[s.length()] ;
	  for (int i=0; i<s.length(); i++) {
	    r[i] = s.charAt(i) - '0' ;
	  }
	  return r;
	}
	  public int leastShots(String[] damageChart, int[] bossHealth) {
	    int i, j, k ;
	    int n = damageChart.length ;
	    int[][] dc = new int[n][] ;
	    int[] cost = new int[1<<n] ;
	    for (i=0; i<n; i++) {
	      dc[i] = s2ia(damageChart[i]) ;
	    }
	    for (i=1; i<1<<n; i++) {
	      cost[i] = 65536 * 30000 ;
	      for (j=0; j<n; j++) {
	  int pre = i - (1 << j) ;
	  if ((i & (1 << j)) != 0) {
	    cost[i] = Math.min(cost[i], cost[pre]+bossHealth[j]) ;
	    for (k=0; k<n; k++) {
	      if ((i & (1 << k)) != 0 && k != j && dc[k][j] > 0) {
	        cost[i] = Math.min(cost[i],
	         cost[pre] + (bossHealth[j] + dc[k][j]-1) / dc[k][j]) ;
	      }
	    }
	  }
	      }
	    }
	    return cost[(1<<n)-1] ;
	  }
	 
	  static void pp(Object o) { System.out.println(o) ; }
	}
