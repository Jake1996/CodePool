
package CodePool.CodePool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public static boolean visited[];
	public static Queue<Integer> Q;

	public static void main(String[] args) {
		AdjacencyList G = new AdjacencyList(6);
		visited = new boolean[6];
		Q = new LinkedList<>();
		G.addVertex(0);
		G.addVertex(1);
		G.addVertex(2);
		G.addVertex(3);
		G.addVertex(4);
		G.addVertex(5);
		G.addEdge(0, 1);
		G.addEdge(1, 5);
		G.addEdge(1, 3);
		G.addEdge(2, 4);
		G.addEdge(3, 4);

		bfs(G, 6);
	}

	public static void bfs(AdjacencyList G, int size) {
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				Q.add(i);
				bfsVisitor(G);
			}
		}
	}

	public static void bfsVisitor(AdjacencyList G) {
		if (Q.isEmpty())
			return;
		int v = Q.remove();
		System.out.println("Visited : " + v);
		visited[v] = true;
		ArrayList<Integer> ref;
		ref = G.getEdges(v);
		for (int i = 0; i < ref.size(); i++) {
			if (!visited[ref.get(i)])
				Q.add(ref.get(i));
		}
		bfsVisitor(G);

	}

}
