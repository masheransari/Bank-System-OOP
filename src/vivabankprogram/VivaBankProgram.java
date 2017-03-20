/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vivabankprogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author asher.ansari
 */
class Bank{
    double interestRate = 8.5;
    double transactionFee = 10;
    Customer[] customers = new Customer[1000];
    public void calculateInterest(Customer c){
        Account a= c.getAccount();
        double balance = a.getBalance();
        double interestAmount = balance * interestRate/100;
        double totalAmount = balance + interestAmount;
        System.out.println("Interest Amount : "+interestAmount+" , Total money after interest: "+totalAmount);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getTransactionFee() {
        return transactionFee;
    }
    public Customer[] getCustomer(){
        return customers;
    }
    
    
    
}
class Account{
    double balance = 100;
    String accountName;

    public String getAccountName() {
        return accountName;
    }
    
    private boolean firstTime=true;

    public Account(String accountName) {
        this.accountName = accountName;
    }
    public Account(double balance,String accountName) {
//        this.balance = balance;
        this.accountName = accountName;
        if (balance>=100) {
            this.balance = balance;
        } else {
            this.balance = 100;
        }
    }
    
    public void deposit(double howMuch){
        if (howMuch>0) {
            this.balance = this.balance + howMuch;
            System.out.println("your ammount has been added..."+howMuch);
            
        } else {
            System.err.println("Deposited amount not be in negetive..");
        }
    }
    public void widrawl(double howMuch){
        if (howMuch>=0) {
            if (firstTime == true) {
                double tempBalance = this.balance;
                
                tempBalance = tempBalance-howMuch;
                if (tempBalance>=100) {
                    this.balance = this.balance - howMuch;
                } else {
                    System.err.println("Insufficient balance to remove "+tempBalance);
                }
                firstTime = false;
            } else {
                Bank bank = new Bank();
                double tempbalance =this.balance;
                tempbalance= tempbalance - howMuch - bank.getTransactionFee();
                if (tempbalance>=100) {
                    this.balance = this.balance -howMuch - bank.getTransactionFee();
                } else {
                    System.err.println("Insuffiecient balance to remove..."+howMuch);
                }
            
                    
            }
            
        } else {
            System.err.println("Amount should not be negetive....");
        }
    }
    
    public double getBalance(){
        return this.balance;
    }
}
class Customer{
    String name;
    Account account;

    Customer(String name, Account account) {
        this.name = name;
        this.account = account;
    }
    
    public void display(){
        System.out.println("Name : "+this.name+" & Account Name: "+account.getAccountName()+" , Balance : "+account.getBalance());
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }
    
}

public class VivaBankProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCustomer = 0;
        Bank bank =new Bank();
        Customer[] csArray = bank.getCustomer();
        // TODO code application logic here
//        Account account = new Account(50,"M. ASher Ansari");
//        account.deposit(50);
//        Customer customer = new Customer();
     while(true){
        System.out.println("Good one!!");
        System.out.println("Please Enter Your Choice:");
        System.out.println("1. Add New Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Widrawl Money");
        System.out.println("4. Check Money");
        System.out.println("5. Calculate Interest");
        System.out.println("6. Exit");
        int choice = Integer.parseInt(bufferedReader.readLine());

        switch(choice){
            case 1:
                System.out.println("Creating an account of a new Customer:");
                System.out.println("Please Enter the initial Amount in your account:");
                double bal = Double.parseDouble(bufferedReader.readLine());
                System.out.println("Please Enter Your Account Name: ");
                String nam = bufferedReader.readLine();
                Account a = new Account(bal, nam);
                System.out.println("Please Enter Your Name: ");
                String name = bufferedReader.readLine();
                Customer customer = new Customer(name, a);
                csArray[numberOfCustomer] = customer;
                numberOfCustomer++;
                System.err.println("number of customers : "+numberOfCustomer);
                for (int i = 0; i < numberOfCustomer; i++) {
//                    Customer customer1 = csArray[i];
                    System.err.println(csArray[i].getName()+" : Name");
                    
                }
                break;
            case 2:
                System.out.println("Please Enter the Account Number: ");
              nam = bufferedReader.readLine();
                if (numberOfCustomer == 0) {
                    System.err.println("Account Number Not Found....");
                } else {
                    boolean found = false;
                    for (int i = 0; i < numberOfCustomer; i++) {
                        Account ac = csArray[i].getAccount();
                        String tempAccName = ac.getAccountName();
                        System.err.println(tempAccName);
                        if (nam.equals(tempAccName)) {
                            System.out.println("Please Enter the amount to deposit..:");
                            double amount = Double.parseDouble(bufferedReader.readLine());
                            ac.deposit(amount);
                            found = true;
                        }
                    }
                    if ( found ==false) {
                        System.err.println("Account Number Not Found,...");
                    }
                }
                break;
            case 3:
                System.out.println("Please Enter the Account Number: ");
              nam = bufferedReader.readLine();
                if (numberOfCustomer == 0) {
                    System.err.println("Account Number Not Found....");
                } else {
                    boolean found = false;
                    for (int i = 0; i < numberOfCustomer; i++) {
                        Account ac = csArray[i].getAccount();
                        String tempAccName = ac.getAccountName();
                        System.err.println(tempAccName);
                        if (nam.equals(tempAccName)) {
                            System.out.println("Please Enter the amount to Widrawl..:");
                            double amount = Double.parseDouble(bufferedReader.readLine());
                            ac.widrawl(amount);
                            found = true;
                        }
                    }
                    if ( found ==false) {
                        System.err.println("Account Number Not Found,...");
                    }
                }
                    break;
            case 4:
                                System.out.println("Please Enter the Account Number: ");
              nam = bufferedReader.readLine();
                if (numberOfCustomer == 0) {
                    System.err.println("Account Number Not Found....");
                } else {
                    boolean found = false;
                    for (int i = 0; i < numberOfCustomer; i++) {
                        Account ac = csArray[i].getAccount();
                        String tempAccName = ac.getAccountName();
                        System.err.println(tempAccName);
                        if (nam.equals(tempAccName)) {
//                            System.out.println("Please Enter the amount to deposit..:");
                              System.out.println("Your Total Amount = "+ac.getBalance());
                            found = true;
                        }
                    }
                    if ( found ==false) {
                        System.err.println("Account Number Not Found,...");
                    }
                }
                break;
            case 5:
                                System.out.println("Please Enter the Account Number: ");
              nam = bufferedReader.readLine();
                if (numberOfCustomer == 0) {
                    System.err.println("Account Number Not Found....");
                } else {
                    boolean found = false;
                    for (int i = 0; i < numberOfCustomer; i++) {
                        Account ac = csArray[i].getAccount();
                        String tempAccName = ac.getAccountName();
                        System.err.println(tempAccName);
                        if (nam.equals(tempAccName)) {
//                            System.out.println("Please Enter the amount to deposit..:");
                            bank.calculateInterest(csArray[i]);
                            found = true;;
                        }
                    }
                    if ( found ==false) {
                        System.err.println("Account Number Not Found,...");
                    }
                }
                break;
            case 6:
                System.exit(0);
                break;               
            default:
                System.exit(0);
                break;
        }
    }
    }
    
}
