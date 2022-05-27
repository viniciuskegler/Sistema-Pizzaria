/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.dao;

import br.com.calegario.entidade.Pedido;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class PedidoDaoImpl extends BaseDaoImpl<Pedido, Long> implements PedidoDao, Serializable {

    @Override
    public Pedido pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Pedido.class, id);
    }

    @Override
    public Pedido pesquisarPorNumero(int numero, Session sessao) {
        Pedido pedidoPesq = (Pedido) sessao.createQuery("from Pedido p where p.numero = :nomeHql").setParameter("nomeHql", numero).getSingleResult();
        return pedidoPesq;
    }
}
