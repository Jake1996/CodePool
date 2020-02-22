package CodePool.CodePool;

import java.util.Scanner;

/**
 * Input : The no of nodes or places followed by a distance matrix where (i,j)
 * represents the distance between node i and node j Output : The min distance
 * to travel through all the node and return to a starting node(a hamiltonian
 * circuit)
 * 
 * @author jatin
 *
 */
public class TravellingSalesProblem {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, dist[][];
		n = in.nextInt();
		dist = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				dist[i][j] = in.nextInt();
		System.out.println(minDistance(dist, 0, 1));
		in.close();
	}

	/**
	 * 
	 * @param dist    the matrix representing the distance between two nodes
	 * @param current the node at which the algorithm is processing
	 * @param mask    binary coded no to represents which all nodes have been
	 *                visited
	 * @return the minimum distance between the present node and the optimum next
	 *         node(s)
	 */
	public static int minDistance(int dist[][], int current, int mask) {
		if (mask == (Math.pow(2, dist.length)) - 1) {
			return dist[current][0];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < dist.length; i++) {
			if ((mask & (1 << i)) == 0 && i != current) {
				int temp = minDistance(dist, i, mask | (1 << i));
				temp += dist[current][i];
				min = min < temp ? min : temp;
			}
		}

		return min;
	}

}
