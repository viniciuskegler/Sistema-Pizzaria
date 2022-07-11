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
import org.hibernate.query.Query;

public class ClienteDaoImpl extends BaseDaoImpl<Cliente, Long> implements ClienteDao, Serializable {

    @Override
    public Cliente pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> pesquisarPorNome(String nome, Session sessao) {
        return sessao.createQuery("select distinct (c) from Cliente c join fetch c.enderecos where c.nome like :nomeHql").setParameter("nomeHql", "%" + nome + "%").getResultList();
    }

    @Override
    public Cliente pesquisarPorTelefone(String telefone, Session sessao) throws HibernateException {
        return (Cliente) sessao.createQuery("select distinct(c) from Cliente c where c.telefone = :telHql").setParameter("telHql", telefone ).getSingleResult();
    }

    @Override
    public boolean verificarEmailCadastrado(String email, Session sessao) throws HibernateException {
        Query<Cliente> consulta = sessao.createQuery("from Cliente c where c.email = :emailHql").setParameter("emailHql", email);
        Cliente cliente =  consulta.uniqueResult();        
        return cliente != null;
    }

    @Override
    public boolean verificarTelefoneCadastrado(String telefone, Session sessao) throws HibernateException {
        String resultadoTel = (String) sessao.createQuery("Select c.telefone from Cliente c where c.telefone = :telCadastradoHql").setParameter("telCadastradoHql", telefone).getSingleResult();
        return resultadoTel != null;
    }
    
}
