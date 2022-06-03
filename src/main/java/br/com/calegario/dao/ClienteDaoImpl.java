/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.dao;

import br.com.calegario.entidade.Cliente;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ClienteDaoImpl extends BaseDaoImpl<Cliente, Long> implements ClienteDao, Serializable {

    @Override
    public Cliente pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> pesquisarPorNome(String nome, Session sessao) {
        return sessao.createQuery("from Cliente c join fetch c.enderecos where c.nome like :nomeHql").setParameter("nomeHql", "%" + nome + "%").getResultList();
    }

}
