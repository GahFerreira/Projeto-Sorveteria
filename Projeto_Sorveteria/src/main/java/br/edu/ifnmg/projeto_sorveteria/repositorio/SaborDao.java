/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.Categoria;
import br.edu.ifnmg.projeto_sorveteria.entidade.Sabor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe Sabor no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.1, 17/05/2022
 */
public class SaborDao
        extends Dao<Sabor, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into sabor (nome, categoria, preco, excluido) values (?, ?, ?, false);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update sabor set nome = ?, categoria = ?, preco = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, nome, categoria, preco from sabor where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, nome, categoria, preco from sabor where excluido = false;";
    }
    
    @Override
    public String obterDeclaracaoDelete()
    {
        return "update sabor set excluido = true where id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Sabor e)
    {
        try
        {
            pstmt.setString(1, e.getNome());
            pstmt.setString(2, e.getCategoria().name()); // TODO Confirmar que é assim que coloca Enum em PreparedStatement
            pstmt.setDouble(3, e.getPreco());

            if (e.getId() != null && e.getId() != 0)
            {
                pstmt.setLong(4, e.getId());
            }
        }

        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de Sabor: " + ex);
        }
    }

    @Override
    public Sabor extrairObjeto(ResultSet resultSet)
    {
        Sabor sabor = null;

        try
        {
            sabor = new Sabor(resultSet.getLong("id"),
                              resultSet.getString("nome"),
                              Categoria.valueOf(resultSet.getString("categoria")), // TODO Confirmar que é assim que extrai Enum de ResultSet
                              resultSet.getDouble("preco"));
        }

        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de Sabor: " + ex);
        }

        return sabor;
    }
}
