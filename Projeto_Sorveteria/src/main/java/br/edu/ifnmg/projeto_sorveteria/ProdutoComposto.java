/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package br.edu.ifnmg.projeto_sorveteria;

import java.util.ArrayList;

/**
 * Entidade que representa um adicional de sorvete.
 *
 * @author GahFerreira
 * @version 1.0, 07/05/2022
 */
public abstract class ProdutoComposto extends Produto
{
    ArrayList<Quantidade> quantidadeBolasCadaSabor;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    
    public ProdutoComposto() {}

    public ProdutoComposto(ArrayList<Quantidade> quantidadeBolasCadaSabor)
    {
        this.quantidadeBolasCadaSabor = quantidadeBolasCadaSabor;
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
