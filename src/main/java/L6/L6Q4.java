package L6;

public class L6Q4 {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        String[] tests = {"asdf", "sohaahos", "lmao", "hehehe", "heheheheh"};
        for (String test : tests) {
            stack.push(test);
        }

        while (!stack.isEmpty()) {
            String s = stack.pop();
            if (isPalindrome(s)) {
                System.out.println(s + " is a palindrome");
            } else {
                System.out.println(s + " is not a palindrome");
            }
        }
    }

    static boolean isPalindrome(String s) {
        MyStack<Character> stack = new MyStack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        String reverse = "";
        while (!stack.isEmpty()) {
            reverse += stack.pop();
        }
        return s.equals(reverse);
    }
}
