public class Estoque
{
    private String nomeProduto;
    private double precoUnitario;
    private int[] vendasPorMes; // guarda vendas de até 12 meses
    private int qtdMesesRegistrados;

    private static int totalProdutosCriados = 0;

    public static int getTotalProdutosCriados ()
    {
        return totalProdutosCriados;
    }

    public Estoque (String nomeProduto, double precoUnitario) throws Exception
    {
        if (nomeProduto == null || nomeProduto == ""){
            throw new Exception("Produto nulo ou vazio!");
        }

        if (precoUnitario < 0){
            throw new Exception("Preço deve ser maior que zero!");
        }

        totalProdutosCriados++;
        this.nomeProduto = nomeProduto;
        this.precoUnitario = precoUnitario;
        this.vendasPorMes = new int[12];
        this.qtdMesesRegistrados = 0;
    }

    public void registrarVendaMes (int qtdVendida) throws Exception
    {
        if (qtdVendida < 0) {
            throw new Exception("Quantidade vendida não pode ser menor que zero!");
        }
        
        if (this.qtdMesesRegistrados == 12) {
            throw new Exception("Ano completo");
        }

        this.vendasPorMes[this.qtdMesesRegistrados] = qtdVendida;
        this.qtdMesesRegistrados += 1;
    }

    public int getTotalVendido ()
    {
        int soma = 0;
        for (int i = 0; i < this.vendasPorMes.length; i++){
            soma += this.vendasPorMes[i];
        }

        return soma;
    }

    public double getFaturamentoTotal ()
    {
        return getTotalVendido() * precoUnitario;
    }

    public String getClassificacao ()
    {
        if (getTotalVendido() >= 1000){
            return "Produto Top";
        }
        else if (getTotalVendido() >= 500 && getTotalVendido() < 1000) {
            return "Produto Bom";
        }
        else {
            return "Produto Regular";
        }
    }

    @Override
    public String toString ()
    {
        return (this.nomeProduto + " - ") + ("R$" + this.precoUnitario) + ("(" + getClassificacao() + ")");
    }
}