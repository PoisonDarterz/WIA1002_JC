package T1;

interface Account {
    int deposit(int amount);
    boolean withdraw(int amount);
}

class BankAccount implements Account {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int deposit(int amount) {
        balance += amount;
        return balance;
    }

    public boolean withdraw(int amount) {
        if (balance - amount < 0) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}
