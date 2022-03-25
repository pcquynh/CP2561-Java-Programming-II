package ReviewAssignment;

/**
 * Transaction test class
 * Review assignment 0
 * CP2561 Winter 2022
 * @author Quynh
 */
public class TransactionTest {
    public static void main(String[] args) {
        System.out.println("Hello Banking World!");
        /* Instantiate a savings account object, Deposit 5000 into the savings account
         Add interest to the savings account
         */
        SavingAccount quynhSaving = new SavingAccount(5000, 3);
        System.out.println("5000 was deposit into Quynh saving account.");
        quynhSaving.addInterest();


        //Instantiate a chequing account object
        ChequingAccount quynhChequing = new ChequingAccount();

        //  Transfer 1000 to the chequing account
        quynhSaving.transfer(quynhChequing, 1000);
        System.out.println("Transfer 1000 from saving account to chequing account");

        /*Withdraw 200 from the chequing account
        Withdraw 400 from the chequing account
        Withdraw 300 from the chequing account
        Withdraw 50 from the chequing account
        */

        quynhChequing.withdraw(200);
        quynhChequing.withdraw(400);
        quynhChequing.withdraw(300);
        quynhChequing.withdraw(50);
        System.out.println("Withdraw 200, 400, 300, 50 from chequing account");

        // Change the interest of the savings account to 5%
        quynhSaving.setInterestRate(5);
        System.out.println("5% was set as interest rate for saving account");

        //  Invoke end of period transactions fees for the checking account
        quynhChequing.chargeFees();

        //  Add interest to the savings account
        quynhSaving.addInterest();

        //  Display the final balance for the savings account and chequing account
        System.out.printf("Final balance for Quynh saving account: %.2f ", quynhSaving.getBalance());
        System.out.printf("\nFinal balance for Quynh chequing account: %.2f ", quynhChequing.getBalance());
    }
}
