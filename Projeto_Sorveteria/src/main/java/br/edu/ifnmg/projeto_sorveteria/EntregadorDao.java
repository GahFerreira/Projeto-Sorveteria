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
 * Classe para realização de operações da classe Entregador no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.1, 17/05/2022
 */
public class EntregadorDao
        extends Dao<Entregador, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into entregador (nome, nascimento, cpf, telefone) values (?, ?, ?, ?);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update entregador set nome = ?, nascimento = ?, cpf = ?, telefone = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, nome, nascimento, cpf, telefone from entregador where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, nome, nascimento, cpf, telefone from entregador where excluido = false;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Entregador e)
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
            System.out.println("Falha na Montagem da Declaração SQL de Entregador: " + ex);
        }
    }

    @Override
    public Entregador extrairObjeto(ResultSet resultSet)
    {
        Entregador entregador = null;

        try
        {
            entregador = new Entregador(resultSet.getLong("id"),
                                        resultSet.getString("nome"),
                                        resultSet.getDate("nascimento").toLocalDate(),
                                        resultSet.getString("cpf"),
                                        resultSet.getLong("telefone"),
                                        null);
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de Entregador do Banco de Dados: " + ex);
        }

        return entregador;
    }
}
