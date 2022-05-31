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
 * Classe para realização de operações da classe Quantidade no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.1, 17/05/2022
 */
public class QuantidadeDao
        extends Dao<Quantidade, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into quantidade (saborId, produtoCompostoId, quantidadeBolas) values (?, ?, ?);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update quantidade set saborId = ?, produtoCompostoId = ?, quantidadeBolas = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, saborId, produtoCompostoId, quantidadeBolas from quantidade where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, saborId, produtoCompostoId, quantidadeBolas from quantidade where excluido = false;";
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
            System.out.println("Falha na Montagem da Declaração SQL de Quantidade: " + ex);
        }
    }

    @Override
    public Quantidade extrairObjeto(ResultSet resultSet)
    {
        Quantidade quantidade = null;

        try
        {
            // TODO Obter sabor e produto composto de Quantidade

            quantidade = new Quantidade(null,
                                        null,
                                        resultSet.getInt("quantidadeBolas"));
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de Quantidade do Banco de Dados: " + ex);
        }

        return quantidade;
    }
}
