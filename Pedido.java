public class Pedido
{
    private int numero;
    private double valorTotal;
    private Data dataCompra;

    public Pedido (int numero, double valorTotal, Data dataCompra) throws Exception
    {
        if (numero <= 0){
            throw new Exception("Número inválido");
        }
        if (valorTotal <= 0) {
            throw new Exception("Valor total inválido");
        }
        if (dataCompra == null) {
            throw new Exception("Data da compra nula");
        }

        this.numero = numero;
        this.valorTotal = valorTotal;
        this.dataCompra = (Data)dataCompra.clone();
    }

    public Data getDataCompra ()
    {
        return (Data)this.dataCompra.clone();
    }

    public double getValorTotal ()
    {
        return this.valorTotal;
    }
}