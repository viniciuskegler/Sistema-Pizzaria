/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author silvio.junior
 * @param <T>
 * @param <ID>
 */
public abstract class BaseDaoImpl<T, ID> implements BaseDao<T, ID>{

    private Transaction transacao;
    
    @Override
    public void salvarOuAlterar(T entidade, Session sessao) throws HibernateException {
        transacao = sessao.beginTransaction();
        sessao.saveOrUpdate(entidade);
        transacao.commit();
    }

    @Override
    public void excluir(T entidade, Session sessao) throws HibernateException {
        transacao = sessao.beginTransaction();
        sessao.delete(entidade);
        transacao.commit();
    }    
}
