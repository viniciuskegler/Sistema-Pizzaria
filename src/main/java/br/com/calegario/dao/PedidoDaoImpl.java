/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.dao;

import br.com.calegario.entidade.Pedido;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
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
        return (Pedido) sessao.createQuery("from Pedido p where p.numero = :nomeHql").setParameter("nomeHql", numero).getSingleResult();
    }

    @Override
    public Integer pesquisarUltimoNumero(Session sessao) {
        return (Integer) sessao.createQuery("select max(p.numero) from Pedido p").getResultList().get(0);
    }

    @Override
    public List<Pedido> pesquisarIntervalo(Session sessao, LocalDate dtInicio, LocalDate dtFim) {
        Date dtInicioHql = Date.valueOf(dtInicio);
        Date dtFimHql = Date.valueOf(dtFim);
        return (List<Pedido>) sessao.createQuery("from Pedido p join fetch p.cliente where p.dt_pedido between :dtInicioHql and :dtFimHql")
                .setParameter("dtInicioHql", dtInicioHql).setParameter("dtFimHql", dtFimHql).getResultList();
    }

}
