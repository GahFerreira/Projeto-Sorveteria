/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.Sorvete;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe Sorvete no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.2, 08/07/2022
 */
public class SorveteDao
        extends Dao<Sorvete, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into sorvete (recipiente_id, excluido) values (?, false);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update sorvete set recipiente_id = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, recipiente_id from sorvete where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, recipiente_id from sorvete where excluido = false;";
    }
    
    @Override
    public String obterDeclaracaoDelete()
    {
        return "update sorvete set excluido = true where id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Sorvete e)
    {
        try
        {
            pstmt.setLong(1, e.getRecipiente().getId());

            if (e.getId() != null && e.getId() != 0)
            {
                pstmt.setLong(2, e.getId());
            }
        }

        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de Sorvete: " + ex);
        }
    }

    @Override
    public Sorvete extrairObjeto(ResultSet resultSet)
    {
        Sorvete sorvete = null;

        try
        {
            sorvete = new Sorvete(resultSet.getLong("id"),
                                  new RecipienteDao().localizarPorId(resultSet.getLong("recipiente_id")));
        }

        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de Sorvete: " + ex);
        }

        return sorvete;
    }
}
