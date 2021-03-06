/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.entidade;

import java.util.ArrayList;

/**
 * Entidade que representa um sorvete.
 *
 * @author GahFerreira
 * @version 1.1, 11/05/2022
 */
public class Sorvete
        extends ProdutoComposto
{
    private Recipiente recipiente;
    private ArrayList<Adicional> adicionais;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Sorvete()
    {
        this(null, null);
    }

    public Sorvete(Recipiente recipiente)
    {
        this(null, recipiente);
    }

    public Sorvete(Long id, Recipiente recipiente)
    {
        super(id);
        this.recipiente = recipiente;
        
        this.adicionais = new ArrayList<>();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Recipiente getRecipiente()
    {
        return recipiente;
    }

    public void setRecipiente(Recipiente recipiente)
    {
        this.recipiente = recipiente;
    }

    public ArrayList<Adicional> getAdicionais()
    {
        return adicionais;
    }

    public void setAdicionais(ArrayList<Adicional> adicionais)
    {
        this.adicionais = adicionais;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString()
    {
        return "Sorvete{" + "recipiente=" + recipiente + ", adicionais=" + adicionais + '}';
    }
//</editor-fold>

    @Override
    public Double calcularPreco()
    {
        // TODO Calcular Preco de Sorvete 
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
