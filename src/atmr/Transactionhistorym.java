/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmr;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Win
 */
public class Transactionhistorym {
     public static ArrayList<ACCOUNTT> users = new ArrayList<ACCOUNTT>();
    public static ArrayList<ADMINF> admins = new ArrayList<ADMINF>();

    public ACCOUNTT getCustomerInfo(int accountNumber) {
        for (ACCOUNTT A : users){
            if (A.getAccountNumber() == accountNumber){
                return A ; 
            }
        }
        return null ; 
    }

      public ArrayList<String> getCustomerTransaction(int accountNumber) {
        for (ACCOUNTT A : users){
            if (A.getAccountNumber()== accountNumber){
                return A.transactionHistory; 
            }
            
        }
        return null; 
    }

    public boolean creatNewCustomer(ACCOUNTT customer) {
        if (customer != null){
            users.add(customer);
            return true ;  
        }
                 return false ; 
     
     
    }
    
    public boolean creatNewAdmin(ADMINF admin){
        if ( admin != null){
            admins.add(admin);
        return true; 
        }
        return false ; 
        
    }
    
    public ADMINF getAdminInfo(int accountNumber) {
        for (ADMINF A : admins){
            if (A.getAccountNumber() == accountNumber){
                return A ; 
            }
        }
        return null ; 
    }
     
     
    public void loginToSystem(){
        System.out.println("========== Welcome to ATM System ==========");
        Scanner in = new Scanner(System.in);
        System.out.println("========== Enter to the System as :");
        System.out.println("========== Admin press 1:");
        System.out.println("========== User press 2 :");
        System.out.println("========== Exit the ATM System press 3:");
        int ch = in.nextInt();
        in.nextLine();
        switch(ch){
            case 1:{
                loginAsAdmin();
                break; 
            }
            case 2:{
                loginAsUser();
                break ; 
            }
            case 3:{
                return ; 
            }
        }
        loginToSystem();
    }
    public void loginAsAdmin(){
        Scanner in = new Scanner(System.in);
        System.out.println("========== Admin Log in :");
        System.out.println("========== Enter your Account number :");
        int account_num = in.nextInt();
        in.nextLine();
        System.out.println("========== Enter Your pin number :");
        String pin_num = in.nextLine();
        int index = 0 ; 
        //System.out.println(""+ account_num + " "+ pin_num);
        boolean adminFound = false ; 
        for (; index<admins.size();index++){
         
            if (admins.get(index).getPinNumber().equals(pin_num) && admins.get(index).getAccountNumber() == account_num){
                adminFound= true; 
                break ;
            }
        }
       if (adminFound){
           adminMenu(index); 
           
       }else{
           System.out.println("========== these credintials are not correct!!, Try again");
           System.out.println("");
           loginToSystem();
       }
        
       
    }
    public void loginAsUser(){
         Scanner in = new Scanner(System.in);
        System.out.println("========== User Log in :");
        System.out.println("========== Enter your Account number :");
        int account_num = in.nextInt();
        in.nextLine();
        System.out.println("========== Enter Your pin number :");
        String pin_num = in.nextLine();
        int index = 0 ; 
        boolean userFound = false ; 
        for (; index<users.size();index++){
            if (users.get(index).getAccountNumber() == account_num && users.get(index).getPinNumber().equals(pin_num)){
                userFound= true; 
                break ;
            }
        }
       if ( userFound){
           userMenu(index); 
           
       }else{
           System.out.println("========== these credintials are not correct!!, Try again");
           System.out.println("");
           loginToSystem();
       }
        
       
    }
        
    public void adminMenu(int index){
        Scanner in = new Scanner(System.in);
        System.out.println("========== Admin Menu please choose a process :");
        System.out.println("========== To creat a user press 1 :");
        System.out.println("========== To creat an Admin press 2 :");
        System.out.println("========== To show user's Transaction History press 3 :");
        System.out.println("========== To show Admin's work History press 4 :");
        System.out.println("========== To show Admin's list in the database press 5 :");

        System.out.println("========== To show users's list in the database press 6 :");

        System.out.println("========== To exit this menu press 7 :");
        int ch = in.nextInt();
        in.nextLine();
        switch(ch){
            case 1:{
               ACCOUNTT temp= admins.get(index).creatNewAccount();
               if (creatNewCustomer(temp))
               {
                  System.out.println("========== User created successfully!");
                  admins.get(index).workHistory.add("========== creating user with account number :" +temp.getAccountNumber());
               }else{
                   System.out.println("========== User is not created ");
               }
                adminMenu(index);
                break; 
            }
            case 2:{
                   ADMINF temp= admins.get(index).creatNewAdmin();
               if (creatNewAdmin(temp))
               {
                  System.out.println("========== Admin created successfully!");
                  admins.get(index).workHistory.add("========== creating admin with account number :" +temp.getAccountNumber());

               }else{
                   System.out.println("========== Admin is not created ");
               }
               adminMenu(index);
                break; 
            }
            case 3:{
                System.out.println("========== please Enter user's account number");
                int accountNum= in.nextInt();
                in.nextLine();
                int ind = 0 ; 
                for ( ; ind < users.size() ; ind++){
                    if (users.get(ind).getAccountNumber() == accountNum){
                        users.get(ind).printHistory();
                        admins.get(index).workHistory.add("========== show works History of the user number :"+accountNum);

                        break ;
                    }
                    
                }
                adminMenu(index);
                break;
            }
            case 4:{
                System.out.println("========== please Enter admin's account number");
                int accountNum= in.nextInt();
                in.nextLine();
                int ind = 0 ;
                for ( ; ind < users.size() ; ind++){
                    if (admins.get(ind).getAccountNumber() == accountNum){
                        admins.get(ind).printHistory();
                        admins.get(index).workHistory.add("========== show works History of the admin number :"+accountNum);
                        break ;
                    }
              
                
                }
                
                        adminMenu(index);
                break; 
            }
            case 5:{
                printdbadmin(); 
                adminMenu(index);
                break; 
            }
            case 6:{
                printdbuser(); 
                
                adminMenu(index);
                break; 
            }
            case 7:{
                System.out.println("========== Exiting Admin Menu..");
                loginToSystem();
            }
        }
    } 
    
