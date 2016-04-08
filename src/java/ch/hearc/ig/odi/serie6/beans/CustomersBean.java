package ch.hearc.ig.odi.serie6.beans;

import ch.hearc.ig.odi.serie6.business.Customer;
import ch.hearc.ig.odi.serie6.services.Services;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author jeremy.barfuss
 */
@Named
@RequestScoped
public class CustomersBean {

    @Inject Services services;
    public CustomersBean() {

    }

    public List<Customer> getCustomers() {
        return services.getCustomersList();
    }
}
