package L7a;

import java.util.Scanner;

public class L7Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue<Integer> shares = new MyQueue<>();
        MyQueue<Integer> prices = new MyQueue<>();
        int totalProfit = 0;

        String query;
        do {
            System.out.print("\nEnter query in format \"Buy / Sell x shares at $y\": ");
            query = sc.nextLine();
            if (query.contains("Buy")) {
                buy(shares, prices, query);
            } else if (query.contains("Sell")) {
                totalProfit += sell(shares, prices, query);
            }
        } while (!query.contains("End"));
        System.out.println("Your total profit is: " + totalProfit);
    }

    public static void buy(MyQueue<Integer> shares, MyQueue<Integer> prices, String query){
        int numSell = Integer.parseInt(query.substring(query.indexOf("Buy") + 4, query.indexOf("shares") - 1));
        int price = Integer.parseInt(query.substring(query.indexOf("$") + 1));
        shares.enqueue(numSell);
        prices.enqueue(price);
        System.out.println("Bought " + numSell + " shares at $" + price + " each");
        System.out.println("\nQueue for shares: " + shares.toString());
        System.out.println("Queue for prices: " + prices.toString());
    }

    public static int sell(MyQueue<Integer> shares, MyQueue<Integer> prices, String query){
        int numSell = Integer.parseInt(query.substring(query.indexOf("Sell") + 5, query.indexOf("shares") - 1));
        int price = Integer.parseInt(query.substring(query.indexOf("$") + 1));
        int profit = 0;
        while (numSell > 0){
            int sharesHave = shares.dequeue();
            if (sharesHave > numSell){
                int priceHave = prices.peek();
                shares.enqueue(sharesHave - numSell);
                profit += (price - priceHave) * numSell;
                numSell = 0;
            } else if (numSell > sharesHave && shares.isEmpty()){
                int priceHave = prices.dequeue();
                profit += (price - priceHave) * sharesHave;
                numSell = 0;
            } else {
                int priceHave = prices.dequeue();
                profit += (price - priceHave) * sharesHave;
                numSell -= sharesHave;
            }
        }
        System.out.println("Profit: $" + profit);
        System.out.println("\nQueue for shares: " + shares.toString());
        System.out.println("Queue for prices: " + prices.toString());
        return profit;
    }
}
