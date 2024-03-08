package Java4b2;

public class Account implements Identifizierbar, UserAccount {
    private int accountId;
    private double balance;


    private Item[] inventory;
    private int inventorySize;

    public Account(int accountId, double balance) throws NegativeBalanceException, IllegalArgumentException {
        if (accountId < 0) {
            throw new IllegalArgumentException("Account ID cannot be negative.");
        }
        if (balance < 0) {
            throw new NegativeBalanceException("Balance cannot be negative.");
        }
        this.accountId = accountId;
        this.balance = balance;
        this.inventory = new Item[10]; // Max 10 items
        this.inventorySize = 0;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void increaseBalance(double uploadCredit) {
        if (uploadCredit > 0) {
            balance += uploadCredit;
        }
    }

    public boolean buyItem(Item item) throws NegativeBalanceException {
        if (balance >= item.getCost() && inventorySize < 10) {
            balance -= item.getCost();
            inventory[inventorySize++] = item;
            return true;
        }
        return false;
    }

    public void setBalance(double balance) throws NegativeBalanceException {
        if (balance < 0) {
            throw new NegativeBalanceException("Balance cannot be negative.");
        }
        this.balance = balance;
    }
    public Item[] getInventory() {
        return inventory;
    }

    public void setInventory(Item[] inventory) {
        this.inventory = inventory;
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public void setInventorySize(int inventorySize) {
        this.inventorySize = inventorySize;
    }

    public void incrementInventorySize() {
        this.inventorySize++;
    }


    @Override
    public String toString() {
        StringBuilder inventoryStr = new StringBuilder();
        for (Item item : inventory) {
            if (item != null) {
                inventoryStr.append(item.toString()).append("\n");
            }
        }
        return "Account[accountId=" + accountId + ", balance=" + balance + ", inventory=\n" + inventoryStr + "]";
    }

    @Override
    public String identifier() {
        return String.format("%010d", accountId);
    }
}
