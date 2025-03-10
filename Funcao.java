package svi;

import java.util.Scanner;

/**
 * Classe responsável pelo gerenciamento da venda de ingressos e assentos no cinema.
 */
public class Funcao {
    private int[][] assentos = new int[10][10]; // Matriz para representar os assentos (0 = livre, 1 = ocupado)
    private int totalVendas = 0; // Contador de ingressos vendidos
    private double totalCaixa = 0; // Valor total arrecadado
    private Scanner input = new Scanner(System.in); // Scanner para entrada de dados do usuário

    /**
     * Realiza a venda de um ingresso, solicitando informações ao usuário.
     */
    public void venderIngresso() {
        input.nextLine(); // Limpa buffer do Scanner
        System.out.print("Digite seu nome (ou 'voltar' para sair): ");
        String nome = input.nextLine();
        if (nome.equalsIgnoreCase("voltar")) return;

        System.out.print("Digite sua idade: ");
        int idade = input.nextInt();
        System.out.print("Digite seu CPF: ");
        String cpf = input.next();

        System.out.println("Escolha o tipo de ingresso:");
        System.out.println("1 - Inteiro");
        System.out.println("2 - Meia-entrada");
        int tipoEscolhido = input.nextInt();
        String tipoIngresso = (tipoEscolhido == 1) ? "Inteiro" : "Meia";

        System.out.println("Escolha um filme:");
        System.out.println("1 - Filme A");
        System.out.println("2 - Filme B");
        System.out.println("3 - Filme C");
        System.out.println("4 - Filme D");
        int filmeEscolhido = input.nextInt();
        String filme = switch (filmeEscolhido) {
            case 1 -> "Filme A";
            case 2 -> "Filme B";
            case 3 -> "Filme C";
            case 4 -> "Filme D";
            default -> "Desconhecido";
        };

        System.out.print("Digite a linha desejada (A-J): ");
        char linha = Character.toUpperCase(input.next().charAt(0));
        System.out.print("Digite a coluna desejada (0-9): ");
        int coluna = input.nextInt();

        processarVenda(new Comprador(nome, idade, cpf, tipoIngresso, filme), linha, coluna);
    }

    /**
     * Processa a venda do ingresso e aloca o assento.
     *
     * @param comprador Objeto do tipo Comprador
     * @param linha     Letra da linha do assento (A-J)
     * @param coluna    Número da coluna do assento (0-9)
     */
    private void processarVenda(Comprador comprador, char linha, int coluna) {
        double precoBase = 20.00;
        double precoFinal = comprador.getTipoIngresso().equals("Meia") ? precoBase / 2 : precoBase;
        int lin = linha - 'A'; // Converte a letra da linha em índice numérico

        if (assentos[lin][coluna] == 0) {
            assentos[lin][coluna] = 1;
            totalCaixa += precoFinal;
            totalVendas++;
            realizarPagamento(precoFinal);

            System.out.println("\nVenda realizada com sucesso!");
            System.out.println("Comprador: " + comprador.getNome());
            System.out.println("Filme: " + comprador.getFilme());
            System.out.println("Tipo de ingresso: " + comprador.getTipoIngresso());
            System.out.printf("Valor pago: R$ %.2f\n", precoFinal);
        } else {
            System.out.println("Assento já ocupado!");
        }
    }

    /**
     * Realiza o pagamento do ingresso.
     *
     * @param valor Valor do ingresso
     */
    private void realizarPagamento(double valor) {
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1 - Cartão");
        System.out.println("2 - Dinheiro");
        int pagamento = input.nextInt();

        if (pagamento == 1) {
            System.out.println("Pagamento de R$" + valor + " realizado com Cartão!");
        } else if (pagamento == 2) {
            double valorPago;
            do {
                System.out.print("Digite o valor em dinheiro: R$ ");
                valorPago = input.nextDouble();
            } while (valorPago < valor);

            double troco = valorPago - valor;
            if (troco > 0) System.out.printf("Troco: R$ %.2f\n", troco);
            System.out.println("Pagamento realizado com sucesso em Dinheiro!");
        } else {
            System.out.println("Opção inválida, tente novamente!");
            realizarPagamento(valor);
        }
    }

    /**
     * Exibe o relatório de vendas.
     */
    public void relatorioVendas() {
        System.out.println("\nRelatório de Vendas:");
        System.out.println("Total de ingressos vendidos: " + totalVendas);
        System.out.printf("Total arrecadado: R$ %.2f\n", totalCaixa);
    }

    /**
     * Exibe o mapa dos assentos, indicando quais estão ocupados ou disponíveis.
     */
    public void consultarAssentos() {
        System.out.println("\nMapa de Assentos:");
        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[i].length; j++) {
                System.out.print((assentos[i][j] == 0 ? "[ ]" : "[X]") + " ");
            }
            System.out.println();
        }
    }
}
