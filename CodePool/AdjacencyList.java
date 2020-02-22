package CodePool.CodePool;

import java.util.ArrayList;

public class AdjacencyList {

	private ArrayList<ArrayList<Integer>> G;

	public AdjacencyList(int size) {
		G = new ArrayList<ArrayList<Integer>>(size);
	}

	public void addVertex(int v) {
		G.add(v, new ArrayList<Integer>());
	}

	public void addEdge(int u, int v) {
		G.get(u).add(v);
	}

	public ArrayList<Integer> getEdges(int v) {
		return G.get(v);
	}

	public void deleteVertex(int v) {
		ArrayList<Integer> ref;
		ref = G.get(v);
		for (int i = 0; i < ref.size(); i++) {
			G.get(ref.get(i)).remove(v);
		}
		G.remove(v);
	}
}
