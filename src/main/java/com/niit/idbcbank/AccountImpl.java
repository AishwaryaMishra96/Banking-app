package com.niit.idbcbank;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AccountImpl {

    private Connection connection;

    public AccountImpl() {
        connection = MySqlConnection.getConnection();
    }

    public String generateAccountNumber()
    {
        Random random1 = new Random(100000);
        int firstPart = random1.nextInt(999999);
        Random random2 = new Random(100000);
        int secondPart = random2.nextInt(999999);
        String accountNumber = String.valueOf(secondPart)+String.valueOf(secondPart);
        return accountNumber;
    }

    /*public int generateCustomerId()
    {
        Random random1 = new Random(100000);
        int firstPart = random1.nextInt(999999);
        int customerId = firstPart;
        return customerId;
    }*/

    public double checkBalance(int customerId)
    {
        try {
            String query = "select accountbalance, accounttype from account where customerid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1,customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                return resultSet.getDouble("accountBalance");
            }
            else
            {
                return 0;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return 0;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return 0;
        }
    }

    /*public boolean addNewCustomer(Customer customer) {
        try
        {
            String query = "insert into customer(name, phone, address) values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setString(2, customer.getPhone());
            preparedStatement.setString(3, customer.getAddress());
            int count = preparedStatement.executeUpdate();
            if(count>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }*/

    public boolean addNewAccount(Account account) {
        try
        {
            String query = "insert into account(accountNo, accountType, customerId, accountBalance) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,account.getAccountNo());
            preparedStatement.setString(2, account.getAccountType());
            preparedStatement.setInt(3, account.getCustomerId());
            preparedStatement.setDouble(4,account.getAccountBalance());
            int count = preparedStatement.executeUpdate();
            if(count>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    public Account getAccountByAccountNo(String accountNo) {
        try
        {
            String query = "select * from account where accountNo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,accountNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Account account = new Account(resultSet.getString("accountNo"),resultSet.getString("AccountType"),resultSet.getInt("customerId"),resultSet.getDouble("accountBalance"),resultSet.getInt("amount"));
                return account;
            }
            else
            {
                return null;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean withdraw(Account account) {
        try
        {
            String query = "update account set accountbalance = accountbalance - ? where accountno = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,account.getAmount());
            preparedStatement.setString(2,account.getAccountNo());
            int count = preparedStatement.executeUpdate();
            if(count>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean addNewLog(Transaction transaction) {
        try
        {
            String query = "insert into transaction(transactionId,accountNo, transactionType, amount, transactionDate) values(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,transaction.getTransactionId());
            preparedStatement.setString(2,transaction.getAccountNo());
            preparedStatement.setString(3, transaction.getTransactionType());
            preparedStatement.setInt(4, transaction.getAmount());
            preparedStatement.setString(5, transaction.getTransactionDate());

            int count = preparedStatement.executeUpdate();
            if(count>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }
    }

