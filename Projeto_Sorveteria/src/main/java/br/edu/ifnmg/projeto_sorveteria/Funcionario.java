/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package br.edu.ifnmg.projeto_sorveteria;

import java.time.LocalDate;

/**
 * Classe abstrata que representa um funcionário.
 *
 * @author GahFerreira
 * @version 1.0, 07/05/2022
 */
public abstract class Funcionario extends Entidade
{
    String nome;
    LocalDate nascimento;
    String cpf;
    Long telefone;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    
    public Funcionario() {}

    public Funcionario(String nome, LocalDate nascimento, String cpf, Long telefone)
    {
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public LocalDate getNascimento()
    {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento)
    {
        this.nascimento = nascimento;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public Long getTelefone()
    {
        return telefone;
    }

    public void setTelefone(Long telefone)
    {
        this.telefone = telefone;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    
    @Override
    public String toString()
    {
        return "Funcionario{" + "nome=" + nome + ", nascimento=" + nascimento + ", cpf=" + cpf + ", telefone=" + telefone + '}';
    }
    
//</editor-fold>
    
    public abstract Double calcularSalario();
}
