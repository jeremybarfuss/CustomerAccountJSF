package ch.hearc.ig.odi.serie6.beans;

import ch.hearc.ig.odi.serie6.business.Account;
import ch.hearc.ig.odi.serie6.business.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author jeremy.barfuss
 */
@Named
@RequestScoped
public class CustomerDetailsBean {

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
        return new ArrayList(this.customer.getAccounts().values());
    }
    
}
