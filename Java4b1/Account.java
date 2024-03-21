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

    @Override
    public boolean equals(Object o) {
        // Prüft, ob das aktuelle Objekt und das übergebene Objekt identisch sind
        if (this == o) return true;
        // Prüft, ob das übergebene Objekt null ist oder ob die Klassen der beiden Objekte unterschiedlich sind
        if (o == null || getClass() != o.getClass()) return false;
        // Castet das übergebene Objekt zu einem Item
        Item item = (Item) o;
        // Vergleicht die Hashcodes der beiden Items
        return hashCode() == item.hashCode();
    }

    @Override
    public int hashCode() {
        // Verwendet die Objects.hash Methode, um einen Hashcode für das Item zu erzeugen
        return java.util.Objects.hash(accountId ,balance, inventory, inventorySize);
    }


}
