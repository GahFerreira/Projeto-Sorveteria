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
public class Quantidade extends Entidade
{
    Sabor sabor;
    ProdutoComposto produtoComposto;
    Integer quantidadeBolas;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    
    public Quantidade() {}
    
    public Quantidade(Sabor sabor, Integer quantidadeBolas)
    {
        this.sabor = sabor;
        this.quantidadeBolas = quantidadeBolas;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public Sabor getSabor()
    {
        return sabor;
    }

    public void setSabor(Sabor sabor)
    {
        this.sabor = sabor;
    }

    public Integer getQuantidadeBolas()
    {
        return quantidadeBolas;
    }

    public void setQuantidadeBolas(Integer quantidadeBolas)
    {
        this.quantidadeBolas = quantidadeBolas;
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ToString">
    
    @Override
    public String toString()
    {
        return "Quantidade{" + "sabor=" + sabor + ", quantidadeBolas=" + quantidadeBolas + '}';
    }
    
//</editor-fold>
}
