/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.dao;

import br.com.calegario.entidade.Fornecedor;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FornecedorDaoImpl extends BaseDaoImpl<Fornecedor, Long> implements FornecedorDao, Serializable {

    @Override
    public Fornecedor pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Fornecedor.class, id);
    }

    @Override
    public List<Fornecedor> pesquisarPorNome(String nome, Session sessao) {
        return sessao.createQuery("from Fornecedor F where F.nome like :nomeHql").setParameter("nomeHql", "%" + nome + "%").getResultList();
    }
}