    public void userMenu (int index){
        Scanner in = new Scanner(System.in);
        System.out.println("==========user Menu please choose a process :");
        System.out.println("==========To widthdraw from your account press 1 :");
        System.out.println("==========To deposit money into your account press 2 :");
        System.out.println("==========To show your balance  press 3 :");
        System.out.println("==========To Transfer money to another account press 4 :");
        System.out.println("==========To show My transactions History press 5 :");
        System.out.println("==========To exit this menu press 6 :");
        int ch = in.nextInt();
        in.nextLine();
        switch(ch){
            case 1:{
                System.out.println("==========withdraw process Initiated.. ..:");
                System.out.println("==========Enter the amount of money you want to withdraw: ");
                int amount = in.nextInt();
                in.nextLine();
                
                if ( amount >=0){
                    if(users.get(index).withdraw(amount))System.out.println("withdrawing succeeded, now you have in your balance "+users.get(index).getBalance());
                }else {
                System.out.println("==========withdrawing failed, now you have in your balance "+users.get(index).getBalance());
                }
                     
                userMenu(index);
                break; 
            }
            case 2:{
               System.out.println("==========deposit process Initiated..");
               System.out.println("==========please Enter deposit amount");
               int amount = in.nextInt(); 
               in.nextLine();
               if ( amount >= 0 ){
                   users.get(index).deposit(amount);
                   System.out.println("==========deposit money successfully !");
               }else {
                   System.out.println("==========you can't deposit negative amount , try again");
               }
               userMenu(index);
                break; 
            }
            case 3:{
                System.out.println("==========showing the balance.. ");
             
                System.out.println("==========you balance is :"+users.get(index).getBalance()+"$");
                userMenu(index);
                break;
            }
            case 4:{
              System.out.println("==========transfer process is initiated");
              System.out.println("==========please Enter the receiver account number");
              int recaccountNum = in.nextInt();
              in.nextLine();
              int ind = 0 ;
              boolean reciverFlage = false ; 
              for (; ind < users.size() ; ind++){
                  if (users.get(ind).getAccountNumber()== recaccountNum){
                      reciverFlage = true; 
                      break; 
                  }
              }
              if(reciverFlage){
                  System.out.println("==========Enter the amount of cash to send it :");
                  int amount = in.nextInt();
                  in.nextLine();
                  if ( amount > 0 ){
                      if ( transferMoney(users.get(index),users.get(ind),amount)){
                          System.out.println("==========transfer complete!!.");
                      }
                      else {
                          System.out.println("==========there is no enough money");
                      }
                  }
                  else {
                      System.out.println("==========you can't send negative amount of money !!");
                  }
                    
              }else {
                  System.out.println("==========credintials are not correct ! try,again");
              }
                userMenu(index);
                break; 
                
                }
            case 5:{
                users.get(index).printHistory();
                 userMenu(index);
                break;
            }
                
            case 6:{
                System.out.println("==========Exiting Admin Menu..");
                loginToSystem();
            }
        }
    }
    
    public boolean transferMoney(ACCOUNTT sender , ACCOUNTT reciever ,int cash){
        if ( cash <= sender.getBalance()){
            sender.setBalance(sender.getBalance() - cash);
            sender.transactionHistory.add("sending the amount "+cash+"$ of money to account number "+reciever.getAccountNumber());
            reciever.setBalance(reciever.getBalance()+cash);
          reciever.transactionHistory.add("reciving the amount "+cash+"$ of money from the account number "+sender.getAccountNumber());
          return true ;
        }
        else {
            return false ; 
        }
        
        
    }

    private void printdbuser() {
      for (ACCOUNTT A : users){
          A.printInfo();
          System.out.println("=========================");
      }
    }

    private void printdbadmin() {
        for (ADMINF A : admins){
            A.printInfo();
            System.out.println("=========================");

        }
    }
}
