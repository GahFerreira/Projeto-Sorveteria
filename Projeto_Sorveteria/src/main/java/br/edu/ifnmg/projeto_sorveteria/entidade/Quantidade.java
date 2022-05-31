/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.entidade;
/**
 * Entidade que representa uma associação entre um produto composto e um sabor.
 * Indica a quantidade de bolas daquele sabor colocada no produto composto.
 *
 * Um exemplo é uma Quantidade que guarda "Chocolate", "Sorvete #1" e "5".
 * Isso representa que o "Sorvete #1" possui "5" bolas de "Chocolate".
 *
 * @author GahFerreira
 * @version 1.2, 17/05/2022
 */
public class Quantidade
        extends Entidade
{
    Sabor sabor;
    ProdutoComposto produtoComposto;
    Integer quantidadeBolas;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Quantidade()
    {
    }

    public Quantidade(Sabor sabor, ProdutoComposto produtoComposto, Integer quantidadeBolas)
    {
        this.sabor = sabor;
        this.produtoComposto = produtoComposto;
        this.quantidadeBolas = quantidadeBolas;
    }

    public Quantidade(Long id, Sabor sabor, ProdutoComposto produtoComposto, Integer quantidadeBolas)
    {
        super(id);
        this.sabor = sabor;
        this.produtoComposto = produtoComposto;
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

    public ProdutoComposto getProdutoComposto()
    {
        return produtoComposto;
    }

    public void setProdutoComposto(ProdutoComposto produtoComposto)
    {
        this.produtoComposto = produtoComposto;
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
