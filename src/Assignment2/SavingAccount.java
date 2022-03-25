package Assignment2;

/**
 * Specialized version of bank account : Saving account
 * Assignment 2
 * CP2561 Winter 2022
 * @author Quynh
 */
public class SavingAccount extends BankAccount {
    private double interestRate;

    /**
     *  constructor that creates a new bank account with a zero balance
     * @param balance
     */
    public SavingAccount(double balance) {
        super(balance);
    }

    /**
     * constructor to create an account with an initial starting balance and interest rate
     * @param balance initial deposit when open account
     * @param interestRate initial interest rate
     */
    public SavingAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }


    /**
     * set the interest rate for the account
     * @param interestRate
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * method that adds the interest, as specified, to the account balance
     * the interest of the amount in the account you can use this formula:
     * interestAmt = balance * interestRate / 100.0
     */
    public void addInterest(){
        double interestAmount = this.getBalance() * this.interestRate/100;
        this.deposit(interestAmount);
    }
}
