/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package br.edu.ifnmg.projeto_sorveteria.entidade;

/**
 * Classe para associar um sorvete a um adicional para registro no banco de dados.
 *
 * @author GahFerreira
 * @version 1.0, 08/07/2022
 */
public class SorveteAdicional extends Entidade
{
    private Sorvete sorvete;
    private Adicional adicional;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public SorveteAdicional()
    {
    }
    
    public SorveteAdicional(Sorvete sorvete, Adicional adicional)
    {
        this.sorvete = sorvete;
        this.adicional = adicional;
    }
    
    public SorveteAdicional(Long id, Sorvete sorvete, Adicional adicional)
    {
        super(id);
        this.sorvete = sorvete;
        this.adicional = adicional;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Sorvete getSorvete()
    {
        return sorvete;
    }
    
    public void setSorvete(Sorvete sorvete)
    {
        this.sorvete = sorvete;
    }
    
    public Adicional getAdicional()
    {
        return adicional;
    }
    
    public void setAdicional(Adicional adicional)
    {
        this.adicional = adicional;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ToString">
    @Override
    public String toString()
    {
        return "SorveteAdicional{" + "sorvete=" + sorvete.getId() + ", adicional=" + adicional.getNome() + '}';
    }
//</editor-fold>
}
