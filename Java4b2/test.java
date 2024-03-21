package Java4b2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test extends JFrame {
    private JTextField accountIdField, balanceField, createItemNameField, itemNameField, itemCostField, upgradeAccountIdField, buyItemIdField, addMoneyField;
    private JButton createAccountButton, createItemButton, upgradeAccountButton, buyItemButton, displayItemsButton, displayUsersButton, displayPremiumUsersButton, addMoneyButton;
    private JTextArea outputArea;
    private List<Account> accounts;
    private List<Item> items;
    private Set<Integer> accountIds;


    private int premiumFee = 20;
    private int discountRate = 10;

    public test() {
        setTitle("Spiel shop 2");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1));

        // Account-Erstellung Panel
        JPanel accountPanel = new JPanel();
        accountPanel.setBorder(BorderFactory.createTitledBorder("Create Account"));
        accountPanel.setLayout(new GridLayout(3, 2));
        accountIdField = new JTextField();
        balanceField = new JTextField();
        createAccountButton = new JButton("Create Account");
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });
        accountPanel.add(new JLabel("Account ID:"));
        accountPanel.add(accountIdField);
        accountPanel.add(new JLabel("Balance:"));
        accountPanel.add(balanceField);
        accountPanel.add(createAccountButton);

        // Item-Erstellung Panel
        JPanel itemPanel = new JPanel();
        itemPanel.setBorder(BorderFactory.createTitledBorder("Create Item"));
        itemPanel.setLayout(new GridLayout(3, 2));
        createItemNameField = new JTextField();
        itemCostField = new JTextField();
        createItemButton = new JButton("Create Item");
        createItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createItem();
            }
        });
        itemPanel.add(new JLabel("Item Name:"));
        itemPanel.add(createItemNameField);
        itemPanel.add(new JLabel("Item Cost:"));
        itemPanel.add(itemCostField);
        itemPanel.add(createItemButton);

        inputPanel.add(accountPanel);
        inputPanel.add(itemPanel);


        // Upgrade Account Panel
        JPanel upgradeAccountPanel = new JPanel();
        upgradeAccountPanel.setBorder(BorderFactory.createTitledBorder("Upgrade Account"));
        upgradeAccountPanel.setLayout(new GridLayout(2, 2));
        upgradeAccountIdField = new JTextField();
        upgradeAccountButton = new JButton("Upgrade Account");
        upgradeAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upgradeAccount();
            }
        });
        upgradeAccountPanel.add(new JLabel("Account ID:"));
        upgradeAccountPanel.add(upgradeAccountIdField);
        upgradeAccountPanel.add(upgradeAccountButton);

        // Buy Item Panel
        JPanel buyItemPanel = new JPanel();
        buyItemPanel.setBorder(BorderFactory.createTitledBorder("Buy Item"));
        buyItemPanel.setLayout(new GridLayout(4, 2));
        buyItemIdField = new JTextField();
        itemNameField = new JTextField();
        buyItemButton = new JButton("Buy Item");
        buyItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyItem();
            }
        });
        buyItemPanel.add(new JLabel("Account ID:"));
        buyItemPanel.add(buyItemIdField);
        buyItemPanel.add(new JLabel("Item Name:"));
        buyItemPanel.add(itemNameField);
        buyItemPanel.add(buyItemButton);

        // Display Buttons
        displayItemsButton = new JButton("Display Items");
        displayItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayItems();
            }
        });
        displayUsersButton = new JButton("Display Users");
        displayUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayUsers();
            }
        });
        displayPremiumUsersButton = new JButton("Display Premium Users");
        displayPremiumUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPremiumUsers();
            }
        });

        // Add Money Panel
        JPanel addMoneyPanel = new JPanel();
        addMoneyPanel.setBorder(BorderFactory.createTitledBorder("Add Money"));
        addMoneyPanel.setLayout(new GridLayout(3, 2));
        addMoneyField = new JTextField();
        addMoneyButton = new JButton("Add Money");
        addMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMoney();
            }
        });
        addMoneyPanel.add(new JLabel("Account ID:"));
        addMoneyPanel.add(new JLabel("Amount:"));
        addMoneyPanel.add(addMoneyField);
        addMoneyPanel.add(addMoneyButton);



        // Output Bereich
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.append("| DEBUG |\n");


        inputPanel.add(accountPanel);
        inputPanel.add(itemPanel);
        inputPanel.add(upgradeAccountPanel);
        inputPanel.add(buyItemPanel);
        inputPanel.add(displayUsersButton);
        inputPanel.add(displayItemsButton);
        inputPanel.add(displayPremiumUsersButton);
        inputPanel.add(addMoneyPanel);


        // Add the outputArea to the mainPanel
        mainPanel.add(outputArea, BorderLayout.CENTER);

        // Add the inputPanel to the mainPanel
        mainPanel.add(inputPanel, BorderLayout.NORTH);

        add(mainPanel);
        setVisible(true);

        // Listen initialisieren
        accounts = new ArrayList<>();
        items = new ArrayList<>();

        accountIds = new HashSet<>();
    }

    private void createAccount() {
        try {
            int accountId = Integer.parseInt(accountIdField.getText());
            if (accountIds.contains(accountId)) {
                JOptionPane.showMessageDialog(this, "Account ID already exists.");
                return;
            }
            double balance = Double.parseDouble(balanceField.getText());
            Account account = new Account(accountId, balance);
            accounts.add(account);
            accountIds.add(accountId);
            outputArea.append("Account created: " + account + "\n");
        } catch (NumberFormatException | NegativeBalanceException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for account creation.");
        }
    }

    private void upgradeAccount() {
        try {
            int accountId = Integer.parseInt(upgradeAccountIdField.getText());

            for (Account account : accounts) {
                if (account.getAccountId() == accountId) {
                    if (account instanceof PremiumAccount) {
                        JOptionPane.showMessageDialog(this, "Account is already a premium account.");
                    } else if (account.getBalance() < premiumFee) {
                        JOptionPane.showMessageDialog(this, "Insufficient balance to upgrade to premium account.");
                    } else {
                        accounts.remove(account);

                        PremiumAccount premiumAccount = new PremiumAccount(account.getAccountId(), account.getBalance(), premiumFee, discountRate);
                        premiumAccount.setInventory(account.getInventory());
                        premiumAccount.chargeMonthlyFee();

                        accounts.add(premiumAccount);
                        outputArea.append("Account upgraded to premium: " + premiumAccount + "\n");
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Account ID not found.");
        } catch (NumberFormatException | NegativeBalanceException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for account upgrade.");
        }
    }

    private void addMoney() {
        try {
            int accountId = Integer.parseInt(addMoneyField.getText());

            double amount = Double.parseDouble(addMoneyField.getText());
            for (Account account : accounts) {
                if (account.getAccountId() == accountId) {
                    account.setBalance(account.getBalance() + amount);
                    outputArea.append("Money added to account: " + account + "\n");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Account ID not found.");
        } catch (NumberFormatException | NegativeBalanceException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for adding money.");
        }
    }

    private void buyItem() {
        try {
            int accountId = Integer.parseInt(buyItemIdField.getText());
            String itemName = itemNameField.getText();
            for (Account account : accounts) {
                if (account.getAccountId() == accountId) {
                    for (Item item : items) {
                        if (item.name().equals(itemName)) {
                            if (account.buyItem(item)) {
                                outputArea.append("Item purchased: " + item + "\n");
                                return;
                            } else {
                                JOptionPane.showMessageDialog(this, "Insufficient balance to buy item.");
                                return;
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(this, "Item not found.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Account ID not found.");
        } catch (NumberFormatException | NegativeBalanceException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for buying item.");
        } 
    }

    private void createItem() {
        try {
            String itemName = createItemNameField.getText();
            double itemCost = Double.parseDouble(itemCostField.getText());
            Item item = new Item(itemName, itemCost);
            items.add(item);
            outputArea.append("Item created: " + item + "\n");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for item creation.");
        }
    }

    private void displayUsers() {
        StringBuilder usersOutput = new StringBuilder("Users:\n");
        for (Account account : accounts) {
            if (!(account instanceof PremiumAccount)) {
                usersOutput.append(account.toString()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(this, usersOutput.toString());
    }

    private void displayPremiumUsers() {
        StringBuilder premiumUsersOutput = new StringBuilder("Premium Users:\n");
        for (Account account : accounts) {
            if (account instanceof PremiumAccount) {
                premiumUsersOutput.append(account.toString()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(this, premiumUsersOutput.toString());
    }

    private void displayItems() {
        StringBuilder itemsOutput = new StringBuilder("Items:\n");
        for (Item item : items) {
            itemsOutput.append(item.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, itemsOutput.toString());
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new test();
            }
        });
    }
}
