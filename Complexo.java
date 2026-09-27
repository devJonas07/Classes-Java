public class Complexo implements Comparable<Complexo>{
    private double a, b;
    public Complexo(double a, double b)
    {
        this.a = a;
        this.b = b;
    }
    public Complexo maisQue(Complexo mais)
    {
        double maisA = this.a + mais.a;
        double maisB = this.b + mais.b;
        return new Complexo(maisA, maisB);
    }
    public Complexo menosQue(Complexo menos)
    {
        double menosA = this.a - menos.a;
        double menosB = this.b - menos.b;
        return new Complexo(menosA, menosB);
    }
    public Complexo vezesQue(Complexo vezes)
    {
        double vezesA = (this.a * vezes.a) - (this.b * vezes.b);
        double vezesB = (this.a * vezes.b) + (vezes.a * this.b);
        return new Complexo(vezesA, vezesB);
    }
    public Complexo divididoPor(Complexo dividido)
    {
        double divididoA = (this.a * dividido.a + this.b * dividido.b) / ((dividido.a * dividido.a) + (dividido.b * dividido.b));
        double divididoB = (dividido.a * this.b - this.a * dividido.b) / ((dividido.a * dividido.a) + (dividido.b * dividido.b));
        return new Complexo(divididoA, divididoB);
    }
    @Override 
    public String toString()
    {
        return (this.a + "+" + this.b);
    }
    @Override 
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Complexo c = (Complexo)obj;

        if (c.a != this.a) return false;
        if (c.b != this.b) return false;
        return true;
    }
    @Override 
    public int hashCode()
    {
        int retorno = 1;
        retorno = retorno * 2 + ((Double)this.a).hashCode();
        retorno = retorno * 2 + ((Double)this.b).hashCode();

        if (retorno < 0) retorno = -retorno;
        return retorno;
    }
    @Override 
    public int compareTo(Complexo outro)
    {
        if (this.a > outro.a) return 1;
        if (this.a < outro.a) return -1;
        if (this.b > outro.b) return 1;
        if (this.b < outro.b) return -1;

        return 0;
    }
}
