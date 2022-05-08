/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package br.edu.ifnmg.projeto_sorveteria;

/**
 * Classe abstrata que representa um produto da sorveteria.
 *
 * @author GahFerreira
 * @version 1.0, 07/05/2022
 */
public abstract class Produto extends Entidade
{
    public abstract Double calcularPreco();
}
