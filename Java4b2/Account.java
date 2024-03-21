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

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void increaseBalance(double uploadCredit) {
        if (uploadCredit > 0) {
            balance += uploadCredit;
        }
    }

    @Override
    public boolean buyItem(Item item) throws NegativeBalanceException {
        if (balance >= item.cost() && inventorySize < 10) {
            balance -= item.cost();
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

    @Override
    public boolean equals(Object o) {
        // Prüft, ob das aktuelle Objekt und das übergebene Objekt identisch sind
        if (this == o) return true;
        // Prüft, ob das übergebene Objekt null ist oder ob die Klassen der beiden Objekte unterschiedlich sind
        if (o == null || getClass() != o.getClass()) return false;
        // Castet das übergebene Objekt zu einem Item
        Java4b1.Item item = (Java4b1.Item) o;
        // Vergleicht die Hashcodes der beiden Items
        return hashCode() == item.hashCode();
    }

    @Override
    public int hashCode() {
        // Verwendet die Objects.hash Methode, um einen Hashcode für das Item zu erzeugen
        return java.util.Objects.hash(accountId ,balance, inventory, inventorySize);
    }

}
