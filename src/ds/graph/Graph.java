package ds.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Implementation of Graph data structure (Currently only directed)
 */
public class Graph {
    // Number of vertices
    private int vCount;
    // Number of edges
    private int eCount;
    // Graph type TODO: Implement variations
    private String graphType;
    // Array of integer lists
    private Map<String, LinkedList<String>> adjacencies;
    // Number of inserted vertices
    private int insertedVertices = 0;

    /**
     * Graph constructor
     * @param vCount number of vertices
     * @param graphType graph type
     */
    public Graph(int vCount, String graphType) {
        this.vCount = vCount;
        this.eCount = 0;
        this.adjacencies = new HashMap<String, LinkedList<String>>();
        this.graphType = graphType;
    }

    /**
     * Get vertex count
     * @return vertex count
     */
    public int getVertexCount() {
        return this.vCount;
    }

    /**
     * Get edge count
     * @return edge count
     */
    public int getEdgeCount() {
        return this.eCount;
    }

    /**
     * Add vertex to the graph
     * @param vertexValue string value of the vertex
     */
    public void addVertex(String vertexValue) {
        if (this.insertedVertices == this.vCount) {
            System.out.println("Initialized vertices already filled!");
            return;
        }
        // Init linked list holding vertex adjacencies
        this.adjacencies.put(vertexValue, new LinkedList<>());
        this.insertedVertices++;
    }

    /**
     * Add new edge between vertices
     * @param srcVertex source vertex value
     * @param destVertex destination vertex value
     */
    public void addEdge(String srcVertex, String destVertex) {
        // Add new item to the vertex list of adjacencies
        this.adjacencies.get(srcVertex).add(destVertex);
        eCount++;
    }

    /**
     * Render vertices with their adjacencies
     */
    public void render() {
        this.adjacencies.forEach(
                (vertex, path) -> {
                    System.out.print(vertex);
                    path.forEach((value) -> {
                        System.out.print(" -- > " + value);
                    });
                    System.out.println();
                }
        );
    }
}
