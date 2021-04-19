/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmr;

/**
 *
 * @author Win
 */
public class ATMR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Transactionhistorym t = new  Transactionhistorym();
        ADMINF rawan = new ADMINF("rawan","alhrbi" ,1 , "123");
        ACCOUNTT thekra = new ACCOUNTT("thekra","alatwi",1,"123");
        ACCOUNTT fay = new ACCOUNTT("fay","albliw",2,"123");
        t.creatNewAdmin(rawan);
        t.creatNewCustomer(thekra);
        t.creatNewCustomer(fay);
//        for (Account a : t.users){
//            a.printInfo();
//        }
        t.loginToSystem();
    }
    
}
