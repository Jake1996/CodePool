
package CodePool;

import java.util.ArrayList;

public class DFS {
	public static boolean visited[];

	public static void main(String[] args) {
		AdjacencyList G = new AdjacencyList(6);
		visited = new boolean[6];
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

		dfs(G, 6);
	}

	public static void dfs(AdjacencyList G, int size) {
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				dfsVisitor(G, i);
			}
		}
	}

	public static void dfsVisitor(AdjacencyList G, int v) {
		System.out.println("Visited : " + v);
		visited[v] = true;
		ArrayList<Integer> ref;
		ref = G.getEdges(v);
		for (int i = 0; i < ref.size(); i++) {
			if (!visited[ref.get(i)])
				dfsVisitor(G, ref.get(i));
		}
	}

}
