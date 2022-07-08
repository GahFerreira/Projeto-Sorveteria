/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package br.edu.ifnmg.projeto_sorveteria.entidade;

/**
 * Classe para associar um pedido a um produto para registro no banco de dados.
 *
 * @author GahFerreira
 * @version 1.0, 08/07/2022
 */
public class PedidoProduto 
        extends Entidade
{
    private Pedido pedido;
    private Produto produto;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public PedidoProduto()
    {
    }
    
    public PedidoProduto(Pedido pedido, Produto produto)
    {
        this.pedido = pedido;
        this.produto = produto;
    }
    
    public PedidoProduto(Long id, Pedido pedido, Produto produto)
    {
        super(id);
        this.pedido = pedido;
        this.produto = produto;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Pedido getPedido()
    {
        return pedido;
    }
    
    public void setPedido(Pedido pedido)
    {
        this.pedido = pedido;
    }
    
    public Produto getProduto()
    {
        return produto;
    }
    
    public void setProduto(Produto produto)
    {
        this.produto = produto;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString()
    {
        return "PedidoProduto{" + "pedido=" + pedido.getClass() + " " + pedido.getId() + ", produto=" + produto.getClass() + " " + produto.getId() + '}';
    }
//</editor-fold> 
}
