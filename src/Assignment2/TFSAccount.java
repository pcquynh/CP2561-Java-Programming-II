package Assignment2;

/**
 * Specialized version of bank account: TFSA account
 * Assignment 2
 * CP2561 Winter 2022
 * @author Quynh
 */
public class TFSAccount extends BankAccount {
    private double maxContribution;
    private double penalty = 0.05;

    /**
     * Constructor which accepts two parameters
     * @param maxContribution set the maximum contribution when the account is opened
     * @param initialContribution specifies of an individual will deposit anything when the account is opened
     */
    public TFSAccount(double initialContribution, double maxContribution) {
        super(initialContribution);
        this.maxContribution = maxContribution;
    }

    /**
     * Method that lets the user know how much contribution room is left
     * @return (double) contribution room is left
     */
    public double contributionRoom(){
        return this.maxContribution - this.getBalance();
    }

    /**
     * Method that allows a new maximum contribution limit to be set for an account
     * @param increaseAmount new maximum contribution limit
     */
    public void increaseContribution(double increaseAmount){
        this.maxContribution += increaseAmount;
    }

    /**
     * Method that will return a penalty amount if the amount above the max contribution
     * @return (double) an amount that is equal to the penalty * to the amount above the max contribution
     */
    public double calculatePenalty(){
        if (this.getBalance() < this.maxContribution){
            return 0.0;
        }else{
            return(this.getBalance() - this.maxContribution) * this.penalty;
        }
    }
}
