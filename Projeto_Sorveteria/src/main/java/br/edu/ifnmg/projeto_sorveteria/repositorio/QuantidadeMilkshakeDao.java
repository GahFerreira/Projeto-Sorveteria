/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.Quantidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe Quantidade no Banco de Dados referente a Milkshake.
 *
 * @author GahFerreira
 * @version 1.0, 08/07/2022
 */
public class QuantidadeMilkshakeDao
        extends Dao<Quantidade, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into quantidade_milkshake (sabor_id, milkshake_id, quantidade_bolas, excluido) values (?, ?, ?, false);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update quantidade set sabor_id = ?, milkshake_id = ?, quantidade_bolas = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, sabor_id, milkshake_id, quantidade_bolas from quantidade where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, sabor_id, milkshake_id, quantidade_bolas from quantidade where excluido = false;";
    }

    @Override
    public String obterDeclaracaoDelete()
    {
        return "update quantidade set excluido = true where id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Quantidade e)
    {
        try
        {
            pstmt.setLong(1, e.getSabor().getId());
            pstmt.setLong(2, e.getProdutoComposto().getId());
            pstmt.setInt(3, e.getQuantidadeBolas());

            if (e.getId() != null && e.getId() != 0)
            {
                pstmt.setLong(4, e.getId());
            }
        }

        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de QuantidadeMilkshake: " + ex);
        }
    }

    @Override
    public Quantidade extrairObjeto(ResultSet resultSet)
    {
        Quantidade quantidade = null;

        try
        {
            quantidade = new Quantidade(resultSet.getLong("id"),
                                        new SaborDao().localizarPorId(resultSet.getLong("sabor_id")),
                                        new MilkshakeDao().localizarPorId(resultSet.getLong("milkshake_id")),
                                        resultSet.getInt("quantidade_bolas"));
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de QuantidadeMilkshake do Banco de Dados: " + ex);
        }

        return quantidade;
    }
}
