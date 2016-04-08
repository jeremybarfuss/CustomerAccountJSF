package ch.hearc.ig.odi.serie6.business;

import ch.hearc.ig.odi.serie6.exceptions.AccountAlreadyExistException;
import ch.hearc.ig.odi.serie6.exceptions.UnknownAccountException;
import java.util.HashMap;

public class Customer {

    private String firstName;
    private String lastName;
    private Integer number;
    HashMap<String, Account> accounts = new HashMap<>();

    public Customer() {
    }

    /**
     *
     * @param number
     * @param firstName
     * @param lastName
     */
    public Customer(Integer number, String firstName, String lastName) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getNumber() {
        return this.number;
    }

    /**
     *
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getFirstName() {
        return this.firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @param number
     * @return Account
     * @throws ch.hearc.ig.odi.serie3.exceptions.UnknownAccountException
     */
    public Account getAccountByNumber(String number) throws UnknownAccountException {
        if (this.accounts.get(number) != null) {
            return this.accounts.get(number);
        } else {
            throw new UnknownAccountException(number);
        }
    }

    public void addAccount(Account account) throws AccountAlreadyExistException {
        if (this.accounts.get(account.getNumber()) == null) {
            this.accounts.put(account.getNumber(), account);
        } else {
            throw new AccountAlreadyExistException();
        }
    }

    public HashMap<String, Account> getAccounts() {
        return this.accounts;
    }

    @Override
    public String toString() {
        return this.number + " - " + this.firstName + " " + this.lastName;
    }

}