package L5.SList;

public class SNode<E> {
    E element;
    SNode<E> next;

    public SNode(E e, SNode<E> n) {
        element = e;
        next = n;
    }

    public SNode() {
        this(null, null);
    }
}
