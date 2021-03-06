/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.entidade;

/**
 * Entidade que representa um adicional de sorvete.
 *
 * @author GahFerreira
 * @version 1.1, 11/05/2022
 */
public class Adicional
        extends Entidade
{
    private String nome;
    private Double preco;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Adicional()
    {
    }

    public Adicional(String nome, Double preco)
    {
        this.nome = nome;
        this.preco = preco;
    }

    public Adicional(Long id, String nome, Double preco)
    {
        super(id);
        this.nome = nome;
        this.preco = preco;
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

    public Double getPreco()
    {
        return preco;
    }

    public void setPreco(Double preco)
    {
        this.preco = preco;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString()
    {
        return "Adicional{" + "nome=" + nome + ", preco=" + preco + '}';
    }
//</editor-fold>
}
