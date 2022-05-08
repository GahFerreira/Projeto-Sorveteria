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
public class Tamanho
{
    Integer mililitros;
    Double preco;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    
    public Tamanho() {}

    public Tamanho(Integer mililitros, Double preco)
    {
        this.mililitros = mililitros;
        this.preco = preco;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public Integer getMililitros()
    {
        return mililitros;
    }

    public void setMililitros(Integer mililitros)
    {
        this.mililitros = mililitros;
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
        return "Tamanho{" + "mililitros=" + mililitros + ", preco=" + preco + '}';
    }
    
//</editor-fold>
}
