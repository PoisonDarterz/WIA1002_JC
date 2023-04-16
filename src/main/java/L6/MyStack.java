package L6;

import java.util.ArrayList;

public class MyStack<E> {
    ArrayList<E> list = new ArrayList<E>();

    public void push(E o) {
        list.add(o);
    }

    public E pop() {
        return list.remove(list.size() - 1);
    }

    public E peek() {
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public String toString() {
        return "stack: " + list.toString();
    }

    public boolean search (E o) {
        return list.contains(o);
    }
}
