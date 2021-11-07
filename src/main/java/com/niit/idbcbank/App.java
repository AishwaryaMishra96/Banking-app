package com.niit.idbcbank;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        AccountImpl accountImpl = new AccountImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Thank you for opening an Account with IDBC!" );
        System.out.println("Please select an option from the menu:\n1. Create account\n2. Check balance\n3. Withdraw money\n4. Deposit money");
        int choice = scanner.nextInt();
        if(choice == 1)
        {
            System.out.println("Enter Account Type : ");
            String accountType=scanner.next();
            System.out.println("Enter customer ID");
            int customerId = scanner.nextInt();
       /* int customerId= accountImpl.generateCustomerId();
        Customer customer=new Customer(customerId,name,phoneNo,address);
        boolean addCustomer= accountImpl.addNewCustomer(customer);*/
            String accountNumber= accountImpl.generateAccountNumber();
            Account account=new Account(accountNumber,accountType,customerId,0,0);
            boolean addAccount= accountImpl.addNewAccount(account);
            if(addAccount)
            {
                System.out.println("Account "+account.getAccountNo()+" has been created successfully");
            }
            else
            {
                System.out.println("Something went wrong, please try again");
            }
        }
        else if(choice == 2)
        {
            System.out.println("Please enter your customer ID");
            int customerId = scanner.nextInt();
            double result = accountImpl.checkBalance(customerId);
            System.out.println("Your account with Customer ID "+customerId+" has balance of "+result);
        }
        else if(choice == 3)
        {
            System.out.println("To withdraw money, please enter your account number");
            String accountNo = scanner.next();
           /* int custId = scanner.nextInt();
            String accountType = "save";*/
            System.out.println("Enter amount to be withdrawn");
            int amount = scanner.nextInt();
            String transactionType = "withdraw";
            Account account =accountImpl.getAccountByAccountNo(accountNo);
            account.setAmount(amount);
            boolean result =accountImpl.withdraw(account);
            if(result)
            {
                Transaction transaction = new Transaction(1,accountNo,transactionType,amount,"2021-07-01");
               accountImpl.addNewLog(transaction);
            }
           // Account account1 = new Account(accountNo,accountType,custId,)

        }
       /* System.out.println("To open account, please enter your Name :");
        String name = scanner.next();
        System.out.println("Enter Phone number :");
        String phoneNo=scanner.next();
        System.out.println("Enter Address :");
        String address =scanner.next();*/

    }
}
