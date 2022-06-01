/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.Recipiente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe Recipiente no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.1, 17/05/2022
 */
public class RecipienteDao
        extends Dao<Recipiente, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into recipiente (nome, preco) values (?, ?);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update recipiente set nome = ?, preco = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, nome, preco from recipiente where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, nome, preco from recipiente where excluido = false;";
    }
    
    @Override
    public String obterDeclaracaoDelete()
    {
        return "update recipiente set excluido = true where id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Recipiente e)
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
            System.out.println("Falha na Montagem da Declaração SQL de Recipiente: " + ex);
        }
    }

    @Override
    public Recipiente extrairObjeto(ResultSet resultSet)
    {
        Recipiente recipiente = null;

        try
        {
            recipiente = new Recipiente(resultSet.getLong("id"),
                                        resultSet.getString("nome"),
                                        resultSet.getDouble("preco"));
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de Quantidade do Banco de Dados: " + ex);
        }

        return recipiente;
    }
}
