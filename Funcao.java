
package svi;

import java.util.Scanner;

public class Funcao {
    static int[][] assentos = new int[10][10];
    static int totalVendas = 0;
    static double totalCaixa = 0;
    static Scanner input = new Scanner(System.in);

    
    public static void venderIngresso() {
        input.nextLine();
        System.out.print("Digite seu nome (ou digite 'voltar' para retornar): ");
        String nome = input.nextLine();
        if (nome.equalsIgnoreCase("voltar")) return;

        System.out.print("Digite sua idade: ");
        int idade = input.nextInt();
        System.out.print("Digite seu CPF: ");
        String cpf = input.next();
        
        System.out.println("Escolha o tipo de ingresso:");
        System.out.println("1 - Inteiro");
        System.out.println("2 - Meia-entrada");
        System.out.println("3 - Voltar");
        int tipoEscolhido = input.nextInt();
        if (tipoEscolhido == 3) return;
        String tipoIngresso = (tipoEscolhido == 1) ? "Inteiro" : "Meia";
        
        System.out.println("Escolha um filme:");
        System.out.println("1 - Filme A");
        System.out.println("2 - Filme B");
        System.out.println("3 - Filme C");
        System.out.println("4 - Filme D");
        System.out.println("5 - Voltar");
        int filmeEscolhido = input.nextInt();
        if (filmeEscolhido == 5) return;
        String filme = switch (filmeEscolhido) {
            case 1 -> "Filme A";
            case 2 -> "Filme B";
            case 3 -> "Filme C";
            case 4 -> "Filme D";
            default -> "Desconhecido";
        };

        System.out.print("Digite a linha desejada (A-J) ou 'Z' para voltar: ");
        char linha = Character.toUpperCase(input.next().charAt(0));
        if (linha == 'Z') return;
        System.out.print("Digite a coluna desejada (0-9) ou -1 para voltar: ");
        int coluna = input.nextInt();
        if (coluna == -1 || linha < 'A' || linha > 'J' || coluna < 0 || coluna >= 10) {
            System.out.println("Posição inválida! Tente novamente.");
            return;
        }

        processarVenda(new Comprador(nome, idade, cpf, tipoIngresso, filme), linha, coluna);
    }

    public static void realizarPagamento(double valor) {
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
                if (valorPago < valor) {
                    System.out.println("Valor insuficiente! Insira um valor igual ou superior a R$ " + valor);
                }
            } while (valorPago < valor);
            
            double troco = valorPago - valor;
            if (troco > 0) {
                System.out.printf("Troco: R$ %.2f\n", troco);
            }
            System.out.println("Pagamento realizado com sucesso em Dinheiro!");
        } else {
            System.out.println("Opção inválida, tente novamente!");
            realizarPagamento(valor);
        }
    }

    public static void processarVenda(Comprador comprador, char linha, int coluna) {
        double precoBase = 20.00;
        double precoFinal = comprador.tipoIngresso.equals("Meia") ? precoBase / 2 : precoBase;
        int lin = linha - 'A';

        if (assentos[lin][coluna] == 0) {
            assentos[lin][coluna] = 1;
            totalCaixa += precoFinal;
            totalVendas++;
            realizarPagamento(precoFinal);
            
            System.out.println("\nVenda realizada com sucesso!");
            System.out.println("Comprador: " + comprador.nome);
            System.out.println("CPF: " + comprador.cpf);
            System.out.println("Filme: " + comprador.filme);
            System.out.println("Tipo de ingresso: " + comprador.tipoIngresso);
            System.out.printf("Valor pago: R$ %.2f\n", precoFinal);
        } else {
            System.out.println("Assento já ocupado!");
        }
    }

    public static void relatorioVendas() {
        System.out.println("\nRelatório de Vendas:");
        System.out.println("Total de ingressos vendidos: " + totalVendas);
        System.out.printf("Total arrecadado: R$ %.2f\n", totalCaixa);
    }

    public static void consultarAssentos() {
        System.out.println("\nMapa de Assentos:");
        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[i].length; j++) {
                System.out.print((assentos[i][j] == 0 ? "[ ]" : "[X]") + " ");
            }
            System.out.println();
        }
    }
}
