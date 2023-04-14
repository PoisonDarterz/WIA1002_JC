package L5.SList;

//this file contains methods for both L5Q1 and L5Q2

public class SList<E> {
    SNode<E> head;
    SNode<E> tail;
    int size;

    public SList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Q1
    public void appendEnd(E e) {
        SNode<E> node = new SNode<>(e, null);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public E removeInitial(){
        if (size == 0) {
            System.out.println("List is empty");
            return null;
        } else if (size == 1) {
            SNode<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            SNode<E> temp = head;
            head = head.next;
            size--;
            return temp.element;
        }
    }

    public boolean contains(E e){
        SNode<E> current = head;
        while (current != null) {
            if (current.element.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear(){
        head = tail = null;
        size = 0;
        System.out.println("List is cleared");
    }

    public void display(){
        SNode<E> current = head;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }


    // Q2
    public void add(E e){
        SNode<E> node = new SNode<>(e, null);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void removeElement(E e){
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            if (head.element.equals(e)) {
                head = tail = null;
                size = 0;
            } else {
                System.out.println("Element not found");
            }
        } else {
            SNode<E> current = head;
            SNode<E> previous = null;
            while (current != null) {
                if (current.element.equals(e)) {
                    if (current == head) {
                        head = head.next;
                    } else if (current == tail) {
                        tail = previous;
                        tail.next = null;
                    } else {
                        previous.next = current.next;
                    }
                    size--;
                    return;
                }
                previous = current;
                current = current.next;
            }
            System.out.println("Element not found");
        }
    }

    public void printList(){
        SNode<E> current = head;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int getSize(){
        return size;
    }

    //public boolean contains(E e) - done in above

    public void replace(E e, E newE){
        SNode<E> current = head;
        while (current != null) {
            if (current.element.equals(e)) {
                current.element = newE;
                return;
            }
            current = current.next;
        }
        System.out.println("Element not found");
    }
}
