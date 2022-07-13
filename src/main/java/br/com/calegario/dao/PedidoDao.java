/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.dao;

import br.com.calegario.entidade.Pedido;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author vinicius.kegler
 */
public interface PedidoDao extends BaseDao<Pedido, Long> {

    Pedido pesquisarPorNumero(int numero, Session sessao);

    Integer pesquisarUltimoNumero(Session sessao);
    
    List<Pedido> pesquisarIntervalo(Session sessao, LocalDate dtInicio, LocalDate dtFim);
}
