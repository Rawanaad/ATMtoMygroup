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
public interface ATMT {
     ACCOUNTT getCustomerInfo(int accountNumber);
    ArrayList<String> getCustomerTransaction(int accountNumer);
    boolean creatNewCustomer(ACCOUNTT customer);
}
