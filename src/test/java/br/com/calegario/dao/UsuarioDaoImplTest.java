/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.dao;

import br.com.calegario.entidade.Usuario;
import com.github.javafaker.Faker;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vinicius.kegler
 */
public class UsuarioDaoImplTest {

    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private Session sessao;
    private Faker faker;

    public UsuarioDaoImplTest() {
        usuarioDao = new UsuarioDaoImpl();
        faker = new Faker();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        usuario = new Usuario(null, faker.name().fullName(), faker.internet().emailAddress(), faker.lorem().word());
        sessao = HibernateUtil.abrirConexao();
        usuarioDao.salvarOuAlterar(usuario, sessao);
        sessao.close();
        assertNotNull(usuario.getId());

    }

//    @Test
    public void testAlterar() {
        System.out.println("alterar");
        buscarUsuarioBd();
        usuario.setNome(usuario.getNome() + faker.lorem().word());
        usuario.setLogin(faker.internet().emailAddress());
        sessao = HibernateUtil.abrirConexao();
        usuarioDao.salvarOuAlterar(usuario, sessao);
        sessao.close();

        sessao = HibernateUtil.abrirConexao();
        Usuario usuarioAlt = usuarioDao.pesquisarPorId(usuario.getId(), sessao);
        sessao.close();

        assertTrue(usuario.getNome().equals(usuarioAlt.getNome()) && usuario.getLogin().equals(usuarioAlt.getLogin()));
    }

//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        usuarioDao.excluir(usuario, sessao);
        usuario = usuarioDao.pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        assertNull(usuario);
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        usuario = usuarioDao.pesquisarPorId(usuario.getId(), sessao);
        sessao.close();
        assertNotNull(usuario.getId());
    }

//    @Test
    public void testPesquisarPorLogin() {
        System.out.println("pesquisarPorLogin");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        usuario = usuarioDao.pesquisarPorLogin(usuario.getLogin(), sessao);
        sessao.close();
        assertNotNull(usuario.getId());
    }

    @Test
    public void testVerificarLoginCadastrado() {
        System.out.println("pesquisarPorLogin");
        buscarUsuarioBd();
        sessao = HibernateUtil.abrirConexao();
        boolean teste = usuarioDao.verificarLoginCadastrado(usuario.getLogin(), sessao);
        sessao.close();
        assertTrue(teste);
    }

    private Usuario buscarUsuarioBd() {
        sessao = HibernateUtil.abrirConexao();
        List<Usuario> usuarios = sessao.createQuery("From Usuario u").getResultList();
        sessao.close();
        if (!usuarios.isEmpty()) {
            usuario = usuarios.get(0);
        } else {
            testSalvar();
        }
        return usuario;
    }

}
