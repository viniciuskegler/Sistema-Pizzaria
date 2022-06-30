/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.dao;

import br.com.calegario.entidade.Cliente;
import br.com.calegario.entidade.Endereco;
import br.com.calegario.entidade.Pessoa;
import br.com.calegario.util.GeradorTestes;
import br.com.calegario.util.GeradorUtil;
import com.github.javafaker.Faker;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vinicius.kegler
 */
public class EnderecoDaoImplTest {

    private Endereco endereco;
    private EnderecoDao enderecoDao;
    private Session sessao;
    private Faker faker;

    public EnderecoDaoImplTest() {
        enderecoDao = new EnderecoDaoImpl();
        faker = new Faker();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        endereco = new Endereco(null, faker.address().streetName(),
                faker.lorem().word(), String.valueOf(faker.number().numberBetween(1, 99999)),
                faker.address().cityName(), faker.address().stateAbbr(), "Casa", GeradorUtil.gerarCep(), faker.lorem().word());
//        Pessoa pessoa = new Pessoa(null, faker.name().fullName(), faker.internet()., telefone)
        Cliente cliente = GeradorTestes.gerarCliente();
        endereco.setPessoa(cliente);
        List<Endereco> enderecos = Arrays.asList(endereco);
        cliente.setEnderecos(enderecos);
        sessao = HibernateUtil.abrirConexao();
        enderecoDao.salvarOuAlterar(endereco, sessao);
        sessao.close();
        assertNotNull(endereco.getId());

    }

    @Test
    public void testAlterar() {
        System.out.println("alterar");
        buscarEnderecoBd();
        endereco.setBairro(faker.address().streetName());
        endereco.setCep(GeradorUtil.gerarCep());
        sessao = HibernateUtil.abrirConexao();
        enderecoDao.salvarOuAlterar(endereco, sessao);
        sessao.close();

        sessao = HibernateUtil.abrirConexao();
        Endereco enderecoAlt = enderecoDao.pesquisarPorId(endereco.getId(), sessao);
        sessao.close();

        assertTrue(endereco.getBairro().equals(enderecoAlt.getBairro()) && endereco.getCep().equals(enderecoAlt.getCep()));
    }

//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarEnderecoBd();
        sessao = HibernateUtil.abrirConexao();
        enderecoDao.excluir(endereco, sessao);
        endereco = enderecoDao.pesquisarPorId(endereco.getId(), sessao);
        sessao.close();
        assertNull(endereco);
    }

    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarEnderecoBd();
        sessao = HibernateUtil.abrirConexao();
        endereco = enderecoDao.pesquisarPorId(endereco.getId(), sessao);
        sessao.close();
        assertNotNull(endereco.getId());
    }

    @Test
    public void testPesquisarPorCep() {
        System.out.println("pesquisarPorCep");
        buscarEnderecoBd();
        sessao = HibernateUtil.abrirConexao();
        endereco = enderecoDao.pesquisarPorCep(endereco.getCep(), sessao);
        sessao.close();
        assertNotNull(endereco.getId());
    }

    @Test
    public void testPesquisarPorEstado() {
        System.out.println("pesquisarPorEstado");
        buscarEnderecoBd();
        sessao = HibernateUtil.abrirConexao();
        List<Endereco> enderecos = enderecoDao.pesquisarPorEstado(endereco.getEstado(), sessao);
        sessao.close();
        assertTrue(!enderecos.isEmpty());
    }

    @Test
    public void testPesquisarPorCidade() {
        System.out.println("pesquisarPorCidade");
        buscarEnderecoBd();
        sessao = HibernateUtil.abrirConexao();
        List<Endereco> enderecos = enderecoDao.pesquisarPorCidade(endereco.getCidade(), sessao);
        sessao.close();
        assertTrue(!enderecos.isEmpty());
    }

    private Endereco buscarEnderecoBd() {
        sessao = HibernateUtil.abrirConexao();
        List<Endereco> enderecos = sessao.createQuery("From Endereco e").getResultList();
        sessao.close();
        if (!enderecos.isEmpty()) {
            endereco = enderecos.get(0);
        } else {
            testSalvar();
        }
        return endereco;
    }

}
