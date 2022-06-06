/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.entidade;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Entidade que representa um pedido físico feito por um cliente.
 *
 * @author GahFerreira
 * @version 1.1, 11/05/2022
 */
public class PedidoFisico
        extends Pedido
{
    private Double gorjeta;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public PedidoFisico()
    {
    }

    public PedidoFisico(LocalDateTime data, String cliente, String formaPagamento, ArrayList<Produto> produtos, Double gorjeta)
    {
        super(data, cliente, formaPagamento, produtos);
        this.gorjeta = gorjeta;
    }

    public PedidoFisico(Long id, LocalDateTime data, String cliente, String formaPagamento, ArrayList<Produto> produtos, Double gorjeta)
    {
        super(id, data, cliente, formaPagamento, produtos);
        this.gorjeta = gorjeta;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Double getGorjeta()
    {
        return gorjeta;
    }

    public void setGorjeta(Double gorjeta)
    {
        this.gorjeta = gorjeta;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString()
    {
        return "PedidoFisico{" + "gorjeta=" + gorjeta + '}';
    }
//</editor-fold>

    // TODO calcularPrecoTotal de PedidoFisico
    @Override
    public Double calcularPrecoTotal()
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // TODO gerarNota de PedidoFisico
    @Override
    public String gerarNota()
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
