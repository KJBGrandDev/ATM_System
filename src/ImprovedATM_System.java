import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ImprovedATM_System {
    public static void main(String[] args){
        loginScreen();
    }

    public static void loginScreen(){
        HashMap<Integer,Integer> loginCredentials = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        boolean loginScreen = true;
        while(loginScreen){
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println();

            System.out.println("Enter Choice: ");
            int choiceInput = scanner.nextInt();

            switch (choiceInput){
                case 1: {
                    System.out.println("Enter account number: ");
                    int newAccountNumber = scanner.nextInt();
                    System.out.println("Enter PIN: ");
                    int newPinNumber = scanner.nextInt();
                    loginCredentials.put(newAccountNumber,newPinNumber);
                    System.out.println("Account successfully registered.");
                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.println("Enter account number: ");
                    int hashAccountNumber = scanner.nextInt();
                    System.out.println("Enter PIN: ");
                    int hashPinNumber = scanner.nextInt();
                    for(Map.Entry<Integer,Integer> i: loginCredentials.entrySet()){
                        Integer accountNumber = i.getKey();
                        Integer pinNumber = i.getValue();
                        if(accountNumber == hashAccountNumber && pinNumber == hashPinNumber){
                            System.out.println("Login successful");
                            System.out.println();
                            loginScreen = false;
                            atmSystem();
                            break;
                        } else {
                            System.out.println("Login Failed");
                            System.out.println();
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Goodbye!");
                    loginScreen = false;
                    break;
                }

            }
        }
    }

    public static void atmSystem(){
        Scanner scanner = new Scanner(System.in);
        boolean atmMenu = true;
        double balance = 0;

        while(atmMenu){
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Logout");
            System.out.println("Enter Choice: ");
            int atmMenuInput = scanner.nextInt();

            switch(atmMenuInput){
                case 1: {
                    if(balance != 0){
                        System.out.println("Current balance: $" + balance);
                        System.out.println();
                    } else {
                        System.out.println("Current balance: $" + (int)balance);
                        System.out.println();
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter amount to deposit: ");
                    double depositInput = scanner.nextInt();
                    balance = balance + depositInput;
                    System.out.println("$" + depositInput + " deposited successfully.");
                    System.out.println();
                    break;
                }
                case 3: {
                    System.out.println("Enter amount to withdraw: ");
                    double withdrawalInput = scanner.nextInt();
                    balance = balance - withdrawalInput;
                    System.out.println("$" + withdrawalInput + " withdrawn successfully.");
                    System.out.println();
                    break;
                }
                case 4: {
                    System.out.println("Logged out.");
                    System.out.println();
                    atmMenu = false;
                    loginScreen();
                }

            }
        }
    }
}

