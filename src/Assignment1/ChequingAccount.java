package Assignment1;

/**
 * Specialized version of bank account: chequing account
 * Assignment 1
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
     */
    public ChequingAccount(double initialBalance) {
        super(initialBalance);
        this.transactionCount = 0;
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
     */
    public void withdraw(double withdrawAmount){
        super.withdraw(withdrawAmount);
        this.transactionCount++;
    }

    /**
     * method that will charge the transaction fee (if any)
     * to the account for any transactions beyond the free transactions
     * (assume that transfers or balance checks are free)
     */
    public void chargeFees(){
        if (this.transactionCount <= FREE_TRANSACTION){
            System.out.println("No free applied");
        }else{
            double fee = (this.transactionCount - FREE_TRANSACTION) * TRANSACTION_FEE;
            this.withdraw(fee);
        }
    }
}

