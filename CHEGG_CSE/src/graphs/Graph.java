package graphs;

import java.util.ArrayList;
import java.util.List;

//class to represent a graph object
public class Graph {
	
	// An array of Lists to represent adjacency list
	List<List<Edge>> adjList = null;

	// Constructor
	Graph(List<Edge> edges, int N) {
		adjList = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			adjList.add(i, new ArrayList<>());
		}

		// add edges to the undirected graph
		for (Edge edge : edges) {
			adjList.get(edge.getSource()).add(edge);
		}
	}
}
