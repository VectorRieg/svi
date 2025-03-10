package svi;

import java.util.Scanner;

/**
 * Classe principal que gerencia o menu do sistema de vendas de ingressos.
 */
public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Funcao f = new Funcao();
        int opcao;

        do {
            System.out.println("\nMENU");
            System.out.println("1 - Vender ingresso");
            System.out.println("2 - Relatório de vendas");
            System.out.println("3 - Consultar assentos disponíveis");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1 -> f.venderIngresso();
                case 2 -> f.relatorioVendas();
                case 3 -> f.consultarAssentos();
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        input.close();
    }
}
