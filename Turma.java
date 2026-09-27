public class Turma
{
    private String nomeTurma;
    private Aluno[] alunos; // guarda até 30 alunos
    private int qtdAlunos;

    public Turma (String nomeTurma) throws Exception
    {
        if (nomeTurma == null || nomeTurma.equals("")) {
            throw new Exception("Nome da turma inválido");
        }

        this.alunos = new Aluno[30];
        this.qtdAlunos = 0;
        this.nomeTurma = nomeTurma;
    }

    public void matricularAluno (Aluno aluno) throws Exception
    {
        if (aluno == null) {
            throw new Exception("Aluno inválido");
        }
        if (this.qtdAlunos == 30) {
            throw new Exception("Turma lotada");
        }
        this.alunos[qtdAlunos] = aluno;
        this.qtdAlunos += 1;
    }

    public double getMediaIdades ()
    {
        double media = 0;
        if (this.qtdAlunos == 0) {
            return 0;
        }
        for (int i = 0; i < this.qtdAlunos; i++){
            media += this.alunos[i].getIdade();
        }
        
        return media/this.qtdAlunos;
    }

    public int getQtdMaioresDeIdade ()
    {
        int aluMaior = 0;
        for (int i = 0; i < qtdAlunos; i++){
            if (this.alunos[i].getIdade() >= 18) {
                aluMaior++;
            }
        }

        return aluMaior;
    }
}