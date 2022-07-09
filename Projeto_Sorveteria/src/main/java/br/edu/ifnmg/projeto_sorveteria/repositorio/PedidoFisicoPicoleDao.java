/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.PedidoProduto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe PedidoProduto no Banco de Dados.
 * Essa classe DAO específica se refere a Pedido Físico e Picolé.
 *
 * @author GahFerreira
 * @version 1.0, 08/07/2022
 */
public class PedidoFisicoPicoleDao
        extends Dao<PedidoProduto, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into pedido_fisico_picole (pedido_fisico_id, picole_id, excluido) values (?, ?, false);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update pedido_fisico_picole set pedido_fisico_id = ?, picole_id = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, pedido_fisico_id, picole_id from pedido_fisico_picole where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, pedido_fisico_id, picole_id from pedido_fisico_picole where excluido = false;";
    }

    @Override
    public String obterDeclaracaoDelete()
    {
        return "update pedido_fisico_picole set excluido = true where id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, PedidoProduto e)
    {
        try
        {
            pstmt.setLong(1, e.getPedido().getId());
            pstmt.setLong(2, e.getProduto().getId());

            if (e.getId() != null && e.getId() != 0)
            {
                pstmt.setLong(3, e.getId());
            }
        }

        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de PedidoFisicoPicole: " + ex);
        }
    }

    @Override
    public PedidoProduto extrairObjeto(ResultSet resultSet)
    {
        PedidoProduto pedidoProduto = null;

        try
        {
            // TODO Obter pedido & produto

            pedidoProduto = new PedidoProduto(resultSet.getLong("id"),
                                              new PedidoFisicoDao().localizarPorId(resultSet.getLong("pedido_fisico_id")),
                                              new PicoleDao().localizarPorId(resultSet.getLong("picole_id")));
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de PedidoFisicoPicole do Banco de Dados: " + ex);
        }

        return pedidoProduto;
    }
}
