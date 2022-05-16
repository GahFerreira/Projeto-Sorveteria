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
 * Classe para realização de operações da classe PedidoFisico no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.0, 16/05/2022
 */
public class PedidoFisicoDao extends Dao<PedidoFisico, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into pedidofisico (data, cliente, formaPagamento, gorjeta) values (?, ?, ?, ?);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update pedidofisico set data = ?, cliente = ?, formaPagamento = ?, gorjeta = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select data, cliente, formaPagamento, gorjeta from pessoafisica where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select data, cliente, formaPagamento, gorjeta from pessoafisica where excluido = false;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, PedidoFisico e)
    {
        try
        {
            pstmt.setTimestamp(1, java.sql.Timestamp.valueOf(e.getData()));
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
                                            resultSet.getTimestamp("data").toLocalDateTime(),
                                            resultSet.getString("cliente"),
                                            resultSet.getString("formaPagamento"),
                                            null,
                                            resultSet.getDouble("gorjeta"));
        }
        
        catch(Exception ex)
        {
            System.out.println("Erro na extração de PedidoFisico do Banco de Dados: " + ex);
        }
        
        return pedidoFisico;
    }
}
