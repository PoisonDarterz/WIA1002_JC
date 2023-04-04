package L4;

class Node<E>{
    E element;
    public Node<E> next;

    public Node() {
        this.element = null;
    }

    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }
}
