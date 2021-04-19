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
public class ADMINF {
       public String first_name ; 
    public String last_name; 
    public int AccountNumber; 
    private String pinNumber; 
    public ArrayList<String> workHistory ; 

    

    public ADMINF() {
         this.setFirst_name("Default");
        this.setLast_name("Default");
        this.setPinNumber("Default");
        this.setAccountNumber(0);
        this.workHistory = new ArrayList<String>(); 
        this.workHistory.add("Admin account created!");
        
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public ADMINF(String first_name, String last_name, int AccountNumber , String pinNumber) {
        this.setFirst_name(first_name);
        this.setLast_name(last_name);
        this.setPinNumber(pinNumber);
        this.setAccountNumber(AccountNumber);
        this.workHistory = new ArrayList<String>(); 
        this.workHistory.add("Admin account created!");
        
        
        
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

    public void setAccountNumber(int AccountNumber) {
        this.AccountNumber = AccountNumber;
    }
    public ACCOUNTT creatNewAccount(){
        Scanner in = new Scanner (System.in);
        ACCOUNTT temp = new ACCOUNTT(); 
        System.out.println("========== Creating new User ..");
        System.out.println ("========== Enter your first name : ");
        String first_name = in.nextLine();
        System.out.println("========== Enter your last name : ");
        String last_name  = in.nextLine();
        System.out.println("========== Enter your Account number(you will use this number to Enter to your account :");
        int Account_number = in.nextInt(); 
        in.nextLine();
        System.out.println("========== Enter your Account password :");
        String password = in.nextLine();
        System.out.println("========== Do you want to complete creation of this user with these information");
        System.out.println("first name     : "+first_name);
        System.out.println("last name      :  "+last_name);   
        System.out.println("Account number : "+Account_number);
        System.out.println("pin number     : "+password);
        System.out.println("========== To save press 1 :");
        System.out.println("========== To Exit without saving press 2 :");
        int ch = in.nextInt();
        in.nextLine();
        switch(ch){
            case 1:{
                temp.setFirst_name(first_name);
                temp.setLast_name(last_name);
                temp.setAccountNumber(Account_number);
                temp.setPinNumber(password);
                break ; 
            }
            case 2:{
                temp = null; 
                break ; 
            }
        }
        return temp ; 
    }
     public ADMINF creatNewAdmin(){
        Scanner in = new Scanner (System.in);
        ADMINF temp = new ADMINF(); 
        System.out.println("========== Creating new Admin ..");
        System.out.println ("========== Enter first name : ");
        String first_name = in.nextLine();
        System.out.println("========== Enter last name : ");
        String last_name  = in.nextLine();
        System.out.println("========== Enter your Admin number(you will use this number to Enter to your admin account :");
        int Account_number = in.nextInt(); 
        in.nextLine();
        System.out.println("========== Enter your Admin password :");
        String password = in.nextLine();
        System.out.println("========== Do you want to complete creation of this admin with these information");
        System.out.println("first name     : "+first_name);
        System.out.println("last name      :  "+last_name);   
        System.out.println("Account number : "+Account_number);
        System.out.println("pin number     : "+password);
        System.out.println("========== To save press 1 :");
        System.out.println("========== To Exit without saving press 2 :");
        int ch = in.nextInt();
        in.nextLine();
        switch(ch){
            case 1:{
                temp.setFirst_name(first_name);
                temp.setLast_name(last_name);
                temp.setAccountNumber(Account_number);
                temp.setPinNumber(password);
                break ; 
            }
            case 2:{
                temp = null; 
                break ; 
            }
        }
        return temp ; 
    }
    
    public void printHistory(){
        for (String S : workHistory){
            System.out.println(S);
            System.out.println("========== ========== ");
        }
    }
    public void printInfo(){
    System.out.println("========== first name     : " +this.getFirst_name());
    System.out.println("========== last name      : " +this.getLast_name());

    System.out.println("========== Account number : " +this.getAccountNumber());

    System.out.println("========== pin number     : " +this.getPinNumber());
    }
}


