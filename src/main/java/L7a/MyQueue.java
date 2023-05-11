package L7a;

import java.util.LinkedList;

public class MyQueue<E> {
    LinkedList<E> list;

    public MyQueue(E[] e) {
        list = new LinkedList<>();
        for (E i : e) {
            list.add(i);
        }
    }

    public MyQueue(){
        list = new LinkedList<>();
    }

    public void enqueue(E e) {
        list.add(e);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public E getElement(int i) {
        return list.get(i);
    }

    public E peek() {
        return list.getFirst();
    }

    public int getSize() {
        return list.size();
    }

    public boolean contains(E e) {
        return list.contains(e);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString() {
        return list.toString();
    }
}
