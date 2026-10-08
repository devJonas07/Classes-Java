public class Livro {
    private String titulo;
    private String autor;
    private short anoPublicado;
    private double preco;

    public Livro(String titulo, String autor, short anoPublicado, double preco) throws Exception
    {
        if (titulo == null || titulo.equals("")){
            throw new Exception("Título inválido!");
        }
        if (autor == null || autor.equals("")){
            throw new Exception("Autor inválido!");
        }
        if (anoPublicado < 1450 || anoPublicado > 2026){
            throw new Exception("Ano de publicação inválido!");
        }
        if (preco <= 0){
            throw new Exception("Preço inválido");
        }

        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicado = anoPublicado;
        this.preco = preco;
    }
    public void setTitulo(String titulo) throws Exception
    {
        if (titulo == null || titulo.equals(""))
        {
            throw new Exception("Título inválido");
        }
        this.titulo = titulo;
    }
    public void setAutor(String autor) throws Exception
    {
        if (autor == null || autor.equals("")){
            throw new Exception("Autor inválido!");
        }
        this.autor = autor;
    }
    public void setAnoPublicado(short anoPublicado) throws Exception
    {
        if (anoPublicado < 1450 || anoPublicado > 2026){
            throw new Exception("Ano inválido!");
        }
        this.anoPublicado = anoPublicado;
    }
    public void setPreco(double preco) throws Exception
    {
        if (preco <= 0){
            throw new Exception("Preço inválido!");
        }
        this.preco = preco;
    }
    public String getTitulo()
    {
        return this.titulo;
    }
    public String getAutor()
    {
        return this.autor;
    }
    public short getanoPublicado()
    {
        return this.anoPublicado;
    }
    public double getPreco()
    {
        return this.preco;
    }
    public String getFaixaDePreco()
    {
        if (this.preco <= 30.0) return "Economico";
        if (this.preco <= 80.0) return "Medio";
        return "Caro";
    }
    @Override 
    public String toString()
    {
        return (this.titulo + " - " + "Ano Publicado: " + this.anoPublicado + " - " + "Autor: " + this.autor + " - " + "Preço: " + this.preco);
    }
    @Override 
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Livro l = (Livro)obj;

        if (!l.titulo.equals(this.titulo)) return false;
        if (!l.autor.equals(this.autor)) return false;
        if (l.anoPublicado != this.anoPublicado) return false;
        if (l.preco != this.preco) return false;
        return true;
    }
    @Override 
    public int hashCode()
    {
        int retorno = 1;
        retorno = retorno * 2 + this.titulo.hashCode();
        retorno = retorno * 2 + this.autor.hashCode();
        retorno = retorno * 2 + ((Short)this.anoPublicado).hashCode();
        retorno = retorno * 2 + ((Double)this.preco).hashCode();

        if (retorno < 0) retorno = -retorno;
        return retorno;
    }
}