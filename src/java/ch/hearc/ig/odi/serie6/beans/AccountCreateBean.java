/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.serie6.beans;

import ch.hearc.ig.odi.serie6.business.Customer;
import ch.hearc.ig.odi.serie6.exceptions.AccountAlreadyExistException;
import ch.hearc.ig.odi.serie6.services.Services;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author jeremy.barfuss
 */
@Named
@SessionScoped
public class AccountCreateBean implements Serializable {

    @Inject
    Services services;
    Customer customer;
    private String number;
    private String name;
    private double rate;

    /**
     * Creates a new instance of AccountCreateBean
     */
    public AccountCreateBean() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String ajouterCompte() throws AccountAlreadyExistException  {
        services.saveAccount(this.number, this.name, this.rate, this.customer);
        this.number = null;
        this.name = null;
        this.rate = 0.0;
        return "valider";
    }
}
