package Desafio;
public class Ticket {
    private int numero;
    private double valor;
    private boolean pago;

    public Ticket(int numero, double valor) {
        this.numero = numero;
        this.valor = valor;
        this.pago = false;
    }

    public int getNumero() {
        return numero;
    }

    public double getValor() {
        return valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void pagar() {
        this.pago = true;
    }
}