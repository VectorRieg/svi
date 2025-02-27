
package svi;

public class Cinema extends Funcao {
    public static void main(String[] args) {
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
                case 1:
                    venderIngresso();
                    break;
                case 2:
                    relatorioVendas();
                    break;
                case 3:
                    consultarAssentos();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);
    }
}
