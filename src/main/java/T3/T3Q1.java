package T3;

import java.util.Scanner;

class Dispenser {
    private String itemName;
    private double itemPrice;
    private int itemStock;
    private int cart;

    public Dispenser(String itemName, double itemPrice, int itemStock) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemStock = itemStock;
        this.cart = 0;
    }

    public String getItemName() {
        return itemName;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public int getItemStock() {
        return itemStock;
    }
    public int getCart() {
        return cart;
    }
    public void deductStock(int itemStock) {
        this.itemStock -= itemStock;
    }

    public boolean addToCart(int amount) {
        if ((itemStock - amount) >= 0) {
            cart += amount;
            return true;
        } else {
            System.out.println("Out of stock");
            return false;
        }
    }
}

class cashRegister {
    static Scanner sc = new Scanner(System.in);
    private double cashIn;
    private static double total;
    private double change;

    public cashRegister() {
        cashIn = 0;
        total = 0;
        change = 0;
    }

    public double getCashIn() {
        return cashIn;
    }
    public double getTotal() {
        return total;
    }
    public double getChange() {
        return change;
    }

    public void pay(){
        System.out.print("Enter cash (negative number to cancel): ");
        double amt = sc.nextDouble();
        if (amt > 0) {
            cashIn += amt;
        } else {
            cashIn = 0;
            total = 0;
        }
    }

    public double change() {
        return cashIn - total;
    }

    public void total(double price){
        total += price;
    }

    public boolean check() {
        if (cashIn >= total) {
            return true;
        } else {
            System.out.println("Balance: " +  (total - cashIn));
            return false;
        }
    }
}

class CandyMachine {
    static Scanner sc = new Scanner(System.in);
    Dispenser[] disps = {new Dispenser("candy", 0.5, 18), new Dispenser("chip", 2.8, 15), new Dispenser("gum", 1.0, 30), new Dispenser("cookie", 2.2, 8)};
    cashRegister cash = new cashRegister();

    public CandyMachine(){
        display();
    }

    public void display(){
        System.out.printf("%-10s%-5s%-5s\n", "Item", "Price", "Stock");
        for (Dispenser d : disps) {
            System.out.printf("%-10s%-5.2f%-5d\n", d.getItemName(), d.getItemPrice(), d.getItemStock());
        }
        select();
    }

    public void select(){
        System.out.print("\nSelect item: (0 for candy, 1 for chip, 2 for gum, 3 for cookie): ");
        int choice = sc.nextInt();
        System.out.print("Enter number of items: ");
        int amount = sc.nextInt();
        
        if (disps[choice].addToCart(amount)) {
            cash.total(disps[choice].getItemPrice() * amount);
        }

        System.out.print("Continue? (y/n): ");
        char cont = sc.next().charAt(0);
        if (cont == 'y') {
            display();
        } else {
            cmPay();
        }
    }

    public void cmPay(){
        System.out.println("\nTotal: " + cash.getTotal());

        while (!cash.check()) {
            cash.pay();
        }

        System.out.println("Change: " + cash.change());
        dispense();
    }

    public void dispense(){
        System.out.println("\nDispensing...");
        for (Dispenser d : disps) {
            if (d.getCart() > 0) {
                System.out.println(d.getItemName() + ": " + d.getCart());
                d.deductStock(d.getCart());
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        CandyMachine cm = new CandyMachine();
    }
}