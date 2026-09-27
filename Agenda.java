public class Agenda {
    private String descricao;
    private byte horarioDeInicio;
    private byte horarioDoFim;
    private short duracaoEmMinutos;
    private int qtdMaximaCompromisso;

    public Agenda(String descricao, byte horarioDeInicio, short duracaoEmMinutos, int qtdMaximaCompromisso, byte horarioDoFim) throws Exception
    {
        if (descricao == null || descricao.equals("")){
            throw new Exception("Descrição inválida!");
        }
        if (qtdMaximaCompromisso <= 0){
            throw new Exception("Quantidade inválida!");
        }
        if (horarioDeInicio < 0 || horarioDeInicio > 23){
            throw new Exception("Horario inválido!");
        }
        if (horarioDoFim < 0 || horarioDoFim > 23){
            throw new Exception("Horario inválido!");
        }
        if (duracaoEmMinutos > 1440 || duracaoEmMinutos <= 0){
            throw new Exception("Duração inválida!");
        }
        this.descricao = descricao;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.horarioDeInicio = horarioDeInicio;
        this.horarioDoFim = horarioDoFim;
        this.descricao = descricao;
    }
    
}
