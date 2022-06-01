/*
 * Material didático destinado ao curso de
 * Programação Orientada a Objetos
 * do Bacharelado em Ciência da Computação do IFNMG
 * - Câmpus Montes Claros.
 *
 * O uso deste material é livre e regido pela licença
 * Creative Commons como Atribuição-NãoComercial
 * -CompartilhaIgual 4.0 Internacional:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package br.edu.ifnmg.projeto_sorveteria.repositorio;

import br.edu.ifnmg.projeto_sorveteria.entidade.Entidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementação de operações gerais e definição de operações específicas para
 * <i>Data Access Object</i>.
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.2, 27/04/2022
 */
public abstract class Dao<E, K>
        implements IDao<E, K>
{
    @Override
    public K salvar(E e)
    {
        // Chave primária de resposta
        Long id = 0L;

        if (((Entidade) e).getId() == null ||
            ((Entidade) e).getId() == 0)
        {
            // Inserir novo registro
            // try-with-resources
            try ( PreparedStatement preparedStatement
                                    = ConexaoBd.getConexao().prepareStatement(
                            obterSentencaInsert(),
                            Statement.RETURN_GENERATED_KEYS))
            {
                // Monta a declaração SQL com os dados (->?)
                montarDeclaracao(preparedStatement, e);

                // Exibe a sentença completa
                System.out.println("SQL: " + preparedStatement);

                // Executa a inserção no banco de dados
                preparedStatement.executeUpdate();

                // Recupera a chave primária gerada
                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                // Movimenta para o primeiro dado recuperado
                if (resultSet.next())
                {
                    // Recupera a chave primária retornada
                    id = resultSet.getLong(1);
                }
            }

            catch (Exception ex)
            {
                System.out.println(">> " + ex);
            }
        }

        else
        {
            // Atualizar registro existente
            try ( PreparedStatement preparedStatement
                                    = ConexaoBd.getConexao().prepareStatement(
                            obterSentencaUpdate()))
            {
                // Monta a declaração SQL com os dados (->?)
                montarDeclaracao(preparedStatement, e);

                // Exibe a sentença completa
                System.out.println(">> " + preparedStatement);

                // Executa a atualização no banco de dados
                preparedStatement.executeUpdate();

                // Mantém a chave primária
                id = ((Entidade) e).getId();
            }

            catch (Exception ex)
            {
                System.out.println("Exception: " + ex);
            }
        }

        return (K) id;
    }

    /**
     * Recupera um objeto do banco de dados.
     *
     * @param id Chave primária
     *
     * @return Objeto buscado
     */
    public E localizarPorId(K id)
    {
        try ( PreparedStatement preparedStatement
                                = ConexaoBd.getConexao().prepareStatement(
                        obterSentencaLocalizarPorId()))
        {
            // Substitui respectiva id na sentença SQL
            preparedStatement.setLong(1, (Long) id);

            // Recupera os dados da consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            // Movimenta para o primeiro dado recuperado
            if (resultSet.next())
            {
                // Extrai o objeto representado pelo registro recuperado
                return extrairObjeto(resultSet);
            }
        }

        catch (Exception ex)
        {
            System.out.println(">> " + ex);
        }

        // Caso não haja registro com a id fornecida
        return null;
    }

    @Override
    public List<E> localizarTodos()
    {
        ArrayList<E> resposta = new ArrayList<>();

        try ( PreparedStatement preparedStatement
                                = ConexaoBd.getConexao().prepareStatement(
                        obterSentencaLocalizarTodos()))
        {
            // Recupera os dados da consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterar sobre todos os registros
            while (resultSet.next())
            {
                // Extrai e adionar "próximo" objeto
                resposta.add(extrairObjeto(resultSet));
            }
        }

        catch (Exception ex)
        {
            System.out.println(">> " + ex);
        }

        // Retorna todos os registros extraídos
        return resposta;
    }

    /**
     * Sentença SQL específica para cada tipo de objeto a ser persistido no
     * banco de dados.
     *
     * @return Sentença SQL de inserção.
     */
    public abstract String obterSentencaInsert();

    /**
     * Sentença SQL específica para cada tipo de objeto a ser atualizado no
     * banco de dados.
     *
     * @return Sentença SQL de atualização.
     */
    public abstract String obterSentencaUpdate();
    
     /**
     * Recupera a sentença SQL específica para a exclusão da entidade no banco
     * de dados.
     *
     * @return Sentença SQl para exclusão.
     */
    public abstract String obterDeclaracaoDelete();

    /**
     * Sentença SQL específica para cada tipo de objeto a ser localizado no
     * banco de dados.
     *
     * @return Sentença SQL de consulta de um registro.
     */
    public abstract String obterSentencaLocalizarPorId();

    public abstract String obterSentencaLocalizarTodos();

    /**
     * Monta a declaração SQL com os valores contidos no objeto recebido.
     *
     * @param pstmt Consulta a ser preparada.
     * @param e Objeto com valores a serem embutidos na consulta.
     */
    public abstract void montarDeclaracao(PreparedStatement pstmt, E e);

    public abstract E extrairObjeto(ResultSet resultSet);
    
     /**
     * Insere o valor da chave primária na senteça SQL específica para seu uso.
     *
     * @param pstmt Declaração previamente preparada.
     * @param id Chave primária a ser inserida na sentença SQL.
     */
    public void ajustarIdDeclaracao(PreparedStatement pstmt, K id) {
        try {
            // Caso id seja um Long, emprega setLong()
            if(id instanceof Long) {
                // Cast é requerido porque K não é um tipo previamente definido
                pstmt.setLong(1, (Long) id);
            } else {
                // Caso id seja um Integer, emprega setInt()
                pstmt.setInt(1, (Integer) id);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Exclui o registro do objeto no banco de dados.
     *
     * @param o Objeto a ser excluído.
     * <i>OBS.: o único valor útil é a identidade do objeto mapeado.</i>
     * @return Condição de sucesso ou falha na exclusão.
     */
    @Override
    public Boolean excluir(E e) {
        // Recupera a identidade (chave primária) do objeto a ser excluído
        Long id = ((Entidade) e).getId();

        // Se há uma identidade válida...
        if (id != null && id != 0) {
            // ... tenta preparar uma sentença SQL para a conexão já estabelecida
            try (PreparedStatement pstmt
                    = ConexaoBd.getConexao().prepareStatement(
                            // Sentença SQL para exclusão de registros
                            obterDeclaracaoDelete())) {

                // Prepara a declaração com os dados do objeto passado
                ajustarIdDeclaracao(pstmt, (K) id);

                // Executa o comando SQL
                pstmt.executeUpdate();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            return false;
        }

        return true;
    }
}
