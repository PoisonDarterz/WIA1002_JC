package L9;

public class L9Q1 {
    public static void main(String[] args) {
        System.out.println(substituteAI("kuala pisang"));
    }

    public static String substituteAI(String str){
        int occ = str.indexOf('a');
        if (occ == -1) return str;

        char first = str.charAt(0);
        if (first == 'a'){
            first = 'i';
        }

        return first + substituteAI(str.substring(1));
    }
}
