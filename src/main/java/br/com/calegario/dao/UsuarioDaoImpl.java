/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.dao;

import br.com.calegario.entidade.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author vinicius.kegler
 */
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario, Long> 
                                            implements UsuarioDao{

    @Override
    public Usuario pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.get(Usuario.class, id);
    }

    @Override
    public Usuario pesquisarPorLogin(String login, Session sessao) {
        return (Usuario) sessao.createQuery("From Usuario u where u.login = :loginHql").setParameter("loginHql", login).getSingleResult();
    }
}
