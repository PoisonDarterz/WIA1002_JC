package selfuse;

public class PYQ_S2_2019_1_Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GenericQueue<String> q = new GenericQueue<>(6);
        q.enqueue("Hello");
        q.enqueueMany("all,who,wants,ice cream,or cookies");
        q.display();
        q.dequeue();
        q.dequeueAll();
        q.display();
        System.out.println("----------------------------------");

    }

}