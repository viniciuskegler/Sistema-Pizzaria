/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.dao;

import br.com.calegario.entidade.Endereco;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class EnderecoDaoImpl extends BaseDaoImpl<Endereco, Long> implements EnderecoDao, Serializable {

    @Override
    public Endereco pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Endereco.class, id);
    }

    @Override
    public Endereco pesquisarPorCep(String cep, Session sessao) {
        return (Endereco) sessao.createQuery("From Endereco e where e.cep = :cepHql").setParameter("cepHql", cep).getSingleResult();
    }

    @Override
    public List<Endereco> pesquisarPorEstado(String estado, Session sessao) {
        return sessao.createQuery("From Endereco e where e.estado = :estadoHql").setParameter("estadoHql", estado).getResultList();
    }

    @Override
    public List<Endereco> pesquisarPorCidade(String cidade, Session sessao) {
        return sessao.createQuery("From Endereco e where e.cidade = :cidadeHql").setParameter("cidadeHql", cidade).getResultList();
    }

}
