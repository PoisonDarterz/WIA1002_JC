package labtest2;

import java.util.ArrayList;

public class DArbyStack<DArby> {
    private static class Node<E>{
        E item;
        Node<E> next;
        public Node(E item){
            this.item = item;
        }
    }
    private Node<DArby> head = null;
    private int size = 0;
    public void push(DArby o){
        // Implement your code here
        Node<DArby> newNode = new Node<DArby>(o);
        if (head == null) {
            head = newNode;
        } else {
            Node<DArby> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    public DArby pop(){
        // Implement your code here
        if (head == null) {
            System.out.println("Stack is empty");
            return null;
        } else if (size == 1) {
            Node<DArby> temp = head;
            head = null;
            size = 0;
            return temp.item;
        } else {
            Node<DArby> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            Node<DArby> temp = current.next;
            current.next = null;
            size--;
            return temp.item;
        }
    }
    public DArby peek(){
        // Implement your code here
        if (head == null) {
            System.out.println("Stack is empty");
            return null;
        } else {
            Node<DArby> current = head;
            while (current.next != null) {
                current = current.next;
            }
            return current.item;
        }
    }

    public boolean isEmpty() {
        // Implement your code here
        return head == null;
    }
    public int size() {
        // Implement your code here
        return size;
    }
    @Override
    public String toString() {
        // Implement your code here
        String result = "";
        Node<DArby> current = head;
        while (current != null) {
            result += current.item + ", ";
            current = current.next;
        }
        return ("[" + result + "]");
    }
    public DArby remove(int k) {
        // Implement your code here
        if (k > size) {
            System.out.println("Index is out of bounds");
            return null;
        } else if (k == size) {
            Node<DArby> temp = head;
            // remove head
            head = head.next;
            size--;
            return temp.item;
        } else if (k == 0) {
            Node<DArby> temp = head;
            head = head.next;
            size--;
            return temp.item;
        } else {
            Node<DArby> current = head;
            for (int i = 0; i < k - 1; i++) {
                current = current.next;
            }
            Node<DArby> temp = current.next;
            current.next = temp.next;
            size--;
            return temp.item;
        }
    }
}
