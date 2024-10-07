package Desafio;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int TICKET_DIGITOS = 5;
    private static Random random = new Random();

    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Emitir Ticket");
            System.out.println("2. Pagar Ticket");
            System.out.println("3. Listar Tickets e Histórico de Transações");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = obterEntradaInteira(scanner);

            switch (opcao) {
                case 1:
                    emitirTicket(estacionamento);
                    break;

                case 2:
                    pagarTicket(scanner, estacionamento);
                    break;

                case 3:
                    listarTicketsEHistorico(estacionamento);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void emitirTicket(Estacionamento estacionamento) {
        int numeroTicket = gerarNumeroTicket();
        Ticket ticket = estacionamento.emitirTicket(numeroTicket);
        System.out.println("Ticket emitido: Número " + ticket.getNumero() + ", Valor: " + ticket.getValor());
    }

    private static int gerarNumeroTicket() {
        return 10000 + random.nextInt(90000); // Gera um número aleatório entre 10000 e 99999
    }

    private static void pagarTicket(Scanner scanner, Estacionamento estacionamento) {
        System.out.println("Tickets disponíveis para pagamento:");
        estacionamento.listarTicketsDisponiveis();

        // Verifica se há tickets disponíveis
        if (estacionamento.getTickets().stream().noneMatch(ticket -> !ticket.isPago())) {
            System.out.println("Nenhum ticket disponível para pagamento.");
            return;
        }

        System.out.print("Digite o número do ticket a pagar: ");
        int numeroParaPagamento = obterEntradaInteira(scanner);
        estacionamento.receberPagamento(numeroParaPagamento);
    }

    private static void listarTicketsEHistorico(Estacionamento estacionamento) {
        estacionamento.listarTickets(); // Lista os tickets
        System.out.println(); // Linha em branco para separação
        estacionamento.mostrarHistoricoTransacoes(); // Mostra o histórico de transações
    }

    private static int obterEntradaInteira(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número inteiro válido.");
            }
        }
    }
}