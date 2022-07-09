/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.EntregadorPedidoDelivery;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe EntregadorPedidoDelivery no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.0, 08/07/2022
 */
public class EntregadorPedidoDeliveryDao
        extends Dao<EntregadorPedidoDelivery, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into entregador_pedido_delivery (entregador_id, pedido_delivery_id, excluido) values (?, ?, false);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update entregador_pedido_delivery set entregador_id = ?, pedido_delivery_id = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, entregador_id, pedido_delivery_id from entregador_pedido_delivery where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, entregador_id, pedido_delivery_id from entregador_pedido_delivery where excluido = false;";
    }

    @Override
    public String obterDeclaracaoDelete()
    {
        return "update entregador_pedido_delivery set excluido = true where id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, EntregadorPedidoDelivery e)
    {
        try
        {
            pstmt.setLong(1, e.getEntregador().getId());
            pstmt.setLong(2, e.getPedidoDelivery().getId());

            if (e.getId() != null && e.getId() != 0)
            {
                pstmt.setLong(3, e.getId());
            }
        }

        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de EntregadorPedidoDelivery: " + ex);
        }
    }

    @Override
    public EntregadorPedidoDelivery extrairObjeto(ResultSet resultSet)
    {
        EntregadorPedidoDelivery entregadorPedidoDelivery = null;

        try
        {
            entregadorPedidoDelivery = new EntregadorPedidoDelivery(resultSet.getLong("id"),
                                                                    new EntregadorDao().localizarPorId(resultSet.getLong("entregador_id")),
                                                                    new PedidoDeliveryDao().localizarPorId(resultSet.getLong("pedido_delivery_id")));
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de EntregadorPedidoDelivery do Banco de Dados: " + ex);
        }

        return entregadorPedidoDelivery;
    }
}
