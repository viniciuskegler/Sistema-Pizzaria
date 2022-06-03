/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.util;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Silvio
 */
public class GeraTabela {

    public static void main(String[] args) {
//        Faker falso = new Faker();
////        for (int i = 0; i < 10; i++) {
//            System.out.println(falso.finance().creditCard(CreditCardType.MASTERCARD));
//            System.out.println(falso.address().city());
//            System.out.println(falso.address().cityName());
//            System.out.println(falso.address().fullAddress());
////        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzaria_pu");
        emf.close();
    }
}
