package L9;

public class L9Q3 {
    public static void main(String[] args) {
        int x = exponent(10, 7);
        System.out.println(x);
    }

    public static int exponent(int base, int power){
        if (power == 0) return 1;
        return base * exponent(base, power - 1);
    }
}
