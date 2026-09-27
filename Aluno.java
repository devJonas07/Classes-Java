public class Aluno
{
    private byte   idade;
    private String nome;
    private Data   nascimento;

    public Aluno (byte idade, String nome, Data nascimento) throws Exception
    {
        this.setIdade      (idade);
        this.setNome       (nome);
        this.setNascimento (nascimento);
    }

    public void setIdade (byte idade) throws Exception
    {
        if (idade<=5 || idade>117)
            throw new Exception ("Idade invalida");

        this.idade = idade;
    }

    public byte getIdade ()
    {
        return this.idade;
    }

    public void setNome (String nome) throws Exception
    {
        if (nome==null || nome.equals(""))
            throw new Exception ("Nome ausente");

        this.nome = nome;
    }

    public String getNome ()
    {
        return this.nome;
    }

    public void setNascimento (Data nascimento) throws Exception
    {
        if (nascimento==null)
            throw new Exception ("Data ausente");

        // copia defensiva: nunca guarda a referencia recebida diretamente
        this.nascimento = new Data (nascimento);
        // this.nascimento = (Data)nascimento.clone(); // forma alternativa, usando clone
    }

    public Data getNascimento ()
    {
        // copia defensiva: nunca devolve a referencia interna diretamente
        return (Data)this.nascimento.clone();
    }
}