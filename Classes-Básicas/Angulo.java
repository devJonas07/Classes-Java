public class Angulo implements Comparable<Angulo>
{
    private double valorEmGraus;

    public Angulo (double valorEmGraus) throws Exception
    {
        if (valorEmGraus < 0 || valorEmGraus > 360){
            throw new Exception("Ângulo inválido!");
        }

        this.valorEmGraus = valorEmGraus;
    }
    public double getValorEmGraus ()
    {
        return this.valorEmGraus;
    }

    public double getValorEmGrados ()
    {
        return this.valorEmGraus * (10.0 / 9.0);
    }

    public double getValorEmRadianos ()
    {
        return this.valorEmGraus * (Math.PI / 180.0);
    }
    public void setValorEmGraus (double valorEmGraus) throws Exception
    {
        if (valorEmGraus < 0 || valorEmGraus > 360){
            throw new Exception("Ângulo inválido");
        }

        this.valorEmGraus = valorEmGraus;
    }

    public void setValorEmGrados (double valorEmGrados) throws Exception
    {
        double grausConvertidos = valorEmGrados * (9.0 / 10.0);

        if (grausConvertidos < 0 || grausConvertidos > 360) {
            throw new Exception("Angulo invalido");
        }

        this.valorEmGraus = grausConvertidos;
    }

    public void setValorEmRadianos (double valorEmRadianos) throws Exception
    {
        double radianosParaGraus = valorEmRadianos * (180.0 / Math.PI);
        if (radianosParaGraus < 0 || radianosParaGraus > 360) {
            throw new Exception("Ângulo inválido");
        }

        this.valorEmGraus = radianosParaGraus;
    }
    @Override 
    public String toString ()
    {
        return this.valorEmGraus + "°";
    }
    @Override 
    public boolean equals (Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Angulo v = (Angulo)obj;

        if (v.valorEmGraus != this.valorEmGraus) return false;
        return true;
    }
    @Override 
    public int hashCode()
    {
        int retorno = 1;
        retorno = retorno * 2 + ((Double)this.valorEmGraus).hashCode();

        if (retorno < 0) retorno = -retorno;
        return retorno;
    }
    @Override 
    public int compareTo (Angulo outro)
    {
        if (this.valorEmGraus > outro.valorEmGraus) return 1;
        if (this.valorEmGraus < outro.valorEmGraus) return -1;

        return 0;
    }
}