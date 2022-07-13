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
public interface UsuarioDao extends BaseDao<Usuario, Long> {

    Usuario pesquisarPorLogin(String login, Session sessao);

    boolean verificarLoginCadastrado(String login, Session sessao)
            throws HibernateException;

}
