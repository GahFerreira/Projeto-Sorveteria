/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.entidade;

import java.time.LocalDate;

/**
 * Entidade que representa um gerente.
 *
 * @author GahFerreira
 * @version 1.1, 11/05/2022
 */
public class Gerente
        extends Funcionario
{
    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Gerente()
    {
    }

    public Gerente(String nome, LocalDate nascimento, String cpf, Long telefone)
    {
        super(nome, nascimento, cpf, telefone);
    }

    public Gerente(Long id, String nome, LocalDate nascimento, String cpf, Long telefone)
    {
        super(id, nome, nascimento, cpf, telefone);
    }
//</editor-fold>

    // TODO calcularSalario de Gerente
    @Override
    public Double calcularSalario()
    {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
