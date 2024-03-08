package Java4b2;

public interface UserAccount {
    double getBalance();
    void increaseBalance(double uploadCredit);
    boolean buyItem(Item item) throws NegativeBalanceException;
}