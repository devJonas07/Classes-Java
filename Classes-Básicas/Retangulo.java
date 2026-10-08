public class Retangulo implements Comparable<Retangulo>
{
  
    private double xInicial;
    private double yInicial;
    private double xFinal;
    private double yFinal;

    public Retangulo(double xInicial, double yInicial, double xFinal, double yFinal) throws Exception
    {
        if (xFinal <= xInicial || yFinal <= yInicial)
        {
            throw new Exception("Retângulo inválido!");
        }

        this.xInicial = xInicial;
        this.yInicial = yInicial;
        this.xFinal = xFinal;
        this.yFinal = yFinal;
    }

    public double getLargura()
    {
        return this.xFinal - this.xInicial;
    }

    public double getAltura()
    {
        return this.yFinal - this.yInicial;
    }

    public double getArea()
    {
        return this.getLargura() * this.getAltura();
    }

    public double getPerimetro()
    {
        return 2 * (this.getLargura() + this.getAltura());
    }

    public boolean contains(double x, double y)
    {
        if (x >= this.xInicial && x <= this.xFinal &&
            y >= this.yInicial && y <= this.yFinal)
        {
            return true;
        }

        return false;
    }
    @Override 
    public String toString()
    {
        return ("Área: " + this.getArea() + " - " + "Perímetro: " + this.getPerimetro() + " - " + "Altura: " + this.getAltura() + " - " + "Largura: " + this.getLargura());
    }
    @Override 
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Retangulo r = (Retangulo)obj;

        if (r.xFinal != this.xFinal) return false;
        if (r.xInicial != this.xInicial) return false;
        if (r.yFinal != this.yFinal) return false;
        if (r.yInicial != this.yInicial) return false;
        return true;
    }
    @Override 
    public int hashCode()
    {
        int retorno = 1;
        retorno = retorno * 2 + ((Double)this.xFinal).hashCode();
        retorno = retorno * 2 + ((Double)this.xInicial).hashCode();
        retorno = retorno * 2 + ((Double)this.yInicial).hashCode();
        retorno = retorno * 2 + ((Double)this.yFinal).hashCode();

        if (retorno < 0) retorno = -retorno;
        return retorno;
    }
    @Override 
    public int compareTo(Retangulo r2)
    {
        if (this.xFinal > r2.xFinal) return 1;
        if (this.xFinal < r2.xFinal) return -1;
        if (this.xInicial > r2.xInicial) return 1;
        if (this.xInicial < r2.xInicial) return -1;
        if (this.yFinal > r2.yFinal) return 1;
        if (this.yFinal < r2.yFinal) return -1;
        if (this.yInicial > r2.yInicial) return 1;
        if (this.yInicial < r2.yInicial) return -1;
        return 0;
    }
}