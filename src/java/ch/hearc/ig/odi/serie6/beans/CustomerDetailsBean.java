package ch.hearc.ig.odi.serie6.beans;

import ch.hearc.ig.odi.serie6.business.Account;
import ch.hearc.ig.odi.serie6.business.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author jeremy.barfuss
 */
@Named
@SessionScoped
public class CustomerDetailsBean implements Serializable{

    Customer customer;
    /**
     * Creates a new instance of CustomerDetails
     */
    public CustomerDetailsBean() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public List<Account> getAccountsList() {
        if(this.customer != null)
            return new ArrayList(this.customer.getAccounts().values());
        else
            return null;
    }
    
}
