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
 * Entidade que representa um garçom.
 *
 * @author GahFerreira
 * @version 1.1, 11/05/2022
 */
public class Garcom
        extends Funcionario
{
    ArrayList<PedidoFisico> pedidos;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Garcom()
    {
    }

    public Garcom(String nome, LocalDate nascimento, String cpf, Long telefone, ArrayList<PedidoFisico> pedidos)
    {
        super(nome, nascimento, cpf, telefone);
        this.pedidos = pedidos;
    }

    public Garcom(Long id, String nome, LocalDate nascimento, String cpf, Long telefone, ArrayList<PedidoFisico> pedidos)
    {
        super(id, nome, nascimento, cpf, telefone);
        this.pedidos = pedidos;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public ArrayList<PedidoFisico> getPedidos()
    {
        return pedidos;
    }

    public void setPedidos(ArrayList<PedidoFisico> pedidos)
    {
        this.pedidos = pedidos;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString()
    {
        return "Garcom{" + "pedidos=" + pedidos + '}';
    }
//</editor-fold>

    // TODO calcularSalario de Garcom
    @Override
    public Double calcularSalario()
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
