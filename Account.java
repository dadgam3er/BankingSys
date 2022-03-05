import java.util.Scanner;

public class Account{
    //set up our variables
    int balance;
    int previousTransaction;
    String CustomerName;
    String CustomerlastName;
    String password;
    int IDLength = 15;


    //let's write the constructor
    Account(String customerfirstName, String customerlastName){
        CustomerName = customerfirstName;
        CustomerlastName = customerlastName;
        this.password = RandomID(IDLength);
    }
    // let's set up our balance function
    void deposit (int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
    void withdraw (int amount){
        if (amount != 0){
            balance = balance - amount;
            previousTransaction = - amount;
        }
    }
    void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("The amount deposited: " + previousTransaction);
        } else if (previousTransaction < 0 ){
            System.out.println("The amount withdrawn: "  + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction(s) occurred");
        }
    }
    void calculateInterest(int years){
        double interestRate = .0195;
        double NewBalance = (balance * years * interestRate) + balance;
        double theAmount = NewBalance - balance;
        System.out.println("The current interest rate is: " + (interestRate * 100) + "%");
        System.out.println("Your new balance after " + years + " years will be : " + NewBalance);
        System.out.println("You have made: $" + theAmount + " in " + years + " years.");
    }
    private String RandomID(int length){
        String passwordSet = "ABCD123456789";
        char [] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int)  (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    void showMenu(){
        char option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + CustomerName + " " + CustomerlastName + "!");
        System.out.println("Your ID is: " + password);
        System.out.println("\n\nWhat would you like to do\n");
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate your interest over given years");
        System.out.println("F. Exit the menu ");
        do {
            System.out.print("\nEnter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            switch (option) {
                //option A
                case 'A':
                    System.out.println("##############################################");
                    System.out.println("#          Balance = $" + balance +"         #");
                    System.out.println("##############################################\n\n");
                    break;
                case 'B':
                    System.out.print("Enter the amount of deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.print("Enter the withdrawal amount: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                case 'D':
                    System.out.println("##############################################");
                    getPreviousTransaction();
                    System.out.println("##############################################\n\n");
                    break;
                case 'E':
                    System.out.print("Enter how many years of occurred interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    System.out.println("\n");
                    break;
                case 'F':
                    System.out.println("######################################################");
                    break;
                default:
                    System.out.println("Error: Invalid option. Please enter A, B, C, D, E, F");
                    break;
            }
        } while(option != 'F');
            System.out.println("# Thank you for banking with zBank, have a great day #");
            System.out.println("######################################################");
    }
}
