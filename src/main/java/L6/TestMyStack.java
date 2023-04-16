package L6;

public class TestMyStack<E> {
    public static void main(String[] args) {
        MyStack<Character> stack = new MyStack<>();

        stack.push('a');
        stack.push('b');
        stack.push('c');
        System.out.println(stack.toString());
        if (stack.search('b')) {
            System.out.println("b is Found");
        } else {
            System.out.println("b is Not Found");
        }
        if (stack.search('k')) {
            System.out.println("k is Found");
        } else {
            System.out.println("k is Not Found");
        }
        System.out.println();

        MyStack<Integer> stack2 = new MyStack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        System.out.println(stack2.toString());
        if (stack2.search(6)) {
            System.out.println("6 is Found");
        } else {
            System.out.println("6 is Not Found");
        }
    }
}
