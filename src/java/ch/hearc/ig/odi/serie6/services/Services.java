package ch.hearc.ig.odi.serie6.services;

import ch.hearc.ig.odi.serie6.business.Bank;
import ch.hearc.ig.odi.serie6.business.Customer;
import ch.hearc.ig.odi.serie6.exceptions.AccountAlreadyExistException;
import ch.hearc.ig.odi.serie6.exceptions.CustomerAlreadyExistException;
import ch.hearc.ig.odi.serie6.exceptions.UnknownCustomerException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 * Classe de services qui stocke les données de l'application dans la session
 * de l'utilisateur. Cette classe est gérée par CDI et peut donc être
 * injectée dans les autres classes Java.
 *
 * @author julien.plumez
 */
@SessionScoped
@Stateful
public class Services implements Serializable {

    private Bank bank;

    public Services() throws AccountAlreadyExistException, CustomerAlreadyExistException {
        bank = new Bank(1, "Raiffeisen Neuchâtel");

        Customer cust = new Customer(1, "Jean", "Dupont");
        bank.addCustomer(cust);

        bank.addAccount("1", "Salaire", 0.001, cust);
        bank.addAccount("2", "Impots", 0.002, cust);

        cust = new Customer(2, "Marie", "Dupont");
        bank.addCustomer(cust);
        bank.addAccount("3", "Epargne", 0.002, cust);
        bank.addAccount("4", "Salaire", 0.001, cust);
    }

    /**
     * Dit à la banque de créer un nouveau client.
     *
     * @param number Le numéro unique du client
     * @param fn Le prénom du client
     * @param ln Le nom du client
     * @throws ch.hearc.ig.odi.serie6.exceptions.CustomerAlreadyExistException
     */
    public void saveCustomer(Integer number, String fn, String ln) throws CustomerAlreadyExistException {
        bank.addCustomer(number, fn, ln);
    }

    public void saveAccount(String number, String label, double rate, Customer customer) throws AccountAlreadyExistException {
        bank.addAccount(number, label, rate, customer);
    }

    /**
     * Retourne le client de la banque qui correspond au numéro passé en
     * paramètre.
     *
     * @param number Le numéro du client à rechercher
     * @return Le client, ou null s'il n'est pas trouvé
     * @throws ch.hearc.ig.odi.serie6.exceptions.UnknownCustomerException
     */
    public Customer getCustomer(Integer number) throws UnknownCustomerException {
        return bank.getCustomerByNumber(number);
    }

    /**
     * Retourne une Map contenant tous les clients de la banqe
     *
     * @return Une Map contenant tous les clients de la banqe
     */
    public Map<Integer, Customer> getCustomers() {
        return bank.getCustomers();
    }

    /**
     * Retourne une List contenant tous les clients de la banque. Utile pour
     * l'affichage des clients dans les facelets
     *
     * @return Une List contenant tous les clients de la banque.
     */
    public List<Customer> getCustomersList() {
        return new ArrayList(getCustomers().values());
    }
}
