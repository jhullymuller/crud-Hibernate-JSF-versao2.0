/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsf.dao;

import br.com.jsf.entidade.Endereco;
import br.com.jsf.entidade.PessoaJuridica;
import br.com.jsf.util.Gerador;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lais.santana
 */
public class PessoaJuridicaDaoImplTest {
    
    private PessoaJuridica pessoaJuridica;
    private Session sessao;
    private PessoaJuridicaDao pessoaJuridicaDao;
    
    public PessoaJuridicaDaoImplTest() {
        pessoaJuridicaDao = new PessoaJuridicaDaoImpl();
    }

    @Test
      public void testSalvar() {
        System.out.println("teste Salvar pessoa Juridica");
        List<Endereco> enderecos = new ArrayList<Endereco>();
        pessoaJuridica = new PessoaJuridica(null, Gerador.gerarPalavra(10), "(48)99999-9999", Gerador.gerarPalavra(10) + "@email.com",
                Gerador.gerarNumero(3) + "."+ Gerador.gerarNumero(3) +".999-99");
        Endereco endereco1 = new Endereco(null, "rua teste", "99999-999", "9", "bairro teste", "cidade teste", "estado teste", "complemento teste", "observacao teste");
        Endereco endereco2 = new Endereco(null, "rua teste 2", "88888-888", "8", "bairro teste 2", "cidade teste 2", "estado teste 2", "complemento teste 2", "observacao teste 2");
        
        enderecos.add(endereco1);
        enderecos.add(endereco2);
        pessoaJuridica.setEnderecos(enderecos);
        
        for(Endereco endereco : enderecos){
            endereco.setPessoa(pessoaJuridica);
        }
        sessao = HibernateUtil.abrirSessao();
        pessoaJuridicaDao.salvarOuAlterar(pessoaJuridica, sessao);
        sessao.close();
        assertNotNull(pessoaJuridica.getId());
    }

    //@Test
    public void testListarTodo() {
        System.out.println("listarTodo");
        
    }
    
}
