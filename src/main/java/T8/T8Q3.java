package T8;

public class T8Q3 {
    public static void main(String[] args) {
        Graph<Character> graph = new Graph<>();
        for (char ch = 'A'; ch <= 'I'; ch++)
        graph.addVertex(ch);
        graph.addEdge('A', 'C');
        graph.addEdge('A', 'D');
        graph.addEdge('B', 'D');
        graph.addEdge('C', 'E');
        graph.addEdge('C', 'F');
        graph.addEdge('D', 'E');
        graph.addEdge('E', 'G');
        graph.addEdge('F', 'H');
        graph.addEdge('G', 'H');
        graph.addEdge('H', 'I');
        graph.showAdjacencyList();
        // Adjacency list is used
	}
}
