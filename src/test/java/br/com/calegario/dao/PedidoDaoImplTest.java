/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.dao;

import br.com.calegario.entidade.Cliente;
import br.com.calegario.entidade.Pedido;
import br.com.calegario.util.GeradorTestes;
import com.github.javafaker.Faker;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vinicius.kegler
 */
public class PedidoDaoImplTest {

    private Session sessao;
    private PedidoDao pedidoDao;
    private Pedido pedido;
    private Faker faker;

    public PedidoDaoImplTest() {
        pedidoDao = new PedidoDaoImpl();
        faker = new Faker();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        pedido = new Pedido(null, faker.number().numberBetween(1, 99999999), BigDecimal.valueOf((faker.number().randomDouble(2, 20, 80))), new Date());
        Cliente cliente = GeradorTestes.gerarCliente();
        pedido.setCliente(cliente);
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido);
        cliente.setPedidos(pedidos);
        sessao = HibernateUtil.abrirConexao();
        pedidoDao.salvarOuAlterar(pedido, sessao);
        sessao.close();
        assertNotNull(pedido.getId());
    }

//    @Test
    public void testAlterar(){
        System.out.println("alterar");
        buscarPedidoBd();
        pedido.setValorTotal(BigDecimal.valueOf((faker.number().randomDouble(2, 20, 80))));
//        pedido.setDt_pedido(new Date());
        sessao = HibernateUtil.abrirConexao();
        pedidoDao.salvarOuAlterar(pedido, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirConexao();
        Pedido pedidoAlt = pedidoDao.pesquisarPorId(pedido.getId(), sessao);
        sessao.close();
//        assertTrue(pedido.getDt_pedido() == pedidoAlt.getDt_pedido() && pedido.getValorTotal() == pedidoAlt.getValorTotal());
        assertTrue(pedido.getValorTotal() == pedidoAlt.getValorTotal());
    }
    
//    @Test
    public void testExcluir(){
        System.out.println("excluir");
        buscarPedidoBd();
        sessao = HibernateUtil.abrirConexao();
        pedidoDao.excluir(pedido, sessao);
        pedido = pedidoDao.pesquisarPorId(pedido.getId(), sessao);
        sessao.close();
        assertNull(pedido);
    
    }
    
//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarPedidoBd();
        sessao = HibernateUtil.abrirConexao();
        pedido = pedidoDao.pesquisarPorId(pedido.getId(), sessao);
        sessao.close();
        assertNotNull(pedido.getId());

    }

//    @Test
    public void testPesquisarPorNumero() {
        System.out.println("pesquisarPorNumero");
        buscarPedidoBd();
        sessao = HibernateUtil.abrirConexao();
        pedido = pedidoDao.pesquisarPorNumero(pedido.getNumero(), sessao);
        sessao.close();
        assertNotNull(pedido);
    }
    
    @Test
    public void testPesquisarUltimoNumero(){
        System.out.println("pesquisarUltimoNumero");
        buscarPedidoBd();
        sessao = HibernateUtil.abrirConexao();
        Integer maiorNumero = pedidoDao.pesquisarUltimoNumero(sessao);
        sessao.close();
        assertNotNull(maiorNumero);
    }
    
    private Pedido buscarPedidoBd() {
        sessao = HibernateUtil.abrirConexao();
        List<Pedido> pedidos = sessao.createQuery("From Pedido P").getResultList();
        sessao.close();
        if (!pedidos.isEmpty()) {
            pedido = pedidos.get(0);
        } else {
            testSalvar();
        }
        return pedido;
    }

}
