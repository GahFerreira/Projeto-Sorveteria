/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package br.edu.ifnmg.projeto_sorveteria;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Entidade que representa um entregador.
 *
 * @author GahFerreira
 * @version 1.0, 07/05/2022
 */
public class Entregador extends Funcionario
{
    ArrayList<PedidoDelivery> pedidos;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    
    public Entregador() {}
    
    public Entregador(ArrayList<PedidoDelivery> pedidos, String nome, LocalDate nascimento, String cpf, Long telefone)
    {
        super(nome, nascimento, cpf, telefone);
        this.pedidos = pedidos;
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public ArrayList<PedidoDelivery> getPedidos()
    {
        return pedidos;
    }

    public void setPedidos(ArrayList<PedidoDelivery> pedidos)
    {
        this.pedidos = pedidos;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    
    @Override
    public String toString()
    {
        return "Entregador{" + "pedidos=" + pedidos + '}';
    }
    
//</editor-fold>

    // TODO calcularSalario de Entregador
    @Override
    public Double calcularSalario()
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }    
}
