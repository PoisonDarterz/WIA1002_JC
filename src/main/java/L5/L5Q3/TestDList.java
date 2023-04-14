package L5.L5Q3;

public class TestDList {
    public static void main(String[] args) {
        DList<Integer> list = new DList<Integer>();
        list.addFirst(1);
        list.addLast(10);
        list.addLast(100);
        list.add(2,2);
        System.out.println("Deleted: " + list.remove(3));
        list.iterateForward();
        list.iterateBackward();
        System.out.println("Size: " + list.size);
        list.clear();
        System.out.println("Size: " + list.size);
    }
}
