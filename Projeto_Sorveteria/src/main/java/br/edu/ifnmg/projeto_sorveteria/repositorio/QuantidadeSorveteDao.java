/*
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.Quantidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe para realização de operações da classe Quantidade no Banco de Dados referente a Sorvete.
 *
 * @author GahFerreira
 * @version 1.0, 08/07/2022
 */
public class QuantidadeSorveteDao
        extends Dao<Quantidade, Long>
{    
    @Override
    public String obterSentencaInsert()
    {
        return "insert into quantidade_sorvete (sabor_id, sorvete_id, quantidade_bolas, excluido) values (?, ?, ?, false);";
    }
    
    @Override
    public String obterSentencaUpdate()
    {
        return "update quantidade set sabor_id = ?, sorvete_id = ?, quantidade_bolas = ? where id = ?;";
    }
    
    @Override
    public String obterSentencaLocalizarPorId()
    {
        return "select id, sabor_id, sorvete_id, quantidade_bolas from quantidade where id = ?;";
    }
    
    @Override
    public String obterSentencaLocalizarTodos()
    {
        return "select id, sabor_id, sorvete_id, quantidade_bolas from quantidade where excluido = false;";
    }
    
    @Override
    public String obterDeclaracaoDelete()
    {
        return "update quantidade set excluido = true where id = ?;";
    }
    
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Quantidade e)
    {
        try
        {
            pstmt.setLong(1, e.getSabor().getId());
            pstmt.setLong(2, e.getProdutoComposto().getId());
            pstmt.setInt(3, e.getQuantidadeBolas());
            
            if (e.getId() != null && e.getId() != 0)
            {
                pstmt.setLong(4, e.getId());
            }
        }
        
        catch (Exception ex)
        {
            System.out.println("Falha na Montagem da Declaração SQL de QuantidadeSorvete: " + ex);
        }
    }
    
    @Override
    public Quantidade extrairObjeto(ResultSet resultSet)
    {
        Quantidade quantidade = null;
        
        try
        {
            quantidade = new Quantidade(resultSet.getLong("id"),
                                        new SaborDao().localizarPorId(resultSet.getLong("sabor_id")),
                                        new SorveteDao().localizarPorId(resultSet.getLong("sorvete_id")),
                                        resultSet.getInt("quantidadeBolas"));
        }
        
        catch (Exception ex)
        {
            System.out.println("Erro na extração de QuantidadeSorvete do Banco de Dados: " + ex);
        }
        
        return quantidade;
    }
}
