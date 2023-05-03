package L7;

public class L7Q1 {
    public static void main(String[] args) {
        MyQueue<String> fruits = new MyQueue<>(new String[]{"Durian", "Blueberry"});
        fruits.enqueue("Apple");
        fruits.enqueue("Orange");
        fruits.enqueue("Grapes");
        fruits.enqueue("Cherry");
        System.out.println(fruits.toString());
        System.out.println("Peek: " + fruits.peek());
        System.out.println("Size: " + fruits.getSize());
        System.out.println("Dequeue: " + fruits.dequeue());
        System.out.println("Index 2: " + fruits.getElement(2));
        System.out.println("Contains Cherry: " + fruits.contains("Cherry"));
        System.out.println("Contains Durian: " + fruits.contains("Durian"));
        while (!fruits.isEmpty()) {
            System.out.println(fruits.dequeue());
        }
    }
}
