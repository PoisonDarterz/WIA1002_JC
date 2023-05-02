package L4;

public class MyLinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst (E e) {
        Node<E> node = new Node<>(e, head);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = node;
        }
        size++;
    }

    public void addLast (E e) {
        Node<E> node = new Node<>(e, null);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void add (int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> prev = current;
            prev.next = new Node<E>(e, prev.next);
            size++;
        }
    }

    public E removeFirst () {
        if (size == 0) {
            System.out.println("List is empty");
            return null;
        } else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            return temp.element;
        }
    }

    public E removeLast () {
        if (size == 0) {
            System.out.println("List is empty");
            return null;
        } else if (size == 1) {
            Node<E> temp = tail;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> removed = tail;
            tail = current;
            tail.next = null;
            size--;
            return removed.element;
        }
    }

    public E remove (int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bound");
            return null;
        } else if (index == 0) {
            E removed = removeFirst();
            return removed;
        } else if (index == size - 1) {
            E removed = removeLast();
            return removed;
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> removed = current.next;
            current.next = (current.next).next;
            size--;
            return removed.element;
        }
    }

    public boolean contains (E e) {
        Node<E> current = head;
        while (current != null) {
            if (current.element.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E get (int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bound");
            return null;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.element;
        }
    }

    public E getFirst() {
        Node<E> current = head;
        if (size == 0) {
            System.out.println("List is empty");
            return null;
        } else {
            return current.element;
        }
    }

    public E getLast() {
        Node<E> current = tail;
        if (size == 0) {
            System.out.println("List is empty");
            return null;
        } else {
            return current.element;
        }
    }

    public int indexOf(E e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public int lastIndexOf(E e) {
        Node<E> current = head;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                index = i;
            }
            current = current.next;
        }
        return index;
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bound");
            return null;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            E replaced = current.element;
            current.element = e;
            return replaced;
        }
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public void print() {
        if(head == null && tail == null) {
            System.out.println("[ ]");
        } else {
            System.out.print("[ ");
            Node<E> current = head;
            while (current != null) {
                System.out.print(current.element + " ");
                current = current.next;
            }
            System.out.println("]");
        }
    }

    public void reverse() {
        if (head == null && tail == null) {
            System.out.println("[ ]");
        } else {
            String s = head.element + "";
            for(Node<E> node = head.next; node != null; node = node.next) {
                s = node.element + " " + s;
            }
            System.out.printf("[ %s ]\n", s);
        }
    }

    public E getMiddleValue() {
        if (head == null && tail == null) {
            System.out.println("List is empty");
            return null;
        } else {
//            Node<E> slow = head;
//            Node<E> fast = head;
//            while (fast != null && fast.next != null) {
//                slow = slow.next;
//                fast = fast.next.next;
//            }
//            return slow.element;
            return get(size/2);
        }
    }
}
