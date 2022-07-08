/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package br.edu.ifnmg.projeto_sorveteria.entidade;

/**
 * Classe para associar um entregador a um pedido delivery para registro no banco de dados.
 *
 * @author GahFerreira
 * @version 1.0, 08/07/2022
 */
public class EntregadorPedidoDelivery 
        extends Entidade
{
    private Entregador entregador;
    private PedidoDelivery pedidoDelivery;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public EntregadorPedidoDelivery()
    {
    }
    
    public EntregadorPedidoDelivery(Entregador entregador, PedidoDelivery pedidoDelivery)
    {
        this.entregador = entregador;
        this.pedidoDelivery = pedidoDelivery;
    }
    
    public EntregadorPedidoDelivery(Long id, Entregador entregador, PedidoDelivery pedidoDelivery)
    {
        super(id);
        this.entregador = entregador;
        this.pedidoDelivery = pedidoDelivery;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Entregador getEntregador()
    {
        return entregador;
    }
    
    public void setEntregador(Entregador entregador)
    {
        this.entregador = entregador;
    }
    
    public PedidoDelivery getPedidoDelivery()
    {
        return pedidoDelivery;
    }
    
    public void setPedidoDelivery(PedidoDelivery pedidoDelivery)
    {
        this.pedidoDelivery = pedidoDelivery;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString()
    {
        return "EntregadorPedidoDelivery{" + "entregador=" + entregador.getId() + ", pedidoDelivery=" + pedidoDelivery.getId() + '}';
    }
//</editor-fold>
}
