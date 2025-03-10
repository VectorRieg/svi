package svi;

/**
 * Representa um comprador de ingresso para um filme.
 */
public class Comprador {
    private String nome;
    private int idade;
    private String cpf;
    private String tipoIngresso;
    private String filme;

    /**
     * Construtor para criar um comprador.
     *
     * @param nome         Nome do comprador
     * @param idade        Idade do comprador
     * @param cpf          CPF do comprador
     * @param tipoIngresso Tipo de ingresso adquirido (Inteiro ou Meia-entrada)
     * @param filme        Nome do filme escolhido
     */
    public Comprador(String nome, int idade, String cpf, String tipoIngresso, String filme) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.tipoIngresso = tipoIngresso;
        this.filme = filme;
    }

    // Métodos getters e setters para acessar os atributos

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTipoIngresso() { return tipoIngresso; }
    public void setTipoIngresso(String tipoIngresso) { this.tipoIngresso = tipoIngresso; }

    public String getFilme() { return filme; }
    public void setFilme(String filme) { this.filme = filme; }
}
