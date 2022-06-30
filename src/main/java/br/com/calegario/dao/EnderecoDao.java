/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.dao;

import br.com.calegario.entidade.Endereco;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author vinicius.kegler
 */
public interface EnderecoDao extends BaseDao<Endereco, Long>{
    
    Endereco pesquisarPorCep(String cep, Session sessao);
    List<Endereco> pesquisarPorEstado(String estado, Session sessao);
    List<Endereco> pesquisarPorCidade(String cidade, Session sessao);
}
