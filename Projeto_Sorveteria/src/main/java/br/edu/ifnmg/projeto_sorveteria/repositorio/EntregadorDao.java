/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.Entregador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe Entregador no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.2, 08/07/2022
 */
public class EntregadorDao
        extends Dao<Entregador, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into entregador (nome, nascimento, cpf, telefone, salario, excluido) values (?, ?, ?, ?, ?, false);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update entregador set nome = ?, nascimento = ?, cpf = ?, telefone = ?, salario = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, nome, nascimento, cpf, telefone, salario from entregador where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, nome, nascimento, cpf, telefone, salario from entregador where excluido = false;";
    }
    
    @Override
    public String obterDeclaracaoDelete()
    {
        return "update entregador set excluido = true where id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Entregador e)
    {
        try
        {
            pstmt.setString(1, e.getNome());
            pstmt.setObject(2, e.getNascimento(), java.sql.Types.DATE);
            pstmt.setString(3, e.getCpf());
            pstmt.setLong(4, e.getTelefone());
            pstmt.setDouble(5, e.getSalario());

            if (e.getId() != null && e.getId() != 0)
            {
                pstmt.setLong(6, e.getId());
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
                                        resultSet.getDouble("salario"));
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de Entregador do Banco de Dados: " + ex);
        }

        return entregador;
    }
}
