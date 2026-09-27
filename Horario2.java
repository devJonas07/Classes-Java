public class Horario2 implements Comparable<Horario2>
{
    private int horas, minutos, segundos;
    public Horario2 (int horas, int minutos, int segundos) throws Exception
    {
        if (horas < 0 || horas > 23){
            throw new Exception("Horas inválidas");
        }
        if (minutos < 0 || minutos > 59){
            throw new Exception("Minuto inválido");
        }
        if (segundos < 0 || segundos > 59){
            throw new Exception("Segundos inválidos");
        }

        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }
     public void setHora (int horas) throws Exception
     {
        if (horas < 0 || horas > 23){
            throw new Exception("Hora inválida");
        }

        this.horas = horas;
     }
     public void setMinutos (int minutos) throws Exception
     {
        if (minutos < 0 || minutos > 59){
            throw new Exception("Minuto inválido");
        }

        this.minutos = minutos;
     }
     public void setSegundos (int segundos) throws Exception
     {
        if (segundos < 0 || segundos > 59){
            throw new Exception("Segundo inválido");
        }

        this.segundos = segundos;
     }
     public int getHoras ()
     {
        return this.horas;
     }
     public int getMinutos ()
    {
        return this.minutos;
    }
    public int getSegundos ()
    {
        return this.segundos;
    }
    public Horario2 mais (Horario2 outro) throws Exception
    {
        int totalSegundos = (this.horas * 3600) + (this.minutos * 60) + this.segundos;
        int totalOutro = (outro.horas * 3600) + (outro.minutos * 60) + outro.segundos;

        totalSegundos += totalOutro;
        totalSegundos = totalSegundos % 86400;

        int novaHora = totalSegundos / 3600;
        int restoHora = totalSegundos % 3600;
        int novoMinuto = restoHora / 60;
        int novoSegundo = restoHora % 60;

        return new Horario2(novaHora, novoMinuto, novoSegundo);
        
    }
    public Horario2 menos (Horario2 outro) throws Exception
    {
        int totalSegundos = (this.horas * 3600) + (this.minutos * 60) + this.segundos;
        int totalOutro = (outro.horas * 3600) + (outro.minutos * 60) + outro.segundos;

        totalSegundos -= totalOutro;
        totalSegundos = totalSegundos % 86400;
        if (totalSegundos < 0){
            totalSegundos += 86400;
        }

        int novaHora = totalSegundos / 3600;
        int restoHora = totalSegundos % 3600;
        int novoMinuto = restoHora / 60;
        int novoSegundo = restoHora % 60;
        return new Horario2(novaHora, novoMinuto, novoSegundo);
    }
    @Override
    public String toString ()
    {
        return (this.horas < 10?"0":"") +
        this.horas + ":" + 
        (this.minutos < 10?"0":"") +
        this.minutos + ":" +
        (this.segundos < 10?"0":"") +
        this.segundos;
    }
    @Override 
    public boolean equals (Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        Horario2 h = (Horario2)obj;

        if (h.horas != this.horas) return false;
        if (h.minutos != this.minutos) return false;
        if (h.segundos != this.segundos) return false;
        return true;
    }
    @Override 
    public int hashCode()
    {
        int retorno = 1;
        retorno = retorno * 2 + ((Integer)this.horas).hashCode();
        retorno = retorno * 2 + ((Integer)this.minutos).hashCode();
        retorno = retorno * 2 + ((Integer)this.segundos).hashCode();

        if (retorno < 0) retorno = -retorno;
        return retorno;
    }
    @Override 
    public int compareTo(Horario2 hor)
    {
        if (this.horas < hor.horas) return -777;
        if (this.horas > hor.horas) return 777;
        if (this.minutos < hor.minutos) return -777;
        if (this.minutos > hor.minutos) return 777;
        if (this.segundos < hor.segundos) return -777;
        if (this.segundos > hor.segundos) return 777;

        return 0;
    }
}
