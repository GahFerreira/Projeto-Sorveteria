/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.Quantidade;
import br.edu.ifnmg.projeto_sorveteria.entidade.SorveteAdicional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe Quantidade no Banco de Dados referente a Milkshake.
 *
 * @author GahFerreira
 * @version 1.0, 08/07/2022
 */
public class SorveteAdicionalDao
        extends Dao<SorveteAdicional, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into sorvete_adicional (sorvete_id, adicional_id, excluido) values (?, ?, false);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update sorvete_adicional set sorvete_id = ?, adicional_id = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, sorvete_id, adicional_id from sorvete_adicional where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, sorvete_id, adicional_id from sorvete_adicional where excluido = false;";
    }

    @Override
    public String obterDeclaracaoDelete()
    {
        return "update quantidade set excluido = true where id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, SorveteAdicional e)
    {
        try
        {
            pstmt.setLong(1, e.getSorvete().getId());
            pstmt.setLong(2, e.getAdicional().getId());

            if (e.getId() != null && e.getId() != 0)
            {
                pstmt.setLong(3, e.getId());
            }
        }

        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de SorveteAdicional: " + ex);
        }
    }

    @Override
    public SorveteAdicional extrairObjeto(ResultSet resultSet)
    {
        SorveteAdicional sorveteAdicional = null;

        try
        {
            // TODO Obter sabor e produto composto de Quantidade

            sorveteAdicional = new SorveteAdicional(null,
                                                    null);
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de SorveteAdicional do Banco de Dados: " + ex);
        }

        return sorveteAdicional;
    }
}
