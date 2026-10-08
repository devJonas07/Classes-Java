public class MediasFinais{
    private double[] turma;
    private String nomeTurma;
    private int qtdAlunos;

    public MediasFinais(String nomeTurma) throws Exception
    {
        if (nomeTurma == null || nomeTurma.equals("")){
            throw new Exception("Nome da turma inválido!");
        }
        this.nomeTurma = nomeTurma;
        this.qtdAlunos = 0;
        this.turma = new double[40];
    }
    public void lancarMedia(double media) throws Exception
    {
        if (media < 0 || media > 10){
            throw new Exception("Média inválida!");
        }
        if (this.qtdAlunos == 40){
            throw new Exception("Quantidade máxima de notas atingida!");
        }
        this.turma[this.qtdAlunos] = media;
        this.qtdAlunos++;
    }
    public double getMediaGeral()
    {
        double mediaAritmetica = 0;
        for (int i = 0; i < this.qtdAlunos; i++){
            mediaAritmetica += this.turma[i];
        }
        mediaAritmetica = mediaAritmetica / this.qtdAlunos;
        return mediaAritmetica;
    }
    public int getQtdAprovados()
    {
        int qtdAprovados = 0;
        for (int i = 0; i < this.qtdAlunos; i++){
            if (this.turma[i] >= 6){
                qtdAprovados++;
            }
        }
        return qtdAprovados;
    }
    public int getQtdReprovados()
    {
        int qtdReprovados = 0;
        for (int i = 0; i < this.qtdAlunos; i++){
            if (this.turma[i] < 6){
                qtdReprovados++;
            }
        }
        return qtdReprovados;
    }
    @Override 
    public String toString()
    {
        return ("Quantidade de aprovados na classe: " + this.getQtdAprovados() + " - " + 
                "Quantidade de Reprovados na classe: " + this.getQtdReprovados() + " - " +
                "Media geral da turma: " + this.getMediaGeral());
    }
    @Override 
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        MediasFinais m = (MediasFinais)obj;

        for (int i = 0; i < this.qtdAlunos; i++) {
            if (m.turma[i] != this.turma[i]) return false;
        }
        if (m.qtdAlunos != this.qtdAlunos) return false;
        if (!m.nomeTurma.equals(this.nomeTurma)) return false;
        return true;
    }
    @Override 
    public int hashCode()
    {
        int retorno = 1;
        for (int i = 0; i < this.qtdAlunos; i++){
            retorno = retorno * 2 + ((Double)this.turma[i]).hashCode();
        }
        retorno = retorno * 2 + this.nomeTurma.hashCode();
        retorno = retorno * 2 + ((Integer)this.qtdAlunos).hashCode();

        if (retorno < 0) retorno = -retorno;
        return retorno;
    }
}