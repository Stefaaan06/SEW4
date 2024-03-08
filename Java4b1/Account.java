package Java4b1;

public class Account {
    private int accountId;
    private double balance;


    private Item[] inventory;
    private int inventorySize;

    public Account(int accountId, double balance) {
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

    public void setBalance(double balance) {
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

    public boolean buyItem(Item item) {
        if (this.balance >= item.getCost() && this.inventorySize < 10) {
            this.balance -= item.getCost();
            this.inventory[this.inventorySize++] = item;
            return true;
        }
        return false;
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
}
