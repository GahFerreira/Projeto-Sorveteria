/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Entidade que representa um adicional de sorvete.
 *
 * @author GahFerreira
 * @version 1.0, 07/05/2022
 */
public class PedidoDelivery extends Pedido
{
    String endereco;
    Double frete;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    
    public PedidoDelivery() {}

    public PedidoDelivery(String endereco, Double frete, LocalDateTime data, String cliente, String formaPagamento, ArrayList<Produto> produtos)
    {
        super(data, cliente, formaPagamento, produtos);
        this.endereco = endereco;
        this.frete = frete;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public Double getFrete()
    {
        return frete;
    }

    public void setFrete(Double frete)
    {
        this.frete = frete;
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ToString">
    
    @Override
    public String toString()
    {
        return "PedidoDelivery{" + "endereco=" + endereco + ", frete=" + frete + '}';
    }
    
//</editor-fold>

    // TODO calcularPrecoTotal de PedidoDelivery
    @Override
    public Double calcularPrecoTotal()
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // TODO gerarNota de PedidoDelivery
    @Override
    public String gerarNota()
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
