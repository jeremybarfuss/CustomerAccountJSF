/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.serie6.exceptions;

/**
 *
 * @author Jérémy
 */
public class UnknownAccountException extends Exception {
    public UnknownAccountException(String number) {
        System.out.println("Compte avec le numéro " + number + " inconnu");
    }
}
