/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.util;

import br.com.calegario.entidade.Cliente;
import br.com.calegario.entidade.Endereco;
import com.github.javafaker.Faker;

/**
 *
 * @author vinicius.kegler
 */
public class GeradorTestes {
    
    
    public static Endereco gerarEndereco(){
        Faker falso = new Faker();
        return new Endereco(null, falso.address().streetName(), 
                falso.number().digits(4), falso.address().streetName(), falso.address().cityName(), "Casa", falso.lorem().sentence(), GeradorUtil.gerarCep(), falso.lorem().word());
    }
    
    public static Cliente gerarCliente(){
        Faker falso = new Faker();
        return new Cliente(true, null, falso.name().fullName(), falso.internet().emailAddress(), GeradorUtil.gerarCelular());
    }
    
}
