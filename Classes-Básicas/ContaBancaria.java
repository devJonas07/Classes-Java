public class ContaBancaria
{
    private double saldo;
    private int[] historicoDepositos; // guarda até 5 depósitos
    private int qtdDepositos;

    public ContaBancaria (double saldoInicial) throws Exception
    {
        if (saldoInicial < 0){
            throw new Exception("Saldo inicial invalido");
        }
        this.historicoDepositos = new int[5];
        this.saldo = saldoInicial;
        this.qtdDepositos = 0;
    }

    public void depositar (int valor) throws Exception
    {
        if (valor < 0){
            throw new Exception("Valor inválido");
        }

        if (this.qtdDepositos == 5) {
            throw new Exception("Limite de depositos atingido");
        }

        this.saldo += valor;
        this.historicoDepositos[this.qtdDepositos] = valor;
        this.qtdDepositos += 1;
    }

    public double getMediaDepositos ()
    {
        double media = 0;

        if (this.qtdDepositos == 0) {
            return 0;
        }
        for (int i = 0; i < this.qtdDepositos; i++){
            media += this.historicoDepositos[i];
        }

        media = media / this.qtdDepositos;
        return media;
    }
    public double getSaldo ()
    {
        return this.saldo;
    }
}