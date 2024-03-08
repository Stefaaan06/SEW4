package Java4b2;

public class PremiumAccount extends Account {
    private double premiumFee;
    private double discountRate;
    private boolean feeCharged = false;

    public PremiumAccount(int accountId, double balance, double premiumFee, double discountRate) throws NegativeBalanceException, IllegalArgumentException {
        super(accountId, balance);
        if (premiumFee < 0) {
            throw new IllegalArgumentException("Premium fee cannot be negative.");
        }
        if (discountRate < 0) {
            throw new IllegalArgumentException("Discount rate cannot be negative.");
        }
        this.premiumFee = premiumFee;
        this.discountRate = discountRate;
    }

    public boolean chargeMonthlyFee() throws NegativeBalanceException {
        if (!feeCharged && getBalance() >= premiumFee) {
            setBalance(getBalance() - premiumFee);
            feeCharged = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean buyItem(Item item) throws NegativeBalanceException {
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

