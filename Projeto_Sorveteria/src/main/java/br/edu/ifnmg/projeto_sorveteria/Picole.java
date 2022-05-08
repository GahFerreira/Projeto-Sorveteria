/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package br.edu.ifnmg.projeto_sorveteria;

/**
 * Entidade que representa um picolé.
 *
 * @author GahFerreira
 * @version 1.0, 07/05/2022
 */
public class Picole extends Produto
{
    private Tipo tipo;
    private Sabor sabor;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    
    public Picole() {}

    public Picole(Tipo tipo, Sabor sabor)
    {
        this.tipo = tipo;
        this.sabor = sabor;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public Tipo getTipo()
    {
        return tipo;
    }

    public void setTipo(Tipo tipo)
    {
        this.tipo = tipo;
    }

    public Sabor getSabor()
    {
        return sabor;
    }

    public void setSabor(Sabor sabor)
    {
        this.sabor = sabor;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString()
    {
        return "Picole{" + "tipo=" + tipo + ", sabor=" + sabor + '}';
    }
//</editor-fold>

    @Override
    public Double calcularPreco()
    {
        // TODO Calcular Preco de Picole
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
