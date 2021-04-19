/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmr;

import java.util.ArrayList;

/**
 *
 * @author Win
 */
public class ACCOUNTT {
  public String first_name ; 
    public String last_name; 
    public int AccountNumber; 
    private String pinNumber;

   
    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }
    private int balance ; 
    public ArrayList<String> transactionHistory ; 

    public ACCOUNTT() {
       this.setFirst_name("Default");
        this.setLast_name("Default");
        this.setAccountNumber(0);
        this.setPinNumber("Default");
        this.setBalance(0);
        this.transactionHistory= new ArrayList<String>(); 
        this.transactionHistory.add("Account created.");
    }

   public ACCOUNTT (String first_name, String last_name, int AccountNumber , String pinNumber) {
        this.setFirst_name(first_name);
        this.setLast_name(last_name);
        this.setPinNumber(pinNumber);
        this.setAccountNumber(AccountNumber);
        this.setBalance(0);
        this.transactionHistory= new ArrayList<String>(); 
        this.transactionHistory.add("Account created.");
    }


    
    
    
    
    
    public void setAccountNumber(int AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

  
   

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

public boolean withdraw(int cash){
    if ( cash > balance ) {
        this.transactionHistory.add("withdrawing an amount " + cash + "failed, no enough money int the balance!");
        return false ; 
    }
    else { 
        balance -= cash ; 
        this.transactionHistory.add("withdrawing an amount " + cash + "succeeded!");
        return true ; 
    }
    
}
public boolean deposit(int cash){
    balance += cash ; 
     this.transactionHistory.add("deposit an amount " + cash + "succeeded!, and your balance has now "+this.getBalance());
     return true ;   
}

public void printHistory(){
    
    for (String S : transactionHistory){
        System.out.println(S);
    }
}
public void printInfo(){
    System.out.println("first name     : " +this.getFirst_name());
    System.out.println("last name      : " +this.getLast_name());

    System.out.println("Account number : " +this.getAccountNumber());

    System.out.println("pin number     : " +this.getPinNumber());

    System.out.println("balance        : " +this.getBalance());            
}   
}
