package L5.L5Q3;

public class Node<E> {
    E element;
    Node<E> next;
    Node<E> prev;

    public Node(E e, Node<E> n, Node<E> p) {
        element = e;
        next = n;
        prev = p;
    }

    public Node() {
        this(null, null, null);
    }
}
