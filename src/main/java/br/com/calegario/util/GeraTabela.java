/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.util;

import java.text.ParseException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Silvio
 */
public class GeraTabela {

    public static void main(String[] args) throws ParseException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzaria_pu");
        emf.close();
    }
}
