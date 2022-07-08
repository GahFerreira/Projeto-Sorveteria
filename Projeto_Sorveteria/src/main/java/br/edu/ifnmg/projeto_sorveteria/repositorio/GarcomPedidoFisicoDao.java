/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.GarcomPedidoFisico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe GarcomPedidoFisico no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.0, 08/07/2022
 */
public class GarcomPedidoFisicoDao
        extends Dao<GarcomPedidoFisico, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into garcom_pedido_fisico (garcom_id, pedido_fisico_id, excluido) values (?, ?, false);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update garcom_pedido_fisico set garcom_id = ?, pedido_fisico_id = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, garcom_id, pedido_fisico_id from garcom_pedido_fisico where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, garcom_id, pedido_fisico_id from garcom_pedido_fisico where excluido = false;";
    }

    @Override
    public String obterDeclaracaoDelete()
    {
        return "update garcom_pedido_fisico set excluido = true where id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, GarcomPedidoFisico e)
    {
        try
        {
            pstmt.setLong(1, e.getGarcom().getId());
            pstmt.setLong(2, e.getPedidoFisico().getId());

            if (e.getId() != null && e.getId() != 0)
            {
                pstmt.setLong(3, e.getId());
            }
        }

        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de GarçomPedidoFisico: " + ex);
        }
    }

    @Override
    public GarcomPedidoFisico extrairObjeto(ResultSet resultSet)
    {
        GarcomPedidoFisico garcomPedidoFisico = null;

        try
        {
            // TODO Obter sabor e produto composto de Quantidade

            garcomPedidoFisico = new GarcomPedidoFisico(null,
                                                        null);
        }

        catch (Exception ex)
        {
            System.out.println("Erro na extração de GarçomPedidoFisico do Banco de Dados: " + ex);
        }

        return garcomPedidoFisico;
    }
}
