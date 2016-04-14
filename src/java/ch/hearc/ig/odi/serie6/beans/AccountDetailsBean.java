package ch.hearc.ig.odi.serie6.beans;

import ch.hearc.ig.odi.serie6.business.Account;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author jeremy.barfuss
 */
@Named
@RequestScoped
public class AccountDetailsBean {

    Account account;
    /**
     * Creates a new instance of AccountDetailsBean
     */
    public AccountDetailsBean() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    
}
