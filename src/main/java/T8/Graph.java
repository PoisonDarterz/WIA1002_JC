package T8;

public class Graph<E extends Comparable<E>> {
    Vertex<E> head;
    int size;

    static class Vertex<E extends Comparable<E>>{
        E item;
        Vertex<E> nextVertex;
        Edge<E> firstEdge;

        public Vertex(E item){
            this.item = item;
            nextVertex = null;
            firstEdge = null;
        }
    }

    static class Edge<E extends Comparable<E>>{
        Vertex<E> toVertex;
        Edge<E> nextEdge;

        public Edge(Vertex<E> toVertex, Edge<E> nextEdge){
            this.toVertex = toVertex;
            this.nextEdge = nextEdge;
        }
    }

    public void addVertex(E item){
        Vertex<E> newVertex = new Vertex<>(item);
        if(head == null) head = newVertex;
        else{
            Vertex<E> current = head;
            while(current.nextVertex != null) current = current.nextVertex;
            current.nextVertex = newVertex;
        }
        size++;
    }

    private Vertex<E> findVertex(E item){
        Vertex<E> current = head;
        while(current != null){
            if(current.item.compareTo(item) == 0) return current;
            current = current.nextVertex;
        }
        return null;
    }
    
    public boolean addEdge(E src, E dst) {
        Vertex<E> from = findVertex(src);
        Vertex<E> to = findVertex(dst);

        if(from == null || to == null) return false;

        from.firstEdge = new Edge<>(to, from.firstEdge);
        return true;
    }

    public void showAdjacencyList(){
        Vertex<E> current = head;
        while(current != null){
            System.out.print(current.item);
            Edge<E> currentEdge = current.firstEdge;
            while(currentEdge != null){
                System.out.print(" --> " + currentEdge.toVertex.item);
                currentEdge = currentEdge.nextEdge;
            }
            System.out.println();
            current = current.nextVertex;
        }
    }
}
