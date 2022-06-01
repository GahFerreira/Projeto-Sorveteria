/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.Tamanho;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe Tamanho no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.0, 16/05/2022
 */
public class TamanhoDao
        extends Dao<Tamanho, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into tamanho (mililitros, preco) values (?, ?);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update tamanho set mililitros = ?, preco = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, mililitros, preco from ponei where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, mililitros, preco from ponei where excluido = false;";
    }
    
    @Override
    public String obterDeclaracaoDelete()
    {
        return "update tamanho set excluido = true where id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Tamanho e)
    {
        try
        {
            pstmt.setInt(1, e.getMililitros());
            pstmt.setDouble(2, e.getPreco());

            if (e.getId() != null && e.getId() != 0)
            {
                pstmt.setLong(3, e.getId());
            }
        }

        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de Tamanho: " + ex);
        }
    }

    @Override
    public Tamanho extrairObjeto(ResultSet resultSet)
    {
        Tamanho tamanho = null;

        try
        {
            tamanho = new Tamanho(resultSet.getLong("id"),
                                  resultSet.getInt("mililitros"),
                                  resultSet.getDouble("preco"));
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de Tamanho do Banco de Dados: " + ex);
        }

        return tamanho;
    }
}
