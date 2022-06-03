/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.dao;

import br.com.calegario.entidade.Cliente;
import br.com.calegario.entidade.Endereco;
import br.com.calegario.util.GeradorTestes;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author vinicius.kegler
 */
public class ClienteDaoImplTest {

    private Session sessao;
    private Cliente cliente;
    private Faker falso;
    private ClienteDao clienteDao;

    public ClienteDaoImplTest() {
        clienteDao = new ClienteDaoImpl();
        falso = new Faker();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");

        cliente = new Cliente(true, null, falso.name().fullName(), falso.internet().emailAddress(), falso.phoneNumber().cellPhone());
        List<Endereco> enderecos = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            enderecos.add(GeradorTestes.gerarEndereco());
            enderecos.get(i).setPessoa(cliente);
        }
        cliente.setEnderecos(enderecos);
        sessao = HibernateUtil.abrirConexao();
        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();
        assertNotNull(cliente.getId());
    }

    //@Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        cliente = clienteDao.pesquisarPorId(cliente.getId(), sessao);
        sessao.close();
        assertNotNull(cliente.getId());

    }

    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        List<Cliente> cliPesq = clienteDao.pesquisarPorNome(cliente.getNome(), sessao);
        sessao.close();
        assertTrue(!cliPesq.isEmpty());

    }

    public Cliente buscarClienteBd() {
        sessao = HibernateUtil.abrirConexao();
        List<Cliente> clientes = sessao.createQuery("From Cliente C").getResultList();
        sessao.close();
        if (!clientes.isEmpty()) {
            cliente = clientes.get(0);
        } else {
            testSalvar();
        }
        return cliente;
    }

}
