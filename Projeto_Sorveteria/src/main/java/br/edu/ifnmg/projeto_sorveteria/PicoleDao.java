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
 * Classe para realização de operações da classe Picole no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.1, 17/05/2022
 */
public class PicoleDao
        extends Dao<Picole, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into picole (tipo, idSabor) values (?, ?);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update picole set tipo = ?, idSabor = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, tipo, idSabor from picole where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, tipo, idSabor from picole where excluido = false;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Picole e)
    {
        try
        {
            pstmt.setString(1, e.getTipo().name());
            pstmt.setLong(2, e.getSabor().getId());

            if (e.getId() != null && e.getId() != 0)
            {
                pstmt.setLong(3, e.getId());
            }
        }

        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de Picole: " + ex);
        }
    }

    @Override
    public Picole extrairObjeto(ResultSet resultSet)
    {
        Picole picole = null;

        try
        {
            // TODO Obter o sabor do picolé do Banco de Dados

            picole = new Picole(resultSet.getLong("id"),
                                Tipo.valueOf(resultSet.getString("tipo")),
                                null);
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de Picole do Banco de Dados: " + ex);
        }

        return picole;
    }
}
