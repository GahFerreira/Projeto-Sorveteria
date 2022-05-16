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
 * Classe para realização de operações da classe PedidoDelivery no Banco de Dados.
 *
 * @author GahFerreira
 * @version 1.0, 16/05/2022
 */
public class PedidoDeliveryDao extends Dao<PedidoDelivery, Long>
{
    @Override
    public String obterSentencaInsert()
    {
        return "insert into pedidofisico (data, cliente, formaPagamento, endereco, frete) values (?, ?, ?, ?, ?);";
    }

    @Override
    public String obterSentencaUpdate()
    {
        return "update pedidofisico set data = ?, cliente = ?, formaPagamento = ?, endereco = ?, frete = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select data, cliente, formaPagamento, endereco, frete from pessoafisica where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select data, cliente, formaPagamento, endereco, frete from pessoafisica where excluido = false;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, PedidoDelivery e)
    {
        try
        {
            pstmt.setTimestamp(1, java.sql.Timestamp.valueOf(e.getData()));
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
                                                resultSet.getTimestamp("data").toLocalDateTime(),
                                                resultSet.getString("cliente"),
                                                resultSet.getString("formaPagamento"),
                                                null,
                                                resultSet.getString("endereco"),
                                                resultSet.getDouble("frete"));
        }
        
        catch(Exception ex)
        {
            System.out.println("Erro na extração de PedidoDelivery do Banco de Dados: " + ex);
        }
        
        return pedidoDelivery;
    }
}
