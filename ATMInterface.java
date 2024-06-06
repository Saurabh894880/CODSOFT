import java.util.Scanner;

public class ATMInterface {
    
    // Class to represent the user's bank account
    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public String deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                return "Deposited " + amount + ". New balance is " + balance + ".";
            } else {
                return "Deposit amount must be positive.";
            }
        }

        public String withdraw(double amount) {
            if (amount > balance) {
                return "Insufficient balance for the withdrawal.";
            } else if (amount <= 0) {
                return "Withdrawal amount must be positive.";
            } else {
                balance -= amount;
                return "Withdrew " + amount + ". New balance is " + balance + ".";
            }
        }

        public String checkBalance() {
            return "Current balance is " + balance + ".";
        }
    }
    
    // Class to represent the ATM machine
    static class ATM {
        private BankAccount account;

        public ATM(BankAccount account) {
            this.account = account;
        }

        public String withdraw(double amount) {
            return account.withdraw(amount);
        }

        public String deposit(double amount) {
            return account.deposit(amount);
        }

        public String checkBalance() {
            return account.checkBalance();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            BankAccount myAccount = new BankAccount(1000);
            ATM atm = new ATM(myAccount);

            while (true) {
                System.out.println("Welcome to the ATM");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println(atm.checkBalance());
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        System.out.println(atm.deposit(depositAmount));
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        System.out.println(atm.withdraw(withdrawAmount));
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }

                System.out.println();
            }
        }
    }
}
