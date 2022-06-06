/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.Milkshake;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe Milkshake no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.1, 17/05/2022
 */
public class MilkshakeDao
        extends Dao<Milkshake, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into milkshake (tamanho_id, excluido) values (?, false);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update milkshake set tamanho_id = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, tamanho_id from milkshake where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, tamanho_id from milkshake where excluido = false;";
    }
    
    @Override
    public String obterDeclaracaoDelete()
    {
        return "update milkshake set excluido = true where id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Milkshake e)
    {
        try
        {
            pstmt.setLong(1, e.getTamanho().getId());

            if (e.getId() != null && e.getId() != 0)
            {
                pstmt.setLong(2, e.getId());
            }
        }

        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de Milkshake: " + ex);
        }
    }

    @Override
    public Milkshake extrairObjeto(ResultSet resultSet)
    {
        Milkshake milkshake = null;

        try
        {
            milkshake = new Milkshake(resultSet.getLong("id"),
                                      null,
                                      null);
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de Milkshake do Banco de Dados: " + ex);
        }

        return milkshake;
    }
}
