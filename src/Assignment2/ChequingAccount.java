package Assignment2;

/**
 * Specialized version of bank account: chequing account
 * Assignment 2
 * CP2561 Winter 2022
 * @author Quynh
 */
public class ChequingAccount extends BankAccount {
    public static final int FREE_TRANSACTION = 3;
    public static final int TRANSACTION_FEE = 2;

    private int transactionCount;

    /**
     * constructor that creates a new bank account with a zero balance
     */
    public ChequingAccount() {
        super();
    }

    /**
     * constructor to create an account with an initial starting balance
     * @param initialBalance initial deposit when open account
     *                       transaction starts at 0
     *  Throw exception if the initial balance is negative
     */
    public ChequingAccount(double initialBalance) throws InvalidAccountException {
        super(initialBalance);
        this.transactionCount = 0;
        if (initialBalance < 0) {
            throw new InvalidAccountException();
        }
    }

    /**
     * get the count of transaction for an account
     * @return count of transaction
     */
    public int getTransactionCount() {
        return this.transactionCount;
    }

    /**
     * override deposit method in super class BankAccount
     * increment transaction's count
     * @param depositAmount (double) amount to deposit
     */
    public void deposit(double depositAmount){
        super.deposit(depositAmount);
        this.transactionCount++;
    }

    /**
     * override withdraw method in super class BankAccount
     * increment transaction's count
     * @param withdrawAmount (double) amount to withdraw
     * throw exception if anyone tries to withdraw an amount from the chequing account
     * that would place the account in a negative balance
     */
    public void withdraw(double withdrawAmount) throws InvalidAccountException {
        double balance = this.getBalance();
        if (withdrawAmount > balance){
            throw new InvalidAccountException("Negative balance");
        }
        else if(withdrawAmount < 0){
            System.out.println("Invalid amount");
        } else {
            balance -= withdrawAmount;
            this.setBalance(balance);
        }
        this.transactionCount++;
    }

    /**
     * method that will charge the transaction fee (if any)
     * to the account for any transactions beyond the free transactions
     * (assume that transfers or balance checks are free)
     */
    public void chargeFees() throws InvalidAccountException {
        if (this.transactionCount <= FREE_TRANSACTION){
            System.out.println("No free applied");
        }else{
            double fee = (this.transactionCount - FREE_TRANSACTION) * TRANSACTION_FEE;
            this.withdraw(fee);
        }
    }
}

