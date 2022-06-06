/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.entidade;

import br.edu.ifnmg.projeto_sorveteria.entidade.Quantidade;
import br.edu.ifnmg.projeto_sorveteria.entidade.Produto;
import java.util.ArrayList;

/**
 * Classe abstrata que representa um produto que é composto de vários itens.
 *
 * Um exemplo é o sorvete, composto por bolas de sorvete, recipiente e adicionais.
 *
 * @author GahFerreira
 * @version 1.1, 11/05/2022
 */
public abstract class ProdutoComposto
        extends Produto
{
    private ArrayList<Quantidade> quantidadeBolasCadaSabor;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public ProdutoComposto()
    {
        this(null);
    }

    public ProdutoComposto(Long id)
    {
        super(id);
        
        this.quantidadeBolasCadaSabor = new ArrayList<>();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public ArrayList<Quantidade> getQuantidadeBolasCadaSabor()
    {
        return quantidadeBolasCadaSabor;
    }

    public void setQuantidadeBolasCadaSabor(ArrayList<Quantidade> quantidadeBolasCadaSabor)
    {
        this.quantidadeBolasCadaSabor = quantidadeBolasCadaSabor;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString()
    {
        return "ProdutoComposto{" + "quantidadeBolasCadaSabor=" + quantidadeBolasCadaSabor + '}';
    }
//</editor-fold>
}
