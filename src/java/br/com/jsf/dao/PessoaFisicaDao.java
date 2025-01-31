/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsf.dao;

import br.com.jsf.entidade.Endereco;
import br.com.jsf.entidade.PessoaFisica;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author lais.santana
 */
public interface PessoaFisicaDao extends BaseDao<PessoaFisica, Long>{
  
    PessoaFisica pesquisarPorIDcomEndereco(Long id, Session session) throws HibernateException;

    List<PessoaFisica> pesquisarPessoaPornome(String nome,Session session) throws HibernateException;
    
    PessoaFisica pesquisaCPF (String cpf , Session session)throws HibernateException;

    public List<Endereco> pesquisar(List<Endereco> enderecos, Session sessao);

    
        
    }

