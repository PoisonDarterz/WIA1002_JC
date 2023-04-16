package L6;

import java.util.Scanner;

public class TestIntMyStack<E> {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            stack.push(i);
        }
        System.out.println("Size: " + stack.getSize());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        // The output order is reversed because the the latest values are the ones to be popped
        // (Last in First out - LIFO)
    }
}
