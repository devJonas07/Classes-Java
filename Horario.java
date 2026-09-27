import javax.xml.crypto.Data;

public class Horario implements Comparable <Horario>, Cloneable
{
    private byte hora, minuto, segundo;

    public /*void*/ Horario (byte hora, byte minuto, byte segundo) throws Exception
    {
        if (hora < 0 || hora > 23){
            throw new Exception("Hora inválida");
        }
        if (minuto < 0 || minuto > 59){
            throw new Exception("Minuto inválido");
        }
        if (segundo < 0 || segundo > 59){
            throw new Exception("Segundo inválido");
        }

        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public void setHora (byte hora) throws Exception
    {
        if (hora < 0 || hora > 23){
            throw new Exception("Hora inválida");
        }
        this.hora = hora;
    }

    public void setMinuto (byte minuto) throws Exception
    {
        if (minuto < 0 || minuto > 59){
            throw new Exception("Minuto inválido");
        }
        this.minuto = minuto;
    }

    public void setSegundo (byte segundo) throws Exception
    {
        if (segundo < 0 || segundo > 59){
            throw new Exception("Segundo inválido");
        }
        this.segundo = segundo;
    }

    public byte getHora ()
    {
        return this.hora;
    }

    public byte getMinuto ()
    {
        return this.minuto;
    }

    public byte getSegundo ()
    {
        return this.segundo;
    }

    public void adiante (int qtdSegundos) throws Exception
    {
        int totalSegundos = (this.hora * 3600) + (this.minuto * 60) + this.segundo;

        totalSegundos += qtdSegundos;
        totalSegundos = totalSegundos % 86400;

        int novaHora = totalSegundos / 3600;
        int restoHor = totalSegundos % 3600;
        int novoMinuto = restoHor / 60;
        int novoSegundo = restoHor % 60;

        this.hora = (byte)novaHora;
        this.minuto = (byte)novoMinuto;
        this.segundo = (byte)novoSegundo;
    }

    public void retroceda (int qtdSegundos) throws Exception
    {
        int totalSegundos = (this.hora * 3600) + (this.minuto * 60) + this.segundo;

        totalSegundos -= qtdSegundos;
        totalSegundos = totalSegundos % 86400;
        if (totalSegundos < 0) {
            totalSegundos += 86400;
        }

        int novaHora = totalSegundos / 3600;
        int restoHora = totalSegundos % 3600;
        int novoMinuto = restoHora / 60;
        int novoSegundo = restoHora % 60;

        this.hora = (byte)novaHora;
        this.minuto = (byte)novoMinuto;
        this.segundo = (byte)novoSegundo;

    }

    public Horario getHorarioFuturo (int qtdSegundos) throws Exception // nao altera o this
    {
        Horario horarioFuturo = new Horario(this.hora, this.minuto, this.segundo);
        horarioFuturo.adiante(qtdSegundos);
        return horarioFuturo;
    }

    public Horario getHorarioPassado (int qtdSegundos) throws Exception // nao altera o this
    {
        Horario horarioPassado = new Horario(this.hora, this.minuto, this.segundo);
        horarioPassado.retroceda(qtdSegundos);
        return horarioPassado;
    }

    @Override 
    public String toString(){
        return (this.hora < 10?"0":"") +
        this.hora + ":" + 
        (this.minuto < 10?"0":"") +
        this.minuto + ":" +
        (this.segundo < 10?"0":"") +
        this.segundo;
    }
    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Horario h = (Horario)obj;

        if (h.hora != this.hora) return false;
        if (h.minuto != this.minuto) return false;
        if (h.segundo != this.segundo) return false;
        return true;
    }

    @Override 
    public int hashCode(){
        int retorno = 1;

        retorno = retorno * 2 + ((Byte)this.hora).hashCode();
        retorno = retorno * 2 + ((Byte)this.minuto).hashCode();
        retorno = retorno * 2 + ((Byte)this.segundo).hashCode();

        if (retorno < 0) retorno = -retorno;
        return retorno;
    }

    @Override 
    public int compareTo(Horario hor){
        if (this.hora < hor.hora) return -777;
        if (this.hora > hor.hora) return 777;
        if (this.minuto < hor.minuto) return -777;
        if (this.minuto > hor.minuto) return 777;
        if (this.segundo < hor.segundo) return -777;
        if (this.segundo > hor.segundo) return 777;

        return 0;
    }

    public Horario(Horario constCopia)throws Exception{
        if (constCopia == null) throw new Exception("Modelo ausente!");

        this.hora = constCopia.hora;
        this.minuto = constCopia.minuto;
        this.segundo = constCopia.segundo;
    }
    
    @Override
    public Object clone ()
    {
        Horario Hora=null;

        try
        {
            Hora = new Horario (this);
        }
        catch (Exception erro)
        {}

        return Hora;
    }
}