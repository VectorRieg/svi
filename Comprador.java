package svi;

/**
 * Classe que representa um comprador de ingresso para um filme.
 */
public class Comprador {
    /** Nome do comprador */
    String nome;
    
    /** Idade do comprador */
    int idade;
    
    /** CPF do comprador */
    String cpf;
    
    /** Tipo de ingresso adquirido pelo comprador */
    String tipoIngresso;
    
    /** Filme para o qual o ingresso foi comprado */
    String filme;

    /**
     * Construtor da classe Comprador.
     * 
     * @param nome Nome do comprador
     * @param idade Idade do comprador
     * @param cpf CPF do comprador
     * @param tipoIngresso Tipo de ingresso adquirido
     * @param filme Filme para o qual o ingresso foi comprado
     */
    public Comprador(String nome, int idade, String cpf, String tipoIngresso, String filme) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.tipoIngresso = tipoIngresso;
        this.filme = filme;
    }
}
