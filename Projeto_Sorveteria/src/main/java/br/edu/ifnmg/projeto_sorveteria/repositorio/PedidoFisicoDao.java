/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.PedidoFisico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe PedidoFisico no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.2, 08/07/2022
 */
public class PedidoFisicoDao
        extends Dao<PedidoFisico, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into pedido_fisico (data_, cliente, forma_pagamento, gorjeta, excluido) values (?, ?, ?, ?, false);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update pedido_fisico set data_ = ?, cliente = ?, forma_pagamento = ?, gorjeta = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, data_, cliente, forma_pagamento, gorjeta from pedido_fisico where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, data_, cliente, forma_pagamento, gorjeta from pedido_fisico where excluido = false;";
    }
    
    @Override
    public String obterDeclaracaoDelete()
    {
        return "update pedido_fisico set excluido = true where id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, PedidoFisico e)
    {
        try
        {
            pstmt.setObject(1, e.getData(), java.sql.Types.TIMESTAMP);
            pstmt.setString(2, e.getCliente());
            pstmt.setString(3, e.getFormaPagamento());
            pstmt.setDouble(4, e.getGorjeta());

            if (e.getId() != null && e.getId() != 0)
            {
                pstmt.setLong(5, e.getId());
            }
        }

        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de PedidoFisico: " + ex);
        }
    }

    @Override
    public PedidoFisico extrairObjeto(ResultSet resultSet)
    {
        PedidoFisico pedidoFisico = null;

        try
        {
            pedidoFisico = new PedidoFisico(resultSet.getLong("id"),
                                            resultSet.getTimestamp("data_").toLocalDateTime(),
                                            resultSet.getString("cliente"),
                                            resultSet.getString("forma_pagamento"),
                                            resultSet.getDouble("gorjeta"));
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de PedidoFisico do Banco de Dados: " + ex);
        }

        return pedidoFisico;
    }
}
