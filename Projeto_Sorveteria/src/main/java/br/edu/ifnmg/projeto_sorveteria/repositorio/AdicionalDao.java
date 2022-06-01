/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.Adicional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe Adicional no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.0, 16/05/2022
 */
public class AdicionalDao
        extends Dao<Adicional, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into adicional (nome, preco) values (?, ?);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update adicional set nome = ?, preco = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, nome, preco from adicional where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, nome, preco from adicional where excluido = false;";
    }
    
    @Override
    public String obterDeclaracaoDelete()
    {
        return "update adicional set excluido = true where id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Adicional e)
    {
        try
        {
            pstmt.setString(1, e.getNome());
            pstmt.setDouble(2, e.getPreco());

            if (e.getId() != null && e.getId() != 0)
            {
                pstmt.setLong(3, e.getId());
            }
        }

        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de Adicional: " + ex);
        }
    }

    @Override
    public Adicional extrairObjeto(ResultSet resultSet)
    {
        Adicional adicional = null;

        try
        {
            adicional = new Adicional(resultSet.getLong("id"),
                                      resultSet.getString("nome"),
                                      resultSet.getDouble("peso"));
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de Adicional do Banco de Dados: " + ex);
        }

        return adicional;
    }
}
