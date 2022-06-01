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

import java.util.List;
/**
 * Definição de métodos obrigatórios nas classes DAO.
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1, 18/04/2022
 */
public interface IDao<E, K>
{
    /**
     * Operação de salvamento de entidade no banco de dados.
     * 
     * Funciona tanto para criar uma nova entidade no bancos de dados, quanto 
     * para atualizar uma existente.
     *
     * @param e Entidade a ser salva.
     *
     * @return Chave primária da entidade salva.
     */
    public K salvar(E e);
    
    /**
     * Operação de recuperação de entidade do banco de dados.
     * 
     * @param id Id da entidade a ser recuperada.
     * @return A entidade recuperada.
     */
    public E localizarPorId(K id);
    
    /**
     * Operação de recuperação de todas as entidades de uma classe do banco de dados.
     * 
     * @return Uma lista com todas as entidades.
     */
    public List<E> localizarTodos();
    
    /**
     * Operação de deleção de entidade no banco de dados.
     * 
     * @param e Entidade a ser excluída.
     * @return `true` se deleção bem sucedida, `false` se não.
     */
    public Boolean excluir(E e);
}
