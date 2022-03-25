package ReviewAssignment;

/**
 * Bank Account Class
 * Review assignment 0
 * CP2561 Winter 2022
 * @author Quynh
 */
public class BankAccount {
    private double balance;

    /**
     * constructor that creates a new bank account with a zero balance
     */
    public BankAccount() {
        this.balance = 0;
    }

    /**
     * constructor to create an account with an initial starting balance
     * if balance is not positive the account defaults to a balance of 0
     * @param balance initial deposit when open account
     */
    public BankAccount(double balance) {
        if (balance > 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    /**
     * get the balance of account
     * @return balance of account
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * set the balance for account
     * @param balance balance of account
     */
    private void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * method that accepts an amount to be deposited in the account
     * if deposit amount is larger or equal 0, add this amount to balance
     * else print error message
     * @param depositAmount (double) amount to deposit
     */
    public void deposit(double depositAmount) {
        if (depositAmount >= 0) {
            this.balance += depositAmount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    /**
     * method that accepts an amount to withdraw from the account
     * if withdrawn amount is larger than account's balance, print error message
     * else minus the withdrawn amount from account's balance
     * @param withdrawAmount (double) amount to withdraw
     */
    public void withdraw(double withdrawAmount) {
        if (withdrawAmount > this.balance) {
            System.out.println("Withdrawal failed: insufficient fun!.");
        } else if(withdrawAmount < 0){
            System.out.println("Invalid amount");
        } else {
            this.balance -= withdrawAmount;
        }
    }

    /**
     * method that will transfer money from one bank account to another bank account,
     * if the transfer amount is bigger than balance of transferred amount, print error message,
     * else update account balance
     * @param account (Bankaccount object)
     * @param amount (double) amount to transfer
     */
    public void transfer(BankAccount account, double amount) {
        if (amount > this.balance) {
            System.out.println("Amount transfer is larger than your account balance.");
            account.getBalance();
        } else {
            this.setBalance(this.getBalance() - amount);
            account.setBalance(account.getBalance() + amount);
        }
    }
}
