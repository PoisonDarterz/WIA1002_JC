package L7;

public class L7Q2 {
    public static void main(String[] args) {
        String[] strings = {"abccba", "aabbcc", "hehehe", "heheheh"};
        for (String s: strings){
            System.out.println(s + " is " + (isPalindrome(s) ? "" : "not ") + "a palindrome");
        }
    }

    public static boolean isPalindrome(String s){
        MyQueue<Character> queue = new MyQueue<>();
        int length = s.length();
        for (char c: s.toCharArray()){
            queue.enqueue(c);
        }
        for (int i = length-1; i > 0; i--){
            if (s.charAt(i) != queue.dequeue()){
                return false;
            }
        }
        return true;
    }
}