/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.dao;

import br.com.calegario.entidade.Fornecedor;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author vinicius.kegler
 */
public interface FornecedorDao extends BaseDao<Fornecedor, Long> {
    
    List<Fornecedor> pesquisarPorNome(String nome, Session sessao);
}
