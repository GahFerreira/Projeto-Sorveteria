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
 * Classe abstrata que representa um pedido feito por um cliente.
 *
 * @author GahFerreira
 * @version 1.1, 11/05/2022
 */
public abstract class Pedido extends Entidade
{
    LocalDateTime data;
    String cliente;
    String formaPagamento;
    ArrayList<Produto> produtos;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    
    public Pedido() {}
    
    public Pedido(LocalDateTime data, String cliente, String formaPagamento, ArrayList<Produto> produtos)
    {
        this.data = data;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
        this.produtos = produtos;
    }

    public Pedido(Long id, LocalDateTime data, String cliente, String formaPagamento, ArrayList<Produto> produtos)
    {
        super(id);
        this.data = data;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
        this.produtos = produtos;
    }

//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">

    public LocalDateTime getData()
    {
        return data;
    }

    public void setData(LocalDateTime data)
    {
        this.data = data;
    }

    public String getCliente()
    {
        return cliente;
    }

    public void setCliente(String cliente)
    {
        this.cliente = cliente;
    }

    public String getFormaPagamento()
    {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento)
    {
        this.formaPagamento = formaPagamento;
    }

    public ArrayList<Produto> getProdutos()
    {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos)
    {
        this.produtos = produtos;
    }
    
    // TODO Verificar Preço Total como variável derivada
    public Double getPrecoTotal()
    {
        return calcularPrecoTotal();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    
    @Override
    public String toString()
    {
        return "Pedido{" + "data=" + data + ", cliente=" + cliente + ", formaPagamento=" + formaPagamento + ", produtos=" + produtos + '}';
    }
    
//</editor-fold>
    
    public abstract Double calcularPrecoTotal();
    
    public abstract String gerarNota();
}
