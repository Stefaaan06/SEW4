package Java4b1;
public class PremiumAccount extends Account {
    private double premiumFee;
    private double discountRate;
    private boolean feeCharged = false;

    public PremiumAccount(int accountId, double balance, double premiumFee, double discountRate) {
        super(accountId, balance);
        this.premiumFee = premiumFee;
        this.discountRate = discountRate;
    }

    public boolean chargeMonthlyFee() {
        if (!feeCharged && getBalance() >= premiumFee) {
            setBalance(getBalance() - premiumFee);
            feeCharged = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean buyItem(Item item) {
        double discountedCost = item.getCost() * (1 - discountRate / 100);
        if (getBalance() >= discountedCost && getInventorySize() < 10) {
            setBalance(getBalance() - discountedCost);
            getInventory()[getInventorySize()] = item;
            incrementInventorySize();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\n PremiumAccount[premiumFee=" + premiumFee + ", discountRate=" + discountRate + ", feeCharged=" + feeCharged + "]";
    }
}

