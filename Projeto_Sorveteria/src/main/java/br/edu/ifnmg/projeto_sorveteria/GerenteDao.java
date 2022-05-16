/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe Gerente no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.0, 16/05/2022
 */
public class GerenteDao extends Dao<Gerente, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into gerente (nome, nascimento, cpf, telefone) values (?, ?, ?, ?);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update gerente set nome = ?, nascimento = ?, cpf = ?, telefone = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select nome, nascimento, cpf, telefone from gerente where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select nome, nascimento, cpf, telefone from gerente where excluido = false;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Gerente e)
    {
        try
        {
            pstmt.setString(1, e.getNome());
            pstmt.setDate(2, java.sql.Date.valueOf(e.getNascimento()));
            pstmt.setString(3, e.getCpf());
            pstmt.setLong(4, e.getTelefone());
            
            if (e.getId() != null && e.getId() != 0)
            {
                pstmt.setLong(5, e.getId());
            }
        }
        
        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de Gerente: " + ex);
        }
    }

    @Override
    public Gerente extrairObjeto(ResultSet resultSet)
    {
        Gerente gerente = null;
        
        try
        {
            gerente = new Gerente(resultSet.getLong("id"),
                                  resultSet.getString("nome"),
                                  resultSet.getDate("nascimento").toLocalDate(),
                                  resultSet.getString("cpf"),
                                  resultSet.getLong("telefone"));
        }
        
        catch(Exception ex)
        {
            System.out.println("Erro na extração de Gerente do Banco de Dados: " + ex);
        }
        
        return gerente;
    }
}
