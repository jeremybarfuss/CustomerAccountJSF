package ch.hearc.ig.odi.serie6.business;

import ch.hearc.ig.odi.serie6.exceptions.AccountAlreadyExistException;
import ch.hearc.ig.odi.serie6.exceptions.CustomerAlreadyExistException;
import ch.hearc.ig.odi.serie6.exceptions.UnknownAccountException;
import ch.hearc.ig.odi.serie6.exceptions.UnknownCustomerException;
import java.util.HashMap;

/**
 *
 * @author Jérémy
 */
public class Bank {

    private int number;
    private String name;
    private HashMap<String, Account> accounts = new HashMap<>();
    private HashMap<Integer, Customer> customers = new HashMap<>();

    public Bank(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public HashMap<Integer, Customer> getCustomers() {
        return this.customers;
    }

    public HashMap<String, Account> getAccounts() {
        return this.accounts;
    }

    public Account getAccountByNumber(String number) throws UnknownAccountException {
        if (this.accounts.get(number) != null) {
            return this.accounts.get(number);
        } else {
            throw new UnknownAccountException(number);
        }
    }

    public Customer getCustomerByNumber(int number) throws UnknownCustomerException {
        if (this.customers.get(number) != null) {
            return this.customers.get(number);
        } else {
            throw new UnknownCustomerException(number);
        }
    }

    public void addCustomer(int number, String firstName, String lastName) throws CustomerAlreadyExistException {
        if (this.customers.get(number) == null) {
            this.customers.put(number, new Customer(number, firstName, lastName));
        } else {
            throw new CustomerAlreadyExistException();
        }
    }

    public void addCustomer(Customer c) throws CustomerAlreadyExistException {
        if (this.customers.get(c.getNumber()) == null) {
            this.customers.put(c.getNumber(), c);
        } else {
            throw new CustomerAlreadyExistException();
        }
    }

    public void addAccount(Account account, Customer customer) throws AccountAlreadyExistException {
        if (this.accounts.get(account.getNumber()) == null) {
            this.accounts.put(account.getNumber(), account);
            this.customers.get(customer.getNumber()).addAccount(account);
        } else {
            throw new AccountAlreadyExistException();
        }
    }

    public void addAccount(String number, String name, double rate, Customer customer) throws AccountAlreadyExistException {
        this.addAccount(new Account(number, name, rate, customer), customer);
    }
}
