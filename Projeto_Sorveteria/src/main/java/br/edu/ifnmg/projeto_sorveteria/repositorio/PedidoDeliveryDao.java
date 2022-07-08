/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.PedidoDelivery;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe PedidoDelivery no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.2, 08/07/2022
 */
public class PedidoDeliveryDao
        extends Dao<PedidoDelivery, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into pedido_delivery (data_, cliente, forma_pagamento, endereco, frete, excluido) values (?, ?, ?, ?, ?, false);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update pedido_delivery set data_ = ?, cliente = ?, forma_pagamento = ?, endereco = ?, frete = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, data_, cliente, forma_pagamento, endereco, frete from pedido_delivery where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, data_, cliente, forma_pagamento, endereco, frete from pedido_delivery where excluido = false;";
    }
    
    @Override
    public String obterDeclaracaoDelete()
    {
        return "update pedido_delivery set excluido = true where id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, PedidoDelivery e)
    {
        try
        {
            pstmt.setObject(1, e.getData(), java.sql.Types.TIMESTAMP);
            pstmt.setString(2, e.getCliente());
            pstmt.setString(3, e.getFormaPagamento());
            pstmt.setString(4, e.getEndereco());
            pstmt.setDouble(5, e.getFrete());

            if (e.getId() != null && e.getId() != 0)
            {
                pstmt.setLong(6, e.getId());
            }
        }

        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de PedidoDelivery: " + ex);
        }
    }

    @Override
    public PedidoDelivery extrairObjeto(ResultSet resultSet)
    {
        PedidoDelivery pedidoDelivery = null;

        try
        {
            pedidoDelivery = new PedidoDelivery(resultSet.getLong("id"),
                                                resultSet.getTimestamp("data_").toLocalDateTime(),
                                                resultSet.getString("cliente"),
                                                resultSet.getString("forma_pagamento"),
                                                resultSet.getString("endereco"),
                                                resultSet.getDouble("frete"));
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de PedidoDelivery do Banco de Dados: " + ex);
        }

        return pedidoDelivery;
    }
}
