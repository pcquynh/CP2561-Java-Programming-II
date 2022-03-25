package Assignment1;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Transaction test class
 * Assignment 1
 * CP2561 Winter 2022
 * @author Quynh
 */
public class TransactionTest {

    public static void main(String[] args) {
        System.out.println("Hello Banking World!");
        // Instantiate a savings account object. The savings account can have a initial balance of $0.
        SavingAccount quynhSaving = new SavingAccount(0);

        // Instantiate a chequing account object with a starting balance of $200.
        ChequingAccount quynhChequing = new ChequingAccount(200);

        // Instantiate a TFSA account object.
        // The new TFSA account should have an initial amount added of $100 and a maximum contribution of $16000.
        TFSAccount quynhTfsAccount = new TFSAccount(100, 16000);

        // Using printf, output a line that displays the current values of each of the accounts
        // Format numerical output as proper dollar figures
        System.out.printf("Current value of saving account: %s",
                NumberFormat.getCurrencyInstance().format(quynhSaving.getBalance()));
        System.out.printf("\nCurrent value of chequing account: %s",
                NumberFormat.getCurrencyInstance().format(quynhChequing.getBalance()));
        System.out.printf("\nCurrent value of TFSA account: %s",
                NumberFormat.getCurrencyInstance().format(quynhTfsAccount.getBalance()));


        // menu of choice that user can make, enter 9 if the user wants to exit the loop
        System.out.println("\nMenu: ");
        System.out.println("1. Deposit to savings");
        System.out.println("2. Deposit to chequing");
        System.out.println("3. Deposit to SFTA");
        System.out.println("4. Withdraw from savings");
        System.out.println("5. Withdraw from chequing");
        System.out.println("6. Withdraw from TFSA");
        System.out.println("7. Transfer one account from another");
        System.out.println("8. Print balances of accounts");
        System.out.println("9. Exit");

        // Create a loop, creat try/catch(exception) to ensure the input types are correct
        // when a mismatch type of input is caught, the program print error and end
        boolean continueLoop = true;
        while(continueLoop) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("\nPlease enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter amount to deposit to saving account: ");
                        double depositSaving = scanner.nextInt();
                        quynhSaving.deposit(depositSaving);
                        break;
                    case 2:
                        System.out.println("Enter amount to deposit to chequing account: ");
                        double depositChequing = scanner.nextInt();
                        quynhChequing.deposit(depositChequing);
                        break;
                    case 3:
                        System.out.println("Enter amount to deposit to TFSA account: ");
                        double depositTfsa = scanner.nextInt();
                        quynhTfsAccount.deposit(depositTfsa);
                        break;
                    case 4:
                        System.out.println("Enter amount to withdraw from saving account: ");
                        double withdrawSaving = scanner.nextInt();
                        quynhSaving.withdraw(withdrawSaving);
                        break;
                    case 5:
                        System.out.println("Enter amount to withdraw from chequing account: ");
                        double withdrawChequing = scanner.nextInt();
                        quynhChequing.withdraw(withdrawChequing);
                        break;
                    case 6:
                        System.out.println("Enter amount to withdraw from TFSA account: ");
                        double withrawTfsa = scanner.nextInt();
                        quynhTfsAccount.withdraw(withrawTfsa);
                        break;
                    case 7:
                        // Create bank account array
                        BankAccount[] accountArray = {quynhSaving, quynhChequing, quynhTfsAccount};
                        System.out.println("Enter account transfer (1:Saving, 2:Chequing, 3:TfsAccount): ");
                        int accountTransfer = scanner.nextInt();
                        System.out.println("Enter account transfer to (1:Saving, 2:Chequing, 3:TfsAccount): ");
                        int accountTransferTo = scanner.nextInt();
                        System.out.println("Enter amount to transfer: ");
                        double transferAmount = scanner.nextInt();
                        accountArray[accountTransfer - 1].transfer(accountArray[accountTransferTo - 1], transferAmount);
                        break;
                    case 8:
                        System.out.printf("Current value of saving account: %s",
                                NumberFormat.getCurrencyInstance().format(quynhSaving.getBalance()));
                        System.out.printf("\nCurrent value of chequing account: %s",
                                NumberFormat.getCurrencyInstance().format(quynhChequing.getBalance()));
                        System.out.printf("\nCurrent value of TFSA account: %s",
                                NumberFormat.getCurrencyInstance().format(quynhTfsAccount.getBalance()));
                        System.out.println();
                        break;
                    default:
                        continueLoop = false;
                }
            }catch (InputMismatchException e){
                System.err.println("Must be a number." + e.toString());
            }
        }
        // Change the interest of the saving account to 2.5%
        quynhSaving.setInterestRate(2.5);
        // Add interest to the savings account
        quynhSaving.addInterest(); 
        // Invoke end of period transactions fees for the checking account
        quynhChequing.chargeFees();
        // Calculate any penalty applicable to the TFSA account. Take any penalty off the balance
        //of the TFSA
        double penaltyAmount = quynhTfsAccount.calculatePenalty();
        System.out.printf("Penalty amount for TFSA account is: %s ",
                NumberFormat.getCurrencyInstance().format(penaltyAmount));
        // Increase the contribution room of the TFSA by $1000
        quynhTfsAccount.increaseContribution(1000);
        System.out.printf("\nCurrent value of saving account: %s",
                NumberFormat.getCurrencyInstance().format(quynhSaving.getBalance()));
        System.out.printf("\nCurrent value of chequing account: %s",
                NumberFormat.getCurrencyInstance().format(quynhChequing.getBalance()));
        System.out.printf("\nCurrent value of TFSA account: %s",
                NumberFormat.getCurrencyInstance().format(quynhTfsAccount.getBalance()));
    }

}


