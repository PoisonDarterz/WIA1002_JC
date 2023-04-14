package L5.SList;

public class TestSList {
    public static void main(String[] args) {
        SList<String> list = new SList<String>();
        list.appendEnd("Linked list");
        list.appendEnd("is");
        list.appendEnd("easy");
        list.display();
        System.out.println("Removed: " + list.removeInitial());
        if (list.contains("difficult")){
            System.out.println("Difficult is in the list");
        } else {
            System.out.println("Difficult is not in the list");
        }
        list.clear();
        list.display();
    }
}
