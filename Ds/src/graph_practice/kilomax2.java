package graph_practice;

import java.util.PriorityQueue;

public class kilomax2 {

	boolean visited[]=new boolean[32768];

	class node {
	 int weapons;
	 int shots;
	 // Define a comparator that puts nodes with less shots on top appropriate to your language
	public node(int weapons, int shots) {
		super();
		this.weapons = weapons;
		this.shots = shots;
	}
	};
	
int leastShots(String[][] damageChart, int[] bossHealth) {
		 PriorityQueue<node> pq;
		 int numWeapons=damageChart.length;
		 pq.add(new node(0, 0));

		 while (pq.isEmpty() == false) {
		  node top =pq.poll();
		  

		  // Make sure we don't visit the same configuration twice
		  if (visited[top.weapons]) continue;
		  visited[top.weapons] = true;

		  // A quick trick to check if we have all the weapons, meaning we defeated all the bosses.
		  // We use the fact that (2^numWeapons - 1) will have all the numWeapons bits set to 1.
		  if (top.weapons == (1 << numWeapons) - 1)
		   return top.shots;

		  for (int i = 0; i < damageChart.length; i++) {
		   // Check if we've already visited this boss, then don't bother trying him again
		   if (((top.weapons >> i) & 1)==1) continue;

		   // Now figure out what the best amount of time that we can destroy this boss is, given the weapons we have.
		   // We initialize this value to the boss's health, as that is our default (with our KiloBuster).
		   int best = bossHealth[i];
		   for (int j = 0; j < damageChart.length; j++) {
		    if (i == j) continue;
		    if ((((top.weapons >> j) & 1)==1) && Integer.parseInt(damageChart[j][i]) != 0) {
		     // We have this weapon, so try using it to defeat this boss
		     int shotsNeeded = bossHealth[i] / (Integer.parseInt(damageChart[j][i]));
		     if (bossHealth[i] % (Integer.parseInt(damageChart[j][i])) != 0) shotsNeeded++;
		     best = Integer.MIN_VALUE(best,shotsNeeded);
		    }
		   }

		   // Add the new node to be searched, showing that we defeated boss i, and we used 'best' shots to defeat him.
		   pq.add( new node(top.weapons | (1 << i), top.shots + best));
		  }
		 }
		}

	
}
