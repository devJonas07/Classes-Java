public class Funcionario
{
    private String nome;
    private String cargo;
    private double salarioBase;

    public Funcionario (String nome, String cargo, double salarioBase) throws Exception
    {
        if (nome == null || nome.equals("")) {
            throw new Exception("Nome inválido!");
        }

        if (cargo == null || cargo.equals("")){
            throw new Exception("Cargo inválido!");
        }

        if (salarioBase <= 0){
            throw new Exception("Salário inválido");
        }

        this.nome = nome;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
    }

    public void setCargo (String novoCargo) throws Exception
    {
        if (novoCargo == null || novoCargo.equals("")){
            throw new Exception("Cargo inválido");
        }

        this.cargo = novoCargo;
    }

    public boolean isMesmoCargo (Funcionario outro)
    {
        return this.cargo.equals(outro.cargo);
    }

    public double getSalarioComBonus (int anosDeCasa)
    {
        double soma = 0;

        for (int i = 0; i < anosDeCasa; i++){
            soma += salarioBase * 0.05;;
        }
        if (anosDeCasa <= 0){
            return 0;
        }

        return this.salarioBase + soma;
    }

    @Override
    public String toString ()
    {
        return (this.nome + " (" + this.cargo + ")" + " - " + "R$" + this.salarioBase);
    }
}