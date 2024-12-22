import java.util.Scanner;

//Creating a class for not enough money on the account
class NotEnoughMoneyException extends Exception {

    //Constructor
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}

// Class to represent a bank account
class Account {
    private String owner;
    private double balance;
    private String accountNumber;

    //Constructor
    public Account(String owner, double balance, String accountNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    //Getters and Setters
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    //Method that simulates the money transfer
    public void transfer(double amount) throws NotEnoughMoneyException {
        if (amount > balance) {
            throw new NotEnoughMoneyException("Not enough money for transfer. Your balance is " + balance);
        }
        balance -= amount;
    }
}

//Main to execute
class MainBE {
    public static void main(String[] args) {
        //Account object
        Account account = new Account("Bartosz R", 1000, "987654321");

        Scanner sc = new Scanner(System.in);

        try {
            //Entering the amount of transfer's funds
            System.out.println("Enter the amount you want to deposit: ");
            double amount = sc.nextDouble();

            //Transfer attempt
            account.transfer(amount);
        } catch (NotEnoughMoneyException e) {
            //insufficient funds exception
            System.out.println(e.getMessage());
        } catch (Exception e) {
            // Handle any other exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // Print the current account balance
            System.out.println("Current balance: " + account.getBalance());
            sc.close();
        }
    }
}

