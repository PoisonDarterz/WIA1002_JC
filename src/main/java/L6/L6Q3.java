package L6;

import java.util.Random;

public class L6Q3 {
    static Random rng = new Random();
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        int size = rng.nextInt(20) + 1;
        System.out.println("Size: " + size);
        for (int i = 0; i < size; i++) {
            stack.push(rng.nextInt(100));
        }
        System.out.println(stack.toString());
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println("Sum: " + sum);
    }
}
