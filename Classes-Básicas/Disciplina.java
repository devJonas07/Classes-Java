public class Disciplina
{
    private String nome;
    private int cargaHoraria;
    private double[] notas; // guarda até 4 notas (provas/trabalhos)
    private int qtdNotasLancadas;

    public Disciplina (String nome, int cargaHoraria) throws Exception
    {
        if (nome.equals("") || nome == null){
            throw new Exception("Nome inválido!");
        }
        if (cargaHoraria <= 0) {
            throw new Exception("Carga horária tem de ser maior que zero!");
        }

        this.notas = new double[4];
        this.qtdNotasLancadas = 0;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public void lancarNota (double nota) throws Exception
    {
        if (nota < 0 || nota > 10) {
            throw new Exception("Nota inválida");
        }
        if (this.qtdNotasLancadas == 4){
            throw new Exception("Todas as notas já foram lançadas");
        }
        this.notas[qtdNotasLancadas] = nota;
        this.qtdNotasLancadas += 1;
    }

    public double getMediaFinal ()
    {
        double media = 0;
        for (int i = 0; i < this.qtdNotasLancadas; i++){
            media += notas[i];
        }
        if (this.qtdNotasLancadas == 0) {
            return 0;
        }

        return media/this.qtdNotasLancadas;
    }

    public String getConceito ()
    {
        int notasSemCasaDecimal = (int)getMediaFinal();
        switch (notasSemCasaDecimal){
            case 10:
            case 9:
                return "A";
            case 8:
            case 7:
                return "B";
            case 6:
            case 5:
                return "C";
            case 4:
            case 3:
            case 2:
            case 1:
            case 0:
                return "D";
            default: 
                return "Conceito inválido";
        }
    }
}