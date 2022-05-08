/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package br.edu.ifnmg.projeto_sorveteria;

/**
 * Entidade que representa um adicional de sorvete.
 *
 * @author GahFerreira
 * @version 1.0, 07/05/2022
 */
public class Sabor
{
    String nome;
    Categoria categoria;
    Double preco;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    
    public Sabor()
    {
    }

    public Sabor(String nome, Categoria categoria, Double preco)
    {
        this.nome = nome;
        this.categoria = categoria;
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

    public Categoria getCategoria()
    {
        return categoria;
    }

    public void setCategoria(Categoria categoria)
    {
        this.categoria = categoria;
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
        return "Sabor{" + "nome=" + nome + ", categoria=" + categoria + ", preco=" + preco + '}';
    }
    
//</editor-fold>
}