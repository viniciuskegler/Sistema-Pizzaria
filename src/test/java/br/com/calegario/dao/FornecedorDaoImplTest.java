/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.dao;

import br.com.calegario.entidade.Fornecedor;
import com.github.javafaker.Faker;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vinicius.kegler
 */
public class FornecedorDaoImplTest {
    
    private Faker falso;
    private Fornecedor fornecedor;
    private FornecedorDao fornecedorDao;
    private Session sessao;
    
    public FornecedorDaoImplTest() {
        falso = new Faker();
        fornecedorDao = new FornecedorDaoImpl();
    }

    @Test
    public void testSalvar(){
        System.out.println("salvar");
        sessao = HibernateUtil.abrirConexao();
        
        
    }
    
    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");

    }

    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");

    }
    
}
