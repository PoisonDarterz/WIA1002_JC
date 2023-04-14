package L5.L5Q3;

public class DList<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    public DList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(E e){
        Node<E> node = new Node<>(e, head, null);
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
        size++;
        System.out.println("Added " + e);
    }

    public void addLast(E e){
        Node<E> node = new Node<>(e, null, tail);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
        size++;
        System.out.println("Added " + e);
    }

    public void add(int index, E e){
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node<E> insert = new Node<>(e, current, current.prev);
            current.prev.next = insert;
            current.prev = insert;
            size++;
            System.out.println("Added " + e);
        }
    }

    public void iterateForward(){
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void iterateBackward(){
        Node<E> current = tail;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public E removeFirst(){
        if (size == 0) {
            System.out.println("List is empty");
            return null;
        } else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            System.out.println("Removed " + temp.element);
            return temp.element;
        } else {
            Node<E> temp = head;
            head = head.next;
            head.prev = null;
            size--;
            System.out.println("Removed " + temp.element);
            return temp.element;
        }
    }

    public E removeLast(){
        if (size == 0) {
            System.out.println("List is empty");
            return null;
        } else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            System.out.println("Removed " + temp.element);
            return temp.element;
        } else {
            Node<E> temp = tail;
            tail = tail.prev;
            tail.next = null;
            size--;
            System.out.println("Removed " + temp.element);
            return temp.element;
        }
    }

    public E remove(int index){
        if (index < 0 || index >= size) {
            System.out.println("Index out of bound");
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> prev = current;
            Node<E> next = current.next.next;
            prev.next = next;
            next.prev = prev;
            size--;
            return current.element;
        }
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
        System.out.println("List is cleared");
    }
}
