package Desafio;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Ticket> tickets;
    private List<String> historicoTransacoes; // Adicionando histórico de transações

    public Estacionamento() {
        this.tickets = new ArrayList<>();
        this.historicoTransacoes = new ArrayList<>(); // Inicializando a lista de transações
    }

    public Ticket emitirTicket(int numero) {
        double valor = 15.0; // Valor fixo do ticket
        Ticket ticket = new Ticket(numero, valor);
        tickets.add(ticket);
        return ticket;
    }

    public boolean receberPagamento(int numeroTicket) {
        for (Ticket ticket : tickets) {
            if (ticket.getNumero() == numeroTicket) {
                if (!ticket.isPago()) {
                    ticket.pagar();

                    // Adiciona a transação ao histórico
                    String transacao = "Pagamento recebido para o ticket: " + numeroTicket + ", Valor: " + ticket.getValor();
                    historicoTransacoes.add(transacao);
                    System.out.println(transacao);
                    return true;
                } else {
                    System.out.println("O ticket " + numeroTicket + " já foi pago.");
                    return false;
                }
            }
        }
        System.out.println("Ticket não encontrado.");
        return false;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void listarTickets() {
        if (tickets.isEmpty()) {
            System.out.println("Nenhum ticket emitido.");
        } else {
            System.out.println("Tickets emitidos:");
            for (Ticket ticket : tickets) {
                System.out.println("Número: " + ticket.getNumero() + ", Valor: " + ticket.getValor() + ", Pago: " + (ticket.isPago() ? "Sim" : "Não"));
            }
        }
    }

    public void listarTicketsDisponiveis() {
        boolean temTicketsDisponiveis = false;
        for (Ticket ticket : tickets) {
            if (!ticket.isPago()) {
                System.out.println("Número: " + ticket.getNumero() + ", Valor: " + ticket.getValor());
                temTicketsDisponiveis = true;
            }
        }
        if (!temTicketsDisponiveis) {
            System.out.println("Nenhum ticket disponível para pagamento.");
        }
    }

    public void mostrarHistoricoTransacoes() {
        if (historicoTransacoes.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
        } else {
            System.out.println("Histórico de Transações:");
            for (String transacao : historicoTransacoes) {
                System.out.println(transacao);
            }
        }
    }
}