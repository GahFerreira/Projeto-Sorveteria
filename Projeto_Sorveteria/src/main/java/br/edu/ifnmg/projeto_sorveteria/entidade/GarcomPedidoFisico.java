/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package br.edu.ifnmg.projeto_sorveteria.entidade;

/**
 * Classe para associar um garçom a um pedido físico para registro no banco de dados.
 *
 * @author GahFerreira
 * @version 1.0, 08/07/2022
 */
public class GarcomPedidoFisico 
        extends Entidade
{
    private Garcom garcom;
    private PedidoFisico pedidoFisico;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public GarcomPedidoFisico()
    {
    }
    
    public GarcomPedidoFisico(Garcom garcom, PedidoFisico pedidoFisico)
    {
        this.garcom = garcom;
        this.pedidoFisico = pedidoFisico;
    }
    
    public GarcomPedidoFisico(Long id, Garcom garcom, PedidoFisico pedidoFisico)
    {
        super(id);
        this.garcom = garcom;
        this.pedidoFisico = pedidoFisico;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Garcom getGarcom()
    {
        return garcom;
    }
    
    public void setGarcom(Garcom garcom)
    {
        this.garcom = garcom;
    }
    
    public PedidoFisico getPedidoFisico()
    {
        return pedidoFisico;
    }
    
    public void setPedidoFisico(PedidoFisico pedidoFisico)
    {
        this.pedidoFisico = pedidoFisico;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString()
    {
        return "GarcomPedido{" + "garcom=" + garcom.getId() + ", pedidoFisico=" + pedidoFisico.getId() + '}';
    }
//</editor-fold>
}
