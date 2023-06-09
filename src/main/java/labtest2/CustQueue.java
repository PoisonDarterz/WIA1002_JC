package labtest2;

public class CustQueue {
    public static void main(String[] args) {
        requeue(3);
        requeue(4);
        requeue(5);
    }

    static void requeue (int k) {
        MyQueue<Integer> queue = new MyQueue<>();
        int size = 10;
        for (int i = 1; i <= size; i++) {
            queue.enqueue(i);
        }
        System.out.println("Original Queue: " + queue.toString());

        for (int i = 0; i < k; i++) {
            queue.dequeue();
        }
        for (int i = k; i > 0; i--) {
            queue.enqueue(i);
        }
        for (int i = size-k; i > 0; i--) {
            queue.enqueue(queue.dequeue());
        }

        System.out.println("Reversed Queue: " + queue.toString());
    }
}
