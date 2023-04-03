package T4;

class LinkedList<E> {
    Node<E> head = null;
    Node<E> tail = null;
    int size;

    public void addFirst (E element) {
        Node<E> node = new Node<>(element, head);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = node;
        }
        size++;
    }

    public void addLast (E element) {
        Node<E> node = new Node<>(element, null);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
        }
        tail = tail.next;
        size++;
    }

    public void add (int index, E element) {
        if (index == 0) {
            addFirst(element);
        } else if (index >= size) {
            addLast(element);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> prev = current;
            prev.next = new Node<E>(element, prev.next);
            size++;
        }
    }

    public void removeFirst () {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
    }

    public void removeLast () {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            head = tail = null;
        } else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
        }
        size--;
    }

    public void remove (int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bound");
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            current.next = (current.next).next;
        }
        size--;
    }

    public void printList () {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Node<E> {
    E element;
    Node<E> next;

    public Node(E element) {
        this.element = element;
    }

    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }
}    

class T4Q1 {
    public static void main(String[] args) {
        q1ac();
        q1def();
    }

    public static void q1ac() {
        // (a)
        LinkedList<Character> list = new LinkedList<>();
        Node<Character> node1 = new Node<>('A');
        Node<Character> node2 = new Node<>('B');
        list.head = node1;
        list.tail = node2;
        node1.next = node2; // (c)
    }

    public static void q1def(){
        LinkedList<Character> list = new LinkedList<>();
        list.addFirst('0'); // 0
        list.addLast('9');  // 0 9
        list.add(2, 'c'); // 0 9 c
        list.add(0, 'a'); // a 0 9 c
        list.add(1, 'b');  // a b 0 9 c
        list.removeFirst(); // b 0 9 c
        list.removeLast();  // b 0 9
        list.remove(1); // b 9
        list.printList();
    }
}