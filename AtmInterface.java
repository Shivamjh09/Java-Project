import java.util.Scanner;


		class BankAccount {
		    private double balance;

		    public BankAccount(double initialBalance) {
		        this.balance = initialBalance;
		    }

		    public double getBalance() {
		        return balance;
		    }

		    public void deposit(double amount) {
		        if (amount > 0) {
		            balance += amount;
		            System.out.println("Deposit successful. New balance: $" + balance);
		        } else {
		            System.out.println("Invalid deposit amount.");
		        }
		    }

		    public void withdraw(double amount) {
		        if (amount > 0 && amount <= balance) {
		            balance -= amount;
		            System.out.println("Withdrawal successful. New balance: $" + balance);
		        } else {
		            System.out.println("Insufficient balance or invalid withdrawal amount.");
		        }
		    }
		}

		class ATM {
		    private BankAccount bankAccount;

		    public ATM(BankAccount bankAccount) {
		        this.bankAccount = bankAccount;
		    }

		    public void displayOptions() {
		        System.out.println("\nATM Options:");
		        System.out.println("1. Check Balance");
		        System.out.println("2. Deposit");
		        System.out.println("3. Withdraw");
		        System.out.println("4. Exit");
		    }

		    public void executeOption(int option) {
		        Scanner scanner = new Scanner(System.in);
		        switch (option) {
		            case 1:
		                System.out.println("Current Balance: $" + bankAccount.getBalance());
		                break;
		            case 2:
		                System.out.print("Enter deposit amount: $");
		                double depositAmount = scanner.nextDouble();
		                bankAccount.deposit(depositAmount);
		                break;
		            case 3:
		                System.out.print("Enter withdrawal amount: $");
		                double withdrawAmount = scanner.nextDouble();
		                bankAccount.withdraw(withdrawAmount);
		                break;
		            case 4:
		                System.out.println("Exiting ATM. Thank you!");
		                break;
		            default:
		                System.out.println("Invalid option. Please try again.");
		        }
		    }
		}

		public class AtmInterface {

			public static void main(String[] args) {
				
		        BankAccount userAccount = new BankAccount(1000); // Initializing the bank account with a balance of $1000
		        ATM atm = new ATM(userAccount);

		        Scanner scanner = new Scanner(System.in);

		        System.out.println("Welcome to the ATM!");
		        int option;
		        do {
		            atm.displayOptions();
		            System.out.print("Enter option (1-4): ");
		            option = scanner.nextInt();
		            atm.executeOption(option);
		        } while (option != 4);
		    }
		
	}


