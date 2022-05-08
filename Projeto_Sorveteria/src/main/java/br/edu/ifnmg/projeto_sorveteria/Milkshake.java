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
public class Milkshake extends ProdutoComposto
{
    Tamanho tamanho;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    
    public Milkshake() {}

    public Milkshake(Tamanho tamanho)
    {
        this.tamanho = tamanho;
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    
    public Tamanho getTamanho()
    {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho)
    {
        this.tamanho = tamanho;
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    
    @Override
    public String toString()
    {
        return "Milkshake{" + "tamanho=" + tamanho + '}';
    }
    
//</editor-fold>

    @Override
    public Double calcularPreco()
    {
        // TODO Calcular Preco de Milkshake
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}