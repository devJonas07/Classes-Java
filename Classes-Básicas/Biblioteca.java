public class Biblioteca {

    private String nomeBiblioteca;
    private Livro[] livros;

    private static int qtdBiblioteca;
    private int qtdLivros;

    public Biblioteca(String nomeBiblioteca) throws Exception {

        if (nomeBiblioteca == null || nomeBiblioteca.equals("")) {
            throw new Exception("Nome inválido!");
        }

        this.nomeBiblioteca = nomeBiblioteca;
        this.livros = new Livro[50];
        this.qtdLivros = 0;
        qtdBiblioteca++;
    }

    public static int getTotalBibliotecas() {
        return qtdBiblioteca;
    }

    public void adicionarLivro(Livro livro) throws Exception {

        if (livro == null) {
            throw new Exception("Livro inválido!");
        }

        if (this.qtdLivros >= 50) {
            throw new Exception("Capacidade máxima atingida!");
        }

        this.livros[this.qtdLivros] = livro;
        this.qtdLivros++;
    }
    public Livro getLivroMaisAntigo() throws Exception {

        if (this.qtdLivros == 0) {
            throw new Exception("Não há nenhum livro ainda!");
        }

        Livro livroMaisAntigo = this.livros[0];

        for (int i = 1; i < this.qtdLivros; i++) {

            if (this.livros[i].getanoPublicado() < livroMaisAntigo.getanoPublicado()) {
                livroMaisAntigo = this.livros[i];
            }
        }

        return livroMaisAntigo;
    }
    public double getValorTotalAcervo()
    {
        double preco = 0;
        for (int i = 0; i < this.qtdLivros; i++){
            preco += this.livros[i].getPreco();
        }
        return preco;
    }
}