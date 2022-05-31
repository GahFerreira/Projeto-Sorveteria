/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.Garcom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe Garcom no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.1, 17/05/2022
 */

// TODO Implementar o trabalho com a lista de pedidos físicos
public class GarcomDao
        extends Dao<Garcom, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into garcom (nome, nascimento, cpf, telefone) values (?, ?, ?, ?);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update garcom set nome = ?, nascimento = ?, cpf = ?, telefone = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, nome, nascimento, cpf, telefone from garcom where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, nome, nascimento, cpf, telefone from garcom where excluido = false;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Garcom e)
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
    public Garcom extrairObjeto(ResultSet resultSet)
    {
        Garcom garcom = null;

        try
        {
            garcom = new Garcom(resultSet.getLong("id"),
                                resultSet.getString("nome"),
                                resultSet.getDate("nascimento").toLocalDate(),
                                resultSet.getString("cpf"),
                                resultSet.getLong("telefone"),
                                null);
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de Garcom do Banco de Dados: " + ex);
        }

        return garcom;
    }
}
