package svi;

import java.util.Scanner;

/**
 * Classe Cinema que representa o sistema de gestão de um cinema.
 * Esta classe exibe um menu para o usuário com opções para vender ingressos,
 * gerar um relatório de vendas, consultar assentos disponíveis e sair do sistema.
 */
public class Cinema extends Funcao {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Scanner para entrada de dados
        int opcao; // Variável para armazenar a opção escolhida pelo usuário
        
        do {
            // Exibe o menu de opções
            System.out.println("\nMENU");
            System.out.println("1 - Vender ingresso");
            System.out.println("2 - Relatório de vendas");
            System.out.println("3 - Consultar assentos disponíveis");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = input.nextInt(); // Lê a opção escolhida pelo usuário
            
            // Executa a ação correspondente à opção escolhida
            switch (opcao) {
                case 1:
                    venderIngresso(); // Chama o método para vender ingresso
                    break;
                case 2:
                    relatorioVendas(); // Chama o método para gerar relatório de vendas
                    break;
                case 3:
                    consultarAssentos(); // Chama o método para consultar assentos disponíveis
                    break;
                case 4:
                    System.out.println("Saindo..."); // Mensagem de saída do sistema
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente."); // Mensagem de erro para opção inválida
            }
        } while (opcao != 4); // Continua exibindo o menu até que o usuário escolha sair
        
        input.close(); // Fecha o scanner para evitar vazamento de recursos
    }
}
