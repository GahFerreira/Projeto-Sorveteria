/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.entidade;

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
    private ArrayList<PedidoFisico> pedidos;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Garcom()
    {
        this(null, null, null, null, null, null);
    }

    public Garcom(String nome, LocalDate nascimento, String cpf, Long telefone, Double salario)
    {
        this(null, nome, nascimento, cpf, telefone, salario);
    }

    public Garcom(Long id, String nome, LocalDate nascimento, String cpf, Long telefone, Double salario)
    {
        super(id, nome, nascimento, cpf, telefone, salario);
        
        this.pedidos = new ArrayList<>();
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
