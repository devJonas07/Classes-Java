public class Circulo implements Comparable<Circulo>
{
    private double x, y, raio; // coordenadas do centro + raio

    public Circulo (double x, double y, double raio) throws Exception
    {
        if (raio <= 0){
            throw new Exception("Raio inválido!");
        }

        this.raio = raio;
        this.x = x;
        this.y = y;
    }
    public double getComprimento (Angulo angulo)
    {
        return this.raio * angulo.getValorEmRadianos();
    }
    public double getArea (Angulo angulo)
    {
        return (Math.pow(this.raio, 2) * angulo.getValorEmRadianos()) / 2;
    }
    public void setCentro (double x, double y) throws Exception
    {
        this.x = x;
        this.y = y;
    }

    public void setRaio (double raio) throws Exception
    {
        if (raio <= 0){
            throw new Exception("Raio inválido");
        }
        this.raio = raio;
    }
    @Override
    public String toString()
    {
        return ("Centro: " + "X " + this.x + "-" + "Y " + this.y + "Raio: " + this.raio);
    }
    @Override 
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Circulo c = (Circulo)obj;

        if (c.raio != this.raio) return false;
        if (c.x != this.x) return false;
        if (c.y != this.y) return false;
        return true;
    }
    @Override
    public int hashCode()
    {
        int retorno = 1;
        retorno = retorno * 2 + ((Double)this.raio).hashCode();
        retorno = retorno * 2 + ((Double)this.x).hashCode();
        retorno = retorno * 2 + ((Double)this.y).hashCode();

        if (retorno < 0) retorno = -retorno;
        return retorno;
    }
    @Override
    public int compareTo (Circulo outro)
    {
        double areaThis = Math.PI * (this.raio * this.raio);
        double areaOutro = Math.PI * (outro.raio * outro.raio);

        if (areaThis > areaOutro) return 1;
        if (areaThis < areaOutro) return -1;
        return 0;
    }
}