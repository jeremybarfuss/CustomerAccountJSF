package ch.hearc.ig.odi.serie6.beans;

import ch.hearc.ig.odi.serie6.exceptions.CustomerAlreadyExistException;
import ch.hearc.ig.odi.serie6.services.Services;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author jeremy.barfuss
 */
@Named
@RequestScoped
public class CustomerCreateBean implements Serializable {

    @Inject
    Services services;

    private int number;
    private String firstName;
    private String lastName;

    /**
     * Creates a new instance of CustomerCreateBean
     */
    public CustomerCreateBean() {

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String ajouterClient() throws CustomerAlreadyExistException {
        services.saveCustomer(this.number, this.firstName, this.lastName);
        return "valider";
    }
}
