import java.util.Scanner;

public class BichinhoVirtual {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Dê um nome ao seu bichinho: ");
        String nome = entrada.nextLine();
        Bicho bichinho = new Bicho (nome);

        int opcao = -1;

        while (opcao != 0 && bichinho.estaVivo()) {

            System.out.println("\n===== BICHINHO VIRTUAL =====");
            System.out.println("1 - Ver status");
            System.out.println("2 - Dar ração");
            System.out.println("3 - Dar fruta");
            System.out.println("4 - Dar doce");
            System.out.println("5 - Passar o tempo");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException erro) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    bichinho.mostrarStatus();
                    break;
                case 2:
                    bichinho.alimentar("ração", 30, 5);
                    break;
                case 3:
                    bichinho.alimentar("uma fruta", 20, 10);
                    break;
                case 4:
                    bichinho.alimentar("um doce", 10, 25);
                    break;
                case 5:
                    bichinho.passarTempo();
                    break;
                case 0:
                    System.out.println("Até a próxima!");
                    break;
                default:
                    System.out.println("Opção inválida, tente de novo.");
            }
        }

        if (!bichinho.estaVivo()) {
            System.out.println("\n" + bichinho.getNome() + " ficou com fome demais... Fim de jogo.");
        }

        entrada.close();
    }
}
