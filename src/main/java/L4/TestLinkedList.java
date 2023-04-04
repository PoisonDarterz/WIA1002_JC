package L4;

public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Character> list = new MyLinkedList<>();
        //a
        list.addLast('a');
        list.addLast('b');
        list.addLast('c');
        list.addLast('d');
        list.addLast('e');
        //b
        list.print();
        //c
        list.reverse();
        //d
        System.out.println(list.size);
        //e
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        //f
        System.out.println("Deleted: " + list.remove(2));
        //g
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        //h
        System.out.println(list.contains('c'));
        //i
        list.set(0,'j');
        list.set(1,'a');
        list.set(2,'v');
        list.set(3,'a');
        list.print();
        //q2
        System.out.println("Middle: " + list.getMiddleValue());
    }
}
