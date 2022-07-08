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
 * Essa classe DAO específica se refere a Pedido Delivery e Milkshake.
 *
 * @author GahFerreira
 * @version 1.0, 08/07/2022
 */
public class PedidoDeliveryMilkshakeDao 
        extends Dao<PedidoProduto, Long>
{   
    @Override
    public String obterSentencaInsert()
    {
        return "insert into pedido_delivery_milkshake (pedido_delivery_id, milkshake_id, excluido) values (?, ?, false);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update pedido_delivery_milkshake set pedido_delivery_id = ?, milkshake_id = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, pedido_delivery_id, milkshake_id from pedido_delivery_milkshake where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, pedido_delivery_id, milkshake_id from pedido_delivery_milkshake where excluido = false;";
    }
    
    @Override
    public String obterDeclaracaoDelete()
    {
        return "update pedido_delivery_milkshake set excluido = true where id = ?;";
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
            System.out.println("Falha na Montagem da Declaração SQL de PedidoDeliveryMilkshake: " + ex);
        }
    }

    @Override
    public PedidoProduto extrairObjeto(ResultSet resultSet)
    {
        PedidoProduto pedidoProduto = null;

        try
        {
            // TODO Obter pedido & produto

            pedidoProduto = new PedidoProduto(null,
                                              null);
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de PedidoDeliveryMilkshake do Banco de Dados: " + ex);
        }

        return pedidoProduto;
    }
}