/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.entidade;

import br.edu.ifnmg.projeto_sorveteria.entidade.PedidoDelivery;
import br.edu.ifnmg.projeto_sorveteria.entidade.Funcionario;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Entidade que representa um entregador.
 *
 * @author GahFerreira
 * @version 1.1, 11/05/2022
 */
public class Entregador
        extends Funcionario
{
    private ArrayList<PedidoDelivery> pedidos;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Entregador()
    {
        this(null, null, null, null, null);
    }

    public Entregador(String nome, LocalDate nascimento, String cpf, Long telefone)
    {
        this(null, nome, nascimento, cpf, telefone);
    }

    public Entregador(Long id, String nome, LocalDate nascimento, String cpf, Long telefone)
    {
        super(id, nome, nascimento, cpf, telefone);
        
        this.pedidos = new ArrayList<>();
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
